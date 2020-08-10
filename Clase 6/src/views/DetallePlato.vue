<template>
  <div>
    <b-container fluid>
      <b-row>
        <b-col>
          <img
            style="max-height:400px"
            :src="'/images/' + platoEncontrado.imagenPath"
        /></b-col>
        <b-col>
          <b-row>
            <b-col
              ><h1>{{ platoEncontrado.nombre }}</h1></b-col
            >
          </b-row>
          <b-row>
            <b-col
              ><h2>$ {{ platoEncontrado.precio }}</h2></b-col
            >
          </b-row>
          <b-row>
            <b-col
              ><h2>{{ platoEncontrado.rubro }}</h2></b-col
            >
          </b-row>
          <b-row>
            <b-col><b>Ingredientes:</b></b-col>
          </b-row>
          <b-row>
            <b-col
              ><li
                v-for="(ingrediente, index) in platoEncontrado.ingredientes"
                :key="index"
              >
                {{ ingrediente }}
              </li>
            </b-col>
          </b-row>
          <b-row style="text-align:center">
            <b-col
              ><b-button href="/" variant="outline-primary"
                >VOLVER</b-button
              ></b-col
            >
          </b-row>
        </b-col>
      </b-row>
    </b-container>
  </div>
</template>

<script>
export default {
  name: "DetallePlato",
  components: {},
  mounted() {
    this.getPlatoXId();
  },
  data() {
    return {
      platoEncontrado: []
    };
  },
  methods: {
    async getPlatoXId() {
      const parametroId = this.$route.params.id;
      const res = await fetch("/platos.json");
      const resJson = await res.json();
      console.log(resJson);
      this.platoEncontrado = await resJson.platos.find(
        plato => plato.id === parametroId
      );
      console.log(this.platoEncontrado);
    }
  }
};
</script>
