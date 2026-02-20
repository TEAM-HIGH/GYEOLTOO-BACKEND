package com.todolist.todolist.service;

import com.todolist.todolist.dto.card.CardResponseDto;
import com.todolist.todolist.dto.list.ListRequestDto;
import com.todolist.todolist.dto.list.ListResponseDto;
import com.todolist.todolist.entity.CardEntity;
import com.todolist.todolist.entity.ListEntity;
import com.todolist.todolist.repository.card.CardRepository;
import com.todolist.todolist.repository.list.ListRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoListService {
    private final CardRepository cardRepository;
    private final ListRepository listRepository;

    @Transactional(readOnly=true)
    public List<ListResponseDto> getLists() {
        return listRepository.findAll()
                .stream()
                .map(ListResponseDto::from)
                .toList();
    }

    @Transactional
    public ListResponseDto createList(ListRequestDto listRequestDto) {
        ListEntity listEntity = listRequestDto.toEntity();
        ListEntity savedEntity = listRepository.save(listEntity);
        return ListResponseDto.from(savedEntity);
    }

    @Transactional
    public void editListTitle(ListRequestDto listRequestDto, Long id) {
        ListEntity listEntity = listRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 아이디가 없습니다."));
        listEntity.UpdateListTitle(listEntity.getTitle());
    }

    @Transactional
    public void deleteListById(Long id) {
        ListEntity deleteEntity = listRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 아이디가 없어 삭제할 수 없습니다."));
        listRepository.delete(deleteEntity);
    }

    @Transactional(readOnly=true)
    public List<CardResponseDto> getCardsByListId(Long listId){
        ListEntity listEntity = listRepository.findById(listId)
                .orElseThrow(()-> new IllegalArgumentException("id가 존재하지 않습니다."));

        return cardRepository.findAllByTodoListId(listEntity.getId())
                .stream()
                .map(CardResponseDto::from)
                .toList();
    }
}