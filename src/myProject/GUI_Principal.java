package myProject;

/**
 * Esta es la ventana que representa el login de la app
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_Principal extends JFrame {
    public static final String PATH ="/recursos/";

    private Image image;
    private ImageIcon inicio, registroImage;
    private JLabel logo;
    private Escucha escucha;
    private JButton login, registro;
    private JPanel panelNorte, panelSur, panelCentro;

    /**
     * Class GUI constructor
     */
    public GUI_Principal(){
        initGUI_Principal();

        // Configuration for default of GUI
        this.setTitle("THE FASHIONROOM");
        this.setIconImage(image);
        this.setUndecorated(false);
        this.setSize(750,750);
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Este método se utiliza para configurar la configuración predeterminada de JComponent,
     * crear objetos de escucha y control utilizados para la clase GUI
     */
    private void initGUI_Principal() {
        // Creacion de las ventanas


        // Creación el evento escucha
        escucha = new Escucha();

        // Imagenes
        image = new ImageIcon(getClass().getResource(PATH+"fIconPrincipal.png")).getImage();
        inicio = new  ImageIcon(getClass().getResource(PATH+"login.png"));
        registroImage = new  ImageIcon(getClass().getResource(PATH+"registro.png"));

        // Set up JFrame Container's Layout
        panelNorte = new JPanel();
        panelSur = new JPanel();
        panelCentro = new JPanel();

        // Creación de paneles para el JFrame
        panelNorte.setBackground(Color.white);
        panelSur.setBackground(Color.white);
        panelCentro.setBackground(Color.green);

        panelSur.setLayout(new FlowLayout(FlowLayout.CENTER,150,20));
        panelNorte.setLayout(new FlowLayout(FlowLayout.CENTER,100,0));
        panelCentro.setLayout(new GridLayout(1,1,0,100));

        panelSur.setPreferredSize(new Dimension(100,80));
        panelNorte.setPreferredSize(new Dimension(100,170));
        panelCentro.setPreferredSize(new Dimension(600,100));

        // Se agregan los paneles al JFrame
        this.add(panelNorte,BorderLayout.NORTH);
        this.add(panelSur,BorderLayout.SOUTH);
        this.add(panelCentro,BorderLayout.CENTER);

        // Poner imagenes y botones en el panel
        // Logo en el panel norte
        logo = new JLabel();
        logo.setIcon(new ImageIcon(getClass().getResource(PATH + "Logo.png")));
        panelNorte.add(logo);

        // Button of login and register
        login = new JButton("Iniciar sesión", inicio);
        login.addActionListener(escucha);
        login.setBackground(Color.WHITE);
        login.setFocusable(false);
        login.setBorder(null);
        panelSur.add(login,FlowLayout.LEFT);

        registro = new JButton("Registrarse", registroImage);
        registro.addActionListener(escucha);
        registro.setBackground(Color.WHITE);
        registro.setFocusable(false);
        registro.setBorder(null);
        panelSur.add(registro,FlowLayout.CENTER);
    }

    private class Escucha implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    /**
     * Main process of the Java program
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            myProject.GUI_Principal miProjectGUI = new myProject.GUI_Principal();
        });
    }

}
