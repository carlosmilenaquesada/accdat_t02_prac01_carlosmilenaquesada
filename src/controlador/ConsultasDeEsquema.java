package controlador;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Columna;
import vista.Defectos;

public class ConsultasDeEsquema {
    public static ArrayList<String> obtenerNombreTablas() throws SQLException {
        ArrayList<String> nombreTablas = new ArrayList<>();
        DatabaseMetaData dbmd = Conexion.getConexion().getMetaData();
        ResultSet rs = dbmd.getTables(null, Defectos.CONEXION_ESQUEMA, "%", new String[]{"TABLE"});
        while (rs.next()) {
            nombreTablas.add(rs.getString("TABLE_NAME"));
        }
        return nombreTablas;
    }

    public static ArrayList<Columna> obtenerMetasDeColumnasDeTabla(String nombreTabla) throws SQLException {
        ArrayList<Columna> columnasTabla = new ArrayList<>();
        DatabaseMetaData dbmd = Conexion.getConexion().getMetaData();
        ResultSet rs = dbmd.getColumns(null, Defectos.CONEXION_ESQUEMA, nombreTabla, "%");
        while (rs.next()) {
            columnasTabla.add(new Columna(rs.getString("COLUMN_NAME"), rs.getString("TYPE_NAME"), rs.getInt("COLUMN_SIZE"), rs.getInt("DECIMAL_DIGITS")));
        }
        return columnasTabla;
    }
}
