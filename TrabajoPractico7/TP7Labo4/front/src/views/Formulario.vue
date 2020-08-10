<template>
  <div>
      <div id="form">       
        <p id="titulo">
        Formulario de ABM
        </p>
        <b-button size="sm" @click="openModalNuevo()" class="mr-2">
                    Agregar instrumento
        </b-button>
       <b-table striped hover :items="instrumentosData" :fields="campo">
            <template v-slot:cell(accion)="row">
                <b-button size="sm" @click="openModalModificar(row.item.id)" class="mr-1">
                    Modificar
                </b-button>
                <b-button size="sm" @click="eliminar(row.item.id)" class="mr-1">
                    Eliminar
                </b-button>
            </template>
       </b-table>     
    </div>
    <b-modal ref="modal" hide-footer title="Modificar instrumento">
      <form>
            <label class="mr-sm-2" for="inline-form-custom-select-pref">Instrumento</label>
            <b-form-input                
                v-model="instrumentoEncontrado.instrumento"
                placeholder="Instrumento"                
            ></b-form-input>
            <label class="mr-sm-2" for="inline-form-custom-select-pref">Marca</label>
            <b-form-input                
                v-model="instrumentoEncontrado.marca"
                placeholder="Marca"               
            ></b-form-input>
            <label class="mr-sm-2" for="inline-form-custom-select-pref">Modelo</label>
            <b-form-input                
                v-model="instrumentoEncontrado.modelo"
                placeholder="Modelo"               
            ></b-form-input>
            <label class="mr-sm-2" for="inline-form-custom-select-pref">Precio</label>
            <b-form-input   
                type="number"             
                v-model="instrumentoEncontrado.precio"
                placeholder="Precio"               
            ></b-form-input>
            <label class="mr-sm-2" for="inline-form-custom-select-pref">Costo de envío</label>
            <b-form-input                
                v-model="instrumentoEncontrado.costoEnvio"
                placeholder="Costo de envio"               
            ></b-form-input>
            <label class="mr-sm-2" for="inline-form-custom-select-pref">Cantidad vendida</label>
             <b-form-input    
                type="number"               
                v-model="instrumentoEncontrado.cantidadVendida"
                placeholder="Cantidad vendida"               
            ></b-form-input>
            <label class="mr-sm-2" for="inline-form-custom-select-pref">Descripción</label>
             <b-form-textarea               
                v-model="instrumentoEncontrado.descripcion"
                placeholder="descripcion"               
            ></b-form-textarea>
            
            <label class="mr-sm-2" for="inline-form-custom-select-pref">Imagen</label>
                  
            <b-form-file :state="Boolean(onFileSelected)" @change="onFileSelected"></b-form-file>

            <b-form-checkbox v-model="instrumentoEncontrado.estaHabilitado"                               
            > Habilitado </b-form-checkbox>
            
            <b-button  v-on:click="guardar()"  class="mr-1" >Guardar</b-button>
  
            
        </form>
        
        
    </b-modal>
</div>
       
</template>


