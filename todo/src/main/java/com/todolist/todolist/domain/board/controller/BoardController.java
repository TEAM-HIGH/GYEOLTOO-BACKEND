package com.todolist.todolist.domain.board.controller;

import com.todolist.todolist.domain.list.dto.BoardResponseDto;
import com.todolist.todolist.domain.list.service.ListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardController {
    private final ListService listService;

    @GetMapping("board")
    public List<BoardResponseDto> getBoards(){
        return listService.getBoards();
    }

}
