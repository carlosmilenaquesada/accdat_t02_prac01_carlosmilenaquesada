package controlador;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import modelo.Columna;
import modelo.TablaDinamica;
import vista.PrincipalJFrame;

public class Herramientas {

    public static void limpiarTabla(DefaultTableModel dtm) {
        for (int i = dtm.getRowCount() - 1; i >= 0; i--) {
            dtm.removeRow(i);
        }
    }

    public static void traspasoDeSeleccionados(JTable tablaOrigen, DefaultTableModel modelOrigen, DefaultTableModel modelDestino) {
        if (tablaOrigen.getSelectedRowCount() >= 1) {
            int[] rowsSeleccionadas = tablaOrigen.getSelectedRows();
            for (int i = rowsSeleccionadas.length - 1; i >= 0; i--) {
                modelDestino.addRow(new Object[]{modelOrigen.getValueAt(rowsSeleccionadas[i], 0)});
                modelOrigen.removeRow(rowsSeleccionadas[i]);
            }
        }
    }

    public static void traspasoDeTodos(DefaultTableModel modelOrigen, DefaultTableModel modelDestino) {
        for (int i = modelOrigen.getRowCount() - 1; i >= 0; i--) {
            modelDestino.addRow(new Object[]{modelOrigen.getValueAt(i, 0)});
        }
    }

    public static TablaDinamica generarObjetoTablaDinamica(ArrayList<Columna> cabeceraTabla, JTable contenidoTabla) {

        TablaDinamica td = new TablaDinamica();
        td.setCabeceraTabla(cabeceraTabla);

        ArrayList<Object> filas = new ArrayList<>();
        ArrayList<Object> celdas = new ArrayList<>();

        for (int filaTabla = 0; filaTabla < contenidoTabla.getRowCount(); filaTabla++) {
            for (int columnaTabla = 0; columnaTabla < contenidoTabla.getColumnCount(); columnaTabla++) {
                celdas.add(contenidoTabla.getValueAt(filaTabla, columnaTabla));
            }
            filas.add(celdas);
            //para limpiar 'celdas' y poder reutilizar la colección en cada ciclo
            //del for, debe hacerse usando new ArrayList, ya que si se usa
            //clear, remove ó removeAll, se borrarán los contenidos que le hagan
            //referencia y en filas también desaparece.
            celdas = new ArrayList<>();
        }
        td.setContenidoTabla(filas);
        return td;
    }

    public static File obtenerFileParaGuardar() throws IOException {
        File file = null;
        JFileChooser jfc = new JFileChooser();
        jfc.setDialogTitle("Seleccione un archivo para guardar...");
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        jfc.setFileFilter(new FileNameExtensionFilter("Archivo Java Serialized Object SER (*.ser)", "ser"));
        jfc.setFileFilter(new FileNameExtensionFilter("Archivo JavaScript Object Notation JSON (*.json)", "json"));
        jfc.setAcceptAllFileFilterUsed(false);
        jfc.showDialog(null, "Guardar");
        if (jfc.getSelectedFile() != null) {
            String extensionElegida = "." + ((FileNameExtensionFilter) jfc.getFileFilter()).getExtensions()[0];
            if (!jfc.getSelectedFile().toString().toLowerCase().endsWith(extensionElegida.toLowerCase())) {
                file = new File(jfc.getSelectedFile().toString() + extensionElegida);
            } else {
                file = new File(jfc.getSelectedFile().toString());
            }
            if (!file.exists()) {
                file.createNewFile();
            }
        }
        return file;
    }

    public static void exportarArchivoJSON(File archivoDondeGuardar, TablaDinamica objetoAGuardar) {
        Gson gson = new Gson();
        String json = gson.toJson(objetoAGuardar);
        FileWriter fw = null;
        try {
            fw = new FileWriter(archivoDondeGuardar);
            fw.write(json);
        } catch (IOException ex) {
            Logger.getLogger(PrincipalJFrame.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (fw != null) {
                    fw.close();

                }
            } catch (IOException ex) {
                Logger.getLogger(PrincipalJFrame.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void exportarArchivoSerializedObject(File archivoDondeGuardar, TablaDinamica objetoAGuardar) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(archivoDondeGuardar);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(objetoAGuardar);

        } catch (IOException ex) {
            Logger.getLogger(PrincipalJFrame.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
                if (fos != null) {
                    fos.close();

                }
            } catch (IOException ex) {
                Logger.getLogger(PrincipalJFrame.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static String obtenerDatoConPrecision(Columna columna) {
        String datoCompleto = columna.getType();
        if (datoCompleto.equals("NUMBER")) {
            datoCompleto += "(" + columna.getPrecision() + "," + columna.getScale() + ")";
        } else {
            if (datoCompleto.equals("VARCHAR2")) {
                datoCompleto += "(" + columna.getPrecision() + " BYTE)";
            }
        }
        return datoCompleto;
    }

    public static Defectos.TipoDeCondicional comprobarTipoCondicional(String tipoOperador) {
        Defectos.TipoDeCondicional tipo;
        switch (tipoOperador) {
            case "IS NULL":
            case "IS NOT NULL":
                tipo = Defectos.TipoDeCondicional.TIPO_NULL;
                break;
            case "BETWEEN":
            case "NOT BETWEEN":
                tipo = Defectos.TipoDeCondicional.TIPO_BETWEEN;
                break;
            case "LIKE":
            case "NOT LIKE":
                tipo = Defectos.TipoDeCondicional.TIPO_LIKE;
                break;
            default:
                tipo = Defectos.TipoDeCondicional.TIPO_COMPARACION;
        }
        return tipo;
    }
        
    public static String convertirDateAString(Date date, String formato){
        return new SimpleDateFormat(formato).format(date);    
    }
}
