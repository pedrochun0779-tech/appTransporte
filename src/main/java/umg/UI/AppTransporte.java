
package umg.UI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class AppTransporte extends JFrame {

    public AppTransporte() {
        configurarVentana();
        crearInterfaz();
    }

    private void configurarVentana() {
        setTitle("Sistema de Transporte - Menu Principal");
        setSize(700, 500);
        setMinimumSize(new Dimension(600, 400));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void crearInterfaz() {

        JPanel panelPrincipal = new JPanel(
                new BorderLayout(15, 15));

        panelPrincipal.setBorder(
                BorderFactory.createEmptyBorder(25, 30, 25, 30));

        JLabel titulo = new JLabel(
                "SISTEMA DE TRANSPORTE",
                SwingConstants.CENTER);

        titulo.setFont(new Font("Arial", Font.BOLD, 24));

        JLabel subtitulo = new JLabel(
                "Seleccione el modulo que desea administrar",
                SwingConstants.CENTER);

        subtitulo.setFont(new Font("Arial", Font.PLAIN, 14));

        JPanel panelEncabezado =
                new JPanel(new GridLayout(2, 1, 5, 5));

        panelEncabezado.add(titulo);
        panelEncabezado.add(subtitulo);

        // Panel con cuatro botones
        JPanel panelBotones =
                new JPanel(new GridLayout(4, 1, 12, 12));

        JButton btnCiudad =
                new JButton("Administrar Ciudades");

        JButton btnCamion =
                new JButton("Administrar Camiones");

        JButton btnCamionero =
                new JButton("Administrar Camioneros");

        JButton btnCamioneroCamion =
                new JButton("Asignar Camioneros a Camiones");

        // Formato de los botones
        Font fuenteBotones =
                new Font("Arial", Font.BOLD, 16);

        btnCiudad.setFont(fuenteBotones);
        btnCamion.setFont(fuenteBotones);
        btnCamionero.setFont(fuenteBotones);
        btnCamioneroCamion.setFont(fuenteBotones);

        // Abrir formularios
        btnCiudad.addActionListener(
                e -> abrirFormulario(new FrmCiudad()));

        btnCamion.addActionListener(
                e -> abrirFormulario(new FrmCamion()));

        btnCamionero.addActionListener(
                e -> abrirFormulario(new FrmCamionero()));

        btnCamioneroCamion.addActionListener(
                e -> abrirFormulario(new FrmCamioneroCamion()));

        // Agregar botones al panel
        panelBotones.add(btnCiudad);
        panelBotones.add(btnCamion);
        panelBotones.add(btnCamionero);
        panelBotones.add(btnCamioneroCamion);

        JLabel pie = new JLabel(
                "Gestion de ciudades, camiones y camioneros",
                SwingConstants.CENTER);

        panelPrincipal.add(
                panelEncabezado, BorderLayout.NORTH);

        panelPrincipal.add(
                panelBotones, BorderLayout.CENTER);

        panelPrincipal.add(
                pie, BorderLayout.SOUTH);

        setContentPane(panelPrincipal);
    }

    private void abrirFormulario(JFrame formulario) {
        formulario.setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE);

        formulario.setLocationRelativeTo(this);
        formulario.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AppTransporte().setVisible(true);
        });
    }
}

