package com.java.util;

import com.java.exceptions.InvalidChampionDataException;
import com.java.model.AbstractChampion;
import com.java.model.ChampionStatistics;
import com.java.model.Type;
import com.java.model.characterClass.Archer;
import com.java.model.characterClass.Mage;
import com.java.model.characterClass.Rogue;
import com.java.model.characterClass.Warrior;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AbstractChampionUtils {

    public static AbstractChampion createChampionFromString(String championString) {
        String[] championParts = championString.split(";");

        if (championParts.length != 8) {
            throw new InvalidChampionDataException("Wrong numer of fields, expeted 6"
                    + " but was: " + championParts.length);
        }

        String name = championParts[1];

        int health, defense, abilityPower, attackDamage, charisma;

        try {
            health = Integer.valueOf(championParts[2]);
            defense = Integer.valueOf(championParts[3]);
            abilityPower = Integer.valueOf(championParts[4]);
            attackDamage = Integer.valueOf(championParts[5]);
            charisma = Integer.valueOf(championParts[6]);
        } catch (NumberFormatException ex) {
            throw new InvalidChampionDataException(
                    "One of hero statistics has wrong format", ex);
        }
        Type type = Type.valueOf(championParts[7]);

        AbstractChampion champion;
        if ("Warrior".equals(championParts[0])) {
            champion = new Warrior();
            champion.setName(name);
            champion.setStats(new ChampionStatistics(health, defense, abilityPower, attackDamage, charisma));
            champion.setType(type);
        } else if ("Mage".equals(championParts[0])) {
            champion = new Mage();
            champion.setName(name);
            champion.setStats(new ChampionStatistics(health, defense, abilityPower, attackDamage, charisma));
            champion.setType(type);
        } else if ("Archer".equals(championParts[0])) {
            champion = new Archer();
            champion.setName(name);
            champion.setStats(new ChampionStatistics(health, defense, abilityPower, attackDamage, charisma));
            champion.setType(type);
        } else {
            champion = new Rogue();
            champion.setName(name);
            champion.setStats(new ChampionStatistics(health, defense, abilityPower, attackDamage, charisma));
            champion.setType(type);
        }
        return champion;
    }

    public static void saveChampionToFile(List<AbstractChampion> champions, String fileName) throws IOException {
        try (FileWriter fileWriter = new FileWriter(fileName);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
             PrintWriter printWriter = new PrintWriter(bufferedWriter)) {
            champions.forEach(champion -> printWriter.write(champion.parseToString() + "\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<AbstractChampion> readHeroesFromFile(String fileName) {
        List<AbstractChampion> heroes = new ArrayList<>();
        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line = bufferedReader.readLine();
            while (line != null) {
                heroes.add(createChampionFromString(line));
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return heroes;
    }
}
