<template>
  <q-page padding>
    
    <template v-if="loading">
      <span class="absolute-center">
        <q-spinner
          color="primary"
          size="3em"
        />
      </span>
    </template>
    <template v-else>
      <div class="q-pa-sm">
          <div class="q-gutter-lg">
            <q-btn unelevated color="primary" rounded icon="add" label="Crear Solicitud" @click="modadd = true" />
            <q-btn unelevated outline color="primary" rounded icon="delete_sweep" @click="modelimtod = true">
              <q-tooltip>Eliminar Todas</q-tooltip> 
            </q-btn>
          </div>

        <q-dialog v-model="modadd" persistent>
                <FormSolicitud
                :solicitud="
                  {
                    id: null,
                    marca: null,
                    modelo: null,
                    noserie: null,
                    macwifi: null,
                    maccable: null,
                    tipo: 'Laptop',
                    estado: 'Enviada',
                    fecha: new Date
                  }
                "
                :crear="true"
                @creado="solicitudes.push($event), reset()"
                @cerrar="reset"
                />
        </q-dialog>
        <q-dialog v-model="modmodif" persistent>
                <FormSolicitud
                :solicitud="
                  {
                    id: solicitud.id,
                    marca: solicitud.marca,
                    modelo: solicitud.modelo,
                    noserie: solicitud.noserie,
                    macwifi: solicitud.macwifi,
                    maccable: solicitud.maccable,
                    tipo: solicitud.tipo,
                    estado: 'Enviada',
                    fecha: new Date
                  }
                "
                @modificado="modificarSolicitud($event), reset()"
                @cerrar="reset"
                />
        </q-dialog>
        <q-dialog v-model="modmelim" persistent>
                <EliminarSolicitud
                @eliminado="eliminarSolicitud($event)"
                :idsolicitud="solicitud.id"
                @cerrar="reset"/>
        </q-dialog>
        <q-dialog v-model="modelimtod" persistent>
                <EliminarSolicitud
                :eliminartodas="true"
                @cerrar="reset"/>
        </q-dialog>
      </div>
    
      <div class="fit row wrap justify-start items-start content-start" padding >
        <q-card bordered class="my-card" v-for="solict in solicitudes" :key="solict.id">
            <q-card-section class="card-section">
              <div class="row">
                <div class="row">
                  <div class="text-subtitle2">Solicitud
                    <q-badge align="top" :color="solict.estado === 'Enviada' ? 'amber-8' : '' || solict.estado === 'Denegada' ? 'red' : '' || solict.estado === 'Aceptada' ? 'green' : '' " style="font-size: 9px">{{solict.estado}}</q-badge>
                  </div>
                </div> 
                <q-space />
                <q-icon
                  size= 18px
                  name="file_upload"
                  class="icon-btn"
                  @click="exportarSolicitud"
                  >
                  <q-tooltip>Exportar</q-tooltip>
                </q-icon>
                <q-icon
                  size= 18px
                  name="edit"
                  class="icon-btn"
                  @click="solicitud = solict, modmodif = true "
                   
                >
                  <q-tooltip>Modificar</q-tooltip>
                </q-icon>
                <q-icon
                  size= 18px
                  name="clear"
                  class="icon-btn"
                  @click="modmelim = true, solicitud.id = solict.id"
                >
                  <q-tooltip>Eliminar</q-tooltip>
                </q-icon>            
              </div>
              
            </q-card-section>

            <q-separator inset />

            <q-card-section class="card-section">
                    <q-card-section style="padding: 5px">
                      <div class="q-pa-xs flex">
                        <div class="">Marca:</div>
                        <div class="q-item__label--caption q-pl-sm">{{solict.marca}}</div>
                      </div>
                      <div class="q-pa-xs flex">
                        <div class="">Modelo:</div>
                        <div class="q-item__label--caption q-pl-sm">{{solict.modelo}}</div>
                      </div>
                      <div class="q-pa-xs flex">
                        <div class="">Nro Serie:</div>
                        <div class="q-item__label--caption q-pl-sm">{{solict.noserie}}</div>
                      </div>
                      <div class="q-pa-xs flex">
                        <div class="">MAC wifi:</div>
                        <div class="q-item__label--caption q-pl-sm">{{solict.macwifi}}</div>
                      </div>
                      <div class="q-pa-xs flex">
                        <div class="">MAC Eternet:</div>
                        <div class="q-item__label--caption q-pl-sm">{{solict.maccable}}</div>
                      </div>
                      <div class="q-pa-xs flex">
                        <div class="">Tipo:</div>
                        <div class="q-item__label--caption q-pl-sm">{{solict.tipo}}</div>
                      </div>
                      <div class="q-pa-xs flex">
                        <div class="">Fecha:</div>
                        <div class="q-item__label--caption q-pl-sm">{{ solict.fecha }}</div>
                        <!-- .split('T', 1)[0] -->
                        <!-- solicitud = solict, modmodif = true -->
                      </div>
                    </q-card-section> 
            </q-card-section>
           <!--  <q-card-section class="card-section">
                    <q-card-section style="padding: 5px">
                      <div class="q-pa-xs flex">
                        <div class="">Marca</div>
                        <div class="q-item__label--caption text-caption">{{solict.marca}}</div>
                      </div>
                      <div class="q-pa-xs">
                        <div class="q-item__label">Modelo</div>
                        <div class="q-item__label q-item__label--caption text-caption">{{solict.modelo}}</div>
                      </div>
                      <div class="q-pa-xs">
                        <div class="q-item__label">Nro Serie</div>
                        <div class="q-item__label q-item__label--caption text-caption">{{solict.noserie}}</div>
                      </div>
                      <div class="q-pa-xs">
                        <div class="q-item__label">MAC wifi</div>
                        <div class="q-item__label q-item__label--caption text-caption">{{solict.macwifi}}</div>
                      </div>
                      <div class="q-pa-xs">
                        <div class="q-item__label">MAC Eternet</div>
                        <div class="q-item__label q-item__label--caption text-caption">{{solict.maccable}}</div>
                      </div>
                      <div class="q-pa-xs">
                        <div class="q-item__label">Tipo</div>
                        <div class="q-item__label q-item__label--caption text-caption">{{solict.tipo}}</div>
                      </div>
                      <div class="q-pa-xs">
                        <div class="q-item__label">Fecha</div>
                        <div class="q-item__label q-item__label--caption text-caption">{{solict.fecha}}</div>
                      </div>
                    </q-card-section>
            </q-card-section> -->
        </q-card>
      </div>
    </template>
  </q-page>
