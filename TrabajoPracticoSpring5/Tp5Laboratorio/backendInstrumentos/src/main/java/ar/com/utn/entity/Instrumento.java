package ar.com.utn.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Instrumento {
	@Id
	@GeneratedValue
	(strategy = GenerationType.IDENTITY)
	 private int id;
	    private String instrumento;
	    private String marca;
	    private String modelo;
	    private String urlImagen;
	    private double precio;
	    private String precioEnvio;
	    private String cantidadVendida;
	    private String descripcion;
	     private boolean estaHabilitado;

	    public Instrumento() {
	    }

	    public Instrumento(Instrumento instrumento) {
	        this.id = instrumento.id;
	        this.instrumento = instrumento.instrumento;
	        this.marca = instrumento.marca;
	        this.modelo = instrumento.modelo;
	        this.precio = instrumento.precio;
	        this.precioEnvio = instrumento.precioEnvio;
	        this.cantidadVendida = instrumento.cantidadVendida;
	        this.descripcion = instrumento.descripcion;
	        this.urlImagen = instrumento.urlImagen;	        
	    }

	   
	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getInstrumento() {
	        return instrumento;
	    }

	    public void setInstrumento(String instrumento) {
	        this.instrumento = instrumento;
	    }

	    public String getMarca() {
	        return marca;
	    }

	    public void setMarca(String marca) {
	        this.marca = marca;
	    }

	    public String getModelo() {
	        return modelo;
	    }

	    public void setModelo(String modelo) {
	        this.modelo = modelo;
	    }

	    public String getUrlImagen() {
	        return urlImagen;
	    }

	    public void setUrlImagen(String urlImagen) {
	        this.urlImagen = urlImagen;
	    }

	    public double getPrecio() {
	        return precio;
	    }

	    public void setPrecio(double precio) {
	        this.precio = precio;
	    }

	    public String getPrecioEnvio() {
	        return precioEnvio;
	    }

	    public void setPrecioEnvio(String precioEnvio) {
	        this.precioEnvio = precioEnvio;
	    }

	    public String getCantidadVendida() {
	        return cantidadVendida;
	    }

	    public void setCantidadVendida(String cantidadVendida) {
	        this.cantidadVendida = cantidadVendida;
	    }

	    public String getDescripcion() {
	        return descripcion;
	    }

	    public void setDescripcion(String descripcion) {
	        this.descripcion = descripcion;
	    }
	 public boolean isEstaHabilitado() {
	        return estaHabilitado;
	    }

	    public void setEstaHabilitado(boolean estaHabilitado) {
	        this.estaHabilitado = estaHabilitado;
	    }
}
