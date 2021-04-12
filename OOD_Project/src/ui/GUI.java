package ui;

import app.PayApp;
import com.itextpdf.text.DocumentException;
import paysys.Employee;
import paysys.Note;
import paysys.Payslip;
import paysys.Report;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.util.Objects;

public class GUI {
    static int payslipNum = 1;
    static int reportNum = 1;
    static int noteNum = 1;
    private final JLabel genReport = new JLabel("Generate Report");
    private final JLabel review = new JLabel("Review Employee History");
    private final JLabel genPayslip = new JLabel("Generate Payslip");
    private final JButton exitBtn = new JButton("EXIT");
    private final JLabel error = new JLabel("INPUT ERROR");

    public void start (PayApp app) {
        JPanel mainPanel = new JPanel();
        JPanel sidePanel = new JPanel();
        JFrame frame  = new JFrame("Sunnyside Payment System");
        frame.setSize(700,650);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);

        mainPanel.setBounds(10, 10, 250, 250);
        sidePanel.setBounds(270, 10, 400, 500);
        mainPanel.setBackground(Color.lightGray);
        sidePanel.setBackground(Color.lightGray);
        exitBtn.setBounds(300, 530, 80, 25);
        exitBtn.setForeground(Color.red);

        mainPanel.setLayout(null);
        sidePanel.setLayout(null);

        JLabel manageEmp = new JLabel("Manage Employee Records");
        manageEmp.setBounds(10, 10, 200, 30);
        mainPanel.add(manageEmp);

        review.setBounds(10, 40, 200, 30);
        mainPanel.add(review);

        genPayslip.setBounds(10, 70, 200, 30);
        mainPanel.add(genPayslip);

        JLabel manageNotes = new JLabel("Manage Your Notes");
        manageNotes.setBounds(10, 100, 200, 30);
        mainPanel.add(manageNotes);

        genReport.setBounds(10, 130, 200, 30);
        mainPanel.add(genReport);

        JLabel eval = new JLabel("Perform An Evaluation");
        eval.setBounds(10, 160, 200, 30);
        mainPanel.add(eval);

//        JLabel showAll = new JLabel("Display All Employees Records");
//        showAll.setBounds(10, 190, 200, 30);
//        mainPanel.add(showAll);

