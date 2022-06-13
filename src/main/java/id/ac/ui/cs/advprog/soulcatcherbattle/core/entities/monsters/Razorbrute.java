package id.ac.ui.cs.advprog.soulcatcherbattle.core.entities.monsters;

import id.ac.ui.cs.advprog.soulcatcherbattle.core.entities.MonsterAttacks;

public class Razorbrute extends MonsterAttacks {

    @Override
    protected Integer attackDamage() {
        return 9;
    }

    @Override
    protected String getName() {
        return "Razorbrute";
    }

    @Override
    protected int getId() {
        return 0;
    }
}
