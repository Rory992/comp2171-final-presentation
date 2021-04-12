package app;

import collections.ManageEmployees;
import collections.ManageNotes;
import collections.ManagePayslips;
import collections.ManageReports;
import infoDb.PaySysDb;
import paysys.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

public class PayApp {
    private PaySysDb employeeData;
    private PaySysDb paySlipData;
    private PaySysDb notesData;
    private PaySysDb reportData;
    private ManageEmployees employeeCollection;
    private ManagePayslips payslipCollection;
    private ManageNotes notesCollection;
    private ManageReports reportCollection;
    public static short newID = 7;
    public final float snrRate = 212.5F;
    public final float jnrRate = 198.8F;


    public PayApp(String employeeFile, String payFile, String noteFile, String reportFile, char delimiter) throws IOException {
        employeeData = new PaySysDb(employeeFile, delimiter);
        paySlipData = new PaySysDb(payFile, delimiter);
        notesData = new PaySysDb(noteFile, delimiter);
        reportData = new PaySysDb(reportFile, delimiter);

        ArrayList<Employee> employeeList = new ArrayList<>();
        ArrayList<Payslip> paySlipList = new ArrayList<>();
        ArrayList<Note> noteList = new ArrayList<>();
        ArrayList<Report> reportList = new ArrayList<>();

        while (employeeData.hasNext()) {
            String[] parts = employeeData.getNext();

            String middleName;

            int trn = Integer.parseInt(parts[0]);
            char gender = parts[2].charAt(0);
            short empID = Short.parseShort(parts[3]);
            byte position = Byte.parseByte(parts[11]);
            float hours = Float.parseFloat(parts[12]);

            if (parts[5].equals("")) {
                middleName = "";
            } else {
                middleName = parts[5];
            }

            Employee newEmployee = new Employee(trn, parts[1], gender, empID, parts[4], middleName, parts[6], parts[7], parts[8], parts[9], parts[10], position, hours);
            employeeList.add(newEmployee);
        }

        while (paySlipData.hasNext()) {
            String[] parts = paySlipData.getNext();
            Payslip newPayslip;

            newPayslip = new Payslip(parts[0], Integer.parseInt(parts[1]), Float.parseFloat(parts[2]), Short.parseShort(parts[3]),
                    Float.parseFloat(parts[4]), Float.parseFloat(parts[5]), Float.parseFloat(parts[6]));
            paySlipList.add(newPayslip);
        }

        while (notesData.hasNext()) {
            String[] parts = notesData.getNext();
            Note newNote = new Note(parts[0], Short.parseShort(parts[1]), parts[2]);
            noteList.add(newNote);
        }

        while (reportData.hasNext()) {
            String [] content = reportData.getNext();
            Report newReport;
            newReport = new Report(Integer.parseInt(content[0]), Float.parseFloat(content[1]), Float.parseFloat(content[2]), content[3].split(":"));
            reportList.add(newReport);
        }

        employeeCollection = new ManageEmployees(employeeList);
        payslipCollection = new ManagePayslips(paySlipList);
        notesCollection = new ManageNotes(noteList);
        reportCollection = new ManageReports(reportList);
    }

    public ManageEmployees getEmployeeList(){
        return employeeCollection;
    }

    public ManagePayslips getPayslipList(){
        return payslipCollection;
    }

    public ManageReports getReportList () {
        return reportCollection;
    }

    public ManageNotes getNoteList () {
        return notesCollection;
    }

    public float getRate (Employee emp) {
        if (emp.getPosition()== Position.JUNIORSTAFF){
            return jnrRate;
        }
        return snrRate;
    }

    public void PDF(String destination, String body, String fileName, int iD) throws DocumentException, FileNotFoundException {

        Document document = new Document();
        File file = new File("C:\\PaymentSystemPDFs\\" + destination + "\\" + fileName.replaceAll("\\s", "")+ iD + ".pdf");
        PdfWriter.getInstance(document, new FileOutputStream(file));

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLDOBLIQUE, 16, BaseColor.BLACK);
        Paragraph para = new Paragraph(body, font);

        document.add(para);
        document.close();
    }

    public void shutDown () throws IOException {
        employeeData.rewrite();
        paySlipData.rewrite();
        notesData.rewrite();
        reportData.rewrite();

        for (Employee employee : getEmployeeList().getList()) {
            employeeData.putNext(putEmployee(employee));
        }
        for (Payslip slip : getPayslipList().getList()) {
            paySlipData.putNext(putPayslip(slip));
        }
        for (Note note : getNoteList().getList()) {
            notesData.putNext(putNote(note));
        }
        for (Report report : getReportList().getList()) {
            reportData.putNext(putReport(report));
        }
        System.out.println("\n\nTHANK YOU FOR USING OUR APPLICATION.");
        System.exit(0);
    }

    public String[] putEmployee(Employee employee){
        String str;
        int pos = 0;

        if (employee.getPosition().equals(Position.JUNIORSTAFF)){
            pos = 1;
        }
        if (employee.getAddress()!=null){
            str = employee.getTRN()  + "," + employee.getDOB() + "," + employee.getGender() + ","
                    + employee.getEmployeeID() + "," + employee.getName().getFirstName() + "," + employee.getName().getMiddleName()
                    + "," + employee.getName().getLastName() + "," + employee.getAddress().getCountry()
                    + "," + employee.getAddress().getParish() + "," + employee.getAddress().getTown() + "," +
                    employee.getAddress().getStreet() + "," + pos + "," + employee.getHours();
        } else {
            str = employee.getTRN() + "," + employee.getDOB() + "," + employee.getGender() + "," + employee.getEmployeeID()
                    + "," + employee.getName().getFirstName() + "," + employee.getName().getMiddleName() + ","
                    + employee.getName().getLastName() + "," +  "" + "," +  "" + "," + "" + "," + "" + "," +
                    pos + "," + employee.getHours();
        }
        return str.split(",",-1);
    }

    public String[] putPayslip (Payslip slip){
        String str;
        str = slip.getName() +"," + slip.getTRN()+ "," + slip.getHours() + "," + slip.getSlipId() + "," + slip.getRate()
                + "," + slip.getBonus() + "," + slip.getDeductions();

        return str.split(",", -1);
    }

    public String[] putNote (Note nt){
        String str;
        str = nt.getNoteName() + "," + nt.getNoteId() + "," + nt.getBody();

        return str.split(",", 3);
    }

    public String[] putReport(Report report) {
        StringBuilder body = new StringBuilder();
        String str;

        for (String val : report.getList()){
            body.append(val).append(":");
        }
        body.deleteCharAt(body.length()-1);
        str = report.getSize() + "," + report.getBonus() + "," + report.getTotal() + "," + body;

        return str.split(",", 4);
    }

}
