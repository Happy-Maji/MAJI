package com.example.maji.service;

import com.example.maji.bean.UserBean;
import com.example.maji.entity.CustomizingEntity;
import com.example.maji.entity.ShoppingCartEntity;
import com.example.maji.entity.ShoppingHistoryEntity;
import com.example.maji.entity.UserEntity;
import com.example.maji.repository.CustomizingRepository;
import com.example.maji.repository.ShoppingHistoryRepository;
import com.example.maji.repository.UserRepository;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomizingRepository customizingRepository;

    @Autowired
    private ShoppingHistoryRepository shoppingHistoryRepository;

    //--------------------------------------------

    public List<UserEntity> getUserList() {
        return userRepository.findAll();
    }

    public List<CustomizingEntity> getCustomizingList() {
        return customizingRepository.findAll();
    }

    public List<ShoppingHistoryEntity> getHistoryList() {
        return shoppingHistoryRepository.findAll();
    }

}
