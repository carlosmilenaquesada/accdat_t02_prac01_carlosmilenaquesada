package controlador;

import java.awt.Color;
import java.text.SimpleDateFormat;

import java.util.List;

public abstract class Defectos {

    public enum TipoDeCondicional {
        NO_ASIGNADO, TIPO_COMPARACION, TIPO_LIKE, TIPO_NULL, TIPO_BETWEEN
    }

    public enum TipoDeDato {
        NO_ASIGNADO, VARCHAR2, NUMBER, DATE
    }

    public static final String CONEXION_CATALOGO = null;
    public static String CONEXION_ESQUEMA;
    public static final Color COLOR_ERROR = new Color(238, 152, 151);

    public static final List<String> OP_LOGICO_NUMBER_Y_DATE = List.of(
            "=", "<>", "<", ">", "<=", ">=", "BETWEEN", "NOT BETWEEN", "IS NULL", "IS NOT NULL"
    );

    public static final List<String> OP_LOGICO_VARCHAR2 = List.of(
            "=", "<>", "LIKE", "NOT LIKE", "IS NULL", "IS NOT NULL"
    );

    public static final List<String> OP_RELACIONAL = List.of("AND", "OR");

    public static final SimpleDateFormat SDF = new SimpleDateFormat("dd-MM-yyyy");// HH:mm:ss

    public static final String FORMATO_FECHA_SQL = "DD-MM-YYYY HH24:MI:SS";

    public static final String[] MENSAJES = new String[]{
        "No se ha establecido una conexión válida con el servidor.",
        "Debe ingresar todos los campos.",
        "No su pudo cargar las tablas correctamente.\nSe cerrará el programa.",
        "El usuario/esquema proporcionado existe, pero no tiene tablas registradas.",
        "El valor porporcionado no es un número.",
        "Debe ingresa dos valores numéricos.",
        "La fecha de inicio no debe superar a la fecha de fin.",
        "No se pudieron cargar los campos de las tablas.",
        "Debe seleccionar o varias filas para borrar.",
        "La consulta proporcionada no se puede ejecutar.",
        "\nDescripción del Error: ",
        "Código Error: ",
        "Considere cambiar el formato de fecha de la DB.",
        "No se pudo crear el archivo.",
        "Si el valor del texto está vacío, no se mostrará ningún resultado en este tipo de consulta."
            

    };
    
    
    
}
