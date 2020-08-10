/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Modelo.Pais;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author rocio
 */
public class PaisDAO {
    Conexion conexion = new Conexion();

    public PaisDAO() {
        conexion.estableceConexion();
    }
    
    public void altaPais(Pais pais) {

        String sql = "INSERT INTO pais (codigoPais, nombrePais, capitalPais, region, poblacion, latitud, longitud)"
                + " VALUES (?,?,?,?,?,?,?)";
        try {
            this.conexion.consulta = this.conexion.conn.prepareStatement(sql);
            conexion.consulta.setInt(1, pais.getCodigoPais());
            conexion.consulta.setString(2, pais.getNombrePais());
            conexion.consulta.setString(3, pais.getCapitalPais());
            conexion.consulta.setString(4, pais.getRegion());
            conexion.consulta.setLong(5, pais.getPoblacion());
            conexion.consulta.setDouble(6, pais.getLatitud());
            conexion.consulta.setDouble(7, pais.getLongitud());
            

            this.conexion.consulta.execute();
         
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Error alta "+pais.getNombrePais());
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        }
       
    }
    
    public Pais traeUnPais(int codigoPais){
        
            try {
                this.conexion.consulta = this.conexion.conn.prepareStatement("SELECT * FROM pais WHERE codigoPais=" + codigoPais);
                ResultSet hojadeResultados = this.conexion.consulta.executeQuery();
                
            while (hojadeResultados.next()) {  
                Pais pais = new Pais();
                pais.setCodigoPais(hojadeResultados.getInt(1));
                pais.setNombrePais(hojadeResultados.getString(2));
                pais.setCapitalPais(hojadeResultados.getString(3));
                pais.setRegion(hojadeResultados.getString(4));
                pais.setPoblacion(hojadeResultados.getLong(5));
                pais.setLatitud(hojadeResultados.getDouble(6));
                pais.setLongitud(hojadeResultados.getDouble(7));
                return pais;
               
            }
            }catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error trae pais");
           Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        }         
        
        return null;
    }



public void updatePais(Pais pais) {
        String sql = "UPDATE pais SET nombrePais=?,capitalPais=?,region=?,poblacion=?, Latitud=?, Longitud=? WHERE codigoPais=" + pais.getCodigoPais();
                
        try {
            this.conexion.consulta = this.conexion.conn.prepareStatement(sql);
         
            conexion.consulta.setString(1, pais.getNombrePais());
            conexion.consulta.setString(2, pais.getCapitalPais());
            conexion.consulta.setString(3, pais.getRegion());
            conexion.consulta.setLong(4, pais.getPoblacion());
            conexion.consulta.setDouble(5, pais.getLatitud());
            conexion.consulta.setDouble(6, pais.getLongitud());

            this.conexion.consulta.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error trae update");
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        }
     
    }
}