package com.todolist.todolist.domain.board.service;

import com.todolist.todolist.domain.board.dto.request.BoardRequest;
import com.todolist.todolist.domain.board.entity.BoardEntity;
import com.todolist.todolist.domain.board.repository.BoardRepository;
import com.todolist.todolist.domain.board.dto.response.BoardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public List<BoardResponse> getBoards() {
        List<BoardEntity> BoardEntityList = boardRepository.findAll();
        return BoardEntityList
                .stream()
                .map(BoardResponse::from)
                .toList();
    }

    @Transactional
    public BoardResponse createBoard(BoardRequest boardRequest) {
        BoardEntity boardEntity = boardRequest.toEntity();
        BoardEntity savedEntity = boardRepository.save(boardEntity);
        return BoardResponse.from(savedEntity);
    }

    @Transactional
    public BoardResponse updateBoard(BoardRequest boardRequest, Long id) {
        BoardEntity boardEntity = boardRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("보드 찾지 못함"));
        return BoardResponse.from(boardEntity);
    }

    @Transactional
    public void deleteBoard(Long id) {
        BoardEntity boardEntity = boardRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("삭제할 보드 찾지 못함"));
        boardRepository.delete(boardEntity);
    }
}
