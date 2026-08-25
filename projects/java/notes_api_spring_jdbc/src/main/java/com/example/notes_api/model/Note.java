package com.example.notes_api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table("NOTES")
public class Note {

    @Id
    private Long id;
    private String title;
    private String description;

    @JsonIgnore
    private boolean deleted;


    // private String createdAt;
    // private String updatedAt;


    // public String getCreatedAt() {
    //     return createdAt;
    // }
    // public void setCreatedAt(String createdAt) {
    //     this.createdAt = createdAt;
    // }
    // public String getUpdatedAt() {
    //     return updatedAt;
    // }
    // public void setUpdatedAt(String updatedAt) {
    //     this.updatedAt = updatedAt;
    // }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Boolean getDeleted() {
        return deleted;
    }
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

}
