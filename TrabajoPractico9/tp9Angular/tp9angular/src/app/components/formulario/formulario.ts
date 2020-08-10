import { Component, OnInit } from "@angular/core";
import { Instrumento } from "src/app/entidades/Instrumento";
import { ServicioService } from "src/app/servicios/servicio.service";
import { Router } from "@angular/router";
import { ActivatedRoute, Params } from "@angular/router";

@Component({
  selector: "app-formulario",
  templateUrl: "./formulario.html",
  styleUrls: ["./formulario.css"],
})
export class Formulario implements OnInit {
  constructor(
    private servicio: ServicioService,
    private router: Router,
    private rutaActiva: ActivatedRoute
  ) {}
  fileToUpload: File = null;
  instrumento: Instrumento = {
    id: "",
    instrumento: "",
    marca: "",
    modelo: "",
    precio: "",
    descripcion: "",
    cantidadVendida: "",
    precioEnvio: "",
    urlImagen: "",
    estaHabilitado: "",
  };

  ngOnInit() {
    this.traerInstrumento();
  }

  traerInstrumento() {
    const parametroId = this.rutaActiva.snapshot.params.id;
    if (parametroId != undefined) {
      this.servicio.getInstrumentosXId(parametroId).subscribe((data) => {
        this.instrumento = data as Instrumento;
      });
    }
  }

  handleFileInput(file: FileList) {
    this.fileToUpload = file.item(0);
  }
  agregar() {
    const parametroId = this.rutaActiva.snapshot.params.id;
    if (parametroId == undefined) {
      this.servicio.subeImagen(this.fileToUpload);

      this.instrumento.urlImagen = this.fileToUpload.name;

      this.servicio.nuevo(this.instrumento).subscribe((data) => {
        if (data && data.id) {
          this.router.navigate(["/listar"]);
        }
      });
    } else {
      this.instrumento.urlImagen = this.fileToUpload.name;
      this.servicio.subeImagen(this.fileToUpload);
      this.servicio.update(this.instrumento).subscribe((data) => {
        if (data && data.id) {
          console.log("Agregado");
          this.router.navigate(["/listar"]);
        }
      });
    }
  }
}
