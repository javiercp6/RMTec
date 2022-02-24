<template>
  <q-page padding>
      <q-dialog v-model="modalescaner" persistent>
                <Escaner
                
                />
       </q-dialog>
      <!-- <Escaner
      
      /> -->
      <button @click="modalescaner = true"></button>
  </q-page>
</template>

<script>
//@barcode="solicitudes.push($event)"
import Escaner from '../CustodioSolicitud/Prueba3.vue'


export default {
    data () {
        return {
            modalescaner: false
        }
    },

    components: {
        Escaner
    },

    methods: {
    }
}

</script>

<style>

</style>