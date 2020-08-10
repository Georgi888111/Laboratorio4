<template>
  <div>
  <p>{{paisEncontrado[0].name}}</p>
  <ul>
           <li v-for="item in paisEncontrado[0].languages" :key="item">{{item.name}}</li>
       </ul>
  </div>
</template>
<script>
export default {
  name: "DetallePais",
  components: {},
  mounted() {
    this.getPaisXId();
  },
  data() {
    return {
      paisEncontrado: []
    };
  },
  methods: {
      
    async getPaisXId() {
     const parametroId = this.$route.params.callingCodes;   
     this.axios.get('https://restcountries.eu/rest/v2/callingcode/' + parametroId)
    
     .then(res =>{
         console.log(res);
         this.paisEncontrado = res.data;
     })
     .catch(e =>{
         console.log(e);
          console.log(parametroId);
     })
    }
  }
};
</script>