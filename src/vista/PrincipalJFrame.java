package vista;

import java.sql.*;
import controlador.Conexion;
import controlador.ConsultaDeMetadatos;
import controlador.ConsultaDeTablas;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Columna;
import vista.Defectos.TipoDeCondicional;

public class PrincipalJFrame extends javax.swing.JFrame {

    //Creación de mis variables-------------------------------------------------
    //Conexión y controladores    
    Connection conexion = null;
    ConsultaDeMetadatos cdm = null;
    ConsultaDeTablas cdt = null;
    //Combo Box model
    DefaultComboBoxModel<String> dcbmTablas;
    DefaultComboBoxModel<Columna> dcbmCampos;
    DefaultComboBoxModel<String> dcbmOperadorLogico;
    DefaultComboBoxModel<String> dcbmOperadorRelacional;
    //Table model
    DefaultTableModel dtmDisponibles;
    DefaultTableModel dtmTomados;
    DefaultTableModel dtmCondiciones;
    DefaultTableModel dtmTablaResultado;

    //Columnas de la tabla elegida
    ArrayList<Columna> columnasTablaEnFoco = null;

    public PrincipalJFrame() {
        //Creación del JDialog del login
        LoginJDialog ljd = new LoginJDialog(this, true);
        //ljd.setVisible(true);
        ljd.CrearConexion();

        //Una vez logeados, ya tenemos una conexión válida a la base de datos,
        //bajo el esquema que se a proporcionado en el login. Guardamos la
        //conexión el en un objeto para poder trabajar con ella.
        conexion = Conexion.getInstance();

        initComponents();
        //A algunos componentes que he agregado al JFrame principal, les tengo
        //que inicializar/configurar sus models y otras propiedades. Además, 
        //tengo que configurar los valores que el programa carga por defecto a su
        //inicio. Dichas acciones las realizo en la siguiente función.
        initConfiguracion();
    }

    private void initConfiguracion() {
        //Combobox
        dcbmTablas = (DefaultComboBoxModel<String>) jComboBoxTablas.getModel();
        dcbmCampos = (DefaultComboBoxModel<Columna>) jComboBoxCampos.getModel();
        dcbmOperadorLogico = (DefaultComboBoxModel<String>) jComboBoxOperadorLogico.getModel();
        dcbmOperadorRelacional = (DefaultComboBoxModel<String>) jComboBoxOperadorRelacional.getModel();

        //Tablas
        dtmDisponibles = (DefaultTableModel) jTableDisponibles.getModel();
        dtmTomados = (DefaultTableModel) jTableTomados.getModel();
        dtmCondiciones = (DefaultTableModel) jTableCondiciones.getModel();
        dtmTablaResultado = (DefaultTableModel) jTableTablaResultado.getModel();

        //Controladores
        cdm = new ConsultaDeMetadatos();
        cdt = new ConsultaDeTablas();

        //Colecciones 
        columnasTablaEnFoco = new ArrayList<>();

        //Rellenar lista de tablas inicial
        dcbmTablas.addAll(cdm.obtenerNombreTablas());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelTablas = new javax.swing.JLabel();
        jComboBoxTablas = new javax.swing.JComboBox<>();
        jScrollPaneDisponibles = new javax.swing.JScrollPane();
        jTableDisponibles = new javax.swing.JTable(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jButtonListaTomarUno = new javax.swing.JButton();
        jButtonListaTomarTodos = new javax.swing.JButton();
        jButtonListaQuitarUno = new javax.swing.JButton();
        jButtonListaQuitarTodos = new javax.swing.JButton();
        jScrollPaneTomados = new javax.swing.JScrollPane();
        jTableTomados = new javax.swing.JTable(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jLabelCampo = new javax.swing.JLabel();
        jComboBoxCampos = new javax.swing.JComboBox<>();
        jLabelValor1 = new javax.swing.JLabel();
        jTextFieldValor1 = new javax.swing.JTextField();
        jLabelOperador = new javax.swing.JLabel();
        jComboBoxOperadorLogico = new javax.swing.JComboBox<>();
        jLabelValor2 = new javax.swing.JLabel();
        jTextFieldValor2 = new javax.swing.JTextField();
        jLabelTipoDato = new javax.swing.JLabel();
        jComboBoxOperadorRelacional = new javax.swing.JComboBox<>();
        jButtonAgregarCondicion = new javax.swing.JButton();
        jScrollPaneCondiciones = new javax.swing.JScrollPane();
        jTableCondiciones = new javax.swing.JTable(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jButtonQuitarCondicion = new javax.swing.JButton();
        jLabelSentenciaSql = new javax.swing.JLabel();
        jScrollPaneSentencia = new javax.swing.JScrollPane();
        jTextAreaSentencia = new javax.swing.JTextArea();
        jButtonEjecutarSentencia = new javax.swing.JButton();
        jScrollPaneTablaResultado = new javax.swing.JScrollPane();
        jTableTablaResultado = new javax.swing.JTable(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jButtonExportarTabla = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tema 02. Práctica 01. Metadatos");

        jPanel1.setLayout(null);

        jLabelTablas.setText("Tabla");
        jPanel1.add(jLabelTablas);
        jLabelTablas.setBounds(20, 20, 70, 25);

        jComboBoxTablas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxTablasItemStateChanged(evt);
            }
        });
        jPanel1.add(jComboBoxTablas);
        jComboBoxTablas.setBounds(100, 20, 120, 25);

        jTableDisponibles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Campos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableDisponibles.getTableHeader().setReorderingAllowed(false);
        jScrollPaneDisponibles.setViewportView(jTableDisponibles);
        if (jTableDisponibles.getColumnModel().getColumnCount() > 0) {
            jTableDisponibles.getColumnModel().getColumn(0).setResizable(false);
        }

        jPanel1.add(jScrollPaneDisponibles);
        jScrollPaneDisponibles.setBounds(20, 80, 200, 170);

        jButtonListaTomarUno.setText(">");
        jButtonListaTomarUno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListaTomarUnoActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonListaTomarUno);
        jButtonListaTomarUno.setBounds(230, 120, 50, 25);

        jButtonListaTomarTodos.setText(">>");
        jButtonListaTomarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListaTomarTodosActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonListaTomarTodos);
        jButtonListaTomarTodos.setBounds(230, 155, 50, 25);

