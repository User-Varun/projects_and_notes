package com.example.notes_api.Service;

import java.util.ArrayList;
import java.util.List;

import com.example.notes_api.Dto.NoteRequest;
import com.example.notes_api.Dto.NoteResponse;
import com.example.notes_api.Exception.UserNotFoundException;
import com.example.notes_api.Repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.notes_api.Exception.InvalidNoteException;
import com.example.notes_api.Model.Note;
import com.example.notes_api.Repository.NoteRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NoteService {

    @Autowired
    NoteRepository noteRepository;
    @Autowired
    AuthRepository authRepository;
    

    @Transactional
    public NoteResponse addNote(NoteRequest noteRequest , Authentication authentication) {

        if(noteRequest == null) throw new InvalidNoteException("Note Cannot be null");


        if(noteRequest.getTitle() == null || noteRequest.getTitle().isBlank()) throw new InvalidNoteException("Title must not be empty");
        if(noteRequest.getDescription() == null || noteRequest.getDescription().isBlank()) throw new InvalidNoteException("Description must not be empty");

        long userId = authRepository.findByUsername(authentication.getName())
                .orElseThrow(() -> new UsernameNotFoundException("No user found with the name: " + authentication.getName()))
                .getId();

        Note n = new Note();

        n.setTitle(noteRequest.getTitle());
        n.setDescription((noteRequest.getDescription()));
        n.setUserId(userId);


        Note savedNote = noteRepository.save(n);

        NoteResponse noteResponse = new NoteResponse();

        noteResponse.setId(savedNote.getId());
        noteResponse.setTitle(savedNote.getTitle());
        noteResponse.setDescription((savedNote.getDescription()));

        return noteResponse;
    }


    public List<NoteResponse> getAllNotes(Authentication authentication){

        long userId = authRepository.
                findByUsername(authentication.getName())
                .orElseThrow(() -> new UserNotFoundException("No user found with the username: " + authentication.getName()))
                .getId();

        List<Note> notes = noteRepository.findAllByUserId(userId);

        List<NoteResponse> notesRes = new ArrayList<>();


        notes.forEach(note -> {
            NoteResponse res = new NoteResponse();
            res.setTitle(note.getTitle());
            res.setDescription(note.getDescription());
            res.setId(note.getId());

            notesRes.add(res);
        });

        return notesRes;
    };

//    public NoteResponse  getNoteById(Long userId , Long noteId){};
//
//    public NoteResponse updateNoteById(Long userId , Long noteId){};
//
//    public void softDeleteNoteById(Long id){};
}
