import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from "@angular/common/http";
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { GrillaProductosComponent } from './components/grilla-productos/grilla-productos.component';
import {Formulario} from './components/formulario/formulario';
import { ListarAdmin } from './components/listar-admin/listar-admin.component';
import {ServicioService} from 'src/app/servicios/servicio.service';
import { FormsModule} from '@angular/forms';
import { DetalleComponent } from './components/detalle/detalle.component';
import {NavegacionComponent} from './components/navegacion/navegacion.component'

@NgModule({
  declarations: [
    AppComponent,
    GrillaProductosComponent,
    Formulario,
    ListarAdmin,
    DetalleComponent,
    NavegacionComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    FormsModule,
    HttpClientModule
    
  ],
    
  providers: [ServicioService],
  bootstrap: [AppComponent]
})
export class AppModule { }
