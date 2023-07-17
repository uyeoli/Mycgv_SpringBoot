package com.springboot.mycgv.controller;

import com.springboot.mycgv.dto.PageDto;
import com.springboot.mycgv.service.NoticeService;
import com.springboot.mycgv.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    PageService pageService;
    @Autowired
    NoticeService noticeService;

    @GetMapping("index")
    public String admin_index() {
        return "/admin/admin_index";
    }

    @GetMapping("notice_list/{reqPage}")
    public String admin_notice_list(@PathVariable String reqPage, Model model){
        PageDto pageDto = pageService.getPageResult(new PageDto(reqPage, "notice"));
        model.addAttribute("list", noticeService.list(pageDto));
        model.addAttribute("page", pageDto);
        return "/admin/notice/admin_notice_list";
    }
}