        manageEmp.addMouseListener(new MouseListener() {
           public void mousePressed(MouseEvent me) {
           }

           public void mouseReleased(MouseEvent me) {
           }

           public void mouseEntered(MouseEvent me) {
           }

           public void mouseExited(MouseEvent me) {
           }

           public void mouseClicked(MouseEvent me) {
               sidePanel.removeAll();
               JLabel addEmp = new JLabel("Add New Employee");
               JLabel rmvEmp = new JLabel("Remove Employee");
               JLabel updateName = new JLabel("Update Employee Name");
               JLabel updateAddr = new JLabel("Update Employee Address");
               JLabel updateHrs = new JLabel("Update Employee Hours");

               if (me.getButton() == MouseEvent.BUTTON1 || me.getButton() == MouseEvent.BUTTON3) {
                   addEmp.setBounds(10, 10, 200, 30);
                   rmvEmp.setBounds(10, 40, 200, 30);
                   updateName.setBounds(10, 70, 200, 30);
                   updateAddr.setBounds(10, 100, 200, 30);
                   updateHrs.setBounds(10, 130, 200, 30);

                   sidePanel.add(addEmp);
                   sidePanel.add(rmvEmp);
                   sidePanel.add(updateName);
                   sidePanel.add(updateAddr);
                   sidePanel.add(updateHrs);
                   sidePanel.updateUI();
               }
               addEmp.addMouseListener(new MouseListener() {
                   final JLabel fName = new JLabel("First Name");
                   final JLabel mName = new JLabel("Middle Name");
                   final JLabel lName = new JLabel("Last Name");
                   final JLabel trn = new JLabel("Tax Registration Number");
                   final JLabel dob = new JLabel("Date of Birth");
                   final JLabel gender = new JLabel("Select Gender");
                   final JLabel country = new JLabel("Country");
                   final JLabel parish = new JLabel("Parish");
                   final JLabel town = new JLabel("Town");
                   final JLabel street = new JLabel("Street");
                   final JLabel position = new JLabel("Select Position");
                   final JLabel hours = new JLabel("Hours");

                   final JTextField firstN = new JTextField();
                   final JTextField midN = new JTextField();
                   final JTextField lastN = new JTextField();
                   final JTextField taxN = new JTextField();
                   final JTextField birthD = new JTextField();
                   final String [] sex = {"M", "F"};
                   final JComboBox<String> cb = new JComboBox<>(sex);
                   final JTextField add1 = new JTextField();
                   final JTextField add2 = new JTextField();
                   final JTextField add3 = new JTextField();
                   final JTextField add4 = new JTextField();
                   final String [] pos = {"Jnr Staff", "Snr Staff"};
                   final JComboBox<String> posCb = new JComboBox<>(pos);
                   final JTextField hrs = new JTextField();

                   @Override
                   public void mouseClicked(MouseEvent e) {
                       sidePanel.removeAll();
                       fName.setBounds(10, 10, 150, 30);
                       firstN.setBounds(10, 40, 150, 30);

                       mName.setBounds(180, 10, 150, 30);
                       midN.setBounds(180, 40, 150, 30);

                       lName.setBounds(10, 70, 150, 30);
                       lastN.setBounds(10, 100, 150, 30);

                       trn.setBounds(180, 70, 150, 30);
                       taxN.setBounds(180, 100, 150, 30);

                       dob.setBounds(10, 130, 150, 30);
                       birthD.setBounds(10, 160, 150, 30);

                       gender.setBounds(180, 130, 150, 30);
                       cb.setBounds(180, 160, 50, 30);

                       country.setBounds(10, 190, 150, 30);
                       add1.setBounds(10, 210, 150, 30);

                       parish.setBounds(180, 190, 150, 30);
                       add2.setBounds(180, 210, 150, 30);

                       town.setBounds(10, 240, 150, 30);
                       add3.setBounds(10, 270, 150, 30);

                       street.setBounds(180, 240, 150, 30);
                       add4.setBounds(180, 270, 150, 30);

                       position.setBounds(10, 300, 150, 30);
                       posCb.setBounds(10, 330, 100, 30);

                       hours.setBounds(180, 300, 150, 30);
                       hrs.setBounds(180, 330, 150, 30);

                       JButton submit = new JButton("SUBMIT");

                       submit.setBounds(250, 380, 80, 30);
                       submit.setForeground(Color.green);

                       sidePanel.add(fName);
                       sidePanel.add(mName);
                       sidePanel.add(lName);
                       sidePanel.add(trn);
                       sidePanel.add(dob);
                       sidePanel.add(gender);
                       sidePanel.add(country);
                       sidePanel.add(parish);
                       sidePanel.add(town);
                       sidePanel.add(street);
                       sidePanel.add(position);
                       sidePanel.add(hours);

                       sidePanel.add(firstN);
                       sidePanel.add(midN);
                       sidePanel.add(lastN);
                       sidePanel.add(taxN);
                       sidePanel.add(birthD);
                       sidePanel.add(cb);
                       sidePanel.add(add1);
                       sidePanel.add(add2);
                       sidePanel.add(add3);
                       sidePanel.add(add4);
                       sidePanel.add(posCb);
                       sidePanel.add(hrs);

                       sidePanel.add(submit);
                       sidePanel.updateUI();

                       submit.addActionListener(e13 -> {
                           try{
                               String middleName = "";
                               byte pos = 0;

                               if (Objects.requireNonNull(posCb.getSelectedItem()).toString().equals("Jnr Staff")){
                                   pos = 1;
                               }
                               if (!midN.getText().equals("")){
                                   middleName = midN.getText().strip();
                               }
                               Employee newEmployee = new Employee(Integer.parseInt(taxN.getText()), birthD.getText().strip(), Objects.requireNonNull(cb.getSelectedItem()).toString().charAt(0),
                                       PayApp.newID, firstN.getText().strip(), middleName, lastN.getText().strip(), add1.getText().strip(), add2.getText().strip(),
                                       add3.getText().strip(), add4.getText().strip(), pos, Float.parseFloat(hrs.getText()));
                               app.getEmployeeList().addEmployee(newEmployee);
                               PayApp.newID++;

                               sidePanel.removeAll();
                               JLabel success = new JLabel();
                               success.setText("<html>" + "SUCCESS" + "<br />" + app.getEmployeeList().getEmployee(firstN.getText().strip(), lastN.getText().strip()).toString() + "<br />" + "Was added successfully" + "</html>");
                               success.setBounds(20, 20, 150, 120);
                               sidePanel.add(success);
                               sidePanel.updateUI();
                           } catch (NumberFormatException numberFormatException) {
                               numberFormatException.printStackTrace();
                               error.setBounds(100, 400, 100, 30);
                               error.setForeground(Color.red);
                               sidePanel.add(error);
                               sidePanel.updateUI();
                           }
                       });
                   }

                   @Override
                   public void mousePressed(MouseEvent e) {

                   }

                   @Override
                   public void mouseReleased(MouseEvent e) {

                   }

                   @Override
                   public void mouseEntered(MouseEvent e) {

                   }

                   @Override
                   public void mouseExited(MouseEvent e) {

                   }
               });

               rmvEmp.addMouseListener(new MouseListener() {
                   final JLabel id = new JLabel("ID Number");
                   final JLabel name = new JLabel("Employee Name");

                   final JTextField idField = new JTextField();
                   final JTextField nameField = new JTextField();

                   final JLabel instruction = new JLabel("Enter Either Employee Name OR ID");

                   @Override
                   public void mouseClicked(MouseEvent e) {
                       sidePanel.removeAll();

                       instruction.setForeground(new Color(102, 0,153));
                       instruction.setBounds(100, 10, 250, 30);

                       id.setBounds(10, 60, 100, 30);
                       idField.setBounds(10, 90, 100, 30);

                       name.setBounds(10, 120, 200, 30 );
                       nameField.setBounds(10, 150, 200, 30);
                       JButton submit = new JButton("SUBMIT");

                       submit.setBounds(200, 190, 80, 30);

                       sidePanel.add(instruction);
                       sidePanel.add(id);
                       sidePanel.add(name);
                       sidePanel.add(idField);
                       sidePanel.add(nameField);
                       sidePanel.add(submit);

                       sidePanel.updateUI();

                       submit.addActionListener(e12 -> {
                           try {
                               if (!idField.getText().equals("") && app.getEmployeeList()!=null) {
                                   JLabel success = new JLabel();
                                   success.setText("<html>" + "SUCCESS" + "<br>" + "Employee Record " + app.getEmployeeList().getEmployee(Integer.parseInt(idField.getText())).toString() + "<br>" + "Was Successfully Removed!" + "</html>");
                                   app.getEmployeeList().removeEmployee(Integer.parseInt(idField.getText()));
                                   sidePanel.removeAll();
                                   success.setBounds(100, 100, 400, 300);
                                   sidePanel.add(success);
                                   sidePanel.updateUI();

                               } else if (!nameField.getText().equals("") && app.getEmployeeList()!=null){
                                   String [] names = nameField.getText().split(" ",2);
                                   app.getEmployeeList().removeEmployee(names[0].strip(), names[1].strip());
                                   JLabel success = new JLabel();
                                   success.setText("<html>" + "SUCCESS " + "<br>" + "Employee record with name " + names[0].strip() + " " + names[1].strip() + " was successfully removed!" + "</html>");
                                   sidePanel.removeAll();
                                   success.setBounds(100, 100, 400, 500);
                                   sidePanel.add(success);
                                   sidePanel.updateUI();
                               }
                           } catch (Exception ex) {
                               ex.printStackTrace();
                               error.setBounds(100, 250, 100, 30);
                               error.setForeground(Color.red);
                               sidePanel.add(error);
                               sidePanel.updateUI();
                           }
                       });
                   }
                   @Override
                   public void mousePressed(MouseEvent e) {

                   }

                   @Override
                   public void mouseReleased(MouseEvent e) {

                   }

                   @Override
                   public void mouseEntered(MouseEvent e) {

                   }

                   @Override
                   public void mouseExited(MouseEvent e) {

                   }
               });

               updateName.addMouseListener(new MouseListener() {
                   @Override
                   public void mouseClicked(MouseEvent e) {
                       if (e.getButton() == MouseEvent.BUTTON1 || e.getButton() == MouseEvent.BUTTON3) {
                           sidePanel.removeAll();
                           JLabel fName = new JLabel("Change First Name");
                           JLabel mName = new JLabel("Change Middle Name");
                           JLabel lName = new JLabel("Change Last Name");

                           fName.setBounds(10, 10, 150, 30);
                           mName.setBounds(10, 40, 150, 30);
                           lName.setBounds(10, 70, 150, 30);

                           sidePanel.add(fName);
                           sidePanel.add(mName);
                           sidePanel.add(lName);
                           sidePanel.updateUI();

                           fName.addMouseListener(new MouseListener() {
                               @Override
                               public void mouseClicked(MouseEvent e) {
                                  if (e.getButton() == MouseEvent.BUTTON1 || e.getButton() == MouseEvent.BUTTON3) {
                                      sidePanel.removeAll();
                                      JLabel instruction = new JLabel("Enter employee ID number AND The New First Name");
                                      JLabel id = new JLabel("EmployeeID Number");
                                      JLabel name = new JLabel("New Name");

                                      JTextField idField = new JTextField();
                                      JTextField nameField = new JTextField();

                                      instruction.setBounds(20, 10, 300, 30);
                                      instruction.setForeground(new Color(102, 0,153));
                                      id.setBounds(10, 40, 200, 30);
                                      idField.setBounds(10, 70, 50, 30);
                                      name.setBounds(10, 100, 100, 30);
                                      nameField.setBounds(10, 130, 100, 30);
                                      JButton submit = new JButton("SUBMIT");

                                      submit.setBounds(100, 180, 80, 30);
                                      submit.setForeground(Color.blue);

                                      sidePanel.add(instruction);
                                      sidePanel.add(id);
                                      sidePanel.add(name);
                                      sidePanel.add(idField);
                                      sidePanel.add(nameField);
                                      sidePanel.add(submit);
                                      sidePanel.updateUI();

                                      submit.addActionListener(e15 -> {
                                          if (!idField.getText().strip().equals("") && !nameField.getText().strip().equals("") && app.getEmployeeList().getEmployee(Integer.parseInt(idField.getText()))!=null){
                                              try {
                                                  sidePanel.removeAll();

                                                  JLabel success = new JLabel("<html>" + "SUCCESS" + "<br>" +
                                                          app.getEmployeeList().getEmployee(Integer.parseInt(idField.getText())).getName().toString() + "<br>"
                                                          + "First name has been changed to " + nameField.getText().strip() + "</html>");

                                                  app.getEmployeeList().getEmployee(Integer.parseInt(idField.getText())).getName().setFirstName(nameField.getText().strip());

                                                  success.setBounds(20, 20, 150, 200);
                                                  sidePanel.add(success);
                                                  sidePanel.updateUI();
                                              } catch (NumberFormatException numberFormatException) {
                                                  numberFormatException.printStackTrace();
                                                  error.setBounds(150, 250, 100, 30);
                                                  error.setForeground(Color.red);
                                                  sidePanel.add(error);
                                                  sidePanel.updateUI();
                                              }
                                          } else {
                                              error.setBounds(150, 250, 100, 30);
                                              error.setForeground(Color.red);
                                              sidePanel.add(error);
                                              sidePanel.updateUI();
                                          }
                                      });
                                   }
                               }

                               @Override
                               public void mousePressed(MouseEvent e) {

                               }

                               @Override
                               public void mouseReleased(MouseEvent e) {

                               }

                               @Override
                               public void mouseEntered(MouseEvent e) {

                               }

                               @Override
                               public void mouseExited(MouseEvent e) {

                               }
                           });
                           mName.addMouseListener(new MouseListener() {
                               @Override
                               public void mouseClicked(MouseEvent e) {
                                   if (e.getButton() == MouseEvent.BUTTON1 || e.getButton() == MouseEvent.BUTTON3) {
                                       sidePanel.removeAll();
                                       JLabel instruction = new JLabel("Enter employee ID number AND The New Middle Name");
                                       JLabel id = new JLabel("EmployeeID Number");
                                       JLabel name = new JLabel("New Name");

                                       JTextField idField = new JTextField();
                                       JTextField nameField = new JTextField();

                                       instruction.setBounds(20, 10, 300, 30);
                                       instruction.setForeground(new Color(102, 0,153));
                                       id.setBounds(10, 40, 200, 30);
                                       idField.setBounds(10, 70, 50, 30);
                                       name.setBounds(10, 100, 100, 30);
                                       nameField.setBounds(10, 130, 100, 30);
                                       JButton submit = new JButton("SUBMIT");

                                       submit.setBounds(100, 180, 80, 30);
                                       submit.setForeground(Color.blue);

                                       sidePanel.add(instruction);
                                       sidePanel.add(id);
                                       sidePanel.add(name);
                                       sidePanel.add(idField);
                                       sidePanel.add(nameField);
                                       sidePanel.add(submit);
                                       sidePanel.updateUI();

                                       submit.addActionListener(e16 -> {
                                           if (!idField.getText().strip().equals("") && !nameField.getText().strip().equals("") && app.getEmployeeList().getEmployee(Integer.parseInt(idField.getText()))!=null){
                                               try {
                                                   sidePanel.removeAll();

                                                   JLabel success = new JLabel("<html>" + "SUCCESS" + "<br>" +
                                                           app.getEmployeeList().getEmployee(Integer.parseInt(idField.getText())).getName().toString() + "<br>"
                                                           + "Middle name has been changed to " + nameField.getText().strip() + "</html>");

                                                   app.getEmployeeList().getEmployee(Integer.parseInt(idField.getText())).getName().setMiddleName(nameField.getText().strip());

                                                   success.setBounds(20, 20, 150, 200);
                                                   sidePanel.add(success);
                                                   sidePanel.updateUI();
                                               } catch (NumberFormatException numberFormatException) {
                                                   numberFormatException.printStackTrace();
                                                   error.setBounds(150, 250, 100, 30);
                                                   error.setForeground(Color.red);
                                                   sidePanel.add(error);
                                                   sidePanel.updateUI();
                                               }
                                           } else {
                                               error.setBounds(150, 250, 100, 30);
                                               error.setForeground(Color.red);
                                               sidePanel.add(error);
                                               sidePanel.updateUI();
                                           }
                                       });
                                   }
                               }

                               @Override
                               public void mousePressed(MouseEvent e) {

                               }

                               @Override
                               public void mouseReleased(MouseEvent e) {

                               }

                               @Override
                               public void mouseEntered(MouseEvent e) {

                               }

                               @Override
                               public void mouseExited(MouseEvent e) {

                               }
                           });
                           lName.addMouseListener(new MouseListener() {
                               @Override
                               public void mouseClicked(MouseEvent e) {
                                   if (e.getButton() == MouseEvent.BUTTON1 || e.getButton() == MouseEvent.BUTTON3) {
                                       sidePanel.removeAll();
                                       JLabel instruction = new JLabel("Enter employee ID number AND The New Last Name");
                                       JLabel id = new JLabel("EmployeeID Number");
                                       JLabel name = new JLabel("New Name");

                                       JTextField idField = new JTextField();
                                       JTextField nameField = new JTextField();

                                       instruction.setBounds(20, 10, 300, 30);
                                       instruction.setForeground(new Color(102, 0,153));
                                       id.setBounds(10, 40, 200, 30);
                                       idField.setBounds(10, 70, 50, 30);
                                       name.setBounds(10, 100, 100, 30);
                                       nameField.setBounds(10, 130, 100, 30);
                                       JButton submit = new JButton("SUBMIT");

                                       submit.setBounds(100, 180, 80, 30);
                                       submit.setForeground(Color.blue);

                                       sidePanel.add(instruction);
                                       sidePanel.add(id);
                                       sidePanel.add(name);
                                       sidePanel.add(idField);
                                       sidePanel.add(nameField);
                                       sidePanel.add(submit);
                                       sidePanel.updateUI();

                                       submit.addActionListener(e17 -> {
                                           if (!idField.getText().strip().equals("") && !nameField.getText().strip().equals("") && app.getEmployeeList().getEmployee(Integer.parseInt(idField.getText()))!=null) {
                                               try {
                                                   sidePanel.removeAll();

                                                   JLabel success = new JLabel("<html>" + "SUCCESS" + "<br>" +
                                                           app.getEmployeeList().getEmployee(Integer.parseInt(idField.getText())).getName().toString() + "<br>"
                                                           + "Last name has been changed to " + nameField.getText().strip() + "</html>");

                                                   app.getEmployeeList().getEmployee(Integer.parseInt(idField.getText())).getName().setLastName(nameField.getText().strip());

                                                   success.setBounds(20, 20, 150, 200);
                                                   sidePanel.add(success);
                                                   sidePanel.updateUI();
                                               } catch (NumberFormatException numberFormatException) {
                                                   numberFormatException.printStackTrace();
                                                   error.setBounds(150, 250, 100, 30);
                                                   error.setForeground(Color.red);
                                                   sidePanel.add(error);
                                                   sidePanel.updateUI();
                                               }
                                           } else {
                                               error.setBounds(150, 250, 100, 30);
                                               error.setForeground(Color.red);
                                               sidePanel.add(error);
                                               sidePanel.updateUI();
                                           }
                                       });
                                   }
                               }

                               @Override
                               public void mousePressed(MouseEvent e) {

                               }

                               @Override
                               public void mouseReleased(MouseEvent e) {

                               }

                               @Override
                               public void mouseEntered(MouseEvent e) {

                               }

                               @Override
                               public void mouseExited(MouseEvent e) {

                               }
                           });
                       }
                   }

                   @Override
                   public void mousePressed(MouseEvent e) {

                   }

                   @Override
                   public void mouseReleased(MouseEvent e) {

                   }

                   @Override
                   public void mouseEntered(MouseEvent e) {

                   }

                   @Override
                   public void mouseExited(MouseEvent e) {

                   }
               });

               updateAddr.addMouseListener(new MouseListener() {
                   @Override
                   public void mouseClicked(MouseEvent e) {
                       if (e.getButton() == MouseEvent.BUTTON1 || e.getButton() == MouseEvent.BUTTON3) {
                           sidePanel.removeAll();
                           JLabel country = new JLabel("Change Country");
                           JLabel parish = new JLabel("Change Parish");
                           JLabel town = new JLabel("Change Town");
                           JLabel street = new JLabel("Change Street");

                           country.setBounds(10, 10, 150, 30);
                           parish.setBounds(10, 40, 150, 30);
                           town.setBounds(10, 70, 150, 30);
                           street.setBounds(10, 100, 150, 30);

                           sidePanel.add(country);
                           sidePanel.add(parish);
                           sidePanel.add(town);
                           sidePanel.add(street);
                           sidePanel.updateUI();

                           country.addMouseListener(new MouseListener() {
                               @Override
                               public void mouseClicked(MouseEvent e) {
                                   if (e.getButton() == MouseEvent.BUTTON1 || e.getButton() == MouseEvent.BUTTON3) {
                                       sidePanel.removeAll();

                                       JLabel instruction = new JLabel("Enter employee Id AND new country in address");
                                       JLabel id = new JLabel("ID Number");
                                       JLabel newCountry = new JLabel("New Country");

                                       JTextField idNum = new JTextField();
                                       JTextField countryAdd = new JTextField();

                                       instruction.setForeground(new Color(102, 0,153));
                                       instruction.setBounds(20, 10,250, 30 );
                                       id.setBounds(10, 50, 100, 30);
                                       idNum.setBounds(10, 80, 50, 30);

                                       newCountry.setBounds(10, 110, 100, 30);
                                       countryAdd.setBounds(10, 140, 100, 30);

                                       JButton submit = new JButton("SUBMIT");
                                       submit.setForeground(Color.blue);
                                       submit.setBounds(100, 180, 80, 30);

                                       sidePanel.add(instruction);
                                       sidePanel.add(id);
                                       sidePanel.add(newCountry);
                                       sidePanel.add(idNum);
                                       sidePanel.add(countryAdd);
                                       sidePanel.add(submit);
                                       sidePanel.updateUI();

                                       submit.addActionListener(e18 -> {
                                           if (!idNum.getText().equals("") && !countryAdd.getText().strip().equals("") &&  app.getEmployeeList().getEmployee(Integer.parseInt(idNum.getText()))!=null) {
                                               try {
                                                   JLabel success = new JLabel();
                                                   success.setText("<html>" + "SUCCESS" + "<br />" + "Address for " +
                                                           app.getEmployeeList().getEmployee(Integer.parseInt(idNum.getText())).getName().toString()+ " was changed" + "</html>");
                                                   success.setBounds(20, 20, 200, 200);
                                                   app.getEmployeeList().getEmployee(Integer.parseInt(idNum.getText())).getAddress().setCountry(countryAdd.getText().strip());

                                                   sidePanel.removeAll();
                                                   sidePanel.add(success);
                                                   sidePanel.updateUI();
                                               } catch (NumberFormatException numberFormatException) {
                                                   numberFormatException.printStackTrace();
                                                   error.setBounds(150, 250, 100, 30);
                                                   error.setForeground(Color.red);
                                                   sidePanel.add(error);
                                                   sidePanel.updateUI();
                                               }
                                           } else {
                                               error.setBounds(150, 250, 100, 30);
                                               error.setForeground(Color.red);
                                               sidePanel.add(error);
                                               sidePanel.updateUI();
                                           }
                                       });
                                   }
                               }

                               @Override
                               public void mousePressed(MouseEvent e) {

                               }

                               @Override
                               public void mouseReleased(MouseEvent e) {

                               }

                               @Override
                               public void mouseEntered(MouseEvent e) {

                               }

                               @Override
                               public void mouseExited(MouseEvent e) {

                               }
                           });
                           parish.addMouseListener(new MouseListener() {
                               @Override
                               public void mouseClicked(MouseEvent e) {
                                   if (e.getButton() == MouseEvent.BUTTON1 || e.getButton() == MouseEvent.BUTTON3) {
                                       sidePanel.removeAll();

                                       JLabel instruction = new JLabel("Enter employee Id AND new parish in address");
                                       JLabel id = new JLabel("ID Number");
                                       JLabel parish = new JLabel("New Parish");

                                       JTextField idNum = new JTextField();
                                       JTextField parishField = new JTextField();

                                       instruction.setForeground(new Color(102, 0,153));
                                       instruction.setBounds(20, 10,250, 30 );
                                       id.setBounds(10, 50, 100, 30);
                                       idNum.setBounds(10, 80, 50, 30);

                                       parish.setBounds(10, 110, 100, 30);
                                       parishField.setBounds(10, 140, 100, 30);

                                       JButton submit = new JButton("SUBMIT");
                                       submit.setForeground(Color.blue);
                                       submit.setBounds(100, 180, 80, 30);

                                       sidePanel.add(instruction);
                                       sidePanel.add(id);
                                       sidePanel.add(parish);
                                       sidePanel.add(idNum);
                                       sidePanel.add(parishField);
                                       sidePanel.add(submit);
                                       sidePanel.updateUI();

                                       submit.addActionListener(e19 -> {
                                           if (!idNum.getText().equals("") && !parishField.getText().strip().equals("") &&  app.getEmployeeList().getEmployee(Integer.parseInt(idNum.getText()))!=null) {
                                               try {
                                                   JLabel success = new JLabel();
                                                   success.setText("<html>" + "SUCCESS" + "<br />" + "Address for " +
                                                           app.getEmployeeList().getEmployee(Integer.parseInt(idNum.getText())).getName().toString()+ " was changed" + "</html>");
                                                   success.setBounds(20, 20, 200, 200);
                                                   app.getEmployeeList().getEmployee(Integer.parseInt(idNum.getText())).getAddress().setParish(parishField.getText().strip());

                                                   sidePanel.removeAll();
                                                   sidePanel.add(success);
                                                   sidePanel.updateUI();
                                               } catch (NumberFormatException numberFormatException) {
                                                   numberFormatException.printStackTrace();
                                                   error.setBounds(150, 250, 100, 30);
                                                   error.setForeground(Color.red);
                                                   sidePanel.add(error);
                                                   sidePanel.updateUI();
                                               }
                                           } else {
                                               error.setBounds(150, 250, 100, 30);
                                               error.setForeground(Color.red);
                                               sidePanel.add(error);
                                               sidePanel.updateUI();
                                           }
                                       });
                                   }
                               }

                               @Override
                               public void mousePressed(MouseEvent e) {

                               }

                               @Override
                               public void mouseReleased(MouseEvent e) {

                               }

                               @Override
                               public void mouseEntered(MouseEvent e) {

                               }

                               @Override
                               public void mouseExited(MouseEvent e) {

                               }
                           });
                           town.addMouseListener(new MouseListener() {
                               @Override
                               public void mouseClicked(MouseEvent e) {
                                   if (e.getButton() == MouseEvent.BUTTON1 || e.getButton() == MouseEvent.BUTTON3) {
                                       sidePanel.removeAll();

                                       JLabel instruction = new JLabel("Enter employee Id AND new town in address");
                                       JLabel id = new JLabel("ID Number");
                                       JLabel town = new JLabel("New Town");

                                       JTextField idNum = new JTextField();
                                       JTextField townField = new JTextField();

                                       instruction.setForeground(new Color(102, 0,153));
                                       instruction.setBounds(20, 10,250, 30 );
                                       id.setBounds(10, 50, 100, 30);
                                       idNum.setBounds(10, 80, 50, 30);

                                       town.setBounds(10, 110, 100, 30);
                                       townField.setBounds(10, 140, 100, 30);

                                       JButton submit = new JButton("SUBMIT");
                                       submit.setForeground(Color.blue);
                                       submit.setBounds(100, 180, 80, 30);

                                       sidePanel.add(instruction);
                                       sidePanel.add(id);
                                       sidePanel.add(town);
                                       sidePanel.add(idNum);
                                       sidePanel.add(townField);
                                       sidePanel.add(submit);
                                       sidePanel.updateUI();

                                       submit.addActionListener(e110 -> {
                                           if (!idNum.getText().equals("") && !townField.getText().strip().equals("") &&  app.getEmployeeList().getEmployee(Integer.parseInt(idNum.getText()))!=null) {
                                               try {
                                                   JLabel success = new JLabel();
                                                   success.setText("<html>" + "SUCCESS" + "<br />" + "Address for " +
                                                           app.getEmployeeList().getEmployee(Integer.parseInt(idNum.getText())).getName().toString()+ " was changed" + "</html>");
                                                   success.setBounds(20, 20, 200, 200);
                                                   app.getEmployeeList().getEmployee(Integer.parseInt(idNum.getText())).getAddress().setTown(townField.getText().strip());

                                                   sidePanel.removeAll();
                                                   sidePanel.add(success);
                                                   sidePanel.updateUI();
                                               } catch (NumberFormatException numberFormatException) {
                                                   numberFormatException.printStackTrace();
                                                   error.setBounds(150, 250, 100, 30);
                                                   error.setForeground(Color.red);
                                                   sidePanel.add(error);
                                                   sidePanel.updateUI();
                                               }
                                           } else {
                                               error.setBounds(150, 250, 100, 30);
                                               error.setForeground(Color.red);
                                               sidePanel.add(error);
                                               sidePanel.updateUI();
                                           }
                                       });
                                   }
                               }

                               @Override
                               public void mousePressed(MouseEvent e) {

                               }

                               @Override
                               public void mouseReleased(MouseEvent e) {

                               }

                               @Override
                               public void mouseEntered(MouseEvent e) {

                               }

                               @Override
                               public void mouseExited(MouseEvent e) {

                               }
                           });
                           street.addMouseListener(new MouseListener() {
                               @Override
                               public void mouseClicked(MouseEvent e) {
                                   if (e.getButton() == MouseEvent.BUTTON1 || e.getButton() == MouseEvent.BUTTON3) {
                                       sidePanel.removeAll();

                                       JLabel instruction = new JLabel("Enter employee Id AND new street in address");
                                       JLabel id = new JLabel("ID Number");
                                       JLabel street = new JLabel("New Street");

                                       JTextField idNum = new JTextField();
                                       JTextField streetField = new JTextField();

                                       instruction.setForeground(new Color(102, 0,153));
                                       instruction.setBounds(20, 10,250, 30 );
                                       id.setBounds(10, 50, 100, 30);
                                       idNum.setBounds(10, 80, 50, 30);

                                       street.setBounds(10, 110, 100, 30);
                                       streetField.setBounds(10, 140, 100, 30);

                                       JButton submit = new JButton("SUBMIT");
                                       submit.setForeground(Color.blue);
                                       submit.setBounds(100, 180, 80, 30);

                                       sidePanel.add(instruction);
                                       sidePanel.add(id);
                                       sidePanel.add(street);
                                       sidePanel.add(idNum);
                                       sidePanel.add(streetField);
                                       sidePanel.add(submit);
                                       sidePanel.updateUI();

                                       submit.addActionListener(e111 -> {
                                           if (!idNum.getText().equals("") && !streetField.getText().strip().equals("") &&  app.getEmployeeList().getEmployee(Integer.parseInt(idNum.getText()))!=null) {
                                               try {
                                                   JLabel success = new JLabel();
                                                   success.setText("<html>" + "SUCCESS" + "<br />" + "Address for " +
                                                           app.getEmployeeList().getEmployee(Integer.parseInt(idNum.getText())).getName().toString()+ " was changed" + "</html>");
                                                   success.setBounds(20, 20, 200, 200);
                                                   app.getEmployeeList().getEmployee(Integer.parseInt(idNum.getText())).getAddress().setStreet(streetField.getText().strip());

                                                   sidePanel.removeAll();
                                                   sidePanel.add(success);
                                                   sidePanel.updateUI();
                                               } catch (NumberFormatException numberFormatException) {
                                                   numberFormatException.printStackTrace();
                                                   error.setBounds(150, 250, 100, 30);
                                                   error.setForeground(Color.red);
                                                   sidePanel.add(error);
                                                   sidePanel.updateUI();
                                               }
                                           } else {
                                               error.setBounds(150, 250, 100, 30);
                                               error.setForeground(Color.red);
                                               sidePanel.add(error);
                                               sidePanel.updateUI();
                                           }
                                       });
                                   }
                               }

                               @Override
                               public void mousePressed(MouseEvent e) {

                               }

                               @Override
                               public void mouseReleased(MouseEvent e) {

                               }

                               @Override
                               public void mouseEntered(MouseEvent e) {

                               }

                               @Override
                               public void mouseExited(MouseEvent e) {

                               }
                           });
                       }
                   }

                   @Override
                   public void mousePressed(MouseEvent e) {

                   }

                   @Override
                   public void mouseReleased(MouseEvent e) {

                   }

                   @Override
                   public void mouseEntered(MouseEvent e) {

                   }

                   @Override
                   public void mouseExited(MouseEvent e) {

                   }
               });

               updateHrs.addMouseListener(new MouseListener() {
                   @Override
                   public void mouseClicked(MouseEvent e) {
                       if (e.getButton() == MouseEvent.BUTTON1 || e.getButton() == MouseEvent.BUTTON3) {
                           sidePanel.removeAll();

                           JLabel addHrs = new JLabel("Add Hours To Employee Record");
                           JLabel rmvHrs = new JLabel("Remove Hours From Employee Record");

                           addHrs.setBounds(10, 10, 250, 30);
                           rmvHrs.setBounds(10, 40, 250, 30);

                           sidePanel.add(addHrs);
                           sidePanel.add(rmvHrs);
                           sidePanel.updateUI();

                           addHrs.addMouseListener(new MouseListener() {
                               @Override
                               public void mouseClicked(MouseEvent e) {
                                   if (e.getButton() == MouseEvent.BUTTON1 || e.getButton() == MouseEvent.BUTTON3){
                                       sidePanel.removeAll();

                                       JLabel instruction = new JLabel("Enter employee Id AND hours to be added");
                                       JLabel id = new JLabel("Employee ID");
                                       JLabel hours = new JLabel("Hours");

                                       JTextField idNum = new JTextField();
                                       JTextField hrsField = new JTextField();

                                       instruction.setForeground(new Color(102, 0,153));
                                       instruction.setBounds(20, 20, 300, 30);
                                       id.setBounds(10, 50, 100, 30);
                                       idNum.setBounds(10, 80, 100, 30);
                                       hours.setBounds(10, 110, 100, 30);
                                       hrsField.setBounds(10, 140, 100, 30);

                                       JButton submit = new JButton("SUBMIT");
                                       submit.setBounds(100, 180, 80, 30);
                                       submit.setForeground(Color.blue);

                                       sidePanel.add(instruction);
                                       sidePanel.add(id);
                                       sidePanel.add(idNum);
                                       sidePanel.add(hours);
                                       sidePanel.add(hrsField);
                                       sidePanel.add(submit);
                                       sidePanel.updateUI();

                                       submit.addActionListener(e112 ->{
                                           if (!idNum.getText().strip().equals("") && !hrsField.getText().strip().equals("") && app.getEmployeeList().getEmployee(Integer.parseInt(idNum.getText()))!=null){
                                               try {
                                                   app.getEmployeeList().getEmployee(Integer.parseInt(idNum.getText())).setHours(Float.parseFloat(hrsField.getText()));
                                                   sidePanel.removeAll();
                                                   JLabel success = new JLabel();
                                                   success.setText("<html>" + "SUCCESS" + "<br />" + hrsField.getText() + " Hours Has Been Added To Employee With ID " + idNum.getText() + "</html>");
                                                   success.setBounds(10, 50, 300, 200);

                                                   sidePanel.add(success);
                                                   sidePanel.updateUI();
                                               } catch (NumberFormatException numberFormatException) {
                                                   numberFormatException.printStackTrace();
                                                   error.setBounds(150, 250, 100, 30);
                                                   error.setForeground(Color.red);
                                                   sidePanel.add(error);
                                                   sidePanel.updateUI();
                                               }
                                           } else {
                                               error.setBounds(150, 250, 100, 30);
                                               error.setForeground(Color.red);
                                               sidePanel.add(error);
                                               sidePanel.updateUI();
                                           }
                                       });
                                   }
                               }

                               @Override
                               public void mousePressed(MouseEvent e) {

                               }

                               @Override
                               public void mouseReleased(MouseEvent e) {

                               }

                               @Override
                               public void mouseEntered(MouseEvent e) {

                               }

                               @Override
                               public void mouseExited(MouseEvent e) {

                               }
                           });
                           rmvHrs.addMouseListener(new MouseListener() {
                               @Override
                               public void mouseClicked(MouseEvent e) {
                                   if (e.getButton() == MouseEvent.BUTTON1 || e.getButton() == MouseEvent.BUTTON3) {
                                       sidePanel.removeAll();

                                       JLabel instruction = new JLabel("Enter employee Id AND hours to be subtracted");
                                       JLabel id = new JLabel("Employee ID");
                                       JLabel hours = new JLabel("Hours");

                                       JTextField idNum = new JTextField();
                                       JTextField hrsField = new JTextField();

                                       instruction.setForeground(new Color(102, 0,153));
                                       instruction.setBounds(20, 20, 300, 30);
                                       id.setBounds(10, 50, 100, 30);
                                       idNum.setBounds(10, 80, 100, 30);
                                       hours.setBounds(10, 110, 100, 30);
                                       hrsField.setBounds(10, 140, 100, 30);

                                       JButton submit = new JButton("SUBMIT");
                                       submit.setBounds(100, 180, 80, 30);
                                       submit.setForeground(Color.blue);

                                       sidePanel.add(instruction);
                                       sidePanel.add(id);
                                       sidePanel.add(idNum);
                                       sidePanel.add(hours);
                                       sidePanel.add(hrsField);
                                       sidePanel.add(submit);
                                       sidePanel.updateUI();

                                       submit.addActionListener(e113 -> {
                                           if (!idNum.getText().strip().equals("") && !hrsField.getText().strip().equals("") && app.getEmployeeList().getEmployee(Integer.parseInt(idNum.getText()))!=null){
                                               if (app.getEmployeeList().getEmployee(Integer.parseInt(idNum.getText())).getHours() >= Float.parseFloat(hrsField.getText())) {
                                                   try {
                                                       app.getEmployeeList().getEmployee(Integer.parseInt(idNum.getText())).takeHours(Float.parseFloat(hrsField.getText()));
                                                       sidePanel.removeAll();
                                                       JLabel success = new JLabel();
                                                       success.setText("<html>" + "SUCCESS" + "<br />" + hrsField.getText() + " Hours Has Been Removed From Employee With ID " + idNum.getText() + "</html>");
                                                       success.setBounds(10, 50, 300, 200);

                                                       sidePanel.add(success);
                                                       sidePanel.updateUI();
                                                   } catch (NumberFormatException numberFormatException) {
                                                       numberFormatException.printStackTrace();
                                                       error.setBounds(150, 250, 100, 30);
                                                       error.setForeground(Color.red);
                                                       sidePanel.add(error);
                                                       sidePanel.updateUI();
                                                   }
                                               } else {
                                                   error.setBounds(150, 250, 300, 30);
                                                   error.setText("Hours on file is less than input. CANNOT SUBTRACT!");
                                                   error.setForeground(Color.red);
                                                   sidePanel.add(error);
                                                   sidePanel.updateUI();
                                               }
                                           } else {
                                               error.setBounds(150, 250, 100, 30);
                                               error.setForeground(Color.red);
                                               sidePanel.add(error);
                                               sidePanel.updateUI();
                                           }
                                       });
                                   }
                               }

                               @Override
                               public void mousePressed(MouseEvent e) {

                               }

                               @Override
                               public void mouseReleased(MouseEvent e) {

                               }

                               @Override
                               public void mouseEntered(MouseEvent e) {

                               }

                               @Override
                               public void mouseExited(MouseEvent e) {

                               }
                           });
                       }
                   }

                   @Override
                   public void mousePressed(MouseEvent e) {

                   }

                   @Override
                   public void mouseReleased(MouseEvent e) {

                   }

                   @Override
                   public void mouseEntered(MouseEvent e) {

                   }

                   @Override
                   public void mouseExited(MouseEvent e) {

                   }
               });
                }
        });

