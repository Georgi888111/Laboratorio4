<template>
    <div>
  <b-navbar type="light" variant="light">
    <b-nav-form>
      <label class="labelLegajo">Legajo:</label>
      <b-form-input class="mr-sm-2" placeholder="Search"></b-form-input>
      <b-button variant="outline-success" class="btnBuscarLejago" type="submit">Buscar</b-button>
       <label class="labelNombre">Nombre:</label>
      <b-form-input class="mr-sm-2" placeholder="Search"></b-form-input>
      <b-button variant="outline-success" class="btnBuscarLejago" type="submit" @click="buscaNombre()">Buscar</b-button>
      <a href="/detalle" class="mejorAlumno">MEJOR ALUMNO</a>
    </b-nav-form>
  </b-navbar>
</div>
</template>
<script>
export default {
  name: "Navegacion",
  components: {},
  mounted() {
   
  },
  data() {
    return {
     nombre: "",
    };
  },
  methods: {
    buscaNombre() {

    
    }
  }
};
</script>
<style>
.labelLegajo{
  margin-right: 10px;
}
.btnBuscarLejago{
  color: black;
  background-color: white;
  border: black;

  
}
.labelNombre{
  margin-right: 10px;
  margin-left: 50px;
}
.mejorAlumno{
  margin-left: 10px;
}
</style>