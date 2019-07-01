package com.java.model.characterClass;

import com.java.model.AbstractChampion;
import com.java.model.ChampionStatistics;
import com.java.model.Type;
import lombok.NoArgsConstructor;

import java.util.Random;

@NoArgsConstructor
public class Warrior extends AbstractChampion {
    public static final Random random = new Random();

    public Warrior(String name, ChampionStatistics stats, Type type) {
        super(name, stats, type);
    }

    @Override
    public int getPower() {
        if (stats.getCharisma() <= 100) {
            int event = random.nextInt(101);

            if ((1 + stats.getCharisma()) >= event) {
                return (stats.getAttackDamage() * 2 + stats.getAbilityPower());
            } else {
                return (stats.getAttackDamage() + stats.getAbilityPower());
            }
        } else return (stats.getAttackDamage() * 2 + stats.getAbilityPower());
    }

    @Override
    public int getHP() {
        if (stats.getCharisma() <= 100) {
            int event = random.nextInt(101 - stats.getCharisma());
            int event2 = random.nextInt(101 - stats.getCharisma());

            if (event == event2) {
                stats.increaseDefense(10);
            }
        } else stats.increaseDefense(15);
        return stats.getHealth() + stats.getDefense();
    }
}
