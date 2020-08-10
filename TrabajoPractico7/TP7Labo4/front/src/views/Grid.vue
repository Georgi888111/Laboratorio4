<template>
  <div class="container">
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
        "http://localhost:9001/instrumento/enabled",
        config
      );
      const resJson = await res.json();
      console.log(resJson);
      this.instrumentosData = resJson;
    },
  },
};
</script>
