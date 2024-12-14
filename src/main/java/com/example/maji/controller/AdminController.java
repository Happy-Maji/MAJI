package com.example.maji.controller;

import com.example.maji.bean.HistoryBean;
import com.example.maji.bean.UserBean;
import com.example.maji.entity.CustomizingEntity;
import com.example.maji.entity.ShoppingHistoryEntity;
import com.example.maji.entity.UserEntity;
import com.example.maji.service.AdminService;
import com.example.maji.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Resource(name = "loginUserBean")
    private UserBean loginUserBean;

    @Autowired
    private AdminService adminService;

    //--------------------------------------------

    @GetMapping("/admin_menu")
    public String adminMenu() {
        return "admin/admin_import/admin_menu";
    }

    @GetMapping("/user_list")
    public String userList(Model model) {

        List<UserEntity> userList = adminService.getUserList();

        model.addAttribute("userList", userList);

        return "admin/user_list";
    }

    @GetMapping("/customizing_list")
    public String customizingList(Model model) {

        List<CustomizingEntity> customizingList = adminService.getCustomizingList();

        model.addAttribute("customizingList", customizingList);

        return "admin/customizing_list";
    }

    @GetMapping("/history_list")
    public String historyList(Model model) {

        List<ShoppingHistoryEntity> historyEntities = adminService.getHistoryList();

        HistoryBean historyBean = new HistoryBean();

        List<HistoryBean> historyBeanList = new ArrayList<>();

    for (int i = 0; i < historyEntities.size(); i++) {
        historyBean.setCustomizingTitle(historyEntities.get(i).getShoppingHistoryListEntities().get(0).getCustomizingEntity().getCustomizingTitle());
        historyBean.setCustomizingTitleNum(historyEntities.get(i).getShoppingHistoryListEntities().size());
        int testSum = 0;
        for (int j = 0; j < historyEntities.get(i).getShoppingHistoryListEntities().size(); j++) {
            testSum += historyEntities.get(i).getShoppingHistoryListEntities().get(j).getCustomizingEntity().getCustomizingPrice();
        }
        historyBean.setCustomizingPriceSum(testSum);
        historyBean.setUserFn(historyEntities.get(i).getUserEntity().getUserFn());
        historyBean.setUserLn(historyEntities.get(i).getUserEntity().getUserLn());
        historyBean.setUserAddress(historyEntities.get(i).getUserEntity().getUserAddress());

        historyBeanList.add(historyBean);
    }
        model.addAttribute("historyList", historyBeanList);

        return "admin/history_list";
    }

}
