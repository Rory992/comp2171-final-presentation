package paysys;

public class Report {
    private final int size;
    private final float total;
    private final float bonus;
    private final String[] lst;
    private final String body;
    private String reportDoc = """
            \t\t\tSUNNYSIDE BEAUTY SUPPLIES LDT.\s
            \t\t\t\t\tShops 3 & 4\s
            \t\t\tNegril Shopping Centre, Negril, Westmoreland\s
            \t\t\t\t\t876-957-3859\t\t\t
            \t\t\tREPORT\s

            """;

    public Report (int size, float bonus, float total, String [] lst){
        this.size = size;
        this.total = total;
        this.bonus = bonus;
        this.lst = lst;

        StringBuilder main = new StringBuilder("\n\nThere are currently " + this.size + " payslip/s on the system.\n\n" +
                "Below displays a breakdown of each payslip generated: \n\n");

        for(String str : lst){
            main.append(str).append("\n\n");
        }

        this.body = main.toString();

    }

    public int getSize(){return size;}

    public float getTotal(){return total;}

    public float getBonus() {
        return bonus;
    }

    public String [] getList(){return lst;}

    public String getReport(){
        return reportDoc + body + "TOTAL BONUSES:\t\t\t\t" + bonus + "\n\nTOTAL EXPENDITURE:\t\t\t" + total ;
    }
}