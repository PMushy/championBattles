package com.java.factory;

import com.java.model.AbstractChampion;
import com.java.model.ChampionStatistics;
import com.java.model.Type;
import com.java.model.characterClass.Warrior;
import com.java.util.PropertiesUtils;
import lombok.ToString;

public class WarriorCreator implements ChampionCreator {
    private static final String WARRIOR = "warrior";
    PropertiesUtils propertiesUtils = PropertiesUtils.getInstance();

    @Override
    public AbstractChampion createChampion(String name, ChampionStatistics stats, Type type) {
        return new Warrior(name, stats, type);
    }

    @Override
    public AbstractChampion createChampionWithDefaultStats(String name, Type type) {
        int health = propertiesUtils
                .getPropertyValue(String.join(".", CONFIG, WARRIOR, DEFAULT_HEALTH));
        int defense = propertiesUtils
                .getPropertyValue(String.join(".", CONFIG, WARRIOR, DEFAULT_DEFENSE));
        int abilityPower = propertiesUtils
                .getPropertyValue(String.join(".", CONFIG, WARRIOR, DEFAULT_ABILITY_POWER));
        int attackDamage = propertiesUtils
                .getPropertyValue(String.join(".", CONFIG, WARRIOR, DEFAULT_ATTACK_DAMAGE));
        int charisma = propertiesUtils
                .getPropertyValue(String.join(".", CONFIG, WARRIOR, DEFAULT_CHARISMA));

        return new Warrior(name, new ChampionStatistics(health, defense, abilityPower, attackDamage, charisma), type);
    }

}