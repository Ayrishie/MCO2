import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
public class VendingMachineGui extends JFrame {
    private Menu menu;
    private JButton buttonCreate;
    private JButton buttonTest;
    private JButton buttonExit;
    public VendingMachineGui(){
        super("Vending Machine Factory");
        setLayout(new BorderLayout());

        //set size of our window
        setSize(450, 500);
        setResizable(false);
        init();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        menu = new Menu();
    }

    private void init(){
        //SOUTH PANEL
        JPanel panelSouth = new JPanel();
        panelSouth.setLayout(new FlowLayout());
        panelSouth.setBackground(Color.decode("#F79327"));

        buttonExit = new JButton("Exit");
        panelSouth.add(buttonExit);

        this.add(panelSouth, BorderLayout.SOUTH);

        //NORTH PANEL
        JPanel panelNorth = new JPanel();
        panelNorth.setLayout(new FlowLayout());
        panelNorth.setBackground(Color.decode("#F79327"));

        JLabel lblPizzaVendingMachine = new JLabel("RAIO Vending Machine Factory");
        lblPizzaVendingMachine.setForeground(Color.decode("#B70404"));
        lblPizzaVendingMachine.setFont(new Font("Montserrat", Font.BOLD, 20));
        panelNorth.add(lblPizzaVendingMachine);

        this.add(panelNorth, BorderLayout.NORTH);

        // Center Panel
        JPanel panelCenter = new JPanel(new GridBagLayout());
        panelCenter.setBackground(Color.decode("#FDF5E6")); // Set background color to FDF5E6

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        buttonCreate = new JButton("Create Vending Machine");
        buttonCreate.setForeground(Color.black); // Set foreground (text) color to black
        buttonCreate.setBackground(Color.decode("#A8A196")); // Set background color to a light gray
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelCenter.add(buttonCreate, gbc);

        buttonTest = new JButton("Test Vending Machine");
        buttonTest.setForeground(Color.black); // Set foreground (text) color to black
        buttonTest.setBackground(Color.decode("#A8A196")); // Set background color to a light gray
        gbc.gridy = 1;
        panelCenter.add(buttonTest, gbc);

        // Reset gridwidth for the second button
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        this.add(panelCenter, BorderLayout.CENTER);
    }

    public void addButtonCreateListener(ActionListener listener) {
        buttonCreate.addActionListener(listener);
    }

    public void addButtonTestListener(ActionListener listener) {
        buttonTest.addActionListener(listener);
    }

    public void addButtonExitListener(ActionListener listener) {
        buttonExit.addActionListener(listener);
    }

}



