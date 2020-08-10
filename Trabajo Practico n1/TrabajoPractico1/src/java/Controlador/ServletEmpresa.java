/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Data.EmpresaDAO;
import Modelo.Empresa;
import Modelo.Noticia;
import java.io.IOException;
import java.io.PrintWriter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author Georgi
 */
@WebServlet(name = "ServletEmpresa", urlPatterns = {"/ServletEmpresa"})
public class ServletEmpresa extends HttpServlet {

  EmpresaDAO empresadao = new EmpresaDAO();
  Empresa empresa = new Empresa();    
 String idEmpresa;
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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletEmpresa</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletEmpresa at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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

         String url = "";
          String accion = request.getParameter("accion");
          
//           idEmpresa= request.getParameter("idEmpresa");
//           request.setAttribute("idEmpresa", idEmpresa);
        
          
             
      
        if (accion.equalsIgnoreCase("A")) {

            String horaInicio = request.getParameter("horaI");
            String horaFin = request.getParameter("horaF");

         
            empresa.setDenominacion(request.getParameter("denominacion"));
            empresa.setTelefono(request.getParameter("telefono"));
            empresa.setHorarioAtencion(horaInicio + " - " + horaFin);
            empresa.setQuienesSomos(request.getParameter("descripcion"));
            empresa.setLatitud(Double.parseDouble(request.getParameter("latitud")));
            empresa.setLongitud(Double.parseDouble(request.getParameter("longitud")));
            empresa.setDomicilio(request.getParameter("domicilio"));
            empresa.setEmail(request.getParameter("email"));
            empresadao.altaEmpresa(empresa);
            idEmpresa = String.valueOf(this.empresadao.retornaIdEmpresa(request.getParameter("denominacion")));
            request.setAttribute("idEmpresa", idEmpresa);
             url = "/home.jsp";
       }else{
           if(accion.equalsIgnoreCase("M")){
        
               
           String horaInicio = request.getParameter("horaI");
           String horaFin = request.getParameter("horaF");         
           
         
           empresa.setId(Integer.parseInt(request.getParameter("idEmpresa")));
           empresa.setDenominacion(request.getParameter("denominacion"));
           empresa.setTelefono(request.getParameter("telefono"));
           empresa.setHorarioAtencion(horaInicio + " - " +horaFin);
           empresa.setQuienesSomos(request.getParameter("descripcion"));
           empresa.setLatitud(Double.parseDouble(request.getParameter("latitud")));
           empresa.setLongitud(Double.parseDouble(request.getParameter("longitud")));
           empresa.setDomicilio(request.getParameter("domicilio"));
           empresa.setEmail(request.getParameter("email"));
           empresadao.modificarEmpresa(empresa);
           idEmpresa= request.getParameter("idEmpresa");
           request.setAttribute("idEmpresa", idEmpresa);
           url = "/home.jsp";
           
           
            
           }else{
                int id = Integer.parseInt(request.getParameter("idEmpresa"));
               
                LocalDate fechaBaja = LocalDate.now();
                empresadao.bajaEmpresa(fechaBaja, id);
                idEmpresa= request.getParameter("idEmpresa");
                request.setAttribute("idEmpresa", idEmpresa);
                url = "/index.jsp";
           }
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

    public List<Empresa> traeEmpresa(){
        return empresa.traeEmpresa();
    }
    public Empresa traeUnaEmpresa(int id){
        return empresa.traeUnaEmpresa(id);
    }
    public ArrayList<Noticia> cargaNoticias(int id){
        ServletNoticia noticia = new ServletNoticia();
        return noticia.ultimasNoticias(id);               
    }
    }
