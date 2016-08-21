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
    private final Conexion Conecta = new Conexion();
    private Connection Conector;

    private JasperReport Jr = null;
    private JasperPrint Jp = null;
    private JasperViewer Jv = null;

    private String PathReporte;
    private String TituloReporte;
    //Cierre de declaracion de variables.

    /**
     * Metodo CargarReporte: Hace las consultas y llama al reporte para ser
     * mostrado en pantalla.
     */
    void CargarReporte(String PathReporte) {

        try {
            // Generar Conexion.
            Conector = Conecta.Conectar();
            // Carga el reporte desde la ubicacion, realiza la conexion, muestra
            // el reporte.
            Jr = (JasperReport) JRLoader.loadObjectFromFile(PathReporte);
            Jp = JasperFillManager.fillReport(Jr, null, Conector);
            Jv = new JasperViewer(Jp, false/* ,Locale.ROOT */);
            // Locale sirve para que el viewer se muestre en el lenguaje que se
            // implemente.
            Jv.setTitle(TituloReporte);
            Jv.setVisible(true);
            Conector.close();
        } catch (JRException | SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Error al generar el reporte, revise el archivo de registros"
                    + " en C:\\Sistema Licoreria\\Reportes\\Logs",
                    "Error al generar Reporte", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Este metodo cierra la conexion, para su uso en otras clases
     */
    public void cierraConexion() {
        try {
            Conector.close();
        } catch (SQLException sqle) {
            // TODO: handle exception
            System.out.println("Error cerrando la conexion");
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, sqle);
        }

    }// Cierre del constructor*/

    /**
     * Metodo ReporteLicorerias:
     *
     * Este metodo define el titulo y locacion del reporte en cuestion.
     */
    public void ReporteLicorerias() {
        // Generar Conexion.
        TituloReporte = "Reporte de Licorerias";
        PathReporte = "C:\\Sistema Licorerias\\Reportes\\Reporte-Licorerias.jasper";
        // Carga el reporte desde la ubicacion, realiza la conexion, muestra el
        // reporte.
        CargarReporte(PathReporte);
    }// Cierre del metodo

    /**
     * Metodo ReporteUsuarios:
     *
     * Este metodo define el titulo y locacion del reporte en cuestion.
     */
    public void ReporteUsuarios() {
        // Generar Conexion.
        TituloReporte = "Reporte de Usuarios";
        PathReporte = "C:\\Sistema Licorerias\\Reportes\\Reporte-Usuarios.jasper";
        // Carga el reporte desde la ubicacion, realiza la conexion, muestra el
        // reporte.
        CargarReporte(PathReporte);
    }// Cierre del metodo
}
