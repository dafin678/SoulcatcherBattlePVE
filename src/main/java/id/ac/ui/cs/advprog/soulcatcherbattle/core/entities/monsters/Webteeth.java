package id.ac.ui.cs.advprog.soulcatcherbattle.core.entities.monsters;

import id.ac.ui.cs.advprog.soulcatcherbattle.core.entities.MonsterAttacks;

public class Webteeth extends MonsterAttacks {

    @Override
    protected Integer attackDamage() {
        return 8;
    }

    @Override
    protected String getName() {
        return "Webteeth";
    }

    @Override
    protected int getId() {
        return 2;
    }
}
