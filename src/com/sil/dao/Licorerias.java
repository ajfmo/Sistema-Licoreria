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

	private final Conexion conecta = new Conexion();
	private Connection conector;
	private Statement statement;
	private ResultSet resultSet;

	/**
	 * Este metodo muestra la lista de licorerias almacenadas en la BD Quiza no
	 * sea usado nunca, asi que pendiente EVALUAR SI ES MEJOR DEJARLO AQUI EN
	 * ESTA CLASE O EN LAS CLASES DE LAS INTERFACES
	 *
	 * @return String licorerias
	 */
	public String consultarLicoreria() {

		String licoreria = null;
		String Query = "SELECT nombreLicoreria FROM sil.licoreria";

		try {
			// Conexion con BBDD
			conector = conecta.conectar();
			statement = conector.createStatement();
			// Consulta
			resultSet = statement.executeQuery(Query);
			while (resultSet.next()) {
				resultSet.getString("nombreLicoreria");
			}
			cerrarConsultas();
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error en la consulta", "Error", JOptionPane.ERROR);
			Logger.getLogger(Licorerias.class.getName()).log(Level.SEVERE, null, sqle);
		}
		return licoreria;
	}

	/**
	 * Metodo MostrarRegistros Muestra en el combobox la lista de empresas
	 * disponibles en la base de datos
	 *
	 * @param jCombo
	 */
	public void mostrarRegistros(JComboBox jCombo) {
		// Muestra en el combobox la lista de empresas disponibles en la base de
		// datos
		String Query = "SELECT nombreLicoreria FROM sil.licorerias;";
		try {
			conector = conecta.conectar();
			statement = conector.createStatement();
			resultSet = statement.executeQuery(Query);
			while (resultSet.next()) {
				jCombo.addItem(resultSet.getString("nombreLicoreria"));
			}
			// Libera recursos del sistema
			cerrarConsultas();
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error en la consulta.");
			Logger.getLogger(Licorerias.class.getName()).log(Level.SEVERE, null, sqle);
		}
	}// Cierre del metodo

	/**
	 * Permite elimiar registros de la base de datos.
	 *
	 * @param nombreLicoreria
	 *            recibe el nombre de la licoreria
	 */
	public void eliminarLicoreria(String nombreLicoreria) {

		String Query = "DELETE FROM licorerias WHERE `nombreLicoreria`='" + nombreLicoreria + "';";

		try {
			conector = conecta.conectar();
			// Se crea la sentencia
			statement = conector.createStatement();
			// Se ejecuta la sentencia
			statement.executeUpdate(Query);
			JOptionPane.showMessageDialog(null, "Registro Eliminado con exito");
			// Se liberan recursos
			cerrarConsultas();
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error al eliminar el registro");
			Logger.getLogger(Licorerias.class.getName()).log(Level.SEVERE, null, sqle);
		}
	} // Cierre del metodo

	/**
	 * Este metodo agregara registros a la base de datos.
	 *
	 * @param nombreLicoreria
	 *            recibe el nombre de la licoreria
	 */
	public void registrarLicoreria(String nombreLicoreria) {

		String Query = "INSERT INTO `sil`.`licorerias` (`nombreLicoreria`) VALUES ('" + nombreLicoreria + "');";

		try {
			// Se establece la conexion
			conector = conecta.conectar();
			// Se crea la sentencia
			statement = conector.createStatement();
			// Se ejecuta la sentencia
			statement.executeUpdate(Query);
			JOptionPane.showMessageDialog(null, "Registro exitoso");
			// Se liberan recursos
			cerrarConsultas();
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

	/**
	 * Este metodo selecciona una licoreria como activa para elaborar las
	 * operaciones con ese registro. Falta definir bien sus funciones
	 *
	 * @param licoreria
	 *            recibe el nombre de la licoreria
	 */
	public void seleccionarLicoreria(String licoreria) {
		try {
			conector = conecta.conectar();
			statement = conector.createStatement();
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
	}// Cierre del metodo

}
