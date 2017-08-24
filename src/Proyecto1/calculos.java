/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.StringTokenizer;
import javax.swing.JTable;

/**
 *
 * @author Loscordonhdez
 */
public class calculos {

    public String funciones(String funcion, String linea, int tipo, Object[][] datos, JTable tabla) {
        String celda = "";
        try {
            switch (tipo) {
                case 0:
                    int d = 0;
                    String columna = String.valueOf(linea.charAt(0));
                    int col1 = numerodecolumna(columna);
                    if (col1 != -1) {
                        StringTokenizer st = new StringTokenizer(linea, columna);
                        while (st.hasMoreTokens()) {
                            d = Integer.parseInt(st.nextToken());
                        }
                        int[] arrayfibonacci = new int[Integer.parseInt(tabla.getModel().getValueAt(d - 1, col1).toString()) + 1];
                        for (int i = 0; i <= Integer.parseInt(tabla.getModel().getValueAt(d - 1, col1).toString()); i++) {
                            celda = String.valueOf(fibonacci(i, arrayfibonacci));
                        }
                    } else {
                        celda = "¡ERROR!";
                    }
                    break;
                case 1:
                    int c = 0;
                    int nc[] = new int[2];
                    int nf[] = new int[2];
                    columna = String.valueOf(linea.charAt(0));
                    col1 = numerodecolumna(columna);
                    StringTokenizer st = new StringTokenizer(linea, ":");
                    while (st.hasMoreTokens()) {
                        String lineasecundaria = st.nextToken();
                        System.out.println(lineasecundaria);
                        StringTokenizer stt = new StringTokenizer(lineasecundaria, String.valueOf(lineasecundaria.charAt(0)));
                        nf[c] = Integer.parseInt(stt.nextToken());
                        nc[c] = numerodecolumna(String.valueOf(lineasecundaria.charAt(0)));
                        c++;
                    }
                    Arrays.sort(nf);
                    Arrays.sort(nc);
                    int tamaño=(1 - nc[0] + nc[1]) * (1 - nf[0] + nf[1]);
                    Double numero[] = new Double[tamaño];
                    int ccc = 0;
                    for (int i = nc[0]; i <= nc[1]; i++) {
                        for (int j = nf[0]; j <= nf[1]; j++) {
                            if (String.valueOf(datos[j - 1][i]) != "null") {
                                numero[ccc] = Double.parseDouble(tabla.getModel().getValueAt(j - 1, i).toString());
                            }
                            ccc++;
                        }
                    }
                    if (col1 != -1) {if (funcion.equals("MCM")) {
                            int numer[] = new int[(1 - nc[0] + nc[1]) * (1 - nf[0] + nf[1])];
                            ccc = 0;
                            for (int i = nc[0]; i <= nc[1]; i++) {
                                for (int j = nf[0]; j <= nf[1]; j++) {
                                    if (String.valueOf(datos[j - 1][i]) != "null") {
                                        numer[ccc] = Integer.parseInt(tabla.getModel().getValueAt(j - 1, i).toString());
                                    }
                                    ccc++;
                                }
                            }
                            Arrays.sort(numer);
                            int mcm = 1;
                            int numx = 1;
                            int min = numer[numer.length-1];
                            int varc = 0;
                            int suma = 0;
                            System.out.println("tamaño"+numer.length);
                            for (int i = 0; i < numer.length; i++) {
                                System.out.println(numer[i]);
                                numx *= (numer[i]);
                            }
                            System.out.println("multi"+numx);
                            do{
                            for (int i = 2; i <= min; i++) {
                                varc = 0;
                                for (int j = 0; j < numer.length; j++) {
                                    if (numer[j] % i == 0) {
                                        varc++;
                                        numer[j]=(numer[j]/i);
                                    }
                                }
                                if (varc!=0) {
                                    int mcd = i;
                                    // Se calcula el mínimo común múltiplo
                                    //mcm = (numx) / mcd;
                                    mcm*=mcd;
                                    System.out.println(mcm);
                                    i=min+1;
                                }
                            }
                            suma = 0;
                            for (int i = 0; i < numer.length; i++) {
                                suma += (numer[i]);
                                System.out.println(suma+"=="+numer.length);
                            }
                            }while(suma!=numer.length);
                            //mcm = (numx) / mcm;
                            celda = String.valueOf(mcm);

                        } else {
                        celda=calculo(numero,funcion,tamaño);
                    }
                    } else {
                        celda = "¡ERROR!";
                    }

                    break;
                case 2:
                    System.out.println("2");
                    c = 0;
                    int tamaño1=1;
                    columna = String.valueOf(linea.charAt(0));
                    col1 = numerodecolumna(columna);
                    for (int i = 0; i < linea.length(); i++) {
                                    if (String.valueOf(linea.charAt(i)).equals(",")) {
                                        tamaño1++;
                                    }
                                }
                    System.out.println(tamaño1);
                    int nc1[] = new int[tamaño1];
                    int nf1[] = new int[tamaño1];
                    StringTokenizer st1 = new StringTokenizer(linea, ",");
                    while (st1.hasMoreTokens()) {
                        String lineasecundaria = st1.nextToken();
                        System.out.println(lineasecundaria);
                        StringTokenizer stt = new StringTokenizer(lineasecundaria, String.valueOf(lineasecundaria.charAt(0)));
                        nf1[c] = Integer.parseInt(stt.nextToken());
                        nc1[c] = numerodecolumna(String.valueOf(lineasecundaria.charAt(0)));
                        c++;
                    }
                    Arrays.sort(nf1);
                    Arrays.sort(nc1);
                    Double numero1[] = new Double[tamaño1];
                    int ccc1 = 0;
                    for (int i = nc1[0]; i <= nc1[nc1.length-1]; i++) {
                        for (int j = nf1[0]; j <= nf1[nf1.length-1]; j++) {
                            if (String.valueOf(datos[j - 1][i]) != "null") {
                                numero1[ccc1] = Double.parseDouble(tabla.getModel().getValueAt(j - 1, i).toString());
                                System.out.println(numero1[ccc1]);
                            }
                            ccc1++;
                        }
                    }
                    if (col1 != -1) {
                        if (funcion.equals("MCM")) {
                            int numer[] = new int[tamaño1];
                            ccc = 0;
                             for (int i = nc1[0]; i <= nc1[nc1.length-1]; i++) {
                        for (int j = nf1[0]; j <= nf1[nf1.length-1]; j++) {
                                    if (String.valueOf(datos[j - 1][i]) != "null") {
                                        numer[ccc] = Integer.parseInt(tabla.getModel().getValueAt(j - 1, i).toString());
                                    }
                                    ccc++;
                                }
                            }
                            Arrays.sort(numer);
                            int mcm = 1;
                            int numx = 1;
                            int min = numer[numer.length-1];
                            int varc = 0;
                            int suma = 0;
                            System.out.println("tamaño"+numer.length);
                            for (int i = 0; i < numer.length; i++) {
                                System.out.println(numer[i]);
                                numx *= (numer[i]);
                            }
                            System.out.println("multi"+numx);
                            do{
                            for (int i = 2; i <= min; i++) {
                                varc = 0;
                                for (int j = 0; j < numer.length; j++) {
                                    if (numer[j] % i == 0) {
                                        varc++;
                                        numer[j]=(numer[j]/i);
                                    }
                                }
                                if (varc!=0) {
                                    int mcd = i;
                                    // Se calcula el mínimo común múltiplo
                                    //mcm = (numx) / mcd;
                                    mcm*=mcd;
                                    System.out.println(mcm);
                                    i=min+1;
                                }
                            }
                            suma = 0;
                            for (int i = 0; i < numer.length; i++) {
                                suma += (numer[i]);
                                System.out.println(suma+"=="+numer.length);
                            }
                            }while(suma!=numer.length);
                            //mcm = (numx) / mcm;
                            celda = String.valueOf(mcm);

                        } else {
                        celda=calculo(numero1,funcion,tamaño1);
                    }
                    } else {
                        celda = "¡ERROR!";
                    }

                    break;
            }
        } catch (Exception e) {
            celda = "¡ERROR!";
            System.out.println(e);
        }
        return celda;
    }

