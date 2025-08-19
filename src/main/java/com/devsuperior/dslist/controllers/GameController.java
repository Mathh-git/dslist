package com.devsuperior.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.services.GameService;

@RestController
@RequestMapping(value = "/games") // o caminho que sera respondido na API
public class GameController { // implementa a API Rest, expondo um endpoint para o mundo externo

    @Autowired
    private GameService gameService; // injeta o service, seguindo as camadas REST

    @GetMapping(value = "/{id}") // configura que na requisição além do link ..../game já definido, o caminho também deverá conter um parâmetro id
    public GameDTO findById(@PathVariable Long id) {
        GameDTO result = gameService.findById(id);
        return result;
    }

    @GetMapping
    public List<GameMinDTO> findAll() {
        List<GameMinDTO> result = gameService.findALL();
        return result;
    }
}
