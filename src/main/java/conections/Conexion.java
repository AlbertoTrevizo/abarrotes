package conections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private Connection con = null;
    private static Conexion conexion;

    private Conexion() throws SQLException, ClassNotFoundException {
        this.createConexion();
    }

    public static Conexion getInstance() throws SQLException, ClassNotFoundException{
        if(conexion == null){
            conexion = new Conexion();
        }
        return conexion;
    }

    private void createConexion() throws SQLException, ClassNotFoundException {
        String urlDatabase = "jdbc:postgresql://localhost:5432/abarrotes";
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection(urlDatabase,  "alberto", "Alberto97");
    }

    public Connection getCon() {
        return con;
    }
}
