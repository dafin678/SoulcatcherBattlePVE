package id.ac.ui.cs.advprog.soulcatcherBattle.core.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import id.ac.ui.cs.advprog.soulcatcherBattle.core.enums.EntityState;
import lombok.Data;

@Data
public class Monster extends Entity {

    @JsonIgnore
    MonsterAttacks monsterAttacks;

    String id;

    public Monster(MonsterAttacks monsterAttacks, String id) {
        this.monsterAttacks = monsterAttacks;
        this.health = monsterAttacks.health();
        this.state = EntityState.ALIVE;
        this.id = id;
    }


    public String getName() {
        return monsterAttacks.getName();
    }

    @Override
    public int getAttack() {
        return monsterAttacks.attackDamage();
    }

    @Override
    public int getHP() {
        return monsterAttacks.health();
    }

    @Override
    public void setHP(int hp) {
        this.health=hp;
    }
}
