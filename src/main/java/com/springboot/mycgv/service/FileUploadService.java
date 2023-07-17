package com.springboot.mycgv.service;

import com.springboot.mycgv.dto.BoardDto;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class FileUploadService {
    /*
     * fileDelete - 게시글 삭제 시 파일 삭제
     */
    public void fileDelete(String oldFileName) throws Exception {

        //파일의 삭제 위치
        String root_path = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\upload\\"; // 파일의 저장위치

        //파일이 이미 존재하면 삭제
            File deleteFile = new File(root_path + oldFileName);
            if(deleteFile.exists()) {
                deleteFile.delete();
            }
    }


//    /*
//     * fileDelete - 파일 수정 시 기존 파일 삭제
//     */
//    public void fileDelete(BoardDto boardDto, String oldFileName) throws IOException {
//
//        //파일의 삭제 위치
//        String root_path = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\upload\\"; // 파일의 저장위치
//
//        //파일이 이미 존재하면 삭제
//        if(!boardDto.getFile1().getOriginalFilename().equals("")) { //새로운 파일 선택
//            File deleteFile = new File(root_path  + oldFileName);
//            if(deleteFile.exists()) {
//                deleteFile.delete();
//            }
//        }
//    }


    /*
     * fileSave 기능 - 파일이 존재하면 서버에 저장하는 메소드
     */
    public void fileSave(BoardDto boardDto) throws IOException {
        //파일의 저장 위치
        String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\upload\\"; // 파일의 저장위치
        System.out.println("path-->" + projectPath);
        //파일이 존재하면 서버에 저장
        if(boardDto.getFile1().getOriginalFilename() != null && !boardDto.getFile1().getOriginalFilename().equals("")) {
            File saveFile = new File(projectPath +  boardDto.getBsfile());
            boardDto.getFile1().transferTo(saveFile);
        }
    }

    /*
     * fileCheck 기능 - 파일이 존재하면 boardVo에 bfile, bsfile set!, 없으면 boardVo 리턴!
     */
    public Object fileCheck(BoardDto boardDto) {
        if(boardDto.getFile1().getOriginalFilename() != null
                && !boardDto.getFile1().getOriginalFilename().equals("")) { // 선택한 파일이 존재하면

            //BSFILE 파일 중복 처리
            UUID uuid = UUID.randomUUID();
            String bfile = boardDto.getFile1().getOriginalFilename();
            String bsfile = uuid + "_" + bfile;
            System.out.println(bfile);
            System.out.println(bsfile);

            boardDto.setBfile(bfile);
            boardDto.setBsfile(bsfile);
        } else {
            System.out.println("파일 없음");
//			 boardVo.setBfile("");
//			 boardVo.setBsfile("");
        }
        return boardDto;
    }

}
