package com.todolist.todolist.controller;

import com.todolist.todolist.dto.card.CardResponseDto;
import com.todolist.todolist.service.TodoListService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardController {

    private TodoListService todoListService;

    @GetMapping("/list/{listId}/cards")
    public List<CardResponseDto> getCards(@PathVariable Long listId){
        return todoListService.getCardsByListId(listId);
    }
}