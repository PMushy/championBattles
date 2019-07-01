package com.java.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Getter
@NoArgsConstructor
public class ChampionStatistics {
    private int health;
    private int defense;
    private int abilityPower;
    private int attackDamage;
    private int charisma;

    public ChampionStatistics(int health, int defense, int abilityPower, int attackDamage, int charisma) {
        this.health = health;
        this.defense = defense;
        this.abilityPower = abilityPower;
        this.attackDamage = attackDamage;
        this.charisma = charisma;
    }

    public void increaseHealth(int amount) {
        health += amount;
    }

    public void increaseDefense(int amount) {
        defense += amount;
    }

    public void increaseAbilityPower(int amount) {
        abilityPower += amount;
    }

    public void increaseAttackDamage(int amount) {
        attackDamage += amount;
    }

    public void increaseCharisma(int amount) {
        charisma += amount;
    }

    public void decreaseHealth(int amount) {
        health -= amount;
    }

    public void decreaseDefense(int amount) {
        defense -= amount;
    }

    public void decreaseAbilityPower(int amount) {
        abilityPower -= amount;
    }

    public void decreaseAttackDamag(int amount) {
        attackDamage -= amount;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChampionStatistics that = (ChampionStatistics) o;
        return health == that.health &&
                defense == that.defense &&
                abilityPower == that.abilityPower &&
                attackDamage == that.attackDamage &&
                charisma == that.charisma;
    }

    @Override
    public int hashCode() {
        return Objects.hash(health, defense, abilityPower, attackDamage, charisma);
    }

    @Override
    public String toString() {
        return "\nStatistics: " +
                "\nHP: " + health +
                " | ARMOR: " + defense +
                " | AP: " + abilityPower +
                " | AD: " + attackDamage +
                " | Charisma: " + charisma;
    }
}
