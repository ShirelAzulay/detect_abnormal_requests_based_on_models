package com.salt.salt_detect_abnormal.model;

import jakarta.validation.constraints.Size;


public class MyModelDBDTO {

    private Long id;

    @Size(max = 255)
    private String name;

    @Size(max = 255)
    private String comments;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(final String comments) {
        this.comments = comments;
    }

}
