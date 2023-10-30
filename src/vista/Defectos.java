package vista;

import java.awt.Color;
import java.text.SimpleDateFormat;

import java.util.List;

public abstract class Defectos {
    public enum TipoDeCondicional{
        NO_ASIGNADO, TIPO_COMPARACION, TIPO_LIKE, TIPO_NULL, TIPO_BETWEEN
    }

    public static final String CONEXION_CATALOGO = null;
    public static String CONEXION_ESQUEMA;
    public static final Color COLOR_ERROR = new Color(238, 152, 151);

    public static final List<String> OP_LOGICO_NUMBER_Y_DATE = List.of(
            "=", "<>", "<", " >", "<=", ">=", "BETWEEN", "NOT BETWEEN", "IS NULL", "IS NOT NULL"
    );

    public static final List<String> OP_LOGICO_VARCHAR2 = List.of(
            "=", "<>", "LIKE", "NOT LIKE", "IS NULL", "IS NOT NULL"
    );

    public static final List<String> OP_RELACIONAL = List.of("AND", "OR");

    public static TipoDeCondicional tipoDeCondicional = TipoDeCondicional.NO_ASIGNADO; 
    
    public static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
}

