package com.example.notes_api.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.notes_api.exceptions.InvalidNoteException;
import com.example.notes_api.model.Note;
import com.example.notes_api.repository.NoteRepository;

@Service
public class NotesService {

    NoteRepository np;
    
    
    public NotesService(NoteRepository np){
        this.np = np;
    }

    public Note createNote(Note n) throws SQLException{

        if(n == null) throw new InvalidNoteException("Note Cannot be null");


        if(n.getTitle() == null || n.getTitle().isBlank()) throw new InvalidNoteException("Title must not be empty");
        if(n.getDescription() == null || n.getDescription().isBlank()) throw new InvalidNoteException("Description must not be empty");

        return np.save(n);

    }

    public List<Note> getAllNotes() throws SQLException {
        return np.getAllNotes();
    }

    public Note  getNote(Long id)throws SQLException{
        if(id == null) throw new InvalidNoteException("invalid id");
        return np.getNote(id);
    }

    public Note updateNoteById(Long id , Note note)throws SQLException{
       
        if(id == null) throw new InvalidNoteException("Id is not valid");

        note.setId(id);
        return np.save(note);
    }

    public void softDeleteNoteById(Long id) throws SQLException{
        if(id == null) throw new InvalidNoteException("id is not valid!");
        np.softDeleteNoteById(id);
     }
}
