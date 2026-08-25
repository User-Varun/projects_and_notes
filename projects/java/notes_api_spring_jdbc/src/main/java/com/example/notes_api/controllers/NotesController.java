package com.example.notes_api.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.notes_api.model.Note;
import com.example.notes_api.services.NotesService;

import java.sql.SQLException;
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
    

    private final NotesService notesService;

    NotesController(NotesService notesService) {
        this.notesService = notesService;
    }
    

    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Note note) throws SQLException{
      Note created = notesService.createNote(note);
      return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public List<Note> getAllNotes() throws SQLException {
        List<Note> notes = notesService.getAllNotes();

        return notes;
    }


  


    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id) throws SQLException{
        return ResponseEntity.status(HttpStatus.OK).body( notesService.getNote(id));
    }

    @PutMapping("/{id}")
    public Note updateNoteById(@PathVariable Long id , @RequestBody Note note) throws SQLException{
        return  notesService.updateNoteById(id , note);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> softDeleteNoteById(@PathVariable Long id)throws SQLException{
        
        notesService.softDeleteNoteById(id);
        
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    

    // @GetMapping("/search")
    // public List<Note> searchBy() throws SQLException{

    // }
}
