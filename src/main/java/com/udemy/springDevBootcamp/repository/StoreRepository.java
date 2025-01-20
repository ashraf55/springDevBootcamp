package com.udemy.springDevBootcamp.repository;

import com.udemy.springDevBootcamp.Item;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StoreRepository {
    private List<Item> itemsList = new ArrayList<>();

    public Item getItemsList(int index){
        return itemsList.get(index);
    }

    public void addItem(Item item){
        itemsList.add(item);
    }

    public void updateItem(Item item, int index){
        itemsList.set(index, item);
    }

    public List<Item> getAllItems(){
        return itemsList;
    }
}
