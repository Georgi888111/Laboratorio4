<template>
  
        <b-card-group deck>
            <div v-for="instrumento in instrumentosData" :key="instrumento.id">
        <tarjeta :instrumento="instrumento"></tarjeta>
        </div>
          </b-card-group>
       
</template>
<script>
import Tarjeta from "@/components/Tarjeta.vue";
export default {
 components: {
    "tarjeta": Tarjeta,
 },
  props:["instrumento"],
  mounted(){
      this.getInstrumentos();
  },
  data(){
      return{
          instrumentosData:[],
      };
  },
  methods:{
      async getInstrumentos(){
      const res = await fetch("/instrumentos.json");
      const resJson = await res.json();
      console.log(resJson);
      this.instrumentosData = resJson.instrumentos;
      },
  },
};
</script>