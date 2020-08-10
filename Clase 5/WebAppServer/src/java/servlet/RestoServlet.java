/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entidad.Plato;
import gestor.PlatoManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.output.*;


/**
 *
 * @author Gerardo
 */
@WebServlet(name = "RestoServlet", urlPatterns = {"/RestoServlet"})
public class RestoServlet extends HttpServlet {

    
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
        
        response.setContentType("application/json");
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me");
        
        PrintWriter out = response.getWriter();
        String respuestaServer = "";
        try {
            
            mostrarElementos(request, response);
            if(request.getParameter("action") != null){
                System.out.println("ACTION " + request.getParameter("action"));
                if(request.getParameter("action").equals("listar")){
                    PlatoManager me = new PlatoManager();
                    List<Plato> platos = me.getPlatosDataBase();
                    Gson gsonBuilder = new GsonBuilder().create();
                    String platosJson = gsonBuilder.toJson(platos);
                    respuestaServer = platosJson;
                }else if(request.getParameter("action").equals("buscar")){
                    PlatoManager me = new PlatoManager();
                    List<Plato> platos = new ArrayList<Plato>();
                    Plato plato = me.getPlatoDataBaseXId(Long.parseLong(request.getParameter("idPlato"))); 
                    platos.add(plato);
                    Gson gsonBuilder = new GsonBuilder().create();
                    String platosJson = gsonBuilder.toJson(plato);
                    respuestaServer = platosJson;
                }else if(request.getParameter("action").equals("insertar")){
                    Plato plato = new Plato(request);
                    PlatoManager me = new PlatoManager();
                    Plato platoNuevo = me.insertarPlato(plato);
                    Gson gsonBuilder = new GsonBuilder().create();
                    String platoJson = gsonBuilder.toJson(platoNuevo);
                    respuestaServer = platoJson;
                }else if(request.getParameter("action").equals("actualizar")){
                    Plato plato = new Plato(request);
                    PlatoManager me = new PlatoManager();
                    Plato platoModificado = me.actualizarPlato(plato);
                    Gson gsonBuilder = new GsonBuilder().create();
                    String platoJson = gsonBuilder.toJson(platoModificado);
                    respuestaServer = platoJson;
                }else if(request.getParameter("action").equals("eliminar")){
                    PlatoManager me = new PlatoManager();
                    me.eliminarPlato(Long.parseLong(request.getParameter("idPlato")));
                    List<Plato> platos = me.getPlatosDataBase();
                    Gson gsonBuilder = new GsonBuilder().create();
                    String platosJson = gsonBuilder.toJson(platos);
                    respuestaServer = platosJson;
                }else if(request.getParameter("action").equals("sumar")){
                    int resultado = Integer.parseInt(request.getParameter("nro1")) + Integer.parseInt(request.getParameter("nro2"));
                    respuestaServer = Integer.toString(resultado);
                }
            
            }
            out.write(respuestaServer);
        }catch(Exception ex){
            ex.printStackTrace();
        } finally {
            out.close();
        }
    }
    
    private void mostrarElementos(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException{
        try { 
            boolean isMultipart = ServletFileUpload.isMultipartContent(request);
            response.setContentType("text/html");
            
            if(!isMultipart ) {
                System.out.println("NO ES MULTIPART");
                return;
            }

            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);

        
           // Parse the request to get file items.
           List fileItems = upload.parseRequest(request);

           // Process the uploaded file items
           Iterator i = fileItems.iterator();

           while ( i.hasNext () ) {
                FileItem fi = (FileItem)i.next();
                // Get the uploaded file parameters
                String fieldName = fi.getFieldName();
                String value = fi.getString();
                System.out.println("FieldName: " + fieldName);
                System.out.println("VALOR: " + value);
           }
           
           } catch(Exception ex) {
              System.out.println(ex);
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
        processRequest(request, response);
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

}
