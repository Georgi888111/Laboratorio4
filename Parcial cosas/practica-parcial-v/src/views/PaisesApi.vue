<template>
   <div>
  <b-table striped hover :items="paisesData" :fields="fields" show-empty>           
     <template v-slot:cell="row">
               <b-button size="sm" :href="'/detallePais/' + row.item.callingCodes" class="mr-1">
                    Detalle
                </b-button>
     </template>
        </b-table>
  </div>
</template>
<script>

export default {
 components: {
   
 },
  props:["paises"],
  mounted(){
      this.getPaises();
  },
  data(){
      return{
          fields: ['name', 'region', 'capital','Boton'],
      
          paisesData:[],
      };
  },
  methods:{
    async getPaises() {
     
     this.axios.get('https://restcountries.eu/rest/v2/')
    
     .then(res =>{
        
         this.paisesData = res.data;
         console.log(res)
     })
     .catch(e =>{
         console.log(e);
          
     })
    }
  }
  };
</script>