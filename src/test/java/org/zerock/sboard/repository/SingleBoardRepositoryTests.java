package org.zerock.sboard.repository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.sboard.domain.SingleBoard;

@SpringBootTest

public class SingleBoardRepositoryTests {

    @Autowired
    private SingleBoardRepository repository;

    @Test
    public void testUpdateByQuery(){

        int count = repository.updateTitle("Updated by Query", 300L, LocalDateTime.now());

        System.out.println("COUNT: " + count);

    }

    @Test
    public void testUpdate(){

        Optional<SingleBoard> result 
          = repository.findById(300L);
        
        SingleBoard singleBoard = result.get();
        
        //System.out.println(singleBoard);

        singleBoard.changeTitle("Updated..........33333..300");

        repository.save(singleBoard);
        

    }

    @Test
    public void testInsert(){
        IntStream.rangeClosed(1,300).forEach(i -> {

            SingleBoard board = 
              SingleBoard.builder().title("title.."+i)
              .content("content.."+i)
              .writer("user" + (i % 10))
              .build();
            
            repository.save(board);  

        });
    }
    
}