package vista;

import java.sql.*;
import controlador.Conexion;
import controlador.ConsultasDeEsquema;
import controlador.ConsultaDeTabla;
import java.awt.Component;

import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Columna;
import vista.Defectos.TipoDeCondicional;

import com.google.gson.*;
import java.awt.Insets;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JTextField;

import javax.swing.filechooser.FileNameExtensionFilter;

import modelo.TablaDinamica;

public class PrincipalJFrame extends javax.swing.JFrame {

    //Creación de mis variables-------------------------------------------------
    //Conexión y controladores    
    Connection conexion = null;
    ConsultasDeEsquema cde = null;
    ConsultaDeTabla cdt = null;
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
        cde = new ConsultasDeEsquema();
        cdt = new ConsultaDeTabla();

        //Colecciones 
        columnasTablaEnFoco = new ArrayList<>();

        //Rellenar lista de tablas inicial
        dcbmTablas.addAll(cde.obtenerNombreTablas());
        if (dcbmTablas.getSize() == 0) {
            JOptionPane.showMessageDialog(null, "El usuario/esquema proporcionado"
                    + " existe, pero no tiene tablas registradas.");
        }

        cabecerasTablaFinal = new ArrayList<>();
        comillasVisibles(false);
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
        jPanelValorOpcionesLike = new javax.swing.JPanel();
        jRadioButtonEmpiece = new javax.swing.JRadioButton();
        jRadioButtonTermine = new javax.swing.JRadioButton();
        jRadioButtonContenga = new javax.swing.JRadioButton();
        jLabelCampo = new javax.swing.JLabel();
        jComboBoxCampos = new javax.swing.JComboBox<>();
        jPanelValor1 = new javax.swing.JPanel();
        jLabelValor1 = new javax.swing.JLabel();
        jLabelComillaIzq = new javax.swing.JLabel();
        jLabelComillaDer = new javax.swing.JLabel();
        jTextFieldValor1 = new javax.swing.JTextField();
        jSpinnerInicio = new javax.swing.JSpinner();
        jLabelOperador = new javax.swing.JLabel();
        jComboBoxOperadorLogico = new javax.swing.JComboBox<>();
        jLabelTipDato = new javax.swing.JLabel();
        jPanelValor2 = new javax.swing.JPanel();
        jLabelValor2 = new javax.swing.JLabel();
        jTextFieldValor2 = new javax.swing.JTextField();
        jSpinnerFin = new javax.swing.JSpinner();
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

        jPanelValorOpcionesLike.setLayout(null);

