package id.ac.ui.cs.advprog.soulcatcherBattle.service;

import id.ac.ui.cs.advprog.soulcatcherBattle.core.entities.BattlePersona;
import id.ac.ui.cs.advprog.soulcatcherBattle.core.entities.Monster;
import id.ac.ui.cs.advprog.soulcatcherBattle.model.DTOs.AttackDTO;
import id.ac.ui.cs.advprog.soulcatcherBattle.model.DTOs.BattleRewardDTO;
import id.ac.ui.cs.advprog.soulcatcherBattle.model.DTOs.DamageDTO;

public interface BattleService {
    BattleRewardDTO assignWinReward(int personaId);

    BattleRewardDTO assignLoseReward(int personaId);

    AttackDTO playerAttack(BattlePersona battlePersona, Monster monster);

    AttackDTO monsterAttack(BattlePersona battlePersona, Monster monster);

    DamageDTO getDamageFromAttack(int attackerPoint);
}
