<template>
  <div id="app">
    <div id="nav">
     <navegacion></navegacion>
    </div>
    <router-view/>
  </div>
</template>
<script>
import Navegacion from "@/components/Navegacion.vue";
export default {
  components: {
    "navegacion": Navegacion
  }
  
};
</script>
<style>


</style>