    private int numerodecolumna(String col) {
        String columna[] = {" ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        int n = -1;
        for (int i = 0; i < columna.length; i++) {
            if (columna[i].equals(col)) {
                n = i;
            }
        }
        return n;
    }

    private int fibonacci(int n, int[] result) {
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

    private String calculo(Double[] numero, String funcion, int tamaño) {
    String celda="";
        try {
            
                        if (funcion.equals("MAX")) {
                            Arrays.sort(numero);
                            celda = String.valueOf(numero[numero.length - 1]);
                        } else if (funcion.equals("MIN")) {
                            Arrays.sort(numero);
                            celda = String.valueOf(numero[0]);
                        } else if (funcion.equals("DESVES")) {
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
                        } else if (funcion.equals("SUMA")) {
                            double suma = 0;
                            for (int i = 0; i < numero.length; i++) {
                                suma += (numero[i]);
                            }
                            celda = String.valueOf(suma);
                        } else if (funcion.equals("MOD")) {
                            celda = String.valueOf(numero[0] % numero[1]);
                        } else if (funcion.equals("MEDIA")) {
                            double media = 0;
                            for (int i = 0; i < numero.length; i++) {
                                media += (numero[i]);
                            }
                            media = media / numero.length;
                            celda = String.valueOf(media);
                        } else if (funcion.equals("MODA")) {
                            System.out.println(tamaño+";");
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
                            } else {
                                celda = "¡ERROR!";
                            }
                        }
                    
        } catch (Exception e) {
            celda = "¡ERROR!";
        }
    return celda;
    }

}
