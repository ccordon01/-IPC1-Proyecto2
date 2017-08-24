package Proyecto1;

import de.javasoft.plaf.synthetica.SyntheticaBlueSteelLookAndFeel;
import java.awt.*;
import java.awt.SplashScreen;
import java.text.ParseException;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public final class ScreenSplash {

    final SplashScreen splash;
    //texto que se muestra a medida que se va cargando el screensplah
    final String[] texto = {"Configuracion de Inicio", "Configuracion de Inicio.", "Configuracion de Inicio..", "Configuracion de Inicio...",
        "Celdas", "Celdas.", "Celdas..", "Celdas...", "Matriz de Datos", "Matriz de Datos.", "Matriz de Datos..", "Matriz de Datos...",
        "Funciones", "Funciones.", "Funciones..", "Funciones..."};

    public ScreenSplash() {
        splash = SplashScreen.getSplashScreen();
    }

    public void animar() {
        try {
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
            UIManager.setLookAndFeel(new SyntheticaBlueSteelLookAndFeel());
        } catch (ParseException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        Pruebatablas211 obj = new Pruebatablas211();
        if (splash != null) {
            Graphics2D g = splash.createGraphics();
            for (int i = 1; i < texto.length; i++) {
                //se pinta texto del array
                //g.setColor( new Color(4,52,101));//color de fondo

                g.setComposite(AlphaComposite.Clear);
                g.fillRect(20, 255, 280, 12);
                g.setPaintMode();//para tapar texto anterior
                g.setColor(new Color(199, 241, 217));//color de texto
                g.setFont(new Font("Arial", Font.BOLD, 12));
                g.drawString("Cargando " + texto[i - 1], 20, 265);
                //g.setColor(Color.WHITE);//color de barra de progeso
                //g.fillRect(204, 263,(i*307/texto.length), 12);//la barra de progreso
                //se pinta una linea segmentada encima de la barra verde
                //float dash1[] = {2.0f};
                //BasicStroke dashed = new BasicStroke(9.0f,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,5.0f, dash1, 0.0f);
                //g.setStroke(dashed);
                //g.setColor(Color.WHITE);//color de barra de progeso
                // g.setColor( new Color(4,52,101));
                //g.drawLine(205,269, 510, 269);                
                //se actualiza todo
                splash.update();
                try {
                    Thread.sleep(350);
                } catch (InterruptedException e) {
                }
            }
            splash.close();
        }
        //una vez terminada la animación se muestra la aplicación principal
        try {
            obj.setLocationRelativeTo(null);
            obj.setVisible(true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
