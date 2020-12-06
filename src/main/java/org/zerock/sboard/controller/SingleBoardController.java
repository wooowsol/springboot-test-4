package org.zerock.sboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.sboard.domain.SingleBoard;
import org.zerock.sboard.dto.GenericListDTO;
import org.zerock.sboard.dto.PageDTO;
import org.zerock.sboard.dto.SingleBoardDTO;
import org.zerock.sboard.service.SingleBoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/sboard")
public class SingleBoardController {

    private final SingleBoardService service;

    @GetMapping("/register")
    public void register(){
        log.info("/register........get");
    }

    @PostMapping("/register")
    public String register(SingleBoardDTO dto, RedirectAttributes rAttributes ){
        log.info("/register........post");
        log.info(dto);

        Long sno = service.register(dto);

        rAttributes.addFlashAttribute("result", sno);

        return "redirect:/sboard/list";
    }

    @GetMapping("/list")
    public void list(@ModelAttribute("pageDTO") PageDTO pageDTO ,   Model model){
        log.info("get........../sboard/list");

        GenericListDTO<SingleBoardDTO, SingleBoard> result = service.getList(pageDTO);

        result.getDtoList().forEach(dto -> log.info(dto));

        model.addAttribute("result", result);


    }

}