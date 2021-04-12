package ui;

import app.PayApp;
import paysys.*;

import java.util.Scanner;

public class TextUI {
    public int selection;
    static int payslipNum = 1;
    static int reportNum = 1;
    static int noteNum = 1;

    public void start(PayApp app) {
        Scanner input = new Scanner(System.in);

        System.out.println("\n+++++++++++++++++++ WELCOME TO SUNNYSIDE BEAUTY SUPPLIES PAYMENT SYSTEM +++++++++++++++++++\n");
        System.out.println("Manager's Interface");
        System.out.println("""
                1) Manage Employee Records
                2) Generate A Payslip
                3) Review Employees
                4) Manage Notes\s
                5) Generate A Report
                6) Display All\s
                7) Exit System""".indent(1));
        System.out.println("\nSelect A Number Between 1 & 7: ");

        try {
            selection=input.nextInt();
            while (selection!=7) {
                if (selection == 1) {
                    System.out.println("""
                            Manage Employee Records. Select From The options Below.
                                                        
                            1. Add an Employee\s
                            2. Remove an Employee\s
                            3. Update Employee Names\s
                            4. Update Employee Addresses\s
                            5. Update Employee Hours""");
                    Scanner choose = new Scanner(System.in);
                    int choice1 = choose.nextInt();

                    if (choice1 == 1) {
                        System.out.println("""
                                Enter Employee Details.\tFormat Required - 234567890, 03/03/1986, F 0R M, Jane, Doe, Wright, Jamaica, Westmoreland,Sav,Great Georges Street, 0 OR 1,24.6
                                OR 123456789, 03/03/1986, F 0R M, Jane, Doe, Wright, 0 OR 1""");
                        Scanner newEmp = new Scanner(System.in);

                        try {
                            String line = newEmp.nextLine().strip();
                            String[] empArr = line.split(",", -1);

                            if (empArr.length == 12) {
                                Employee newEmployee = new Employee((Integer.parseInt(empArr[0])), empArr[1].strip(), empArr[2].strip().charAt(0),
                                        PayApp.newID, empArr[3].strip(), empArr[4].strip(), empArr[5].strip(), empArr[6].strip(), empArr[7].strip(), empArr[8].strip(),
                                        empArr[9].strip(), (byte) Integer.parseInt(empArr[10].strip()), Float.parseFloat(empArr[11]));
                                app.getEmployeeList().addEmployee(newEmployee);
                                System.out.println("Success! A New Employee Has Been Created.");
                                PayApp.newID++;

                            } else if (empArr.length == 8) {
                                Employee newEmployee = new Employee((Integer.parseInt(empArr[0])), empArr[1].strip(), empArr[2].strip().charAt(0),
                                        PayApp.newID, empArr[3].strip(), empArr[4].strip(), empArr[5].strip(), (byte) Integer.parseInt(empArr[6].strip()));
                                newEmployee.setEmployeeID(PayApp.newID);
                                app.getEmployeeList().addEmployee(newEmployee);
                                System.out.println("Success! A New Employee Has Been Created.");
                                PayApp.newID++;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("OOPS! You Entered Something Wrong.");
                        }


                    } else if (choice1 == 2) {
                        System.out.println("Enter The Name OR ID For Employee You Want To Delete.\tRequired Format - Jane Doe OR 10");
                        Scanner oldEmp = new Scanner(System.in);
                        String  line = oldEmp.nextLine().strip();

                        try {
                            int id = Integer.parseInt(line);
                            System.out.println("Employee Record " + app.getEmployeeList().getEmployee(id).toString() + "\nWas Successfully Removed!\n");
                            app.getEmployeeList().removeEmployee(id);
                        } catch (NumberFormatException e) {
                            try {
                                String [] names = line.split(" ");
                                app.getEmployeeList().removeEmployee(names[0].strip(), names[1].strip());
                                System.out.println("Employee record with name " + names[0].strip() + " " + names[1].strip() + " was successfully removed!\n");

                            } catch (Exception exception) {
                                System.out.println("OOPS! There was an error. Please try again.");
                            }
                        }

                    } else if (choice1 == 3) {
                        System.out.println(" 1) Change First Name\n 2) Change Middle Name\n 3) Change Last Name\nSelect An Option From Above\n");
                        Scanner nameChange = new Scanner(System.in);
                        int change1 = nameChange.nextInt();

                        if (change1 == 1) {
                            try {
                                System.out.println("Enter Employee ID And New First Name\n Required Format - 10, Mary");
                                Scanner fName = new Scanner(System.in);
                                String fLine = fName.nextLine().strip();
                                String[] nameArr = fLine.split(",");
                                app.getEmployeeList().getEmployee(Integer.parseInt(nameArr[0])).getName().setFirstName(nameArr[1].strip());
                                System.out.println("SUCCESS! First name of employee with id " + nameArr[0].strip() + " has been changed.");
                            } catch (NumberFormatException e) {
                                System.out.println("OOPS! You Entered Something Wrong.");
                            }

                        } else if (change1 == 2) {
                            try {
                                System.out.println("Enter Employee Number And New Middle Name\n Required Format - 11, James");
                                Scanner mName = new Scanner(System.in);
                                String mLine = mName.nextLine().strip();
                                String[] nameArr = mLine.split(",");
                                app.getEmployeeList().getEmployee(Integer.parseInt(nameArr[0])).getName().setMiddleName(nameArr[1].strip());
                                System.out.println("SUCCESS! Middle name of employee with id " + nameArr[0].strip() + " has been changed.");
                            } catch (NumberFormatException e) {
                                System.out.println("OOPS! You Entered Something Wrong.");
                            }

                        } else if (change1 == 3) {
                            try {
                                System.out.println("Enter Employee Number And New Last Name\n Required Format - 12, Jones");
                                Scanner lName = new Scanner(System.in);
                                String lLine = lName.nextLine().strip();
                                String[] nameArr = lLine.split(",");
                                app.getEmployeeList().getEmployee(Integer.parseInt(nameArr[0])).getName().setLastName(nameArr[1].strip());
                                System.out.println("SUCCESS! Last name of employee with id " + nameArr[0].strip() + " has been changed.");
                            } catch (NumberFormatException e) {
                                System.out.println("OOPS! You Entered Something Wrong.");
                            }
                        }

                    } else if (choice1 == 4) {
                        System.out.println(" 1) An Address Information\n 2) Change Parish\n 3) Change Town\n 4) Change Street\n");
                        System.out.println("Select An Option From Above");
                        Scanner addressChange = new Scanner(System.in);
                        int change2 = addressChange.nextInt();

                        if (change2 == 1) {
                            try {
                                System.out.println("Enter Employee ID And Complete Address \n Required Format - 9, Jamaica, St. Ann, Ocho Rios, Union Street\n");
                                Scanner addr = new Scanner(System.in);
                                String addLine = addr.nextLine().strip();
                                String[] addrArr = addLine.split(",", -1);
                                app.getEmployeeList().getEmployee(Integer.parseInt(addrArr[0])).setAddress(new Address(addrArr[1].strip(),
                                        addrArr[2].strip(), addrArr[3].strip(), addrArr[4].strip()));
                                System.out.println("SUCCESS! Address " + app.getEmployeeList().getEmployee(Integer.parseInt(addrArr[0])).getAddress().toString()
                                        + " has been added to employee with id " + addrArr[0].strip() + " record.");
                            } catch (NumberFormatException e) {
                                System.out.println("OOPS! You Entered Something Wrong.");
                            }

                        } else if (change2 == 2) {
                            try {
                                System.out.println("Enter Employee ID And New Parish\n Required Format - 13, St. James\n");
                                Scanner parish = new Scanner(System.in);
                                String newParish = parish.nextLine();
                                String[] pArr = newParish.split(",", -1);
                                app.getEmployeeList().getEmployee(Integer.parseInt(pArr[0])).getAddress().setParish(pArr[1].strip());
                                System.out.println("SUCCESS! Address of employee with id " + pArr[0].strip() + " was changed.");
                            } catch (NumberFormatException e) {
                                System.out.println("OOPS! You Entered Something Wrong.");
                            }

                        } else if (change2 == 3) {
                            try {
                                System.out.println("Enter Employee ID And New Town\n Required Format - 14, Bouge Village\n");
                                Scanner town = new Scanner(System.in);
                                String newTown = town.nextLine();
                                String[] tArr = newTown.split(",", -1);
                                app.getEmployeeList().getEmployee(Integer.parseInt(tArr[0])).getAddress().setTown(tArr[1].strip());
                                System.out.println("SUCCESS! Address of employee with id " + tArr[0].strip() + " was changed.");
                            } catch (NumberFormatException e) {
                                System.out.println("OOPS! You Entered Something Wrong.");
                            }

                        } else if (change2 == 4) {
                            try {
                                System.out.println("Enter Employee ID And New Street\n Required Format - 15, Civic Drive\n");
                                Scanner street = new Scanner(System.in);
                                String newStreet = street.nextLine();
                                String[] sArr = newStreet.split(",", -1);
                                app.getEmployeeList().getEmployee(Integer.parseInt(sArr[0])).getAddress().setParish(sArr[1].strip());
                                System.out.println("SUCCESS! Address of employee with id " + app.getEmployeeList().getEmployee(Integer.parseInt(sArr[0])).getEmployeeID()
                                        + " was changed.");
                            } catch (NumberFormatException e) {
                                System.out.println("OOPS! You Entered Something Wrong.");
                            }
                        }
                    } else if (choice1 == 5) {
                        System.out.println(" 1) Add Hours\n 2) Subtract Hours\nSelect An Option From Above");
                        Scanner newHours = new Scanner(System.in);
                        int change3 = newHours.nextInt();

                        if (change3 == 1){
                            try {
                                System.out.println("Enter The Employee ID And Hours You Wish To Add\n Required Format - 1, 6.5\n");
                                Scanner addHrs = new Scanner(System.in);
                                String hrs = addHrs.nextLine();
                                String[] hrsArr = hrs.split(",");
                                app.getEmployeeList().getEmployee(Integer.parseInt(hrsArr[0])).setHours(Float.parseFloat(hrsArr[1]));

                                System.out.println(hrsArr[1].strip() + " Hours Has Been Added To Employee With ID " + hrsArr[0].strip() + " Record");
                            } catch (NumberFormatException numberFormatException) {
                                System.out.println("OOPS! You Entered Something Wrong.");
                            }
                        } else if (change3 == 2) {
                            try {
                                System.out.println("Enter The Employee ID And Hours You Wish To Remove\n Required Format - 2, 3\n");
                                Scanner remHrs = new Scanner(System.in);
                                String hrs = remHrs.nextLine().strip();
                                String[] hrsArr = hrs.split(",");

                                if (app.getEmployeeList().getEmployee(Integer.parseInt(hrsArr[0])).getHours() > Float.parseFloat(hrsArr[1])) {
                                    app.getEmployeeList().getEmployee(Integer.parseInt(hrsArr[0])).takeHours(Float.parseFloat(hrsArr[1]));
                                    System.out.println(hrsArr[1].strip() + " Hours Has Been Removed From Employee With ID "
                                            + hrsArr[0].strip() + " Record");
                                } else {
                                    System.out.println("DENIED! Not Enough Hours On Employee Record.");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("OOPS! You Entered Something Wrong.");
                            }
                        }
                    }
                } else if (selection == 2) {
                    System.out.println(" Enter Employee Name To Generate Payslip. Bonus And Deductions Are Optional\n Format Required - Jane Doe OR Jane Doe,3000,1200\n\n");

                    Scanner paySlip = new Scanner(System.in);
                    String slip = paySlip.nextLine();
                    String[] slipArr = slip.split(",");
                    String[] names = slipArr[0].split(" ");

                    if (slipArr.length == 3) {
                        Employee emp1 = app.getEmployeeList().getEmployee(names[0].strip(), names[1].strip());

                        if (emp1 != null) {
                            String name = emp1.getName().getFirstName() + " " + emp1.getName().getLastName();
                            Payslip pay = new Payslip(name, emp1.getTRN(), emp1.getHours(), emp1.getEmployeeID(),
                                    app.getRate(emp1), Float.parseFloat(slipArr[1]), Float.parseFloat(slipArr[2]));
                            app.PDF("payslips", pay.getPayslip(),pay.getName() + "Payslip", payslipNum);
                            app.getPayslipList().addPayslip(pay);
                            app.getEmployeeList().getEmployee(names[0].strip(), names[1].strip()).resetHours();
                            payslipNum++;
                            System.out.println("Payslip Generated Successfully. See Below\n\n" + pay.getPayslip() + "\n");
                        } else {
                            System.out.println("OOPS!! No record was found for employee " + names[0] + " " + names[0] + "\n");
                        }
                    } else if (slipArr.length == 1) {
                        Employee emp1 = app.getEmployeeList().getEmployee(names[0].strip(), names[1].strip());

                        if (emp1 != null) {
                            String name = emp1.getName().getFirstName() + " " + emp1.getName().getLastName();
                            Payslip pay = new Payslip(name, emp1.getTRN(), emp1.getHours(), emp1.getEmployeeID(), app.getRate(emp1));
                            app.PDF("payslips", pay.getPayslip(),pay.getName() + "Payslip", payslipNum);
                            app.getPayslipList().addPayslip(pay);
                            app.getEmployeeList().getEmployee(names[0].strip(), names[1].strip()).resetHours();
                            payslipNum++;
                            System.out.println("Payslip Generated Successfully. See Below\n\n" + pay.getPayslip() + "\n");
                        } else {
                            System.out.println("OOPS!! No record was found for employee " + names[0] + " " + names[0] + "\n");
                        }
                    }
                } else if (selection==3){
                    System.out.println(" 1) Search By ID\n 2) Search By Name\n\n");
                    System.out.println("Select Option From Above\n");

                    Scanner search = new Scanner(System.in);
                    int choice3;
                    choice3 = search.nextInt();

                    if (choice3 == 1) {
                        System.out.println("Enter Employee Number Of The Desired Employee\nFormat Required - 9 ");
                        Scanner searchID = new Scanner(System.in);
                        short iD = searchID.nextShort();

                        System.out.println(app.getEmployeeList().getEmployee(iD).toString() + "\n");
                        app.getPayslipList().getPayslip(iD);

                    } else if (choice3 == 2) {
                        System.out.println("Enter The Full Name Of The Desired Employee\nFormat Required - Mary Jane\n");
                        Scanner searchName = new Scanner(System.in);
                        String name = searchName.nextLine().strip();
                        String[] nameArr = name.split("\\s", 2);
                        String fName = nameArr[0].strip();
                        String lName = nameArr[1].strip();
                        if (app.getEmployeeList().getEmployee(fName, lName) != null) {
                            System.out.println(app.getEmployeeList().getEmployee(fName, lName) + "\n\n");
                            String nameIn = fName + " " + lName;

                            System.out.println(app.getPayslipList().getPayslipName(nameIn) + "\n\n");
                        } else {
                            System.out.println("OOPS! " + fName + " " + lName + " could not be found.\n");
                        }
                    }
                } else if (selection==4){
                    System.out.println(" 1) Create A Note\n 2) Review Notes\n 3) Remove A Note\n");
                    System.out.println("Select An option Above");

                    int choice4;
                    Scanner noteLine = new Scanner(System.in);
                    choice4 = noteLine.nextInt();

                    if (choice4 == 1) {
                        System.out.println("Enter The Employee ID Number AND The Notes To Be Added\nFormat Required - 14,This is a hard working employee.\n");

                        Scanner makeNote = new Scanner(System.in);
                        String note = makeNote.nextLine().strip();
                        String[] noteArr = note.split(",",2);

                        if (app.getEmployeeList().getEmployee(Integer.parseInt(noteArr[0])) != null){
                            String name = app.getEmployeeList().getEmployee(Integer.parseInt(noteArr[0])).getName().getFirstName() + " "
                                    + app.getEmployeeList().getEmployee(Integer.parseInt(noteArr[0])).getName().getLastName();

                            Note newNote = new Note(name, Short.parseShort(noteArr[0].strip()) , noteArr[1].strip());
                            app.PDF("notes", newNote.getNote(), newNote.getNoteName() + "Note", noteNum);
                            noteNum++;
                            app.getNoteList().addNote(newNote);
                            System.out.println("Note on employee with ID " + noteArr[0].strip() + " successfully created.");
                        }
                    } else if (choice4==2){
                        System.out.println("1) Search By ID\n2) Search By Name");
                        System.out.println("Select An option Above\n");
                        Scanner chose = new Scanner(System.in);
                        int chose1 = chose.nextInt();

                        if (chose1==1){
                            System.out.println("Enter The Employee ID Number To Find Notes\nFormat Required - 12\n");

                            Scanner getNote = new Scanner(System.in);
                            int id = getNote.nextInt();
                            app.getNoteList().getNoteId(id);

                        } else if (chose1==2){
                            System.out.println("Enter The Employee Name To Find Notes\nFormat Required - John Doe");

                            Scanner noteName = new Scanner(System.in);
                            String [] name = noteName.nextLine().split(" ");
                            app.getNoteList().getName(name[0].strip() + " " + name[1].strip());
                        }
                    }else if (choice4==3) {
                        System.out.println("Enter The Number Of The Note You Wish To Delete From The List Below\n");
                        app.getNoteList().getAll();
                        Scanner noteNumber = new Scanner(System.in);

                        int number = noteNumber.nextInt();
                        try {
                            app.getNoteList().removeNote(number-1);
                            System.out.println("SUCCESS! Note deleted.");
                        } catch (Exception exception) {
                            System.out.println("OOPS! There is no note to remove.");
                        }
                    }
                } else if (selection==5){
                    System.out.println("\nPlease Wait For Report To Be Generated.\n\n");
                    float total = 0;
                    float bonus = 0;
                    int size = app.getReportList().getList().size();
                    StringBuilder rpt = new StringBuilder();

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

                    System.out.println("SUCCESS! Report generated.");
                }

                System.out.println("\n+++++++++++++++++++ WELCOME TO SUNNYSIDE BEAUTY SUPPLIES PAYMENT SYSTEM +++++++++++++++++++\n");
                System.out.println("""
                        1) Manage Employee Records
                        2) Generate A Payslip
                        3) Review Employees
                        4) Manage Notes\s
                        5) Generate Report
                        6) Display All\s
                        7) Exit System""".indent(1));
                System.out.println("\nSelect A Number Between 1 & 7: ");
                selection = input.nextInt();
            }

            System.out.println("\nTHANK YOU FOR USING THE APPLICATION");
            app.shutDown();
        } catch (Exception e) {
            System.out.println("\nOOPS! Something Incorrect Was Entered. Please Try Again\n");
        }
    }

    public void letsGo (PayApp app) {
        System.out.println("\n+++++++++++++++++++ WELCOME TO SUNNYSIDE BEAUTY SUPPLIES PAYMENT SYSTEM +++++++++++++++++++\n");
        System.out.print("Accountant Interface\n\n");
        System.out.println("Select One Of The Options Below\n\n");
        System.out.println("\n1) Generate Payslip \n2) Review Employee History \n3) Generate Report \n5) Exit\n");

        Scanner accountant = new Scanner(System.in);
        try {
            int select = accountant.nextInt();

            while (select != 5) {
                if (select == 1) {
                    System.out.println(" Enter Employee Name To Generate Payslip, Bonus And Deductions Are Optional\n Format Required - Jane Doe OR Jane Doe,3000,1200\n\n");

                    Scanner paySlip = new Scanner(System.in);
                    String slip = paySlip.nextLine();

                    if (slip.split(",").length==3) {
                        String[] slipArr = slip.split(",");
                        String [] names = slipArr[0].split(" ");

                        Employee emp1 = app.getEmployeeList().getEmployee(names[0].strip(), names[1].strip());

                        if (emp1 != null) {
                            String name = emp1.getName().getFirstName() + " " + emp1.getName().getLastName();
                            Payslip pay = new Payslip(name , emp1.getTRN(), emp1.getHours(), emp1.getEmployeeID(),
                                    app.getRate(emp1), Float.parseFloat(slipArr[1]), Float.parseFloat(slipArr[2]));
                            app.PDF("payslips", pay.getPayslip(),pay.getName() + "Payslip", payslipNum);
                            app.getPayslipList().addPayslip(pay);
                            payslipNum++;
                            System.out.println("Payslip Generated Successfully. See Below\n\n" + pay.getPayslip()+"\n");
                        } else {
                            System.out.println("OOPS!! No record was found for employee "+ names[0] + " " + names[0] + "\n");
                        }

                    } else if (slip.split(" ").length==2) {
                        String [] names = slip.split(" ");
                        Employee emp1 = app.getEmployeeList().getEmployee(names[0].strip(), names[1].strip());

                        if (emp1 != null) {
                            String name = emp1.getName().getFirstName() + " " + emp1.getName().getLastName();
                            Payslip pay = new Payslip(name, emp1.getTRN(), emp1.getHours(), emp1.getEmployeeID(), app.getRate(emp1));
                            app.PDF("payslips", pay.getPayslip(), pay.getName() + "Payslip", payslipNum);
                            app.getPayslipList().addPayslip(pay);
                            payslipNum++;
                            System.out.println("Payslip Generated Successfully. See Below\n\n" + pay.getPayslip()+"\n");
                        } else {
                            System.out.println("OOPS!! No record was found for employee "+ names[0] + " " + names[0] + "\n");
                        }
                    }

                } else if (select==2) {
                    System.out.println(" 1) Search By ID\n 2) Search By Name\n\n");
                    System.out.println("Select An option Above\n");

                    int choice3;
                    Scanner nameChange = new Scanner(System.in);
                    choice3 = nameChange.nextInt();

                    if (choice3 == 1) {
                        System.out.println("Enter Employee Number Of The Desired Employee\nFormat Required - 9 ");
                        Scanner searchID = new Scanner(System.in);
                        short iD = searchID.nextShort();

                        System.out.println(app.getEmployeeList().getEmployee(iD).toString() + "\n");
                        app.getPayslipList().getPayslip(iD);

                    } else if (choice3 == 2) {
                        System.out.println("Enter The Full Name Of The Desired Employee\nFormat Required - Mary Jane\n");
                        Scanner searchName = new Scanner(System.in);
                        String name = searchName.nextLine().strip();
                        String[] nameArr = name.split("\\s", 2);
                        String fName = nameArr[0].strip();
                        String lName = nameArr[1].strip();
                        if (app.getEmployeeList().getEmployee(fName, lName) != null) {
                            System.out.println(app.getEmployeeList().getEmployee(fName, lName) + "\n\n");
                            String nameIn = fName + " " + lName;

                            System.out.println(app.getPayslipList().getPayslipName(nameIn) + "\n\n");
                        } else {
                            System.out.println("OOPS! " + fName + " " + lName + " could not be found.\n");
                        }
                    }
                } else if (select==3) {
                    System.out.println("\nPlease Wait For Report To Be Generated.\n\n");
                    float total = 0;
                    float bonus = 0;
                    int size = app.getEmployeeList().size();
                    StringBuilder rpt = new StringBuilder();

                    for (Payslip slip : app.getPayslipList().getList()){
                        rpt.append("A payslip was generated for ").append(slip.getName()).append(", and was paid ").append(slip.getSalary()).append(". With a bonus of ").append(slip.getBonus()).append(":");
                        total+=Float.parseFloat(slip.getSalary());
                        bonus+=slip.getBonus();
                    }

                    String [] employeeSlips = rpt.toString().split(":", -1) ;
                    Report newReport = new Report(size, bonus, total, employeeSlips);
                    app.PDF("reports", newReport.getReport(), "Report", reportNum);
                    reportNum++;
                    app.getReportList().addReport(newReport);

                    System.out.println("SUCCESS! Report generated.");
                }
                System.out.print("\nWelcome to the Accountant Interface\n\n");
                System.out.println("Select One Of The Options Below\n\n");
                System.out.println("\n1) Generate Payslip \n2) Review Employee History \n3) Generate Report \n5. Exit\n");

                select = accountant.nextInt();
            }
            System.out.println("\n\n\t\t\tTHANK YOU FOR USING THE APPLICATION\n\n");
            app.shutDown();

        } catch (Exception e) {
            e.printStackTrace();
            //System.out.println("An Error Occurred. Please Try Again");
        }
    }
}