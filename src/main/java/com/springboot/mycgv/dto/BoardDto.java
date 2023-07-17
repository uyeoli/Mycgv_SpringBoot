package com.springboot.mycgv.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Data
public class BoardDto {
    int rno, bhits;
    String bid, btitle, bcontent, id, bdate, bfile, bsfile;
    String reqPage;
    MultipartFile file1; //폼에서 넘어오는 파일객체
}
