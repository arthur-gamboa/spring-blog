package com.codeup.codeup_demo.models;

import javax.persistence.*;

@Entity
@Table(name = "ads")
public class Ad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT(11) UNSIGNED")
    private Long Id;

    @Column(name = "title", nullable = false, length = 255)
    private String Title;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String Description;

    public Ad(Long id, String title, String description) {
        Id = id;
        Title = title;
        Description = description;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
