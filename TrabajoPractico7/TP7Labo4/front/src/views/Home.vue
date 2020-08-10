<template>
  <div id="home">       
        <p class="titulo">
        <strong>Musical Hendrix</strong> es una tienda de instrumentos musicales con ya más de 15 años de experiencia.
        <br />
        Tenemos el conocimiento y la capacidad como para informarte acerca de
        las mejores elecciones para tu compra musical.
        </p>
      </div>
</template>

<style>

.titulo{
    width: 50%;
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    padding: 10px;
    font-family: Verdana, Geneva, Tahoma, sans-serif;   
    z-index: 2;
    float: left;
    
}
  #home{    
    width: 100%;
    height: 650px;   
    position: relative;
    display: inline-block;
    text-align: center;
    background-image: url("/images/fondo2.jpg");
    background-size: contain;
    background-repeat: no-repeat;
    background-color: #fedb35;
  }




</style>