</template>

<script>
import UsuarioService from '../../Servicio/UsuarioService'
import FormSolicitud from './FormSolicitud.vue'
import EliminarSolicitud from './EliminarSolicitud.vue'
import jwt_decode from 'jwt-decode'
import jsPDF from 'jspdf'
//import VueHtml2pdf from '../Solicitud/AdministrarSolicitud/CustodioSolicitud/Generatepdf.vue'
import VueHtml2pdf from 'vue-html2pdf'

export default {
    components : {
        EliminarSolicitud,
        FormSolicitud,
        //VueHtml2pdf
        //CalcNivel
      },

    data () {
      return {
        solicitudes: [],
        solicitud:{ 
                id: null,
                marca: null,
                modelo: null,
                noserie: null,
                macwifi: null,
                maccable: null,
                tipo: "Laptop",
                estado: "Enviada",
                fecha: new Date
               },
        loading: true,
        modmelim: false,
        modadd: false,
        modmodif: false,
        modelimtod: false,
        modmcalnivel: false,
        usuarioService: null,
        
      }
    },
    computed: {

    },
    
     created(){
       this.usuarioService = new UsuarioService();
     },
     mounted(){
      
      this.listar()
      const decoded = jwt_decode(localStorage.getItem("token"))

     },
     methods: {

          
          
         listar(){
           console.log("listar")
           console.log(jwt_decode(localStorage.getItem("token")).sub)
             this.usuarioService.obtenerPorUserName(jwt_decode(localStorage.getItem("token")).sub).then(response =>{
                console.log(response.data)
                console.log("data del usuario")
                this.solicitudes = response.data
                 
             })
            .catch(error => {
                    console.log(error, "Hay un errrrrrrrrrrrrrorrrrrrrrrrrrrrrr")
                    this.errored = true
              })
            .finally(() => this.loading = false);
         },
        /*  reset(){
           this.modmelim = false
           this.modadd = false,
           this.modmodif = false,
           this.modelimtod = false,           
          this.solicitud.id = null,
          this.solicitud.marca = null,
          this.solicitud.modelo = null,
          this.solicitud.noserie = null,
          this.solicitud.macwifi = null,
          this.solicitud.maccable = null,
          this.solicitud.tipo = "Laptop",
          this.solicitud.estado = "Enviada",
          this.solicitud.fecha = new Date
          
           this.listar()
           console.log("reset")
         }, */

         reset(){
           this.modmelim = false
           this.modadd = false,
           this.modmodif = false,
           this.modelimtod = false,           
          /* this.solicitud.id = null,
          this.solicitud.marca = null,
          this.solicitud.modelo = null,
          this.solicitud.noserie = null,
          this.solicitud.macwifi = null,
          this.solicitud.maccable = null,
          this.solicitud.tipo = "Laptop",
          this.solicitud.estado = "Enviada",
          this.solicitud.fecha = new Date */
           console.log("reset")     

         },

         modificarSolicitud(solicitud){
           for (let i = 0; i < this.solicitudes.length; i++) {
             const element = this.solicitudes[i];
             if (element.id == solicitud.id) {
               this.solicitudes.splice(i, 1, solicitud)
             }
           }
           console.log("modificado")
           console.log(solicitud)
         },

         eliminarSolicitud(id){
           for (let i = 0; i < this.solicitudes.length; i++) {
             const element = this.solicitudes[i];
             if (element.id == id) {
               this.solicitudes.splice(i, 1)
             }
           }
         },

         exportarSolicitud(){
           
           const pdf = new jsPDF( {
             orientation: "portrait",
             
             format: "letter"
           })
           const columns = [
            {title: "Title", dataKey: "title"},
            {title: "Description", dataKey: "description"}
          ];
           const body = [
              {title: 'todo 1', description: 'description 1'},
              {title: 'todo 2', description: 'description2'},
              {title: 'todo 3', description: 'description 3'},
              {title: 'todo 4', description: 'description 4'},
              {title: 'todo 5', description: 'description 5'}
            ]
           /*    */
            
            
            /* pdf.autoTable({
              columns,
              body,  
              margin: {top: 60}
           }) */
           pdf.setFontSize(20)
           pdf.text(10, 15, 'Registro de medio tecnológico')
           pdf.save('solicitud.pdf')
         }
     }
}
</script>

<style lang="sass" scoped>
.my-card
  margin: 5px
  width: 100%
  @media (min-width: 480px)  
    max-width: 250px
  
.card-section
  padding: 10px

.icon-btn
  cursor: pointer
  padding-left: 12px

.btnn
  font-size: 12px

</style>