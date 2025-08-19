package com.devsuperior.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.services.GameListService;

@RestController
@RequestMapping(value = "/lists") // o caminho que sera respondido na API
public class GameListController { // implementa a API Rest, expondo um endpoint para o mundo externo

    @Autowired
    private GameListService gameListService; // injeta o service, seguindo as camadas REST

    @GetMapping
    public List<GameListDTO> findAll() {
        List<GameListDTO> result = gameListService.findALL();
        return result;
    }
}
