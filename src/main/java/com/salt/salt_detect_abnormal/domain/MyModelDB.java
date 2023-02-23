package com.salt.salt_detect_abnormal.domain;

public class MyModelDB {

//    @Id
//    @Column(nullable = false, updatable = false)
//    @SequenceGenerator(
//            name = "primary_sequence",
//            sequenceName = "primary_sequence",
//            allocationSize = 1,
//            initialValue = 10000
//    )
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "primary_sequence"
//    )
    private Long id;

//    @Column
    private String name;

  //  @Column
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
