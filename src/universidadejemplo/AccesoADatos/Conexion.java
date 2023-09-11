/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadejemplo.AccesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author federico.acenjo
 */
public class Conexion {
    private static final String URL = "jdbc.mariadb://localhost/";
    private static final String DB = "universidadulp";
    private static final String USUARIO = "root";    // root
    private static final String PASSWORD = "";   // ""
    
    private static Connection connection;  // lo que importa  

    private Conexion(){}
    
      
    public static Connection getConexion(){
        if (connection==null) {  // si es la primera vez
            try {
                //cargamos las clases de mariadb que implementan JDBC
                Class.forName("org.mariadb.jdbc.Driver");
//                connection = DriverManager.getConnection(URL+DB + "?useLegacyDatetimeCode=false&serverTimezone=UTC" +
//                "&user=" + USUARIO + "&password=" + PASSWORD);
                connection = DriverManager.getConnection(URL+DB,USUARIO,PASSWORD);
            } catch (SQLException | ClassNotFoundException ex) {  // si me olvide de importar la libreria // error al cargar los drivers
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return connection; // retorna la conexion establecida
    }
}
