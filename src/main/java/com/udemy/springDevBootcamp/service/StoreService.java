package com.udemy.springDevBootcamp.service;

import com.udemy.springDevBootcamp.Constants;
import com.udemy.springDevBootcamp.Item;
import com.udemy.springDevBootcamp.repository.StoreRepository;

import java.util.List;

public class StoreService {

    StoreRepository storeRepository = new StoreRepository();

    public Item getItemsList(int index){
        return storeRepository.getItemsList(index);
    }

    public void addItem(Item item){
        storeRepository.addItem(item);
    }

    public void updateItem(Item item, int index){
        storeRepository.updateItem(item, index);
    }

    public List<Item> getAllItems(){
        return storeRepository.getAllItems();
    }

    public int getItemIndex(String id){
        for (int i =0; i<getAllItems().size(); i++){
            if(getAllItems().get(i).getId().equals(id)) return i;
        }
        return Constants.NOT_FOUND;
    }

    public Item getItemById(String id){
        int index = getItemIndex(id);
        return index == Constants.NOT_FOUND ? new Item() : getItemsList(index);
    }
}
