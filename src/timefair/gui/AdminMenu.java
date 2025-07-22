package timefair.gui;

import java.awt.*;
import javax.swing.*;

public class AdminMenu extends JFrame {

    private JPanel cards;
    private JPanel MainPanel;
    private JLabel WelcomeLabel;
    private JButton NewEmployeeButton;
    private JButton EmployeeListButton;
    private JButton RecordHoursButton;
    private JButton PaymentHistoryButton;
    private JButton CalcButton;
    private JButton RequestListButton;
    private JButton LogOutButton;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AdminMenu().setVisible(true));
    }

    public AdminMenu() {
        setTitle("Panel de Administrador");
        initComponents();

        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int ancho = (int)(pantalla.width * 0.8);
        int alto  = (int)(pantalla.height * 0.8);
        setSize(ancho, alto);
        setMinimumSize(new Dimension(800, 600));
        setLocationRelativeTo(null);

        // Creamos CardLayout y agregamos los "cards"
        cards = new JPanel(new CardLayout());
        cards.add(MainPanel,            "MAIN");
        cards.add(new CalcularNomina(cards), "CALC");
        cards.add(new EmployeeList(cards),   "EL");
        cards.add(new NewEmployee(cards),    "NE");
        cards.add(new PaymentHistory(cards),"PH");
        cards.add(new RecordHours(cards),    "RH");
        cards.add(new RequestList(cards),    "RL");

        // Ponemos sólo cards en el frame
        setContentPane(cards);
        revalidate();
        repaint();
        pack();  // <— ¡al FINAL!
    }

    private void initComponents() {
        // 1) Crear componentes
        MainPanel            = new JPanel(new GridBagLayout());  // <— importante
        WelcomeLabel         = new JLabel("Bienvenido de nuevo");
        LogOutButton         = new JButton("Cerrar sesión");
        NewEmployeeButton    = new JButton("Registrar empleado nuevo");
        EmployeeListButton   = new JButton("Ver lista de empleados");
        RecordHoursButton    = new JButton("Registrar horas trabajadas");
        PaymentHistoryButton = new JButton("Historial de pagos");
        CalcButton           = new JButton("Calcular nómina");
        RequestListButton    = new JButton("Solicitudes de licencias o vacaciones");

        // 2) Añadir a MainPanel con GridBagConstraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);

        // Fila 0, col 0: etiqueta de bienvenida
        gbc.gridx   = 0;
        gbc.gridy   = 0;
        gbc.gridwidth = 1;
        gbc.anchor  = GridBagConstraints.FIRST_LINE_START;
        MainPanel.add(WelcomeLabel, gbc);

        // Fila 0, col 1: botón cerrar sesión
        gbc.gridx   = 1;
        gbc.anchor  = GridBagConstraints.FIRST_LINE_END;
        MainPanel.add(LogOutButton, gbc);
        LogOutButton.addActionListener(evt -> {
            dispose();
            SwingUtilities.invokeLater(() -> new Login().setVisible(true));
        });

        // Resto de botones, columna única centrada
        gbc.gridx      = 0;
        gbc.gridy      = 1;
        gbc.gridwidth  = 2;
        gbc.anchor     = GridBagConstraints.CENTER;

        MainPanel.add(NewEmployeeButton, gbc);
        NewEmployeeButton.addActionListener(evt -> switchCard("NE"));

        gbc.gridy++;
        MainPanel.add(EmployeeListButton, gbc);
        EmployeeListButton.addActionListener(evt -> switchCard("EL"));

        gbc.gridy++;
        MainPanel.add(RecordHoursButton, gbc);
        RecordHoursButton.addActionListener(evt -> switchCard("RH"));

        gbc.gridy++;
        MainPanel.add(PaymentHistoryButton, gbc);
        PaymentHistoryButton.addActionListener(evt -> switchCard("PH"));

        gbc.gridy++;
        MainPanel.add(CalcButton, gbc);
        CalcButton.addActionListener(evt -> switchCard("CALC"));

        gbc.gridy++;
        MainPanel.add(RequestListButton, gbc);
        RequestListButton.addActionListener(evt -> switchCard("RL"));
    }

    private void switchCard(String name) {
        CardLayout cl = (CardLayout) cards.getLayout();
        cl.show(cards, name);
    }
}
