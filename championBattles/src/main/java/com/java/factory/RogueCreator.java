package com.java.factory;

import com.java.model.AbstractChampion;
import com.java.model.ChampionStatistics;
import com.java.model.Type;
import com.java.model.characterClass.Rogue;
import com.java.util.PropertiesUtils;

public class RogueCreator implements ChampionCreator {
    private static final String ROGUE = "rogue";
    PropertiesUtils propertiesUtils = PropertiesUtils.getInstance();

    @Override
    public AbstractChampion createChampion(String name, ChampionStatistics stats, Type type) {
        return new Rogue(name, stats, type);
    }

    @Override
    public AbstractChampion createChampionWithDefaultStats(String name, Type type) {
        int health = propertiesUtils
                .getPropertyValue(String.join(".", CONFIG, ROGUE, DEFAULT_HEALTH));
        int defense = propertiesUtils
                .getPropertyValue(String.join(".", CONFIG, ROGUE, DEFAULT_DEFENSE));
        int abilityPower = propertiesUtils
                .getPropertyValue(String.join(".", CONFIG, ROGUE, DEFAULT_ABILITY_POWER));
        int attackDamage = propertiesUtils
                .getPropertyValue(String.join(".", CONFIG, ROGUE, DEFAULT_ATTACK_DAMAGE));
        int charisma = propertiesUtils
                .getPropertyValue(String.join(".", CONFIG, ROGUE, DEFAULT_CHARISMA));

        return new Rogue(name, new ChampionStatistics(health, defense, abilityPower, attackDamage, charisma), type);
    }
}