        review.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1 || e.getButton() == MouseEvent.BUTTON3) {
                    sidePanel.removeAll();

                    JLabel heading = new JLabel("Enter a name OR id number");
                    JLabel name = new JLabel("Review By Name");
                    JLabel id = new JLabel("Review By Id Number");

                    JTextField empName = new JTextField();
                    JTextField empId = new JTextField();
                    JButton submit = new JButton("SUBMIT");

                    heading.setForeground(new Color(102, 0,153));
                    heading.setBounds(100, 10, 200, 30);
                    name.setBounds(10, 40, 150, 30);
                    empName.setBounds(10, 70, 100, 30);
                    id.setBounds(10, 100, 150, 30);
                    empId.setBounds(10, 130, 100, 30);
                    submit.setBounds(100, 190, 80, 30);
                    submit.setForeground(Color.blue);

                    sidePanel.add(heading);
                    sidePanel.add(name);
                    sidePanel.add(id);
                    sidePanel.add(empName);
                    sidePanel.add(empId);
                    sidePanel.add(submit);
                    sidePanel.updateUI();

                    submit.addActionListener(e14 -> {
                        if (!empName.getText().equals("")) {
                            try{
                                String [] names = empName.getText().split(" ", 2);
                                if (app.getEmployeeList().getEmployee(names[0].strip(), names[1].strip()) != null){
                                    sidePanel.removeAll();
                                    JLabel success = new JLabel();
                                    success.setText("<html>" + "SUCCESS" + "<br />" + app.getEmployeeList().getEmployee(names[0].strip(), names[1].strip()).toString() + "</html>");
                                    success.setBounds(10, 50, 300, 200);

                                    sidePanel.add(success);
                                    sidePanel.updateUI();
                                }
                            } catch (Exception exception) {
                                exception.printStackTrace();
                                error.setBounds(150, 250, 100, 30);
                                error.setForeground(Color.red);
                                sidePanel.add(error);
                                sidePanel.updateUI();
                            }
                        } else  if (!empId.getText().equals("") && app.getEmployeeList().getEmployee(Integer.parseInt(empId.getText())) != null) {
                            try {
                                if (!empId.getText().equals("") && app.getEmployeeList().getEmployee(Integer.parseInt(empId.getText())) != null) {
                                    sidePanel.removeAll();
                                    JLabel success = new JLabel();
                                    success.setText("<html>" + "SUCCESS" + "<br />" + app.getEmployeeList().getEmployee(Integer.parseInt(empId.getText())).toString() + "</html>");
                                    success.setBounds(10, 50, 100, 200);

                                    sidePanel.add(success);
                                    sidePanel.updateUI();
                                }
                            } catch (Exception ex) {
                                ex.printStackTrace();
                                error.setBounds(150, 250, 100, 30);
                                error.setForeground(Color.red);
                                sidePanel.add(error);
                                sidePanel.updateUI();
                            }
                        }
                    });
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        genPayslip.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                sidePanel.removeAll();
                JLabel fName = new JLabel("Employee First Name");
                JLabel lName = new JLabel("Employee Last Name");
                JLabel bonus = new JLabel("Optional - Bonus");
                JLabel deduction = new JLabel("Optional - Deductions");

                JTextArea name1 = new JTextArea();
                JTextArea name2 = new JTextArea();
                JTextArea bn = new JTextArea();
                JTextArea ded = new JTextArea();

                if (e.getButton() == MouseEvent.BUTTON1 || e.getButton() == MouseEvent.BUTTON3) {
                    fName.setBounds(10, 10, 200, 30);
                    name1.setBounds(10, 40, 100, 30);

                    lName.setBounds(10, 70, 200, 30);
                    name2.setBounds(10, 100, 100, 30);

                    bonus.setBounds(10, 130, 200, 30);
                    bn.setBounds(10, 160, 100, 30);

                    deduction.setBounds(10, 190, 200, 30);
                    ded.setBounds(10, 210, 100, 30);
                    JButton submit = new JButton("SUBMIT");

                    submit.setBounds(200, 250, 80, 30);
                    submit.setForeground(Color.blue);

                    sidePanel.add(fName);
                    sidePanel.add(lName);
                    sidePanel.add(bonus);
                    sidePanel.add(deduction);
                    sidePanel.add(name1);
                    sidePanel.add(name2);
                    sidePanel.add(bn);
                    sidePanel.add(ded);
                    sidePanel.add(submit);
                    sidePanel.updateUI();

                    submit.addActionListener(e1 -> {
                        try{
                            Employee emp1 = app.getEmployeeList().getEmployee(name1.getText().strip(), name2.getText().strip());
                            if (bn.getText()!=null && ded.getText()!=null) {
                                if (emp1 != null) {
                                    String name = emp1.getName().getFirstName() + " " + emp1.getName().getLastName();
                                    Payslip pay = new Payslip(name, emp1.getTRN(), emp1.getHours(), emp1.getEmployeeID(),
                                            app.getRate(emp1), Float.parseFloat(bn.getText()), Float.parseFloat(ded.getText()));
                                    app.PDF("payslips", pay.getPayslip(), pay.getName() + "Payslip", payslipNum);
                                    app.getPayslipList().addPayslip(pay);
                                    app.getEmployeeList().getEmployee(name1.getText().strip(), name2.getText().strip()).resetHours();
                                    payslipNum++;
                                    sidePanel.removeAll();
                                    JLabel success = new JLabel();
                                    success.setBounds(100, 100, 100, 30);
                                    success.setForeground(Color.green);
                                    sidePanel.add(success);
                                    sidePanel.updateUI();
                                }
                            } else {
                                String name = emp1.getName().getFirstName() + " " + emp1.getName().getLastName();
                                Payslip pay = new Payslip(name, emp1.getTRN(), emp1.getHours(), emp1.getEmployeeID(), app.getRate(emp1));
                                app.PDF("payslips", pay.getPayslip(),pay.getName() + "Payslip", payslipNum);
                                app.getPayslipList().addPayslip(pay);
                                app.getEmployeeList().getEmployee(name1.getText().strip(), name2.getText().strip()).resetHours();
                                payslipNum++;
                                sidePanel.removeAll();
                                JLabel success = new JLabel();
                                success.setBounds(250, 200, 100, 30);
                                success.setForeground(Color.green);
                                sidePanel.add(success);
                                sidePanel.updateUI();
                            }
                        } catch (Exception exception) {
                            exception.printStackTrace();
                            error.setBounds(250, 200, 100, 30);
                            error.setForeground(Color.red);
                            sidePanel.add(error);
                            sidePanel.updateUI();
                        }
                    });
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        genReport.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JLabel wait = new JLabel("Please Wait For Report To Be Generated");
                sidePanel.removeAll();

                wait.setBounds(100, 50, 300, 30);
                wait.setForeground(new Color(102, 0,153));

                sidePanel.add(wait);
                sidePanel.updateUI();

                try{
                    float total = 0;
                    float bonus = 0;
                    int size = app.getPayslipList().getList().size();
                    StringBuilder rpt = new StringBuilder();

                    if (app.getPayslipList().getList()!=null){
                        for (Payslip slip : app.getPayslipList().getList()){
                            rpt.append("A payslip was generated for ").append(slip.getName()).append(", and was paid ").append(slip.getSalary()).append(". With a bonus of ").append(slip.getBonus()).append(":");
                            total+=Float.parseFloat(slip.getSalary());
                            bonus+=slip.getBonus();
                        }

                        String [] employeeSlips = rpt.toString().split(":", -1);
                        Report newReport = new Report(size, bonus, total, employeeSlips);
                        app.PDF("reports", newReport.getReport(), "Report", reportNum);
                        reportNum++;
                        app.getReportList().addReport(newReport);

                        JLabel success = new JLabel();
                        success.setText("<html>" + "SUCCESS" + "<br />" + newReport.getReport() + "</html>");
                        success.setBounds(10, 80, 300, 300);
                        sidePanel.add(success);
                        sidePanel.updateUI();
                    }
                }
                catch (FileNotFoundException | DocumentException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                    error.setText("OOPS! There was an error.");
                    error.setBounds(100, 200, 100, 30);
                    error.setForeground(Color.red);
                    sidePanel.add(error);
                    sidePanel.updateUI();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        manageNotes.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1 || e.getButton() == MouseEvent.BUTTON3) {
                    sidePanel.removeAll();
                    JLabel create = new JLabel("Create A Note");
                    JLabel review = new JLabel("Review Note");
                    JLabel rmvNote = new JLabel("Remove A Note");

                    create.setBounds(10, 10, 150, 30);
                    review.setBounds(10, 40, 150, 30);
                    rmvNote.setBounds(10, 70, 150, 30);

                    sidePanel.add(create);
                    sidePanel.add(review);
                    sidePanel.add(rmvNote);
                    sidePanel.updateUI();

                    create.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            if (e.getButton() == MouseEvent.BUTTON1 || e.getButton() == MouseEvent.BUTTON3){
                                sidePanel.removeAll();

                                JLabel instruction = new JLabel("Enter the employee Id number AND the note");
                                JLabel id = new JLabel("Employee ID");
                                JLabel note = new JLabel("New Note");

                                JTextField idNum = new JTextField();
                                JTextField noteField = new JTextField();

                                instruction.setForeground(new Color(102, 0,153));
                                instruction.setBounds(20, 20, 200, 30);
                                id.setBounds(10, 50, 100, 30);
                                idNum.setBounds(10, 80, 100, 30);
                                note.setBounds(10, 110, 100, 30);
                                noteField.setBounds(10, 140, 100, 30);

                                JButton submit = new JButton("SUBMIT");
                                submit.setBounds(100, 180, 80, 30);
                                submit.setForeground(Color.blue);

                                sidePanel.add(instruction);
                                sidePanel.add(id);
                                sidePanel.add(idNum);
                                sidePanel.add(note);
                                sidePanel.add(noteField);
                                sidePanel.add(submit);
                                sidePanel.updateUI();

                                submit.addActionListener(e114 -> {
                                    if (!idNum.getText().strip().equals("") && !noteField.getText().strip().equals("") && app.getEmployeeList().getEmployee(Integer.parseInt(idNum.getText()))!=null){
                                        try {
                                            String name = app.getEmployeeList().getEmployee(Integer.parseInt(idNum.getText())).getName().getFirstName() + " "
                                                    + app.getEmployeeList().getEmployee(Integer.parseInt(idNum.getText())).getName().getLastName();

                                            Note newNote = new Note(name, Short.parseShort(idNum.getText()), noteField.getText().strip());
                                            app.PDF("notes", newNote.getNote(), newNote.getNoteName() + "Note", noteNum);
                                            noteNum++;
                                            app.getNoteList().addNote(newNote);

                                            sidePanel.removeAll();
                                            JLabel success = new JLabel();
                                            success.setText("<html>" + "SUCCESS" + "<br />" + "Note on employee with ID " + idNum.getText() + " successfully created." + "</html>");
                                            success.setBounds(10, 80, 300, 300);
                                            sidePanel.add(success);
                                            sidePanel.updateUI();

                                        } catch (DocumentException | FileNotFoundException documentException) {
                                            documentException.printStackTrace();
                                            error.setBounds(250, 100, 100, 30);
                                            error.setForeground(Color.red);
                                            sidePanel.add(error);
                                            sidePanel.updateUI();
                                        }
                                    } else {
                                        error.setBounds(250, 100, 100, 30);
                                        error.setForeground(Color.red);
                                        sidePanel.add(error);
                                        sidePanel.updateUI();
                                    }
                                });
                            }
                        }

                        @Override
                        public void mousePressed(MouseEvent e) {

                        }

                        @Override
                        public void mouseReleased(MouseEvent e) {

                        }

                        @Override
                        public void mouseEntered(MouseEvent e) {

                        }

                        @Override
                        public void mouseExited(MouseEvent e) {

                        }
                    });
                    review.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            if (e.getButton() == MouseEvent.BUTTON1 || e.getButton() == MouseEvent.BUTTON3) {
                                sidePanel.removeAll();

                                JLabel instruction = new JLabel("Enter employee name OR Id");
                                JLabel name = new JLabel("Employee Name");
                                JLabel id = new JLabel("Employee Id");

                                JTextField nameField = new JTextField();
                                JTextField idNum = new JTextField();
                                JButton submit = new JButton("SUBMIT");

                                instruction.setForeground(new Color(102, 0,153));
                                instruction.setBounds(20, 10, 200, 30);
                                name.setBounds(10, 40, 100, 30);
                                nameField.setBounds(10, 70, 100, 30);
                                id.setBounds(10, 100, 100, 30);
                                idNum.setBounds(10, 130, 100, 30);
                                submit.setBounds(100, 170, 80, 30);

                                sidePanel.add(instruction);
                                sidePanel.add(name);
                                sidePanel.add(nameField);
                                sidePanel.add(id);
                                sidePanel.add(idNum);
                                sidePanel.add(submit);
                                sidePanel.updateUI();

                                submit.addActionListener(e115 -> {
                                    try {
                                        String [] names = nameField.getText().split(" ", 2);
                                        if (!nameField.getText().strip().equals("") && app.getNoteList().getName(names[0].strip() + " " + names[1].strip()) != null) {
                                            try {
                                                sidePanel.removeAll();
                                                JLabel info = new JLabel("<html>" + app.getNoteList().getName(names[0].strip() + " " + names[1].strip()) + "</html>");
                                                info.setBounds(20, 10, 150, 300);

                                                sidePanel.add(info);
                                                sidePanel.updateUI();
                                            } catch (Exception exception) {
                                                exception.printStackTrace();
                                                error.setText("OOPS! There was an error.");
                                                error.setBounds(100, 200, 100, 30);
                                                error.setForeground(Color.red);
                                                sidePanel.add(error);
                                                sidePanel.updateUI();
                                            }
                                        } else if (!idNum.getText().strip().equals("") && app.getNoteList().getNoteId(Integer.parseInt(idNum.getText()))!=null) {
                                            sidePanel.removeAll();
                                            JLabel info = new JLabel ("<html>" + app.getNoteList().getNoteId(Integer.parseInt(idNum.getText())) + "</html>");
                                            info.setBounds(20, 10, 150, 300);

                                            sidePanel.add(info);
                                            sidePanel.updateUI();
                                        }
                                    } catch (Exception exception) {
                                        exception.printStackTrace();
                                        error.setText("OOPS! There was an error.");
                                        error.setBounds(100, 200, 100, 30);
                                        error.setForeground(Color.red);
                                        sidePanel.add(error);
                                        sidePanel.updateUI();
                                    }
                                });
                            }
                        }

                        @Override
                        public void mousePressed(MouseEvent e) {

                        }

                        @Override
                        public void mouseReleased(MouseEvent e) {

                        }

                        @Override
                        public void mouseEntered(MouseEvent e) {

                        }

                        @Override
                        public void mouseExited(MouseEvent e) {

                        }
                    });
                    rmvNote.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            if (e.getButton() == MouseEvent.BUTTON1 || e.getButton() == MouseEvent.BUTTON3) {
                                sidePanel.removeAll();

                                JLabel title = new JLabel("Enter the note number to be removed");
                                JLabel id = new JLabel("Note number");
                                JTextField idNum = new JTextField();

                                title.setForeground(new Color(102, 0,153));
                                title.setBounds(20, 20, 250, 30);
                                id.setBounds(10, 50, 100, 30);
                                idNum.setBounds(10, 80, 100, 30);

                                JButton submit = new JButton("SUBMIT");
                                submit.setForeground(Color.blue);
                                submit.setBounds(100, 120, 80,30);

                                sidePanel.add(title);
                                sidePanel.add(id);
                                sidePanel.add(idNum);
                                sidePanel.add(submit);
                                sidePanel.updateUI();

                                submit.addActionListener(e116 -> {
                                    if (!idNum.getText().strip().equals("") && app.getNoteList().getNoteId(Integer.parseInt(idNum.getText()))!=null) {
                                        try {
                                            app.getNoteList().removeNote(Integer.parseInt(idNum.getText())-1);
                                            sidePanel.removeAll();
                                            JLabel success = new JLabel("SUCCESS! Note deleted.");

                                            success.setBounds(20, 20, 300, 30);
                                            sidePanel.add(success);
                                            sidePanel.updateUI();
                                        } catch (NumberFormatException numberFormatException) {
                                            numberFormatException.printStackTrace();
                                            error.setBounds(250, 100, 100, 30);
                                            error.setForeground(Color.red);
                                            sidePanel.add(error);
                                            sidePanel.updateUI();
                                        }
                                    }
                                });
                            }
                        }

                        @Override
                        public void mousePressed(MouseEvent e) {

                        }

                        @Override
                        public void mouseReleased(MouseEvent e) {

                        }

                        @Override
                        public void mouseEntered(MouseEvent e) {

                        }

                        @Override
                        public void mouseExited(MouseEvent e) {

                        }
                    });
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        eval.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        frame.add(mainPanel);
        frame.add(sidePanel);
        frame.add(exitBtn);
        frame.setVisible(true);
    }

    public void letsGo (PayApp app) {
        JPanel mainPanel = new JPanel();
        JPanel sidePanel = new JPanel();
        JFrame frame  = new JFrame("Sunnyside Payment System");
        frame.setSize(700,650);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);

        mainPanel.setBounds(10, 10, 250, 250);
        sidePanel.setBounds(270, 10, 400, 500);
        mainPanel.setBackground(Color.lightGray);
        sidePanel.setBackground(Color.lightGray);
        exitBtn.setBounds(300, 530, 80, 25);
        exitBtn.setForeground(Color.red);

        mainPanel.setLayout(null);
        sidePanel.setLayout(null);

        genPayslip.setBounds(10, 10, 200, 30);

        review.setBounds(10, 40, 200, 30);
        mainPanel.add(review);
        mainPanel.add(genPayslip);

        genReport.setBounds(10, 70, 200, 30);
        mainPanel.add(genReport);

        genPayslip.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                sidePanel.removeAll();
                JLabel fName = new JLabel("Employee First Name");
                JLabel lName = new JLabel("Employee Last Name");
                JLabel bonus = new JLabel("Optional - Bonus");
                JLabel deduction = new JLabel("Optional - Deductions");

                JTextArea name1 = new JTextArea();
                JTextArea name2 = new JTextArea();
                JTextArea bn = new JTextArea();
                JTextArea ded = new JTextArea();

                if (e.getButton() == MouseEvent.BUTTON1 || e.getButton() == MouseEvent.BUTTON3) {
                    fName.setBounds(10, 10, 200, 30);
                    name1.setBounds(10, 40, 100, 30);

                    lName.setBounds(10, 70, 200, 30);
                    name2.setBounds(10, 100, 100, 30);

                    bonus.setBounds(10, 130, 200, 30);
                    bn.setBounds(10, 160, 100, 30);

                    deduction.setBounds(10, 190, 200, 30);
                    ded.setBounds(10, 210, 100, 30);
                    JButton submit = new JButton("SUBMIT");

                    submit.setBounds(200, 250, 80, 30);
                    submit.setForeground(Color.blue);

                    sidePanel.add(fName);
                    sidePanel.add(lName);
                    sidePanel.add(bonus);
                    sidePanel.add(deduction);
                    sidePanel.add(name1);
                    sidePanel.add(name2);
                    sidePanel.add(bn);
                    sidePanel.add(ded);
                    sidePanel.add(submit);
                    sidePanel.updateUI();

                    submit.addActionListener(e1 -> {
                        try{
                            Employee emp1 = app.getEmployeeList().getEmployee(name1.getText().strip(), name2.getText().strip());
                            if (bn.getText()!=null && ded.getText()!=null) {
                                if (emp1 != null) {
                                    String name = emp1.getName().getFirstName() + " " + emp1.getName().getLastName();
                                    Payslip pay = new Payslip(name, emp1.getTRN(), emp1.getHours(), emp1.getEmployeeID(),
                                            app.getRate(emp1), Float.parseFloat(bn.getText()), Float.parseFloat(ded.getText()));
                                    app.PDF("payslips", pay.getPayslip(), pay.getName() + "Payslip", payslipNum);
                                    app.getPayslipList().addPayslip(pay);
                                    app.getEmployeeList().getEmployee(name1.getText().strip(), name2.getText().strip()).resetHours();
                                    payslipNum++;
                                    sidePanel.removeAll();
                                    JLabel success = new JLabel();
                                    success.setBounds(100, 100, 100, 30);
                                    success.setForeground(Color.green);
                                    sidePanel.add(success);
                                    sidePanel.updateUI();
                                }
                            } else {
                                String name = emp1.getName().getFirstName() + " " + emp1.getName().getLastName();
                                Payslip pay = new Payslip(name, emp1.getTRN(), emp1.getHours(), emp1.getEmployeeID(), app.getRate(emp1));
                                app.PDF("payslips", pay.getPayslip(),pay.getName() + "Payslip", payslipNum);
                                app.getPayslipList().addPayslip(pay);
                                app.getEmployeeList().getEmployee(name1.getText().strip(), name2.getText().strip()).resetHours();
                                payslipNum++;
                                sidePanel.removeAll();
                                JLabel success = new JLabel();
                                success.setBounds(250, 200, 100, 30);
                                success.setForeground(Color.green);
                                sidePanel.add(success);
                                sidePanel.updateUI();
                            }
                        } catch (Exception exception) {
                            exception.printStackTrace();
                            error.setBounds(250, 200, 100, 30);
                            error.setForeground(Color.red);
                            sidePanel.add(error);
                            sidePanel.updateUI();
                        }
                    });
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        review.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1 || e.getButton() == MouseEvent.BUTTON3) {
                    sidePanel.removeAll();

                    JLabel heading = new JLabel("Enter a name OR id number");
                    JLabel name = new JLabel("Review By Name");
                    JLabel id = new JLabel("Review By Id Number");

                    JTextField empName = new JTextField();
                    JTextField empId = new JTextField();
                    JButton submit = new JButton("SUBMIT");

                    heading.setForeground(new Color(102, 0,153));
                    heading.setBounds(100, 10, 200, 30);
                    name.setBounds(10, 40, 150, 30);
                    empName.setBounds(10, 70, 100, 30);
                    id.setBounds(10, 100, 150, 30);
                    empId.setBounds(10, 130, 100, 30);
                    submit.setBounds(100, 190, 80, 30);
                    submit.setForeground(Color.blue);

                    sidePanel.add(heading);
                    sidePanel.add(name);
                    sidePanel.add(id);
                    sidePanel.add(empName);
                    sidePanel.add(empId);
                    sidePanel.add(submit);
                    sidePanel.updateUI();

                    submit.addActionListener(e14 -> {
                        if (!empName.getText().equals("")) {
                            try{
                                String [] names = empName.getText().split(" ", 2);
                                if (app.getEmployeeList().getEmployee(names[0].strip(), names[1].strip()) != null){
                                    sidePanel.removeAll();
                                    JLabel success = new JLabel();
                                    success.setText("<html>" + "SUCCESS" + "<br />" + app.getEmployeeList().getEmployee(names[0].strip(), names[1].strip()).toString() + "</html>");
                                    success.setBounds(10, 50, 300, 200);

                                    sidePanel.add(success);
                                    sidePanel.updateUI();
                                }
                            } catch (Exception exception) {
                                exception.printStackTrace();
                                error.setBounds(150, 250, 100, 30);
                                error.setForeground(Color.red);
                                sidePanel.add(error);
                                sidePanel.updateUI();
                            }
                        } else  if (!empId.getText().equals("") && app.getEmployeeList().getEmployee(Integer.parseInt(empId.getText())) != null) {
                            try {
                                if (!empId.getText().equals("") && app.getEmployeeList().getEmployee(Integer.parseInt(empId.getText())) != null) {
                                    sidePanel.removeAll();
                                    JLabel success = new JLabel();
                                    success.setText("<html>" + "SUCCESS" + "<br />" + app.getEmployeeList().getEmployee(Integer.parseInt(empId.getText())).toString() + "</html>");
                                    success.setBounds(10, 50, 100, 200);

                                    sidePanel.add(success);
                                    sidePanel.updateUI();
                                }
                            } catch (Exception ex) {
                                ex.printStackTrace();
                                error.setBounds(150, 250, 100, 30);
                                error.setForeground(Color.red);
                                sidePanel.add(error);
                                sidePanel.updateUI();
                            }
                        }
                    });
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        genReport.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JLabel wait = new JLabel("Please Wait For Report To Be Generated");
                sidePanel.removeAll();

                wait.setBounds(100, 50, 300, 30);
                wait.setForeground(new Color(102, 0,153));

                sidePanel.add(wait);
                sidePanel.updateUI();

                try{
                    float total = 0;
                    float bonus = 0;
                    int size = app.getPayslipList().getList().size();
                    StringBuilder rpt = new StringBuilder();

                    if (app.getPayslipList().getList()!=null){
                        for (Payslip slip : app.getPayslipList().getList()){
                            rpt.append("A payslip was generated for ").append(slip.getName()).append(", and was paid ").append(slip.getSalary()).append(". With a bonus of ").append(slip.getBonus()).append(":");
                            total+=Float.parseFloat(slip.getSalary());
                            bonus+=slip.getBonus();
                        }

                        String [] employeeSlips = rpt.toString().split(":", -1);
                        Report newReport = new Report(size, bonus, total, employeeSlips);
                        app.PDF("reports", newReport.getReport(), "Report", reportNum);
                        reportNum++;
                        app.getReportList().addReport(newReport);

                        JLabel success = new JLabel();
                        success.setText("<html>" + "SUCCESS" + "<br />" + newReport.getReport() + "</html>");
                        success.setBounds(10, 80, 400, 500);
                        sidePanel.add(success);
                        sidePanel.updateUI();
                    }
                }
                catch (FileNotFoundException | DocumentException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                    error.setBounds(250, 200, 100, 30);
                    error.setForeground(Color.red);
                    sidePanel.add(error);
                    sidePanel.updateUI();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        frame.add(mainPanel);
        frame.add(sidePanel);
        frame.add(exitBtn);
        frame.setVisible(true);
    }
}