/*
 * Created by JFormDesigner on Sun Nov 17 22:54:22 CST 2019
 */

package FrontEnd.Panels;

import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author unknown
 */
public class PanelCrearUsuario extends JPanel {
    public PanelCrearUsuario() {
        initComponents();
    }

    public JTextField getTfNombre() {
        return tfNombre;
    }

    public JTextField getTfApellido() {
        return tfApellido;
    }

    public JTextField getTfCorreo() {
        return tfCorreo;
    }

    public JPasswordField getTfPsswd() {
        return tfPsswd;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        label1 = new JLabel();
        tfNombre = new JTextField();
        label2 = new JLabel();
        tfApellido = new JTextField();
        label3 = new JLabel();
        tfCorreo = new JTextField();
        label4 = new JLabel();
        tfPsswd = new JPasswordField();

        //======== this ========
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new
        javax. swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax
        . swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java
        .awt .Font ("D\u0069alog" ,java .awt .Font .BOLD ,12 ), java. awt
        . Color. red) , getBorder( )) );  addPropertyChangeListener (new java. beans.
        PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062order" .
        equals (e .getPropertyName () )) throw new RuntimeException( ); }} );
        setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- label1 ----
        label1.setText("Nombre");
        add(label1, "cell 0 0");
        add(tfNombre, "cell 1 0,wmin 350");

        //---- label2 ----
        label2.setText("Apellido");
        add(label2, "cell 0 1");
        add(tfApellido, "cell 1 1");

        //---- label3 ----
        label3.setText("Correo");
        add(label3, "cell 0 2");
        add(tfCorreo, "cell 1 2");

        //---- label4 ----
        label4.setText("Contrase\u00f1a");
        add(label4, "cell 0 3");
        add(tfPsswd, "cell 1 3");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel label1;
    private JTextField tfNombre;
    private JLabel label2;
    private JTextField tfApellido;
    private JLabel label3;
    private JTextField tfCorreo;
    private JLabel label4;
    private JPasswordField tfPsswd;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
