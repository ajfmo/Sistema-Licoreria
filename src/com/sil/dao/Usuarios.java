package com.sil.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

/**
 * Esta clase contiene los distintos metodos que operan sobre la tabla de
 * usuarios
 *
 * @author Adrian Floers
 */
public class Usuarios {

	private final Conexion conecta = new Conexion();
	private Connection conector;
	private ResultSet resultSet;
	private Statement statement;
	private PreparedStatement preparedStatement;

	/**
	 * Este metodo hace la operacion de acceso mediante una comparacion de los
	 * datos que ingresan y los q hay en la BD.
	 *
	 * @param login
	 *            recibe el login del usario
	 * @param clave
	 *            recibe la clave del ususario
	 * @return data
	 */
	public Object[][] accederUsuario(String login, String clave) {

		conector = conecta.conectar();
		int registros = 0;
		int usu_id;

		try {
			String Query = "SELECT count(1) as cont" + " FROM usuarios";
			statement = conector.createStatement();
			/*
			 * PreparedStatement pstm = Conn.prepareStatement(Query); ResultSet
			 * resultSet = pstm.executeQuery();
			 */
			try (ResultSet Rs = statement.executeQuery(Query)) {
				/*
				 * PreparedStatement pstm = Conn.prepareStatement(Query);
				 * ResultSet resultSet = pstm.executeQuery();
				 */
				Rs.next();
				registros = Rs.getInt("cont");
				Rs.close();
			}
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error en la consulta MySQL");
			Logger.getLogger(Licorerias.class.getName()).log(Level.SEVERE, null, sqle);
		}

		Object[][] data = new Object[registros][3];

		if (login.length() != 0 && clave.length() != 0) {

			String usu_login;
			String usu_password;

			try {
				String Query = "SELECT * FROM sil.usuarios WHERE login = '" + login + "' AND clave = '" + clave + "'";
				statement = conector.createStatement();
				/*
				 * PreparedStatement pstm = Conn.prepareStatement(Query); try
				 * (ResultSet resultSet = pstm.executeQuery()) {
				 */
				try (ResultSet Rs = statement.executeQuery(Query)) {
					int i = 0;
					while (Rs.next()) {
						usu_id = Rs.getInt("idUsuarios");
						usu_login = Rs.getString("login");
						usu_password = Rs.getString("clave");
						data[i][0] = usu_id;
						data[i][1] = usu_login;
						data[i][2] = usu_password;
						i++;

					}
				}
			} catch (SQLException sqle) {
				JOptionPane.showMessageDialog(null, "Error en la consulta MySQL");
				Logger.getLogger(Licorerias.class.getName()).log(Level.SEVERE, null, sqle);
			} finally {
				try {
					if (conector != null) {
						conector.close();
					}
				} catch (SQLException sqle) {
					JOptionPane.showMessageDialog(null, "Error al cerrar la conexion");
					Logger.getLogger(Licorerias.class.getName()).log(Level.SEVERE, null, sqle);
				}
			}
		}
		return data;
	}

	/**
	 * Este metodo permite borrar registros de la base de datos
	 *
	 * @param login
	 *            recibe el login del usuario
	 */
	public void borrarUsuario(String login) {

		conector = conecta.conectar();

		// Otro Query "delete FROM sil.usuarios where `nombreUsuarios` =
		// 'Ventas';"
		try {
			String Query = "DELETE FROM usuarios WHERE `login`='" + login + "';";
			statement = conector.createStatement();
			statement.executeUpdate(Query);
			JOptionPane.showMessageDialog(null, "Registro eliminado con exito!");
			statement.close();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error en la actualizacion de datos");
		} finally {
			if (conector != null) {
				try {
					conector.close();
				} catch (SQLException sqle) {
					JOptionPane.showMessageDialog(null, "Error al cerrar la conexion");
					Logger.getLogger(Licorerias.class.getName()).log(Level.SEVERE, null, sqle);
				}
			}
		}
	}

