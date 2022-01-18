<template>
  <q-card style="min-width: 350px">
    <q-card-section class="row items-center">
        <span class="q-ml-sm">{{this.eliminartodas ? 'Estas seguro(a) que deseas eliminar todas las solicitudes' : 'Estas seguro(a) que deseas eliminar la solicitud'}}</span>
    </q-card-section>

    <q-card-section>    
        <q-card-actions align="right">
            <q-btn flat label="Cancelar" color="primary" v-close-popup />
            <q-btn type="submit" label="Si, eliminar" @click="eliminarSolicitud" color="primary" />
        </q-card-actions>
    </q-card-section>
    </q-card>
</template>

<script>
import SolicitudService from '../../Servicio/SolicitudService'

export default {

    props:{
        idsolicitud: {
            type: Number,
            default: null
        },
        eliminartodas: {
            type: Boolean,
            default: null
        }
    },


    created(){
         this.solicitudService = new SolicitudService();
    },
    methods: {
        eliminarSolicitud(){
            if (this.eliminartodas) {
                this.eliminarTodasSolicitud()
            } else {
                this.eliminarSolicitudPorId()
            }
        },

        eliminarSolicitudPorId(){
            this.solicitudService.eliminarPorId(this.idsolicitud)
                    .then(response => {
                        console.log(response)
                        console.log(response.data)  
                         this.$emit('cerrar')
                         this.$q.notify({
                                        color: 'green-4',
                                        textColor: 'white',
                                        icon: 'cloud_done',
                                        message: 'Solicitud eliminada'
                                 })
                        })
                        .catch(error => {
                        console.log(error, "Hay un errrrrrrrrrrrrrorrrrrrrrrrrrrrrr")
                        })
                        .finally()
        },

        eliminarTodasSolicitud(){
            this.solicitudService.eliminar()
                    .then(response => {
                        console.log(response)
                        console.log(response.data)  
                         this.$emit('cerrar')
                         this.$q.notify({
                                        color: 'green-4',
                                        textColor: 'white',
                                        icon: 'cloud_done',
                                        message: 'Se han eliminado todas las solicitudes'
                                 })
                        })
                        .catch(error => {
                        console.log(error, "Hay un errrrrrrrrrrrrrorrrrrrrrrrrrrrrr")
                        })
                        .finally()
        },
    }

}
</script>

<style>

</style>