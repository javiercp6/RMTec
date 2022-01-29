<template >
<div class="fullscreen bg-blue text-white text-center q-pa-md flex flex-center">
  <q-page class="row items-center justify-center" padding>
        <div class="q-pa-md   ">
            <q-card class="my-card">
            <!-- <img  src="~assets/quasar-logo-full.svg"> -->
                <div class=" row justify-center ">
                    <q-icon color="black" name="login" size="100px"></q-icon> 
                </div>
                <q-card-section>
                        <q-form @submit.prevent="submitFormLogin">
                            <q-input
                                v-model="formLogin.usuario"
                                ref="usuario"
                                lazy-rules
                                :rules="[ val => val && val.length > 0 || 'Este campo no puede enviarse vacio']"
                                label="Usuario"
                                type="text" >
                                <template v-slot:prepend>
                                    <q-icon name="account_circle" />
                                </template>
                            </q-input> 
                            <q-input
                                v-model="formLogin.contrasenna"
                                ref="contraseña"
                                lazy-rules
                                :rules="[ val => val && val.length > 0 || 'Este campo no puede enviarse vacio']"
                                label="Contraseña"
                                :type="isPwd ? 'password' : 'text'">
                                <template v-slot:prepend>
                                    <q-icon name="lock" />
                                </template>
                                <template v-slot:append>
                                    <q-icon
                                        :name="isPwd ? 'visibility_off' : 'visibility'"
                                        class="cursor-pointer"
                                        @click="isPwd = !isPwd"
                                    />
                                </template>
                            </q-input>
                            <div class="row justify-center q-py-md">
                                <q-btn
                                 class="col" 
                                 label="Iniciar Sesión" 
                                 color="primary" 
                                 type="submit"/>
                            </div>
                        </q-form>
                </q-card-section>
            

            </q-card>
        </div>
     </q-page>
    </div>
</template>

<script>
//import { mapActions, mapGetters, mapState } from 'vuex';  
import axios from "axios";
export default {
    computed: {
      // ...mapState('denuncia', ['denuncias']),
    },
    data() {
        return {
            formLogin: {
                usuario: "",
                contrasenna: ""
            }, 
            isPwd: true

        }
    },
    methods: {
     //   ...mapActions('login', ['registrarUsuario']), 
     //   ...mapActions('denuncia', ['getDenuncias']),  
        submitFormLogin(){
            this.$refs.usuario.validate()
            this.$refs.contraseña.validate()
            if (!this.$refs.usuario.hasError && !this.$refs.contraseña.hasError) {
                //this.registrarUsuario(this.formLogin) 
                //console.log("hola state" + this.denuncias)
                axios.post("http://localhost:8080/login", this.formLogin).then(response =>{
                    console.log(response.data)
                    localStorage.setItem("token", response.data)
                    axios.defaults.headers.common['Authorization'] = localStorage.getItem("token")
                    console.log(axios.defaults.headers.common['Authorization'])
                    this.$router.push("/")
                    })
                    .catch(error => {
                            console.log(error, "Error en el login")
                            this.errored = true
                    })
                    .finally(() => this.loading = false);
            }
                
        }
    },

    mounted() {
        
        },
    created() {
       // this.getDenuncias()
    },

}
</script>

<style lang="sass" scoped>
.my-card
  width: 100%
  min-width: 290px
  max-width: 300px
  
.bg-blue 
  background: #b2b1b3 !important

</style>