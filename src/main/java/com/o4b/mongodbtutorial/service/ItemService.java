package com.o4b.mongodbtutorial.service;

import com.o4b.mongodbtutorial.dto.ItemDto;
import com.o4b.mongodbtutorial.mapper.GroceryMapperInt;
import com.o4b.mongodbtutorial.model.GroceryItem;
import com.o4b.mongodbtutorial.repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@AllArgsConstructor
@Service
public class ItemService implements GroceryItemServiceInt {
    private final ItemRepository itemRepository;
    private final GroceryMapperInt groceryMapperInt;

    public List<ItemDto> getAllGroceryItems() {
        return itemRepository.findAll().stream().map(groceryMapperInt::ItemToItemDto).collect(Collectors.toList());
    }

    public ItemDto findGroceryItemById(String id) {
        List<ItemDto> items = new ArrayList<>();
        itemRepository.findById(id).ifPresentOrElse(i -> items.add(groceryMapperInt.ItemToItemDto(i))
                , () -> {
                    System.out.println("no item with given id");
                });
        return items.get(0);
    }

    public void deleteGroceryItem(String id) {
        itemRepository.deleteById(id);
    }

    public ItemDto updateGroceryItem(String id, ItemDto itemDto) {
        GroceryItem updateItem = GroceryItem.builder()
                .id(id)
                .name(itemDto.getName())
                .quantity(itemDto.getQuantity())
                .category(itemDto.getCategory())
                .build();
        itemRepository.save(updateItem);

        return groceryMapperInt.ItemToItemDto(itemRepository.findById(id).get());
    }

    public ItemDto saveGroceryItem(ItemDto itemDto) {
        var item = groceryMapperInt.ItemDtoToGroceryItem(itemDto);
        return groceryMapperInt.ItemToItemDto(itemRepository.save(item));
    }

}
