<template>
<div class="fondo">
  <p class="tituloHome">¡Bienvenido!</p>
</div>
</template>

<script>


export default {
  name: 'Home',
  components: {
    
  }
}
</script>
<style>
.fondo{
  width: 100%;
    height: 650px;   
    position: relative;
    display: inline-block;
    text-align: center;
    background-image: url("/images/fondo2.jpg");
    background-size: contain;
    background-repeat: no-repeat;
    background-color: #ADD7EF;
}
.tituloHome{
  font-family: Helvetica;
  font-size: 20px;
  margin-top: 50px;
}
</style>
 