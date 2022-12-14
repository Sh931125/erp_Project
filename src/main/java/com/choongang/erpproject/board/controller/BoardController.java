package com.choongang.erpproject.board.controller;



import com.choongang.erpproject.board.dao.BoardMapper;
import com.choongang.erpproject.board.dto.BoardDto;
import com.choongang.erpproject.board.service.BoardService;
import com.choongang.erpproject.info.dto.NoticeDto;

import com.choongang.erpproject.info.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/board/*")
public class BoardController {
    //    @Autowired
//    PromotionMapper promotionMapper;
    @Autowired
    private BoardService boardService;
    @Autowired
    BoardMapper boardMapper;

    @RequestMapping("/board")
    private String GotoBoard(Model model) {
        List<BoardDto> list = boardMapper.selectBoardList();
        System.out.println(list);
        model.addAttribute("info", list);
        return "/board/board";
    }

    @GetMapping("/viewBoard")
    private String viewBoard(long boardNum, Model model) {
        System.out.println(boardNum);
        BoardDto dto = boardService.read(boardNum);
        model.addAttribute("view", dto);
        boardMapper.updateViewCnt(boardNum);
        return "/board/viewBoard";
    }


    @RequestMapping("/writingBoard")
    private String WriteBoard() {
        return "/board/writingBoard";
    }



    @PostMapping("/upload")
// 업로드하는 파일들을 MultipartFile 형태의 파라미터로 전달된다.
    public String upload(Model model, BoardDto boardDto)
            throws IllegalStateException, IOException {
        boardMapper.insertBoard(boardDto);
        List<BoardDto> list = boardMapper.selectBoardList();
        model.addAttribute("info", list);
        return "redirect:/board/board";
    }

//
//    @GetMapping("/download")
//    public ResponseEntity<Resource> download(@ModelAttribute NoticeDto dto) throws IOException {
//        return fileService.download(dto);
//    }

//    @RequestMapping("/deleteBoard")
//    private String DeleteBoard(Model model, int boardNum) {
//        boardMapper.deleteBoard(boardNum);
//        List<BoardDto> list = boardMapper.selectBoardList();
//        model.addAttribute("info", list);
//        return "redirect:/board/board";
//    }




    @RequestMapping("/searchBoard")
    @ResponseBody
    private List<BoardDto> searchList(@RequestParam String start , @RequestParam String end, @RequestParam String title) {
        List<BoardDto> BoardList = boardMapper.searchBoard(start, end, title);
        return BoardList;
    }

    @RequestMapping("/deleteBoard")
    private String DeleteBoard(Model model, long boardNum) {
        boardMapper.deleteBoard(boardNum);
        List<BoardDto> list = boardMapper.selectBoardList();
        model.addAttribute("info", list);
        return "redirect:/board/board";
    }

    @GetMapping("/updateBoard")
    private String UpdateBoard(Model model, long boardNum) {
        BoardDto dto = boardService.read(boardNum);
        model.addAttribute("view", dto);
        return "/board/updateBoard";
    }

    @PostMapping("/update")
    public String update(long boardNum, Model model, @RequestParam String title, @RequestParam String content)
            throws IllegalStateException, IOException {
        boardMapper.updateBoard(boardNum, title, content);
        List<BoardDto> list = boardMapper.selectBoardList();
        model.addAttribute("info", list);
        return "redirect:/board/board";
    }


    @RequestMapping("/searchEmpName")
    @ResponseBody
    private List<BoardDto> searchEmpName(@RequestParam String empId) {
        List<BoardDto> BoardList = boardMapper.findEmpName(empId);
        return BoardList;
    }
}