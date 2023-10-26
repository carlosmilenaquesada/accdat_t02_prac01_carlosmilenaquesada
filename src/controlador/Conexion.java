package controlador;

import java.sql.*;

public class Conexion {

    /**
     * Conexión a la base de datos es estática (solo puede haber una en todo el
     * programa) y privada (accedemos a ella solo a través de getInstance()).
     *
     * Los atributos son privados, ya que nos interesa que solamente se puedan
     * inicializar a del constructor por parámetros.
     */
    private static Connection connection = null;
    private String server;
    private String port;
    private String user;
    private String pass;

    /**
     * El constructor por defecto es privado, ya que no queremos que se cree una
     * instancia de Conexión con atributos vacíos con estado no válido.
     */
    private Conexion() {}

    /**
     * Mediante el constructor por parámetros, se inicializan los atributos que
     * recibirá la Connection.
     */
    public Conexion(String server, String port, String user, String pass) {
        this.server = server;
        this.port = port;
        this.user = user;
        this.pass = pass;
    }

    /**
     * El método getInstance permite obtener un objeto tipo Connection, que
     * obligatoriamente será instancia única, y además solamente se puede crear
     * cuando sea null.
     *
     * Unos atributos no válidos harán que connection siga siendo null (por
     * exception o por no inicialización), lo que nos permite reintentar la
     * creación. Una una vez creada, no se podrá sobreescribir.
     */
    public Connection getInstance() {
        if (Conexion.connection == null) {
            try {
                Conexion.connection = DriverManager.getConnection("jdbc:oracle:thin:@" + this.server + ":" + this.port + ":" + "xe", this.user, this.pass);
            } catch (SQLException ex) {
                Conexion.connection = null;
            }
        }
        return Conexion.connection;
    }
}
