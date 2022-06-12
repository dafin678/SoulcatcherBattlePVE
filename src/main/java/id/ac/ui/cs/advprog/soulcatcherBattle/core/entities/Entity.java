package id.ac.ui.cs.advprog.soulcatcherBattle.core.entities;

import id.ac.ui.cs.advprog.soulcatcherBattle.core.enums.EntityState;
import lombok.Data;

@Data
public abstract class Entity {
    EntityState state;
    int health;

    public abstract int getAttack();

    public abstract int getHP();

    public abstract void setHP(int hp);
}
