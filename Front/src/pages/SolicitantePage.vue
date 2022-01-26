<template>
  <Solicitud/>
</template>

<script>
import Solicitud from '../components/Solicitud/Solicitud.vue'
import jwt_decode from 'jwt-decode'

export default {
  components: {
    Solicitud
  },

  created(){
    console.log(jwt_decode(localStorage.getItem("token")).roles[0].authority)
      if (jwt_decode(localStorage.getItem("token")).roles[0].authority === "Solisitante" || jwt_decode(localStorage.getItem("token")).roles[1].authority === "Solisitante") {
        console.log("fffffffffffff")
      } else {
        this.$router.push("/login")
      }
      console.log(localStorage)
  },

}
</script>

<style>

</style>