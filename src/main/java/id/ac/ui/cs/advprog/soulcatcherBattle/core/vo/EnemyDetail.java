package id.ac.ui.cs.advprog.soulcatcherBattle.core.vo;

import id.ac.ui.cs.advprog.soulcatcherBattle.core.entities.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EnemyDetail {
    private int hp;
    private int damage;
    private String name;
    private int id;

    public EnemyDetail(Entity enemy) {
        this.hp = enemy.getHP();
        this.damage = enemy.getAttack();
        this.name = enemy.getName();
        this.id = enemy.getId();
    }
}
