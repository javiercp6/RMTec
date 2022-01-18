<template>
  <div class="q-pa-md">
    <q-table
      title="Solicitudes"
      :data="data"
      :columns="columns"
      :filter="filter"
      row-key="name"
    >

    <template v-slot:top>
        <div style="font-size: 30px">Solicitudes</div>
        <q-space />
        <q-input borderless dense debounce="300" color="primary" v-model="filter">
          <template v-slot:append>
            <q-icon name="search" />
          </template>
        </q-input>
      </template>


    <template v-slot:header="props">
        <q-tr :props="props">
          <q-th auto-width />
          <q-th
            v-for="col in props.cols"
            :key="col.name"
            :props="props"
          >
            {{ col.label }}
          </q-th>
        </q-tr>
      </template>

    <template v-slot:body="props">
        <q-tr :props="props">
          <q-td auto-width>
            <q-btn size="sm" color="green" round dense @click="props.expand = !props.expand" icon="done" />
            <q-btn size="sm" color="red" round dense @click="props.expand = !props.expand" icon="clear" />
          </q-td>
          
          <q-td
            v-for="col in props.cols"
            :key="col.name"
            :props="props"
          >
            {{ col.value }}
          </q-td>
        </q-tr>
        <q-tr v-show="props.expand" :props="props">
          <q-td colspan="100%">
            <div class="text-left">This is expand slot for row above: {{ props.row.name }}.</div>
          </q-td>
        </q-tr>
      </template>

      </q-table>

  </div>
  
</template>

<script>
export default {
  data () {
    return {
      filter: '',
      columns: [
        {
          name: 'solicitante',
          required: true,
          label: 'Solicitante',
          align: 'left',
          field: row => row.name,
          format: val => `${val}`,
          sortable: true
        },
        { name: 'Usuario', align: 'center', label: 'usuario', field: 'calories', sortable: true },
        { name: 'marca', label: 'Marca', field: 'fat', sortable: true },
        { name: 'modelo', label: 'Modelo', field: 'carbs' },
        { name: 'noserie', label: 'No. Serie', field: 'protein' },
        { name: 'macwifi', label: 'MAC WIFI', field: 'sodium' },
        { name: 'maccable', label: 'MAC Cable', field: 'calcium', sortable: true, sort: (a, b) => parseInt(a, 10) - parseInt(b, 10) },
        { name: 'tipo', label: 'Tipo', field: 'iron', sortable: true, sort: (a, b) => parseInt(a, 10) - parseInt(b, 10) }
      ],
      data: [
        {
          name: 'Javier Ceballo Perez',
          calories: 'javiercp',
          fat: 'HP',
          carbs: 'Pavilion G6',
          protein: 'e453534',
          sodium: 'D4 - D4 - D4 - 4D',
          calcium: 'D4 - D4 - D4 - 4D',
          iron: 'Laptop'
        },
        {
          name: 'Lázaro Alcedo FIALLO',
          calories: 'lazaroeaf',
          fat: 'HP',
          carbs: 'Psafsdf',
          protein: 'g35ert4',
          sodium: 'D4 - D4 - D4 - 4D',
          calcium: 'D4 - D4 - D4 - 4D',
          iron: 'Laptop'
        },
        {
          name: 'Daniel Parejo ',
          calories: 'ricsdf',
          fat: 'Lenovo',
          carbs: 'Psafsdf',
          protein: 'g35ert4',
          sodium: 'D4 - D4 - D4 - 4D',
          calcium: 'D4 - D4 - D4 - 4D',
          iron: 'Laptop'
        },
        {
          name: 'Joselu Sanmartin',
          calories: 'Josegol',
          fat: 'Apple',
          carbs: 'Psafsdf',
          protein: 'g35ert4',
          sodium: 'D4 - D4 - D4 - 4D',
          calcium: 'D4 - D4 - D4 - 4D',
          iron: 'Laptop'
        },
        {
          name: 'Mathias Olivera',
          calories: 'matadsf',
          fat: 'HP',
          carbs: 'Psafsdf',
          protein: 'g35ert4',
          sodium: 'D4 - D4 - D4 - 4D',
          calcium: 'D4 - D4 - D4 - 4D',
          iron: 'Laptop'
        },
        {
          name: 'Lázaro Alcedo FIALLO',
          calories: 'lazaroeaf',
          fat: 'HP',
          carbs: 'Psafsdf',
          protein: 'g35ert4',
          sodium: 'D4 - D4 - D4 - 4D',
          calcium: 'D4 - D4 - D4 - 4D',
          iron: 'Laptop'
        },
        {
          name: 'Lázaro Alcedo FIALLO',
          calories: 'lazaroeaf',
          fat: 'HP',
          carbs: 'Psafsdf',
          protein: 'g35ert4',
          sodium: 'D4 - D4 - D4 - 4D',
          calcium: 'D4 - D4 - D4 - 4D',
          iron: 'Laptop'
        },
        {
          name: 'Honeycomb',
          calories: 408,
          fat: 3.2,
          carbs: 87,
          protein: 6.5,
          sodium: 562,
          calcium: '0%',
          iron: '45%'
        },
        {
          name: 'Donut',
          calories: 452,
          fat: 25.0,
          carbs: 51,
          protein: 4.9,
          sodium: 326,
          calcium: '2%',
          iron: '22%'
        },
        {
          name: 'KitKat',
          calories: 518,
          fat: 26.0,
          carbs: 65,
          protein: 7,
          sodium: 54,
          calcium: '12%',
          iron: '6%'
        }
      ]
    }
  }
}
</script>
<style>

</style>