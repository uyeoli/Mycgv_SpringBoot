package com.springboot.mycgv.controller;

import com.springboot.mycgv.dto.BoardDto;
import com.springboot.mycgv.dto.PageDto;
import com.springboot.mycgv.service.BoardService;
import com.springboot.mycgv.service.FileUploadService;
import com.springboot.mycgv.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {
    @Autowired
    private PageService pageService;
    @Autowired
    private BoardService boardService;
    @Autowired
    private FileUploadService fileUploadService;

    @GetMapping("/board_list/{page}")
    public String board_list(@PathVariable String page, Model model) {
        PageDto pageDto = pageService.getPageResult(new PageDto(page, "board"));
        model.addAttribute("list", boardService.list(pageDto));
        model.addAttribute("page", pageDto);
        return "board/board_list";

    }

    @GetMapping("board_content/{bid}/{reqPage}")
    public String board_content(@PathVariable String bid, @PathVariable String reqPage, Model model) {
        BoardDto boardDto = boardService.content(bid);
        if(boardDto != null) {
            boardService.updateHits(bid);
        }
        model.addAttribute("boardDto", boardDto);
        model.addAttribute("reqPage", reqPage);
        return "/board/board_content";

    }

    @GetMapping("/board_write")
    public String board_write() {
        return "/board/board_write";
    }

    @PostMapping("/board_write")
    public String board_write(BoardDto boardDto) throws Exception {
        String viewName = "";
        //파일업로드 서비스 추가 & insert
        int result = boardService.insert((BoardDto)fileUploadService.fileCheck(boardDto));
        if(result == 1) {
            if(boardDto.getBfile() != null)  {
                fileUploadService.fileSave(boardDto);
            }
            viewName = "redirect:/board_list/1/";
        }
        return viewName;
    }

    @GetMapping("/board_update/{bid}/{reqPage}")
    public String board_update(@PathVariable String bid, @PathVariable String reqPage, Model model) {
        model.addAttribute("board", boardService.content(bid));
        model.addAttribute("reqPage", reqPage);
        return "/board/board_update";
    }

    @PostMapping("/board_update")
    public String board_update(BoardDto boardDto) throws Exception {
        String viewName = "";
        String oldFileName = boardDto.getBsfile();
        int result = boardService.update((BoardDto)fileUploadService.fileCheck(boardDto));
        if(result == 1) {
            if(!boardDto.getFile1().isEmpty()) {
                fileUploadService.fileSave(boardDto); // 새로운 파일 저장
                // 기존파일 삭제
                fileUploadService.fileDelete(oldFileName);
            }
            viewName = "redirect:/board_list/" + boardDto.getReqPage() + "/";
        }
        return viewName;
    }

    @GetMapping("/board_delete/{bid}/{reqPage}")
    public String board_delete(@PathVariable String bid, @PathVariable String reqPage, Model model) {
        model.addAttribute("bid", bid);
        model.addAttribute("reqPage", reqPage);
        return "/board/board_delete";
    }

    @PostMapping("/board_delete")
    public String board_delete(BoardDto boardDto) throws Exception {
        String oldBsFile = boardService.getBsfile(boardDto.getBid());
        int result = boardService.delete(boardDto.getBid());
        if(result == 1) {
            if(!oldBsFile.equals("")) {
                fileUploadService.fileDelete(oldBsFile);
            }
        }
        return "redirect:/board_list/" + boardDto.getReqPage() + "/";
    }

    @GetMapping("board_list_json")
    public String board_list_json(){
        return "/board/board_list_json";
    }
}
