package controlador;

import java.sql.*;

public class Conexion {

    private static Connection connection = null;
    private static String server;
    private static String port;
    private static String user;
    private static String pass;

    public Conexion(String server, String port, String user, String pass) {
        Conexion.server = server.trim();
        Conexion.port = port.trim();
        Conexion.user = user.trim();
        Conexion.pass = pass.trim();
    }

    public static Connection getConexion() throws SQLException {
        if (Conexion.connection == null) {
            Conexion.connection = DriverManager.getConnection("jdbc:oracle:thin:@" + Conexion.server + ":" + Conexion.port + ":" + "xe", Conexion.user, Conexion.pass);
        }
        return Conexion.connection;
    }

    public static void cerrarConexion() {
        try {
            if (!Conexion.connection.isClosed()) {
                Conexion.connection.close();
            }
        } catch (SQLException ex) {
        }

    }
}
