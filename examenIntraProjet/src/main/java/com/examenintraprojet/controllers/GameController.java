package com.examenintraprojet.controllers;

import com.examenintraprojet.services.GameService;
import com.examenintraprojet.models.Game;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/game")
@CrossOrigin("http://localhost:3000")
@Log
public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }


    @PostMapping("/save")
    public ResponseEntity<Game> saveGame(@RequestBody Game game) {
        return new ResponseEntity<Game>(gameService.saveGame(game), HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Game>> getGames(){
        log.info("all serv" + gameService.getGames());
        return new ResponseEntity<List<Game>>(gameService.getGames(), HttpStatus.OK);
    }
}
