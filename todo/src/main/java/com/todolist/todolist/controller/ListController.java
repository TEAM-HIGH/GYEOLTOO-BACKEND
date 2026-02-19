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

    @PatchMapping("/list/{id}")
    public void patchList(@PathVariable Long id, @RequestBody ListRequestDto listRequestDto){
        todoListService.editListTitle(listRequestDto, id);
    }

    @DeleteMapping("/list/{id}")
    public void deleteList(@PathVariable Long id){
        todoListService.deleteListById(id);
    }
}