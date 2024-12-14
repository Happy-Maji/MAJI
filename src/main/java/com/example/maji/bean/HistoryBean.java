package com.example.maji.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Getter
@Setter
@Component
public class HistoryBean {

    private String customizingTitle;

    private int customizingTitleNum;

    private int customizingPriceSum;

    private String userFn;

    private String userLn;

    private String userAddress;

}



