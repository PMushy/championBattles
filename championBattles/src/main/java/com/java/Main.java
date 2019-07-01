package com.java;

import com.java.factory.ChampionCreator;
import com.java.model.AbstractChampion;
import com.java.model.ChampionStatistics;
import com.java.model.Type;
import com.java.model.characterClass.Mage;
import com.java.model.characterClass.Warrior;
import com.java.util.PropertiesUtils;

public class Main {
    public static void main(String[] args) {
        PropertiesUtils.getInstance().loadProperties();

        Warrior warrior = new Warrior("WojBody", new ChampionStatistics(100, 10, 10, 35, 10), Type.EVIL);
        Mage mage = new Mage("Czarodziej", new ChampionStatistics(144, 2, 20, 20, 20), Type.GOOD);

        System.out.println(warrior + "\n");
        System.out.println(mage + "\n");

        Fight fight = new Fight();
        System.out.println(fight.startFight(warrior, mage));

//        ChampionCreator championA = new WarriorCreator();
//        ChampionCreator championB = new MageCreator();
//        ChampionCreator championC = new ArcherCreator();
//        ChampionCreator championD = new RogueCreator();
//
//        generateChampion(championC);
//        generateChampion(championB);
//
//        generateDefaultChampion(championA);
//        generateDefaultChampion(championD);
//
//        Fight fight = new Fight();
//        System.out.println(fight.startFight(createDefaultChampion(championA), createDefaultChampion(championC)));
    }

    public static void generateChampion(ChampionCreator creator) {
        AbstractChampion champion = creator
                .createChampion(
                        "ChampionGG", new ChampionStatistics(10, 5, 15, 23, 7), Type.GOOD);
        System.out.println(champion + "\n");
    }

    public static void generateDefaultChampion(ChampionCreator creator) {
        AbstractChampion champion = creator.createChampionWithDefaultStats("ChampionGDE", Type.EVIL);
        System.out.println(champion + "\n");
    }

    public static AbstractChampion createChampion(ChampionCreator creator) {
        AbstractChampion champion = creator.createChampion
                ("ChampionCG", new ChampionStatistics(50, 5, 15, 10, 0), Type.GOOD);
        return champion;
    }

    public static AbstractChampion createDefaultChampion(ChampionCreator creator) {
        AbstractChampion champion = creator.createChampionWithDefaultStats(
                "ChampionCDE", Type.EVIL);
        return champion;
    }
}
