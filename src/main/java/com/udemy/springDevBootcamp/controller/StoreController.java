package com.udemy.springDevBootcamp.controller;

import com.udemy.springDevBootcamp.Constants;
import com.udemy.springDevBootcamp.Item;
import com.udemy.springDevBootcamp.service.StoreService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Controller
public class StoreController {

    @Autowired
    StoreService storeService;

    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false) String id){

        model.addAttribute("item", storeService.getItemById(id));
        model.addAttribute("categories", Constants.CATEGORIES);
        return "form";
    }

    @PostMapping("/saveItem")
    public String submitItem(@Valid Item item, BindingResult result, RedirectAttributes redirectAttributes){
        //checking cross validation so that price is not less than discount
        if(item.getPrice() < item.getDiscount()){
            result.rejectValue("price", "", "Price cannot be less than discount");
        }

        //checking mandatory fields
        if(result.hasErrors()) return "form";

        //working with the form
        int index = storeService.getItemIndex(item.getId());
        String status = Constants.SUCCESS_STATUS;
        if(index == Constants.NOT_FOUND){
            storeService.addItem(item);
        } else if(within5Days(item.getDate(), storeService.getItemsList(index).getDate())){
            storeService.updateItem(item,index);
        }else{
            status = Constants.FAILED_STATUS;
        }
        redirectAttributes.addFlashAttribute("status", status);
        return "redirect:/inventory";
    }

    @GetMapping("/inventory")
    public String getInventory(Model model){
        model.addAttribute("items", storeService.getAllItems());
        return "inventory";
    }

    public boolean within5Days(Date newDate, Date oldDate) {
        long diff = Math.abs(newDate.getTime() - oldDate.getTime());
        return (int) (TimeUnit.MILLISECONDS.toDays(diff)) <= 5;
    }

}
