<template>
  <AdministrarSolicitud/> 
  <!-- <ListaSolicitud/> --> 
</template>

<script>
import AdministrarSolicitud from '../components/Solicitud/AdministrarSolicitud/AdministrarSolicitud.vue'
import ListaSolicitud from '../components/Solicitud/AdministrarSolicitud/ListaSolicitudes.vue'
import jwt_decode from 'jwt-decode'

export default {
  components: {
    AdministrarSolicitud,
    //ListaSolicitud
  },

  mounted() {
    this.permisos()
  },

  methods: {
    permisos(){
      if (jwt_decode(localStorage.getItem("token")).roles[0].authority === "Administrador") {
        console.log("fffffffffffff")
      } else {
        console.log("push login")
        this.$router.push("/login")
      }
      console.log(localStorage)
    }
  }

}
</script>

<style>

</style>