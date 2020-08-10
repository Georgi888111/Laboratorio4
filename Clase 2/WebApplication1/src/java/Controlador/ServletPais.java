/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Pais;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author rocio
 */
@WebServlet(name = "ServletPais", urlPatterns = {"/ServletPais"})
public class ServletPais extends HttpServlet {

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
            out.println("<title>Servlet ServletPais</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Datos cargados</h1>");
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
        processRequest(request, response);
        JSONParser parser = new JSONParser();

        try {
            for (int codigo = 1; codigo <= 300; codigo++) {
                String urlParaVisitar = "https://restcountries.eu/rest/v2/callingcode/" + codigo;

                StringBuilder resultado = new StringBuilder();
                URL url = new URL(urlParaVisitar);

                HttpURLConnection conexion = (HttpURLConnection) url.openConnection();

                conexion.setRequestMethod("GET");

                if (conexion.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    try (BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream()));) {
                        String linea;
                        while ((linea = rd.readLine()) != null) {
                            resultado.append(linea);
                        }
                        rd.close();
                    }
                } else {
                    continue;
                }
                Object obj = parser.parse(resultado.toString());

                JSONArray paises = (JSONArray) obj;

                for (int i = 0; i < paises.size(); i++) {
                    Pais pais = new Pais();

                    JSONObject paisJson = (JSONObject) paises.get(i);

                    pais.setNombrePais(paisJson.get("name").toString());
                    pais.setCapitalPais(paisJson.get("capital").toString());
                    pais.setRegion(paisJson.get("region").toString());
                    pais.setPoblacion(Long.parseLong(paisJson.get("population").toString()));
                    String cadena = paisJson.get("latlng").toString();
                    cadena = cadena.replaceAll("[\\(\\)\\[\\]\\{\\}]", "");
                    String[] latLong = cadena.split(",");
                    pais.setLatitud(Double.parseDouble(latLong[0]));
                    pais.setLongitud(Double.parseDouble(latLong[1]));
                    pais.setCodigoPais(Integer.parseInt(paisJson.get("numericCode").toString()));
                    Pais paisAux = pais.traeUnPais(pais.getCodigoPais());
                    if (paisAux != null) {
                        pais.updatePais(pais);

                    } else {
                        pais.altaPais(pais);

                    }
                }

            }

        } catch (Exception e) {
            
        }

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
