package com.todolist.todolist.service;

import com.todolist.todolist.dto.card.CardRequestDto;
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
