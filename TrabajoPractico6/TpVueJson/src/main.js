import 'mutationobserver-shim'
import Vue from "vue";
import './plugins/bootstrap-vue'
import './plugins/bootstrap-vue'
import App from "./App.vue";
import router from "./router";
import store from "./store";
import "@babel/polyfill";

Vue.config.productionTip = false;

new Vue({
  router,
  store,
  render: (h) => h(App),
}).$mount("#app");
