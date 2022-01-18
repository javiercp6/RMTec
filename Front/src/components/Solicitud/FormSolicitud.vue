<template>
  <q-card style="min-width: 350px">           
        <q-card-section> 
            <q-form
            @submit.prevent="onSubmit"
            class="q-gutter-md"
            >
                <div class="title row">
                    <div class="text-h5 text-center col-12">{{crear ? 'Crear Solicitud' : 'Modificar Dolicitud'}}</div>
                </div> 
                <q-input
                v-model="solicit.marca"
                label="Marca"
                dense
                hint="Escriba la marca del medio tecnológico"
                lazy-rules
                :rules="[ val => val && val.length > 0 || 'Este campo no puede enviarse vacio']"
                />
                <q-input
                v-model="solicit.modelo"
                dense
                label="Modelo"
                hint="Escriba el modelo del medio tecnológico"
                lazy-rules
                :rules="[ val => val && val.length > 0 || 'Este campo no puede enviarse vacio']"
                />
                <q-input
                v-model="solicit.noserie"
                dense
                label="No. Serie"
                hint="Escriba el número de serie del medio tecnológico"
                lazy-rules
                :rules="[ val => val && val.length > 0 || 'Este campo no puede enviarse vacio']"
                />
                <q-input
                v-model="solicit.macwifi"
                dense
                label="MAC WIFI"
                mask="XX - XX - XX - XX"
                hint="Escriba el número de serie del medio tecnológico"
                lazy-rules
                :rules="[ val => val && val.length > 0 || 'Este campo no puede enviarse vacio', val => val && val.length === 17 || 'La direccion MAC debe contar con 8 cacarteres']"
                />
                <q-input
                v-model="solicit.maccable"
                dense
                label="MAC Cable"
                mask="XX - XX - XX - XX"
                hint="Escriba el número de serie del medio tecnológico"
                lazy-rules
                :rules="[ val => val && val.length > 0 || 'Este campo no puede enviarse vacio', val => val && val.length === 17 || 'La direccion MAC debe contar con 8 cacarteres']"
                />
                <div class="q-gutter-md">
                    <q-radio size="sm" dense v-model="solicit.tipo" val="Laptop" label="Laptop" />
                    <q-radio size="sm" dense v-model="solicit.tipo" val="Table" label="Table" />
                    <q-radio size="sm" dense v-model="solicit.tipo" val="PC de Escritorio" label="PC de Escritorio" />
                </div>
                <q-card-actions align="right" class="text-primary">
                    <q-btn flat rounded label="Cancelar" @click="Reset()"/>
                    <q-btn label="Aceptar" rounded type="submit" color="primary"/>
                </q-card-actions>
            </q-form>
        </q-card-section>          
    </q-card>
</template>

<script>
//import TrabajadorService from '../../Service/TrabajadorService'
import SolicitudService from '../../Servicio/SolicitudService'

export default {
    data() {
        return {
            solicit: this.solicitud
        }
    },
 
    props: {
        solicitud: {
            type: Object,
            default: null
        },
        crear: {
            type: Boolean,
            default: false
        }
    },

    created(){
        this.solicitudService = new SolicitudService();
    },
    mounted(){

     },
    methods: {
        Reset(){
           // this.$emit('update:prompt', false ) 
            //this.cancelarDenuncia() 
            console.log("cerrar")
            this.$emit('cerrar')
        },
       
        onSubmit() {
            if (this.crear === true) {
                this.CrearSolicitud()
            } else {
                this.ModificarSolicitud()
            }
        },

        ModificarSolicitud(){ 
            this.solicitudService.modificar(this.solicitud)
               .then(response => {
                   console.log("add trab")
                    console.log(response)
                    console.log(response.data)
                    this.$q.notify({
                        color: 'green-4',
                        textColor: 'white',
                        icon: 'cloud_done',
                        message: 'Solicitud Modificada'
                        })
                    this.$emit('cerrar')
                     
                })
                .catch(error => {
                    console.log(error, "error , error , error")
                    //this.errored = true
                })
                .finally()            
        },

        CrearSolicitud(){
            this.solicitudService.salvarSolicitud(this.solicitud)
               .then(response => {
                   console.log("add trab")
                    console.log(response)
                    console.log(response.data)
                    this.$q.notify({
                        color: 'green-4',
                        textColor: 'white',
                        icon: 'cloud_done',
                        message: 'Solicitud Enviada'
                        })
                    this.$emit('cerrar')
                     
                })
                .catch(error => {
                    console.log(error, "error , error , error")
                    //this.errored = true
                })
                .finally() 
        }

        
    },

}
</script>

<style>

</style>