package com.todolist.todolist.service;

import com.todolist.todolist.dto.card.CardRequestDto;
import com.todolist.todolist.dto.card.CardResponseDto;
import com.todolist.todolist.entity.CardEntity;
import com.todolist.todolist.entity.ListEntity;
import com.todolist.todolist.repository.card.CardRepository;
import com.todolist.todolist.repository.list.ListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;
    private final ListRepository listRepository;
    private final ListEntity listEntity;

    @Transactional(readOnly=true)
    public List<CardResponseDto> getCardsByListId(Long listId){
        ListEntity listEntity = listRepository.findById(listId)
                .orElseThrow(()-> new IllegalArgumentException("id가 존재하지 않습니다."));

        return cardRepository.findAllByTodoListId(listEntity.getId())
                .stream()
                .map(CardResponseDto::from)
                .toList();
    }

    @Transactional
    public CardResponseDto createCard(Long listId, CardRequestDto cardRequestDto) {
        ListEntity listEntity = listRepository.findById(listId)
                .orElseThrow(()->new IllegalArgumentException("리스트가 없습니다."));
        CardEntity savedEntity = cardRepository.save(cardRequestDto.toEntity(listEntity));

        return CardResponseDto.from(savedEntity);
    }

    @Transactional
    public void deleteCardById(Long cardId){
        CardEntity cardEntity = cardRepository.findById(cardId)
                .orElseThrow(()->new IllegalArgumentException("리스트가 없습니다."));

        cardRepository.delete(cardEntity);
    }

    @Transactional
    public CardResponseDto editCard(Long cardId, CardRequestDto cardRequestDto) {
        CardEntity cardEntity = cardRepository.findById(cardId)
                .orElseThrow(()->new IllegalArgumentException("카드가 존재하지 않습니다."));

        cardEntity.update(
                cardRequestDto.getTitle(),
                cardRequestDto.getContent(),
                cardRequestDto.getEmoji(),
                cardRequestDto.isCompleted(),
                cardRequestDto.getDueDate(),
                cardRequestDto.getPosition()
        );
        return CardResponseDto.from(cardEntity);
    }
}
