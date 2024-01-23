package com.lxi.gamefication.repository;

import org.springframework.data.repository.CrudRepository;

import com.lxi.gamefication.model.LeaderBoard;

public interface LeaderBoardRepo extends CrudRepository<LeaderBoard,Long>{
    
}
