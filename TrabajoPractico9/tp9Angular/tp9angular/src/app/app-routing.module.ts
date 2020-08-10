import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { GrillaProductosComponent } from "./components/grilla-productos/grilla-productos.component";
import { Formulario } from "./components/formulario/formulario";
import { ListarAdmin } from "./components/listar-admin/listar-admin.component";
import { DetalleComponent } from "./components/detalle/detalle.component";
import { UbicacionComponent } from './components/ubicacion/ubicacion.component';
import { HomeComponent } from './components/home/home.component';

const routes: Routes = [
  { path: "instrumentos", component: GrillaProductosComponent },
  { path: "formulario", component: Formulario },
  { path: "formulario/:id", component: Formulario },
  { path: "listar", component: ListarAdmin },
  { path: "detalle/:id", component: DetalleComponent },
  { path: "ubicacion", component: UbicacionComponent },
  { path: "home", component: HomeComponent }
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
