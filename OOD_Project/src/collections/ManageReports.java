package collections;

import paysys.Report;

import java.util.ArrayList;

public class ManageReports {
    private final ArrayList<Report> reportList;

    public ManageReports(ArrayList<Report> lst) {
        reportList = lst;
    }

    public void addReport(Report newReport){
        reportList.add(newReport);
    }

    public ArrayList<Report> getList(){
        return reportList;
    }
}