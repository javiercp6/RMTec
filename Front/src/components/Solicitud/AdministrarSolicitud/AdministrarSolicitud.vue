<template>
  <div class="q-pa-md">
    <q-table
      title="Treats"
      dense
      :data="data"
      :columns="columns"
      row-key="name"
    >
        <template v-slot:body-cell-acciones="props">
        <q-td :props="props">
          <div>
              <div style="display: inline">
                <q-btn size="sm" color="green" round dense @click="cambiarEstado(props.row.solicitud.id, 'Aceptada')" icon="done" />
              </div>
              <div class="q-pl-xs" style="display: inline">
                <q-btn size="sm" color="red" round dense @click="cambiarEstado(props.row.solicitud.id, 'Denegada')" icon="clear" />
              </div>
          </div>
          <!-- <div class="my-table-details">
              <q-btn color="primary" icon="check" label="OK"  />
            {{ props.row.details }}
          </div> -->
        </q-td>
      </template>
    </q-table>
  </div>
</template>

<script>
import SolicitudService from '../../../Servicio/SolicitudService'
export default {
  data () {
    return {
      solicitudService: null,
      columns: [
        {
          name: 'solicitante',
          required: true,
          label: 'Solicitante',
          align: 'left',
          field: row => row.nombreUsuario,
          format: val => `${val}`,
          sortable: true
        },
        { name: 'usuario', label: 'Usuario', field: 'usuario', sortable: true },
        { name: 'marca',  label: 'Marca', field: row => row.solicitud.marca, sortable: true },
        { name: 'modelo', label: 'Modelo', field: row => row.solicitud.modelo },
        { name: 'noserie', label: 'No. Serie', field: row => row.solicitud.noserie },
        { name: 'macwifi', label: 'MAC WIFI', field: row => row.solicitud.macwifi },
        { name: 'maccable', label: 'MAC Cable', field: row => row.solicitud.maccable, sortable: true},
        { name: 'tipo', label: 'Tipo', field: row => row.solicitud.tipo, sortable: true},
        { name: 'fecha', label: 'Fecha', field: row => row.solicitud.fecha.split('T', 1)[0] },
        { name: 'acciones', label: 'Acciones' },
      ],
      data: [
        
        /* {
          name: 'Javier Ceballo Perez',
          usuario: 'javiercp',
          marca: 'HP',
          modelo: 'Pavilion G6',
          noserie: 'e453534',
          macwifi: 'D4 - D4 - D4 - 4D',
          maccable: 'D4 - D4 - D4 - 4D',
          tipo: 'Laptop',
          fecha: '2022/01/01',
        },
        {
          name: 'Lázaro Alcedo FIALLO',
          usuario: 'lazaroeaf',
          marca: 'HP',
          modelo: 'Psafsdf',
          noserie: 'g35ert4',
          macwifi: 'D4 - D4 - D4 - 4D',
          maccable: 'D4 - D4 - D4 - 4D',
          tipo: 'Laptop',
          fecha: '2022/01/01'
        },
        {
          name: 'Javier Ceballo Perez',
          usuario: 'javiercp',
          marca: 'HP',
          modelo: 'Pavilion G6',
          noserie: 'e453534',
          macwifi: 'D4 - D4 - D4 - 4D',
          maccable: 'D4 - D4 - D4 - 4D',
          tipo: 'Laptop',
          fecha: '2022/01/01'
        },
        {
          name: 'Javier Ceballo Perez',
          usuario: 'javiercp',
          marca: 'HP',
          modelo: 'Pavilion G6',
          noserie: 'e453534',
          macwifi: 'D4 - D4 - D4 - 4D',
          maccable: 'D4 - D4 - D4 - 4D',
          tipo: 'Laptop',
          fecha: '2022/01/01'
        },
        {
          name: 'Javier Ceballo Perez',
          usuario: 'javiercp',
          marca: 'HP',
          modelo: 'Pavilion G6',
          noserie: 'e453534',
          macwifi: 'D4 - D4 - D4 - 4D',
          maccable: 'D4 - D4 - D4 - 4D',
          tipo: 'Laptop',
          fecha: '2022/01/01'
        },
        {
          name: 'Javier Ceballo Perez',
          usuario: 'javiercp',
          marca: 'HP',
          modelo: 'Pavilion G6',
          noserie: 'e453534',
          macwifi: 'D4 - D4 - D4 - 4D',
          maccable: 'D4 - D4 - D4 - 4D',
          tipo: 'Laptop',
          fecha: '2022/01/01'
        },
        {
          name: 'Javier Ceballo Perez',
          usuario: 'javiercp',
          marca: 'HP',
          modelo: 'Pavilion G6',
          noserie: 'e453534',
          macwifi: 'D4 - D4 - D4 - 4D',
          maccable: 'D4 - D4 - D4 - 4D',
          tipo: 'Laptop',
          fecha: '2022/01/01'
        },
        {
          name: 'Javier Ceballo Perez',
          usuario: 'javiercp',
          marca: 'HP',
          modelo: 'Pavilion G6',
          noserie: 'e453534',
          macwifi: 'D4 - D4 - D4 - 4D',
          maccable: 'D4 - D4 - D4 - 4D',
          tipo: 'Laptop',
          fecha: '2022/01/01'
        },
        {
          name: 'Javier Ceballo Perez',
          usuario: 'javiercp',
          marca: 'HP',
          modelo: 'Pavilion G6',
          noserie: 'e453534',
          macwifi: 'D4 - D4 - D4 - 4D',
          maccable: 'D4 - D4 - D4 - 4D',
          tipo: 'Laptop',
          fecha: '2022/01/01'
        },
        {
          name: 'Javier Ceballo Perez',
          usuario: 'javiercp',
          marca: 'HP',
          modelo: 'Pavilion G6',
          noserie: 'e453534',
          macwifi: 'D4 - D4 - D4 - 4D',
          maccable: 'D4 - D4 - D4 - 4D',
          tipo: 'Laptop',
          fecha: '2022/01/01'
        } */
      ]

      
    }
    
  },
  created(){
    this.solicitudService = new SolicitudService();
  },
  mounted(){
    this.listar()
  },

  methods: {
         listar(){
           console.log("listar")
             this.solicitudService.listaCompletaEnviada().then(response =>{
                console.log(response.data)
                this.data = response.data
                 
             })
            .catch(error => {
                    console.log(error, "Hay un errrrrrrrrrrrrrorrrrrrrrrrrrrrrr")
                    this.errored = true
              })
            .finally(() => this.loading = false);
         },

         cambiarEstado(idUsuario, estado){
           console.log("cambiar estado")
             this.solicitudService.cambiarEstado(idUsuario, estado).then(response =>{
                console.log(response.data)
                if (response.data.estado === 'Aceptada') {
                  console.log("Aceptada")
                  this.eliminarDenuncia(response.data.idSolicitud)
                  this.$q.notify({
                        color: 'green-4',
                        textColor: 'white',
                        icon: 'cloud_done',
                        message: 'Solicitud Aceptada'
                        })
                } else {
                  this.eliminarDenuncia(response.data.idSolicitud)
                  this.$q.notify({
                        color: 'green-4',
                        textColor: 'white',
                        icon: 'cloud_done',
                        message: 'Solicitud Denegada'
                        })
                }              
             })
            .catch(error => {
                    console.log(error, "Hay un errrrrrrrrrrrrrorrrrrrrrrrrrrrrr")
                    this.errored = true
              })
            .finally(() => this.loading = false);
         },

         eliminarDenunciaa(id){
           for (const i of this.data) {
             conslole.log(i)
             if (this.data[i].solicitud.id === id) {
               this.data.splice(i, 1)
             }
           }
         },

         eliminarDenuncia(id){
           for (let i = 0; i < this.data.length; i++) {
             const element = this.data[i];
             if (element.solicitud.id == id) {
               this.data.splice(i, 1)
             }
           }
         },

         reset(){
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
         },
     }
}
</script>

<style>

</style>