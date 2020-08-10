import { Injectable } from "@angular/core";
import { HttpClient, HttpParams, HttpHeaders } from "@angular/common/http";
import { map } from "rxjs/operators";
import { Instrumento } from "../entidades/Instrumento";

@Injectable({
  providedIn: "root",
})
export class ServicioService {
  public instrumentos: Instrumento[] = [];
  httpOptions = {
    headers: new HttpHeaders({
      "Content-Type": "application/json",
      "Access-Control-Allow-Origins": "*",
      "Access-Control-Allow-Methods": [
        "GET",
        "OPTIONS",
        "POST",
        "PUT",
        "DELETE",
      ],
      "Access-Control-Allow-Headers": "Content-Type",
      "cache-control": "no-cache",
      Authorization: "my-auth-token",
    }),
  };
  httpOptionsImage = {
    headers: new HttpHeaders({
      'Accept': 'text/plain;charset=UTF-8',      
      
      "Access-Control-Allow-Origins": "*",                   
      "cache-control": "no-cache",
    }),
  };
  constructor(public http: HttpClient) {}

  getInstrumentos() {
    const ins = this.http
      .get("http://localhost:9002/api/v1/instrumento/")
      .pipe(map((instrumentos) => instrumentos));
    return ins;
  }

  getInstrumentosXId(id: string) {
    return this.http
      .get("http://localhost:9002/api/v1/instrumento/" + id)
      .pipe(map((instrumento) => instrumento));
  }

  getInstrumentosAdmin() {
    const ins = this.http
      .get("http://localhost:9002/api/v1/instrumento/all")
      .pipe(map((instrumentos) => instrumentos));
    return ins;
  }

  instrumentoUrl: string = "http://localhost:9002/api/v1/instrumento/";
  nuevo(instrumentoNuevo: Instrumento) {
    console.log(instrumentoNuevo);

    return this.http.post<Instrumento>(
      this.instrumentoUrl,
      instrumentoNuevo,
      this.httpOptions
    );
  }

  update(instrumentoUpdate: Instrumento) {
    const url =
      "http://localhost:9002/api/v1/instrumento/" + instrumentoUpdate.id;
    return this.http.put<Instrumento>(url, instrumentoUpdate, this.httpOptions);
  }

  subeImagen(fileUpload) {
    console.log(fileUpload);
    const url = "http://localhost:9002/api/v1/instrumento/upload";
    const formData: FormData = new FormData();
    formData.append("file", fileUpload);
    console.log(formData.get.length);

    return this.http.post(url, formData, this.httpOptionsImage).subscribe((val) => {

      console.log(val);
      });
      return false; 
  }

  delete(id: string) {
    const options = {
      headers: new HttpHeaders({
        "Content-Type": "application/json",
      }),
      body: {
        id: id,
      },
    };
    const url = "http://localhost:9002/api/v1/instrumento/" + id;
    return this.http.delete<Instrumento>(url, options);
  }
}
