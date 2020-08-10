/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Modelo.Empresa;
import Modelo.Noticia;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Georgi
 */
public class NoticiaDAO {

    Conexion conexion = new Conexion();

    public NoticiaDAO() {

        conexion.estableceConexion();
    }

    public void altaNoticia(Noticia noticia) {

        try {
            this.conexion.consulta = this.conexion.conn.prepareStatement("INSERT INTO noticia (Titulo, Resumen, Imagen, Html, Publicada, Fecha, idEmpresa)"
                    + " VALUES (?,?,?,?,?,?,?)");
            conexion.consulta.setString(1, noticia.getTitulo());
            conexion.consulta.setString(2, noticia.getResumen());
            conexion.consulta.setString(3, noticia.getImagen());
            conexion.consulta.setString(4, noticia.getContenidoHTML());
            if (noticia.isPublicada()) {
                conexion.consulta.setString(5, "Y");
            } else {
                conexion.consulta.setString(5, "N");
            }

            java.sql.Date fechaPublicacion = java.sql.Date.valueOf(noticia.getFechaPublicacion());
            conexion.consulta.setDate(6, fechaPublicacion);
            conexion.consulta.setInt(7, noticia.getIdEmpresa());

            this.conexion.consulta.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);

        }
    }

    public void modificacionNoticia(Noticia noticia) {

        try {
            this.conexion.consulta = this.conexion.conn.prepareStatement("UPDATE Noticia SET Titulo=?, Resumen=?, Imagen=?, Html=?, Publicada=?, Fecha=?"
                    + " WHERE idNoticia=" + noticia.getId());
            conexion.consulta.setString(1, noticia.getTitulo());
            conexion.consulta.setString(2, noticia.getResumen());
            conexion.consulta.setString(3, noticia.getImagen());
            conexion.consulta.setString(4, noticia.getContenidoHTML());
            if (noticia.isPublicada()) {
                conexion.consulta.setString(5, "Y");
            } else {
                conexion.consulta.setString(5, "N");
            }

            java.sql.Date fechaPublicacion = java.sql.Date.valueOf(noticia.getFechaPublicacion());
            conexion.consulta.setDate(6, fechaPublicacion);

            this.conexion.consulta.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void bajaNoticia(int id) {

        try {
            this.conexion.consulta = this.conexion.conn.prepareStatement("UPDATE noticia SET Publicada=? WHERE idNoticia=" + id);

            conexion.consulta.setString(1, "N");

            this.conexion.consulta.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public List<Noticia> filtrarNoticias(List<String> parametrosBusqueda, String id) {
        List<Noticia> noticias = new ArrayList<>();
        String sql = crearSQL(parametrosBusqueda, id);
        if (sql != null) {
            try {
                this.conexion.consulta = this.conexion.conn.prepareStatement(sql + " ORDER BY Fecha DESC LIMIT 20");
                ResultSet rs = this.conexion.consulta.executeQuery();

                while (rs.next()) {
                    Noticia noticia = new Noticia();
                    noticia.setId(rs.getInt(1));
                    noticia.setTitulo(rs.getString(2));
                    noticia.setResumen(rs.getString(3));
                    noticia.setImagen(rs.getString(4));
                    noticia.setContenidoHTML(rs.getString(5));
                    String publicada = rs.getString(6);
                    if (publicada.equals("Y")) {
                        noticia.setPublicada(true);
                    } else {
                        noticia.setPublicada(false);
                    }
                    LocalDate fechaPublicacion = rs.getDate(7).toLocalDate();
                    noticia.setFechaPublicacion(fechaPublicacion);
                    noticias.add(noticia);
                }
                return noticias;
            } catch (SQLException e) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return null;
    }

    private String crearSQL(List<String> parametrosBuqueda, String id) {
        String query = null;
        if (!parametrosBuqueda.isEmpty()) {

            if (parametrosBuqueda.size() > 1) {
                int i = 0;

                for (String param : parametrosBuqueda) {
                    query = "SELECT * FROM Noticia WHERE idEmpresa=" + id + " AND (";
                    if (param != null) {
                        if (i == parametrosBuqueda.size() - 1) {

                            query += " Titulo LIKE '%" + param + "%' OR Resumen LIKE '%" + param + "%')";

                        } else {

                            query += " Titulo LIKE '%" + param + "%' OR Resumen LIKE '%" + param + "%' OR ";

                        }
                    }
                    i++;
                }
            } else {
                query = "SELECT * FROM Noticia WHERE idEmpresa=" + id + " AND (Titulo LIKE '%"
                        + parametrosBuqueda.get(0) + "%' OR Resumen LIKE '%" + parametrosBuqueda.get(0) + "%')";
            }
            return query;
        } else {
            return null;
        }
    }

    public ArrayList<Noticia> ultimasNoticias(int id) {
        ArrayList<Noticia> noticias = new ArrayList<>();
        try {
            this.conexion.consulta = this.conexion.conn.prepareStatement("SELECT * FROM Noticia WHERE idEmpresa=" + id + " AND Publicada='Y' ORDER BY Fecha DESC LIMIT 5");
            ResultSet rs = this.conexion.consulta.executeQuery();

            while (rs.next()) {
                Noticia noticia = new Noticia();
                noticia.setId(rs.getInt(1));
                noticia.setTitulo(rs.getString(2));
                noticia.setResumen(rs.getString(3));
                noticia.setImagen(rs.getString(4));
                noticia.setContenidoHTML(rs.getString(5));
                String publicada = rs.getString(6);
                if (publicada.equals("Y")) {
                    noticia.setPublicada(true);
                } else {
                    noticia.setPublicada(false);
                }
                LocalDate fechaPublicacion = rs.getDate(7).toLocalDate();
                noticia.setFechaPublicacion(fechaPublicacion);
                noticias.add(noticia);
            }
            return noticias;
        } catch (SQLException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        }

        return null;
    }

    public Empresa traeEmpresaXIdNot(int idNot) {
        int id = retornaIdEmpresa(idNot);
        Empresa empresa = new Empresa();
        try {
            this.conexion.consulta = this.conexion.conn.prepareStatement("SELECT * FROM Empresa WHERE idEmpresa=" + id);
            ResultSet hojadeResultados = this.conexion.consulta.executeQuery();

            while (hojadeResultados.next()) {
                empresa.setId(hojadeResultados.getInt(1));
                empresa.setDenominacion(hojadeResultados.getString(2));
                empresa.setTelefono(hojadeResultados.getString(3));
                empresa.setHorarioAtencion(hojadeResultados.getString(4));
                empresa.setQuienesSomos(hojadeResultados.getString(5));
                empresa.setLatitud(hojadeResultados.getDouble(6));
                empresa.setLongitud(hojadeResultados.getDouble(7));
                empresa.setDomicilio(hojadeResultados.getString(8));
                empresa.setEmail(hojadeResultados.getString(9));
                empresa.setHabilitada(hojadeResultados.getDate(10));

            }
        } catch (SQLException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        }
        return empresa;
    }

    public int retornaIdEmpresa(int id) {
        int idEmpresa = 0;
        try {
            this.conexion.consulta = this.conexion.conn.prepareStatement("SELECT idEmpresa from noticia where idNoticia= " + id);
            ResultSet rs = this.conexion.consulta.executeQuery();
            while (rs.next()) {
                idEmpresa = rs.getInt("idEmpresa");
            }
        } catch (SQLException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        }
        return idEmpresa;
    }

    public Noticia traeNoticia(int idNoticia) {
        Noticia noti = new Noticia();
        try {
            this.conexion.consulta = this.conexion.conn.prepareStatement("SELECT * FROM Noticia WHERE idNoticia=" + idNoticia);
            ResultSet hojadeResultados = this.conexion.consulta.executeQuery();

            while (hojadeResultados.next()) {
                noti.setId(hojadeResultados.getInt(1));
                noti.setTitulo(hojadeResultados.getString(2));
                noti.setResumen(hojadeResultados.getString(3));
                noti.setImagen(hojadeResultados.getString(4));
                noti.setContenidoHTML(hojadeResultados.getString(5));
                String publicada = hojadeResultados.getString(6);
                if (publicada.equals("Y")) {
                    noti.setPublicada(true);
                } else {
                    noti.setPublicada(false);
                }
                LocalDate fechaPublicacion = hojadeResultados.getDate(7).toLocalDate();
                noti.setFechaPublicacion(fechaPublicacion);
                noti.setIdEmpresa(hojadeResultados.getInt(8));
            }
        } catch (SQLException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        }
        return noti;
    }

}
