import app.PayApp;
import ui.GUI;
import ui.TextUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main implements ActionListener {

    private static JTextField user;
    private static JPasswordField pass;
    private static JLabel message;
    GUI gui = new GUI();
    static JFrame frame  = new JFrame("Payment System Login");


    public static void main(String[] args) throws Exception {
        PayApp app = new PayApp("employees", "payslips", "notes", "reports", ',');
        TextUI ui = new TextUI();

        System.out.println("\n Please wait, the system is starting...");
        Thread.sleep(4000);
        System.out.println("\n");
        DateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy \n               hh.mm aa");
        String dateString2 = dateFormat2.format(new Date());
        System.out.println("              " + dateString2);
        System.out.println("\n");
        System.out.println("        Main Menu loading      ".toUpperCase());
        Thread.sleep(4000);
        System.out.println("\nSelect Interface\n");
        System.out.println("1)TextUI\n\n");
        Thread.sleep(250);
        System.out.println("2)GUI\n\n");
        Thread.sleep(250);
        Scanner select = new Scanner(System.in);
        int choice = select.nextInt();


        if (choice == 1) {
            while (true) {
                System.out.println("\nPlease Enter Username: ");
                Scanner user = new Scanner(System.in);

                String userName = user.next();
                System.out.println("\nPlease Enter Password: ");
                Scanner passcode = new Scanner(System.in);

                String code = passcode.next();

                if (userName.compareTo("admin")==0 && code.compareTo("123")==0) {
                    ui.start(app);

                } else if (userName.compareTo("acct")==0 && code.compareTo("789")==0) {
                    ui.letsGo(app);
                }

                System.out.println("\n\nUsername Or Password Is Incorrect\n\nEXITING\n\n");
            }

       } else {
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
        select.close();
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