	/**
	 * Este metodo muestra los registros actuales en la tabla de la base de
	 * datos
	 *
	 * @param login
	 *            recibe el login del usuario
	 * @return resultSet
	 */
	// Deprecated por mi
	public ResultSet buscarUsuario(String login) {

		try {
			conector = conecta.conectar();
			String Query = "SELECT * FROM sil.usuarios where login = ?";

			// Prepara la consulta Query
			preparedStatement = conector.prepareStatement(Query);
			preparedStatement.setString(1, login);

			// Ejecuta la consulta
			resultSet = preparedStatement.executeQuery();

			/*
			 * Este bloque hace que se pasee por todos los resultados Usando el
			 * while while (resultSet.next()) {
			 * 
			 * JOptionPane.showMessageDialog(null, " | ID: " +
			 * resultSet.getString("idUsuarios") + " | Login: " +
			 * resultSet.getString("login") + " | Nombre: " +
			 * resultSet.getString("nombreUsuarios")); statement.close();
			 * resultSet.close(); }
			 */
		} catch (SQLException SQLe) {
			JOptionPane.showMessageDialog(null, "Error en la consulta");
			Logger.getLogger(Licorerias.class.getName()).log(Level.SEVERE, null, SQLe);
		}
		return resultSet;
	}

	/**
	 * Metodo OtraBusqueda: Este metodo realiza la busqueda en la base de datos
	 * del parametro recibido
	 *
	 * @param login
	 *            recive el login del usuario
	 * @return ResultSet resultSet
	 */
	public ResultSet buscaUsuario(String login) {

		conector = conecta.conectar();
		String Query = "SELECT * FROM usuarios WHERE login = '" + login + "'";
		try {
			// Crea la consulta Query
			statement = conector.createStatement();
			// Ejecuta la consulta Query
			resultSet = statement.executeQuery(Query);
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, sqle, "Error en la consulta de datos", JOptionPane.ERROR_MESSAGE);
			Logger.getLogger(Licorerias.class.getName()).log(Level.SEVERE, null, sqle);
		}
		return resultSet;
	}

	/**
	 * Este metodo registra mediante un Query los datos de los usuarios a
	 * agregar a la base de datos
	 *
	 * @param nombreUsuarios
	 *            recibe el nombre del usuario
	 * @param login
	 *            recibe el login del usuario
	 * @param clave
	 *            recibe el password del usuario
	 */
	public void registrarUsuario(String nombreUsuarios, String login, String clave) {
		try {
			conector = conecta.conectar();
			String Query = "INSERT INTO `sil`.`usuarios` (`nombreUsuarios`," + " `login`, `clave`) VALUES ('"
					+ nombreUsuarios + "', '" + login + "', '" + clave + "');";
			statement = conector.createStatement();
			statement.executeUpdate(Query);
			JOptionPane.showMessageDialog(null, "Datos ingresados correctamente!");
		} catch (SQLException SQLe) {
			JOptionPane.showMessageDialog(null, "Error en la consulta");
			Logger.getLogger(Licorerias.class.getName()).log(Level.SEVERE, null, SQLe);
		}
	}// Cierre del constructor

	/**
	 * Metodo CerrarConsultas: Este metodo permite cerrar consultas y conexion
	 * sí existen.
	 *
	 */
	public void cierraConsultas() {
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

	/**
	 * Metodo aun por definir
	 *
	 * @param nombreUsuario
	 *
	 */

	/*
	 * public void usuarioOnline(String nombreUsuario) {
	 * 
	 * String Query = "SELECT * FROM sil.usuarios WHERE `nombreUsuarios`='" +
	 * nombreUsuario + "';";
	 * 
	 * try { Statement statement = conector.createStatement(); ResultSet
	 * resultSet = statement.executeQuery(Query);
	 * JOptionPane.showMessageDialog(null, "Conectado como:  " + nombreUsuario);
	 * } catch (SQLException sqle) { JOptionPane.showMessageDialog(null,
	 * "Error en el query de consulta", "ERROR", JOptionPane.ERROR_MESSAGE); }
	 * 
	 * }
	 */
}
