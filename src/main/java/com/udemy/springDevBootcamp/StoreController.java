package com.udemy.springDevBootcamp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StoreController {

    List<Item> itemsList = new ArrayList<>();

    @GetMapping("/")
    public String getForm(Model model){
        model.addAttribute("item", new Item());
        model.addAttribute("categories", Constants.CATEGORIES);
        return "form";
    }

    @PostMapping("/saveItem")
    public String submitItem(Item item){
        itemsList.add(item);
        return "redirect:/inventory";
    }

    @GetMapping("/inventory")
    public String getInventory(Model model){
        model.addAttribute("items", itemsList);
        return "inventory";
    }


}
