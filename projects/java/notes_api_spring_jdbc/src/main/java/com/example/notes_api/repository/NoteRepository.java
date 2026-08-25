package com.example.notes_api.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.notes_api.exceptions.NoteNotFoundException;
import com.example.notes_api.model.Note;


public interface NoteRepository extends CrudRepository<Note , Long>{


   // for create note don't even need method definition , just use noteRepo.save(noteObj) (used in NotesService:31)
   // for update also used the .save() method;

   @Query("SELECT * FROM notes WHERE deleted=false")
   public List<Note> getAllNotes();


   @Query("SELECT * FROM notes WHERE deleted = false AND id=:id")
   public Note getNote(Long id);

      
   @Modifying
   @Query("UPDATE notes SET deleted = true WHERE id =:id")
   public void softDeleteNoteById(@Param("id") Long id);

}