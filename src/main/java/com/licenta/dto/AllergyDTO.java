package com.licenta.dto;



public class AllergyDTO {


    private Integer id;
    private String name;

    public AllergyDTO(){}

    public AllergyDTO(String name){
        this.name=name;
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){

        this.name = name;
    }
}
