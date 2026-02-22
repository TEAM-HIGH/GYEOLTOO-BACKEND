package com.todolist.todolist.controller;

import com.todolist.todolist.dto.card.CardRequestDto;
import com.todolist.todolist.dto.card.CardResponseDto;
import com.todolist.todolist.service.TodoListService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CardController {

    private TodoListService todoListService;

    @GetMapping("/list/{listId}/cards")
    public List<CardResponseDto> getCards(@PathVariable Long listId){
        return todoListService.getCardsByListId(listId);
    }

//    @PostMapping("/cards/{listId}")
//    public CardResponseDto createCard(@PathVariable Long listId, @RequestBody CardRequestDto cardRequestDto){
//        return todoListService.createCard(listId, cardRequestDto);
//    }
}