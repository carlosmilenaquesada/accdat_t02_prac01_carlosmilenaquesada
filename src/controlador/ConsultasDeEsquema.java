package controlador;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Columna;
import vista.Defectos;

public class ConsultasDeEsquema {
    //En esta clase se guardan las funciones que se usarán en la recopilación
    //de metadatos, tales como la obtención de nombres de tablas, obtención de
    //columnas, etc.

    private DatabaseMetaData dbmd = null;

    public ConsultasDeEsquema() {
        if (dbmd == null) {
            try {
                //COMPROBAR SI BORRRO UNA TABLA POR EUJEMPLO, LOS METADATOS SE MODIFICAN O SI UNA VEZ TOMADOS SE MANTIENEN
                dbmd = Conexion.getInstance().getMetaData();
               
            } catch (SQLException ex) {

            }
        }
    }

    public ArrayList<String> obtenerNombreTablas() {
        ArrayList<String> nombreTablas = new ArrayList<>();
        try {
            ResultSet rs = dbmd.getTables(null, Defectos.CONEXION_ESQUEMA, "%", new String[]{"TABLE"});
            while (rs.next()) {
                nombreTablas.add(rs.getString("TABLE_NAME"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasDeEsquema.class.getName()).log(Level.SEVERE, null, ex);
        }

        return nombreTablas;
    }

    public ArrayList<Columna> obtenerMetasDeColumnasDeTabla(String nombreTabla) {
        ArrayList<Columna> columnasTabla = new ArrayList<>();
        ResultSet rs = null;
        try {
            rs = dbmd.getColumns(null, Defectos.CONEXION_ESQUEMA, nombreTabla, "%");
            while (rs.next()) {
                columnasTabla.add(new Columna(rs.getString("COLUMN_NAME"), rs.getString("TYPE_NAME"), rs.getInt("COLUMN_SIZE"), rs.getInt("DECIMAL_DIGITS")));
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasDeEsquema.class.getName()).log(Level.SEVERE, null, ex);
        }
        return columnasTabla;
    }
}
