package vista;

import controlador.Defectos;
import controlador.Herramientas;
import java.sql.ResultSet;
import java.sql.SQLException;
import controlador.ConsultasDeEsquema;
import controlador.ConsultaDeTabla;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Columna;
import controlador.Defectos.TipoDeCondicional;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PrincipalJFrame extends javax.swing.JFrame {

    //Creación de mis variables-------------------------------------------------
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

    ArrayList<Columna> cabecerasTablaFinal = null;
    boolean layoutCargado = false;

    TipoDeCondicional tipoDeCondicional;

    String tipoDatoColumna = "";

    public PrincipalJFrame() {

        LoginJDialog ljd = new LoginJDialog(this, true);
        ljd.setVisible(true);

        initComponents();

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

        //Colecciones 
        columnasTablaEnFoco = new ArrayList<>();

        try {
            //Rellenar lista de tablas inicial
            dcbmTablas.addAll(ConsultasDeEsquema.obtenerNombreTablas());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, Defectos.MENSAJES[2]);
            System.exit(0);
        }
        if (dcbmTablas.getSize() == 0) {
            JOptionPane.showMessageDialog(null, Defectos.MENSAJES[3]);
        }
        tipoDeCondicional = TipoDeCondicional.NO_ASIGNADO;

        cabecerasTablaFinal = new ArrayList<>();
        for (Component c : jPanelEntradasValores.getComponents()) {
            c.setVisible(false);
        }
        jPanelValorVarcharUno.setVisible(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupOpcionesLike = new javax.swing.ButtonGroup();
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
        jPanelEntradasValores = new javax.swing.JPanel();
        jPanelValorVarcharUno = new javax.swing.JPanel();
        jLabelValorVarcharUno = new javax.swing.JLabel();
        jTextFieldValorVarcharUno = new javax.swing.JTextField();
        jPanelValorNumberUno = new javax.swing.JPanel();
        jLabelValorNumberUno = new javax.swing.JLabel();
        jTextFieldValorNumeroUno = new javax.swing.JTextField();
        jPanelValorDateInicio = new javax.swing.JPanel();
        jLabelValorDateInicio = new javax.swing.JLabel();
        jSpinnerDateInicio = new javax.swing.JSpinner();
        jPanelValorNumberDos = new javax.swing.JPanel();
        jLabelValorNumberDos = new javax.swing.JLabel();
        jTextFieldValorNumberDos = new javax.swing.JTextField();
        jPanelValorDateFin = new javax.swing.JPanel();
        jLabelValorDateFin = new javax.swing.JLabel();
        jSpinnerDateFin = new javax.swing.JSpinner();
        jPanelValorOpcionesLike = new javax.swing.JPanel();
        jRadioButtonEmpiece = new javax.swing.JRadioButton();
        jRadioButtonTermine = new javax.swing.JRadioButton();
        jRadioButtonContenga = new javax.swing.JRadioButton();
        jLabelCampo = new javax.swing.JLabel();
        jComboBoxCampos = new javax.swing.JComboBox<>();
        jLabelOperador = new javax.swing.JLabel();
        jComboBoxOperadorLogico = new javax.swing.JComboBox<>();
        jLabelInfoDatoElegido = new javax.swing.JLabel();
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
        jButtonExportar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tema 02. Práctica 01. Metadatos");

        jPanelPrincipal.setLayout(null);

        jPanelSeleccionTabla.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Seleccionar tabla", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanelSeleccionTabla.setLayout(null);

        jLabelTablas.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTablas.setText("Tabla");
        jPanelSeleccionTabla.add(jLabelTablas);
        jLabelTablas.setBounds(10, 37, 50, 25);

        jComboBoxTablas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxTablasItemStateChanged(evt);
            }
        });
        jPanelSeleccionTabla.add(jComboBoxTablas);
        jComboBoxTablas.setBounds(70, 37, 150, 25);

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
        jScrollPaneDisponibles.setBounds(10, 80, 180, 210);

        jButtonListaTomarUno.setText(">");
        jButtonListaTomarUno.setEnabled(false);
        jButtonListaTomarUno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListaTomarUnoActionPerformed(evt);
            }
        });
        jPanelSeleccionTabla.add(jButtonListaTomarUno);
        jButtonListaTomarUno.setBounds(200, 110, 50, 25);

        jButtonListaTomarTodos.setText(">>");
        jButtonListaTomarTodos.setEnabled(false);
        jButtonListaTomarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListaTomarTodosActionPerformed(evt);
            }
        });
        jPanelSeleccionTabla.add(jButtonListaTomarTodos);
        jButtonListaTomarTodos.setBounds(200, 145, 50, 25);

        jButtonListaQuitarUno.setText("<");
        jButtonListaQuitarUno.setEnabled(false);
        jButtonListaQuitarUno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListaQuitarUnoActionPerformed(evt);
            }
        });
        jPanelSeleccionTabla.add(jButtonListaQuitarUno);
        jButtonListaQuitarUno.setBounds(200, 180, 50, 25);

        jButtonListaQuitarTodos.setText("<<");
        jButtonListaQuitarTodos.setEnabled(false);
        jButtonListaQuitarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListaQuitarTodosActionPerformed(evt);
            }
        });
        jPanelSeleccionTabla.add(jButtonListaQuitarTodos);
        jButtonListaQuitarTodos.setBounds(200, 215, 50, 25);

        jScrollPaneTomados.setDoubleBuffered(true);
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
        jScrollPaneTomados.setBounds(260, 80, 180, 210);

        jPanelPrincipal.add(jPanelSeleccionTabla);
        jPanelSeleccionTabla.setBounds(10, 10, 450, 300);

        jPanelCreacionCondicionales.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Crear condicional", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanelCreacionCondicionales.setLayout(null);

        jPanelEntradasValores.setEnabled(false);
        jPanelEntradasValores.setOpaque(false);
        jPanelEntradasValores.setLayout(null);

        jPanelValorVarcharUno.setLayout(null);

        jLabelValorVarcharUno.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelValorVarcharUno.setText("Texto 1");
        jLabelValorVarcharUno.setEnabled(false);
        jLabelValorVarcharUno.setOpaque(true);
        jPanelValorVarcharUno.add(jLabelValorVarcharUno);
        jLabelValorVarcharUno.setBounds(5, 5, 60, 30);

        jTextFieldValorVarcharUno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldValorVarcharUno.setEnabled(false);
        jPanelValorVarcharUno.add(jTextFieldValorVarcharUno);
        jTextFieldValorVarcharUno.setBounds(80, 5, 160, 30);

        jPanelEntradasValores.add(jPanelValorVarcharUno);
        jPanelValorVarcharUno.setBounds(0, 0, 240, 40);

        jPanelValorNumberUno.setLayout(null);

        jLabelValorNumberUno.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelValorNumberUno.setText("Número 1");
        jLabelValorNumberUno.setOpaque(true);
        jPanelValorNumberUno.add(jLabelValorNumberUno);
        jLabelValorNumberUno.setBounds(5, 5, 60, 30);

        jTextFieldValorNumeroUno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanelValorNumberUno.add(jTextFieldValorNumeroUno);
        jTextFieldValorNumeroUno.setBounds(80, 5, 160, 30);

        jPanelEntradasValores.add(jPanelValorNumberUno);
        jPanelValorNumberUno.setBounds(0, 0, 240, 40);

        jPanelValorDateInicio.setLayout(null);

        jLabelValorDateInicio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelValorDateInicio.setText("Fecha inicio");
        jLabelValorDateInicio.setOpaque(true);
        jPanelValorDateInicio.add(jLabelValorDateInicio);
        jLabelValorDateInicio.setBounds(5, 5, 80, 30);

        jSpinnerDateInicio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jSpinnerDateInicio.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.MINUTE));
        jSpinnerDateInicio.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jSpinnerDateInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelValorDateInicio.add(jSpinnerDateInicio);
        jSpinnerDateInicio.setBounds(100, 5, 140, 30);

        jPanelEntradasValores.add(jPanelValorDateInicio);
        jPanelValorDateInicio.setBounds(0, 0, 240, 40);

        jPanelValorNumberDos.setLayout(null);

        jLabelValorNumberDos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelValorNumberDos.setText("Número 2");
        jLabelValorNumberDos.setOpaque(true);
        jPanelValorNumberDos.add(jLabelValorNumberDos);
        jLabelValorNumberDos.setBounds(5, 5, 60, 30);
        jPanelValorNumberDos.add(jTextFieldValorNumberDos);
        jTextFieldValorNumberDos.setBounds(80, 5, 160, 30);

        jPanelEntradasValores.add(jPanelValorNumberDos);
        jPanelValorNumberDos.setBounds(0, 40, 240, 40);

        jPanelValorDateFin.setLayout(null);

        jLabelValorDateFin.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelValorDateFin.setText("Fecha fin");
        jLabelValorDateFin.setOpaque(true);
        jPanelValorDateFin.add(jLabelValorDateFin);
        jLabelValorDateFin.setBounds(5, 5, 80, 30);

        jSpinnerDateFin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jSpinnerDateFin.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.MINUTE));
        jSpinnerDateFin.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jSpinnerDateFin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelValorDateFin.add(jSpinnerDateFin);
        jSpinnerDateFin.setBounds(100, 5, 140, 30);

        jPanelEntradasValores.add(jPanelValorDateFin);
        jPanelValorDateFin.setBounds(0, 40, 240, 40);

        jPanelValorOpcionesLike.setLayout(null);

        buttonGroupOpcionesLike.add(jRadioButtonEmpiece);
        jRadioButtonEmpiece.setText("empiece");
        jPanelValorOpcionesLike.add(jRadioButtonEmpiece);
        jRadioButtonEmpiece.setBounds(1, 5, 80, 30);

        buttonGroupOpcionesLike.add(jRadioButtonTermine);
        jRadioButtonTermine.setText("termine");
        jPanelValorOpcionesLike.add(jRadioButtonTermine);
        jRadioButtonTermine.setBounds(81, 5, 80, 30);

        buttonGroupOpcionesLike.add(jRadioButtonContenga);
        jRadioButtonContenga.setText("contenga");
        jPanelValorOpcionesLike.add(jRadioButtonContenga);
        jRadioButtonContenga.setBounds(161, 5, 80, 30);

        jPanelEntradasValores.add(jPanelValorOpcionesLike);
        jPanelValorOpcionesLike.setBounds(0, 40, 240, 40);

        jPanelCreacionCondicionales.add(jPanelEntradasValores);
        jPanelEntradasValores.setBounds(225, 41, 240, 80);

        jLabelCampo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelCampo.setText("Campo");
        jLabelCampo.setEnabled(false);
        jPanelCreacionCondicionales.add(jLabelCampo);
        jLabelCampo.setBounds(10, 48, 55, 25);

        jComboBoxCampos.setEnabled(false);
        jComboBoxCampos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxCamposItemStateChanged(evt);
            }
        });
        jPanelCreacionCondicionales.add(jComboBoxCampos);
        jComboBoxCampos.setBounds(75, 48, 140, 25);

        jLabelOperador.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelOperador.setText("Operador");
        jLabelOperador.setEnabled(false);
        jPanelCreacionCondicionales.add(jLabelOperador);
        jLabelOperador.setBounds(10, 87, 55, 25);

        jComboBoxOperadorLogico.setEnabled(false);
        jComboBoxOperadorLogico.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxOperadorLogicoItemStateChanged(evt);
            }
        });
        jPanelCreacionCondicionales.add(jComboBoxOperadorLogico);
        jComboBoxOperadorLogico.setBounds(75, 87, 140, 25);

        jLabelInfoDatoElegido.setEnabled(false);
        jPanelCreacionCondicionales.add(jLabelInfoDatoElegido);
        jLabelInfoDatoElegido.setBounds(10, 20, 300, 20);

        jComboBoxOperadorRelacional.setEnabled(false);
        jPanelCreacionCondicionales.add(jComboBoxOperadorRelacional);
        jComboBoxOperadorRelacional.setBounds(205, 130, 75, 25);

        jButtonAgregarCondicion.setText("+");
        jButtonAgregarCondicion.setEnabled(false);
        jButtonAgregarCondicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarCondicionActionPerformed(evt);
            }
        });
        jPanelCreacionCondicionales.add(jButtonAgregarCondicion);
        jButtonAgregarCondicion.setBounds(415, 130, 50, 25);

        jScrollPaneCondiciones.setEnabled(false);
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
            jTableCondiciones.getColumnModel().getColumn(1).setMaxWidth(80);
        }

        jPanelCreacionCondicionales.add(jScrollPaneCondiciones);
        jScrollPaneCondiciones.setBounds(10, 165, 395, 125);

        jButtonQuitarCondicion.setText("-");
        jButtonQuitarCondicion.setEnabled(false);
        jButtonQuitarCondicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQuitarCondicionActionPerformed(evt);
            }
        });
        jPanelCreacionCondicionales.add(jButtonQuitarCondicion);
        jButtonQuitarCondicion.setBounds(415, 190, 50, 25);

        jPanelPrincipal.add(jPanelCreacionCondicionales);
        jPanelCreacionCondicionales.setBounds(470, 10, 480, 300);

        jPanelSentenciaSql.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Sentencia SQL generada", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanelSentenciaSql.setLayout(null);

        jScrollPaneSentencia.setEnabled(false);
        jScrollPaneSentencia.setFocusable(false);

        jTextAreaSentencia.setEditable(false);
        jTextAreaSentencia.setColumns(20);
        jTextAreaSentencia.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTextAreaSentencia.setRows(5);
        jTextAreaSentencia.setEnabled(false);
        jScrollPaneSentencia.setViewportView(jTextAreaSentencia);

        jPanelSentenciaSql.add(jScrollPaneSentencia);
        jScrollPaneSentencia.setBounds(10, 20, 805, 105);

        jButtonEjecutarSentencia.setText("Ejecutar");
        jButtonEjecutarSentencia.setEnabled(false);
        jButtonEjecutarSentencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEjecutarSentenciaActionPerformed(evt);
            }
        });
        jPanelSentenciaSql.add(jButtonEjecutarSentencia);
        jButtonEjecutarSentencia.setBounds(820, 60, 90, 25);

        jPanelPrincipal.add(jPanelSentenciaSql);
        jPanelSentenciaSql.setBounds(10, 320, 940, 135);

        jPanelTablaExportacion.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Resultado de la consulta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
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
        jTableTablaResultado.getTableHeader().setReorderingAllowed(false);
        jScrollPaneTablaResultado.setViewportView(jTableTablaResultado);
        if (jTableTablaResultado.getColumnModel().getColumnCount() > 0) {
            jTableTablaResultado.getColumnModel().getColumn(0).setResizable(false);
            jTableTablaResultado.getColumnModel().getColumn(1).setResizable(false);
            jTableTablaResultado.getColumnModel().getColumn(2).setResizable(false);
            jTableTablaResultado.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanelTablaExportacion.add(jScrollPaneTablaResultado);
        jScrollPaneTablaResultado.setBounds(10, 20, 805, 195);

        jButtonExportar.setText("Exportar");
        jButtonExportar.setEnabled(false);
        jButtonExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExportarActionPerformed(evt);
            }
        });
        jPanelTablaExportacion.add(jButtonExportar);
        jButtonExportar.setBounds(820, 105, 90, 25);

        jPanelPrincipal.add(jPanelTablaExportacion);
        jPanelTablaExportacion.setBounds(10, 465, 940, 225);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 960, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void reinicioValoresFormulario() {
        Herramientas.limpiarTabla(dtmDisponibles);
        Herramientas.limpiarTabla(dtmTomados);
        Herramientas.limpiarTabla(dtmCondiciones);
        dcbmCampos.removeAllElements();
        dcbmOperadorLogico.removeAllElements();
        jLabelInfoDatoElegido.setText("");
        jTextAreaSentencia.setText("");
        tipoDeCondicional = TipoDeCondicional.NO_ASIGNADO;
    }

    private String condicionPorTipoComparacion(String textoUno, String numberUno, String fechaIni) {
        String condicional = "";
        if (tipoDatoColumna.equals("VARCHAR2")) {
            if (!textoUno.isEmpty()) {
                condicional = "'" + textoUno + "'";
            }
        } else {
            if (tipoDatoColumna.equals("NUMBER")) {
                if (esDatoNumericoValido(numberUno)) {
                    condicional = numberUno;
                } else {
                    JOptionPane.showMessageDialog(null, Defectos.MENSAJES[4]);
                }
            } else {
                condicional = fechaIni;
            }
        }
        return condicional;
    }

    private String condicionPorTipoLike(String textoUno) {
        String condicional = "";
        if (!textoUno.isEmpty()) {
            if (jRadioButtonEmpiece.isSelected()) {
                condicional = "'" + textoUno + "%'";
            } else {
                if (jRadioButtonTermine.isSelected()) {
                    condicional = "'%" + textoUno + "'";
                } else {
                    condicional = "'%" + textoUno + "%'";
                }
            }
        }
        return condicional;
    }

    private boolean esDatoNumericoValido(String dato) {
        boolean esDatoNumerico = true;
        try {
            Double.valueOf(dato);
        } catch (Exception e) {
            esDatoNumerico = false;
        }
        return esDatoNumerico;
    }

    private String condicionPorTipoBetweenNumero() {
        String valorNumberUno = jTextFieldValorNumeroUno.getText();
        String valorNumberDos = jTextFieldValorNumberDos.getText();
        String condicional = "";
        if (esDatoNumericoValido(valorNumberUno) && esDatoNumericoValido(valorNumberDos)) {
            condicional = valorNumberUno + " AND " + valorNumberDos;
        } else {
            JOptionPane.showMessageDialog(null, Defectos.MENSAJES[5]);
        }
        return condicional;
    }

    private String condicionPorTipoBetweenFecha() {
        String condicional = "";
        if (((Date) (jSpinnerDateInicio).getValue()).after((Date) jSpinnerDateFin.getValue())) {
            JOptionPane.showMessageDialog(null, Defectos.MENSAJES[6]);
        } else {
            condicional = "'" + Defectos.SDF.format(jSpinnerDateInicio.getValue()) + "' AND '" + Defectos.SDF.format(jSpinnerDateFin.getValue()) + "'";
        }
        return condicional;
    }

    private String obtenerLineaCondicional() {
        String valorTextUno = jTextFieldValorVarcharUno.getText();
        String valorNumberUno = jTextFieldValorNumeroUno.getText();
        String fechaIni = "'" + Defectos.SDF.format(jSpinnerDateInicio.getValue()) + "'";
        String condicional = "";
        switch (tipoDeCondicional) {
            case TIPO_COMPARACION:
                condicional = condicionPorTipoComparacion(valorTextUno, valorNumberUno, fechaIni);
                break;
            case TIPO_LIKE:
                condicional = condicionPorTipoLike(valorTextUno);
                break;
            case TIPO_BETWEEN:
                if (tipoDatoColumna.equals("NUMBER")) {
                    condicional = condicionPorTipoBetweenNumero();
                } else {
                    condicional = condicionPorTipoBetweenFecha();
                }
                break;
            case NO_ASIGNADO:
                break;
        }
        return condicional;
    }

    private void actualizarSentenciaSql() {
        String sentencia = "";
        sentencia = "SELECT";
        if (dtmDisponibles.getRowCount() == 0 || dtmTomados.getRowCount() == 0) {
            sentencia += " *";
        } else {
            for (int i = 0; i < dtmTomados.getRowCount(); i++) {
                sentencia += " " + (String) dtmTomados.getValueAt(i, 0) + ",";
            }
            sentencia = sentencia.substring(0, sentencia.length() - 1);
        }
        sentencia += "\nFROM " + (String) dcbmTablas.getSelectedItem();
        if (dtmCondiciones.getRowCount() > 0) {
            sentencia += "\nWHERE";
            for (int i = 0; i < dtmCondiciones.getRowCount() - 1; i++) {
                sentencia += " " + (String) dtmCondiciones.getValueAt(i, 0)
                        + " \n" + dtmCondiciones.getValueAt(i, 1);
            }
            sentencia += " " + (String) dtmCondiciones.getValueAt(dtmCondiciones.getRowCount() - 1, 0);
        }
        sentencia += ";";

        jTextAreaSentencia.setText(sentencia);
    }

    private void cargaInicialFormulario() {
        for (Component c : jPanelSeleccionTabla.getComponents()) {
            c.setEnabled(true);
        }
        for (Component c : jPanelCreacionCondicionales.getComponents()) {
            c.setEnabled(true);
        }
        jTextFieldValorVarcharUno.setEnabled(true);
        jLabelValorVarcharUno.setEnabled(true);
        jScrollPaneSentencia.setEnabled(true);
        jTextAreaSentencia.setEnabled(true);
        jButtonEjecutarSentencia.setEnabled(true);
        dcbmOperadorRelacional.addAll(Defectos.OP_RELACIONAL);
        layoutCargado = true;
    }

    private void jButtonListaTomarUnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListaTomarUnoActionPerformed
        Herramientas.traspasoDeSeleccionados(jTableDisponibles, dtmDisponibles, dtmTomados);
        actualizarSentenciaSql();
    }//GEN-LAST:event_jButtonListaTomarUnoActionPerformed

    private void jButtonListaTomarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListaTomarTodosActionPerformed
        Herramientas.traspasoDeTodos(dtmDisponibles, dtmTomados);
        Herramientas.limpiarTabla(dtmDisponibles);
        actualizarSentenciaSql();
    }//GEN-LAST:event_jButtonListaTomarTodosActionPerformed

    private void jButtonListaQuitarUnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListaQuitarUnoActionPerformed
        Herramientas.traspasoDeSeleccionados(jTableTomados, dtmTomados, dtmDisponibles);
        actualizarSentenciaSql();
    }//GEN-LAST:event_jButtonListaQuitarUnoActionPerformed

    private void jButtonListaQuitarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListaQuitarTodosActionPerformed
        Herramientas.traspasoDeTodos(dtmTomados, dtmDisponibles);
        Herramientas.limpiarTabla(dtmTomados);
        actualizarSentenciaSql();
    }//GEN-LAST:event_jButtonListaQuitarTodosActionPerformed

    private void jComboBoxTablasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxTablasItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            if (layoutCargado == true) {
                reinicioValoresFormulario();
            } else {
                cargaInicialFormulario();
            }
            try {
                columnasTablaEnFoco = ConsultasDeEsquema.obtenerMetasDeColumnasDeTabla((String) dcbmTablas.getSelectedItem());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, Defectos.MENSAJES[7]);
            }
            for (Columna columna : columnasTablaEnFoco) {
                dtmDisponibles.addRow(new String[]{columna.getName()});
            }
            dcbmCampos.addAll(columnasTablaEnFoco);
            dcbmCampos.setSelectedItem(dcbmCampos.getElementAt(0));

            actualizarSentenciaSql();
        }
    }//GEN-LAST:event_jComboBoxTablasItemStateChanged

    private void jComboBoxCamposItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxCamposItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            tipoDatoColumna = ((Columna) dcbmCampos.getSelectedItem()).getType();
            jLabelInfoDatoElegido.setText("Tipo de dato del campo: " + Herramientas.obtenerDatoConPrecision((Columna) dcbmCampos.getSelectedItem()));
            dcbmOperadorLogico.removeAllElements();
            if (tipoDatoColumna.equals("VARCHAR2")) {
                dcbmOperadorLogico.addAll(Defectos.OP_LOGICO_VARCHAR2);
            } else {
                dcbmOperadorLogico.addAll(Defectos.OP_LOGICO_NUMBER_Y_DATE);
            }
            dcbmOperadorRelacional.setSelectedItem(dcbmOperadorRelacional.getElementAt(0));
            dcbmOperadorLogico.setSelectedItem(dcbmOperadorLogico.getElementAt(0));

        }
     }//GEN-LAST:event_jComboBoxCamposItemStateChanged


    private void jComboBoxOperadorLogicoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxOperadorLogicoItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            tipoDeCondicional = Herramientas.comprobarTipoCondicional((String) dcbmOperadorLogico.getSelectedItem());

            for (Component c : jPanelEntradasValores.getComponents()) {
                c.setVisible(false);

            }
            if (!tipoDeCondicional.equals(TipoDeCondicional.TIPO_NULL)) {
                switch (tipoDatoColumna) {
                    case "NUMBER":
                        jPanelValorNumberUno.setVisible(true);
                        if (tipoDeCondicional.equals(TipoDeCondicional.TIPO_BETWEEN)) {
                            jPanelValorNumberDos.setVisible(true);
                        }
                        break;
                    case "DATE":
                        jPanelValorDateInicio.setVisible(true);
                        if (tipoDeCondicional.equals(TipoDeCondicional.TIPO_BETWEEN)) {
                            jPanelValorDateFin.setVisible(true);
                        }
                        break;
                    case "VARCHAR2":
                        jPanelValorVarcharUno.setVisible(true);
                        if (tipoDeCondicional.equals(TipoDeCondicional.TIPO_LIKE)) {
                            jPanelValorOpcionesLike.setVisible(true);
                        }
                        break;
                    default:
                }
            }
        }
    }//GEN-LAST:event_jComboBoxOperadorLogicoItemStateChanged

    private void jButtonAgregarCondicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarCondicionActionPerformed
        String condicional = obtenerLineaCondicional();
        if (!condicional.isEmpty() || tipoDeCondicional == TipoDeCondicional.TIPO_NULL) {
            String sentenciaCondicional = (dcbmCampos.getSelectedItem().toString()) + " " + (String) dcbmOperadorLogico.getSelectedItem() + " " + condicional;
            if (tipoDeCondicional == TipoDeCondicional.TIPO_NULL) {
                sentenciaCondicional = sentenciaCondicional.substring(0, sentenciaCondicional.length() - 1);
            }
            dtmCondiciones.addRow(new Object[]{sentenciaCondicional, dcbmOperadorRelacional.getSelectedItem()});
            actualizarSentenciaSql();
        }
    }//GEN-LAST:event_jButtonAgregarCondicionActionPerformed

    private void jButtonQuitarCondicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuitarCondicionActionPerformed
        int[] rowsSeleccionadas = jTableCondiciones.getSelectedRows();
        if (rowsSeleccionadas.length > 0) {
            for (int i = rowsSeleccionadas.length - 1; i >= 0; i--) {
                dtmCondiciones.removeRow(rowsSeleccionadas[i]);
            }
            actualizarSentenciaSql();
        } else {
            JOptionPane.showMessageDialog(null, Defectos.MENSAJES[8]);
        }
    }//GEN-LAST:event_jButtonQuitarCondicionActionPerformed

    private void jButtonEjecutarSentenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEjecutarSentenciaActionPerformed
        Herramientas.limpiarTabla(dtmTablaResultado);
        try {
            String sentencia = jTextAreaSentencia.getText();
            sentencia = sentencia.substring(0, sentencia.length() - 1);
            cabecerasTablaFinal = ConsultaDeTabla.obtenerCabeceraParaTablaFinal(sentencia);
            dtmTablaResultado.setColumnIdentifiers(cabecerasTablaFinal.toArray());
            ResultSet rs = ConsultaDeTabla.obtenerContenidoParaTablaFinal(sentencia);
            while (rs.next()) {
                ArrayList<Object> contenidoRow = new ArrayList<>();
                for (int i = 1; i <= jTableTablaResultado.getColumnCount(); i++) {
                    contenidoRow.add(rs.getObject(i));
                }
                dtmTablaResultado.addRow(contenidoRow.toArray());
            }
            jButtonExportar.setEnabled(true);

        } catch (SQLException ex) {
            String falloFecha = "";
            if (ex.getErrorCode() == 1830) {
                falloFecha = Defectos.MENSAJES[12];
            }
            JOptionPane.showMessageDialog(null, Defectos.MENSAJES[9]
                    + Defectos.MENSAJES[10] + ex.getMessage()
                    + Defectos.MENSAJES[11] + ex.getErrorCode() + "\n"
                    + falloFecha
            );

        }
    }//GEN-LAST:event_jButtonEjecutarSentenciaActionPerformed

    private void jButtonExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExportarActionPerformed
        try {
            File file = Herramientas.obtenerFileParaGuardar();
            if (file != null && file.exists() && file.isFile() && file.canWrite()) {
                if (file.toString().toLowerCase().endsWith("json")) {
                    Herramientas.exportarArchivoJSON(file, Herramientas.generarObjetoTablaDinamica(cabecerasTablaFinal, jTableTablaResultado));
                } else {
                    Herramientas.exportarArchivoSerializedObject(file, Herramientas.generarObjetoTablaDinamica(cabecerasTablaFinal, jTableTablaResultado));
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, Defectos.MENSAJES[13]
                    +  Defectos.MENSAJES[10]+ ex.getMessage());
        }
    }//GEN-LAST:event_jButtonExportarActionPerformed
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PrincipalJFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalJFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalJFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalJFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupOpcionesLike;
    private javax.swing.JButton jButtonAgregarCondicion;
    private javax.swing.JButton jButtonEjecutarSentencia;
    private javax.swing.JButton jButtonExportar;
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
    private javax.swing.JLabel jLabelInfoDatoElegido;
    private javax.swing.JLabel jLabelOperador;
    private javax.swing.JLabel jLabelTablas;
    private javax.swing.JLabel jLabelValorDateFin;
    private javax.swing.JLabel jLabelValorDateInicio;
    private javax.swing.JLabel jLabelValorNumberDos;
    private javax.swing.JLabel jLabelValorNumberUno;
    private javax.swing.JLabel jLabelValorVarcharUno;
    private javax.swing.JPanel jPanelCreacionCondicionales;
    private javax.swing.JPanel jPanelEntradasValores;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JPanel jPanelSeleccionTabla;
    private javax.swing.JPanel jPanelSentenciaSql;
    private javax.swing.JPanel jPanelTablaExportacion;
    private javax.swing.JPanel jPanelValorDateFin;
    private javax.swing.JPanel jPanelValorDateInicio;
    private javax.swing.JPanel jPanelValorNumberDos;
    private javax.swing.JPanel jPanelValorNumberUno;
    private javax.swing.JPanel jPanelValorOpcionesLike;
    private javax.swing.JPanel jPanelValorVarcharUno;
    private javax.swing.JRadioButton jRadioButtonContenga;
    private javax.swing.JRadioButton jRadioButtonEmpiece;
    private javax.swing.JRadioButton jRadioButtonTermine;
    private javax.swing.JScrollPane jScrollPaneCondiciones;
    private javax.swing.JScrollPane jScrollPaneDisponibles;
    private javax.swing.JScrollPane jScrollPaneSentencia;
    private javax.swing.JScrollPane jScrollPaneTablaResultado;
    private javax.swing.JScrollPane jScrollPaneTomados;
    private javax.swing.JSpinner jSpinnerDateFin;
    private javax.swing.JSpinner jSpinnerDateInicio;
    private javax.swing.JTable jTableCondiciones;
    private javax.swing.JTable jTableDisponibles;
    private javax.swing.JTable jTableTablaResultado;
    private javax.swing.JTable jTableTomados;
    private javax.swing.JTextArea jTextAreaSentencia;
    private javax.swing.JTextField jTextFieldValorNumberDos;
    private javax.swing.JTextField jTextFieldValorNumeroUno;
    private javax.swing.JTextField jTextFieldValorVarcharUno;
    // End of variables declaration//GEN-END:variables

}
