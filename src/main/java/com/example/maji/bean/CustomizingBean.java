package com.example.maji.bean;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Getter
@Setter
@Component
public class CustomizingBean {

    private Long customizingIdx;

    private String customizingTitle;

    private String customizingContent;

    private LocalDateTime customizingDate;

    private String customizingImg;

    private Integer customizingViewCount = 0;

    private Long customizingPrice;

    private Long customizingInfoIdx;

    private Long userIdx;

    // 기본 생성자 추가
    public CustomizingBean() {
    }

    public CustomizingBean(Long customizingIdx, String customizingTitle, String customizingImg,
                           LocalDateTime customizingDate, Integer customizingViewCount,
                           Long customizingPrice, String customizingContent,
                           String customizingInfoName, Long userIdx, String userId) {
        this.customizingIdx = customizingIdx;
        this.customizingTitle = customizingTitle;
        this.customizingImg = customizingImg;
        this.customizingDate = customizingDate;
        this.customizingViewCount = customizingViewCount;
        this.customizingPrice = customizingPrice;
        this.customizingContent = customizingContent;
        this.customizingInfoIdx = customizingInfoName != null ? Long.valueOf(customizingInfoName) : null;
        this.userIdx = userIdx;
    }

}



