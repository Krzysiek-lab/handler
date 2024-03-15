package com.o4b.mongodbtutorial.mapper;

import com.o4b.mongodbtutorial.dto.ItemDto;
import com.o4b.mongodbtutorial.model.GroceryItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValueMappingStrategy;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface GroceryMapperInt {
        @Mapping(target = "id", source = "groceryItem.id")
    ItemDto ItemToItemDto(GroceryItem groceryItem);

        @Mapping(target = "id", source = "itemDto.id")
    GroceryItem ItemDtoToGroceryItem(ItemDto itemDto);
}
