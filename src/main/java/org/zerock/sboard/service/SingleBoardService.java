package org.zerock.sboard.service;

import org.springframework.transaction.annotation.Transactional;
import org.zerock.sboard.domain.SingleBoard;
import org.zerock.sboard.dto.GenericListDTO;
import org.zerock.sboard.dto.PageDTO;
import org.zerock.sboard.dto.SingleBoardDTO;

@Transactional
public interface SingleBoardService {

    Long register(SingleBoardDTO dto);

    GenericListDTO<SingleBoardDTO, SingleBoard> getList(PageDTO pageDTO);

    default SingleBoard bindToEntity(SingleBoardDTO dto){

        SingleBoard entity = SingleBoard.builder()
        .sno(dto.getSno())
        .title(dto.getTitle())
        .content(dto.getContent())
        .writer(dto.getWriter())
        .build();

        return entity;
    }

    default SingleBoardDTO bindToDTO(SingleBoard entity){

        SingleBoardDTO dto = SingleBoardDTO.builder()
        .sno(entity.getSno())
        .title(entity.getTitle())
        .content(entity.getContent())
        .writer(entity.getWriter())
        .regdate(entity.getRegdate())
        .moddate(entity.getModdate())
        .build();

        return dto;
    }

}