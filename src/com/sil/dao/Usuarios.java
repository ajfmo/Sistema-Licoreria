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

    private final Conexion Conecta = new Conexion();
    private Connection Conector;
    private ResultSet Rs;
    private Statement St;
    private PreparedStatement Pst;

    /**
     * Este metodo hace la operacion de acceso mediante una comparacion de los
     * datos que ingresan y los q hay en la BD.
     *
     * @param login recibe el login del usario
     * @param clave recibe la clave del ususario
     * @return data
     */
    public Object[][] AccedeUsuario(String login, String clave) {

        Conector = Conecta.Conectar();
        int registros = 0;
        int usu_id;

        try {
            String Query = "SELECT count(1) as cont" + " FROM usuarios";
            St = Conector.createStatement();
            /*
			 * PreparedStatement pstm = Conn.prepareStatement(Query); ResultSet
			 * Rs = pstm.executeQuery();
             */
            try (ResultSet Rs = St.executeQuery(Query)) {
                /*
				 * PreparedStatement pstm = Conn.prepareStatement(Query);
				 * ResultSet Rs = pstm.executeQuery();
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
                St = Conector.createStatement();
                /*
				 * PreparedStatement pstm = Conn.prepareStatement(Query); try
				 * (ResultSet Rs = pstm.executeQuery()) {
                 */
                try (ResultSet Rs = St.executeQuery(Query)) {
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
                    if (Conector != null) {
                        Conector.close();
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
     * @param login recibe el login del usuario
     */
    public void BorrarUsuario(String login) {

        Conector = Conecta.Conectar();

        // Otro Query "delete FROM sil.usuarios where `nombreUsuarios` =
        // 'Ventas';"
        try {
            String Query = "DELETE FROM usuarios WHERE `login`='" + login + "';";
            St = Conector.createStatement();
            St.executeUpdate(Query);
            JOptionPane.showMessageDialog(null, "Registro eliminado con exito!");
            St.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la actualizacion de datos");
        } finally {
            if (Conector != null) {
                try {
                    Conector.close();
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
     * @param login recibe el login del usuario
     * @return Rs
     */
    //Deprecated por mi
    public ResultSet buscarUsuario(String login) {

        try {
            Conector = Conecta.Conectar();
            String Query = "SELECT * FROM sil.usuarios where login = ?";

            // Prepara la consulta Query
            Pst = Conector.prepareStatement(Query);
            Pst.setString(1, login);

            // Ejecuta la consulta
            Rs = Pst.executeQuery();

            /*
			 * Este bloque hace que se pasee por todos los resultados Usando el
			 * while while (Rs.next()) {
			 * 
			 * JOptionPane.showMessageDialog(null, " | ID: " +
			 * Rs.getString("idUsuarios") + " | Login: " + Rs.getString("login")
			 * + " | Nombre: " + Rs.getString("nombreUsuarios")); St.close();
			 * Rs.close(); }
             */
        } catch (SQLException SQLe) {
            JOptionPane.showMessageDialog(null, "Error en la consulta");
            Logger.getLogger(Licorerias.class.getName()).log(Level.SEVERE, null, SQLe);
        }
        return Rs;
    }

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
    }

    /**
     * Metodo OtraBusqueda: Este metodo realiza la busqueda en la base de datos
     * del parametro recibido
     *
     * @param login recive el login del usuario
     * @return ResultSet Rs
     */
    public ResultSet buscaUsuario(String login) {

        Conector = Conecta.Conectar();
        String Query = "SELECT * FROM usuarios WHERE login = '" + login + "'";
        try {
            // Crea la consulta Query
            St = Conector.createStatement();
            // Ejecuta la consulta Query
            Rs = St.executeQuery(Query);
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle, "Error en la consulta de datos", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Licorerias.class.getName()).log(Level.SEVERE, null, sqle);
        }
        return Rs;
    }

    /**
     * Este metodo registra mediante un Query los datos de los usuarios a
     * agregar a la base de datos
     *
     * @param nombreUsuarios recibe el nombre del usuario
     * @param login recibe el login del usuario
     * @param clave recibe el password del usuario
     */
    public void RegistrarUsuario(String nombreUsuarios, String login, String clave) {
        try {
            Conector = Conecta.Conectar();
            String Query = "INSERT INTO `sil`.`usuarios` (`nombreUsuarios`," + " `login`, `clave`) VALUES ('"
                    + nombreUsuarios + "', '" + login + "', '" + clave + "');";
            St = Conector.createStatement();
            St.executeUpdate(Query);
            JOptionPane.showMessageDialog(null, "Datos ingresados correctamente!");
        } catch (SQLException SQLe) {
            JOptionPane.showMessageDialog(null, "Error en la consulta");
            Logger.getLogger(Licorerias.class.getName()).log(Level.SEVERE, null, SQLe);
        }
    }// Cierre del constructor

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
	 * try { Statement St = Conector.createStatement(); ResultSet Rs =
	 * St.executeQuery(Query); JOptionPane.showMessageDialog(null,
	 * "Conectado como:  " + nombreUsuario); } catch (SQLException sqle) {
	 * JOptionPane.showMessageDialog(null, "Error en el query de consulta",
	 * "ERROR", JOptionPane.ERROR_MESSAGE); }
	 * 
	 * }
     */
}
