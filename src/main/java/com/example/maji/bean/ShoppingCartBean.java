package com.example.maji.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class ShoppingCartBean {

    private Long shopping_cart_idx;

    private Long user_idx;

    private Long customizing_idx;

}
