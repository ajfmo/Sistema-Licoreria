package com.sil.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 * Esta clase contiene la estructura de las empresas, metodos y constructores
 *
 * @author Adrian Flores
 *
 */
public class Licorerias {

    private final Conexion Conecta = new Conexion();
    private Connection Conector;
    private Statement St;
    private ResultSet Rs;

    /**
     * Este metodo muestra la lista de licorerias almacenadas en la BD Quiza no
     * sea usado nunca, asi que pendiente EVALUAR SI ES MEJOR DEJARLO AQUI EN
     * ESTA CLASE O EN LAS CLASES DE LAS INTERFACES
     *
     * @return String licorerias
     */
    public String consultaLicoreria() {

        String licoreria = null;
        String Query = "SELECT nombreLicoreria FROM sil.licoreria";

        try {
            // Conexion con BBDD
            Conector = Conecta.Conectar();
            St = Conector.createStatement();
            // Consulta
            Rs = St.executeQuery(Query);
            while (Rs.next()) {
                Rs.getString("nombreLicoreria");
            }
            cierraConsultas();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Error en la consulta", "Error", JOptionPane.ERROR);
            Logger.getLogger(Licorerias.class.getName()).log(Level.SEVERE, null, sqle);
        }
        return licoreria;
    }

    /**
     * Metodo MostrarRegistros Muestra en el combobox la lista de empresas
     * disponibles en la base de datos
     * @param jCombo
     */
    public void muestraRegistros(JComboBox jCombo) {
        // Muestra en el combobox la lista de empresas disponibles en la base de
        // datos
        String Query = "SELECT nombreLicoreria FROM sil.licorerias;";
        try {
            Conector = Conecta.Conectar();
            St = Conector.createStatement();
            Rs = St.executeQuery(Query);
            while (Rs.next()) {
                jCombo.addItem(Rs.getString("nombreLicoreria"));
            }
            // Libera recursos del sistema
            cierraConsultas();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Error en la consulta.");
            Logger.getLogger(Licorerias.class.getName()).log(Level.SEVERE, null, sqle);
        }
    }// Cierre del metodo

    /**
     * Permite elimiar registros de la base de datos.
     *
     * @param nombreLicoreria recibe el nombre de la licoreria
     */
    public void eliminaLicoreria(String nombreLicoreria) {

        String Query = "DELETE FROM licorerias WHERE `nombreLicoreria`='" + nombreLicoreria + "';";

        try {
            Conector = Conecta.Conectar();
            // Se crea la sentencia
            St = Conector.createStatement();
            // Se ejecuta la sentencia
            St.executeUpdate(Query);
            JOptionPane.showMessageDialog(null, "Registro Eliminado con exito");
            // Se liberan recursos
            cierraConsultas();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el registro");
            Logger.getLogger(Licorerias.class.getName()).log(Level.SEVERE, null, sqle);
        }
    } // Cierre del metodo

    /**
     * Este metodo agregara registros a la base de datos.
     *
     * @param nombreLicoreria recibe el nombre de la licoreria
     */
    public void registraLicoreria(String nombreLicoreria) {

        String Query = "INSERT INTO `sil`.`licorerias` (`nombreLicoreria`) VALUES ('" + nombreLicoreria + "');";

        try {
            // Se establece la conexion
            Conector = Conecta.Conectar();
            // Se crea la sentencia
            St = Conector.createStatement();
            // Se ejecuta la sentencia
            St.executeUpdate(Query);
            JOptionPane.showMessageDialog(null, "Registro exitoso");
            // Se liberan recursos
            cierraConsultas();
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

    /**
     * Este metodo selecciona una licoreria como activa para elaborar las
     * operaciones con ese registro. Falta definir bien sus funciones
     *
     * @param licoreria recibe el nombre de la licoreria
     */
    public void seleccionaLicoreria(String licoreria) {
        try {
            Conector = Conecta.Conectar();
            St = Conector.createStatement();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Error al mostrar empresas", "Error en la consulta",
                    JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Licorerias.class.getName()).log(Level.SEVERE, null, sqle);
        }
    }// Cierre del metodo

    /**
     * Metodo CerrarConsultas: Este metodo permite cerrar consultas y conexion
     * sí existen.
     *
     */
    public void cierraConsultas() {
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
    }// Cierre del metodo

}
