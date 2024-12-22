package com.example.maji.controller;

import com.example.maji.bean.ContentBean;
import com.example.maji.bean.UserBean;
import com.example.maji.entity.CustomizingEntity;
import com.example.maji.entity.ShoppingCartEntity;
import com.example.maji.service.ShoppingService;
import com.example.maji.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/shopping")
public class ShoppingController {

    @Resource(name = "loginUserBean")
    private UserBean loginUserBean;

    @Autowired
    private UserService userService;

    @Autowired
    private ShoppingService shoppingService;

    //--------------------------------------------

    @GetMapping("/cart")
    public String cart(Model model) {

        List<ShoppingCartEntity> shoppingCartList = shoppingService.getShoppingCart(loginUserBean.getUserIdx());


        model.addAttribute("shoppingCartList", shoppingCartList);
        return "shopping/shopping_cart";
    }

    @GetMapping("/payment")
    public String payment(Model model) {

        List<ShoppingCartEntity> shoppingCartList = shoppingService.getShoppingCart(loginUserBean.getUserIdx());

        int totalPrice = 0;
        for (ShoppingCartEntity shoppingCartEntity : shoppingCartList) {
            totalPrice += shoppingCartEntity.getCustomizingEntity().getCustomizingPrice();
        }

        System.out.println(totalPrice);

        model.addAttribute("shoppingCartList", shoppingCartList);
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("loginUserBean", loginUserBean);
        return "shopping/shopping_payment";
    }

    @GetMapping("/saveCart/{id}")
    public String history(@PathVariable("id") Long customizingIdx, Model model) {

        shoppingService.insertCart(customizingIdx, loginUserBean.getUserIdx());

        return "alert/success_cart";
    }

}
