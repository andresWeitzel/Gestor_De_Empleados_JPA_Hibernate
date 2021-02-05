/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage.gui.empleados;

import java.awt.Color;
import static java.lang.Float.max;
import static java.lang.Float.min;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JFrame;
import mypackage.repositories.interfaces.I_EmpleadoRepository;
import mypackage.repositories.jpa.EmpleadoRepository;
import mypackage.utils.swing.Table;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author andre
 */
public class JFrameAnalyticsEmpleado extends javax.swing.JFrame {
    
        private EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("mypackage_GestorEmpleadosJPAHibernate_app_jar_1.0-SNAPSHOTPU");
    

    private I_EmpleadoRepository empleadoRepository = new EmpleadoRepository(entityManagerFactory);

    /** Creates new form JFrameAnalytics */
    public JFrameAnalyticsEmpleado() {
        initComponents();
        listarEmpleados();
        setearTextFields();
    }
    /*
        COLOCO LA LISTA DE EMPLEADOS ENCONDIDA EN EL JFRAME PORQUE ES MAS FACIL, MENOS CODIGO
    Y MAS ENTENDIBLE COLOCAR LOS JTEXTFIELDS Y REALIZAR LOS GRAFICOS DESDE ACA Y NO ANDAR ENVIANDO
    LOS DATOS DESDE OTRO JFRAME
     */

    //=============================================
    //===LISTAMOS LOS EMPLEADOS EN LA TABLA ESCONDIDA==
    //=============================================
    public void listarEmpleados() {

        new Table().cargar(jTableListaEmpleados, empleadoRepository.getAll());

    }
    //=============================================
    //===FIN LISTAMOS LOS EMPLEADOS EN LA TABLA ESCONDIDA==
    //=============================================

    //=============================================
    //===SET VALORES DE LA DB A LOS JTEXTFIELDS=======
    //=============================================
    public void setearTextFields() {
        //-----------------------------------
        //------EDAD(columna 3)-----
        //-----------------------------------
    //CANTIDAD
        //jTextFieldEdadesCantidad.setText(String.valueOf(cantidadValores(3)));
        jTextFieldEdadesCantidad.setText(String.valueOf(cantidadValores(3)));
        //MAXIMO
        jTextFieldEdadMaxima.setText(String.valueOf(maximaValores(3)));

        //MINIMO
        jTextFieldEdadMinima.setText(String.valueOf(minimaValores(3)));

        //PROMEDIO-MEDIA
        jTextFieldEdadPromedio.setText(String.valueOf(promedioValores(3)));

        //MODA-MEDIANA
        jTextFieldEdadQueMasSeRepite.setText(String.valueOf(modaFrecuenciaValores(3).get(0)));

        //FRECUENCIA DE VECES MODA-MEDIANA
        jTextFieldFrecuenciaEdadQueMasSeRepite.setText(String.valueOf(modaFrecuenciaValores(3).get(1)));

        //DISPERSION RESPECTO AL PROMEDIO-MEDIA (VARIANZA)
        //HAY QUE EFIENTIZAR ESTOS METODOS, COLOCANDO ESTOS PARAMETROS NOS OLVIDAMOS DE CREAR MILES DE METODOS
        jTextFieldVarianzaEdad.setText(String.valueOf(varianzaValores(3, 3)));

        //GRADO DE DISPERSION (DESVIO ESTANDAR)
        //HAY QUE EFIENTIZAR ESTOS METODOS, COLOCANDO ESTOS PARAMETROS NOS OLVIDAMOS DE CREAR MILES DE METODOS
        jTextFieldDesvioEstandarEdad.setText(String.valueOf(desvioEstandarValores(3, 3, 3)));

        //----------------------------------------
        //------FIN EDAD(columna 3)-----
        //----------------------------------------
        //--------------------------------------------------------------------------------------------
        //-----------CANTIDAD DE HORAS SEMANALES(columna 10)---------------
        //---------------------------------------------------------------------------------------------
                //CANTIDAD
        //jTextFieldHsSemanalesCantidad.setText(String.valueOf(cantidadValores(10)));
        jTextFieldHsSemanalesCantidad.setText(String.valueOf(cantidadValores(10)));
        //MAXIMO
        jTextFieldHsSemanalesMaxima.setText(String.valueOf(maximaValores(10)));

        //MINIMO
        jTextFieldHsSemanalesMinima.setText(String.valueOf(minimaValores(10)));

        //PROMEDIO-MEDIA
        jTextFieldHsSemanalesPromedio.setText(String.valueOf(promedioValores(10)));

        //MODA-MEDIANA
        jTextFieldHsSemanalesQueMasSeRepite.setText(String.valueOf(modaFrecuenciaValores(10).get(0)));

        //FRECUENCIA DE VECES MODA-MEDIANA
        jTextFieldFrecuenciaHsSemanalesQueMasSeRepite.setText(String.valueOf(modaFrecuenciaValores(10).get(1)));

        //DISPERSION RESPECTO AL PROMEDIO-MEDIA (VARIANZA)
        //HAY QUE EFIENTIZAR ESTOS METODOS, COLOCANDO ESTOS PARAMETROS NOS OLVIDAMOS DE CREAR MILES DE METODOS
        jTextFieldVarianzaHsSemanales.setText(String.valueOf(varianzaValores(10, 10)));

        //GRADO DE DISPERSION (DESVIO ESTANDAR)
        //HAY QUE EFIENTIZAR ESTOS METODOS, COLOCANDO ESTOS PARAMETROS NOS OLVIDAMOS DE CREAR MILES DE METODOS
        jTextFieldDesvioEstandarHsSemanales.setText(String.valueOf(desvioEstandarValores(10, 10, 10)));

        //-------------------------------------------------------------------------------------------------
        //-----------FIN CANTIDAD DE HORAS SEMANALES(columna 10)---------------
        //---------------------------------------------------------------------------------------------------
        
        //---------------------------------------------------------
        //-----------SUELDO(columna 11)---------------
        //----------------------------------------------------------
   //CANTIDAD
        //jTextFieldSueldoCantidad.setText(String.valueOf(cantidadValores(11)));
        jTextFieldSueldoCantidad.setText(String.valueOf(cantidadValores(11)));
        //MAXIMO
        jTextFieldSueldoMaximo.setText(String.valueOf(maximaValoresSueldoDecimal(11)));

        //MINIMO
        jTextFieldSueldoMinimo.setText(String.valueOf(minimaValoresSueldoDecimal(11)));

        //PROMEDIO-MEDIA
        jTextFieldSueldoPromedio.setText(String.valueOf(promedioValoresSueldoDecimal(11)));

        //MODA-MEDIANA
        jTextFieldSueldoQueMasSeRepite.setText(modaFrecuenciaValoresSueldoDecimal(11).get(0));

        //FRECUENCIA DE VECES MODA-MEDIANA
        jTextFieldFrecuenciaSueldoQueMasSeRepite.setText(modaFrecuenciaValoresSueldoDecimal(11).get(1));

        //DISPERSION RESPECTO AL PROMEDIO-MEDIA (VARIANZA)
        //HAY QUE EFIENTIZAR ESTOS METODOS, COLOCANDO ESTOS PARAMETROS NOS OLVIDAMOS DE CREAR MILES DE METODOS
        jTextFieldVarianzaSueldo.setText(String.valueOf(varianzaValoresSueldoDecimal(11, 11)));

        //GRADO DE DISPERSION (DESVIO ESTANDAR)
        //HAY QUE EFIENTIZAR ESTOS METODOS, COLOCANDO ESTOS PARAMETROS NOS OLVIDAMOS DE CREAR MILES DE METODOS
        jTextFieldDesvioEstandarSueldo.setText(String.valueOf(desvioEstandarValoresSueldoDecimal(11, 11, 11)));
//        //--------------------------------------------------------------
//        //-----------FIN SUELDO(columna 11)---------------
//        //--------------------------------------------------------------
    }

