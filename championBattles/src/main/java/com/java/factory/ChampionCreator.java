package com.java.factory;

import com.java.model.AbstractChampion;
import com.java.model.ChampionStatistics;
import com.java.model.Type;
import lombok.ToString;

public interface ChampionCreator {
    String CONFIG = "config";
    String DEFAULT_HEALTH = "defaultHealth";
    String DEFAULT_DEFENSE = "defaultDefense";
    String DEFAULT_ABILITY_POWER = "defaultAbilityPower";
    String DEFAULT_ATTACK_DAMAGE = "defaultAttackDamage";
    String DEFAULT_CHARISMA = "defaultCharisma";

    AbstractChampion createChampion(String name, ChampionStatistics stats, Type type);

    AbstractChampion createChampionWithDefaultStats(String name, Type type);

}
