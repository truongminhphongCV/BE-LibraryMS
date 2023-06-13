package com.example.Library.Entity;



import jakarta.persistence.*;


import java.util.List;


@Entity

@Table

public class BookType {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "typeId")

    private int typeId;

    private String typeName;

    @OneToMany(mappedBy = "bookType", fetch = FetchType.LAZY)

    private List<Book> books;


    public BookType() {}


    public BookType(String typeName) {

        this.typeName = typeName;

    }


    public int getTypeId() {

        return typeId;

    }


    public void setTypeId(int typeId) {

        this.typeId = typeId;

    }


    public String getTypeName() {

        return typeName;

    }


    public void setTypeName(String typeName) {

        this.typeName = typeName;

    }


    public List<Book> getBooks() {

        return books;

    }

}






