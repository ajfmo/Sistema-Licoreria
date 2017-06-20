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
 * Clase Tipos: Esta clase permite el uso de la tabla tipoproductos de la base
 * de datos.
 *
 *
 * @author Adrian
 */
public class Tipos {

    private final Conexion conecta = new Conexion();
    private Connection conector;
    private Statement statement;
    private ResultSet resultSet;

    /**
     * Metodo cerrarConsultas: Este metodo permite cerrar consultas y conexion
     * sí existen.
     *
     */
    public void cerrarConsultas() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (conector != null) {
                conector.close();
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
    public String consultarTipo() {

        String tipo = null;
        String Query = "SELECT descripcionTipo FROM sil.tipoproductos";

        try {
            // Conexion con BBDD
            conector = conecta.conectar();
            statement = conector.createStatement();
            // Consulta
            resultSet = statement.executeQuery(Query);
            while (resultSet.next()) {
                resultSet.getString("descripcionTipo");
                resultSet.close();
                conector.close();
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
    public void eliminarTipo(String descripcionTipo) {

        String Query = "DELETE FROM tipoproductos WHERE `descripcionTipo`='" + descripcionTipo + "';";

        try {
            conector = conecta.conectar();
            // Se crea la sentencia
            statement = conector.createStatement();
            // Se ejecuta la sentencia
            statement.executeUpdate(Query);
            JOptionPane.showMessageDialog(null, "Registro Eliminado con exito");
            // Se liberan recursos
            statement.close();
            conector.close();
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
    public void registrarTipo(String descripcionTipo) {

        String Query = "INSERT INTO `sil`.`tipoproductos` (`descripcionTipo`) VALUES ('" + descripcionTipo + "');";

        try {
            // Se establece la conexion
            conector = conecta.conectar();
            // Se crea la sentencia
            statement = conector.createStatement();
            // Se ejecuta la sentencia
            statement.executeUpdate(Query);
            JOptionPane.showMessageDialog(null, "Registro exitoso");
            // Se liberan recursos
            statement.close();
            conector.close();
            // -----En Desarrollo-----Si ya existe un registro con el mismo
            // nombre
            /* if (resultSet.get) { */
            // statement.executeUpdate(Query);
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
