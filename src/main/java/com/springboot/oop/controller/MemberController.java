package com.springboot.oop.controller;

import com.springboot.oop.dto.MemberDto;
import com.springboot.oop.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;


    @GetMapping("/{id}/{pass}")
    public ResponseEntity<?> login(@PathVariable String id, @PathVariable String pass) {
        if(memberService.login(id, pass)) {
            return ResponseEntity.status(HttpStatus.OK).body("Success Login");
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Forbidden");
    }

    @PostMapping
    public ResponseEntity<?> join(MemberDto memberDto) {
        memberService.join(memberDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<?> modify(MemberDto memberDto) {
        memberService.modify(memberDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        memberService.delete(id);
        return ResponseEntity.ok().build();
    }


}
