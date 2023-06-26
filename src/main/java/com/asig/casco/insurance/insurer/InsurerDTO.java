package com.asig.casco.insurance.insurer;

public class InsurerDTO {

    private String companyName;

    public InsurerDTO(String companyName, String img) {
        this.companyName = companyName;
        this.img = img;
    }

    private String img;
}
