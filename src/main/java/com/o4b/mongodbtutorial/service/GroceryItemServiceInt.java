package com.o4b.mongodbtutorial.service;

import com.o4b.mongodbtutorial.dto.ItemDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface GroceryItemServiceInt {
    List<ItemDto> getAllGroceryItems();

    void deleteGroceryItem(String id);

    ItemDto findGroceryItemById(String id);

    ItemDto updateGroceryItem(String id, ItemDto itemDto);

    ItemDto saveGroceryItem(ItemDto itemDto);
}
