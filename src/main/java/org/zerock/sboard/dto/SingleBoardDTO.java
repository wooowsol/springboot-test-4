package org.zerock.sboard.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SingleBoardDTO {
    
    private Long sno;

    private String title;

    private String content;

    private String writer;

    private LocalDateTime regdate, moddate;

}