        buttonGroupOpcionesLike.add(jRadioButtonEmpiece);
        jRadioButtonEmpiece.setText("empiece");
        jRadioButtonEmpiece.setIconTextGap(3);
        jRadioButtonEmpiece.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonEmpieceActionPerformed(evt);
            }
        });
        jPanelValorOpcionesLike.add(jRadioButtonEmpiece);
        jRadioButtonEmpiece.setBounds(1, 5, 80, 30);

        buttonGroupOpcionesLike.add(jRadioButtonTermine);
        jRadioButtonTermine.setText("termine");
        jRadioButtonTermine.setIconTextGap(3);
        jRadioButtonTermine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonTermineActionPerformed(evt);
            }
        });
        jPanelValorOpcionesLike.add(jRadioButtonTermine);
        jRadioButtonTermine.setBounds(81, 5, 80, 30);

        buttonGroupOpcionesLike.add(jRadioButtonContenga);
        jRadioButtonContenga.setText("contenga");
        jRadioButtonContenga.setIconTextGap(3);
        jRadioButtonContenga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonContengaActionPerformed(evt);
            }
        });
        jPanelValorOpcionesLike.add(jRadioButtonContenga);
        jRadioButtonContenga.setBounds(161, 5, 80, 30);

        jPanelCreacionCondicionales.add(jPanelValorOpcionesLike);
        jPanelValorOpcionesLike.setBounds(225, 80, 240, 40);

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

        jPanelValor1.setLayout(null);

        jLabelValor1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelValor1.setText("Valor 1");
        jLabelValor1.setEnabled(false);
        jPanelValor1.add(jLabelValor1);
        jLabelValor1.setBounds(5, 5, 45, 30);

        jLabelComillaIzq.setBackground(new java.awt.Color(102, 153, 0));
        jLabelComillaIzq.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelComillaIzq.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelComillaIzq.setText("'");
        jLabelComillaIzq.setEnabled(false);
        jLabelComillaIzq.setOpaque(true);
        jPanelValor1.add(jLabelComillaIzq);
        jLabelComillaIzq.setBounds(55, 5, 10, 30);

        jLabelComillaDer.setBackground(new java.awt.Color(255, 102, 0));
        jLabelComillaDer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelComillaDer.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelComillaDer.setText("'");
        jLabelComillaDer.setEnabled(false);
        jLabelComillaDer.setOpaque(true);
        jPanelValor1.add(jLabelComillaDer);
        jLabelComillaDer.setBounds(230, 5, 10, 30);

        jTextFieldValor1.setEnabled(false);
        jPanelValor1.add(jTextFieldValor1);
        jTextFieldValor1.setBounds(55, 5, 185, 30);

        jSpinnerInicio.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.MINUTE));
        jSpinnerInicio.setEnabled(false);
        jPanelValor1.add(jSpinnerInicio);
        jSpinnerInicio.setBounds(55, 5, 140, 30);

        jPanelCreacionCondicionales.add(jPanelValor1);
        jPanelValor1.setBounds(225, 41, 240, 40);

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
        jPanelCreacionCondicionales.add(jLabelTipDato);
        jLabelTipDato.setBounds(10, 20, 220, 25);

        jPanelValor2.setLayout(null);

        jLabelValor2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelValor2.setText("Valor 2");
        jLabelValor2.setEnabled(false);
        jPanelValor2.add(jLabelValor2);
        jLabelValor2.setBounds(5, 5, 45, 30);

        jTextFieldValor2.setEnabled(false);
        jPanelValor2.add(jTextFieldValor2);
        jTextFieldValor2.setBounds(55, 5, 140, 30);

        jSpinnerFin.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.MINUTE));
        jSpinnerFin.setEnabled(false);
        jPanelValor2.add(jSpinnerFin);
        jSpinnerFin.setBounds(55, 5, 140, 30);

        jPanelCreacionCondicionales.add(jPanelValor2);
        jPanelValor2.setBounds(225, 80, 240, 40);

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

        jTextAreaSentencia.setColumns(20);
        jTextAreaSentencia.setRows(5);
        jTextAreaSentencia.setEnabled(false);
        jTextAreaSentencia.setFocusable(false);
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
        jTextFieldValor1.setText("");
        jTextFieldValor2.setText("");
        jLabelTipDato.setText("");
        jTextAreaSentencia.setText("");
        Defectos.tipoDeCondicional = TipoDeCondicional.NO_ASIGNADO;
    }

    private String obtenerLineaCondicional() {
        String condicional = "";
        condicional = (dcbmCampos.getSelectedItem().toString()) + " " + (String) dcbmOperadorLogico.getSelectedItem();
        switch (Defectos.tipoDeCondicional) {
            case TIPO_COMPARACION:
                if (((Columna) dcbmCampos.getSelectedItem()).getType().equals("DATE")) {
                    if (!jSpinnerInicio.getValue().toString().isEmpty()) {
                        condicional += " TO_DATE('" + Defectos.SDF.format(jSpinnerInicio.getValue()) + "', '" + Defectos.FORMATO_FECHA_SQL + "')";
                    } else {
                        condicional = "";
                    }
                    break;
                }
            case TIPO_LIKE:
                if (!jTextFieldValor1.getText().isEmpty()) {
                    condicional += " " + jTextFieldValor1.getText();
                } else {
                    condicional = "";
                }
                break;
            case TIPO_BETWEEN:
                if (((Columna) dcbmCampos.getSelectedItem()).getType().equals("NUMBER")) {
                    if (!jTextFieldValor1.getText().isEmpty() && !jTextFieldValor2.getText().isEmpty()) {
                        condicional += " " + jTextFieldValor1.getText() + " AND " + jTextFieldValor2.getText();
                    } else {
                        condicional = "";
                    }
                } else {
                    if (!jSpinnerInicio.getValue().toString().isEmpty() && !jSpinnerFin.getValue().toString().isEmpty()) {

                        condicional += " TO_DATE('" + Defectos.SDF.format(jSpinnerInicio.getValue()) + "', '" + Defectos.FORMATO_FECHA_SQL + "') AND "
                                + " TO_DATE('" + Defectos.SDF.format(jSpinnerFin.getValue()) + "', '" + Defectos.FORMATO_FECHA_SQL + "')";
                    } else {
                        condicional = "";
                    }
                }
                break;
            case NO_ASIGNADO:
                break;
        }
        return condicional;
    }

    private void actualizarSentenciaSql() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT");
        if (dtmDisponibles.getRowCount() == 0 || dtmTomados.getRowCount() == 0) {
            sb.append(" *");
        } else {
            for (int i = 0; i < dtmTomados.getRowCount(); i++) {
                sb.append(" ").append(dtmTomados.getValueAt(i, 0)).append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append(" FROM ");
        sb.append(dcbmTablas.getSelectedItem());
        if (dtmCondiciones.getRowCount() > 0) {
            sb.append(" WHERE ").append(dtmCondiciones.getValueAt(0, 0));
            for (int i = 1; i < dtmCondiciones.getRowCount(); i++) {
                sb.append(" ").append(dtmCondiciones.getValueAt(i - 1, 1)).append(" ").append(dtmCondiciones.getValueAt(i, 0));
            }
        }
        sb.append(";");

        jTextAreaSentencia.setText(sb.toString());
    }

    //private void 
    private void comillasVisibles(boolean aFlag) {
        jLabelComillaIzq.setVisible(aFlag);
        jLabelComillaDer.setVisible(aFlag);
        if (aFlag) {
            jTextFieldValor1.setMargin(new Insets(2, 10, 2, 10));
        } else {
            jTextFieldValor1.setMargin(new Insets(2, 2, 2, 2));
        }
    }


    private void jButtonListaTomarUnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListaTomarUnoActionPerformed
        traspasoDeSeleccionados(jTableDisponibles, dtmDisponibles, dtmTomados);
        actualizarSentenciaSql();
    }//GEN-LAST:event_jButtonListaTomarUnoActionPerformed

    private void jButtonListaTomarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListaTomarTodosActionPerformed
        traspasoDeTodos(dtmDisponibles, dtmTomados);
        limpiarTabla(dtmDisponibles);
        actualizarSentenciaSql();
    }//GEN-LAST:event_jButtonListaTomarTodosActionPerformed

    private void jButtonListaQuitarUnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListaQuitarUnoActionPerformed
        traspasoDeSeleccionados(jTableTomados, dtmTomados, dtmDisponibles);
        actualizarSentenciaSql();
    }//GEN-LAST:event_jButtonListaQuitarUnoActionPerformed

    private void jButtonListaQuitarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListaQuitarTodosActionPerformed
        traspasoDeTodos(dtmTomados, dtmDisponibles);
        limpiarTabla(dtmTomados);
        actualizarSentenciaSql();
    }//GEN-LAST:event_jButtonListaQuitarTodosActionPerformed

    private void jComboBoxTablasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxTablasItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            if (layoutCargado == false) {
                for (Component c : jPanelSeleccionTabla.getComponents()) {
                    c.setEnabled(true);
                }
                for (Component c : jPanelCreacionCondicionales.getComponents()) {
                    c.setEnabled(true);
                }
                for (Component c : jPanelValor1.getComponents()) {
                    c.setEnabled(true);
                }
                for (Component c : jPanelValor2.getComponents()) {
                    c.setEnabled(true);
                }
                jScrollPaneSentencia.setEnabled(true);
                jTextAreaSentencia.setEnabled(true);
                jButtonEjecutarSentencia.setEnabled(true);
                layoutCargado = true;
            } else {
                reiniciarTodoElFormulario();
            }

            columnasTablaEnFoco = cde.obtenerMetasDeColumnasDeTabla((String) dcbmTablas.getSelectedItem());
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
            String tipoDatoSql = ((Columna) dcbmCampos.getSelectedItem()).getType();
            jLabelTipDato.setText("Tipo de dato del campo: " + tipoDatoSql);
            dcbmOperadorLogico.removeAllElements();

            /*jLabelValor1.setVisible(true);
            jLabelValor2.setVisible(true);
            jSpinnerInicio.setVisible(true);
            jSpinnerFin.setVisible(true);*/
            comillasVisibles(false);
            jSpinnerInicio.setVisible(false);
            jSpinnerFin.setVisible(false);
            jTextFieldValor1.setVisible(true);
            jTextFieldValor2.setVisible(true);
            switch (tipoDatoSql) {
                case "NUMBER":
                    dcbmOperadorLogico.addAll(Defectos.OP_LOGICO_NUMBER_Y_DATE);

                    //jLabelValor1.setVisible(true);
                    //jTextFieldValor1.setVisible(true);
                    //jLabelValor2.setVisible(true);
                    //jTextFieldValor2.setVisible(true);
                    //jSpinnerInicio.setVisible(false);
                    //jSpinnerFin.setVisible(false);
                    //comillasVisibles(false);
                    break;
                case "DATE":
                    dcbmOperadorLogico.addAll(Defectos.OP_LOGICO_NUMBER_Y_DATE);
                    //jLabelValor1.setVisible(true);
                    jTextFieldValor1.setVisible(false);
                    //jLabelValor2.setVisible(true);
                    jTextFieldValor2.setVisible(false);
                    jSpinnerInicio.setVisible(true);
                    jSpinnerFin.setVisible(true);
                    //comillasVisibles(false);
                    break;
                case "VARCHAR2":
                    dcbmOperadorLogico.addAll(Defectos.OP_LOGICO_VARCHAR2);
                    //jLabelValor1.setVisible(true);
                    //jTextFieldValor1.setVisible(true);
                    //jLabelValor2.setVisible(false);
                    //jTextFieldValor2.setVisible(false);
                    //jSpinnerInicio.setVisible(false);
                    //jSpinnerFin.setVisible(false);
                    comillasVisibles(true);
                    break;
                default:

            }

            dcbmOperadorLogico.setSelectedItem(dcbmOperadorLogico.getElementAt(0));
            dcbmOperadorRelacional.addAll(Defectos.OP_RELACIONAL);
            dcbmOperadorRelacional.setSelectedItem(dcbmOperadorRelacional.getElementAt(0));
        }
     }//GEN-LAST:event_jComboBoxCamposItemStateChanged

    private void jComboBoxOperadorLogicoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxOperadorLogicoItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            String tipoOperador = ((String) dcbmOperadorLogico.getSelectedItem());

            jPanelValor1.setVisible(true);
            jPanelValor2.setVisible(false);
            Defectos.tipoDeCondicional = TipoDeCondicional.TIPO_COMPARACION;

            if (tipoOperador.equals("IS NULL") || tipoOperador.equals("IS NOT NULL")) {
                jPanelValor1.setVisible(false);
                jPanelValor2.setVisible(false);
                Defectos.tipoDeCondicional = TipoDeCondicional.TIPO_NULL;
            } else {
                if (tipoOperador.equals("BETWEEN") || tipoOperador.equals("NOT BETWEEN")) {
                    jPanelValor1.setVisible(true);
                    jPanelValor2.setVisible(true);

                    Defectos.tipoDeCondicional = TipoDeCondicional.TIPO_BETWEEN;
                } else {
                    if (tipoOperador.equals("LIKE") || tipoOperador.equals("NOT LIKE")) {

                        Defectos.tipoDeCondicional = TipoDeCondicional.TIPO_LIKE;
                    }
                }
            }
        }
    }//GEN-LAST:event_jComboBoxOperadorLogicoItemStateChanged

    private void jButtonAgregarCondicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarCondicionActionPerformed
        String sentenciaCondicional = obtenerLineaCondicional();
        if (!sentenciaCondicional.isEmpty()) {
            dtmCondiciones.addRow(new Object[]{sentenciaCondicional, dcbmOperadorRelacional.getSelectedItem()});
            actualizarSentenciaSql();
        } else {
            JOptionPane.showMessageDialog(null, "Debe proporcionar una consulta correcta.");
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
            JOptionPane.showMessageDialog(null, "Debe seleccionar o varias filas para borrar.");
        }
    }//GEN-LAST:event_jButtonQuitarCondicionActionPerformed

    private void jButtonEjecutarSentenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEjecutarSentenciaActionPerformed
        limpiarTabla(dtmTablaResultado);
        try {
            String sentencia = jTextAreaSentencia.getText();
            sentencia = sentencia.substring(0, sentencia.length() - 1);
            cabecerasTablaFinal = cdt.obtenerCabeceraParaTablaFinal(sentencia);
            dtmTablaResultado.setColumnIdentifiers(cabecerasTablaFinal.toArray());
            ResultSet rs = cdt.obtenerContenidoParaTablaFinal(sentencia);
            while (rs.next()) {
                ArrayList<Object> contenidoRow = new ArrayList<>();
                for (int i = 1; i <= jTableTablaResultado.getColumnCount(); i++) {
                    contenidoRow.add(rs.getObject(i));
                }
                dtmTablaResultado.addRow(contenidoRow.toArray());
            }
            jButtonExportar.setEnabled(true);
        } catch (SQLException ex) {
            Logger.getLogger(PrincipalJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonEjecutarSentenciaActionPerformed

    private void jButtonExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExportarActionPerformed
        File file = obtenerFileParaGuardar();
        if (file != null && file.exists() && file.isFile() && file.canWrite()) {
            if (file.toString().toLowerCase().endsWith("json")) {
                exportarArchivoJSON(file, generarObjetoTablaDinamica(cabecerasTablaFinal, jTableTablaResultado));
            } else {
                exportarArchivoSerializedObject(file, generarObjetoTablaDinamica(cabecerasTablaFinal, jTableTablaResultado));
            }
        }
    }//GEN-LAST:event_jButtonExportarActionPerformed

    private void jRadioButtonEmpieceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonEmpieceActionPerformed
        jLabelComillaDer.setBounds(210, 5, 30, 30);
        jLabelComillaDer.setText("%");
        jTextFieldValor1.setMargin(new Insets(2, 2, 2, 25));
        jTextFieldValor1.setHorizontalAlignment(JTextField.RIGHT);
    }//GEN-LAST:event_jRadioButtonEmpieceActionPerformed

    private void jRadioButtonTermineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonTermineActionPerformed
        jLabelComillaIzq.setSize(30, 30);
        jLabelComillaIzq.setText("%");

        jTextFieldValor1.setMargin(new Insets(2, 25, 2, 2));
        jTextFieldValor1.setHorizontalAlignment(JTextField.LEFT);
    }//GEN-LAST:event_jRadioButtonTermineActionPerformed

    private void jRadioButtonContengaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonContengaActionPerformed
        jLabelComillaIzq.setSize(30, 30);
        jLabelComillaDer.setBounds(210, 5, 30, 30);
        jLabelComillaIzq.setText("%");
        jLabelComillaDer.setText("%");
        jTextFieldValor1.setMargin(new Insets(2, 25, 2, 25));
        jTextFieldValor1.setHorizontalAlignment(JTextField.CENTER);
    }//GEN-LAST:event_jRadioButtonContengaActionPerformed
    private TablaDinamica generarObjetoTablaDinamica(ArrayList<Columna> cabeceraTabla, JTable contenidoTabla) {

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

    private File obtenerFileParaGuardar() {
        //Esta función abre un JFileChooser que nos permite crear o seleccionar
        //una referencia a un File. Además, la he configurado para que solo
        //admita crear o seleccionar archivos con extensión .json o .ser (.ser
        //para objetos serializables de java)
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
                try {
                    file.createNewFile();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "No se pudo crear el archivo."
                            + "\nDescripción del error: " + ex.getMessage());
                }
            }
        }
        return file;
    }

    private void exportarArchivoJSON(File archivoDondeGuardar, TablaDinamica objetoAGuardar) {
        Gson gson = new Gson();
        String json = gson.toJson(objetoAGuardar);
        FileWriter fw = null;
        try {
            fw = new FileWriter(archivoDondeGuardar);
            fw.write(json);
        } catch (IOException ex) {
            Logger.getLogger(PrincipalJFrame.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(PrincipalJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void exportarArchivoSerializedObject(File archivoDondeGuardar, TablaDinamica objetoAGuardar) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(archivoDondeGuardar);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(objetoAGuardar);
        } catch (IOException ex) {
            Logger.getLogger(PrincipalJFrame.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(PrincipalJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

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
    private javax.swing.JLabel jLabelComillaDer;
    private javax.swing.JLabel jLabelComillaIzq;
    private javax.swing.JLabel jLabelOperador;
    private javax.swing.JLabel jLabelTablas;
    private javax.swing.JLabel jLabelTipDato;
    private javax.swing.JLabel jLabelValor1;
    private javax.swing.JLabel jLabelValor2;
    private javax.swing.JPanel jPanelCreacionCondicionales;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JPanel jPanelSeleccionTabla;
    private javax.swing.JPanel jPanelSentenciaSql;
    private javax.swing.JPanel jPanelTablaExportacion;
    private javax.swing.JPanel jPanelValor1;
    private javax.swing.JPanel jPanelValor2;
    private javax.swing.JPanel jPanelValorOpcionesLike;
    private javax.swing.JRadioButton jRadioButtonContenga;
    private javax.swing.JRadioButton jRadioButtonEmpiece;
    private javax.swing.JRadioButton jRadioButtonTermine;
    private javax.swing.JScrollPane jScrollPaneCondiciones;
    private javax.swing.JScrollPane jScrollPaneDisponibles;
    private javax.swing.JScrollPane jScrollPaneSentencia;
    private javax.swing.JScrollPane jScrollPaneTablaResultado;
    private javax.swing.JScrollPane jScrollPaneTomados;
    private javax.swing.JSpinner jSpinnerFin;
    private javax.swing.JSpinner jSpinnerInicio;
    private javax.swing.JTable jTableCondiciones;
    private javax.swing.JTable jTableDisponibles;
    private javax.swing.JTable jTableTablaResultado;
    private javax.swing.JTable jTableTomados;
    private javax.swing.JTextArea jTextAreaSentencia;
    private javax.swing.JTextField jTextFieldValor1;
    private javax.swing.JTextField jTextFieldValor2;
    // End of variables declaration//GEN-END:variables

}
