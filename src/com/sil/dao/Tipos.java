/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sil.dao;

import java.awt.image.ImageObserver;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Clase Tipos: Esta clase permite el uso de la tabla tipoproductos de la
 base de datos.
 *
 *
 * @author Adrian
 */
public class Tipos {

    private final Conexion Conecta = new Conexion();
    private Connection Conector;
    private Statement St;
    private ResultSet Rs;

    /**
     * Metodo CerrarConsultas: Este metodo permite cerrar consultas y conexion
     * sí existen.
     *
     */
    public void CerrarConsultas() {
        try {
            if (Rs != null) {
                Rs.close();
            }
            if (St != null) {
                St.close();
            }
            if (Conector != null) {
                Conector.close();
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Error cerrando la conexion!", "Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Licorerias.class.getName()).log(Level.SEVERE, null, sqle);
        }
    }

    /**
     * Este metodo muestra la lista de tipos almacenadas en la BD
     *
     * @return tipo
     */
    public String ConsultaTipo() {

        String tipo = null;
        String Query = "SELECT descripcionTipo FROM sil.tipoproductos";

        try {
            // Conexion con BBDD
            Conector = Conecta.Conectar();
            St = Conector.createStatement();
            // Consulta
            Rs = St.executeQuery(Query);
            while (Rs.next()) {
                Rs.getString("descripcionTipo");
                Rs.close();
                Conector.close();
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Error en la consulta", "Error en la consulta", ImageObserver.ERROR);
            Logger.getLogger(Licorerias.class.getName()).log(Level.SEVERE, null, sqle);
        }
        return tipo;
    }// Cierre del metodo

    /**
     * Permite elimiar registros de la base de datos.
     *
     * @param descripcionTipo recibe la descripcion del tipo de producto
     */
    public void EliminarTipo(String descripcionTipo) {

        String Query = "DELETE FROM tipoproductos WHERE `descripcionTipo`='" + descripcionTipo + "';";

        try {
            Conector = Conecta.Conectar();
            // Se crea la sentencia
            St = Conector.createStatement();
            // Se ejecuta la sentencia
            St.executeUpdate(Query);
            JOptionPane.showMessageDialog(null, "Registro Eliminado con exito");
            // Se liberan recursos
            St.close();
            Conector.close();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el registro");
            Logger.getLogger(Licorerias.class.getName()).log(Level.SEVERE, null, sqle);
        }
    } // Cierre del metodo

    /**
     * Este metodo agregara registros a la base de datos.
     *
     * @param descripcionTipo recibe la descripcion del tipo de producto
     */
    public void RegistrarTipo(String descripcionTipo) {

        String Query = "INSERT INTO `sil`.`tipoproductos` (`descripcionTipo`) VALUES ('" + descripcionTipo + "');";

        try {
            // Se establece la conexion
            Conector = Conecta.Conectar();
            // Se crea la sentencia
            St = Conector.createStatement();
            // Se ejecuta la sentencia
            St.executeUpdate(Query);
            JOptionPane.showMessageDialog(null, "Registro exitoso");
            // Se liberan recursos
            St.close();
            Conector.close();
            // -----En Desarrollo-----Si ya existe un registro con el mismo
            // nombre
            /* if (Rs.get) { */
            // St.executeUpdate(Query);
            /*
			 * } else { JOptionPane.showMessageDialog(null,
			 * "Ya existe una empresa con el mismo nombre, debe ingresar otro nombre"
			 * );
             */
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Error al registrar!");
            Logger.getLogger(Licorerias.class.getName()).log(Level.SEVERE, null, sqle);
        }
    }// Cierre del metodo

}
