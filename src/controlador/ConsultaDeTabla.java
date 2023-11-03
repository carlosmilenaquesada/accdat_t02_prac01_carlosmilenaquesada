package controlador;

import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.ResultSet;
import modelo.Columna;

public class ConsultaDeTabla {
    public static ArrayList<Columna> obtenerCabeceraParaTablaFinal(String consulta) throws SQLException {
        ArrayList<Columna> cabeceras = new ArrayList<>();
        Statement st = Conexion.getConexion().createStatement();
        ResultSetMetaData rsmd = st.executeQuery(consulta).getMetaData();

        int cantidadColumnas = rsmd.getColumnCount();
        for (int i = 1; i <= cantidadColumnas; i++) {
            cabeceras.add(new Columna(rsmd.getColumnName(i), rsmd.getColumnTypeName(i), rsmd.getPrecision(i), rsmd.getScale(i)));
        }
        return cabeceras;
    }

    public static ResultSet obtenerContenidoParaTablaFinal(String consulta) throws SQLException {
        Statement st = Conexion.getConexion().createStatement();
        return st.executeQuery(consulta);
    }
}
