package com.sil.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Clase Productos: Estructura de un articulo y sus distintos comportamientos
 *
 * @author Adrian Flores
 *
 */
public class Productos {

    private static Connection Conector;
    private static final Conexion Conecta = new Conexion();
    private static Statement St;
    private static ResultSet Rs;

    public void buscaProducto() {

    }

    /**
     * Metodo llenarTabla: Este metodo permite ver los productos almacenados en
     * la base de datos
     *
     * @param table
     * @param Query
     * @throws java.sql.SQLException
     */
    public void llenarTabla(JTable table) throws SQLException {
        String Query = "SELECT codProducto, descripcionProducto, tipoProducto,"
                + " existenciaProducto, costoProducto, precioProducto FROM productos;";
        try {
            Conector = Conecta.Conectar();
            St = Conector.createStatement();
            Rs = St.executeQuery(Query);

            //To remove previously added rows
            while (table.getRowCount() > 0) {
                ((DefaultTableModel) table.getModel()).removeRow(0);
            }
            int columns = Rs.getMetaData().getColumnCount();
            while (Rs.next()) {
                Object[] row = new Object[columns];
                for (int i = 1; i <= columns; i++) {
                    row[i - 1] = Rs.getObject(i);
                }
                ((DefaultTableModel) table.getModel()).insertRow(Rs.getRow() - 1, row);
            }
            cierraConsultas();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Error en la consulta MySQL");
            Logger.getLogger(Licorerias.class.getName()).log(Level.SEVERE, null, sqle);
        }
    }

    /**
     * Metodo MostrarRegistros:
     *
     * Muestra en el combobox la lista de registros disponibles en la base de
     * datos
     *
     * @param jCombo
     */
    public void muestraTipo(JComboBox jCombo) {
        String Query = "SELECT descripcionTipo FROM sil.tipoproductos;";
        try {
            Conector = Conecta.Conectar();
            St = Conector.createStatement();
            Rs = St.executeQuery(Query);
            while (Rs.next()) {
                jCombo.addItem(Rs.getString("descripcionTipo"));
            }
            cierraConsultas();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Error en la consulta.");
            Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, sqle);
        }
    }

    public void registraProducto() {

    }

    public void modificaProducto() {

    }

    public void eliminaProducto() {

    }

    /**
     * Metodo cierraConsultas Este metodo cierra las consultas y conexiones si
     * las hay abiertas.
     */
    public void cierraConsultas() {
        try {
            if (Conector != null) {
                Conector.close();
            }
            if (St != null) {
                St.close();
            }
            if (Rs != null) {
                Rs.close();
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Error al cerrar");
            Logger.getLogger(Licorerias.class.getName()).log(Level.SEVERE, null, sqle);
        }
    }
}
