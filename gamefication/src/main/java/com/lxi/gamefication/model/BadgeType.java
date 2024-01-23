package com.lxi.gamefication.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter

public enum BadgeType {
    
    BRONZE("Bronze"),
    SILVER("Silver"),
    GOLD("Gold");
    private final String description;

}
