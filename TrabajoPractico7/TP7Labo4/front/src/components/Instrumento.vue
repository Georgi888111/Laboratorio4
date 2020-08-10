<template>
  <div class="row">
    <div class="col-xs-1-12">
      <div class="card">
        <div class="card-body" style="width: 900px; height: 300px">
          <b-row>
            <b-col>
              <a :href="'/detalle/' + instrumentoParam.id">
                <b-card-img
                  class="imagen"
                  :src="
                    'http://localhost:9001/images/' + instrumentoParam.imagen
                  "
                />
              </a>
            </b-col>
            <b-col class="texto">
              <b-card-title
                :title="instrumentoParam.instrumento"
              ></b-card-title>
              <b-card-text> $ {{ instrumentoParam.precio }} </b-card-text>
              <b-card-text>
                <span
                  v-if="instrumentoParam.costoEnvio == 'G' || instrumentoParam.costoEnvio == 0"
                  style="color:green"
                >
                  <img src="http://localhost:9001/images/camion.png" />
                  Envio gratis a todo el país
                </span>
                <span v-else style="color:orange">
                  Costo de envío al interior de Argentina: $
                  {{ instrumentoParam.costoEnvio }}
                </span>
              </b-card-text>
              <b-card-text
                >{{ instrumentoParam.cantidadVendida }} vendidos
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
  props: ["instrumentoParam"],
};
</script>

<style>
.imagen {
  margin: 10px;
  width: 60%;
}

.texto {
  margin-top: 50px;
  text-align: left;
}
</style>
