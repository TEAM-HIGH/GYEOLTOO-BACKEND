package com.todolist.todolist.domain.list.controller;

import com.todolist.todolist.domain.list.dto.ListRequestDto;
import com.todolist.todolist.domain.list.dto.ListResponseDto;
import com.todolist.todolist.domain.list.service.ListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/lists")
public class ListController {

    private final ListService ListService;

    @GetMapping()
    public List<ListResponseDto> getLists(){
        return ListService.getLists();
    }

    @PostMapping("/{boardId}")
    public ListResponseDto createList(@PathVariable Long boardId, @RequestBody ListRequestDto listRequestDto){
        return ListService.createList(listRequestDto, boardId);
    }

    @PatchMapping("/{listId}")
    public void patchList(@PathVariable Long listId, @RequestBody ListRequestDto listRequestDto){
        ListService.editListTitle(listId, listRequestDto);
    }

    @DeleteMapping("/{listId}")
    public void deleteList(@PathVariable Long listId){
        ListService.deleteListById(listId);
    }
}