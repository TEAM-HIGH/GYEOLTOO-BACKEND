package com.todolist.todolist.domain.board.controller;

import com.todolist.todolist.domain.board.dto.request.BoardRequest;
import com.todolist.todolist.domain.board.service.BoardService;
import com.todolist.todolist.domain.board.dto.response.BoardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/board")
    public List<BoardResponse> getBoards(){
        return boardService.getBoards();
    }

    @PostMapping("/board")
    public ResponseEntity<BoardResponse> createBoard(@RequestBody BoardRequest boardRequest) {
        BoardResponse boardResponse = boardService.createBoard(boardRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(boardResponse);
    }

    @PatchMapping("/board")
    public ResponseEntity<BoardResponse> updateBoard(@RequestBody BoardRequest boardRequest,@RequestParam Long id) {
        BoardResponse boardResponse = boardService.updateBoard(boardRequest, id);
        return ResponseEntity.ok(boardResponse);
    }

    @GetMapping("/health")
    public String healthCheck() {
        return "OK";
    }
}
