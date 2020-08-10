/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Data.PaisDAO;

/**
 *
 * @author rocio
 */
public class Pais {
    private int codigoPais;
    private String nombrePais;
    private String capitalPais;
    private String region;
    private long poblacion;
    private double latitud;
    private double longitud;

    private PaisDAO datos = new PaisDAO();
    public Pais() {
    }

    public Pais(int codigoPais, String nombrePais, String capitalPais, String region, long poblacion, double latitud, double longitud) {
        this.codigoPais = codigoPais;
        this.nombrePais = nombrePais;
        this.capitalPais = capitalPais;
        this.region = region;
        this.poblacion = poblacion;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public int getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(int codigoPais) {
        this.codigoPais = codigoPais;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public String getCapitalPais() {
        return capitalPais;
    }

    public void setCapitalPais(String capitalPais) {
        this.capitalPais = capitalPais;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public long getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(long poblacion) {
        this.poblacion = poblacion;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }
    
    public Pais traeUnPais(int codigoPais){
        return datos.traeUnPais(codigoPais);
    }
    
    public void altaPais(Pais pais){
        datos.altaPais(pais);
    }
    
    public void updatePais(Pais pais){
        datos.updatePais(pais);
    }
}
