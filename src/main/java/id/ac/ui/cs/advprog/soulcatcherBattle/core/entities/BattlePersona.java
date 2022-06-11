package id.ac.ui.cs.advprog.soulcatcherBattle.core.entities;

import id.ac.ui.cs.advprog.soulcatcherBattle.vo.Persona;
import lombok.Data;

@Data
public class BattlePersona extends Entity {

    private Persona persona;

    @Override
    public int getAttack() {
        return persona.getDamage();
    }

    @Override
    public int getDefense() {
        return 0;
    }
}
