package org.zerock.sboard.dto;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import lombok.Data;

@Data
public class PageDTO {
    
    private int page;
    private int size;

    public PageDTO(){
        this.page = 1; //무조건 처음에 1ㅠㅔ이지 
        this.size = 10;
    
    }

    //모든 리스트 페이지에 공통으로 들어가게 //첨부파일 사용되지 않는 코드 정리하는 거 .sno로 desc 하는거, 다른걸로 정렬할 필요,  
    public Pageable  makePageable(Sort sort){
        return PageRequest.of(this.page -1, this.size, sort);
    }
}