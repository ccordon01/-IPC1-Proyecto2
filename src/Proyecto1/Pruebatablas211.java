/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto1;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import de.javasoft.plaf.synthetica.SyntheticaBlueSteelLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Loscordonhdez
 */
public class Pruebatablas211 extends JFrame implements ActionListener {
    
    public static ListaCircular lista = new ListaCircular();
    int tamfil = 0, tamcol = 0;
    Archivos gestion = new Archivos();
    JFileChooser selected = new JFileChooser();
    File archivo;
    ArrayList<formato> formato = new ArrayList();
    ArrayList<funciones> funciones = new ArrayList();
    ArrayList<reporte2> reporte2 = new ArrayList();
    ArrayList<ccp> ccp = new ArrayList();
    public JTable tabla;
    private Font fuente;
    private static JMenuBar mb;
    private JMenu menu1, menu2, menu3, menu4, menu5, reportes, dash;
    private JMenuItem abrir, mi1, mi2, mi3, mi4, mi5, mi6, mi7, mi8, mi9, m10, m11, m12, m13, m14, reportes1, reportes2, reportes3, reportes4;
    private Object matrizrespaldo[][] = new Object[10][10];
    String columna[] = {" ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    public Object datos[][] = new Object[100][columna.length];
    JTextField cuadrofunciones;
    String aux = "";
    String funcionaux = "";
    boolean datareload = false;
    JButton negra, subra, cursi, copi, peg, cortar;
    String readword = "";
    int colaux = 0;
    int rowaux = 0;
    
    public Pruebatablas211() {
        mb = new JMenuBar();
        setJMenuBar(mb);
        //Dashboard
        dash = new JMenu("Dashboard");
        // Inicio
        menu1 = new JMenu("Inicio");
        mb.add(menu1);
        abrir = new JMenuItem("Abrir");
        menu1.add(abrir);
        menu1.add(dash);
        abrir.addActionListener(this);
        // Edicion
        menu2 = new JMenu("Edición");
        menu1.add(menu2);
        //Opciones de Edicion
        mi1 = new JMenuItem("Negrita");
        menu2.add(mi1);
        mi1.addActionListener(this);
        mi2 = new JMenuItem("Subrayada");
        menu2.add(mi2);
        mi2.addActionListener(this);
        mi3 = new JMenuItem("Cursiva");
        menu2.add(mi3);
        mi3.addActionListener(this);
        mi4 = new JMenuItem("Tachado");
        menu2.add(mi4);
        mi4.addActionListener(this);
        // Formato de Texto
        menu3 = new JMenu("Formato De Texto");
        menu1.add(menu3);
        //Opciones de Formato de Texto
        mi5 = new JMenuItem("General");
        menu3.add(mi5);
        mi5.addActionListener(this);
        mi6 = new JMenuItem("Porcentaje");
        menu3.add(mi6);
        mi6.addActionListener(this);
        mi7 = new JMenuItem("Fecha");
        menu3.add(mi7);
        mi7.addActionListener(this);
        //Formulas
        menu4 = new JMenu("Formulas");
        mb.add(menu4);
        // Opciones Formulas
        mi8 = new JMenuItem("Desviación Estandar");
        menu4.add(mi8);
        mi8.addActionListener(this);
        mi9 = new JMenuItem("MCM");
        menu4.add(mi9);
        mi9.addActionListener(this);
        m14 = new JMenuItem("Moda");
        menu4.add(m14);
        m14.addActionListener(this);
        m10 = new JMenuItem("Maximo");
        menu4.add(m10);
        m10.addActionListener(this);
        m11 = new JMenuItem("Minimo");
        menu4.add(m11);
        m11.addActionListener(this);
        //Operaciones
        menu5 = new JMenu("Operaciones");
        mb.add(menu5);
        // Operaciones Operaciones
        m12 = new JMenuItem("Fibonacci");
        menu5.add(m12);
        m12.addActionListener(this);
        m13 = new JMenuItem("Modulo");
        menu5.add(m13);
        m13.addActionListener(this);
        // Reportes
        reportes = new JMenu("Reportes");
        mb.add(reportes);
        // Reportes1-4
        reportes1 = new JMenuItem("Reporte 1");
        reportes.add(reportes1);
        reportes1.addActionListener(this);
        reportes2 = new JMenuItem("Reporte 2");
        reportes.add(reportes2);
        reportes2.addActionListener(this);
        reportes3 = new JMenuItem("Reporte 3");
        reportes.add(reportes3);
        reportes3.addActionListener(this);
        reportes4 = new JMenuItem("Reporte 4");
        reportes.add(reportes4);
        reportes4.addActionListener(this);
        mb.add(dash);
        dash.addActionListener(this);
        tabla = new JTable(new ModeloDatos1());
        // La tabla se añade a un ScrollPane para que sea éste el
        // que controle automáticamente en tamaño de la tabla,
        // presentando una barra de desplazamiento cuando sea
        // necesario

        tabla.setRowSelectionAllowed(true);
        tabla.setColumnSelectionAllowed(true);
        TableColumnModel columnModel = tabla.getColumnModel();
        tabla.getTableHeader().setReorderingAllowed(false);
        columnModel.getColumn(0).setPreferredWidth(30);
        columnModel.getColumn(0).setMaxWidth(30);
        columnModel.getColumn(0).setMinWidth(30);
        columnModel.getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                JLabel label = (JLabel) comp;
                label.setBackground(Color.getHSBColor(38, 0, Float.parseFloat("0.95")));
                return label;
            }
        });
        tabla.setDefaultRenderer(String.class, new LabelRenderer());
        JScrollPane panel = new JScrollPane(tabla, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        cuadrofunciones = new JTextField();
        cuadrofunciones.setSize(750, 40);
        cuadrofunciones.setFont(new Font("Cambria", Font.PLAIN, 14));
        cuadrofunciones.addActionListener(this);
        JToolBar tool = new JToolBar();
        copi = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("resources/Copiar.png"))));
        tool.add(copi);
        copi.addActionListener(this);
        cortar = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("resources/cut.png"))));
        tool.add(cortar);
        cortar.addActionListener(this);
        cortar.setSize(32, 32);
        peg = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("resources/Pegar.png"))));
        tool.add(peg);
        peg.addActionListener(this);
        negra = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("resources/Negrita.png"))));
        tool.add(negra);
        negra.addActionListener(this);
        subra = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("resources/Subrayado.png"))));
        tool.add(subra);
        subra.addActionListener(this);
        cursi = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("resources/Cursiva.png"))));
        tool.add(cursi);
        cursi.addActionListener(this);
        tool.setFloatable(false);
        JPanel partedearriba = new JPanel();
        JPanel partecentral = new JPanel();
        JLabel jLabel1 = new JLabel();
        jLabel1.setText(" fx");
        jLabel1.setFont(new Font("Adobe Garamond Pro", Font.PLAIN, 16));
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(partedearriba);
        partedearriba.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(tool)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cuadrofunciones)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(tool)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(cuadrofunciones))));
        //add(partedearriba, BorderLayout.NORTH);
        //add(cuadrofunciones,BorderLayout.CENTER);
        javax.swing.GroupLayout layout1 = new javax.swing.GroupLayout(partecentral);
        partecentral.setLayout(layout1);
        layout1.setHorizontalGroup(
                layout1.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(partedearriba)
                .addComponent(panel));
        layout1.setVerticalGroup(
                layout1.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout1.createSequentialGroup()
                        .addComponent(partedearriba)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout1.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(panel))));
        add(partecentral);
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        setSize(750, 400);
        setEventoMouseClicked(tabla);
        setTitle("Excel Lite 2");
        setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("resources/48x48.png")));
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }

    /**
     * @param args the command line arguments
     */
    private void setEventoMouseClicked(JTable tbl) {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tblEjemploMouseClicked(e);
            }
        });
    }
    
    private void tblEjemploMouseClicked(java.awt.event.MouseEvent evt) {
        String cadena = "";
        cadena = String.valueOf(tabla.getSelectedRow() + tabla.getSelectedColumn());
        //ModeloDatos m=new ModeloDatos();
        //datos[tabla.getSelectedRow()][ tabla.getSelectedColumn()]=cadena;
        //JOptionPane.showMessageDialog(null, cadena);
        //m.setValueAt(cadena,tabla.getSelectedRow(), tabla.getSelectedColumn());
        //tabla.getModel().setValueAt(cadena, tabla.getSelectedRow(), tabla.getSelectedColumn());
        System.out.println("Evento OnClick");
        try {
            aux = tabla.getModel().getValueAt(tabla.getSelectedRow(), tabla.getSelectedColumn()).toString();
            System.out.println("Numero En Axuliar " + aux);
        } catch (Exception e) {
            //System.out.println(e);
            aux = "";
        }
        datareload = true;
        System.out.println("datareload " + datareload);
        try {
            cuadrofunciones.setFocusable(true);
            funciones v;
            if (!funciones.isEmpty()) {
                Iterator<funciones> ite = funciones.iterator();
                while (ite.hasNext()) {
                    v = ite.next();
                    if (v.getCol() == tabla.getSelectedColumn() && v.getRow() == tabla.getSelectedRow()) {
                        cuadrofunciones.setText(v.getFuncion());
                        funcionaux = v.getFuncion();
                    } else {
                        cuadrofunciones.setText(aux);
                    }
                }
            } else {
                cuadrofunciones.setText(aux);
            }
        } catch (Exception e) {
        }
        setformatcells();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
            if (ae.getSource() == dash) {
                System.out.println("click");
                Graficas1 g = new Graficas1();
                g.setVisible(true);
            }
        try {
            if (ae.getSource() == abrir) {
                
                try {
                    FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.csv", "csv");
                    selected.setFileFilter(filtro);
                    if (selected.showDialog(null, "Abrir") == JFileChooser.APPROVE_OPTION) {
                        archivo = selected.getSelectedFile();
                        if (archivo.canRead()) {
                            if (archivo.getName().endsWith("csv")) {
                                String contenido = gestion.Abrir(archivo);
                                String[] filas;
                                String[] columnas = null;
                                String[] content;
                                content = contenido.split(";|,|\n");
                                filas = contenido.split("\n");
                                for (String fila1 : filas) {
                                    columnas = fila1.split(";|,");
                                }
                                int t = 0;
                                System.out.println("Filas" + filas.length + " Columnas:" + columnas.length);
                                for (int i = 0; i < filas.length; i++) {
                                    for (int j = 0; j < columnas.length; j++) {
                                        datos[i][j + 1] = content[t];
                                        t++;
                                    }
                                }
                                tamcol = columnas.length;
                                tamfil = filas.length;
                                cargarlistas();
                            } else {
                                JOptionPane.showMessageDialog(null, "Seleccione archivo Valido");
                            }
                        }
                    }
                    
                } catch (Exception ee) {
                }
            }
            if (ae.getSource() == mi1 || ae.getSource() == negra) {
                for (int i = 0; i < tabla.getSelectedColumns().length; i++) {
                    for (int j = 0; j < tabla.getSelectedRows().length; j++) {
                        int index = search(tabla.getSelectedRows()[j], tabla.getSelectedColumns()[i]);
                        if (index == -1) {
                            formato.add(new formato(tabla.getSelectedRows()[j], tabla.getSelectedColumns()[i], true, false, false, false));
                        } else {
                            formato f = formato.get(index);
                            if (f.isNegrita()) {
                                formato.set(index, new formato(tabla.getSelectedRows()[j], tabla.getSelectedColumns()[i], false, f.isCurisva(), f.isSubrayado(), f.isTachado()));
                            } else {
                                formato.set(index, new formato(tabla.getSelectedRows()[j], tabla.getSelectedColumns()[i], true, f.isCurisva(), f.isSubrayado(), f.isTachado()));
                            }
                        }
                        setformatcells();
                    }
                }
                //tabla.getModel().setValueAt(label.getText(),tabla.getSelectedRow(), tabla.getSelectedColumn());
                //negrita(tabla.getSelectedRow(), tabla.getSelectedColumn());
                tabla.removeRowSelectionInterval(tabla.getSelectedRows()[0], tabla.getSelectedRows()[tabla.getSelectedRows().length - 1]);//editCellAt(tabla.getSelectedRow(), tabla.getSelectedColumn());
                setformatcells();
                
            }
            if (ae.getSource() == mi2 || ae.getSource() == subra) {
                for (int i = 0; i < tabla.getSelectedColumns().length; i++) {
                    for (int j = 0; j < tabla.getSelectedRows().length; j++) {
                        int index = search(tabla.getSelectedRows()[j], tabla.getSelectedColumns()[i]);
                        if (index == -1) {
                            formato.add(new formato(tabla.getSelectedRows()[j], tabla.getSelectedColumns()[i], false, false, true, false));
                        } else {
                            formato f = formato.get(index);
                            if (f.isSubrayado()) {
                                formato.set(index, new formato(tabla.getSelectedRows()[j], tabla.getSelectedColumns()[i], f.isNegrita(), f.isCurisva(), false, f.isTachado()));
                            } else {
                                formato.set(index, new formato(tabla.getSelectedRows()[j], tabla.getSelectedColumns()[i], f.isNegrita(), f.isCurisva(), true, f.isTachado()));
                            }
                        }
                        setformatcells();
                    }
                }
                //tabla.getModel().setValueAt(label.getText(),tabla.getSelectedRow(), tabla.getSelectedColumn());
                //negrita(tabla.getSelectedRow(), tabla.getSelectedColumn());
                tabla.removeRowSelectionInterval(tabla.getSelectedRows()[0], tabla.getSelectedRows()[tabla.getSelectedRows().length - 1]);//editCellAt(tabla.getSelectedRow(), tabla.getSelectedColumn());
                setformatcells();
            }
            if (ae.getSource() == mi3 || ae.getSource() == cursi) {
                for (int i = 0; i < tabla.getSelectedColumns().length; i++) {
                    for (int j = 0; j < tabla.getSelectedRows().length; j++) {
                        int index = search(tabla.getSelectedRows()[j], tabla.getSelectedColumns()[i]);
                        if (index == -1) {
                            formato.add(new formato(tabla.getSelectedRows()[j], tabla.getSelectedColumns()[i], false, true, false, false));
                        } else {
                            formato f = formato.get(index);
                            if (f.isCurisva()) {
                                formato.set(index, new formato(tabla.getSelectedRows()[j], tabla.getSelectedColumns()[i], f.isNegrita(), false, f.isSubrayado(), f.isTachado()));
                            } else {
                                formato.set(index, new formato(tabla.getSelectedRows()[j], tabla.getSelectedColumns()[i], f.isNegrita(), true, f.isSubrayado(), f.isTachado()));
                            }
                        }
                        setformatcells();
                    }
                }
                //tabla.getModel().setValueAt(label.getText(),tabla.getSelectedRow(), tabla.getSelectedColumn());
                //negrita(tabla.getSelectedRow(), tabla.getSelectedColumn());
                tabla.removeRowSelectionInterval(tabla.getSelectedRows()[0], tabla.getSelectedRows()[tabla.getSelectedRows().length - 1]);//editCellAt(tabla.getSelectedRow(), tabla.getSelectedColumn());
                setformatcells();
            }
            if (ae.getSource() == mi4) {
                for (int i = 0; i < tabla.getSelectedColumns().length; i++) {
                    for (int j = 0; j < tabla.getSelectedRows().length; j++) {
                        int index = search(tabla.getSelectedRows()[j], tabla.getSelectedColumns()[i]);
                        if (index == -1) {
                            formato.add(new formato(tabla.getSelectedRows()[j], tabla.getSelectedColumns()[i], false, false, false, true));
                        } else {
                            formato f = formato.get(index);
                            if (f.isTachado()) {
                                formato.set(index, new formato(tabla.getSelectedRows()[j], tabla.getSelectedColumns()[i], f.isNegrita(), f.isCurisva(), f.isSubrayado(), false));
                            } else {
                                formato.set(index, new formato(tabla.getSelectedRows()[j], tabla.getSelectedColumns()[i], f.isNegrita(), f.isCurisva(), f.isSubrayado(), true));
                            }
                        }
                        setformatcells();
                    }
                }
                //tabla.getModel().setValueAt(label.getText(),tabla.getSelectedRow(), tabla.getSelectedColumn());
                //negrita(tabla.getSelectedRow(), tabla.getSelectedColumn());
                tabla.removeRowSelectionInterval(tabla.getSelectedRows()[0], tabla.getSelectedRows()[tabla.getSelectedRows().length - 1]);//editCellAt(tabla.getSelectedRow(), tabla.getSelectedColumn());
                setformatcells();
            }
            if (ae.getSource() == mi5) {
                for (int i = 0; i < tabla.getSelectedColumns().length; i++) {
                    for (int j = 0; j < tabla.getSelectedRows().length; j++) {
                        int index = search(tabla.getSelectedRows()[j], tabla.getSelectedColumns()[i]);
                        if (index == -1) {
                            formato.add(new formato(tabla.getSelectedRows()[j], tabla.getSelectedColumns()[i], false, false, false, false));
                        } else {
                            formato f = formato.get(index);
                            formato.set(index, new formato(tabla.getSelectedRows()[j], tabla.getSelectedColumns()[i], false, false, false, false));
                        }
                        setformatcells();
                    }
                }
                //tabla.getModel().setValueAt(label.getText(),tabla.getSelectedRow(), tabla.getSelectedColumn());
                //negrita(tabla.getSelectedRow(), tabla.getSelectedColumn());
                tabla.removeRowSelectionInterval(tabla.getSelectedRows()[0], tabla.getSelectedRows()[tabla.getSelectedRows().length - 1]);//editCellAt(tabla.getSelectedRow(), tabla.getSelectedColumn());
                setformatcells();
            }
            
            if (ae.getSource() == mi6) {
                for (int i = 0; i < tabla.getSelectedColumns().length; i++) {
                    for (int j = 0; j < tabla.getSelectedRows().length; j++) {
                        try {
                            try {
                                int n = Integer.parseInt(tabla.getModel().getValueAt(tabla.getSelectedRows()[j], tabla.getSelectedColumns()[i]).toString());
                                Double p = n * 0.01;
                                tabla.getModel().setValueAt(p, tabla.getSelectedRows()[j], tabla.getSelectedColumns()[i]);
                            } catch (Exception e) {
                                Double n = Double.parseDouble(tabla.getModel().getValueAt(tabla.getSelectedRows()[j], tabla.getSelectedColumns()[i]).toString());
                                BigDecimal p = new BigDecimal(n * 100).setScale(0, RoundingMode.DOWN);
                                tabla.getModel().setValueAt(p, tabla.getSelectedRows()[j], tabla.getSelectedColumns()[i]);
                            }
                        } catch (Exception e) {
                        }
                    }
                }
                //tabla.getModel().setValueAt(label.getText(),tabla.getSelectedRow(), tabla.getSelectedColumn());
                //negrita(tabla.getSelectedRow(), tabla.getSelectedColumn());
                tabla.removeRowSelectionInterval(tabla.getSelectedRows()[0], tabla.getSelectedRows()[tabla.getSelectedRows().length - 1]);//editCellAt(tabla.getSelectedRow(), tabla.getSelectedColumn());
                setformatcells();
            }
            if (ae.getSource() == mi7) {
                Date d = new Date();
                Calendar c;
                for (int i = 0; i < tabla.getSelectedColumns().length; i++) {
                    for (int j = 0; j < tabla.getSelectedRows().length; j++) {
                        try {
                            try {
                                String n = (tabla.getModel().getValueAt(tabla.getSelectedRows()[j], tabla.getSelectedColumns()[i]).toString());
                                StringTokenizer st = new StringTokenizer(n, "/-");
                                while (st.hasMoreTokens()) {
                                    int d1 = Integer.parseInt(st.nextToken());
                                    int d2 = Integer.parseInt(st.nextToken()) - 1;
                                    Calendar cc = GregorianCalendar.getInstance();
                                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMMM/yyyy");
                                    d.setDate(d1);
                                    d.setMonth(d2);
                                    cc.set(d.getYear() + 1900, d2, d1);
                                    if (d.getDate() == d1 && d.getMonth() == d2) {
                                        tabla.getModel().setValueAt(sdf.format(cc.getTime()), tabla.getSelectedRows()[j], tabla.getSelectedColumns()[i]);
                                    } else {
                                    }
                                }
                            } catch (Exception e) {
                            }
                        } catch (Exception e) {
                        }
                    }
                }
                //tabla.getModel().setValueAt(label.getText(),tabla.getSelectedRow(), tabla.getSelectedColumn());
                //negrita(tabla.getSelectedRow(), tabla.getSelectedColumn());
                tabla.removeRowSelectionInterval(tabla.getSelectedRows()[0], tabla.getSelectedRows()[tabla.getSelectedRows().length - 1]);//editCellAt(tabla.getSelectedRow(), tabla.getSelectedColumn());
                setformatcells();
            }
            if (ae.getSource() == mi8) {
                String celda = "";
                try {
                    Double numero[] = new Double[tabla.getSelectedColumns().length * tabla.getSelectedRows().length];
                    int contnumero = 0;
                    for (int i = 0; i < tabla.getSelectedColumns().length; i++) {
                        for (int j = 0; j < tabla.getSelectedRows().length; j++) {
                            numero[contnumero] = Double.parseDouble(tabla.getModel().getValueAt(tabla.getSelectedRows()[j], tabla.getSelectedColumns()[i]).toString());
                            contnumero++;
                        }
                    }
                    double media = 0;
                    for (int i = 0; i < numero.length; i++) {
                        media += (numero[i]);
                    }
                    media = media / numero.length;
                    double sum = 0;
                    for (int i = 0; i < numero.length; i++) {
                        sum += Math.pow((numero[i] - media), 2);
                    }
                    System.out.println("Numeros " + numero.length + " media: " + media + " sum: " + sum);
                    celda = new BigDecimal(Math.sqrt(sum / numero.length)).setScale(2, RoundingMode.DOWN).toPlainString();
                    JOptionPane.showMessageDialog(null, "Desviacion Estandar es " + celda);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "¡ERROR!");
                }
            }
            if (ae.getSource() == mi9) {
                String celda = "";
                try {
                    int numer[] = new int[tabla.getSelectedColumns().length * tabla.getSelectedRows().length];
                    int contnumero = 0;
                    for (int i = 0; i < tabla.getSelectedColumns().length; i++) {
                        for (int j = 0; j < tabla.getSelectedRows().length; j++) {
                            numer[contnumero] = Integer.parseInt(tabla.getModel().getValueAt(tabla.getSelectedRows()[j], tabla.getSelectedColumns()[i]).toString());
                            contnumero++;
                        }
                    }
                    Arrays.sort(numer);
                    int mcm = 1;
                    int numx = 1;
                    int min = numer[numer.length - 1];
                    int varc = 0;
                    int suma = 0;
                    System.out.println("tamaño" + numer.length);
                    for (int i = 0; i < numer.length; i++) {
                        System.out.println(numer[i]);
                        numx *= (numer[i]);
                    }
                    System.out.println("multi" + numx);
                    do {
                        for (int i = 2; i <= min; i++) {
                            varc = 0;
                            for (int j = 0; j < numer.length; j++) {
                                if (numer[j] % i == 0) {
                                    varc++;
                                    numer[j] = (numer[j] / i);
                                }
                            }
                            if (varc != 0) {
                                int mcd = i;
                                // Se calcula el mínimo común múltiplo
                                //mcm = (numx) / mcd;
                                mcm *= mcd;
                                System.out.println(mcm);
                                i = min + 1;
                            }
                        }
                        suma = 0;
                        for (int i = 0; i < numer.length; i++) {
                            suma += (numer[i]);
                            System.out.println(suma + "==" + numer.length);
                        }
                    } while (suma != numer.length);
                    //mcm = (numx) / mcm;
                    celda = String.valueOf(mcm);
                    JOptionPane.showMessageDialog(null, "El MCM es " + celda);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "¡ERROR!");
                }
            }
            if (ae.getSource() == m10) {
                try {
                    Double numero[] = new Double[tabla.getSelectedColumns().length * tabla.getSelectedRows().length];
                    int contnumero = 0;
                    for (int i = 0; i < tabla.getSelectedColumns().length; i++) {
                        for (int j = 0; j < tabla.getSelectedRows().length; j++) {
                            numero[contnumero] = Double.parseDouble(tabla.getModel().getValueAt(tabla.getSelectedRows()[j], tabla.getSelectedColumns()[i]).toString());
                            contnumero++;
                        }
                    }
                    Arrays.sort(numero);
                    JOptionPane.showMessageDialog(null, "El mayor es " + numero[numero.length - 1]);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "¡ERROR!");
                }
            }
            if (ae.getSource() == m12) {
                String celda = "";
                try {
                    int numero[] = new int[tabla.getSelectedColumns().length * tabla.getSelectedRows().length];
                    int contnumero = 0;
                    for (int i = 0; i < tabla.getSelectedColumns().length; i++) {
                        for (int j = 0; j < tabla.getSelectedRows().length; j++) {
                            numero[contnumero] = Integer.parseInt(tabla.getModel().getValueAt(tabla.getSelectedRows()[j], tabla.getSelectedColumns()[i]).toString());
                            contnumero++;
                        }
                    }
                    if (numero.length == 1) {
                        int[] arrayfibonacci = new int[(numero[0]) + 1];
                        for (int i = 0; i <= (numero[0]); i++) {
                            celda = String.valueOf(fibonacci(i, arrayfibonacci));
                        }
                        JOptionPane.showMessageDialog(null, "El numero Fibonacci[" + numero[0] + "] " + "es:" + celda);
                    } else {
                        JOptionPane.showMessageDialog(null, "¡ERROR!");
                    }
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "¡ERROR!");
                }
            }
            if (ae.getSource() == m11) {
                try {
                    Double numero[] = new Double[tabla.getSelectedColumns().length * tabla.getSelectedRows().length];
                    int contnumero = 0;
                    for (int i = 0; i < tabla.getSelectedColumns().length; i++) {
                        for (int j = 0; j < tabla.getSelectedRows().length; j++) {
                            numero[contnumero] = Double.parseDouble(tabla.getModel().getValueAt(tabla.getSelectedRows()[j], tabla.getSelectedColumns()[i]).toString());
                            contnumero++;
                        }
                    }
                    Arrays.sort(numero);
                    JOptionPane.showMessageDialog(null, "El menor es " + numero[0]);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "¡ERROR!");
                }
            }
            if (ae.getSource() == m13) {
                try {
                    Double numero[] = new Double[tabla.getSelectedColumns().length * tabla.getSelectedRows().length];
                    int contnumero = 0;
                    for (int i = 0; i < tabla.getSelectedColumns().length; i++) {
                        for (int j = 0; j < tabla.getSelectedRows().length; j++) {
                            numero[contnumero] = Double.parseDouble(tabla.getModel().getValueAt(tabla.getSelectedRows()[j], tabla.getSelectedColumns()[i]).toString());
                            contnumero++;
                        }
                    }
                    if (numero.length == 2) {
                        JOptionPane.showMessageDialog(null, "MOD " + numero[0] + " % " + numero[1] + " = " + (numero[0] % numero[1]));
                    } else {
                        JOptionPane.showMessageDialog(null, "¡ERROR!");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "¡ERROR!");
                }
            }
            if (ae.getSource() == m14) {
                String celda = "";
                try {
                    Double numero[] = new Double[tabla.getSelectedColumns().length * tabla.getSelectedRows().length];
                    int contnumero = 0;
                    for (int i = 0; i < tabla.getSelectedColumns().length; i++) {
                        for (int j = 0; j < tabla.getSelectedRows().length; j++) {
                            numero[contnumero] = Double.parseDouble(tabla.getModel().getValueAt(tabla.getSelectedRows()[j], tabla.getSelectedColumns()[i]).toString());
                            contnumero++;
                        }
                    }
                    int tamaño = tabla.getSelectedColumns().length * tabla.getSelectedRows().length;
                    int auxnumero[] = new int[tamaño];
                    int auxauxnumero[] = new int[tamaño];
                    int con = 0;
                    for (int i = 0; i < numero.length; i++) {
                        for (int j = 0; j < numero.length; j++) {
                            System.out.println(numero[i] + "==" + numero[j]);
                            if (String.valueOf(numero[i]).equals(String.valueOf(numero[j]))) {
                                con++;
                                auxnumero[i] = con;
                                auxauxnumero[i] = con;
                            }
                        }
                        con = 0;
                    }
                    Double moda[] = new Double[tamaño];
                    Arrays.sort(auxauxnumero);
                    if (auxauxnumero[0] != auxauxnumero[auxauxnumero.length - 1]) {
                        int cont = 0;
                        for (int j = 0; j < numero.length; j++) {
                            System.out.println(auxauxnumero[auxauxnumero.length - 1] + "==" + auxnumero[j]);
                            if (auxauxnumero[auxauxnumero.length - 1] == auxnumero[j]) {
                                if (cont == 0) {
                                    celda = String.valueOf(numero[j]);
                                    moda[cont] = numero[j];
                                    cont++;
                                } else {
                                    boolean verimoda = true;
                                    for (int i = 0; i < cont; i++) {
                                        if (String.valueOf(moda[i]).equals(String.valueOf(numero[j]))) {
                                            verimoda = false;
                                            i = cont;
                                        }
                                    }
                                    if (verimoda) {
                                        moda[cont] = numero[j];
                                        celda = celda + "," + String.valueOf(numero[j]);
                                        cont++;
                                    }
                                }
                            }
                        }
                        celda = "La moda es " + celda;
                    } else {
                        celda = "No Existe Moda";
                    }
                    JOptionPane.showMessageDialog(null, celda);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "¡ERROR!");
                }
            }
            if (ae.getSource() == copi) {
                try {
                    ccp.removeAll(ccp);
                    colaux = tabla.getSelectedColumns().length;
                    rowaux = tabla.getSelectedRows().length;
                    for (int i = 0; i < tabla.getSelectedColumns().length; i++) {
                        for (int j = 0; j < tabla.getSelectedRows().length; j++) {
                            if (String.valueOf(datos[tabla.getSelectedRows()[j]][tabla.getSelectedColumns()[i]]) == ("null")) {
                                ccp.add(new ccp(j, i, " "));
                            } else {
                                ccp.add(new ccp(j, i, tabla.getModel().getValueAt(tabla.getSelectedRows()[j], tabla.getSelectedColumns()[i]).toString()));
                            }
                        }
                    }
                } catch (Exception e) {
                }
            }
            if (ae.getSource() == cortar) {
                try {
                    ccp.removeAll(ccp);
                    colaux = tabla.getSelectedColumns().length;
                    rowaux = tabla.getSelectedRows().length;
                    for (int i = 0; i < tabla.getSelectedColumns().length; i++) {
                        for (int j = 0; j < tabla.getSelectedRows().length; j++) {
                            if (String.valueOf(datos[tabla.getSelectedRows()[j]][tabla.getSelectedColumns()[i]]) == ("null")) {
                                ccp.add(new ccp(j, i, " "));
                            } else {
                                ccp.add(new ccp(j, i, tabla.getModel().getValueAt(tabla.getSelectedRows()[j], tabla.getSelectedColumns()[i]).toString()));
                            }
                            tabla.getModel().setValueAt(" ", tabla.getSelectedRows()[j], tabla.getSelectedColumns()[i]);
                        }
                    }
                } catch (Exception e) {
                }
            }
            if (ae.getSource() == peg) {
                try {
                    ccp v;
                    if (!ccp.isEmpty()) {
                        Iterator<ccp> ite = ccp.iterator();
                        while (ite.hasNext()) {
                            v = ite.next();
                            tabla.getModel().setValueAt(v.getCcp(), v.getRow() + tabla.getSelectedRow(), v.getCol() + tabla.getSelectedColumn());
                        }
                    }
                } catch (Exception e) {
                }
                
            }
            if (ae.getSource() == reportes1) {
                try {
                    for (int i = 0; i < tabla.getSelectedColumns().length; i++) {
                        int contnumero = 0;
                        String numero[] = new String[tabla.getSelectedRows().length];
                        for (int j = 0; j < tabla.getSelectedRows().length; j++) {
                            if (String.valueOf(datos[tabla.getSelectedRows()[j]][tabla.getSelectedColumns()[i]]) == ("null")) {
                                numero[contnumero] = " ";
                            } else {
                                numero[contnumero] = (tabla.getModel().getValueAt(tabla.getSelectedRows()[j], tabla.getSelectedColumns()[i]).toString());
                            }
                            contnumero++;
                        }
                        try {
                            double suma = 0.00;
                            for (int j = 0; j < numero.length; j++) {
                                suma += Integer.parseInt(numero[j]);
                            }
                            Arrays.sort(numero);
                            for (int j = 0; j < numero.length; j++) {
                                tabla.getModel().setValueAt(numero[j], tabla.getSelectedRows()[j], tabla.getSelectedColumns()[i]);
                            }
                        } catch (Exception e) {
                            listasort(numero);
                            for (int j = 0; j < numero.length; j++) {
                                tabla.getModel().setValueAt(numero[j], tabla.getSelectedRows()[j], tabla.getSelectedColumns()[i]);
                            }
                        }
                        
                    }
                    crearregistro(1);
                    //JOptionPane.showMessageDialog(null, "El menor es " + numero[0]);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "¡ERROR!");
                }
            }
            if (ae.getSource() == reportes2) {
                try {
                    crearregistro(2);
                    //JOptionPane.showMessageDialog(null, "El menor es " + numero[0]);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "¡ERROR!");
                }
            }
            if (ae.getSource() == reportes3) {
                try {
                    Scanner read = new Scanner(System.in);
                    boolean verread = false;
                    do {
                        System.out.println("Ingrese palabra a buscar");
                        readword = read.next();
                        readword.trim();
                        if (readword.length() != 0) {
                            System.out.println("Palabra a buscar " + readword);
                            verread = false;
                        } else {
                            verread = true;
                        }
                    } while (verread);
                    crearregistro(3);
                    //JOptionPane.showMessageDialog(null, "El menor es " + numero[0]);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "¡ERROR!");
                }
            }
            if (ae.getSource() == reportes4) {
                try {
                    crearregistro(4);
                    //JOptionPane.showMessageDialog(null, "El menor es " + numero[0]);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "¡ERROR!");
                }
            }
            if (ae.getSource() == cuadrofunciones) {
                funciones v;
                if (!funciones.isEmpty()) {
                    Iterator<funciones> ite = funciones.iterator();
                    while (ite.hasNext()) {
                        v = ite.next();
                        if (v.getFuncion().equals(funcionaux)) {
                            funciones.set(funciones.indexOf(v), new funciones(v.getRow(), v.getCol(), cuadrofunciones.getText().trim()));
                            //datos[v.getRow()][v.getCol()] = cuadrofunciones.getText().trim();
                            //m.reload(v.getRow(), v.getCol());
                            ModeloDatos1 m = new ModeloDatos1();
                            try {
                                tabla.getModel().setValueAt("", v.getRow() + 20, v.getCol() + 20);
                                aux = "";
                                datareload = true;
                                cuadrofunciones.setFocusable(false);
                                m.reload(v.getRow() + 20, v.getCol() + 20);
                            } catch (Exception e) {
                            }
                        } else {
                        }
                    }
                }
            }
            
        } catch (Exception e) {
        }
    }
    
    private void negrita(final int selectedRow, int selectedColumn) {
        
        tabla.getColumnModel().getColumn(selectedColumn).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                JLabel label = (JLabel) comp;
                return label;
            }
        });
    }
    
    private void subrayado(final int selectedRow, int selectedColumn) {
        
        tabla.getColumnModel().getColumn(selectedColumn).setCellRenderer(new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                JLabel label = (JLabel) comp;
                int index = search(row, column);
                try {
                    formato f = formato.get(index);
                    Map attributes = fuente.getAttributes();
                    attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                    if (row == selectedRow || f.isSubrayado()) {
                        label.setFont(fuente.deriveFont(attributes));
                        if (f.isCurisva() && f.isNegrita()) {
                            fuente = new Font("Serief", Font.BOLD | Font.ITALIC, 14);
                            label.setFont(fuente.deriveFont(attributes));
                        } else if (f.isCurisva()) {
                            fuente = new Font("Serief", Font.ITALIC, 14);
                            label.setFont(fuente.deriveFont(attributes));
                        } else if (f.isNegrita()) {
                            fuente = new Font("Serief", Font.BOLD, 14);
                            label.setFont(fuente.deriveFont(attributes));
                        }
                    }
                } catch (Exception e) {
                }
                return label;
            }
        });
    }
    
    private void cursiva(final int selectedRow, int selectedColumn) {
        
        tabla.getColumnModel().getColumn(selectedColumn).setCellRenderer(new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                JLabel label = (JLabel) comp;
                int index = search(row, column);
                try {
                    formato f = formato.get(index);
                    Map attributes = fuente.getAttributes();
                    attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                    if (row == selectedRow || f.isCurisva()) {
                        fuente = new Font("Serief", Font.ITALIC, 14);
                        label.setFont(fuente);
                        if (f.isNegrita() && f.isSubrayado()) {
                            fuente = new Font("Serief", Font.BOLD | Font.ITALIC, 14);
                            label.setFont(fuente.deriveFont(attributes));
                        } else if (f.isNegrita()) {
                            fuente = new Font("Serief", Font.BOLD | Font.ITALIC, 14);
                            label.setFont(fuente);
                        } else if (f.isSubrayado()) {
                            label.setFont(fuente.deriveFont(attributes));
                        }
                    }
                } catch (Exception e) {
                }
                return label;
            }
        });
    }
    
    private int search(int selectedRow, int selectedColumn) {
        int index = -1;
        formato v;
        if (!formato.isEmpty()) {
            Iterator<formato> ite = formato.iterator();
            while (ite.hasNext()) {
                v = ite.next();
                if (v.getCol() == selectedColumn && v.getRow() == selectedRow) {
                    index = formato.indexOf(v);
                }
            }
        }
        return index;
    }
    
    private void setformatcells() {
        for (int i = 1; i < columna.length; i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    JLabel label = (JLabel) comp;
                    int index = search(row, column);
                    try {
                        formato f = formato.get(index);
                        if (f.isCurisva()) {
                            Map attributes = fuente.getAttributes();
                            fuente = new Font("Serief", Font.ITALIC, 14);
                            label.setFont(fuente);
                            if (f.isNegrita() && f.isSubrayado() && f.isTachado()) {
                                attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                                attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
                                fuente = new Font("Serief", Font.BOLD | Font.ITALIC, 14);
                                label.setFont(fuente.deriveFont(attributes));
                            } else if (f.isNegrita() && f.isSubrayado()) {
                                attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                                fuente = new Font("Serief", Font.BOLD | Font.ITALIC, 14);
                                label.setFont(fuente.deriveFont(attributes));
                            } else if (f.isNegrita() && f.isTachado()) {
                                attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
                                fuente = new Font("Serief", Font.BOLD | Font.ITALIC, 14);
                                label.setFont(fuente.deriveFont(attributes));
                            } else if (f.isSubrayado() && f.isTachado()) {
                                attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                                attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
                                fuente = new Font("Serief", Font.ITALIC | Font.PLAIN, 14);
                                label.setFont(fuente.deriveFont(attributes));
                            } else if (f.isNegrita()) {
                                fuente = new Font("Serief", Font.BOLD | Font.ITALIC, 14);
                                label.setFont(fuente);
                            } else if (f.isSubrayado()) {
                                fuente = new Font("Serief", Font.ITALIC | Font.PLAIN, 14);
                                attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                                label.setFont(fuente.deriveFont(attributes));
                            } else if (f.isTachado()) {
                                fuente = new Font("Serief", Font.ITALIC | Font.PLAIN, 14);
                                attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
                                label.setFont(fuente.deriveFont(attributes));
                            }
                        } else if (f.isSubrayado()) {
                            Map attributes = fuente.getAttributes();
                            attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                            label.setFont(fuente.deriveFont(attributes));
                            if (f.isCurisva() && f.isNegrita() && f.isTachado()) {
                                attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
                                fuente = new Font("Serief", Font.BOLD | Font.ITALIC, 14);
                                label.setFont(fuente.deriveFont(attributes));
                            } else if (f.isNegrita() && f.isTachado()) {
                                attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
                                fuente = new Font("Serief", Font.BOLD, 14);
                                label.setFont(fuente.deriveFont(attributes));
                            } else if (f.isNegrita() && f.isCurisva()) {
                                fuente = new Font("Serief", Font.BOLD | Font.ITALIC, 14);
                                label.setFont(fuente.deriveFont(attributes));
                            } else if (f.isCurisva() && f.isTachado()) {
                                attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
                                fuente = new Font("Serief", Font.ITALIC, 14);
                                label.setFont(fuente.deriveFont(attributes));
                            } else if (f.isCurisva()) {
                                fuente = new Font("Serief", Font.ITALIC, 14);
                                label.setFont(fuente.deriveFont(attributes));
                            } else if (f.isNegrita()) {
                                fuente = new Font("Serief", Font.BOLD, 14);
                                label.setFont(fuente.deriveFont(attributes));
                            } else if (f.isTachado()) {
                                attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
                                label.setFont(fuente.deriveFont(attributes));
                            }
                        } else if (f.isNegrita()) {
                            fuente = new Font("Serief", Font.BOLD, 14);
                            label.setFont(fuente);
                            if (f.isCurisva() && f.isSubrayado() && f.isTachado()) {
                                Map attributes = fuente.getAttributes();
                                attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
                                attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                                fuente = new Font("Serief", Font.BOLD | Font.ITALIC, 14);
                                label.setFont(fuente.deriveFont(attributes));
                            } else if (f.isCurisva() && f.isSubrayado()) {
                                Map attributes = fuente.getAttributes();
                                attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                                fuente = new Font("Serief", Font.BOLD | Font.ITALIC, 14);
                                label.setFont(fuente.deriveFont(attributes));
                            } else if (f.isCurisva() && f.isTachado()) {
                                Map attributes = fuente.getAttributes();
                                attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
                                fuente = new Font("Serief", Font.BOLD | Font.ITALIC, 14);
                                label.setFont(fuente.deriveFont(attributes));
                            } else if (f.isSubrayado() && f.isTachado()) {
                                Map attributes = fuente.getAttributes();
                                attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
                                attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                                fuente = new Font("Serief", Font.BOLD, 14);
                                label.setFont(fuente.deriveFont(attributes));
                            } else if (f.isCurisva()) {
                                fuente = new Font("Serief", Font.BOLD | Font.ITALIC, 14);
                                label.setFont(fuente);
                            } else if (f.isSubrayado()) {
                                Map attributes = fuente.getAttributes();
                                attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                                label.setFont(fuente.deriveFont(attributes));
                            } else if (f.isTachado()) {
                                Map attributes = fuente.getAttributes();
                                attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
                                label.setFont(fuente.deriveFont(attributes));
                            }
                        } else if (f.isTachado()) {
                            Map attributes = fuente.getAttributes();
                            attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
                            label.setFont(fuente.deriveFont(attributes));
                            if (f.isCurisva() && f.isNegrita() && f.isSubrayado()) {
                                attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                                fuente = new Font("Serief", Font.BOLD | Font.ITALIC, 14);
                                label.setFont(fuente.deriveFont(attributes));
                            } else if (f.isCurisva() && f.isNegrita()) {
                                fuente = new Font("Serief", Font.BOLD | Font.ITALIC, 14);
                                label.setFont(fuente.deriveFont(attributes));
                            } else if (f.isCurisva() && f.isSubrayado()) {
                                attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                                fuente = new Font("Serief", Font.ITALIC, 14);
                                label.setFont(fuente.deriveFont(attributes));
                            } else if (f.isNegrita() && f.isSubrayado()) {
                                attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                                fuente = new Font("Serief", Font.BOLD, 14);
                                label.setFont(fuente.deriveFont(attributes));
                            } else if (f.isCurisva()) {
                                fuente = new Font("Serief", Font.ITALIC, 14);
                                label.setFont(fuente.deriveFont(attributes));
                            } else if (f.isNegrita()) {
                                fuente = new Font("Serief", Font.BOLD, 14);
                                label.setFont(fuente.deriveFont(attributes));
                            } else if (f.isCurisva()) {
                                attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                                label.setFont(fuente.deriveFont(attributes));
                            }
                        }
                        System.out.println("Renderer " + row + " Cursiva: " + f.isCurisva() + " Negrita: " + f.isNegrita() + " Subrayado: " + f.isSubrayado() + " Tachado: " + f.isTachado());
                    } catch (Exception e) {
                    }
                    return label;
                }
            });
        }
    }
    
    private Object fibonacci(int n, int[] result) {
        int f = 0;
        if (n == 0) {
            f = 0;
            result[0] = 0;
        } else if (n == 1) {
            f = 1;
            result[1] = 1;
        } else {
// for(int i=2;i<=n;i++){
//f=f+(i-1)+(i-2);
//}
            f = result[n - 1] + result[n - 2];
            result[n] = f;
        }
        return f;
    }
    
    private void listasort(String[] x) {
        int j;
        boolean flag = true;  // will determine when the sort is finished
        String temp;
        
        while (flag) {
            flag = false;
            for (j = 0; j < x.length - 1; j++) {
                if (x[j].compareToIgnoreCase(x[j + 1]) > 0) {                                             // ascending sort
                    temp = x[j];
                    x[j] = x[j + 1];     // swapping
                    x[j + 1] = temp;
                    flag = true;
                }
            }
        }
    }
    
    private void crearregistro(int n) {
        FileWriter filewriter = null;
        PrintWriter printw = null;
        try {
            filewriter = new FileWriter("reporte" + n + ".html");//declarar el archivo
            printw = new PrintWriter(filewriter);//declarar un impresor

            printw.println("<!DOCTYPE html>\n" + "<html>");
            printw.println("<head><title>Reporte" + n + "</title>");
            printw.println("<meta charset=\"utf-8\">\n"
                    + "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
                    + "  <link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\">\n"
                    + "  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js\"></script>\n"
                    + "  <script src=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js\"></script>\n"
                    + "  <link rel=\"stylesheet\" type=\"text/css\" href=\"efectos.css\">\n"
                    + "</head>");
            //si queremos escribir una comilla " en el 
            //archivo uzamos la diagonal invertida \"
            printw.println("<body>\n"
                    + "<div class=\"container\">\n"
                    + " <div class=\"tab-content\">\n"
                    + "    <div id=\"home\" class=\"tab-pane fade in active\"><div class=\"jumbotron\">\n"
                    + "    <h1>Carlos Eduardo Cordón Hernández</h1>\n"
                    + "    <p>201504427</p> \n"
                    + "    <p>Reporte " + n + "</p> \n"
                    + "  </div>\n"
                    + "  <div class=\"row\">\n"
                    + "    <div class=\"col-sm-2\"> </div>\n"
                    + "    <div class=\"col-sm-8\">");
            //printw.println("<h2>" + "Reporte" + n + "</h2>");
            printw.println("<table class=\"table table-bordered\">");
            switch (n) {
                case 1:
                    printw.println("<thead>");
                    printw.println("<tr id=\"colortexto1\" class=\"active\">");
                    printw.println("<th> </th>");
                    for (int j = 0; j < tabla.getSelectedColumns().length; j++) {
                        printw.println("<th>" + changecolumnnumber(tabla.getSelectedColumns()[j]) + "</th>");
                    }
                    printw.println("</tr>");
                    printw.println("</thead>");
                    printw.println("<tbody>");
                    int c = tabla.getSelectedRow() + 1;
                    for (int i = 0; i < tabla.getSelectedRows().length; i++) {
                        printw.println("<tr class=\"active\">");
                        printw.println("<td style=\"text-align:justify\" class=\"text-info\"> " + c + " </td>");
                        for (int j = 0; j < tabla.getSelectedColumns().length; j++) {
                            printw.println("<td style=\"text-align:justify\" class=\"text-info\"> ");
                            printw.println(tabla.getModel().getValueAt(tabla.getSelectedRows()[i], tabla.getSelectedColumns()[j]).toString());
                            printw.println(" </td>");
                        }
                        printw.println("</tr>");
                        c++;
                    }
                    printw.println("</tbody>");
                    break;
                case 2:
                    printw.println("<thead>");
                    printw.println("<tr id=\"colortexto1\" class=\"active\">");
                    printw.println("<th> Celda </th>");
                    printw.println("<th> Contenido </th>");
                    printw.println("<th> Tipo De Contenido </th>");
                    printw.println("</tr>");
                    printw.println("</thead>");
                    printw.println("<tbody>");
                    reporte2 v;
                    if (!reporte2.isEmpty()) {
                        Iterator<reporte2> ite = reporte2.iterator();
                        while (ite.hasNext()) {
                            v = ite.next();
                            printw.println("<tr class=\"active\">");
                            printw.println("<td style=\"text-align:justify\" class=\"text-info\"> " + v.celda + " </td>");
                            printw.println("<td style=\"text-align:justify\" class=\"text-info\"> " + v.contenido + " </td>");
                            printw.println("<td style=\"text-align:justify\" class=\"text-info\"> " + v.tipo + " </td>");
                            printw.println("</tr>");
                        }
                    }
                    printw.println("</tbody>");
                    break;
                case 3:
                    printw.println("<thead>");
                    printw.println("<tr id=\"colortexto1\" class=\"active\">");
                    printw.println("<th> Celda </th>");
                    printw.println("<th> Contenido </th>");
                    printw.println("</tr>");
                    printw.println("</thead>");
                    printw.println("<tbody>");
                    reporte2 v2;
                    if (!reporte2.isEmpty()) {
                        Iterator<reporte2> ite = reporte2.iterator();
                        while (ite.hasNext()) {
                            v2 = ite.next();
                            char sortb[] = readword.toCharArray();
                            System.out.println(v2.contenido.length() + " >= " + sortb.length);
                            if (v2.contenido.length() >= sortb.length) {
                                System.out.println("intento");
                                for (int i = 0; i <= (v2.contenido.length() - sortb.length); i++) {
                                    int cont = 0;
                                    for (int j = 0; j < sortb.length; j++) {
                                        if (String.valueOf(sortb[j]).equalsIgnoreCase(String.valueOf(v2.contenido.charAt(i + j)))) {
                                            cont++;
                                            System.out.println(cont);
                                        }
                                    }
                                    if (cont == sortb.length) {
                                        printw.println("<tr class=\"active\">");
                                        printw.println("<td style=\"text-align:justify\" class=\"text-info\"> " + v2.celda + " </td>");
                                        printw.println("<td style=\"text-align:justify\" class=\"text-info\"> " + v2.contenido + " </td>");
                                        printw.println("</tr>");
                                    }
                                }
                            }
                        }
                    }
                    printw.println("</tbody>");
                    break;
                case 4:
                    printw.println("<thead>");
                    printw.println("<tr id=\"colortexto1\" class=\"active\">");
                    printw.println("<th> </th>");
                    for (int j = 0; j < tabla.getSelectedColumns().length; j++) {
                        printw.println("<th>" + changecolumnnumber(tabla.getSelectedColumns()[j]) + "</th>");
                    }
                    printw.println("</tr>");
                    printw.println("</thead>");
                    printw.println("<tbody>");
                    int cc = tabla.getSelectedRow() + 1;
                    for (int i = 0; i < tabla.getSelectedRows().length; i++) {
                        printw.println("<tr class=\"active\">");
                        printw.println("<td style=\"text-align:justify\" class=\"text-info\"> " + cc + " </td>");
                        for (int j = 0; j < tabla.getSelectedColumns().length; j++) {
                            printw.println("<td style=\"text-align:justify\" class=\"text-info\"> ");
                            if (String.valueOf(datos[tabla.getSelectedRows()[i]][tabla.getSelectedColumns()[j]]) == ("null")) {
                                printw.println(" </td>");
                            } else {
                                printw.println(tabla.getModel().getValueAt(tabla.getSelectedRows()[i], tabla.getSelectedColumns()[j]).toString());
                                printw.println("</td>");
                            }
                        }
                        printw.println("</tr>");
                        cc++;
                    }
                    printw.println("</tbody>");
                    break;
            }
            printw.println("</table>");
            printw.println("</div>\n"
                    + "    <div class=\"col-sm-2\"></div>\n"
                    + "  </div>\n"
                    + "    </div>\n"
                    + "    </div>\n"
                    + "  </div>\n"
                    + "</body>");
            printw.println("</html>");

            //no devemos olvidar cerrar el archivo para que su lectura sea correcta
            printw.close();//cerramos el archivo

            System.out.println("Generado exitosamente");//si todo sale bien mostramos un mensaje de guardado exitoso
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    private String changecolumnnumber(int j) {
        return columna[j];
    }
    
    private class LabelRenderer extends DefaultTableCellRenderer {
        
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (value instanceof JLabel) {
                return (JLabel) value;
            } else {
                return comp;
            }
        }
    }
    // El Modelo de la Tabla es el que controla todos los
// datos que se colocan en ella

    class ModeloDatos1 extends AbstractTableModel {
        
        private boolean matrizrespaldoswitch;
// Esta clase imprime los datos en la consola cada vez
        // que se produce un cambio en cualquiera de las
        // casillas de la tabla

        class TablaListener extends calculos implements TableModelListener {
            
            public void tableChanged(TableModelEvent evt) {
                /*for (int i = 0; i < matrizrespaldo.length; i++) {
                 for (int j = 0; j < matrizrespaldo[0].length; j++) {
                 System.out.print(matrizrespaldo[i][j] + " ");
                 }
                 System.out.println();
                 }*/
                System.out.println("Cambio Detectado");
                System.out.println("datareload " + datareload);
                String[] arrayceldas;
                String funcion = "";
                String linea = "";
                int contcoma = 0;
                int cont2puntos = 0;
                String datacelda = datos[tabla.getSelectedRow()][tabla.getSelectedColumn()].toString();
                System.out.println("aux: " + aux + " data " + datacelda);
                try {
                    if (String.valueOf(datacelda.charAt(0)).equalsIgnoreCase("=")) {
                        StringTokenizer st = new StringTokenizer(datacelda, "=()");
                        while (st.hasMoreTokens()) {
                            if (funcion.equals("")) {
                                funcion = st.nextToken();
                            } else {
                                linea = st.nextToken();
                                for (int i = 0; i < linea.length(); i++) {
                                    if (String.valueOf(linea.charAt(i)).equals(":")) {
                                        cont2puntos++;
                                    }
                                    if (String.valueOf(linea.charAt(i)).equals(",")) {
                                        contcoma++;
                                    }
                                }
                            }
                        }
                        System.out.println("funcion: " + funcion + " linea: " + linea + " dos puntos:" + cont2puntos + " comas:" + contcoma);
                        if (cont2puntos == 0 && contcoma == 0) {
                            if (funcion.equalsIgnoreCase("fibo")) {
                                String showfuncion = funciones(funcion, linea, 0, datos, tabla);
                                tabla.getModel().setValueAt(showfuncion, tabla.getSelectedRow(), tabla.getSelectedColumn());
                                funciones.add(new funciones(tabla.getSelectedRow(), tabla.getSelectedColumn(), datacelda));
                                String cell = cellchange(tabla.getSelectedRow(), tabla.getSelectedColumn());
                                reporte2.add(new reporte2(cell, datacelda, "Formula"));
                                contcoma = 0;
                                cont2puntos = 0;
                                funcion = "";
                                linea = "";
                            } else {
                                tabla.getModel().setValueAt("¡ERROR!", tabla.getSelectedRow(), tabla.getSelectedColumn());
                            }
                        } else if (cont2puntos == 1 && contcoma == 0) {
                            int tipo = 1;
                            String showfuncion = funciones(funcion, linea, tipo, datos, tabla);
                            tabla.getModel().setValueAt(showfuncion, tabla.getSelectedRow(), tabla.getSelectedColumn());
                            funciones.add(new funciones(tabla.getSelectedRow(), tabla.getSelectedColumn(), datacelda));
                            String cell = cellchange(tabla.getSelectedRow(), tabla.getSelectedColumn());
                            reporte2.add(new reporte2(cell, datacelda, "Formula"));
                            contcoma = 0;
                            cont2puntos = 0;
                            funcion = "";
                            linea = "";
                        } else if (contcoma >= 1 && cont2puntos == 0) {
                            int tipo = 2;
                            String showfuncion = funciones(funcion, linea, tipo, datos, tabla);
                            tabla.getModel().setValueAt(showfuncion, tabla.getSelectedRow(), tabla.getSelectedColumn());
                            funciones.add(new funciones(tabla.getSelectedRow(), tabla.getSelectedColumn(), datacelda));
                            String cell = cellchange(tabla.getSelectedRow(), tabla.getSelectedColumn());
                            reporte2.add(new reporte2(cell, datacelda, "Formula"));
                            contcoma = 0;
                            cont2puntos = 0;
                            funcion = "";
                            linea = "";
                        } else {
                            tabla.getModel().setValueAt("¡ERROR!", tabla.getSelectedRow(), tabla.getSelectedColumn());
                        }
                    } else {
                        String cell = cellchange(tabla.getSelectedRow(), tabla.getSelectedColumn());
                        reporte2 v1;
                        if (!reporte2.isEmpty()) {
                            Iterator<reporte2> ite = reporte2.iterator();
                            while (ite.hasNext()) {
                                v1 = ite.next();
                                if (v1.celda == cell) {
                                    reporte2.set(reporte2.indexOf(v1), new reporte2(cell, datacelda, "Texto"));
                                } else {
                                    reporte2.add(new reporte2(cell, datacelda, "Texto"));
                                }
                            }
                        } else {
                            reporte2.add(new reporte2(cell, datacelda, "Texto"));
                        }
                        
                    }
                    System.out.println("datacelda: " + datacelda);
                    
                } catch (Exception e) {
                }
                if (!aux.equals(datacelda)) {
                    aux = datacelda;
                    datareload = false;
                    System.out.println("Actualizacion De Celda(s)");
                    funciones v;
                    if (!funciones.isEmpty()) {
                        Iterator<funciones> ite = funciones.iterator();
                        while (ite.hasNext()) {
                            v = ite.next();
                            contcoma = 0;
                            cont2puntos = 0;
                            funcion = "";
                            linea = "";
                            int i = v.getRow();
                            int j = v.getCol();
                            StringTokenizer st = new StringTokenizer(v.getFuncion(), "=()");
                            while (st.hasMoreTokens()) {
                                if (funcion.equals("")) {
                                    funcion = st.nextToken();
                                } else {
                                    linea = st.nextToken();
                                    for (int k = 0; k < linea.length(); k++) {
                                        if (String.valueOf(linea.charAt(k)).equals(":")) {
                                            cont2puntos++;
                                        }
                                        if (String.valueOf(linea.charAt(k)).equals(",")) {
                                            contcoma++;
                                        }
                                    }
                                }
                            }
                            System.out.println("funcion: " + funcion + " linea: " + linea + " dos puntos:" + cont2puntos + " comas:" + contcoma);
                            if (cont2puntos == 0 && contcoma == 0) {
                                if (funcion.equalsIgnoreCase("fibo")) {
                                    String showfuncion = funciones(funcion, linea, 0, datos, tabla);
                                    tabla.getModel().setValueAt(showfuncion, i, j);
                                    contcoma = 0;
                                    cont2puntos = 0;
                                    funcion = "";
                                    linea = "";
                                } else {
                                    tabla.getModel().setValueAt("¡ERROR!", i, j);
                                }
                            } else if (cont2puntos == 1 && contcoma == 0) {
                                int tipo = 1;
                                String showfuncion = funciones(funcion, linea, tipo, datos, tabla);
                                tabla.getModel().setValueAt(showfuncion, i, j);
                                contcoma = 0;
                                cont2puntos = 0;
                                funcion = "";
                                linea = "";
                            } else if (contcoma >= 1 && cont2puntos == 0) {
                                int tipo = 2;
                                String showfuncion = funciones(funcion, linea, tipo, datos, tabla);
                                tabla.getModel().setValueAt(showfuncion, tabla.getSelectedRow(), tabla.getSelectedColumn());
                                contcoma = 0;
                                cont2puntos = 0;
                                funcion = "";
                                linea = "";
                            }
                        }
                    }
                    /*for (int i = 0; i < matrizrespaldo.length; i++) {
                     for (int j = 0; j < matrizrespaldo[0].length; j++) {
                     if (String.valueOf(matrizrespaldo[i][j]) != "null") {
                     if (String.valueOf(String.valueOf(matrizrespaldo[i][j]).charAt(0)).equalsIgnoreCase("=")) {
                     contcoma = 0;
                     cont2puntos = 0;
                     funcion = "";
                     linea = "";
                     StringTokenizer st = new StringTokenizer(datacelda, "=()");
                     while (st.hasMoreTokens()) {
                     if (funcion.equals("")) {
                     funcion = st.nextToken();
                     } else {
                     linea = st.nextToken();
                     for (int k = 0; k < linea.length(); k++) {
                     if (String.valueOf(linea.charAt(k)).equals(":")) {
                     cont2puntos++;
                     }
                     if (String.valueOf(linea.charAt(k)).equals(",")) {
                     contcoma++;
                     }
                     }
                     }
                     }
                     System.out.println("-funcion: " + funcion + " linea: " + linea + " dos puntos:" + cont2puntos);
                     if (cont2puntos == 0 && contcoma == 0) {
                     tabla.getModel().setValueAt("¡ERROR!", i, j);
                     } else if (cont2puntos == 1) {
                     matrizrespaldoswitch = true;
                     int tipo = 1;
                     String showfuncion = funciones(funcion, linea, tipo);
                     contcoma = 0;
                     cont2puntos = 0;
                     funcion = "";
                     linea = "";
                     tabla.getModel().setValueAt(showfuncion, i, j);
                     } else if (contcoma > 1) {
                     }
                     }
                     }
                     }
                     }*/
                }
            }
            
            private String cellchange(int selectedRow, int selectedColumn) {
                return changecolumnnumber(selectedColumn) + (selectedRow + 1);
            }
        }
        // Constructor

        ModeloDatos1() {
            addTableModelListener(new TablaListener());
            for (int i = 0; i < 100; i++) {
                datos[i][0] = i + 1;
            }
        }
        // Devuelve el número de columnas de la tabla

        public int getColumnCount() {
            return columna.length;
        }
        
        public String getColumnName(int col) {
            return columna[col];
        }
        // Devuelve el número de filas de la tabla

        public int getRowCount() {
            return (datos.length);
        }
        // Devuelve el valor de una determinada casilla de la tabla
        // identificada mediante fila y columna

        public Object getValueAt(int fila, int col) {
            return (datos[fila][col]);
        }
        // Cambia el valor que contiene una determinada casilla de
        // la tabla

        public void setValueAt(Object valor, int fila, int col) {
            datos[fila][col] = valor;
            // Indica que se ha cambiado
            fireTableCellUpdated(fila, col);
        }
        
        public void reload(int fila, int col) {
            // Indica que se ha cambiado
            try {
                fireTableCellUpdated(fila, col);
            } catch (Exception e) {
            }
            
        }
        // Indica si la casilla identificada por fila y columna es
        // editable

        public boolean isCellEditable(int fila, int col) {
            if (col == 0) {
                return false;
            }
            return true;
        }
    }
    
    private void cargarlistas() {
        for (int i = 1; i <= tamcol; i++) {
            ListaSimple lissim = null;
            for (int j = 0; j < tamfil; j++) {
                if (j == 0) {
                    lissim = new ListaSimple(tabla.getValueAt(j, i).toString());
                } else {
                    lissim.insertarAlFinal(tabla.getValueAt(j, i));
                }
            }
            lista.insertarAlFinal(lissim);
        }
        lista.imprimir();
        javax.swing.JFileChooser jF1 = new javax.swing.JFileChooser();
        jF1.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        jF1.setFileFilter(new FileNameExtensionFilter("*.ser", "ser"));
        //jF1.setCurrentDirectory(new File(pathfolder));
        String ruta = "";
        try {
            if (jF1.showSaveDialog(null) == jF1.APPROVE_OPTION) {
                ruta = jF1.getSelectedFile().getAbsolutePath();
                System.out.println(ruta.toString());
                try {
                    FileOutputStream fileOut = new FileOutputStream(ruta);
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    //out.writeObject(this.lista);
                    out.writeObject(lista);
                    out.close();
                    fileOut.close();
                    System.out.println("Lista serializada exitosamente!");
                    //this.console.setText("Lista serializada exitosamente!");
                } catch (IOException i) {
                    //this.console.setText("Ocurrio un error al serializar la lista.");
                }
            }
        } catch (Exception e) {
        }
    }
}
