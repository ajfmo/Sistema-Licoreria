/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sil.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 * Clase Operacones_Reportes:
 *
 * Esta clase contiene los metodos para el llamado e implementacion de los
 * mismos.
 *
 * @author Adrian Floers
 */
public class Reportes {

    //Variables de la clase, no modificar.
    private final Conexion conecta = new Conexion();
    private Connection conector;

    private JasperReport jasperReport = null;
    private JasperPrint jasperPrint = null;
    private JasperViewer jasperView = null;

    private String pathReporte;
    private String tituloReporte;
    //Cierre de declaracion de variables.

    /**
     * Metodo cargarReporte: Hace las consultas y llama al reporte para ser
     * mostrado en pantalla.
     */
    void cargarReporte(String PathReporte) {

        try {
            // Generar Conexion.
            conector = conecta.conectar();
            // Carga el reporte desde la ubicacion, realiza la conexion, muestra
            // el reporte.
            jasperReport = (JasperReport) JRLoader.loadObjectFromFile(PathReporte);
            jasperPrint = JasperFillManager.fillReport(jasperReport, null, conector);
            jasperView = new JasperViewer(jasperPrint, false/* ,Locale.ROOT */);
            // Locale sirve para que el viewer se muestre en el lenguaje que se
            // implemente.
            jasperView.setTitle(tituloReporte);
            jasperView.setVisible(true);
            conector.close();
        } catch (JRException | SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Error al generar el reporte, revise el archivo de registros"
                    + " en /Sistema Licoreria/Reporte/Logs",
                    "Error al generar Reporte", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Este metodo cierra la conexion, para su uso en otras clases
     */
    public void cierraConexion() {
        try {
            conector.close();
        } catch (SQLException sqle) {
            // TODO: handle exception
            System.out.println("Error cerrando la conexion");
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, sqle);
        }

    }// Cierre del constructor*/

    /**
     * Metodo reportarLicorerias:
     *
     * Este metodo define el titulo y locacion del reporte en cuestion.
     */
    public void reportarLicorerias() {
        // Generar Conexion.
        tituloReporte = "Reporte de Licorerias";
        pathReporte = "/Sistema Licorerias/Reportes/Reporte-Licorerias.jasper";
        // Carga el reporte desde la ubicacion, realiza la conexion, muestra el
        // reporte.
        cargarReporte(pathReporte);
    }// Cierre del metodo

    /**
     * Metodo reportarUsuarios:
     *
     * Este metodo define el titulo y locacion del reporte en cuestion.
     */
    public void reportarUsuarios() {
        // Generar Conexion.
        tituloReporte = "Reporte de Usuarios";
        pathReporte = "/Sistema Licorerias/Reportes/Reporte-Usuarios.jasper";
        // Carga el reporte desde la ubicacion, realiza la conexion, muestra el
        // reporte.
        cargarReporte(pathReporte);
    }// Cierre del metodo
}
