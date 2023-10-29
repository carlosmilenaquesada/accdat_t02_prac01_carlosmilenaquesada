package modelo;

public class Columna {

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
