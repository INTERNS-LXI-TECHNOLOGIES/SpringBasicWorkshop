package com.lxi.gamefication.restcontroller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lxi.gamefication.model.ChallengeSolvedEvent;
import com.lxi.gamefication.service.LeaderBoardService;

@RestController
@RequestMapping("/gamefeature")
public class LeaderBoardController {
  
    private final LeaderBoardService leaderBoardService;

    public LeaderBoardController(LeaderBoardService leaderBoardService){
        this.leaderBoardService = leaderBoardService;
    }

    @PostMapping("/")
    public String saveScore(ChallengeSolvedEvent challengeSolvedDTO){
        return leaderBoardService.saveScore(challengeSolvedDTO);
    }
}