<script>
export default {
   mounted() {
    this.getInstrumentos();
  },
  
  data() {
    return {
        campo: ['accion','id', 'instrumento', 'marca', 'modelo', 'imagen', 'precio', 'costoEnvio','cantidadVendida','descripcion','estaHabilitado'],
        instrumentosData: [],
        instrumentoEncontrado: {
            id:"",
            instrumento:"",
            marca:"",
            modelo:"",
            imagen:"",
            precio:0,
            costoEnvio:"",
            cantidadVendida:0,
            descripcion:"",
            estaHabilitado: false,
        },
       selectedFile:null,
       update :false,
       
       
    };
  },
  methods: {
    async getInstrumentos() {
      var config = {
        headers: {
          "Content-type": "application/json; charset=utf-8",
          "Access-Control-Allow-Origins": "*",
          "Access-Control-Allow-Methods": ["GET", "OPTIONS"],
          "Access-Control-Allow-Headers": "Content-Type",
          "cache-control": "no-cache",
        },
      };
      const res = await fetch(
        "http://localhost:9001/instrumento/all",
        config
      );
      const resJson = await res.json();
      
      this.instrumentosData = resJson;
    },

    async getInstrumentoXId(parametroId) {
      
     this.axios.get('http://localhost:9001/instrumento/'+parametroId)
    
     .then(res =>{
         console.log(res);
         this.instrumentoEncontrado = res.data;
     })
     .catch(e =>{
         console.log(e);
          console.log(parametroId);
     })
    
    },

    onFileSelected(event){
       this.selectedFile = event.target.files[0]
      },

    
               

save() {  

  if(this.update){
    console.log("update")
  
    if(this.selectedFile==null){
      console.log("sin imagen")
      this.axios.post('http://localhost:9001/instrumento/',{ 
          id:this.instrumentoEncontrado.id,      
           instrumento: this.instrumentoEncontrado.instrumento,
           marca: this.instrumentoEncontrado.marca,
           modelo: this.instrumentoEncontrado.modelo,
            imagen: this.instrumentoEncontrado.imagen,
           precio :this.instrumentoEncontrado.precio,
           costoEnvio: this.instrumentoEncontrado.costoEnvio,
           cantidadVendida: this.instrumentoEncontrado.cantidadVendida,
           descripcion: this.instrumentoEncontrado.descripcion,
           estaHabilitado : this.instrumentoEncontrado.estaHabilitado,
       
      })    
     .then(res =>{
         console.log(res);
         this.instrumentoEncontrado = res.data;
         
      })
      .catch(e =>{
         console.log(e);
          
      })
    }else{
      console.log("con imagen")

      const formData = new FormData();
        formData.append("file",this.selectedFile);               
        this.axios.post('http://localhost:9001/instrumento/upload', formData, {headers: {
                    'Content-Type': 'multipart/form-data',
                    "Access-Control-Allow-Origins": "*",                   
                    "cache-control": "no-cache",                   

                }})
        .then(res =>{
            console.log(res)
        })
        .catch(e =>{
          console.log(e);
          
        })
   
      this.axios.post('http://localhost:9001/instrumento/',{ 
        id:this.instrumentoEncontrado.id,      
        instrumento: this.instrumentoEncontrado.instrumento,
        marca: this.instrumentoEncontrado.marca,
        modelo: this.instrumentoEncontrado.modelo,
        imagen: this.selectedFile.name,
        precio :this.instrumentoEncontrado.precio,
        costoEnvio: this.instrumentoEncontrado.costoEnvio,
        cantidadVendida: this.instrumentoEncontrado.cantidadVendida,
        descripcion: this.instrumentoEncontrado.descripcion,
        estaHabilitado : this.instrumentoEncontrado.estaHabilitado,
       
      })    
     .then(res =>{
        console.log(res);
        //this.instrumentoEncontrado = res.data;
      })
     .catch(e =>{
        console.log(e);
      })
    }
    
    

  }else{
    console.log("insert")
    const formData = new FormData();
      formData.append("file",this.selectedFile);
      this.axios.post('http://localhost:9001/instrumento/upload', formData, {headers: {
                    'Content-Type': 'multipart/form-data',
                    "Access-Control-Allow-Origins": "*",                   
                    "cache-control": "no-cache",
      }})
      .then(res =>{
        console.log(res)
      })
      .catch(e =>{
        console.log(e);
      })
    
    this.axios.post('http://localhost:9001/instrumento/',{ 
      id:this.instrumentoEncontrado.id,      
      instrumento: this.instrumentoEncontrado.instrumento,
      marca: this.instrumentoEncontrado.marca,
      modelo: this.instrumentoEncontrado.modelo,
      imagen: this.selectedFile.name,
      precio :this.instrumentoEncontrado.precio,
      costoEnvio: this.instrumentoEncontrado.costoEnvio,
      cantidadVendida: this.instrumentoEncontrado.cantidadVendida,
      descripcion: this.instrumentoEncontrado.descripcion,
      estaHabilitado : this.instrumentoEncontrado.estaHabilitado,
      })    
     .then(res =>{
        console.log(res);
        //this.instrumentoEncontrado = res.data;
      })
     .catch(e =>{
        console.log(e);
      })
  }
  
      this.limpiarDatos();

  //  window.location.reload();   
      
    },
              
     
    limpiarDatos(){
     this.selectedFile=null;
    },

    
    openModalModificar(id) {
         this.$refs['modal'].show()
         this.update = true;
         this.getInstrumentoXId(id);
         
       
      },
      openModalNuevo() {
          this.instrumentoEncontrado = [];
          this.update=false;
         this.$refs['modal'].show()   
      },
      eliminar(parametroId){
          
     this.axios.delete('http://localhost:9001/instrumento/'+ parametroId)
    
     .then(res =>{
         if(res){
         alert('Instrumento eliminado con exito');    
         }
         
     })
     .catch(e =>{
         console.log(e);
          alert('Ocurrió un error, inténtelo nuevamente');   
     })
     window.location.reload();
    },
      

      guardar(){          
          this.save();
          
      }
  },
};
</script>

<style>  
  #titulo{
  padding: 10px;
    font-family: Verdana, Geneva, Tahoma, sans-serif;  
    text-align:left;
    font-weight: bold;
    margin-left: 50px;
}

.mr-1{
    background-color:dodgerblue;
    border: none;
    margin:1px;
}
.mr-2{
    background-color:dodgerblue;
    border: none;
    margin:1px;
    float:left;
}
</style>
