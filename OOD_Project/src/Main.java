import app.PayApp;
import ui.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Main implements ActionListener {
    private static JTextField user;
    private static JPasswordField pass;
    private static JLabel message;
    GUI gui = new GUI();
    static JFrame frame  = new JFrame("Payment System Login");

    public static void main(String[] args) throws Exception {
        JPanel panel = new JPanel();
        frame.setSize(350,250);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        JLabel label = new JLabel("User");
        label.setBounds(10,20, 80, 25);
        panel.add(label);

        user = new JTextField(20);
        user.setBounds(100, 20, 165, 25);
        panel.add(user);

        JLabel password = new JLabel("Password");
        password.setBounds(10, 50, 80, 25);
        panel.add(password);

        pass = new JPasswordField();
        pass.setBounds(100, 50, 165, 25);
        panel.add(pass);

        JButton login = new JButton("Login");
        login.setBounds(100, 90, 80, 25);
        login.addActionListener(new Main());
        panel.add(login);

        message = new JLabel("");
        message.setBounds(100, 120, 100, 25);
        panel.add(message);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PayApp app = null;
        try {
            app = new PayApp("employees", "payslips", "notes", "reports", ',');
        } catch (IOException ioException) {
            System.out.println("There was an error locating a database!");
        }

        String user = Main.user.getText();
        String password = Main.pass.getText();

        if (user.equals("admin") && password.equals("123")) {
            frame.dispose();
            gui.start(app);
        }
        else if (user.equals("acct") && password.equals("321")) {
            frame.dispose();
            gui.letsGo(app);
        }
        else {
            message.setText("FAILED TO LOGIN!");
            message.setForeground(Color.red);
        }
    }
}