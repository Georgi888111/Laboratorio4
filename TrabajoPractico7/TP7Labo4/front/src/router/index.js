import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";



Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/grid",
    name: "Grid",
    component: () => import("@/views/Grid.vue"),
  },
  {
    path: "/detalle/:id",
    name: "Detalle",
    component: () => import("../views/Detalle.vue"),
  },
  {
    path: "/ubicacion",
    name: "Ubicacion",
    component: () => import("../views/Ubicacion.vue")
  },

  {
    path: "/form",
    name: "Formulario",
    component: () => import("../views/Formulario.vue")
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
