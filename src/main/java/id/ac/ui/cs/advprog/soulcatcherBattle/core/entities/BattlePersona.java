package id.ac.ui.cs.advprog.soulcatcherBattle.core.entities;

import id.ac.ui.cs.advprog.soulcatcherBattle.model.DTOs.DamageDTO;
import id.ac.ui.cs.advprog.soulcatcherBattle.core.vo.Persona;
import lombok.Data;

@Data
public class BattlePersona extends Entity {

    private Persona persona;

    @Override
    public int getAttack() {
        return persona.getDamage();
    }

    @Override
    public int getHP() {
        return persona.getHp();
    }

    @Override
    public void processDamage(DamageDTO damageDto) {
        persona.setHp(persona.getHp()-damageDto.getDamage());
    }

    @Override
    public void setHP(int hp) {
        persona.setHp(hp);
    }


}