    //=============================================
    //===FIN SET VALORES DE LA DB A LOS JTEXTFIELDS=======
    //=============================================
    //=============================================
    //==============GRÁFICOS=====================
    //=============================================
    JFreeChart GraficaEdad;
    JFreeChart GraficaHsSemanales;
    JFreeChart GraficaSueldo;

    DefaultCategoryDataset DatosEdad = new DefaultCategoryDataset();
    DefaultCategoryDataset DatosHsSemanales = new DefaultCategoryDataset();
    DefaultCategoryDataset DatosSueldo = new DefaultCategoryDataset();

    public void graficarGraficoEdad() {
          DatosEdad.addValue(cantidadValores(3), "EDAD", "CANTIDAD");
        DatosEdad.addValue(promedioValores(3), "EDAD", "PROMEDIO");
        DatosEdad.addValue(maximaValores(3), "EDAD", "MÁXIMA");
        DatosEdad.addValue(minimaValores(3), "EDAD", "MÍNIMA");
        DatosEdad.addValue(Integer.valueOf(modaFrecuenciaValores(3).get(0)), "EDAD", "MODA");
        DatosEdad.addValue(Integer.valueOf(modaFrecuenciaValores(3).get(1)), "EDAD", "FRECUENCIA MODA");
        DatosEdad.addValue(varianzaValores(3, 3), "EDAD", "VARIANZA");
        DatosEdad.addValue(desvioEstandarValores(3, 3, 3), "EDAD", "DESVIO ESTANDAR");

//Creamos un grafico de tipo barras
        GraficaEdad = ChartFactory.createBarChart("GRÁFICA DE ANALYTICS EDAD",
                "ESTADISTICA", "VALORES OBTENIDOS", DatosEdad,
                PlotOrientation.HORIZONTAL, true, true, false);

//Agregamos nuestro grafico a una nueva ventana
        ChartPanel Panel = new ChartPanel(GraficaEdad);
        JFrame Ventana = new JFrame("JFreeChartAnalyticsEdad");
        Ventana.getContentPane().add(Panel);
        Ventana.pack();
        Ventana.setVisible(true);
        Ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    public void graficarGraficoHsSemanales() {
        //DatosHsSemanales.addValue(cantidadValores(10), "HORAS SEMANALES", "CANTIDAD");
        DatosHsSemanales.addValue(cantidadValores(10), "HORAS SEMANALES", "CANTIDAD");
        DatosHsSemanales.addValue(promedioValores(10), "HORAS SEMANALES", "PROMEDIO");
        DatosHsSemanales.addValue(maximaValores(10), "HORAS SEMANALES", "MÁXIMA");
         DatosHsSemanales.addValue(minimaValores(10), "HORAS SEMANALES", "MÍNIMA");
        DatosHsSemanales.addValue(Integer.valueOf(modaFrecuenciaValores(10).get(0)), "HORAS SEMANALES", "MODA");
        DatosHsSemanales.addValue(Integer.valueOf(modaFrecuenciaValores(10).get(1)), "HORAS SEMANALES", "FRECUENCIA MODA");
        DatosHsSemanales.addValue(varianzaValores(10, 10), "HORAS SEMANALES", "VARIANZA");
        DatosHsSemanales.addValue(desvioEstandarValores(10, 10, 10), "HORAS SEMANALES", "DESVIO ESTANDAR");

//Creamos un grafico de tipo barras
        GraficaHsSemanales = ChartFactory.createBarChart("GRÁFICA DE ANALYTICS HORAS SEMANALES",
                "ESTADISTICA", "VALORES OBTENIDOS", DatosHsSemanales,
                PlotOrientation.HORIZONTAL, true, true, false);

//Agregamos nuestro grafico a una nueva ventana
        ChartPanel Panel = new ChartPanel(GraficaHsSemanales);
        JFrame Ventana = new JFrame("JFreeChartAnalyticsHsSemanales");
        Ventana.getContentPane().add(Panel).setBackground(Color.yellow);
        Ventana.pack();
        Ventana.setVisible(true);
        Ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    public void graficarGraficoSueldo() {
        //DatosSueldo.addValue(cantidadValores(11), "SUELDO", "CANTIDAD");
        DatosSueldo.addValue(cantidadValores(11), "SUELDO", "CANTIDAD");
        DatosSueldo.addValue(promedioValoresSueldoDecimal(11), "SUELDO", "PROMEDIO");
        DatosSueldo.addValue(maximaValoresSueldoDecimal(11), "SUELDO", "MÁXIMA");
        DatosSueldo.addValue(minimaValoresSueldoDecimal(11), "SUELDO", "MÍNIMA");
        DatosSueldo.addValue(Float.valueOf(modaFrecuenciaValoresSueldoDecimal(11).get(0)), "SUELDO", "MODA");
        DatosSueldo.addValue(Float.valueOf(modaFrecuenciaValoresSueldoDecimal(11).get(1)), "SUELDO", "FRECUENCIA MODA");
        DatosSueldo.addValue(varianzaValoresSueldoDecimal(11, 11), "SUELDO", "VARIANZA");
        DatosSueldo.addValue(desvioEstandarValoresSueldoDecimal(11, 11, 11), "SUELDO", "DESVIO ESTANDAR");

//Creamos un grafico de tipo barras
        GraficaSueldo = ChartFactory.createBarChart("GRÁFICA DE ANALYTICS SUELDO",
                "ESTADISTICA", "VALORES OBTENIDOS", DatosSueldo,
                PlotOrientation.HORIZONTAL, true, true, false);

//Agregamos nuestro grafico a una nueva ventana
        ChartPanel Panel = new ChartPanel(GraficaSueldo);
        JFrame Ventana = new JFrame("JFreeChartAnalyticsSueldo");
        Ventana.getContentPane().add(Panel).setBackground(Color.yellow);
        Ventana.pack();
        Ventana.setVisible(true);
        Ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    //=============================================
    //==============FIN GRÁFICOS=====================
    //=============================================
    //=============================================
    //==============ANALYTICS=====================
    //=============================================

    
    
      public int cantidadValores(int columnaTabla) {
        int cantidad = 0;

        try {
            for (int i = 0; i < jTableListaEmpleados.getRowCount(); i++) {

                cantidad = jTableListaEmpleados.getRowCount();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cantidad;
    }
      
      
//---------------------------------------------------------------------------------
    public int maximaValores(int columnaTabla) {
        int max = 0;
        try {
            for (int i = 0; i < jTableListaEmpleados.getRowCount(); i++) {

                max = Math.round(max(max, Integer.parseInt(jTableListaEmpleados.getValueAt(i, columnaTabla).toString())));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return max;
    }
//---------------------------------------------------------------------------------
    public float maximaValoresSueldoDecimal(int columnaTabla) {
        float max = 0;
        try {
            for (int i = 0; i < jTableListaEmpleados.getRowCount(); i++) {

                max = Math.round(max(max, Float.parseFloat(jTableListaEmpleados.getValueAt(i, columnaTabla).toString())));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return max;
    }
//---------------------------------------------------------------------------------
    public int minimaValores(int columnaTabla) {

        int min = Integer.parseInt(jTableListaEmpleados.getValueAt(0, columnaTabla).toString());

        try {
            for (int i = 0; i < jTableListaEmpleados.getRowCount(); i++) {

                // min = Math.round(min(min, Integer.parseInt(jTableListaEmpleados.getValueAt(i, columnaTabla).toString())));
                min = Math.round(min(min, Integer.parseInt(jTableListaEmpleados.getValueAt(i, columnaTabla).toString())));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return min;
    }
//---------------------------------------------------------------------------------
    
     public float minimaValoresSueldoDecimal(int columnaTabla) {

        float min = Float.parseFloat(jTableListaEmpleados.getValueAt(0, columnaTabla).toString());

        try {
            for (int i = 0; i < jTableListaEmpleados.getRowCount(); i++) {

                // min = Math.round(min(min, Integer.parseInt(jTableListaEmpleados.getValueAt(i, columnaTabla).toString())));
                min = Math.round(min(min, Float.parseFloat(jTableListaEmpleados.getValueAt(i, columnaTabla).toString())));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return min;
    }
//---------------------------------------------------------------------------------
    public int promedioValores(int columnaTabla) {
        int sum = 0;
        int promedio = 0;
        try {
            for (int i = 0; i < jTableListaEmpleados.getRowCount(); i++) {

                sum += Integer.parseInt(jTableListaEmpleados.getValueAt(i, columnaTabla).toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        promedio = sum / jTableListaEmpleados.getRowCount();
        return promedio;

    }
//---------------------------------------------------------------------------------
    public float promedioValoresSueldoDecimal(int columnaTabla) {
        float sum = 0;
        float promedio = 0;
        try {
            for (int i = 0; i < jTableListaEmpleados.getRowCount(); i++) {

                sum += Float.parseFloat(jTableListaEmpleados.getValueAt(i, columnaTabla).toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        promedio = sum / jTableListaEmpleados.getRowCount();
        return promedio;

    }
//---------------------------------------------------------------------------------
    public List<String> modaFrecuenciaValores(int columnaTabla) {

        int valores = 0;

        List<Integer> arrayValores = new ArrayList<Integer>();

        try {
            for (int i = 0; i < jTableListaEmpleados.getRowCount(); i++) {

                valores = Integer.valueOf(jTableListaEmpleados.getValueAt(i, columnaTabla).toString());

                arrayValores.add(valores);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Hasta aca guardamos todos los elementos de la jTable en List

        //Ahora realizamos el calculo de la moda
        int moda = 0;

        int frecuenciaDeVecesQueSeRepite = 0;

        for (int i = 0; i < arrayValores.size(); i++) {

            int vecesQueSeRepite = 0;

            for (int j = 0; j < arrayValores.size(); j++) {

                if (arrayValores.get(i) == arrayValores.get(j)) {

                    vecesQueSeRepite++;
                }
            }
            if (vecesQueSeRepite > frecuenciaDeVecesQueSeRepite) {

                moda = arrayValores.get(i);

                frecuenciaDeVecesQueSeRepite = vecesQueSeRepite;
            }
        }
        //  Como no podemos tener un return dos veces devolvemos una List de enteros con ambos valores
        List<String> valoresObtenidos = new ArrayList<String>();

        valoresObtenidos.add(String.valueOf(moda));
        valoresObtenidos.add(String.valueOf(frecuenciaDeVecesQueSeRepite));

        return valoresObtenidos;
    }
    
    
    
    
//---------------------------------------------------------------------------------
     public List<String> modaFrecuenciaValoresSueldoDecimal(int columnaTabla) {

        float valores = 0;

        List<Float> arrayValores = new ArrayList<Float>();

        try {
            for (int i = 0; i < jTableListaEmpleados.getRowCount(); i++) {

                valores = Float.valueOf(jTableListaEmpleados.getValueAt(i, columnaTabla).toString());

                arrayValores.add(valores);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Hasta aca guardamos todos los elementos de la jTable en List

        //Ahora realizamos el calculo de la moda
        float moda = 0;

        int frecuenciaDeVecesQueSeRepite = 0;

        for (int i = 0; i < arrayValores.size(); i++) {

            int vecesQueSeRepite = 0;

            for (int j = 0; j < arrayValores.size(); j++) {

                if (arrayValores.get(i) == arrayValores.get(j)) {

                    vecesQueSeRepite++;
                }
            }
            if (vecesQueSeRepite > frecuenciaDeVecesQueSeRepite) {

                moda = arrayValores.get(i);

                frecuenciaDeVecesQueSeRepite = vecesQueSeRepite;
            }
        }
        //  Como no podemos tener un return dos veces devolvemos una List de enteros con ambos valores
        List<String> valoresObtenidos = new ArrayList<String>();

        valoresObtenidos.add(String.valueOf(moda));
        valoresObtenidos.add(String.valueOf(frecuenciaDeVecesQueSeRepite));

        return valoresObtenidos;
    }
//---------------------------------------------------------------------------------
    //El segundo parametro nos aseguramos de no crear metodos repetidos
    public double varianzaValores(int columnaTabla, int columnaTablaPromedioValores) {

        int valores;
        double varianza = 0.0;
        DecimalFormat decimalFormat = new DecimalFormat("###.##");

        List<Integer> arrayValores = new ArrayList<Integer>();

        try {
            for (int i = 0; i < jTableListaEmpleados.getRowCount(); i++) {

                valores = Integer.valueOf(jTableListaEmpleados.getValueAt(i, columnaTabla).toString());

                arrayValores.add(valores);
            }
            for (int j = 0; j < jTableListaEmpleados.getRowCount(); j++) {
                double rango;
                rango = Math.pow(arrayValores.get(j) - promedioValores(columnaTablaPromedioValores), 2f);
                varianza = varianza + rango;
            }
            //suma de diferencias sobre "n"
            varianza = varianza / Double.valueOf(arrayValores.size());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return varianza;
    }
    
    
    
    
    
    
//---------------------------------------------------------------------------------

       //El segundo parametro nos aseguramos de no crear metodos repetidos
    public double varianzaValoresSueldoDecimal(int columnaTabla, int columnaTablaPromedioValores) {

        double valores;
        double varianza = 0.0;

        List<Double> arrayValores = new ArrayList<Double>();

        try {
            for (int i = 0; i < jTableListaEmpleados.getRowCount(); i++) {

                valores = Double.valueOf(jTableListaEmpleados.getValueAt(i, columnaTabla).toString());

                arrayValores.add(valores);
            }
            for (int j = 0; j < jTableListaEmpleados.getRowCount(); j++) {
                double rango;
   
                rango =Math.pow(arrayValores.get(j) - promedioValoresSueldoDecimal(columnaTablaPromedioValores), 2f);
               
                varianza = varianza + rango;
            }
            //suma de diferencias sobre "n"
            varianza = Math.floor(varianza /Double.valueOf(arrayValores.size()));
           

        } catch (Exception e) {
            e.printStackTrace();
        }

        return varianza;
    }
//---------------------------------------------------------------------------------

    
//---------------------------------------------------------------------------------
    public double desvioEstandarValores(int columnaTabla, int columnaTablaVarianza, int columnaTablaPromedioValores) {

        double desviacion = 0.0;

        try {

            //teniendo ya la varinza sólo debemos sacarle raiz cuadrada 
            //tendremos la desviación estandar
            desviacion = Math.sqrt(varianzaValores(columnaTablaVarianza, columnaTablaPromedioValores));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return desviacion;

    }
    //---------------------------------------------------------------------------------

    //---------------------------------------------------------------------------------
    public float desvioEstandarValoresSueldoDecimal(int columnaTabla, int columnaTablaVarianza, int columnaTablaPromedioValores) {

        float   desviacion = 0.0f;

        try {

            //teniendo ya la varinza sólo debemos sacarle raiz cuadrada 
            //tendremos la desviación estandar
            desviacion = (float)Math.sqrt(varianzaValoresSueldoDecimal(columnaTablaVarianza, columnaTablaPromedioValores));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return desviacion;

    }
    //---------------------------------------------------------------------------------


    //=============================================
    //==============FIN ANALYTICS==================
    //=============================================
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelHsSemanalesMinima = new javax.swing.JLabel();
        jTextFieldEdadMaxima = new javax.swing.JTextField();
        jLabelEdadMinima = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabelEdad = new javax.swing.JLabel();
        jLabelTituloCantHsSemanales = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        jSeparator13 = new javax.swing.JSeparator();
        jSeparator15 = new javax.swing.JSeparator();
        jSeparator16 = new javax.swing.JSeparator();
        jSeparator17 = new javax.swing.JSeparator();
        jSeparator18 = new javax.swing.JSeparator();
        jSeparator19 = new javax.swing.JSeparator();
        jSeparator20 = new javax.swing.JSeparator();
        jLabelSueldo = new javax.swing.JLabel();
        jSeparator21 = new javax.swing.JSeparator();
        jSeparator22 = new javax.swing.JSeparator();
        jSeparator24 = new javax.swing.JSeparator();
        jLabelHsSemanalesPromedio = new javax.swing.JLabel();
        jTextFieldSueldoPromedio = new javax.swing.JTextField();
        jLabelDesvioEdad2 = new javax.swing.JLabel();
        jTextFieldSueldoQueMasSeRepite = new javax.swing.JTextField();
        jTextFieldEdadMinima = new javax.swing.JTextField();
        jLabelCantidadHsSemanales = new javax.swing.JLabel();
        jTextFieldEdadesCantidad = new javax.swing.JTextField();
        jTextFieldFrecuenciaSueldoQueMasSeRepite = new javax.swing.JTextField();
        jLabelFrecuenciaEdadMasRepetido3 = new javax.swing.JLabel();
        jLabelVarianzaHsSemanales = new javax.swing.JLabel();
        jTextFieldVarianzaHsSemanales = new javax.swing.JTextField();
        jTextFieldDesvioEstandarSueldo = new javax.swing.JTextField();
        jLabelDesvioEstandar = new javax.swing.JLabel();
        jLabelEdadMasRepetido1 = new javax.swing.JLabel();
        jLabelEdadMasRepetido2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableListaEmpleados = new javax.swing.JTable();
        jButtonGraficaSueldo = new javax.swing.JButton();
        jLabelCantidadEdad = new javax.swing.JLabel();
        jTextFieldSueldoCantidad = new javax.swing.JTextField();
        jLabelEdadPromedio1 = new javax.swing.JLabel();
        jTextFieldEdadPromedio = new javax.swing.JTextField();
        jLabelEdadMaxima1 = new javax.swing.JLabel();
        jButtonGrafica = new javax.swing.JButton();
        jLabelHsSemanalesMaxima1 = new javax.swing.JLabel();
        jTextFieldHsSemanalesMinima = new javax.swing.JTextField();
        jTextFieldSueldoMaximo = new javax.swing.JTextField();
        jLabelVarianzaEdad1 = new javax.swing.JLabel();
        jTextFieldVarianzaEdad = new javax.swing.JTextField();
        jLabelDesvioEdad3 = new javax.swing.JLabel();
        jLabelDesvioEstandar1 = new javax.swing.JLabel();
        jTextFieldDesvioEstandarEdad = new javax.swing.JTextField();
        jLabelEdadMasRepetido3 = new javax.swing.JLabel();
        jLabelEdadMasRepetido4 = new javax.swing.JLabel();
        jLabelFrecuenciaEdadMasRepetido4 = new javax.swing.JLabel();
        jTextFieldEdadQueMasSeRepite = new javax.swing.JTextField();
        jTextFieldFrecuenciaEdadQueMasSeRepite = new javax.swing.JTextField();
        jSeparator25 = new javax.swing.JSeparator();
        jButtonGraficaHsSemanales = new javax.swing.JButton();
        jLabelCantidadHsSemanales1 = new javax.swing.JLabel();
        jLabelHsSemanalesPromedio1 = new javax.swing.JLabel();
        jTextFieldHsSemanalesCantidad = new javax.swing.JTextField();
        jTextFieldHsSemanalesPromedio = new javax.swing.JTextField();
        jLabelVarianzaHsSemanales1 = new javax.swing.JLabel();
        jTextFieldVarianzaSueldo = new javax.swing.JTextField();
        jLabelDesvioEstandar2 = new javax.swing.JLabel();
        jLabelDesvioEdad4 = new javax.swing.JLabel();
        jTextFieldDesvioEstandarHsSemanales = new javax.swing.JTextField();
        jLabelEdadMasRepetido5 = new javax.swing.JLabel();
        jLabelEdadMasRepetido6 = new javax.swing.JLabel();
        jTextFieldHsSemanalesQueMasSeRepite = new javax.swing.JTextField();
        jLabelFrecuenciaEdadMasRepetido5 = new javax.swing.JLabel();
        jTextFieldFrecuenciaHsSemanalesQueMasSeRepite = new javax.swing.JTextField();
        jLabelHsSemanalesMaxima2 = new javax.swing.JLabel();
        jLabelHsSemanalesMinima1 = new javax.swing.JLabel();
        jTextFieldHsSemanalesMaxima = new javax.swing.JTextField();
        jTextFieldSueldoMinimo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabelTitulo.setFont(new java.awt.Font("Arial Black", 1, 28)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setText("ANALYTICS-EMPLEADOS");

        jLabelHsSemanalesMinima.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelHsSemanalesMinima.setForeground(new java.awt.Color(255, 255, 255));
        jLabelHsSemanalesMinima.setText("Hora Mínima:");

        jTextFieldEdadMaxima.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTextFieldEdadMaxima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEdadMaximaActionPerformed(evt);
            }
        });
        jTextFieldEdadMaxima.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldEdadMaximaKeyTyped(evt);
            }
        });

        jLabelEdadMinima.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelEdadMinima.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEdadMinima.setText("Edad Mínima:");

        jLabelEdad.setFont(new java.awt.Font("Arial Black", 1, 20)); // NOI18N
        jLabelEdad.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEdad.setText("EDAD");

        jLabelTituloCantHsSemanales.setFont(new java.awt.Font("Arial Black", 1, 20)); // NOI18N
        jLabelTituloCantHsSemanales.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTituloCantHsSemanales.setText(" HORAS SEMANALES");

        jLabelSueldo.setFont(new java.awt.Font("Arial Black", 1, 20)); // NOI18N
        jLabelSueldo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSueldo.setText("SUELDO");

        jLabelHsSemanalesPromedio.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelHsSemanalesPromedio.setForeground(new java.awt.Color(255, 255, 255));
        jLabelHsSemanalesPromedio.setText("Sueldo Promedio (Media) :");

        jTextFieldSueldoPromedio.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTextFieldSueldoPromedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSueldoPromedioActionPerformed(evt);
            }
        });
        jTextFieldSueldoPromedio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldSueldoPromedioKeyTyped(evt);
            }
        });

        jLabelDesvioEdad2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelDesvioEdad2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDesvioEdad2.setText("Estandar:");

        jTextFieldSueldoQueMasSeRepite.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTextFieldSueldoQueMasSeRepite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSueldoQueMasSeRepiteActionPerformed(evt);
            }
        });
        jTextFieldSueldoQueMasSeRepite.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldSueldoQueMasSeRepiteKeyTyped(evt);
            }
        });

        jTextFieldEdadMinima.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTextFieldEdadMinima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEdadMinimaActionPerformed(evt);
            }
        });
        jTextFieldEdadMinima.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldEdadMinimaKeyTyped(evt);
            }
        });

        jLabelCantidadHsSemanales.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelCantidadHsSemanales.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCantidadHsSemanales.setText("Cantidad de Horas:");

        jTextFieldEdadesCantidad.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTextFieldEdadesCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEdadesCantidadActionPerformed(evt);
            }
        });
        jTextFieldEdadesCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldEdadesCantidadKeyTyped(evt);
            }
        });

        jTextFieldFrecuenciaSueldoQueMasSeRepite.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTextFieldFrecuenciaSueldoQueMasSeRepite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldFrecuenciaSueldoQueMasSeRepiteActionPerformed(evt);
            }
        });
        jTextFieldFrecuenciaSueldoQueMasSeRepite.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldFrecuenciaSueldoQueMasSeRepiteKeyTyped(evt);
            }
        });

        jLabelFrecuenciaEdadMasRepetido3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelFrecuenciaEdadMasRepetido3.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFrecuenciaEdadMasRepetido3.setText("Frecuencia de Moda:");

        jLabelVarianzaHsSemanales.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelVarianzaHsSemanales.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVarianzaHsSemanales.setText("Varianza:");

        jTextFieldVarianzaHsSemanales.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTextFieldVarianzaHsSemanales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldVarianzaHsSemanalesActionPerformed(evt);
            }
        });
        jTextFieldVarianzaHsSemanales.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldVarianzaHsSemanalesKeyTyped(evt);
            }
        });

        jTextFieldDesvioEstandarSueldo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTextFieldDesvioEstandarSueldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDesvioEstandarSueldoActionPerformed(evt);
            }
        });
        jTextFieldDesvioEstandarSueldo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldDesvioEstandarSueldoKeyTyped(evt);
            }
        });

        jLabelDesvioEstandar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelDesvioEstandar.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDesvioEstandar.setText("Desvio ");

        jLabelEdadMasRepetido1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelEdadMasRepetido1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEdadMasRepetido1.setText("Sueldo que más ");

        jLabelEdadMasRepetido2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelEdadMasRepetido2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEdadMasRepetido2.setText("se repite (MonoModa):");

        jTableListaEmpleados.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N
        jTableListaEmpleados.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTableListaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableListaEmpleados.setToolTipText("");
        jScrollPane1.setViewportView(jTableListaEmpleados);

        jButtonGraficaSueldo.setBackground(new java.awt.Color(0, 34, 103));
        jButtonGraficaSueldo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButtonGraficaSueldo.setForeground(new java.awt.Color(255, 255, 255));
        jButtonGraficaSueldo.setText("GRAFICA SUELDO");
        jButtonGraficaSueldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGraficaSueldoActionPerformed(evt);
            }
        });

        jLabelCantidadEdad.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelCantidadEdad.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCantidadEdad.setText("Cantidad de Edades:");

        jTextFieldSueldoCantidad.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTextFieldSueldoCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSueldoCantidadActionPerformed(evt);
            }
        });
        jTextFieldSueldoCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldSueldoCantidadKeyTyped(evt);
            }
        });

        jLabelEdadPromedio1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelEdadPromedio1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEdadPromedio1.setText("Edad Promedio (Media) :");

        jTextFieldEdadPromedio.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTextFieldEdadPromedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEdadPromedioActionPerformed(evt);
            }
        });
        jTextFieldEdadPromedio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldEdadPromedioKeyTyped(evt);
            }
        });

        jLabelEdadMaxima1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelEdadMaxima1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEdadMaxima1.setText("Edad Máxima:");

        jButtonGrafica.setBackground(new java.awt.Color(0, 34, 103));
        jButtonGrafica.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButtonGrafica.setForeground(new java.awt.Color(255, 255, 255));
        jButtonGrafica.setText("GRAFICA EDAD");
        jButtonGrafica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGraficaActionPerformed(evt);
            }
        });

        jLabelHsSemanalesMaxima1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelHsSemanalesMaxima1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelHsSemanalesMaxima1.setText("Sueldo Máximo:");

        jTextFieldHsSemanalesMinima.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTextFieldHsSemanalesMinima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldHsSemanalesMinimaActionPerformed(evt);
            }
        });
        jTextFieldHsSemanalesMinima.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldHsSemanalesMinimaKeyTyped(evt);
            }
        });

        jTextFieldSueldoMaximo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTextFieldSueldoMaximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSueldoMaximoActionPerformed(evt);
            }
        });
        jTextFieldSueldoMaximo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldSueldoMaximoKeyTyped(evt);
            }
        });

        jLabelVarianzaEdad1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelVarianzaEdad1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVarianzaEdad1.setText("Varianza:");

        jTextFieldVarianzaEdad.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTextFieldVarianzaEdad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldVarianzaEdadActionPerformed(evt);
            }
        });
        jTextFieldVarianzaEdad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldVarianzaEdadKeyTyped(evt);
            }
        });

        jLabelDesvioEdad3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelDesvioEdad3.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDesvioEdad3.setText("Estandar:");

        jLabelDesvioEstandar1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelDesvioEstandar1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDesvioEstandar1.setText("Desvio ");

        jTextFieldDesvioEstandarEdad.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTextFieldDesvioEstandarEdad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDesvioEstandarEdadActionPerformed(evt);
            }
        });
        jTextFieldDesvioEstandarEdad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldDesvioEstandarEdadKeyTyped(evt);
            }
        });

        jLabelEdadMasRepetido3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelEdadMasRepetido3.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEdadMasRepetido3.setText("Edad que más ");

        jLabelEdadMasRepetido4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelEdadMasRepetido4.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEdadMasRepetido4.setText("se repite (MonoModa):");

        jLabelFrecuenciaEdadMasRepetido4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelFrecuenciaEdadMasRepetido4.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFrecuenciaEdadMasRepetido4.setText("Frecuencia de Moda:");

        jTextFieldEdadQueMasSeRepite.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTextFieldEdadQueMasSeRepite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEdadQueMasSeRepiteActionPerformed(evt);
            }
        });
        jTextFieldEdadQueMasSeRepite.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldEdadQueMasSeRepiteKeyTyped(evt);
            }
        });

        jTextFieldFrecuenciaEdadQueMasSeRepite.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTextFieldFrecuenciaEdadQueMasSeRepite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldFrecuenciaEdadQueMasSeRepiteActionPerformed(evt);
            }
        });
        jTextFieldFrecuenciaEdadQueMasSeRepite.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldFrecuenciaEdadQueMasSeRepiteKeyTyped(evt);
            }
        });

        jButtonGraficaHsSemanales.setBackground(new java.awt.Color(0, 34, 103));
        jButtonGraficaHsSemanales.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButtonGraficaHsSemanales.setForeground(new java.awt.Color(255, 255, 255));
        jButtonGraficaHsSemanales.setText("GRAFICA HS SEMANALES");
        jButtonGraficaHsSemanales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGraficaHsSemanalesActionPerformed(evt);
            }
        });

        jLabelCantidadHsSemanales1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelCantidadHsSemanales1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCantidadHsSemanales1.setText("Cantidad de Sueldos:");

        jLabelHsSemanalesPromedio1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelHsSemanalesPromedio1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelHsSemanalesPromedio1.setText("Horas Promedio (Media) :");

        jTextFieldHsSemanalesCantidad.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTextFieldHsSemanalesCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldHsSemanalesCantidadActionPerformed(evt);
            }
        });
        jTextFieldHsSemanalesCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldHsSemanalesCantidadKeyTyped(evt);
            }
        });

        jTextFieldHsSemanalesPromedio.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTextFieldHsSemanalesPromedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldHsSemanalesPromedioActionPerformed(evt);
            }
        });
        jTextFieldHsSemanalesPromedio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldHsSemanalesPromedioKeyTyped(evt);
            }
        });

        jLabelVarianzaHsSemanales1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelVarianzaHsSemanales1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVarianzaHsSemanales1.setText("Varianza:");

        jTextFieldVarianzaSueldo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTextFieldVarianzaSueldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldVarianzaSueldoActionPerformed(evt);
            }
        });
        jTextFieldVarianzaSueldo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldVarianzaSueldoKeyTyped(evt);
            }
        });

        jLabelDesvioEstandar2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelDesvioEstandar2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDesvioEstandar2.setText("Desvio ");

        jLabelDesvioEdad4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelDesvioEdad4.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDesvioEdad4.setText("Estandar:");

        jTextFieldDesvioEstandarHsSemanales.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTextFieldDesvioEstandarHsSemanales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDesvioEstandarHsSemanalesActionPerformed(evt);
            }
        });
        jTextFieldDesvioEstandarHsSemanales.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldDesvioEstandarHsSemanalesKeyTyped(evt);
            }
        });

        jLabelEdadMasRepetido5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelEdadMasRepetido5.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEdadMasRepetido5.setText("Hora que más ");

        jLabelEdadMasRepetido6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelEdadMasRepetido6.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEdadMasRepetido6.setText("se repite (MonoModa):");

        jTextFieldHsSemanalesQueMasSeRepite.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTextFieldHsSemanalesQueMasSeRepite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldHsSemanalesQueMasSeRepiteActionPerformed(evt);
            }
        });
        jTextFieldHsSemanalesQueMasSeRepite.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldHsSemanalesQueMasSeRepiteKeyTyped(evt);
            }
        });

        jLabelFrecuenciaEdadMasRepetido5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelFrecuenciaEdadMasRepetido5.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFrecuenciaEdadMasRepetido5.setText("Frecuencia de Moda:");

        jTextFieldFrecuenciaHsSemanalesQueMasSeRepite.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTextFieldFrecuenciaHsSemanalesQueMasSeRepite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldFrecuenciaHsSemanalesQueMasSeRepiteActionPerformed(evt);
            }
        });
        jTextFieldFrecuenciaHsSemanalesQueMasSeRepite.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldFrecuenciaHsSemanalesQueMasSeRepiteKeyTyped(evt);
            }
        });

        jLabelHsSemanalesMaxima2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelHsSemanalesMaxima2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelHsSemanalesMaxima2.setText("Hora Máxima:");

        jLabelHsSemanalesMinima1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelHsSemanalesMinima1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelHsSemanalesMinima1.setText("Sueldo Mínimo:");

        jTextFieldHsSemanalesMaxima.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTextFieldHsSemanalesMaxima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldHsSemanalesMaximaActionPerformed(evt);
            }
        });
        jTextFieldHsSemanalesMaxima.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldHsSemanalesMaximaKeyTyped(evt);
            }
        });

        jTextFieldSueldoMinimo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTextFieldSueldoMinimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSueldoMinimoActionPerformed(evt);
            }
        });
        jTextFieldSueldoMinimo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldSueldoMinimoKeyTyped(evt);
            }
        });

        jDesktopPane1.setLayer(jLabelTitulo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabelHsSemanalesMinima, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jTextFieldEdadMaxima, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabelEdadMinima, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jSeparator2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabelEdad, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabelTituloCantHsSemanales, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jSeparator3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jSeparator4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jSeparator5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jSeparator6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jSeparator1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jSeparator7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jSeparator10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jSeparator11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jSeparator12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jSeparator13, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jSeparator15, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jSeparator16, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jSeparator17, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jSeparator18, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jSeparator19, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jSeparator20, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabelSueldo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jSeparator21, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jSeparator22, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jSeparator24, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabelHsSemanalesPromedio, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jTextFieldSueldoPromedio, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabelDesvioEdad2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jTextFieldSueldoQueMasSeRepite, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jTextFieldEdadMinima, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabelCantidadHsSemanales, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jTextFieldEdadesCantidad, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jTextFieldFrecuenciaSueldoQueMasSeRepite, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabelFrecuenciaEdadMasRepetido3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabelVarianzaHsSemanales, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jTextFieldVarianzaHsSemanales, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jTextFieldDesvioEstandarSueldo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabelDesvioEstandar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabelEdadMasRepetido1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabelEdadMasRepetido2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButtonGraficaSueldo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabelCantidadEdad, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jTextFieldSueldoCantidad, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabelEdadPromedio1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jTextFieldEdadPromedio, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabelEdadMaxima1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButtonGrafica, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabelHsSemanalesMaxima1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jTextFieldHsSemanalesMinima, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jTextFieldSueldoMaximo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabelVarianzaEdad1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jTextFieldVarianzaEdad, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabelDesvioEdad3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabelDesvioEstandar1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jTextFieldDesvioEstandarEdad, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabelEdadMasRepetido3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabelEdadMasRepetido4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabelFrecuenciaEdadMasRepetido4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jTextFieldEdadQueMasSeRepite, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jTextFieldFrecuenciaEdadQueMasSeRepite, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jSeparator25, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButtonGraficaHsSemanales, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabelCantidadHsSemanales1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabelHsSemanalesPromedio1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jTextFieldHsSemanalesCantidad, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jTextFieldHsSemanalesPromedio, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabelVarianzaHsSemanales1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jTextFieldVarianzaSueldo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabelDesvioEstandar2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabelDesvioEdad4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jTextFieldDesvioEstandarHsSemanales, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabelEdadMasRepetido5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabelEdadMasRepetido6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jTextFieldHsSemanalesQueMasSeRepite, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabelFrecuenciaEdadMasRepetido5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jTextFieldFrecuenciaHsSemanalesQueMasSeRepite, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabelHsSemanalesMaxima2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabelHsSemanalesMinima1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jTextFieldHsSemanalesMaxima, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jTextFieldSueldoMinimo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabelTitulo)))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator15, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(320, 320, 320)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(jLabelEdad))))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabelCantidadEdad)
                        .addGap(132, 132, 132)
                        .addComponent(jLabelEdadMaxima1)
                        .addGap(119, 119, 119)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(190, 190, 190)
                                .addComponent(jTextFieldEdadQueMasSeRepite, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabelEdadMasRepetido4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelEdadPromedio1)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(210, 210, 210)
                                .addComponent(jTextFieldEdadPromedio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(150, 150, 150)
                        .addComponent(jTextFieldEdadMinima, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jLabelFrecuenciaEdadMasRepetido4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jTextFieldFrecuenciaEdadQueMasSeRepite, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(jTextFieldVarianzaEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabelVarianzaEdad1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(80, 80, 80)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabelDesvioEstandar1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabelDesvioEdad2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jTextFieldDesvioEstandarEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(360, 360, 360)
                        .addComponent(jButtonGrafica, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jSeparator16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(jSeparator18, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(200, 200, 200)
                                .addComponent(jLabelTituloCantHsSemanales, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jSeparator17, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))))
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(jTextFieldEdadesCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(480, 480, 480)
                .addComponent(jTextFieldEdadMaxima, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(360, 360, 360)
                .addComponent(jLabelEdadMinima, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(640, 640, 640)
                .addComponent(jLabelEdadMasRepetido3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(290, 290, 290)
                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabelCantidadHsSemanales)
                .addGap(5, 5, 5)
                .addComponent(jTextFieldHsSemanalesCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabelHsSemanalesMaxima2)
                .addGap(2, 2, 2)
                .addComponent(jTextFieldHsSemanalesMaxima, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelEdadMasRepetido6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(jTextFieldHsSemanalesQueMasSeRepite, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabelEdadMasRepetido5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabelHsSemanalesPromedio1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jTextFieldHsSemanalesPromedio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabelHsSemanalesMinima)
                .addGap(6, 6, 6)
                .addComponent(jTextFieldHsSemanalesMinima, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jLabelFrecuenciaEdadMasRepetido5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jTextFieldFrecuenciaHsSemanalesQueMasSeRepite, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jTextFieldVarianzaHsSemanales, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelVarianzaHsSemanales1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabelDesvioEstandar2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelDesvioEdad4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jTextFieldDesvioEstandarHsSemanales, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(340, 340, 340)
                .addComponent(jButtonGraficaHsSemanales, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jSeparator19, javax.swing.GroupLayout.PREFERRED_SIZE, 930, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jSeparator21, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jSeparator22, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(jSeparator20, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(jTextFieldSueldoCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(jLabelSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabelHsSemanalesMaxima1))
                        .addGap(80, 80, 80)
                        .addComponent(jLabelEdadMasRepetido2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(290, 290, 290)
                        .addComponent(jSeparator24, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(590, 590, 590)
                        .addComponent(jLabelEdadMasRepetido1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(440, 440, 440)
                        .addComponent(jTextFieldSueldoMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(750, 750, 750)
                        .addComponent(jTextFieldSueldoQueMasSeRepite, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelCantidadHsSemanales1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(jSeparator25, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(jLabelHsSemanalesPromedio, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jTextFieldSueldoPromedio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabelHsSemanalesMinima1)
                .addGap(6, 6, 6)
                .addComponent(jTextFieldSueldoMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jLabelFrecuenciaEdadMasRepetido3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jTextFieldFrecuenciaSueldoQueMasSeRepite, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jTextFieldVarianzaSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelVarianzaHsSemanales, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(100, 100, 100)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jTextFieldDesvioEstandarSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelDesvioEdad3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabelDesvioEstandar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(340, 340, 340)
                .addComponent(jButtonGraficaSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabelTitulo))
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator15, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabelEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelEdadMaxima1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelCantidadEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldEdadQueMasSeRepite, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelEdadMasRepetido4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelEdadPromedio1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldEdadPromedio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldEdadMinima, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelFrecuenciaEdadMasRepetido4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldFrecuenciaEdadQueMasSeRepite, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDesvioEstandar1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldVarianzaEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelVarianzaEdad1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelDesvioEdad2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldDesvioEstandarEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(20, 20, 20)
                        .addComponent(jButtonGrafica, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jSeparator16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jSeparator18, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabelTituloCantHsSemanales, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jSeparator17, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jTextFieldEdadesCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(364, 364, 364)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jTextFieldEdadMaxima, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(jLabelEdadMinima, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(jLabelEdadMasRepetido3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(384, 384, 384)
                        .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabelCantidadHsSemanales, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jTextFieldHsSemanalesCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabelHsSemanalesMaxima2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jTextFieldHsSemanalesMaxima, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabelEdadMasRepetido6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jTextFieldHsSemanalesQueMasSeRepite, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelEdadMasRepetido5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelHsSemanalesPromedio1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldHsSemanalesPromedio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelHsSemanalesMinima, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldHsSemanalesMinima, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelFrecuenciaEdadMasRepetido5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldFrecuenciaHsSemanalesQueMasSeRepite, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDesvioEstandar2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldVarianzaHsSemanales, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelVarianzaHsSemanales1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDesvioEdad4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldDesvioEstandarHsSemanales, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20)
                .addComponent(jButtonGraficaHsSemanales, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator19, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator21, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator22, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addComponent(jSeparator20, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jTextFieldSueldoCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jLabelSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabelHsSemanalesMaxima1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabelEdadMasRepetido2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator24, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabelEdadMasRepetido1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jTextFieldSueldoMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jTextFieldSueldoQueMasSeRepite, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabelCantidadHsSemanales1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jSeparator25, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelHsSemanalesPromedio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldSueldoPromedio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelHsSemanalesMinima1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldSueldoMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelFrecuenciaEdadMasRepetido3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldFrecuenciaSueldoQueMasSeRepite, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDesvioEstandar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldVarianzaSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelVarianzaHsSemanales, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldDesvioEstandarSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDesvioEdad3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20)
                .addComponent(jButtonGraficaSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldEdadMaximaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEdadMaximaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEdadMaximaActionPerformed

    private void jTextFieldEdadMaximaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldEdadMaximaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEdadMaximaKeyTyped

    private void jTextFieldSueldoPromedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSueldoPromedioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSueldoPromedioActionPerformed

    private void jTextFieldSueldoPromedioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSueldoPromedioKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSueldoPromedioKeyTyped

    private void jTextFieldSueldoQueMasSeRepiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSueldoQueMasSeRepiteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSueldoQueMasSeRepiteActionPerformed

    private void jTextFieldSueldoQueMasSeRepiteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSueldoQueMasSeRepiteKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSueldoQueMasSeRepiteKeyTyped

    private void jTextFieldEdadMinimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEdadMinimaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEdadMinimaActionPerformed

    private void jTextFieldEdadMinimaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldEdadMinimaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEdadMinimaKeyTyped

    private void jTextFieldEdadesCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEdadesCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEdadesCantidadActionPerformed

    private void jTextFieldEdadesCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldEdadesCantidadKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEdadesCantidadKeyTyped

    private void jTextFieldFrecuenciaSueldoQueMasSeRepiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFrecuenciaSueldoQueMasSeRepiteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFrecuenciaSueldoQueMasSeRepiteActionPerformed

    private void jTextFieldFrecuenciaSueldoQueMasSeRepiteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldFrecuenciaSueldoQueMasSeRepiteKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFrecuenciaSueldoQueMasSeRepiteKeyTyped

    private void jTextFieldVarianzaHsSemanalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldVarianzaHsSemanalesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldVarianzaHsSemanalesActionPerformed

    private void jTextFieldVarianzaHsSemanalesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldVarianzaHsSemanalesKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldVarianzaHsSemanalesKeyTyped

    private void jTextFieldDesvioEstandarSueldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDesvioEstandarSueldoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDesvioEstandarSueldoActionPerformed

    private void jTextFieldDesvioEstandarSueldoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDesvioEstandarSueldoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDesvioEstandarSueldoKeyTyped

    private void jButtonGraficaSueldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGraficaSueldoActionPerformed
        graficarGraficoSueldo();
    }//GEN-LAST:event_jButtonGraficaSueldoActionPerformed

    private void jTextFieldSueldoCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSueldoCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSueldoCantidadActionPerformed

    private void jTextFieldSueldoCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSueldoCantidadKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSueldoCantidadKeyTyped

    private void jTextFieldEdadPromedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEdadPromedioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEdadPromedioActionPerformed

    private void jTextFieldEdadPromedioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldEdadPromedioKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEdadPromedioKeyTyped

    private void jButtonGraficaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGraficaActionPerformed
        graficarGraficoEdad();
    }//GEN-LAST:event_jButtonGraficaActionPerformed

    private void jTextFieldHsSemanalesMinimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldHsSemanalesMinimaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldHsSemanalesMinimaActionPerformed

    private void jTextFieldHsSemanalesMinimaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldHsSemanalesMinimaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldHsSemanalesMinimaKeyTyped

    private void jTextFieldSueldoMaximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSueldoMaximoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSueldoMaximoActionPerformed

    private void jTextFieldSueldoMaximoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSueldoMaximoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSueldoMaximoKeyTyped

    private void jTextFieldVarianzaEdadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldVarianzaEdadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldVarianzaEdadActionPerformed

    private void jTextFieldVarianzaEdadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldVarianzaEdadKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldVarianzaEdadKeyTyped

    private void jTextFieldDesvioEstandarEdadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDesvioEstandarEdadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDesvioEstandarEdadActionPerformed

    private void jTextFieldDesvioEstandarEdadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDesvioEstandarEdadKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDesvioEstandarEdadKeyTyped

    private void jTextFieldEdadQueMasSeRepiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEdadQueMasSeRepiteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEdadQueMasSeRepiteActionPerformed

    private void jTextFieldEdadQueMasSeRepiteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldEdadQueMasSeRepiteKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEdadQueMasSeRepiteKeyTyped

    private void jTextFieldFrecuenciaEdadQueMasSeRepiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFrecuenciaEdadQueMasSeRepiteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFrecuenciaEdadQueMasSeRepiteActionPerformed

    private void jTextFieldFrecuenciaEdadQueMasSeRepiteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldFrecuenciaEdadQueMasSeRepiteKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFrecuenciaEdadQueMasSeRepiteKeyTyped

    private void jButtonGraficaHsSemanalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGraficaHsSemanalesActionPerformed
        graficarGraficoHsSemanales();
    }//GEN-LAST:event_jButtonGraficaHsSemanalesActionPerformed

    private void jTextFieldHsSemanalesCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldHsSemanalesCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldHsSemanalesCantidadActionPerformed

    private void jTextFieldHsSemanalesCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldHsSemanalesCantidadKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldHsSemanalesCantidadKeyTyped

    private void jTextFieldHsSemanalesPromedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldHsSemanalesPromedioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldHsSemanalesPromedioActionPerformed

    private void jTextFieldHsSemanalesPromedioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldHsSemanalesPromedioKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldHsSemanalesPromedioKeyTyped

    private void jTextFieldVarianzaSueldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldVarianzaSueldoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldVarianzaSueldoActionPerformed

    private void jTextFieldVarianzaSueldoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldVarianzaSueldoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldVarianzaSueldoKeyTyped

    private void jTextFieldDesvioEstandarHsSemanalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDesvioEstandarHsSemanalesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDesvioEstandarHsSemanalesActionPerformed

    private void jTextFieldDesvioEstandarHsSemanalesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDesvioEstandarHsSemanalesKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDesvioEstandarHsSemanalesKeyTyped

    private void jTextFieldHsSemanalesQueMasSeRepiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldHsSemanalesQueMasSeRepiteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldHsSemanalesQueMasSeRepiteActionPerformed

    private void jTextFieldHsSemanalesQueMasSeRepiteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldHsSemanalesQueMasSeRepiteKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldHsSemanalesQueMasSeRepiteKeyTyped

    private void jTextFieldFrecuenciaHsSemanalesQueMasSeRepiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFrecuenciaHsSemanalesQueMasSeRepiteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFrecuenciaHsSemanalesQueMasSeRepiteActionPerformed

    private void jTextFieldFrecuenciaHsSemanalesQueMasSeRepiteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldFrecuenciaHsSemanalesQueMasSeRepiteKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFrecuenciaHsSemanalesQueMasSeRepiteKeyTyped

    private void jTextFieldHsSemanalesMaximaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldHsSemanalesMaximaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldHsSemanalesMaximaActionPerformed

    private void jTextFieldHsSemanalesMaximaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldHsSemanalesMaximaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldHsSemanalesMaximaKeyTyped

    private void jTextFieldSueldoMinimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSueldoMinimoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSueldoMinimoActionPerformed

    private void jTextFieldSueldoMinimoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSueldoMinimoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSueldoMinimoKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrameAnalyticsEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameAnalyticsEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameAnalyticsEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameAnalyticsEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameAnalyticsEmpleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonGrafica;
    private javax.swing.JButton jButtonGraficaHsSemanales;
    private javax.swing.JButton jButtonGraficaSueldo;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabelCantidadEdad;
    private javax.swing.JLabel jLabelCantidadHsSemanales;
    private javax.swing.JLabel jLabelCantidadHsSemanales1;
    private javax.swing.JLabel jLabelDesvioEdad2;
    private javax.swing.JLabel jLabelDesvioEdad3;
    private javax.swing.JLabel jLabelDesvioEdad4;
    private javax.swing.JLabel jLabelDesvioEstandar;
    private javax.swing.JLabel jLabelDesvioEstandar1;
    private javax.swing.JLabel jLabelDesvioEstandar2;
    private javax.swing.JLabel jLabelEdad;
    private javax.swing.JLabel jLabelEdadMasRepetido1;
    private javax.swing.JLabel jLabelEdadMasRepetido2;
    private javax.swing.JLabel jLabelEdadMasRepetido3;
    private javax.swing.JLabel jLabelEdadMasRepetido4;
    private javax.swing.JLabel jLabelEdadMasRepetido5;
    private javax.swing.JLabel jLabelEdadMasRepetido6;
    private javax.swing.JLabel jLabelEdadMaxima1;
    private javax.swing.JLabel jLabelEdadMinima;
    private javax.swing.JLabel jLabelEdadPromedio1;
    private javax.swing.JLabel jLabelFrecuenciaEdadMasRepetido3;
    private javax.swing.JLabel jLabelFrecuenciaEdadMasRepetido4;
    private javax.swing.JLabel jLabelFrecuenciaEdadMasRepetido5;
    private javax.swing.JLabel jLabelHsSemanalesMaxima1;
    private javax.swing.JLabel jLabelHsSemanalesMaxima2;
    private javax.swing.JLabel jLabelHsSemanalesMinima;
    private javax.swing.JLabel jLabelHsSemanalesMinima1;
    private javax.swing.JLabel jLabelHsSemanalesPromedio;
    private javax.swing.JLabel jLabelHsSemanalesPromedio1;
    private javax.swing.JLabel jLabelSueldo;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelTituloCantHsSemanales;
    private javax.swing.JLabel jLabelVarianzaEdad1;
    private javax.swing.JLabel jLabelVarianzaHsSemanales;
    private javax.swing.JLabel jLabelVarianzaHsSemanales1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator20;
    private javax.swing.JSeparator jSeparator21;
    private javax.swing.JSeparator jSeparator22;
    private javax.swing.JSeparator jSeparator24;
    private javax.swing.JSeparator jSeparator25;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JTable jTableListaEmpleados;
    public static javax.swing.JTextField jTextFieldDesvioEstandarEdad;
    public static javax.swing.JTextField jTextFieldDesvioEstandarHsSemanales;
    public static javax.swing.JTextField jTextFieldDesvioEstandarSueldo;
    public static javax.swing.JTextField jTextFieldEdadMaxima;
    public static javax.swing.JTextField jTextFieldEdadMinima;
    public static javax.swing.JTextField jTextFieldEdadPromedio;
    public static javax.swing.JTextField jTextFieldEdadQueMasSeRepite;
    public static javax.swing.JTextField jTextFieldEdadesCantidad;
    public static javax.swing.JTextField jTextFieldFrecuenciaEdadQueMasSeRepite;
    public static javax.swing.JTextField jTextFieldFrecuenciaHsSemanalesQueMasSeRepite;
    public static javax.swing.JTextField jTextFieldFrecuenciaSueldoQueMasSeRepite;
    public static javax.swing.JTextField jTextFieldHsSemanalesCantidad;
    public static javax.swing.JTextField jTextFieldHsSemanalesMaxima;
    public static javax.swing.JTextField jTextFieldHsSemanalesMinima;
    public static javax.swing.JTextField jTextFieldHsSemanalesPromedio;
    public static javax.swing.JTextField jTextFieldHsSemanalesQueMasSeRepite;
    public static javax.swing.JTextField jTextFieldSueldoCantidad;
    public static javax.swing.JTextField jTextFieldSueldoMaximo;
    public static javax.swing.JTextField jTextFieldSueldoMinimo;
    public static javax.swing.JTextField jTextFieldSueldoPromedio;
    public static javax.swing.JTextField jTextFieldSueldoQueMasSeRepite;
    public static javax.swing.JTextField jTextFieldVarianzaEdad;
    public static javax.swing.JTextField jTextFieldVarianzaHsSemanales;
    public static javax.swing.JTextField jTextFieldVarianzaSueldo;
    // End of variables declaration//GEN-END:variables
}
