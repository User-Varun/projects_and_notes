package com.example.notes_api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.notes_api.Model.Note;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note , Long> {

    List<Note> findAllByUserId(Long userId);

    // Old JDBC code
    /*
      public Note createNote(Note n) throws SQLException {


    Connection con = ds.getConnection();

         String sql = "INSERT INTO notes(title , description) VALUES(? , ?)";

       try(
         PreparedStatement stmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)
       ){
        stmt.setString(1, n.getTitle());
        stmt.setString(2, n.getDescription());
        stmt.executeUpdate();

         try (ResultSet keys = stmt.getGeneratedKeys()) {
            if (keys.next()) {
               n.setId(keys.getLong(1));
            }
         }

         return n;
       }
   }

   public List<Note> getAllNotes() throws SQLException{
      Connection con = ds.getConnection();

      String sql = "SELECT * FROM notes WHERE deleted=false";

      try(

          
          PreparedStatement stmt = con.prepareStatement(sql);


        ){

            ResultSet res = stmt.executeQuery();

            List<Note> notes = new ArrayList<Note>();

            while(res.next()){
                Note n = new Note();

               n.setId(res.getLong("id"));
                n.setTitle(res.getString("title"));
                n.setDescription(res.getString("description"));

                notes.add(n);
            }

            return notes;
        }
      
   }

   public Note getNote(Long id)throws SQLException{

      Connection conn = ds.getConnection();    

      String sql = "SELECT * FROM notes WHERE id= ? AND deleted=false";

      try(
        PreparedStatement stmt = conn.prepareStatement(sql);
       
      ){
     stmt.setLong(1 , id);

       ResultSet rs = stmt.executeQuery();

       if(!rs.next()){
          throw new NoteNotFoundException("Note not found with the id " + id);
       }

       Note n = new Note();
       n.setId(rs.getLong("id"));
       n.setTitle(rs.getString("title"));
       n.setDescription(rs.getString("description"));
       return n;
      }
   }

   public Note updateNoteById(Long id , Note note) throws SQLException{
      
      Connection conn = ds.getConnection();

      String sql = "UPDATE notes SET title= ? , description = ? WHERE id=?";

      try(PreparedStatement stmt = conn.prepareStatement(sql)){
         
        stmt.setString(1 , note.getTitle());
        stmt.setString(2 , note.getDescription());
        stmt.setLong(3 , id);

        int updated = stmt.executeUpdate();

        if(updated == 0) throw new NoteNotFoundException("Note not found with the id " + id);

        // RETURN THE UPDATED RECORD;
        PreparedStatement ps2 = conn.prepareStatement("SELECT * FROM notes WHERE id=?");

        ps2.setLong(1 , id);

        ResultSet rs2 = ps2.executeQuery();
        
        if(!rs2.next()) throw new NoteNotFoundException("Error fetching the saved note");
        
        Note updatedNote = new Note();

        updatedNote.setId(rs2.getLong("id"));
        updatedNote.setTitle(rs2.getString("title"));
        updatedNote.setDescription(rs2.getString("description"));

        return updatedNote;
        
      }

   }

   public void softDeleteNoteById(Long id) throws SQLException{
       Connection conn = ds.getConnection();
      
       String sql = "UPDATE notes SET deleted = true WHERE id = ?";

       try(PreparedStatement stmt = conn.prepareStatement(sql)){
          
        stmt.setLong(1 , id);

        int res = stmt.executeUpdate();

        if(res == 0) throw new NoteNotFoundException("No Note found with the id " + id);
       }

   }

     */
}
