package com.devsuperior.dslist.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.repositories.GameListRepository;

import java.util.List;

@Service
public class GameListService { // retorna o DTO, aplica a regra de negócio

    @Autowired
    private GameListRepository gameListRepository;

     @Transactional(readOnly = true)  
    public List<GameListDTO> findALL() {
        List<GameList> result = gameListRepository.findAll(); 
        return result.stream().map(x -> new GameListDTO(x)).toList(); 
    }
}
