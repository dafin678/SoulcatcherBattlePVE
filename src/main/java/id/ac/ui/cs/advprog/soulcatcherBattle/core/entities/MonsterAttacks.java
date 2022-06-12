package id.ac.ui.cs.advprog.soulcatcherBattle.core.entities;

public abstract class MonsterAttacks {

    static final int HEALTH = 100;

    public Integer health() {
        return HEALTH;
    }

    protected abstract Integer attackDamage();

    protected abstract String getName();

    protected abstract int getId();
}

