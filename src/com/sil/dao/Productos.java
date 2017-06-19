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

	private static Connection conector;
	private static final Conexion conecta = new Conexion();
	private static Statement statement;
	private static ResultSet resultSet;
	private String query;

	/**
	 * Metodo ejectutarConsulta: Conecta a la base de datos y ejecuta la
	 * consulta recibiendo el query
	 */
	private static void ejectutarConsulta(String Query) throws SQLException {
		conector = conecta.conectar();
		statement = conector.createStatement();
		resultSet = statement.executeQuery(Query);
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
		query = "SELECT codProducto, descripcionProducto, tipoProducto,"
				+ " existenciaProducto, costoProducto, precioProducto FROM productos;";
		try {
			ejectutarConsulta(query);
			// To remove previously added rows
			while (table.getRowCount() > 0) {
				((DefaultTableModel) table.getModel()).removeRow(0);
			}
			int columns = resultSet.getMetaData().getColumnCount();
			while (resultSet.next()) {
				Object[] row = new Object[columns];
				for (int i = 1; i <= columns; i++) {
					row[i - 1] = resultSet.getObject(i);
				}
				((DefaultTableModel) table.getModel()).insertRow(resultSet.getRow() - 1, row);
			}
			cerrarConsultas();
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
	public void mostrarTipo(JComboBox jCombo) {
		query = "SELECT descripcionTipo FROM sil.tipoproductos;";
		try {
			ejectutarConsulta(query);
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				jCombo.addItem(resultSet.getString("descripcionTipo"));
			}
			cerrarConsultas();
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error en la consulta.");
			Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, sqle);
		}
	}

	public void registrarProducto() {

	}

	public void modificarProducto() {

	}

	public void eliminarProducto() {

	}

	/**
	 * Metodo cerrarConsultas Este metodo cierra las consultas y conexiones si
	 * las hay abiertas.
	 */
	public void cerrarConsultas() {
		try {
			if (conector != null) {
				conector.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (resultSet != null) {
				resultSet.close();
			}
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error al cerrar");
			Logger.getLogger(Licorerias.class.getName()).log(Level.SEVERE, null, sqle);
		}
	}
}
