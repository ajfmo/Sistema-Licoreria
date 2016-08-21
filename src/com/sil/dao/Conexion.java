package com.sil.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Clase Conexion: Permite el manejo de conexiones, consultas y querys hacia
 la base de datos.
 *
 * @author Adrian Flores
 *
 */
public class Conexion {

    // Variables y constantes para establecer la conexion con la base de datos.
    private final String DB = "sil";
    private final String DBuser = "root";
    private final String DBpwd = "2374";
    private final String DBurl = "jdbc:mysql://localhost:3306/" + DB;

    private Connection Conector;

    /**
     * Este metodo costructor devuelve la conexion, para su uso en otras clases
     *
     * @return Conector
     */
    public Connection Conectar() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            // se implementa el metodo Class.forName

            /*
			 * A call to Class.forName("X") causes the class named X to be
			 * dynamically loaded (at runtime). A call to forName("X") causes
			 * the class named X to be initialized (i.e., JVM executes all its
			 * static block after class loading). Class.forName("X") returns the
			 * Class object associated with the "X" class. The returned Class
			 * object is not an instance of the "x" class itself.
			 * Class.forName("X") loads the class if it not already loaded. The
			 * JVM keeps track of all the classes that have been previously
			 * loaded. This method uses the classloader of the class that
			 * invokes it. The "X" is the fully qualified name of the desired
			 * class.
			 * 
			 * 
			 * java.lang.Class forName(String className): Carga una clase del
			 * classpath a partir de su nombre (nombre completo, con todos los
			 * paquetes. Si la clase no se puede cargar, porque no se encuentra
			 * en el classpath, se lanzar� una
			 * java.lang.ClassNotFoundException.
			 * 
			 * Con el metodo forname() de Class, se crea una asociacion entre
			 * nuestra clase Conex y el driver de conexion MYSQL, si no lo logra
			 * da error capturado con ClassNotFoundException
             */
            // Creamos la conexi�n con los parametros suministrados
            // anteriormente
            Conector = DriverManager.getConnection(DBurl, DBuser, DBpwd);
        } catch (ClassNotFoundException classNotFoundException) {
            JOptionPane.showMessageDialog(null, "Error con el driver JDBC");
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Error en la conexion");
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, sqle);
        }
        return Conector;

    } // Cierre del constructor

    /**
     * Este metodo cierra la conexion, para su uso en otras clases es realmente
     * necesario? ya que puedo cerrar la conexion cuando quiera con el metodo
     * Connection.close();
     *
     */
    public void cierraConexion() {
        try {
            Conector.close();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Error al cerrar conexion", "Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, sqle);
        }
    }// Cierre del constructor*/

}// Fin de la clase Conexion
