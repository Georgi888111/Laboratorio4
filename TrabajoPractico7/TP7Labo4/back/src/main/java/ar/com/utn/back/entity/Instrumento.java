package ar.com.utn.back.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Instrumento {

	private int id;
	private String instrumento;
	private String marca;
	private String modelo;
	private String imagen;
	private double precio;
	private String costoEnvio;
	private String cantidadVendida;
	private String descripcion;
	private boolean estaHabilitado;

	public Instrumento() {

	}

	public Instrumento(int id, String instrumento, String marca, String modelo, String imagen, double precio,
			String costoEnvio, String cantidadVendida, String descripcion, boolean estaHabilitado) {
		this.id = id;
		this.instrumento = instrumento;
		this.marca = marca;
		this.modelo = modelo;
		this.imagen = imagen;
		this.precio = precio;
		this.costoEnvio = costoEnvio;
		this.cantidadVendida = cantidadVendida;
		this.descripcion = descripcion;
		this.estaHabilitado = estaHabilitado;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", insertable = false, nullable = false, updatable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "instrumento", nullable = false)
	public String getInstrumento() {
		return instrumento;
	}

	public void setInstrumento(String instrumento) {
		this.instrumento = instrumento;
	}

	@Column(name = "marca", nullable = false)
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Column(name = "modelo", nullable = false)
	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Column(name = "imagen", nullable = false)
	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Column(name = "precio", nullable = false)
	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Column(name = "costoEnvio", nullable = false)
	public String getCostoEnvio() {
		return costoEnvio;
	}

	public void setCostoEnvio(String costoEnvio) {
		this.costoEnvio = costoEnvio;
	}

	@Column(name = "cantidadVendida", nullable = false)
	public String getCantidadVendida() {
		return cantidadVendida;
	}

	public void setCantidadVendida(String cantidadVendida) {
		this.cantidadVendida = cantidadVendida;
	}

	@Column(name = "descripcion", nullable = false)
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "estaHabilitado", nullable = false)
	public boolean isEstaHabilitado() {
		return estaHabilitado;
	}

	public void setEstaHabilitado(boolean estaHabilitado) {
		this.estaHabilitado = estaHabilitado;
	}
}
