<template>
  <q-page>
    <div class="section_index row bg-secondary">
      <div class="col col-xs-12 col-sm-6 row items-center">
        <div class="title-index q-pa-lg">
          <h1>Registra tus medios tecnológicos en simples pasos</h1>
          <q-btn unelevated rounded color="primary" label="Crear Solicitud" to="Solicitud"/>
        </div>
      </div>
      <div class="col col-xs-12 col-sm-6 flex flex-center">
        <img src="../assets/asset_1.png" class="asset1" alt="">
      </div>
    </div>
    <section style="height: 100px ">
      
    </section>
    <div>
      sdfsdf
    </div>
    <!-- <img
      alt="Quasar logo"
      src="~assets/quasar-logo-full.svg"
    > -->
  </q-page>
</template>

<script>
export default {
  name: 'PageIndex'
}
</script>

<style lang="sass" scoped>
h1
  font-size: 30px 
  line-height: 3rem
  color: #c3c3c3

.section_index
  width: 100%
  height: calc(100vh - 50px) 

.asset1 
  width: 300px

@media  only screen and (min-width: 923px) and (max-width: 1440px)
  .asset1 
    width: 450px

  h1
    font-size: 40px 

  .title-index
    padding: 50px

@media  only screen and (min-width: 1440px)
  .asset1 
    width: 550px

  h1
    font-size: 50px 

  .title-index
    padding: 120px

   
</style>