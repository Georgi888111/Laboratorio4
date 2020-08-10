/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Empresa;
import Modelo.Noticia;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Georgi
 */
@WebServlet(name = "ServletNoticia", urlPatterns = {"/ServletNoticia"})
public class ServletNoticia extends HttpServlet {

    private Noticia noticia = new Noticia();
    private Empresa empresa = new Empresa();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        String url = "";
        String accion = request.getParameter("accion");
        String idEmpresa = request.getParameter("idEmpresa");
        String idNoticia = request.getParameter("idNoticia");
        request.setAttribute("idEmpresa", idEmpresa);
        request.setAttribute("idNoticia", idNoticia);
        request.setAttribute("empresa", this.empresa.traeUnaEmpresa(Integer.parseInt(idEmpresa)));
        request.setAttribute("noticia", this.noticia.traeNoticia(noticia.getId()));

        boolean publicada;
        if (!accion.equals("buscar") && !accion.equals("B")) {
            String titulo = request.getParameter("titulo");
            String resumen = request.getParameter("resumen");
            String imagenAux = request.getParameter("imagen");
            String imagen = "images/" + imagenAux;
            String contenido = request.getParameter("contenido");
            publicada = request.getParameter("publicada").equals("on");
            String fechaString = request.getParameter("fecha");
            String[] fechasStrings = fechaString.split("-");
            Integer anio = Integer.parseInt(fechasStrings[0]);
            Integer mes = Integer.parseInt(fechasStrings[1]);
            Integer dia = Integer.parseInt(fechasStrings[2]);
            LocalDate fechaPublicacion = LocalDate.of(anio, mes, dia);

            this.noticia.setTitulo(titulo);
            this.noticia.setResumen(resumen);
            this.noticia.setImagen(imagen);
            this.noticia.setContenidoHTML(contenido);
            this.noticia.setPublicada(publicada);
            this.noticia.setFechaPublicacion(fechaPublicacion);
            this.noticia.setIdEmpresa(Integer.parseInt(idEmpresa));
        }
        switch (accion) {
            case "A":
                this.noticia.altaNoticia(this.noticia);
                url = "/home.jsp";
                break;
            case "M":
                this.noticia.setId(Integer.parseInt(idNoticia));
                this.noticia.modificacionNoticia(this.noticia);
                url = "/detalle.jsp";
                break;
            case "B":
                this.noticia.bajaNoticia(Integer.parseInt(idNoticia));
                url = "/home.jsp";
                break;
            case "buscar":
                List<String> parametrosBusqueda = (List<String>) Arrays.asList(request.getParameter("s").split(" "));
                request.setAttribute("resultados", this.noticia.filtrarNoticias(parametrosBusqueda, idEmpresa));
                url = "/buscador.jsp";
        }

       
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public ArrayList<Noticia> ultimasNoticias(int id) {
        return this.noticia.ultimasNoticias(id);
    }

    public Empresa traeEmpresaXidNot(int id) {

        return this.noticia.traeEmpresaXidNot(id);

    }

    public Noticia traeNoticia(int id) {
        return this.noticia.traeNoticia(id);
    }
}
