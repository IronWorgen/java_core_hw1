package org.example;



import java.util.Date;

//@Data
public class Note {
    private Long id;
    private String text;
    private Date dateOfCreate;
    Note(String text){
        dateOfCreate = new Date();
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDateOfCreate() {
        return dateOfCreate;
    }

    public void setDateOfCreate(Date dateOfCreate) {
        this.dateOfCreate = dateOfCreate;
    }
}
