package com.example.demo.Models;

import java.util.Date;

public class CategoryDTO {
    public Long id;
    public String name;
    public Date createDate;

//    public CategoryDTO() {
//    }
//
//    public CategoryDTO(Long id, String name , Date createDate) {
//        this.id = id;
//        this.name = name;
//        this.createDate = createDate;
//    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Date getCreateDate() { return createDate; }
    public void setCreateDate(Date createDate) { this.createDate = createDate; }
}
