package com.example.maji.service;

import com.example.maji.bean.ContentBean;
import com.example.maji.bean.UserBean;
import com.example.maji.entity.ShoppingCartEntity;
import com.example.maji.entity.UserEntity;
import com.example.maji.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ShoppingService {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    //--------------------------------------------

    public List<ShoppingCartEntity> getShoppingCart(Long userIdx) {
        return shoppingCartRepository.findUserCartByUserIdx(userIdx);
    }

    public ShoppingCartEntity insertCart(Long customizingIdx, Long userIdx) {

        ShoppingCartEntity cartEntity = new ShoppingCartEntity();

        cartEntity.setUserIdx(userIdx);
        cartEntity.setCustomizingIdx(customizingIdx);

        return shoppingCartRepository.save(cartEntity);
    }

}
