<template>
  <Solicitud/>
</template>

<script>
import Solicitud from '../components/Solicitud/Solicitud.vue'
import jwt_decode from 'jwt-decode'

export default {
  
  mounted(){
    this.permisos()
  },
  created(){
    },

  components: {
      Solicitud
  },
  methods: {
    permisos(){
      if (jwt_decode(localStorage.getItem("token")).roles[0].authority === "Solicitante") {
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