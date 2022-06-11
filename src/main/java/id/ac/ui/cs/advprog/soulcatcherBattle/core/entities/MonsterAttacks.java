package id.ac.ui.cs.advprog.soulcatcherBattle.core.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class MonsterAttacks {

    public List attack() {
        List list = new ArrayList();
        //ToDo:
        list.add(health());
        list.add(attackDamage());
        list.add(defense());
        list.add(agility());
        return list;
    }

    public Integer health() {
        return 100;
    }

    protected abstract Integer attackDamage();

    protected abstract Integer defense();

    protected abstract Integer agility();

    protected abstract String getName();
}

