<template>
  <div id="ubicacion">
    <div id="titulo">Dónde estamos</div>
   <iframe
      class="gMap"
      src="https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d996.0947107272386!2d-68.83894376895863!3d-32.88627163419579!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1ses-419!2sar!4v1589163006043!5m2!1ses-419!2sar"
      frameborder="0"
      allowfullscreen="false"
      aria-hidden="false"
      tabindex="0"
    ></iframe>
  </div>
</template>

<style>
#ubicacion{
    background-color: #fedb35;
    height: 600px; 
}

  .gMap {
    margin-top: 20px;
  border: 0;
  width: 650px;
  height: 450px; 
  position: relative;

  }
  #titulo{
  padding: 10px;
    font-family: Verdana, Geneva, Tahoma, sans-serif;  
    text-align:left;
    font-weight: bold;
    margin-left: 50px;
}


</style>
