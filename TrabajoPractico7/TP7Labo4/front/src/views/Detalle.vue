<template>
  <div>
    <b-container>
   <b-row> 
       <b-col lg="7" class="izquierda">
       <p><img
            class="imagen" :src="'http://localhost:9001/images/' + instrumentoEncontrado.imagen"/></p>
       <p class="descripcion">Descripcion:<br>
       {{instrumentoEncontrado.descripcion}}</p>
    </b-col>
    <b-col lg="5" class="derecha">
      <p class="vendidos">{{instrumentoEncontrado.cantidadVendida}} vendidos</p>
       <p class="instrumento">{{instrumentoEncontrado.instrumento}}</p>  
       <p class="precio">${{instrumentoEncontrado.precio}}</p>
       <p>Marca:{{instrumentoEncontrado.marca}}<br>
          Modelo:{{instrumentoEncontrado.modelo}}
       </p>
        <p>Costo envío:<br><span class="envio"
                  v-if="instrumentoEncontrado.costoEnvio == 'G' || instrumentoEncontrado.costoEnvio == 0"
                  style="color:green"
                >
                  <img src="/images/camion.png" />
                  Envio gratis a todo el país
                </span>
                <span v-else style="color:orange" class="envio">
                  Costo de envío al interior de Argentina: $
                  {{ instrumentoEncontrado.costoEnvio }}
                </span></p>
         <p><b-button class="boton">Agregar al carrito</b-button></p>
    </b-col>
    </b-row>
    </b-container>
  </div>
</template>

<script>
export default {
  name: "Detalle",
  components: {},
  mounted() {
    this.getInstrumentoXId();
  },
  data() {
    return {
      instrumentoEncontrado: []
    };
  },
  methods: {
      
    async getInstrumentoXId() {
     const parametroId = this.$route.params.id;   
     this.axios.get('http://localhost:9001/instrumento/'+parametroId)
    
     .then(res =>{
         console.log(res);
         this.instrumentoEncontrado = res.data;
     })
     .catch(e =>{
         console.log(e);
          console.log(parametroId);
     })
    }
  }
};
</script>
<style>

.descripcion {
  text-align: left;
  font-size: 12pt;
  font-family: Helvetica;
  margin-top: 30px;
}
.imagen {
  width: 50%;
  align-content: center;

}

.izquierda {
  
  border-right: 1px inset lightgray;
}
.derecha {

  
  border-right: 2px inset lightgray;
  text-align: left;
}
.vendidos {
  margin-top: 20px;
  font-size: 13px;
  font-family: Helvetica;
 
}
.instrumento{
font-weight: bold;
font-family: Helvetica;
font-size: 20px;


  
}

.envio{
   margin-top: 300px; 
   font-family: Helvetica;
}

.precio{
  font-size: 40px; 
  
}
.boton{
    background-color: white;
    color: blue;
    margin-top: 90px;
 
}
</style>