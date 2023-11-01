package modelo;

import java.io.Serializable;

public class Columna implements Serializable {

    private String name;
    private String type;
    private int precision;
    private int scale;

    public Columna(String name, String type, int precision, int scale) {
        this.name = name;
        this.type = type;
        this.precision = precision;
        this.scale = scale;
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

    public int getPrecision() {
        return precision;
    }

    public int getScale() {
        return scale;
    }

}
