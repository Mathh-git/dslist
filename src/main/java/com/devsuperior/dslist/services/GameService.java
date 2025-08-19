package com.devsuperior.dslist.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;

import java.util.List;

@Service
public class GameService { // retorna o DTO

    @Autowired
    private GameRepository gameRepository; // injeta uma instância do GameRepository no GameService, seguindo as camadas REST

    // gera uma consulta dos games no banco de dados e a converte em uma lista de games
    public List<GameMinDTO> findALL() {
        List<Game> result = gameRepository.findAll();
        //transforma uma lista de Games, com todos os dados, para uma lista de GameMinDTO, onde há apenas os dados do DTO
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList(); 
        return dto;
    }
}
