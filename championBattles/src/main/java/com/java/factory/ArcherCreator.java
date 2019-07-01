package com.java.factory;

import com.java.model.AbstractChampion;
import com.java.model.ChampionStatistics;
import com.java.model.Type;
import com.java.model.characterClass.Archer;
import com.java.util.PropertiesUtils;

public class ArcherCreator implements ChampionCreator {
    private static final String ARCHER = "archer";
    private PropertiesUtils propertiesUtils = PropertiesUtils.getInstance();

    @Override
    public AbstractChampion createChampion(String name, ChampionStatistics stats, Type type) {
        return new Archer(name, stats, type);
    }

    @Override
    public AbstractChampion createChampionWithDefaultStats(String name, Type type) {
        int health = propertiesUtils
                .getPropertyValue(String.join(".", CONFIG, ARCHER, DEFAULT_HEALTH));
        int defense = propertiesUtils
                .getPropertyValue(String.join(".", CONFIG, ARCHER, DEFAULT_DEFENSE));
        int abilityPower = propertiesUtils
                .getPropertyValue(String.join(".", CONFIG, ARCHER, DEFAULT_ABILITY_POWER));
        int attackDamage = propertiesUtils
                .getPropertyValue(String.join(".", CONFIG, ARCHER, DEFAULT_ATTACK_DAMAGE));
        int charisma = propertiesUtils
                .getPropertyValue(String.join(".", CONFIG, ARCHER, DEFAULT_CHARISMA));

        return new Archer(name, new ChampionStatistics(health, defense, abilityPower, attackDamage, charisma), type);
    }
}
