<template>
  <div id="app">
    <div id="nav"><top-nav-bar></top-nav-bar></div>
    <router-view />
  </div>
</template>

<script>
import NavBarTop from "@/components/TopBar.vue";
export default {
  components: {
    "top-nav-bar": NavBarTop
  }
  
};
</script>
<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

</style>
