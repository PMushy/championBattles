package com.java.model.characterClass;

import com.java.model.AbstractChampion;
import com.java.model.ChampionStatistics;
import com.java.model.Type;
import lombok.NoArgsConstructor;

import java.util.Random;

@NoArgsConstructor
public class Mage extends AbstractChampion {
    public static final Random random = new Random();

    public Mage(String name, ChampionStatistics stats, Type type) {
        super(name, stats, type);
    }

    @Override
    public int getPower() {
        if (stats.getCharisma() <= 100) {
            int event = random.nextInt(101);

            if ((1 + stats.getCharisma()) >= event) {
                return (stats.getAttackDamage() + stats.getAbilityPower() * 2);
            } else {
                return (stats.getAttackDamage() + stats.getAbilityPower());
            }
        } else return (stats.getAttackDamage() + stats.getAbilityPower() * 3);
    }

    @Override
    public int getHP() {
        return stats.getHealth() + stats.getDefense();
    }
}
