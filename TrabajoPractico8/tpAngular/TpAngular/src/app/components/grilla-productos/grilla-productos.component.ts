import { Component, OnInit } from "@angular/core";
import { ServicioService } from "src/app/servicios/servicio.service";
import { Router } from "@angular/router";

@Component({
  selector: "app-grilla-productos",
  templateUrl: "./grilla-productos.component.html",
  styleUrls: ["./grilla-productos.component.css"],
})
export class GrillaProductosComponent implements OnInit {
  instrumentosArray: any[] = [];
  constructor(private servicio: ServicioService, private router: Router) {}

  ngOnInit(): void {
    this.instrumentosArray = this.servicio.getInstrumentos();
    console.log(this.instrumentosArray);
  }

  public detalleInstrumento(id: string) {
    this.router.navigate(["/detalle", id]);
  }
}
