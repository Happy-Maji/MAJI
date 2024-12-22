package com.example.maji.controller;

import com.example.maji.entity.CustomizingEntity;
import com.example.maji.service.CustomizingService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import static java.lang.Integer.parseInt;

@Controller
@RequestMapping("/content")
public class ContentController {

    private final CustomizingService customizingService;

    public ContentController(CustomizingService customizingService) {
        this.customizingService = customizingService;
    }

    @GetMapping("/content_main")
    public String contentMain(@RequestParam(name = "pages", required = false) String pages,
                              Model model) {

        Pageable pageable = null;

        // 페이지 파라미터가 있으면 그것을 사용하고, 없으면 첫 페이지로 설정
        if(pages != null) {
            pageable = parsePageable(pages);
        }
        if(pageable == null || pageable.getPageNumber() <= 0) {
            pageable = PageRequest.of(0, 6); // 기본값: 1페이지, 6개씩
        }

        // 페이지네이션된 데이터만 가져옵니다.
        Page<CustomizingEntity> pagesList = customizingService.findContentPage(pageable);



        // 페이지네이션된 데이터만 model에 추가
        model.addAttribute("customizingList", pagesList.getContent()); // 실제 게시물 리스트
        model.addAttribute("pagesList", pagesList); // 페이지네이션 정보

        return "content/content_main";
    }

    private Pageable parsePageable(String str) {
        int page = parseInt(str); // 문자열을 정수로 변환
        return PageRequest.of(page, 6); // 페이지 크기 5로 설정
    }

    @GetMapping("/customizingList/{id}")
    public String viewCustomizing(@PathVariable("id") Long customizingIdx, Model model) {

        CustomizingEntity customizing = customizingService.findById(customizingIdx);

        model.addAttribute("customizing", customizing);

        return "content/content_detail";

    }

}