package com.springboot.mycgv.dto;

import lombok.Data;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.ArrayList;

@Data
public class NoticeDto {
    int rno, nhits;
    String nid, ntitle, ncontent, ndate;
    //파일 업로드
    CommonsMultipartFile[] files;
    String nfile1, nsfile1, nfile2, nsfile2;
    ArrayList<String> nfiles = new ArrayList<String>();
    ArrayList<String> nsfiles = new ArrayList<String>();
}
