<template>
     <px-header/>
     <router-view/>
</template>

<script>
import PxHeader from './components/PxHeader.vue'

export default {
  name: 'App',
  components: {
    PxHeader

  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}
</style>
