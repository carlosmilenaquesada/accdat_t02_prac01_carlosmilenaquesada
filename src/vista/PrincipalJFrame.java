package vista;

import java.sql.*;
import controlador.Conexion;
import controlador.ConsultaDeMetadatos;
import controlador.ConsultaDeTablas;
import java.awt.Component;

import java.awt.event.ItemEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;

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
        
        jButtonAgregarCondicion.setEnabled(false);

        //Rellenar lista de tablas inicial
        dcbmTablas.addAll(cdm.obtenerNombreTablas());
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelPrincipal = new javax.swing.JPanel();
        jPanelSeleccionTabla = new javax.swing.JPanel();
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
        jPanelCreacionCondicionales = new javax.swing.JPanel();
        jLabelCampo = new javax.swing.JLabel();
        jComboBoxCampos = new javax.swing.JComboBox<>();
        jLabelValor1 = new javax.swing.JLabel();
        jTextFieldValor1 = new javax.swing.JTextField();
        jLabelOperador = new javax.swing.JLabel();
        jComboBoxOperadorLogico = new javax.swing.JComboBox<>();
        jLabelValor2 = new javax.swing.JLabel();
        jTextFieldValor2 = new javax.swing.JTextField();
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
        jPanelSentenciaSql = new javax.swing.JPanel();
        jScrollPaneSentencia = new javax.swing.JScrollPane();
        jTextAreaSentencia = new javax.swing.JTextArea();
        jButtonEjecutarSentencia = new javax.swing.JButton();
        jPanelTablaExportacion = new javax.swing.JPanel();
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

        jPanelPrincipal.setLayout(null);

        jPanelSeleccionTabla.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Seleccionar tabla", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanelSeleccionTabla.setLayout(null);

        jLabelTablas.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTablas.setText("Tabla");
        jPanelSeleccionTabla.add(jLabelTablas);
        jLabelTablas.setBounds(10, 20, 70, 25);

        jComboBoxTablas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxTablasItemStateChanged(evt);
            }
        });
        jPanelSeleccionTabla.add(jComboBoxTablas);
        jComboBoxTablas.setBounds(90, 20, 120, 25);

        jScrollPaneDisponibles.setFocusable(false);

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
        jTableDisponibles.setFocusable(false);
        jTableDisponibles.setName(""); // NOI18N
        jTableDisponibles.getTableHeader().setReorderingAllowed(false);
        jScrollPaneDisponibles.setViewportView(jTableDisponibles);
        if (jTableDisponibles.getColumnModel().getColumnCount() > 0) {
            jTableDisponibles.getColumnModel().getColumn(0).setResizable(false);
        }

        jPanelSeleccionTabla.add(jScrollPaneDisponibles);
        jScrollPaneDisponibles.setBounds(10, 55, 200, 185);

        jButtonListaTomarUno.setText(">");
        jButtonListaTomarUno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListaTomarUnoActionPerformed(evt);
            }
        });
        jPanelSeleccionTabla.add(jButtonListaTomarUno);
        jButtonListaTomarUno.setBounds(220, 90, 50, 25);

        jButtonListaTomarTodos.setText(">>");
        jButtonListaTomarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListaTomarTodosActionPerformed(evt);
            }
        });
        jPanelSeleccionTabla.add(jButtonListaTomarTodos);
        jButtonListaTomarTodos.setBounds(220, 125, 50, 25);

        jButtonListaQuitarUno.setText("<");
        jButtonListaQuitarUno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListaQuitarUnoActionPerformed(evt);
            }
        });
        jPanelSeleccionTabla.add(jButtonListaQuitarUno);
        jButtonListaQuitarUno.setBounds(220, 160, 50, 25);

        jButtonListaQuitarTodos.setText("<<");
        jButtonListaQuitarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListaQuitarTodosActionPerformed(evt);
            }
        });
        jPanelSeleccionTabla.add(jButtonListaQuitarTodos);
        jButtonListaQuitarTodos.setBounds(220, 195, 50, 25);

        jScrollPaneTomados.setFocusable(false);

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
        jTableTomados.setFocusable(false);
        jTableTomados.getTableHeader().setReorderingAllowed(false);
        jScrollPaneTomados.setViewportView(jTableTomados);
        if (jTableTomados.getColumnModel().getColumnCount() > 0) {
            jTableTomados.getColumnModel().getColumn(0).setResizable(false);
        }

        jPanelSeleccionTabla.add(jScrollPaneTomados);
        jScrollPaneTomados.setBounds(280, 55, 200, 185);

        jPanelPrincipal.add(jPanelSeleccionTabla);
        jPanelSeleccionTabla.setBounds(10, 10, 490, 250);

        jPanelCreacionCondicionales.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Crear condicional", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanelCreacionCondicionales.setLayout(null);

        jLabelCampo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelCampo.setText("Campo");
        jPanelCreacionCondicionales.add(jLabelCampo);
        jLabelCampo.setBounds(10, 20, 55, 25);

        jComboBoxCampos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxCamposItemStateChanged(evt);
            }
        });
        jPanelCreacionCondicionales.add(jComboBoxCampos);
        jComboBoxCampos.setBounds(75, 20, 120, 25);

        jLabelValor1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelValor1.setText("Valor 1");
        jPanelCreacionCondicionales.add(jLabelValor1);
        jLabelValor1.setBounds(235, 20, 45, 25);
        jPanelCreacionCondicionales.add(jTextFieldValor1);
        jTextFieldValor1.setBounds(290, 20, 120, 25);

        jLabelOperador.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelOperador.setText("Operador");
        jPanelCreacionCondicionales.add(jLabelOperador);
        jLabelOperador.setBounds(10, 55, 55, 25);

        jComboBoxOperadorLogico.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxOperadorLogicoItemStateChanged(evt);
            }
        });
        jPanelCreacionCondicionales.add(jComboBoxOperadorLogico);
        jComboBoxOperadorLogico.setBounds(75, 55, 120, 25);

        jLabelValor2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelValor2.setText("Valor 2");
        jPanelCreacionCondicionales.add(jLabelValor2);
        jLabelValor2.setBounds(235, 55, 45, 25);
        jPanelCreacionCondicionales.add(jTextFieldValor2);
        jTextFieldValor2.setBounds(290, 55, 120, 25);

        jPanelCreacionCondicionales.add(jComboBoxOperadorRelacional);
        jComboBoxOperadorRelacional.setBounds(205, 90, 75, 25);

        jButtonAgregarCondicion.setText("+");
        jButtonAgregarCondicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarCondicionActionPerformed(evt);
            }
        });
        jPanelCreacionCondicionales.add(jButtonAgregarCondicion);
        jButtonAgregarCondicion.setBounds(360, 90, 50, 25);

        jScrollPaneCondiciones.setFocusable(false);

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
        jTableCondiciones.setFocusable(false);
        jTableCondiciones.getTableHeader().setReorderingAllowed(false);
        jScrollPaneCondiciones.setViewportView(jTableCondiciones);
        if (jTableCondiciones.getColumnModel().getColumnCount() > 0) {
            jTableCondiciones.getColumnModel().getColumn(0).setResizable(false);
            jTableCondiciones.getColumnModel().getColumn(1).setResizable(false);
        }

        jPanelCreacionCondicionales.add(jScrollPaneCondiciones);
        jScrollPaneCondiciones.setBounds(10, 125, 345, 115);

        jButtonQuitarCondicion.setText("-");
        jPanelCreacionCondicionales.add(jButtonQuitarCondicion);
        jButtonQuitarCondicion.setBounds(360, 175, 50, 25);

        jPanelPrincipal.add(jPanelCreacionCondicionales);
        jPanelCreacionCondicionales.setBounds(510, 10, 420, 250);

        jPanelSentenciaSql.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Sentencia SQL generada", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanelSentenciaSql.setLayout(null);

        jScrollPaneSentencia.setFocusable(false);

        jTextAreaSentencia.setColumns(20);
        jTextAreaSentencia.setRows(5);
        jTextAreaSentencia.setFocusable(false);
        jScrollPaneSentencia.setViewportView(jTextAreaSentencia);

        jPanelSentenciaSql.add(jScrollPaneSentencia);
        jScrollPaneSentencia.setBounds(10, 20, 805, 105);

        jButtonEjecutarSentencia.setText("Ejecutar");
        jPanelSentenciaSql.add(jButtonEjecutarSentencia);
        jButtonEjecutarSentencia.setBounds(820, 60, 90, 25);

        jPanelPrincipal.add(jPanelSentenciaSql);
        jPanelSentenciaSql.setBounds(10, 270, 920, 135);

        jPanelTablaExportacion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Resultado de la consulta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanelTablaExportacion.setLayout(null);

        jScrollPaneTablaResultado.setFocusable(false);

        jTableTablaResultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Columna 1", "Columna 2", "Columna 3", "Columna 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableTablaResultado.setFocusable(false);
        jTableTablaResultado.getTableHeader().setReorderingAllowed(false);
        jScrollPaneTablaResultado.setViewportView(jTableTablaResultado);
        if (jTableTablaResultado.getColumnModel().getColumnCount() > 0) {
            jTableTablaResultado.getColumnModel().getColumn(0).setResizable(false);
            jTableTablaResultado.getColumnModel().getColumn(1).setResizable(false);
            jTableTablaResultado.getColumnModel().getColumn(2).setResizable(false);
            jTableTablaResultado.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanelTablaExportacion.add(jScrollPaneTablaResultado);
        jScrollPaneTablaResultado.setBounds(10, 20, 805, 190);

        jButtonExportarTabla.setText("Exportar");
        jPanelTablaExportacion.add(jButtonExportarTabla);
        jButtonExportarTabla.setBounds(820, 60, 90, 25);

        jPanelPrincipal.add(jPanelTablaExportacion);
        jPanelTablaExportacion.setBounds(10, 420, 920, 220);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 1034, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        jButtonAgregarCondicion.setEnabled(false);        
    }
    
    private String obtenerLineaCondicional() {
        StringBuilder sb = new StringBuilder();
        //if(dcbmCampos)
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
    
    private boolean validarInputsDeCondicional() {
        boolean habilitar = true;
        
        if ((Defectos.tipoDeCondicional.equals(TipoDeCondicional.TIPO_COMPARACION)
                || Defectos.tipoDeCondicional.equals(TipoDeCondicional.TIPO_LIKE))
                && jTextFieldValor1.getText().isEmpty()) {
            habilitar = false;
        } else {
            if (Defectos.tipoDeCondicional.equals(TipoDeCondicional.TIPO_BETWEEN)
                    && (jTextFieldValor1.getText().isEmpty() || jTextFieldValor2.getText().isEmpty())) {
                habilitar = false;
            }
        }
        return habilitar;
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
            dcbmCampos.setSelectedItem(dcbmCampos.getElementAt(0));
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

            if (tipoDatoSql.equals("NUMBER") || tipoDatoSql.equals("DATE")) {
                dcbmOperadorLogico.addAll(Defectos.OP_LOGICO_NUMBER_Y_DATE);
            } else {
                dcbmOperadorLogico.addAll(Defectos.OP_LOGICO_VARCHAR2);
            }
            dcbmOperadorLogico.setSelectedItem(dcbmOperadorLogico.getElementAt(0));
            dcbmOperadorRelacional.addAll(Defectos.OP_RELACIONAL);
            dcbmOperadorRelacional.setSelectedItem(dcbmOperadorRelacional.getElementAt(0));
        }
     }//GEN-LAST:event_jComboBoxCamposItemStateChanged

    private void jComboBoxOperadorLogicoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxOperadorLogicoItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {           
            String tipoOperador = ((String) dcbmOperadorLogico.getSelectedItem());
            //Se modifica el tipo de distribución de los inputs que personalizan
            //los condicionales en base a tipo de operador seleccionado:
            modificarInputsDeCondiciones(tipoOperador);
            jButtonAgregarCondicion.setEnabled(validarInputsDeCondicional());
        }
    }//GEN-LAST:event_jComboBoxOperadorLogicoItemStateChanged

    private void jButtonAgregarCondicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarCondicionActionPerformed
        String sentenciaCondicional = obtenerLineaCondicional();
        System.out.println(sentenciaCondicional);
    }//GEN-LAST:event_jButtonAgregarCondicionActionPerformed
    
    public static void main(String args[]) {
        /*try {
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
        }*/
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
    private javax.swing.JLabel jLabelTablas;
    private javax.swing.JLabel jLabelValor1;
    private javax.swing.JLabel jLabelValor2;
    private javax.swing.JPanel jPanelCreacionCondicionales;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JPanel jPanelSeleccionTabla;
    private javax.swing.JPanel jPanelSentenciaSql;
    private javax.swing.JPanel jPanelTablaExportacion;
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
