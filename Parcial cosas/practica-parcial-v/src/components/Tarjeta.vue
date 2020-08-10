<template>
  <div class="row">
    <div class="col-xs-1-12">
      <div class="card">
        <div class="card-body" style="width: 1000px; height: 300px">
          <b-row>
            <b-col>
                <a :href="'/detalle/' + instrumento.id">
                <b-card-img
                  :src="'/images/' + instrumento.imagen"
                  class="imagen"
                ></b-card-img>
                </a>
            </b-col>
            <b-col class="texto">
              <b-card-title
                :title="instrumento.instrumento"
              ></b-card-title>
              <b-card-text> $ {{ instrumento.precio }} </b-card-text>
              <b-card-text>
                <span
                  v-if="instrumento.costoEnvio == 'G'"
                  style="color:green"
                >
                  <img src="/images/camion.png" />
                  Envio gratis a todo el país
                </span>
                <span v-else style="color:orange">
                  Costo de envío al interior de Argentina: $
                  {{ instrumento.costoEnvio }}
                </span>
              </b-card-text>
              <b-card-text
                >{{ instrumento.cantidadVendida }} vendidos
              </b-card-text>
            </b-col>
          </b-row>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props: ["instrumento"],
};
</script>

<style>
.imagen {
  margin: 50px;
  width: 40%;
  margin-top: 10px;
}

.texto {
  margin-top: 50px;
  text-align: left;
}
</style>
