package id.ac.ui.cs.advprog.soulcatcherBattle.core.vo;

import id.ac.ui.cs.advprog.soulcatcherBattle.core.entities.Monster;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EnemyDetail {
    private int hp;
    private int damage;
    private String name;
    private String type;

    public EnemyDetail(Monster monster) {
        this.hp = monster.getHealth();
        this.damage = monster.getAttack();
        this.name = monster.getName();
        this.type = monster.getId();
    }
}
