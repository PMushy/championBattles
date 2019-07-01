package com.java.factory;

import com.java.model.AbstractChampion;
import com.java.model.ChampionStatistics;
import com.java.model.Type;
import com.java.model.characterClass.Mage;
import com.java.util.PropertiesUtils;

public class MageCreator implements ChampionCreator {
    private static final String MAGE = "mage";
    PropertiesUtils propertiesUtils = PropertiesUtils.getInstance();

    @Override
    public AbstractChampion createChampion(String name, ChampionStatistics stats, Type type) {
        return new Mage(name, stats, type);
    }

    @Override
    public AbstractChampion createChampionWithDefaultStats(String name, Type type) {
        int health = propertiesUtils
                .getPropertyValue(String.join(".", CONFIG, MAGE, DEFAULT_HEALTH));
        int defense = propertiesUtils
                .getPropertyValue(String.join(".", CONFIG, MAGE, DEFAULT_DEFENSE));
        int abilityPower = propertiesUtils
                .getPropertyValue(String.join(".", CONFIG, MAGE, DEFAULT_ABILITY_POWER));
        int attackDamage = propertiesUtils
                .getPropertyValue(String.join(".", CONFIG, MAGE, DEFAULT_ATTACK_DAMAGE));
        int charisma = propertiesUtils
                .getPropertyValue(String.join(".", CONFIG, MAGE, DEFAULT_CHARISMA));

        return new Mage(name, new ChampionStatistics(health, defense, abilityPower, attackDamage, charisma), type);
    }
}
