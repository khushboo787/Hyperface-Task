package com.khushboo.dto;

import jakarta.validation.constraints.NotBlank;

public class TaskRequest {
	
    @NotBlank(message = "Description cannot be blank")
    private String description;

    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}