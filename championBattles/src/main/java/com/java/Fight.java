package com.java;

import com.java.model.AbstractChampion;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Fight {

    public String startFight(AbstractChampion champion1, AbstractChampion champion2) {
        while (champion1.isAlive() && champion2.isAlive()) {

            duel(champion1, champion2);
        }

        return "The winnner is " + getWinner(champion1, champion2).getName();
    }

    private void duel(AbstractChampion champion1, AbstractChampion champion2) {

        String champ1Name = champion1.getName();
        String champ2Name = champion2.getName();

        while (champion1.getHP() > 0 & champion2.getHP() > 0) {
            int champ1Power = champion1.getPower();
            int champ2Power = champion2.getPower();

            champion2.getStats().decreaseHealth(champ1Power);
            System.out.println(
                    champ1Name + " hit " + champion2.getName() + " for " + champ1Power
                            + "\n" + champ2Name + " HP: " + champion2.getHP());
            if (champion2.getHP() <= 0) {
                champion2.killChampion();
                break;
            }
            champion1.getStats().decreaseHealth(champ2Power);
            System.out.println(
                    champ2Name + " hit " + champ1Name + " for " + champ2Power
                            + "\n" + champ1Name + " HP: " + champion1.getHP());

            if (champion1.getHP() <= 0) {
                champion1.killChampion();
                break;
            }
        }
    }

    private AbstractChampion getWinner(AbstractChampion champion1, AbstractChampion champion2) {
        if (champion1.isAlive()) {
            return champion1;
        } else if (champion2.isAlive()) {
            return champion2;
        } else {
            return null;
        }
    }
}
