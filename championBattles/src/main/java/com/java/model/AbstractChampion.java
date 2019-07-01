package com.java.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static java.lang.String.join;

@Getter
@NoArgsConstructor
@EqualsAndHashCode
public abstract class AbstractChampion {

    public static int instanceNumber = 0;

    protected String name;
    protected ChampionStatistics stats;
    protected Type type;
    protected boolean alive;

    public AbstractChampion(String name, ChampionStatistics stats, Type type) {
        instanceNumber++;

        this.name = name;
        this.stats = stats;
        this.type = type;
        this.alive = true;

        switch (this.type) {
            case GOOD: {
                this.stats.increaseHealth(10);
                this.stats.increaseDefense(5);
                break;
            }
            case EVIL: {
                this.stats.increaseAbilityPower(10);
                this.stats.increaseAttackDamage(10);
                break;
            }
            default:
                break;
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStats(ChampionStatistics stats) {
        this.stats = stats;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void killChampion() {
        this.alive = false;
    }

    public abstract int getPower();
    public abstract int getHP();

    public String parseToString() {
        return join(";",
                this.getClass().getSimpleName(),
                this.name,
                Integer.toString(this.stats.getHealth()),
                Integer.toString(this.stats.getDefense()),
                Integer.toString(this.stats.getAbilityPower()),
                Integer.toString(this.stats.getAttackDamage()),
                Integer.toString(this.stats.getCharisma()),
                this.type.toString());
    }

    @Override
    public String toString() {
        return "AbstractChampion" +
                "\nName: " + name + stats +
                "\nType: " + type +
                "\nAlive: " + alive;
    }
}