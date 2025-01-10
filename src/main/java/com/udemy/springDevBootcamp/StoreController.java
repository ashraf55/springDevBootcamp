package com.udemy.springDevBootcamp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StoreController {

    List<Item> itemsList = new ArrayList<>();

    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false) String id){
        int index = getIndexFromID(id);
        model.addAttribute("item", index == Constants.NOT_FOUND ? new Item() : itemsList.get(index));
        model.addAttribute("categories", Constants.CATEGORIES);
        return "form";
    }

    @PostMapping("/saveItem")
    public String submitItem(Item item){
        int index = getIndexFromID(item.getId());
        if(index == Constants.NOT_FOUND){
            itemsList.add(item);
        }else{
            itemsList.set(index, item);
        }
        return "redirect:/inventory";
    }

    @GetMapping("/inventory")
    public String getInventory(Model model){
        model.addAttribute("items", itemsList);
        return "inventory";
    }

    public int getIndexFromID(String id){
        for (int i =0; i<itemsList.size(); i++){
            if(itemsList.get(i).getId().equals(id)) return i;
        }
        return Constants.NOT_FOUND;
    }

}
