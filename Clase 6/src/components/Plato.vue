<template>
  <div>
    <b-card
      tag="article"
      style="max-width: 20rem; min-width: 20rem;"
      class="mb-2"
    >
      <b-card-img
        :src="'/images/' + platoParam.imagenPath"
        alt="Image"
        style="min-height:200px; max-height:200px"
      ></b-card-img>
      <b-card-title :title="platoParam.nombre"></b-card-title>
      <b-card-text>
        $ {{ platoParam.precio }}
        <span style="color:red" v-if="platoParam.id == 5"> 
        (Es Bebida)
        </span>
      </b-card-text>
      <div style="text-align:center">
        <b-button
          :href="'/detalle/' + platoParam.id"
          variant="primary"
          style="width:100%">
            <b>Detalle</b>
        </b-button>
      </div>
    </b-card>
  </div>
</template>
<script>
export default {
  props: ["platoParam"]
};
</script>
<style lang=""></style>
