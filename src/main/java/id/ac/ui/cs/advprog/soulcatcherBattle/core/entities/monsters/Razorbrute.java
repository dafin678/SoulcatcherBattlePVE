package id.ac.ui.cs.advprog.soulcatcherBattle.core.entities.monsters;

import id.ac.ui.cs.advprog.soulcatcherBattle.core.entities.MonsterAttacks;

public class Razorbrute extends MonsterAttacks {

    private static final String name = "Razorbrute";

    @Override
    protected Integer attackDamage() {
        return 9;
    }

    @Override
    protected Integer defense() {
        return 7;
    }

    @Override
    protected Integer agility() {
        return null;
    }

    @Override
    protected String getName() {
        return name;
    }
}
