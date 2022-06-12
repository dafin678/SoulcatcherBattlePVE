package id.ac.ui.cs.advprog.soulcatcherBattle.core.entities;

import id.ac.ui.cs.advprog.soulcatcherBattle.core.enums.EntityState;
import id.ac.ui.cs.advprog.soulcatcherBattle.model.DTOs.DamageDTO;
import lombok.Data;

@Data
public abstract class Entity {
    EntityState state;
    int health;

    public abstract int getAttack();

    public abstract int getHP();

    public abstract void processDamage(DamageDTO damageDto);


    public void refreshState() {
        this.health = Math.max(health, 0);
        if (health <= 0) state = EntityState.DEAD;
    }


    public abstract void setHP(int hp);
}
