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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
