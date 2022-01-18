<template>
  <q-page padding>
      <q-btn color="primary" icon="check" label="OK" @click="escaner" />
  </q-page>
</template>

<script>

export default {

    data(){
        return{

        }
    },
    methods: {
        escaner(){
            cordova.plugins.barcodeScaner.scan(function (result){console.log(result.text)}, function (error){console.log(error)})
        }
    }
}
</script>

<style>

</style>