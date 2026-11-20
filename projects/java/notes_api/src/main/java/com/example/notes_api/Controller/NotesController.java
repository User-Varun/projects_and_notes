package com.example.notes_api.Controller;

import com.example.notes_api.Dto.NoteRequest;
import com.example.notes_api.Dto.NoteResponse;
import com.example.notes_api.Model.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RestController;

import com.example.notes_api.Model.Note;
import com.example.notes_api.Service.NoteService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api/notes")
public class NotesController {
    

    @Autowired
    private NoteService noteService;

    

    @PostMapping
    public ResponseEntity<NoteResponse> createNote(@Valid @RequestBody NoteRequest noteRequest , Authentication authentication){

      NoteResponse res = noteService.addNote(noteRequest , authentication);

      return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

    @GetMapping
    public List<NoteResponse> getAllNotes(Authentication auth){

       List<NoteResponse> notes =  noteService.getAllNotes(auth);

       return notes;

    }


//    @GetMapping("/{id}")
//    public ResponseEntity<NoteResponse> getNoteById(@PathVariable Long noteId , Authentication auth){};
//
//    @PutMapping("/{id}")
//    public Note updateNoteById(@PathVariable Long noteId, Authentication auth){};
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> softDeleteNoteById(@PathVariable Long noteId , Authentication auth)throws SQLException{
//        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//    }
    

    // @GetMapping("/search")
    // public List<Note> searchBy(){

    // }
}
