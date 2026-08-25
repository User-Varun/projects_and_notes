package com.varun.repository;

import org.springframework.stereotype.Component;

import com.varun.model.Comment;

@Component
public class DBCommentRespository implements CommentRespository {
    
    @Override
    public void storeComment(Comment comment){
     System.out.println("Storing Comment " + comment.getText());   
    }
}
