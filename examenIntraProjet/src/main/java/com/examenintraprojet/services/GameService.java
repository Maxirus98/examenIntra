package com.examenintraprojet.services;

import com.examenintraprojet.repositories.GameRepository;
import com.examenintraprojet.models.Game;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log
public class GameService {

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Game saveGame(Game game){
       return this.gameRepository.save(game);
    }

    public List<Game> getGames(){
        log.info("all repo" + this.gameRepository.findAll());
        return this.gameRepository.findAll();
    }
}
