package modelo;

public class Columna {

    private String nombreColumna;
    private String nombreTipo;

    public Columna(String nombreColumna, String nombreTipo) {
        this.nombreColumna = nombreColumna;
        this.nombreTipo = nombreTipo;
    }

    @Override
    public String toString() {
        return nombreColumna;
    }

    public String getNombreColumna() {
        return nombreColumna;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

}
