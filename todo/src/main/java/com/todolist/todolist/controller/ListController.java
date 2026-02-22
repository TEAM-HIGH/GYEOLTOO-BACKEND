package com.todolist.todolist.controller;

import com.todolist.todolist.dto.list.ListRequestDto;
import com.todolist.todolist.dto.list.ListResponseDto;
import com.todolist.todolist.service.TodoListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ListController {

    private final TodoListService todoListService;

    @GetMapping("/list")
    public List<ListResponseDto> getLists(){
        return todoListService.getLists();
    }

    @PostMapping("/list")
    public ListResponseDto createList(@RequestBody ListRequestDto listRequestDto){
        return todoListService.createList(listRequestDto);
    }

    @PatchMapping("/list/{listId}")
    public void patchList(@PathVariable Long listId, @RequestBody ListRequestDto listRequestDto){
        todoListService.editListTitle(listId, listRequestDto);
    }

    @DeleteMapping("/list/{listId}")
    public void deleteList(@PathVariable Long listId){
        todoListService.deleteListById(listId);
    }



}