        jButtonListaQuitarUno.setText("<");
        jButtonListaQuitarUno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListaQuitarUnoActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonListaQuitarUno);
        jButtonListaQuitarUno.setBounds(230, 190, 50, 25);

        jButtonListaQuitarTodos.setText("<<");
        jButtonListaQuitarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListaQuitarTodosActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonListaQuitarTodos);
        jButtonListaQuitarTodos.setBounds(230, 225, 50, 25);

        jTableTomados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Campos Seleccionados"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableTomados.getTableHeader().setReorderingAllowed(false);
        jScrollPaneTomados.setViewportView(jTableTomados);
        if (jTableTomados.getColumnModel().getColumnCount() > 0) {
            jTableTomados.getColumnModel().getColumn(0).setResizable(false);
        }

        jPanel1.add(jScrollPaneTomados);
        jScrollPaneTomados.setBounds(290, 80, 200, 170);

        jLabelCampo.setText("Campo");
        jPanel1.add(jLabelCampo);
        jLabelCampo.setBounds(550, 20, 55, 25);

        jComboBoxCampos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxCamposItemStateChanged(evt);
            }
        });
        jPanel1.add(jComboBoxCampos);
        jComboBoxCampos.setBounds(620, 20, 120, 25);

        jLabelValor1.setText("Valor 1");
        jPanel1.add(jLabelValor1);
        jLabelValor1.setBounds(780, 20, 55, 25);
        jPanel1.add(jTextFieldValor1);
        jTextFieldValor1.setBounds(850, 20, 120, 25);

        jLabelOperador.setText("Operador");
        jPanel1.add(jLabelOperador);
        jLabelOperador.setBounds(550, 55, 55, 25);

        jComboBoxOperadorLogico.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxOperadorLogicoItemStateChanged(evt);
            }
        });
        jPanel1.add(jComboBoxOperadorLogico);
        jComboBoxOperadorLogico.setBounds(620, 55, 120, 25);

        jLabelValor2.setText("Valor 2");
        jPanel1.add(jLabelValor2);
        jLabelValor2.setBounds(780, 55, 55, 25);
        jPanel1.add(jTextFieldValor2);
        jTextFieldValor2.setBounds(850, 55, 120, 25);

        jLabelTipoDato.setText("El tipo del dato elegido es: ");
        jPanel1.add(jLabelTipoDato);
        jLabelTipoDato.setBounds(510, 90, 230, 25);

        jPanel1.add(jComboBoxOperadorRelacional);
        jComboBoxOperadorRelacional.setBounds(770, 90, 70, 25);

        jButtonAgregarCondicion.setText("+");
        jButtonAgregarCondicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarCondicionActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAgregarCondicion);
        jButtonAgregarCondicion.setBounds(880, 90, 40, 25);

        jTableCondiciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Condición", "Operador"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCondiciones.getTableHeader().setReorderingAllowed(false);
        jScrollPaneCondiciones.setViewportView(jTableCondiciones);
        if (jTableCondiciones.getColumnModel().getColumnCount() > 0) {
            jTableCondiciones.getColumnModel().getColumn(0).setResizable(false);
            jTableCondiciones.getColumnModel().getColumn(1).setResizable(false);
        }

        jPanel1.add(jScrollPaneCondiciones);
        jScrollPaneCondiciones.setBounds(510, 125, 410, 125);

        jButtonQuitarCondicion.setText("-");
        jPanel1.add(jButtonQuitarCondicion);
        jButtonQuitarCondicion.setBounds(930, 175, 40, 25);

        jLabelSentenciaSql.setText("Sentencia SQL");
        jPanel1.add(jLabelSentenciaSql);
        jLabelSentenciaSql.setBounds(20, 260, 110, 14);

        jTextAreaSentencia.setEditable(false);
        jTextAreaSentencia.setColumns(20);
        jTextAreaSentencia.setRows(5);
        jScrollPaneSentencia.setViewportView(jTextAreaSentencia);

        jPanel1.add(jScrollPaneSentencia);
        jScrollPaneSentencia.setBounds(20, 285, 850, 105);

        jButtonEjecutarSentencia.setText("Ejecutar");
        jPanel1.add(jButtonEjecutarSentencia);
        jButtonEjecutarSentencia.setBounds(880, 325, 90, 25);

        jTableTablaResultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableTablaResultado.getTableHeader().setReorderingAllowed(false);
        jScrollPaneTablaResultado.setViewportView(jTableTablaResultado);
        if (jTableTablaResultado.getColumnModel().getColumnCount() > 0) {
            jTableTablaResultado.getColumnModel().getColumn(0).setResizable(false);
        }

        jPanel1.add(jScrollPaneTablaResultado);
        jScrollPaneTablaResultado.setBounds(20, 400, 850, 225);

        jButtonExportarTabla.setText("Exportar");
        jPanel1.add(jButtonExportarTabla);
        jButtonExportarTabla.setBounds(880, 500, 90, 25);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 990, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void limpiarTabla(DefaultTableModel dtm) {
        for (int i = dtm.getRowCount() - 1; i >= 0; i--) {
            dtm.removeRow(i);
        }
    }

    private void traspasoDeSeleccionados(JTable tablaOrigen, DefaultTableModel modelOrigen, DefaultTableModel modelDestino) {
        if (tablaOrigen.getSelectedRowCount() >= 1) {
            int[] rowsSeleccionadas = tablaOrigen.getSelectedRows();
            for (int i = rowsSeleccionadas.length - 1; i >= 0; i--) {
                modelDestino.addRow(new Object[]{modelOrigen.getValueAt(rowsSeleccionadas[i], 0)});
                modelOrigen.removeRow(rowsSeleccionadas[i]);
            }
        }
    }

    private void traspasoDeTodos(DefaultTableModel modelOrigen, DefaultTableModel modelDestino) {
        for (int i = modelOrigen.getRowCount() - 1; i >= 0; i--) {
            modelDestino.addRow(new Object[]{modelOrigen.getValueAt(i, 0)});
        }
    }

    private void modificarInputsDeCondiciones(String tipoOperador) {
        //Ya que el tipo de condicionales más habituales quizás sean los de
        //comparación (=, <>, <, >, <=, >=), voy a establecerlos por defecto
        //y en caso de ser otro (LIKE, NULL, BETWEEN, etc), procederé a
        //realizar los cambios necesarios.
        jTextFieldValor1.setVisible(true);
        jLabelValor1.setVisible(true);
        jTextFieldValor2.setVisible(false);
        jLabelValor2.setVisible(false);
        //El enum es necesario para saber la estructura del condicional 
        //sobre el que se va a trabajar (para agregar comillas, %, el AND de
        //los BETWEEN, etc).
        Defectos.tipoDeCondicional = TipoDeCondicional.TIPO_COMPARACION;

        if (tipoOperador.equals("IS NULL") || tipoOperador.equals("IS NOT NULL")) {
            jTextFieldValor1.setVisible(false);
            jLabelValor1.setVisible(false);
            Defectos.tipoDeCondicional = TipoDeCondicional.TIPO_NULL;
        } else {
            if (tipoOperador.equals("BETWEEN") || tipoOperador.equals("NOT BETWEEN")) {
                jTextFieldValor2.setVisible(true);
                jLabelValor2.setVisible(false);
                Defectos.tipoDeCondicional = TipoDeCondicional.TIPO_BETWEEN;
            } else {
                if (tipoOperador.equals("LIKE") || tipoOperador.equals("NOT LIKE")) {
                    Defectos.tipoDeCondicional = TipoDeCondicional.TIPO_LIKE;
                }
            }
        }
    }

    private void reiniciarTodoElFormulario() {
        //Cada vez que se cambie de tabla, se debe reestablecer a defecto
        //todos los valores y elementos del formulario, excepto la tabla de 
        //resultados final.
        limpiarTabla(dtmDisponibles);
        limpiarTabla(dtmTomados);
        limpiarTabla(dtmCondiciones);
        dcbmCampos.removeAllElements();
        dcbmOperadorLogico.removeAllElements();
        dcbmOperadorRelacional.removeAllElements();
        jLabelValor1.setVisible(true);
        jTextFieldValor1.setText("");
        jTextFieldValor1.setVisible(true);
        jLabelValor2.setVisible(true);
        jTextFieldValor2.setText("");
        jTextFieldValor2.setVisible(true);
        jTextAreaSentencia.setText("");
        Defectos.tipoDeCondicional = TipoDeCondicional.NO_ASIGNADO;
    }

    private String obtenerLineaCondicional() {
        StringBuilder sb = new StringBuilder();
        sb.append(((Columna) dcbmCampos.getSelectedItem()).getNombreColumna());
        switch (Defectos.tipoDeCondicional) {
            case TIPO_COMPARACION:
                sb.append(" ").append((String) dcbmOperadorLogico.getSelectedItem())
                        .append(" '").append(jTextFieldValor1.getText()).append("'");
                break;
            case TIPO_LIKE:
                break;
            case TIPO_NULL:
                break;
            case TIPO_BETWEEN:
                break;
            case NO_ASIGNADO:
                break;
        }
        return sb.toString();
    }

    private void jButtonListaTomarUnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListaTomarUnoActionPerformed
        traspasoDeSeleccionados(jTableDisponibles, dtmDisponibles, dtmTomados);
    }//GEN-LAST:event_jButtonListaTomarUnoActionPerformed

    private void jButtonListaTomarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListaTomarTodosActionPerformed
        traspasoDeTodos(dtmDisponibles, dtmTomados);
        limpiarTabla(dtmDisponibles);
    }//GEN-LAST:event_jButtonListaTomarTodosActionPerformed

    private void jButtonListaQuitarUnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListaQuitarUnoActionPerformed
        traspasoDeSeleccionados(jTableTomados, dtmTomados, dtmDisponibles);
    }//GEN-LAST:event_jButtonListaQuitarUnoActionPerformed

    private void jButtonListaQuitarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListaQuitarTodosActionPerformed
        traspasoDeTodos(dtmTomados, dtmDisponibles);
        limpiarTabla(dtmTomados);
    }//GEN-LAST:event_jButtonListaQuitarTodosActionPerformed

    private void jComboBoxTablasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxTablasItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            reiniciarTodoElFormulario();
            columnasTablaEnFoco = cdm.obtenerMetasDeColumnasDeTabla((String) dcbmTablas.getSelectedItem());
            for (Columna columna : columnasTablaEnFoco) {
                dtmDisponibles.addRow(new String[]{columna.getNombreColumna()});
            }
            dcbmCampos.addAll(columnasTablaEnFoco);
        }
    }//GEN-LAST:event_jComboBoxTablasItemStateChanged

    private void jComboBoxCamposItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxCamposItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            String tipoDatoSql = ((Columna) dcbmCampos.getSelectedItem()).getNombreTipo();
            dcbmOperadorLogico.removeAllElements();

            //Vamos a trabajar con 3 tipos de datos SQL, que son: NUMBER, VARCHAR2 y
            //DATE. En un proyecto mayor, habría más tipos de datos, y habría
            //que realizar una adaptacións más exhaustiva, pero en este proyecto,
            //me voy a centrar en adecuar los operadores a estos tres tipos de casos.
            //if(tipoDatoSql)
            jLabelTipoDato.setText("El tipo del dato elegido es: " + tipoDatoSql);
            if (tipoDatoSql.equals("NUMBER") || tipoDatoSql.equals("DATE")) {
                dcbmOperadorLogico.addAll(Defectos.OP_LOGICO_NUMBER_Y_DATE);
            } else {
                dcbmOperadorLogico.addAll(Defectos.OP_LOGICO_VARCHAR2);
            }
        }
     }//GEN-LAST:event_jComboBoxCamposItemStateChanged

    private void jComboBoxOperadorLogicoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxOperadorLogicoItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            if (dcbmOperadorRelacional.getSize() == 0) {
                dcbmOperadorRelacional.addAll(Defectos.OP_RELACIONAL);
            }
            String tipoOperador = ((String) dcbmOperadorLogico.getSelectedItem());
            //Se modifica el tipo de distribución de los inputs que personalizan
            //los condicionales en base a tipo de operador seleccionado:
            modificarInputsDeCondiciones(tipoOperador);
        }
    }//GEN-LAST:event_jComboBoxOperadorLogicoItemStateChanged

    private void jButtonAgregarCondicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarCondicionActionPerformed
        String sentenciaCondicional = obtenerLineaCondicional();
        System.out.println(sentenciaCondicional);
    }//GEN-LAST:event_jButtonAgregarCondicionActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PrincipalJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgregarCondicion;
    private javax.swing.JButton jButtonEjecutarSentencia;
    private javax.swing.JButton jButtonExportarTabla;
    private javax.swing.JButton jButtonListaQuitarTodos;
    private javax.swing.JButton jButtonListaQuitarUno;
    private javax.swing.JButton jButtonListaTomarTodos;
    private javax.swing.JButton jButtonListaTomarUno;
    private javax.swing.JButton jButtonQuitarCondicion;
    private javax.swing.JComboBox<Columna> jComboBoxCampos;
    private javax.swing.JComboBox<String> jComboBoxOperadorLogico;
    private javax.swing.JComboBox<String> jComboBoxOperadorRelacional;
    private javax.swing.JComboBox<String> jComboBoxTablas;
    private javax.swing.JLabel jLabelCampo;
    private javax.swing.JLabel jLabelOperador;
    private javax.swing.JLabel jLabelSentenciaSql;
    private javax.swing.JLabel jLabelTablas;
    private javax.swing.JLabel jLabelTipoDato;
    private javax.swing.JLabel jLabelValor1;
    private javax.swing.JLabel jLabelValor2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPaneCondiciones;
    private javax.swing.JScrollPane jScrollPaneDisponibles;
    private javax.swing.JScrollPane jScrollPaneSentencia;
    private javax.swing.JScrollPane jScrollPaneTablaResultado;
    private javax.swing.JScrollPane jScrollPaneTomados;
    private javax.swing.JTable jTableCondiciones;
    private javax.swing.JTable jTableDisponibles;
    private javax.swing.JTable jTableTablaResultado;
    private javax.swing.JTable jTableTomados;
    private javax.swing.JTextArea jTextAreaSentencia;
    private javax.swing.JTextField jTextFieldValor1;
    private javax.swing.JTextField jTextFieldValor2;
    // End of variables declaration//GEN-END:variables
}
