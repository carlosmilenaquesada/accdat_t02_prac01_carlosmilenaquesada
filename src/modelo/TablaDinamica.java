package modelo;

import java.io.Serializable;
import java.util.ArrayList;

//El objetivo de esta clase, es conseguir un objeto serializable que me permita
//exportar la tabla resultado. Ya que la tabla resultado se genera en tiempo
//de ejecución, no conocemos ni el número de columnas, ni el tipo de datos,  ni
//la cantidad de registros hasta que no haya sido generada, por eso he creado 
//esta clase que se adapta a cualquier tabla generada.
//El atributo cabeceraTabala contiene una colección de pares nombre-tipo del 
//dato de la columna.
//El atributo contenidoTabla es una colección de filas (cada object de la 
//colección es una fila), y cada fila a su vez será una colección de celdas de
//fila.
public class TablaDinamica implements Serializable {

    private ArrayList<Columna> cabeceraTabla;
    private ArrayList<Object> contenidoTabla;

    public TablaDinamica() {
        this.cabeceraTabla = new ArrayList<>();
        this.contenidoTabla = new ArrayList<>();
    }

    public ArrayList<Columna> getCabeceraTabla() {
        return cabeceraTabla;
    }

    public void setCabeceraTabla(ArrayList<Columna> cabeceraTabla) {
        this.cabeceraTabla = cabeceraTabla;
    }

    public ArrayList<Object> getContenidoTabla() {
        return contenidoTabla;
    }

    public void setContenidoTabla(ArrayList<Object> contenidoTabla) {
        this.contenidoTabla = contenidoTabla;
    }

}
