package collections;

import paysys.Note;
import java.util.ArrayList;

public class ManageNotes {
    private final ArrayList<Note> notesList;

    public ManageNotes(ArrayList<Note> lst) {
        notesList = lst;
    }

    public void addNote(Note newNote){
        notesList.add(newNote);
    }

    public void removeNote(int position){
        notesList.remove(position);
    }

    public void getNoteId (int id) {
        for (Note note : notesList) {
            if(note.getNoteId()==id) {
                System.out.println(note.getNote() + "\n");
            }
        }
    }

    public void getName (String name) {
        for(Note nt: notesList) {
            if (nt.getNoteName().equalsIgnoreCase(name)) {
                System.out.println(nt.getNote()+"\n");
            }
        }
    }

    public void getAll (){
        for (int i=0; i<notesList.size(); i++) {
            System.out.println("Note number " + i+1 + " " + notesList.get(i).getNoteName() + ". " + notesList.get(i).getBody() + "\n");
        }
    }

    public ArrayList<Note> getList(){return notesList;}
}