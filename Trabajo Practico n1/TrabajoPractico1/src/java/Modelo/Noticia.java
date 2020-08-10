/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Data.NoticiaDAO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Georgi
 */
public class Noticia {

    private int id;
    private String titulo;
    private String resumen;
    private String imagen;
    private String contenidoHTML;
    private boolean publicada;
    private LocalDate fechaPublicacion;
    private int idEmpresa;
    private Empresa empresa;
    private NoticiaDAO datos = new NoticiaDAO();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getContenidoHTML() {
        return contenidoHTML;
    }

    public void setContenidoHTML(String contenidoHTML) {
        this.contenidoHTML = contenidoHTML;
    }

    public boolean isPublicada() {
        return publicada;
    }

    public void setPublicada(boolean publicada) {
        this.publicada = publicada;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public void altaNoticia(Noticia noticia) {
        this.datos.altaNoticia(noticia);
    }

    public void modificacionNoticia(Noticia noticia) {
        this.datos.modificacionNoticia(noticia);
    }

    public void bajaNoticia(int id) {
        this.datos.bajaNoticia(id);
    }

    public List<Noticia> filtrarNoticias(List<String> parametrosBusqueda, String id) {
        return this.datos.filtrarNoticias(parametrosBusqueda, id);
    }

    public ArrayList<Noticia> ultimasNoticias(int id) {
        ArrayList<Noticia> noticias = datos.ultimasNoticias(id);
        return noticias;
    }

    public Empresa traeEmpresaXidNot(int id) {

        return this.datos.traeEmpresaXIdNot(id);
    }

    public Noticia traeNoticia(int id) {
        return this.datos.traeNoticia(id);
    }
}
