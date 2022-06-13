package id.ac.ui.cs.advprog.soulcatcherbattle.service;

import id.ac.ui.cs.advprog.soulcatcherbattle.core.entities.Monster;
import id.ac.ui.cs.advprog.soulcatcherbattle.model.dto.AttackDTO;
import id.ac.ui.cs.advprog.soulcatcherbattle.model.dto.BattleRewardDTO;
import id.ac.ui.cs.advprog.soulcatcherbattle.model.dto.DamageDTO;

import java.util.List;

public interface BattleService {
    BattleRewardDTO assignWinReward(int personaId);

    BattleRewardDTO assignLoseReward(int personaId);

    AttackDTO attack(AttackDTO attackDTO);


    DamageDTO getDamageFromAttack(int attackerPoint);

    Monster getMonster();

    List<Monster> getMonsterList();


}
