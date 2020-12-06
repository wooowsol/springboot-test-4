package org.zerock.sboard.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.zerock.sboard.domain.SingleBoard;
import org.zerock.sboard.dto.GenericListDTO;
import org.zerock.sboard.dto.PageDTO;
import org.zerock.sboard.dto.SingleBoardDTO;
import org.zerock.sboard.repository.SingleBoardRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class SingleBoardServiceImpl implements SingleBoardService {

    private final SingleBoardRepository singleBoardRepository;

    @Override
    public Long register(final SingleBoardDTO dto) {

        SingleBoard entity = bindToEntity(dto);

        singleBoardRepository.save(entity);

        return entity.getSno();
    }

    @Override
    public GenericListDTO<SingleBoardDTO, SingleBoard> getList(PageDTO pageDTO) {

        Sort sort = Sort.by("sno").descending();

        Pageable pageable = pageDTO.makePageable(sort);

        Page<SingleBoard> result = singleBoardRepository.findAll(pageable);

        log.info(result);

        GenericListDTO<SingleBoardDTO, SingleBoard> listDTO
          = new GenericListDTO<>(result, en -> bindToDTO(en));

        return listDTO;
    }

}