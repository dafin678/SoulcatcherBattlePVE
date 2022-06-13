package id.ac.ui.cs.advprog.soulcatcherbattle.core.entities.monsters;

import id.ac.ui.cs.advprog.soulcatcherbattle.core.entities.MonsterAttacks;

public class Rotflayer extends MonsterAttacks {

    @Override
    protected Integer attackDamage() {
        return 7;
    }

    @Override
    protected String getName() {
        return "Rotflayer";
    }

    @Override
    protected int getId() {
        return 1;
    }
}
