/*
 * Created by JFormDesigner on Sun Nov 17 21:53:49 CST 2019
 */

package FrontEnd;

import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import javax.swing.*;

import BackEnd.Usuarios;
import FrontEnd.Panels.PanelCrearUsuario;
import FrontEnd.Panels.PanelLogin;
import com.formdev.flatlaf.FlatIntelliJLaf;
import net.miginfocom.swing.*;


/**
 * @author unknown
 */
public class FrmInicio extends JFrame {
    PanelLogin panelLogin;
    PanelCrearUsuario panelCrearUsuario;

    public FrmInicio() {
        initComponents();
        panelLogin = new PanelLogin();
        panelCrearUsuario = new PanelCrearUsuario();
        panelLogin.setVisible(true);
        panelCrearUsuario.setVisible(false);

        panelPrincipal.add(panelLogin);
        panelPrincipal.repaint();
        panelPrincipal.revalidate();

    }

    private void btnIniciarActionPerformed(ActionEvent e) {
        if (panelLogin.isVisible()) {
            String nombre = panelLogin.getTextField1().getText();
            char[] psswd = panelLogin.getPasswordField1().getPassword();
            try {
                String url = "jdbc:oracle:thin:@localhost:49161:XE";
                Connection conn = DriverManager.getConnection(url, "fbd_2", "fbd_2");
                Statement stmt = conn.createStatement();
                ResultSet rs;
                System.out.println(String.format("SELECT id_usuario FROM usuarios WHERE correo like '%s' and password like '%s'", nombre, String.valueOf(psswd)));
                rs = stmt.executeQuery(String.format("SELECT id_usuario FROM usuarios WHERE correo like '%s' and password like '%s'", nombre, String.valueOf(psswd)));
               boolean f = false;
                if (rs.getFetchSize() > 0) {
                    while (rs.next()) {
                        f = true;
                        String lastName = rs.getString("ID_USUARIO");
                        System.out.println(lastName);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Error al iniciar sesión\nDatos no validos", "ERROR al iniciar sesión", JOptionPane.ERROR_MESSAGE);
                }

                conn.close();
            } catch (Exception ex) {
                System.err.println("Got an exception! ");
                System.err.println(ex.getMessage());
            }
        } else {
            panelCrearUsuario.setVisible(false);
            panelLogin.setVisible(true);
            panelPrincipal.removeAll();
            panelPrincipal.repaint();
            panelPrincipal.revalidate();

            panelPrincipal.add(panelLogin);
            panelPrincipal.repaint();
            panelPrincipal.revalidate();
        }


    }

    private void btn_crearSesionActionPerformed(ActionEvent e) throws SQLException {
        if (panelCrearUsuario.isVisible()) {
            String nombre = panelCrearUsuario.getTfNombre().getText();
            String apellidos = panelCrearUsuario.getTfApellido().getText();
            String correo = panelCrearUsuario.getTfCorreo().getText();
            char[] psswd = panelCrearUsuario.getTfPsswd().getPassword();
            Usuarios u1 = new Usuarios(nombre, apellidos, correo, psswd);
            if (u1.findError() == null) {
                //Registering the Driver
                DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
                //Getting the connection
                String oracleUrl = "jdbc:oracle:thin:@localhost:49161:XE";
                Connection con = DriverManager.getConnection(oracleUrl, "fbd_2", "fbd_2");
                System.out.println("Connected to Oracle database.....");
                PreparedStatement pstmt = con.prepareStatement(u1.toSql());
                pstmt.execute();
                System.out.println("Record inserted");
                con.close(); // close the connection
            } else {
                JOptionPane.showMessageDialog(this, "Dato incorrecto\nVerifique " +
                                (u1.findError().equals("contraseña") ? "la " + u1.findError() : "el " + u1.findError()),
                        "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            panelLogin.setVisible(false);
            panelCrearUsuario.setVisible(true);
            panelPrincipal.removeAll();
            panelPrincipal.repaint();
            panelPrincipal.revalidate();
            panelPrincipal.add(panelCrearUsuario);
            panelPrincipal.repaint();
            panelPrincipal.revalidate();
        }

    }

    private void initComponents() {
        FlatIntelliJLaf.install();
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        panelPrincipal = new JPanel();
        buttonBar = new JPanel();
        btn_crearSesion = new JButton();
        btnIniciar = new JButton();

        //======== this ========
        setTitle("Iniciar sesi\u00f3n");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(510, 360));
        setResizable(false);
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax
                    .swing.border.EmptyBorder(0, 0, 0, 0), "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax.swing
                    .border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.
                    Font("Dia\u006cog", java.awt.Font.BOLD, 12), java.awt.Color.red
            ), dialogPane.getBorder()));
            dialogPane.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
                @Override
                public void propertyChange(java.beans.PropertyChangeEvent e) {
                    if ("bord\u0065r".equals(e.getPropertyName(
                    ))) throw new RuntimeException();
                }
            });
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setLayout(new MigLayout(
                        "insets dialog,hidemode 3,alignx center",
                        // columns
                        "[fill]" +
                                "[fill]",
                        // rows
                        "[]" +
                                "[]" +
                                "[]"));

                //---- label1 ----
                label1.setText("Iniciar sesi\u00f3n");
                label1.setFont(new Font("Segoe UI", Font.PLAIN, 26));
                contentPanel.add(label1, "cell 0 0 2 1,alignx center,growx 0");

                //---- label2 ----
                label2.setText("Ingrese sus datos para continuar");
                contentPanel.add(label2, "cell 0 1 2 1,alignx center,growx 0");

                //======== panelPrincipal ========
                {
                    panelPrincipal.setPreferredSize(new Dimension(61, 150));
                    panelPrincipal.setLayout(new MigLayout(
                            "hidemode 3",
                            // columns
                            "[fill]" +
                                    "[fill]",
                            // rows
                            "[]" +
                                    "[]" +
                                    "[]"));
                }
                contentPanel.add(panelPrincipal, "cell 0 2 2 1,dock center");
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setLayout(new MigLayout(
                        "insets dialog,alignx right",
                        // columns
                        "[button,fill]" +
                                "[button,fill]",
                        // rows
                        null));

                //---- btn_crearSesion ----
                btn_crearSesion.setText("Crear usuario");
                btn_crearSesion.addActionListener(e -> {
                    try {
                        btn_crearSesionActionPerformed(e);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                });
                buttonBar.add(btn_crearSesion, "cell 0 0");

                //---- btnIniciar ----
                btnIniciar.setText("Iniciar sesi\u00f3n");
                btnIniciar.addActionListener(e -> {
                    btnIniciarActionPerformed(e);
                    btnIniciarActionPerformed(e);
                });
                buttonBar.add(btnIniciar, "cell 1 0");
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel label1;
    private JLabel label2;
    private JPanel panelPrincipal;
    private JPanel buttonBar;
    private JButton btn_crearSesion;
    private JButton btnIniciar;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
