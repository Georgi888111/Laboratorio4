import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Productos from '../views/Productos.vue'
import Detalle from '../views/Detalle.vue'
import PaisesApi from '../views/PaisesApi.vue'
import DetallePais from '../views/DetallePais.vue'

Vue.use(VueRouter)


  const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/productos',
    name: 'Productos',
    component: Productos
  },
  {
    path: "/detalle/:id",
    name: "Detalle",
    component: Detalle
  },
  {
    path: "/paises",
    name: "PaisesApi",
    component: PaisesApi
  },
  {
    path: "/detallePais/:callingCodes",
    name: "DetallePais",
    component: DetallePais
  }
  
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
