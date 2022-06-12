package id.ac.ui.cs.advprog.soulcatcherBattle.service;

import id.ac.ui.cs.advprog.soulcatcherBattle.core.entities.BattlePersona;
import id.ac.ui.cs.advprog.soulcatcherBattle.core.entities.Monster;
import id.ac.ui.cs.advprog.soulcatcherBattle.core.entities.MonsterAttacks;
import id.ac.ui.cs.advprog.soulcatcherBattle.model.DTOs.AttackDTO;
import id.ac.ui.cs.advprog.soulcatcherBattle.model.DTOs.BattleRewardDTO;
import id.ac.ui.cs.advprog.soulcatcherBattle.model.DTOs.DamageDTO;

import java.util.List;

public interface BattleService {
    BattleRewardDTO assignWinReward(int personaId);

    BattleRewardDTO assignLoseReward(int personaId);

    AttackDTO attack();


    DamageDTO getDamageFromAttack(int attackerPoint);

    Monster getMonster();

    List<Monster> getMonsterList();


}
