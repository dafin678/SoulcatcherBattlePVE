package id.ac.ui.cs.advprog.soulcatcherBattle.core.entities.monsters;

import id.ac.ui.cs.advprog.soulcatcherBattle.core.entities.MonsterAttacks;

public class Webteeth extends MonsterAttacks {
    private static final String name = "Webteeth";

    @Override
    protected Integer attackDamage() {
        return 8;
    }


    @Override
    protected String getName() {
        return name;
    }
}
