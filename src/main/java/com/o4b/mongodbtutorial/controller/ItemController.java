package com.o4b.mongodbtutorial.controller;

import com.o4b.mongodbtutorial.dto.ItemDto;
import com.o4b.mongodbtutorial.exceptionHandler.MojException;
import com.o4b.mongodbtutorial.service.GroceryItemServiceInt;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/items")
public class ItemController {
    private final GroceryItemServiceInt groceryItemServiceInt;

    public ItemController(GroceryItemServiceInt groceryItemServiceInt) {
        this.groceryItemServiceInt = groceryItemServiceInt;
    }

    @GetMapping
    public ResponseEntity<List<ItemDto>> getAllItems() {
        throw new MojException("fff");

//        return new ResponseEntity<>(groceryItemServiceInt.getAllGroceryItems(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemDto> getItemById(@PathVariable String id) {
        return new ResponseEntity<>(groceryItemServiceInt.findGroceryItemById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteItemById(@PathVariable String id) {
        return new ResponseEntity<>("Deleted item with id: " + id, HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<ItemDto> addGroceryItem(@RequestBody @Valid ItemDto itemDto) {
        return new ResponseEntity<>(groceryItemServiceInt.saveGroceryItem(itemDto), HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemDto> updateGroceryItem(@PathVariable String id, @RequestBody ItemDto itemDto) {
        return new ResponseEntity<>(groceryItemServiceInt.updateGroceryItem(id, itemDto), HttpStatus.ACCEPTED);
    }
}
