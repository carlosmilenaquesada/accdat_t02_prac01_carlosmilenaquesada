package modelo;

import java.io.Serializable;

public class Columna implements Serializable {

    private String name;
    private String type;

    public Columna(String nombreColumna, String nombreTipo) {
        this.name = nombreColumna;
        this.type = nombreTipo;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

}
