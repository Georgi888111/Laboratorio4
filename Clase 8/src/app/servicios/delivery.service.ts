import { Injectable } from '@angular/core';
import  *  as  data  from  'src/assets/datos/platos.json'

@Injectable({
  providedIn: 'root'
})
export class DeliveryService {

  platosFile:any  = (data  as  any).default;

  constructor() {
    console.log("Servicio Cargado!!!");
    console.log(this.platosFile);
   }
   
  public getPlatos():any[]{
    return this.platosFile.platos;
    console.log(this.platosFile.platos);
  }

  public getPlatoXId(idx:string):any{
      for(let plato of this.platosFile.platos){
          if(plato.id == idx){
            return plato;
          } 
      }
  }

  public buscarPlatos(termino:string):any[]{
      let platosArr:any[] = [];
      termino = termino.toLowerCase();

      for(let plato of this.platosFile.platos){
        let nombre = plato.nombre.toLowerCase();
        if(nombre.indexOf(termino) >= 0){
          platosArr.push(plato);
        }

      }
      return platosArr;
    }
}


