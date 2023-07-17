package com.springboot.mycgv.controller;

import com.springboot.mycgv.dto.NoticeDto;
import com.springboot.mycgv.dto.PageDto;
import com.springboot.mycgv.service.NoticeService;
import com.springboot.mycgv.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class NoticeController {

    @Autowired
    NoticeService noticeService;
    @Autowired
    PageService pageService;

    @GetMapping("notice_list/{page}")
    public String notice(@PathVariable String page, Model model) {
//        PageDto pageDto = new PageDto(page, "notice");
//        pageDto.setServiceName("notice");
//        pageDto.setPage(page);
        PageDto pageDto = pageService.getPageResult(new PageDto(page, "notice"));
        model.addAttribute("list", noticeService.list(pageDto));
        model.addAttribute("page", pageDto);
        return "/notice/notice_list";
    }

    @GetMapping("notice_content/{nid}/{reqPage}")
    public String notice_content( @PathVariable String nid, @PathVariable String reqPage, Model model) {
        NoticeDto noticeDto = noticeService.content(nid);
        if(noticeDto != null) {
            noticeService.updateHits(nid);
        }
        model.addAttribute("noticeDto", noticeDto);
        model.addAttribute("reqPage", reqPage);
        return "/notice/notice_content";
    }

}
