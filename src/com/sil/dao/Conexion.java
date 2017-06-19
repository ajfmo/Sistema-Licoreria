package com.sil.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

/**
 * Clase Conexion: Permite el manejo de conexiones, consultas y querys hacia la
 * base de datos.
 *
 * @author Adrian Flores
 *
 */
public class Conexion {

	// Variables y constantes para establecer la conexion con la base de datos.
	private final String urlBD = "jdbc:mysql://localhost:3306/sil";
	private final String usuarioBD = "root";
	private final String pwdBD = "2374";
	private Connection conector;

	/**
	 * Este metodo costructor devuelve la conexion, para su uso en otras clases
	 *
	 * @return conector
	 */
	public Connection conectar() {
		try {
			conector = DriverManager.getConnection(urlBD, usuarioBD, pwdBD);
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error en la conexion");
			Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, sqle);
		}
		return conector;

	} // Cierre del constructor

	/**
	 * Este metodo cierra la conexion, para su uso en otras clases es realmente
	 * necesario? ya que puedo cerrar la conexion cuando quiera con el metodo
	 * Connection.close();
	 *
	 */
	public void cerrarConexion() {
		try {
			conector.close();
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error al cerrar conexion", "Error", JOptionPane.ERROR_MESSAGE);
			Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, sqle);
		}
	}// Cierre del constructor*/

}// Fin de la clase Conexion
