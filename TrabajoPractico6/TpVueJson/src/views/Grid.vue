<template>
  <div class="home">
    <b-container fluid>
      <b-card-group deck>
        <div
          v-for="instrumento in instrumentosData"
          :key="instrumento.id"
          style="margin-top: 15px;"
        >
          <instrumento-item :instrumentoParam="instrumento"></instrumento-item>
        </div>
      </b-card-group>
    </b-container>
  </div>
</template>

<script>
import Instrumento from "@/components/Instrumento.vue";
export default {
  components: {
    "instrumento-item": Instrumento,
  },
  props: ["instrumento"],
  mounted() {
    this.getInstrumentos();
  },
  data() {
    return {
      instrumentosData: [],
    };
  },
  methods: {
    async getInstrumentos() {
      const res = await fetch("/instrumentos.json");
      const resJson = await res.json();
      console.log(resJson);
      this.instrumentosData = resJson.instrumentos;
    },
  },
};
</script>
