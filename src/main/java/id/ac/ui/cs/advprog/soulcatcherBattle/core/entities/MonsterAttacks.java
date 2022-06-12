package id.ac.ui.cs.advprog.soulcatcherBattle.core.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class MonsterAttacks {


    public Integer health() {
        return 100;
    }

    protected abstract Integer attackDamage();

    protected abstract String getName();

    protected abstract int getId();
}

