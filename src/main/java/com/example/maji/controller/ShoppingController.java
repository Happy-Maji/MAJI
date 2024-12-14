package com.example.maji.controller;

import com.example.maji.bean.ContentBean;
import com.example.maji.bean.UserBean;
import com.example.maji.entity.ShoppingCartEntity;
import com.example.maji.service.ShoppingService;
import com.example.maji.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String payment(@RequestParam("totalPrice") Long totalPrice, Model model) {


        List<ShoppingCartEntity> shoppingCartList = shoppingService.getShoppingCart(loginUserBean.getUserIdx());


        model.addAttribute("shoppingCartList", shoppingCartList);
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("loginUserBean", loginUserBean);
        return "shopping/shopping_payment";
    }
}
