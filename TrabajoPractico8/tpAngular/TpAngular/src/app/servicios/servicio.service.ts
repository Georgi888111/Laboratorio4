import { Injectable } from "@angular/core";
import * as data from "src/assets/datos/instrumentos.json";

@Injectable({
  providedIn: "root",
})
export class ServicioService {
  instrumentoFile: any = (data as any).default;

  constructor() {
    console.log("Servicio cargado");
    //console.log(this.instrumentoFile);
  }

  public getInstrumentos() {
    return this.instrumentoFile.instrumentos;
    //console.log(this.instrumentoFile.instrumentos);
  }

  public getInstrumentoXId(id: string): any {
    for (let instrumento of this.instrumentoFile.instrumentos) {
      if (instrumento.id == id) {
        console.log(instrumento);
        return instrumento;
      }
    }
  }
}
