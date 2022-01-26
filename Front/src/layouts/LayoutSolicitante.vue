<template>
  <q-layout view="hHh lpR fFf">

    <q-header elevated class="bg-secondary text-white">
      <q-toolbar>
        <q-btn flat @click="drawer = !drawer" round dense icon="menu" id="btn-toolbar" />
        <q-toolbar-title >
            <img src="../assets/logo RMTec2.7.png" class="logo"  @click="toIndex">
        </q-toolbar-title>
        <div class="q-gutter-sm row items-center no-wrap">
          <EssentialLink
            id="EssentialLink-toolbar"
            v-for="link in essentialLinks"
            :key="link.title"
            :router="link.router"
            :title="link.title"
          />
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
            <q-tooltip>Account</q-tooltip>
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

            <EssentialLink
            v-for="link in essentialLinks"
            :key="link.title"
            :router="link.router"
            :title="link.title"
          />

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


const linksData = [
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
  components: { EssentialLink },
  data () {
    return {
      
      essentialLinks: linksData,
      drawer: false,
      index: ''
    }
  },
  methods: {
    toIndex(){
      if (this.$router.history.current.path !== "/") {
        this.$router.push('/')  
      }
    },
  }
}
</script>

<style lang="sass" scoped>
.logo
  width: 150px 
  cursor: pointer

@media (max-width: 800px)
  #EssentialLink-toolbar
    display: none

@media (min-width: 801px)
  #btn-toolbar
    display: none  
</style>