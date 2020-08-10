<template>
  <div class="home">
    <b-container fluid>
      <b-card-group deck>
        <div
          v-for="plato in platosData"
          :key="plato.id"
          style="margin-top:15px"
        >
          <plato-item :platoParam="plato"></plato-item>
        </div>
      </b-card-group>
    </b-container>
  </div>
</template>

<script>
// @ is an alias to /src
import Plato from "@/components/Plato.vue";

export default {
  name: "Home",
  components: {
    "plato-item": Plato
  },
  mounted() {
    this.getPlatos();
  },
  data() {
    return {
      platosData: []
    };
  },
  methods: {
    async getPlatos() {
      const res = await fetch("/platos.json");
      const resJson = await res.json();
      console.log(resJson);
      this.platosData = resJson.platos;
    }
  }
};
</script>
