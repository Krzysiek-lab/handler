package com.o4b.mongodbtutorial.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Builder
@Document("groceryitems")
public class GroceryItem implements Serializable {

    @Id
    private String id;
    private String name;
    private int quantity;
    private String category;
}

