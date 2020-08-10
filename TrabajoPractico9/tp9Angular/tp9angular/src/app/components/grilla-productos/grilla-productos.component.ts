import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';
import { ServicioService } from 'src/app/servicios/servicio.service';
import { Instrumento } from 'src/app/entidades/Instrumento';

@Component({
  selector: 'app-grilla-productos',
  templateUrl: './grilla-productos.component.html',
  styleUrls: ['./grilla-productos.component.css']
})
export class GrillaProductosComponent implements OnInit {
  instrumentosArray:Instrumento[] =[];
  constructor(private servicio:ServicioService, private router:Router) { }

  ngOnInit(): void {
    this.servicio.getInstrumentos()
    .subscribe(data => {
      console.log(data);
      for(let instru in data){
        //console.log(data[instru]);
        this.instrumentosArray.push(data[instru]);
      }
     
    });

    
  }

}
