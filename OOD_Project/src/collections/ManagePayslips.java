package collections;

import paysys.Payslip;
import java.util.ArrayList;

public class ManagePayslips {
    private final ArrayList<Payslip> payslipList;

    public ManagePayslips (ArrayList<Payslip> lst) {
        payslipList = lst;
    }

    public void addPayslip (Payslip newPayslip) {
        payslipList.add(newPayslip);
    }

    public void getPayslip (short empId){
        for (Payslip slip : payslipList) {
            if (slip.getSlipId()==empId) {
                System.out.println(slip.getPayslip());
            }
        }
    }

    public Payslip getPayslipName (String name){
        for (Payslip slip : payslipList) {
            if (slip.getName().equalsIgnoreCase(name)){
                System.out.println(slip.getPayslip());
            }
        }
        return null;
    }

    public ArrayList<Payslip> getList(){
        return payslipList;
    }
}