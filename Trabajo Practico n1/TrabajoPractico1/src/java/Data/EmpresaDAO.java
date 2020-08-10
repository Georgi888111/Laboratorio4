/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Modelo.Empresa;
import java.sql.Date;
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
public class EmpresaDAO {

    Conexion conexion = new Conexion();

    public EmpresaDAO() {
        conexion.estableceConexion();
    }

    public void altaEmpresa(Empresa empresa) {

        String sql = "INSERT INTO empresa (Denominacion, Telefono, Horario, QuienesSomos, Latitud, Longitud, Domicilio, Email)"
                + " VALUES (?,?,?,?,?,?,?,?)";
        try {
            this.conexion.consulta = this.conexion.conn.prepareStatement(sql);
            conexion.consulta.setString(1, empresa.getDenominacion());
            conexion.consulta.setString(2, empresa.getTelefono());
            conexion.consulta.setString(3, empresa.getHorarioAtencion());
            conexion.consulta.setString(4, empresa.getQuienesSomos());
            conexion.consulta.setDouble(5, empresa.getLatitud());
            conexion.consulta.setDouble(6, empresa.getLongitud());
            conexion.consulta.setString(7, empresa.getDomicilio());
            conexion.consulta.setString(8, empresa.getEmail());

            this.conexion.consulta.execute();
         
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        }
       
    }
    
    public List<Empresa> traeEmpresa(){
        List<Empresa> empresas = new ArrayList<Empresa>();
            try {
                this.conexion.consulta = this.conexion.conn.prepareStatement("SELECT * FROM Empresa Where FechaBaja is null;");
                ResultSet hojadeResultados = this.conexion.consulta.executeQuery();

            while (hojadeResultados.next()) {
                Empresa empresa = new Modelo.Empresa();
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
                empresas.add(empresa);
            }
            }catch (SQLException e) {
           Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        }            
     
        return empresas;
    }

    public void modificarEmpresa(Empresa empresa) {
        String sql = "UPDATE empresa SET Denominacion=?,Telefono=?,Horario=?,QuienesSomos=?, Latitud=?, Longitud=?, Domicilio=? , Email =? WHERE idEmpresa=" + empresa.getId();
                
        try {
            this.conexion.consulta = this.conexion.conn.prepareStatement(sql);
         
            conexion.consulta.setString(1, empresa.getDenominacion());
            conexion.consulta.setString(2, empresa.getTelefono());
            conexion.consulta.setString(3, empresa.getHorarioAtencion());
            conexion.consulta.setString(4, empresa.getQuienesSomos());
            conexion.consulta.setDouble(5, empresa.getLatitud());
            conexion.consulta.setDouble(6, empresa.getLongitud());
            conexion.consulta.setString(7, empresa.getDomicilio());
            conexion.consulta.setString(8, empresa.getEmail());

            this.conexion.consulta.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        }
     
    }
    
    
       public void bajaEmpresa(LocalDate fechaBaja, int id) {

        String sql =  "UPDATE empresa SET FechaBaja = ? WHERE idEmpresa=" + id;
              
        try {
         this.conexion.consulta = this.conexion.conn.prepareStatement(sql);
         Date fecha = Date.valueOf(fechaBaja);
         conexion.consulta.setDate(1, fecha);
            this.conexion.consulta.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        }
   
    }
       
       public Empresa traeUnaEmpresa(int idEmpresa){
        Empresa empresa = new Empresa();
            try {
                this.conexion.consulta = this.conexion.conn.prepareStatement("SELECT * FROM Empresa WHERE idEmpresa=" + idEmpresa);
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
            }catch (SQLException e) {
           Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        }         
        
        return empresa;
    }
       
         public int retornaIdEmpresa(String denominacion) {
        this.conexion.estableceConexion();
        int idEmpresa = 0;
        try {
            this.conexion.consulta = this.conexion.conn.prepareStatement("SELECT idEmpresa from empresa where Denominacion = '"+denominacion+"'");
            ResultSet rs = this.conexion.consulta.executeQuery();
            while (rs.next()) {
                idEmpresa = rs.getInt("idEmpresa");
            }
        } catch (SQLException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        }
        return idEmpresa;
    }
}
