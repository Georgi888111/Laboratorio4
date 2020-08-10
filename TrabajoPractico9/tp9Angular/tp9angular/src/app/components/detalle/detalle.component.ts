import { Component, OnInit } from "@angular/core";
import { ServicioService } from "src/app/servicios/servicio.service";
import { ActivatedRoute } from "@angular/router";

@Component({
  selector: "app-detalle",
  templateUrl: "./detalle.component.html",
  styleUrls: ["./detalle.component.css"],
})
export class DetalleComponent implements OnInit {
  instrumento: any;
  envioGratis: boolean;
  constructor(
    private activatedRoute: ActivatedRoute,
    private servicio: ServicioService
  ) {}

  ngOnInit() {
    this.activatedRoute.params.subscribe((params) => {
      this.servicio.getInstrumentosXId(params["id"]).subscribe((data) => {
        this.instrumento = data;
      });
      console.log(this.instrumento);
    });
  }
}
