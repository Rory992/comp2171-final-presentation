package paysys;

public class Note {
    private final String name;
    private final String note;
    private final short id;


    public Note (String nm, short id, String note) {
        name = nm;
        this.id = id;
        this.note = note;
    }

    public short getNoteId (){
        return id;
    }

    public String getNoteName (){
        return name;
    }

    public String getBody(){
        return note;
    }

    public String getNote (){
        return "\t\t\tSUNNYSIDE BEAUTY SUPPLIES LDT. \n\t\t\t\t\tShops 3 & 4 \n\t\t\tNegril Shopping Centre, Negril, Westmoreland \n\t\t\t\t\t876-957-3859\t\t\t" +
                "\n\nNote on MR/MRS/MS. " + name + "\n\n" + note + "\n";
    }
}