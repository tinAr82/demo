package com.example.demo.controller;


import com.example.demo.Models.CategoryDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class HelloWorldApp {
    public static List<CategoryDTO> data = new ArrayList<>();

    @RequestMapping(value = "/getCategory" , method = RequestMethod.GET)
    public List<CategoryDTO> getCategory() {
        return data;
    }

    @RequestMapping(value = "/sendCategory" , method = RequestMethod.POST)
    public String insert(@RequestBody CategoryDTO categoryDTO) {
        boolean name = categoryDTO.getName() != null && !Objects.equals(categoryDTO.getName(), "");
        if (name) {
            System.out.println(categoryDTO);
            data.add(categoryDTO);
            return "Data Inserted Successfully!";
        }else {
            return "Please enter your name";
        }
    }

    @RequestMapping(value = "/delete/{id}" , method = RequestMethod.DELETE)
    public String delete(@PathVariable Long id) {
        boolean removed = data.removeIf(item -> item.getId().equals(id));
        if (removed) {
            return "Category with ID " + id + " deleted!";
        } else {
            return "Category not found!";
        }
    }

    @RequestMapping(value = "/update" , method = RequestMethod.PUT)
    public String update(@RequestBody CategoryDTO categoryDTO) {
        data.stream()
                .filter(item -> item.getId() == categoryDTO.getId())
                .forEach(item -> {
                    item.setName(categoryDTO.getName());
                    item.setId(categoryDTO.getId());
                    item.setCreateDate(categoryDTO.getCreateDate());
                });
        return "Category with ID " + categoryDTO.getId() + " updated!";
    }

}
