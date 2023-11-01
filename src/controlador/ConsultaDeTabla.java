package controlador;

import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Columna;

public class ConsultaDeTabla {

    //En esta clase se guardan las funciones que se usarán contra las tablas
    //de la base de datos, tales como los query 'select' construidos por 
    //el usuario.
    public ConsultaDeTabla() {

    }

    public ArrayList<Columna> obtenerCabeceraParaTablaFinal(String consulta) {
        ArrayList<Columna> cabeceras = new ArrayList<>();
        try {
            Statement st = Conexion.getInstance().createStatement();
            ResultSetMetaData rsmd = st.executeQuery(consulta).getMetaData();

            int cantidadColumnas = rsmd.getColumnCount();
            for (int i = 1; i <= cantidadColumnas; i++) {
                cabeceras.add(new Columna(rsmd.getColumnName(i), rsmd.getColumnTypeName(i), rsmd.getPrecision(i), rsmd.getScale(i)));
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
            System.out.println(consulta);
            rs = st.executeQuery(consulta);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaDeTabla.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

}
