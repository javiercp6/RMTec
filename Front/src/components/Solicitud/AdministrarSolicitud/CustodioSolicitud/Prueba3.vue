<template>
  <div>
    <div id="content_barcode">
      <div ref="quagga" id="camere-block" />
      <span v-if="!this.hasCamera"
        >Cámara no oencontrada</span
      >
    </div>
  </div>
</template>

<script>
import Quagga from "quagga";

export default {
  components: {},
  data() {
    return {
      hasCamera: true,
    };
  },
  async mounted() {
    let data = await this.checkDevice();
    if (data) {
      this.initQuagga();
    } else {
      this.hasCamera = false;
    }
  },
  methods: {
    async checkDevice() {
      let md = navigator.mediaDevices;
      if (!md || !md.enumerateDevices) return false;
      const devices = await navigator.mediaDevices.enumerateDevices();
      console.log(devices);
      return devices.some((device) => "videoinput" === device.kind);
    },
    initQuagga() {
      Quagga.init(
        {
          inputStream: {
            name: "Live",
            type: "LiveStream",
            target: this.$refs.quagga,
            constraints: {
              width: { max: 480 },
              height: { max: 320 },
              deviceId: 0,
              facingMode: "environment",
            },
            area: {
              // defines rectangle of the detection/localization area
              top: "0%", // top offset
              right: "0%", // right offset
              left: "0%", // left offset
              bottom: "0%", // bottom offset
            },
          },
          debug: true,
          locator: {
            halfSample: true,
            patchSize: "medium", // x-small, small, medium, large, x-large
          },

          locate: true,

          decoder: {
            readers: [
              "code_128_reader",
              "ean_reader",
              "ean_8_reader",
              "code_39_reader",
              "code_39_vin_reader",
              "codabar_reader",
              "upc_reader",
              "upc_e_reader",
              "i2of5_reader",
            ],
          },
        },
        () => this.start()
      );
    },
    start() {
      Quagga.start();
      Quagga.onProcessed(function (result) {
        var drawingCtx = Quagga.canvas.ctx.overlay,
          drawingCanvas = Quagga.canvas.dom.overlay;

        if (result) {
          if (result.boxes) {
            drawingCtx.clearRect(
              0,
              0,
              parseInt(drawingCanvas.getAttribute("width")),
              parseInt(drawingCanvas.getAttribute("height"))
            );
            result.boxes
              .filter(function (box) {
                return box !== result.box;
              })
              .forEach(function (box) {
                Quagga.ImageDebug.drawPath(box, { x: 0, y: 1 }, drawingCtx, {
                  color: "green",
                  lineWidth: 2,
                });
              });
          }

          if (result.box) {
            Quagga.ImageDebug.drawPath(result.box, { x: 0, y: 1 }, drawingCtx, {
              color: "#00F",
              lineWidth: 2,
            });
          }

          if (result.codeResult && result.codeResult.code) {
            Quagga.ImageDebug.drawPath(
              result.line,
              { x: "x", y: "y" },
              drawingCtx,
              { color: "red", lineWidth: 3 }
            );
          }
        }
      });
      let video = document.querySelector(
        "#camere-block.viewport canvas, video"
      );
      console.log("video", video);
      Quagga.onDetected(this.onDetected);
    },
    onDetected(data) {
      let barCodeData = data.codeResult.code;
      // this.$store.dispatch("navigator/PUSH_PAGE", {
      //   name: "search",
      //   barCodeData,
      // });
      console.log("data", data);
      console.log("barcodeData", barCodeData);
    },
    beforeDestroy() {
      Quagga.stop();
    },
  },
};
</script>

<style>
#content_barcode {
  position: relative;
  display: block;
}
#camere-block {
  max-width: 320px;
  height: 100%;
}
#camere-block.viewport canvas,
video {
  width: 100%;
  height: 100%;
  position: absolute;
  top: 0;
  left: 0;
}

#camere-block.viewport canvas.drawingBuffer,
video.drawingBuffer {
  width: 480px;
  height: 320px;
}
</style>
