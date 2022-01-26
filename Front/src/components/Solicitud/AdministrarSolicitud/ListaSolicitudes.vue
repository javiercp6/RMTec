<template>
  <div class="q-pa-md">
    <q-table
      title="Treats"
      dense
      :data="data"
      :columns="columns"
      row-key="name"
    >
        
      <template v-slot:body-cell-marca="props">
        <q-td :props="props">
          <div v-for="(solict, index) in props.row.solicitudes" :key="index">
              <p>{{solict.marca}}</p>
          </div>
        </q-td>
      </template>
      <template v-slot:body-cell-modelo="props">
        <q-td :props="props">
          <div v-for="(solict, index) in props.row.solicitudes" :key="index">
              <p>{{solict.modelo}}</p>
          </div>
        </q-td>
      </template>
      <template v-slot:body-cell-noserie="props">
        <q-td :props="props">
          <div v-for="(solict, index) in props.row.solicitudes" :key="index">
              <p>{{solict.noserie}}</p>
          </div>
        </q-td>
      </template>
      <template v-slot:body-cell-macwifi="props">
        <q-td :props="props">
          <div v-for="(solict, index) in props.row.solicitudes" :key="index">
              <p>{{solict.macwifi}}</p>
          </div>
        </q-td>
      </template>
      <template v-slot:body-cell-maccable="props">
        <q-td :props="props">
          <div v-for="(solict, index) in props.row.solicitudes" :key="index">
              <p>{{solict.maccable}}</p>
          </div>
        </q-td>
      </template>
      <template v-slot:body-cell-tipo="props">
        <q-td :props="props">
          <div v-for="(solict, index) in props.row.solicitudes" :key="index">
              <p>{{solict.tipo}}</p>
          </div>
        </q-td>
      </template>
      <template v-slot:body-cell-fecha="props">
        <q-td :props="props">
          <div v-for="(solict, index) in props.row.solicitudes" :key="index">
              <p>{{ solict.fecha.split('T', 1)[0] }}</p>
          </div>
        </q-td>
      </template>
      <template v-slot:body-cell-estado="props">
        <q-td :props="props">
          <div v-for="(solict, index) in props.row.solicitudes" :key="index">
              <p>{{solict.estado}}</p>
          </div>
        </q-td>
      </template>
      

    </q-table>
  </div>
</template>

<script>
import UsuarioService from '../../../Servicio/UsuarioService'
export default {
  data () {
    return {
      usuarioService: null,
      columns: [
        {
          name: 'solicitante',
          required: true,
          label: 'Solicitante',
          align: 'left',
          field: row => row.nombre,
          format: val => `${val}`,
          sortable: true
        },
        { name: 'usuario', label: 'Usuario', field: row => row.username, sortable: true },
        { name: 'marca',  label: 'Marca', field: row => row.solicituddes.marca, sortable: true },
        { name: 'modelo', label: 'Modelo' },
        { name: 'noserie', label: 'No. Serie' },
        { name: 'macwifi', label: 'MAC WIFI'},
        { name: 'maccable', label: 'MAC Cable'},
        { name: 'tipo', label: 'Tipo',},
        { name: 'fecha', label: 'Fecha', },
        { name: 'estado', label: 'Estado' },
      ],
      data: [ ]

      
    }
    
  },
  created(){
    this.usuarioService = new UsuarioService();
  },
  mounted(){
    this.listar()
  },

  methods: {
         listar(){
           console.log("listar")
             this.usuarioService.listaPorSolicitud().then(response =>{
                console.log(response.data)
                this.data = response.data
                 
             })
            .catch(error => {
                    console.log(error, "Hay un errrrrrrrrrrrrrorrrrrrrrrrrrrrrr")
                    this.errored = true
              })
            .finally(() => this.loading = false);
         },


     }
}
</script>

<style>

</style>