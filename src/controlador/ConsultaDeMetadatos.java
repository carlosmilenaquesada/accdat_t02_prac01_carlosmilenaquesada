package controlador;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import vista.Defectos;

public class ConsultaDeMetadatos {
    //En esta clase se guardan las funciones que se usarán en la recopilación
    //de metadatos, tales como la obtención de nombres de tablas, obtención de
    //columnas, etc.

    private static DatabaseMetaData dbmd = null;

    public ConsultaDeMetadatos() {
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
        ResultSet rs = null;
        try {
            rs = dbmd.getTables(null, Defectos.CONEXION_ESQUEMA, "%", new String[]{"TABLE"});
            while (rs.next()) {
                nombreTablas.add(rs.getString("TABLE_NAME"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaDeMetadatos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return nombreTablas;
    }
    
    public ArrayList<String> obtenerNombreColumnasDeTabla(String nombreTabla){
        ArrayList<String> nombreColumnas = new ArrayList<>();
        ResultSet rs = null;
        try {
            rs = dbmd.getColumns(null, Defectos.CONEXION_ESQUEMA, nombreTabla, "%");
            while(rs.next()){
                nombreColumnas.add(rs.getString("COLUMN_NAME"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaDeMetadatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nombreColumnas;
         
    }
}
