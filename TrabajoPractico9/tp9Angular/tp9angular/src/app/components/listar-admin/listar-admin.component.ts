import { Component, OnInit } from "@angular/core";
import { Instrumento } from "src/app/entidades/Instrumento";
import { ServicioService } from "src/app/servicios/servicio.service";
import { Router } from "@angular/router";

@Component({
  selector: "app-listar-admin",
  templateUrl: "./listar-admin.component.html",
  styleUrls: ["./listar-admin.component.css"],
})
export class ListarAdmin implements OnInit {
  constructor(private router: Router, private servicio: ServicioService) {}
  instrumentos: Instrumento[] = [];

  ngOnInit() {
    this.servicio.getInstrumentosAdmin().subscribe((data) => {
      for (let instrumento in data) {
        // console.log(data[instrumento]);
        this.instrumentos.push(data[instrumento]);
      }
    });
  }

  delete(id: string) {
    let accion = confirm("¿Está seguro de eliminar este producto?");
    accion
      ? this.servicio.delete(id).subscribe((data) => {
          console.log(data);
          location.reload();
        })
      : "";
  }

  public abreFormulario() {
    this.router.navigate(["/formulario"]);
  }

  public abreFormularioMod(id) {
    this.router.navigate(["/formulario/" + id]);
  }
}
