package com.todolist.todolist.controller;

import com.todolist.todolist.dto.card.CardRequestDto;
import com.todolist.todolist.dto.card.CardResponseDto;
import com.todolist.todolist.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @GetMapping("/lists/{listId}/cards")
    public List<CardResponseDto> getCards(@PathVariable Long listId){
        return cardService.getCardsByListId(listId);
    }

    @PostMapping("/lists/{listId}/cards")
    public CardResponseDto createCard(@PathVariable Long listId, @RequestBody CardRequestDto cardRequestDto){
        return cardService.createCard(listId, cardRequestDto);
    }

    @PatchMapping("/cards/{cardId}")
    public CardResponseDto updateCard(@PathVariable Long cardId, @RequestBody CardRequestDto cardRequestDto){
        return cardService.editCard(cardId, cardRequestDto);
    }

    @DeleteMapping("cards/{cardId}")
    public void deleteCard(@PathVariable Long cardId){
        cardService.deleteCardById(cardId);
    }

}