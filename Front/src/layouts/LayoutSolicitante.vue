<template>
  <q-layout view="hHh lpR fFf">

    <q-header elevated class="bg-secondary text-white">
      <q-toolbar>
        <q-btn flat @click="drawer = !drawer" round dense icon="menu" id="btn-toolbar" />
        <q-toolbar-title >
            <img src="../assets/logo RMTec2.7.png" class="logo"  @click="toIndex">
        </q-toolbar-title>
        <div class="q-gutter-sm row items-center no-wrap">
            <!-- <EssentialLink
              id="EssentialLink-toolbar"
              v-for="link in essentialLinks"
              :key="link.title"
              :router="link.router"
              :title="link.title"
            /> -->

              <q-item
                v-if="$store.state.usuario.rol === 'Solicitante'"
                clickable
                to="solicitante"
              >
                <q-item-section>
                  <q-item-label>Gestionar Solicitud</q-item-label>
                </q-item-section>
              </q-item>

              <q-item
                v-if="$store.state.usuario.rol === 'Administrador'"
                clickable
                to="adminsolicitud"
              >
                <q-item-section>
                  <q-item-label>Administrar Solicitud</q-item-label>
                </q-item-section>
              </q-item>

              <q-item
                v-if="$store.state.usuario.rol === 'Custodio'"
                clickable
                to="custodiosolicitud"
              >
                <q-item-section>
                  <q-item-label>Revisar Solicitud</q-item-label>
                </q-item-section>
              </q-item>

              <q-item
                clickable
                to="ayuda"
              >
                <q-item-section>
                  <q-item-label>Ayuda</q-item-label>
                </q-item-section>
              </q-item>

              <q-item
                clickable
                to="acerca_de"
              >
                <q-item-section>
                  <q-item-label>Acerca de</q-item-label>
                </q-item-section>
              </q-item>
            

          <q-btn round dense flat color="grey-8" icon="notifications">
            <q-badge color="red" text-color="white" floating>
              2
            </q-badge>
            <q-tooltip>Notifications</q-tooltip>
          </q-btn>
          
          <q-btn round flat>
            <q-avatar size="26px">
              <img src="../assets/10.jpg">
            </q-avatar>
            <q-menu>
              <q-list style="min-width: 100px">
                <q-item clickable v-close-popup @click="deslogear">
                  <q-item-section>Salir</q-item-section>
                </q-item>
              </q-list>
            </q-menu>
            <!-- <q-tooltip>Account</q-tooltip> -->
          </q-btn>
        </div>
      </q-toolbar>
    </q-header>

    <q-drawer
        v-model="drawer"
        :width="200"
        :breakpoint="500"
        overlay
        bordered
        content-class="bg-grey-3"
      >
        <q-scroll-area class="fit">
          <q-list>
            <!-- <EssentialLink
              v-for="link in essentialLinks"
              :key="link.title"
              :router="link.router"
              :title="link.title"
            />  -->

              <q-item
                v-if="$store.state.usuario.rol === 'Solicitante'"
                clickable
                to="solicitante"
              >
                <q-item-section>
                  <q-item-label>Gestionar Solicitud</q-item-label>
                </q-item-section>
              </q-item>

              <q-item
                v-if="$store.state.usuario.rol === 'Administrador'"
                clickable
                to="adminsolicitud"
              >
                <q-item-section>
                  <q-item-label>Administrar Solicitud</q-item-label>
                </q-item-section>
              </q-item>

              <q-item
                v-if="$store.state.usuario.rol === 'Custodio'"
                clickable
                to="custodiosolicitud"
              >
                <q-item-section>
                  <q-item-label>Revisar Solicitud</q-item-label>
                </q-item-section>
              </q-item>

              <q-item
                clickable
                to="ayuda"
              >
                <q-item-section>
                  <q-item-label>Ayuda</q-item-label>
                </q-item-section>
              </q-item>

              <q-item
                clickable
                to="acerca_de"
              >
                <q-item-section>
                  <q-item-label>Acerca de</q-item-label>
                </q-item-section>
              </q-item>

          </q-list>
        </q-scroll-area>
      </q-drawer>

    <q-page-container>
      <router-view />
    </q-page-container>

    <!-- <q-footer elevated class="bg-grey-8 text-white">
      <q-toolbar>
        <q-toolbar-title>
          <q-avatar>
            
          </q-avatar>
          Title
        </q-toolbar-title>
      </q-toolbar>
    </q-footer> -->

  </q-layout>
</template>

<script>
import EssentialLink from 'components/EssentialLink.vue'
import router from 'src/router';
import jwt_decode from 'jwt-decode'


const linksDataSolicitante = [
  {
    title: 'Gestionar Solicitud',
    caption: 'github.com/quasarframework',
    icon: 'code',
    router: 'solicitante'
  },
  {
    title: 'Ayuda',
    caption: 'chat.quasar.dev',
    icon: 'chat',
    router: 'ayuda'
  },
  {
    title: 'Acerca de',
    caption: 'forum.quasar.dev',
    icon: 'record_voice_over',
    router: 'acerca_de'
  },
  
];

export default {
  name: 'MainLayout',
  components: { /* EssentialLink */ },
  data () {
    return {
      
      essentialLinks: function(){
        if ($store.state.usuario.rol === "Solicitante") {
          return linksDataSolicitante
        } else if ($store.state.usuario.rol === "Administrador") {
          return linksDataAdministrador
        }else{
          return linksDataCustodio
        }
      } ,
      drawer: false,
      index: '',

    }
  },
  
  mounted() {
    console.log(this.rol)
    console.log(this.$store.state.usuario.rol)
  /*   if (this.rol === "Solicitante") {
          this.essentialLinks = linksDataSolicitante
        } else if (this.rol === "Administrador") {
          this.essentialLinks = linksDataAdministrador
        }else{
          this.essentialLinks = linksDataCustodio
        } */
    },

   computed: {

/*     links: function (){
      if (this.rol === "Solicitante") {
        return this.essentialLinksS
      } else if (this.rol === "Administrador") {
        return this.essentialLinksA
      } else {
       return this.essentialLinksC
      }
    } */
  },
  methods: {
    toIndex(){
      if (this.$store.state.usuario.rol === 'Solicitante') {
        if (this.$router.history.current.path !== "/") {
          this.$router.push('/')  
        }  
      }
    },

    deslogear(){
      localStorage.removeItem('token')
      this.$router.push("login")
    }
  }
}
</script>

<style lang="sass" scoped>
.logo
  width: 150px 
  cursor: pointer

@media (max-width: 800px)
  q-item
   display: none

@media (min-width: 801px)
  #btn-toolbar
    display: none  
</style>