package controlador;

import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsultaDeTabla {

    //En esta clase se guardan las funciones que se usarán contra las tablas
    //de la base de datos, tales como los query 'select' construidos por 
    //el usuario.
    public ConsultaDeTabla() {

    }

    public ArrayList<String> obtenerCabeceraParaTablaFinal(String consulta) {
        ArrayList<String> cabeceras = new ArrayList<>();
        try {
            Statement st = Conexion.getInstance().createStatement();
            ResultSetMetaData rsmd = st.executeQuery(consulta).getMetaData();
            int cantidadColumnas = rsmd.getColumnCount();
            for (int i = 1; i <= cantidadColumnas; i++) {
                cabeceras.add(rsmd.getColumnName(i));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConsultaDeTabla.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cabeceras;
    }

    public ResultSet obtenerContenidoParaTablaFinal(String consulta) {
        ResultSet rs = null;

        try {
            Statement st = Conexion.getInstance().createStatement();
            rs = st.executeQuery(consulta);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaDeTabla.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;

    }
}
