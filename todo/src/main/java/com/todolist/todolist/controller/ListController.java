package com.todolist.todolist.controller;

import com.todolist.todolist.dto.list.ListRequestDto;
import com.todolist.todolist.dto.list.ListResponseDto;
import com.todolist.todolist.service.ListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ListController {

    private final ListService ListService;

    @GetMapping("/list")
    public List<ListResponseDto> getLists(){
        return ListService.getLists();
    }

    @PostMapping("/list")
    public ListResponseDto createList(@RequestBody ListRequestDto listRequestDto){
        return ListService.createList(listRequestDto);
    }

    @PatchMapping("/list/{listId}")
    public void patchList(@PathVariable Long listId, @RequestBody ListRequestDto listRequestDto){
        ListService.editListTitle(listId, listRequestDto);
    }

    @DeleteMapping("/list/{listId}")
    public void deleteList(@PathVariable Long listId){
        ListService.deleteListById(listId);
    }
}