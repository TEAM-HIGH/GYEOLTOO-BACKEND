package com.todolist.todolist.domain.list.service;

import com.todolist.todolist.domain.board.entity.BoardEntity;
import com.todolist.todolist.domain.board.repository.BoardRepository;
import com.todolist.todolist.domain.list.dto.ListRequestDto;
import com.todolist.todolist.domain.list.dto.ListResponseDto;
import com.todolist.todolist.domain.list.entity.ListEntity;
import com.todolist.todolist.domain.list.repository.ListRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListService {

    private final ListRepository listRepository;
    private final BoardRepository boardRepository;

    @Transactional(readOnly=true)
    public List<ListResponseDto> getLists() {
        return listRepository.findAll()
                .stream()
                .map(ListResponseDto::from)
                .toList();
    }

    @Transactional
    public ListResponseDto createList(ListRequestDto listRequestDto, Long boardId) {
        BoardEntity boardEntity = boardRepository.findById(boardId)
                .orElseThrow(() -> new EntityNotFoundException("보드를 찾을 수 없습니다."));
        ListEntity listEntity = ListEntity.builder()
                .title(listRequestDto.getTitle())
                .board(boardEntity)
                .build();

        ListEntity savedEntity = listRepository.save(listEntity);
        return ListResponseDto.from(savedEntity);
    }

    @Transactional
    public void editListTitle(Long id, ListRequestDto listRequestDto) {
        ListEntity listEntity = listRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 아이디가 없습니다."));
        listEntity.UpdateListTitle(listRequestDto.getTitle());
    }

    @Transactional
    public void deleteListById(Long id) {
        ListEntity deleteEntity = listRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 아이디가 없어 삭제할 수 없습니다."));
        listRepository.delete(deleteEntity);
    }

}
