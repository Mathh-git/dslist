package com.devsuperior.dslist.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;

import java.util.List;

@Service
public class GameService { // retorna o DTO, aplica a regra de negócio

    @Autowired
    private GameRepository gameRepository; // injeta uma instância do GameRepository no GameService, seguindo as camadas REST

    @Transactional(readOnly = true) // boa prática, garante que os princípios ASID sejam respeitados
    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id).get();
        return new GameDTO(result);
    }

     @Transactional(readOnly = true)  
    public List<GameMinDTO> findALL() {
        List<Game> result = gameRepository.findAll(); // gera uma consulta dos games no banco de dados e a converte em uma lista de games com menos dados
        //transforma uma lista de Games, com todos os dados, para uma lista de GameMinDTO, onde há apenas os dados do DTO
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList(); 
        return dto;
    }
}
