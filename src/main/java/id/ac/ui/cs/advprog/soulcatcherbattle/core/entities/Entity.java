package id.ac.ui.cs.advprog.soulcatcherbattle.core.entities;

import id.ac.ui.cs.advprog.soulcatcherbattle.core.enums.EntityState;
import id.ac.ui.cs.advprog.soulcatcherbattle.model.dto.DamageDTO;
import lombok.Data;

@Data
public abstract class Entity {
    EntityState state;
    String name;
    int health;
    int damage;
    String entityState;


    public abstract int getAttack();

    public abstract int getHP();

    public abstract void processDamage(DamageDTO damageDto);

    public void refreshState() {
        this.health = Math.max(health, 0);
        if (health <= 0) state = EntityState.DEAD;
    }

    public abstract void setHP(int hp);

    public abstract String getName();

    public abstract int getId();
}
