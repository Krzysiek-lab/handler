package com.o4b.mongodbtutorial.dto;


import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Builder
@Getter
public class ItemDto {

    private String id;
    @NotEmpty
    private String name;
    @Min(value = 1)
    private int quantity;
    @NotEmpty
    private String category;
}
