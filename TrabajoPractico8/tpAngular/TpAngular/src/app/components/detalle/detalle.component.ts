import { Component, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { ServicioService } from "src/app/servicios/servicio.service";

@Component({
  selector: "app-detalle",
  templateUrl: "./detalle.component.html",
  styleUrls: ["./detalle.component.css"],
})
export class Detalle implements OnInit {
  instrumento: any;
  constructor(
    private activatedRoute: ActivatedRoute,
    private service: ServicioService
  ) {
    this.activatedRoute.params.subscribe((params) => {
      console.log(params["id"]);
      this.instrumento = this.service.getInstrumentoXId(params["id"]);
    });
  }

  ngOnInit() {}
}
