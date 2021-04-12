package paysys;

import java.text.DecimalFormat;

public class Payslip {
    private final String name;
    private final int trn;
    private final float hours;
    private final short empID;
    private final float rate;
    private  float bonus = 0;
    private float deductions = 0;
    private final String salary;
    public static DecimalFormat df = new DecimalFormat("###.##");


    public Payslip (String nm, int trn, float hrs, short id, float rate) {
        name = nm;
        this.trn = trn;
        hours = hrs;
        empID = id;
        this.rate = rate;
        salary = df.format(rate*hours);
    }

    public Payslip (String nm, int trn, float hrs, short id, float rate, float bonus, float deductions) {
        name = nm;
        this.trn = trn;
        hours = hrs;
        empID = id;
        this.rate = rate;
        this.bonus = bonus;
        this.deductions = deductions;
        salary = df.format(bonus+(hours*rate)-deductions);
    }

    public String getName(){
        return name;
    }

    public int getTRN(){return trn;}

    public float getHours(){return hours;}

    public short getSlipId () {
        return empID;
    }

    public float getRate(){return rate;}

    public float getBonus(){
        return bonus;
    }

    public float getDeductions(){return deductions;}

    public String getSalary(){
        return salary;
    }

    public String getPayslip(){
        return "\t\t\tSUNNYSIDE BEAUTY SUPPLIES LDT. \n\t\t\t\t\tShops 3 & 4 \n\t\t\tNegril Shopping Centre, Negril, Westmoreland \n\t\t\t\t\t876-957-3859\t\t\t" +
                "\n\nPayslip for MR/MRS/MS. " + name + "\t\nTax Registration # - " + trn + "\nID # - " + empID + "\n\nHours Worked -\t "
                + hours + "\nRate: \t" + rate + "\nBonus: \t" + bonus + "\nDeductions: \t" + deductions + "\n\nSalary: \t"
                + getSalary() + "\n\n";
    }
}