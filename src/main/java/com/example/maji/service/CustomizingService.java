package com.example.maji.service;

import com.example.maji.bean.CustomizingBean;
import com.example.maji.entity.CustomizingEntity;
import com.example.maji.entity.CustomizingInfoEntity;
import com.example.maji.repository.CustomizingInfoRepository;
import com.example.maji.repository.CustomizingRepository;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class CustomizingService {

    @Autowired
    private CustomizingInfoRepository customizingInfoRepository;

    @Autowired
    private CustomizingRepository customizingRepository;

    //커스터마이징 이름 가져오기
    public String findCustomizingInfoName(long customizingInfoIdx) {

        Optional<CustomizingInfoEntity> optionalEntity = customizingInfoRepository.findByCustomizingInfoIdx(customizingInfoIdx);

        return optionalEntity.map(CustomizingInfoEntity::getCustomizingInfoName).orElse("정보 없음");

    }

    //커스터마이징 만들기
    @Transactional
    public void saveCustomizing(CustomizingBean customizingBean) {

        CustomizingEntity customizingEntity = new CustomizingEntity();

        customizingEntity.setCustomizingIdx(customizingBean.getCustomizingIdx());
        customizingEntity.setCustomizingTitle(customizingBean.getCustomizingTitle());
        customizingEntity.setCustomizingContent(customizingBean.getCustomizingContent());
        customizingEntity.setCustomizingDate(LocalDateTime.now());
        customizingEntity.setCustomizingImg(customizingBean.getCustomizingImg());
        customizingEntity.setCustomizingViewCount(customizingBean.getCustomizingViewCount());
        customizingEntity.setCustomizingPrice(customizingBean.getCustomizingPrice());
        customizingEntity.setCustomizingInfoIdx(customizingBean.getCustomizingInfoIdx());
        customizingEntity.setUserIdx(customizingBean.getUserIdx());

        customizingRepository.save(customizingEntity);
    }

    //커스터마이징 게시판 정보 가져오기
    @Transactional
    public List<CustomizingBean> findAllWithPagination() {
        return customizingRepository.findAllWithPagination()
                .stream()
                .map(entity -> new CustomizingBean(
                        entity.getCustomizingIdx(),
                        entity.getCustomizingTitle(),
                        entity.getCustomizingImg(),
                        entity.getCustomizingDate(),
                        entity.getCustomizingViewCount(),
                        entity.getCustomizingPrice(),
                        entity.getCustomizingContent(),
                        entity.getCustomizingInfoEntity() != null ? entity.getCustomizingInfoEntity().getCustomizingInfoName() : null,
                        entity.getUserEntity() != null ? entity.getUserEntity().getUserIdx() : null,
                        entity.getUserEntity() != null ? entity.getUserEntity().getUserId() : null
                ))
                .collect(Collectors.toList());
    }

    public Page<CustomizingEntity> findContentPage(Pageable pageable) {

        return customizingRepository.findAllByOrderByCustomizingIdxDesc(pageable);
    }


    // customizingIdx를 기준으로 CustomizingEntity 조회
    public  CustomizingEntity findById(Long customizingIdx) {

        return customizingRepository.findById(customizingIdx).
                orElseThrow(() -> new IllegalArgumentException("Invalid customizing ID: " + customizingIdx));
    }

}


