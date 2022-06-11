package id.ac.ui.cs.advprog.soulcatcherBattle.service;

import id.ac.ui.cs.advprog.soulcatcherBattle.core.entities.BattlePersona;
import id.ac.ui.cs.advprog.soulcatcherBattle.core.entities.Monster;
import id.ac.ui.cs.advprog.soulcatcherBattle.vo.BattleRequest;
import id.ac.ui.cs.advprog.soulcatcherBattle.vo.Persona;

public interface BattleService {
    Persona getPersona(BattleRequest battleRequest);

    void assignReward(BattlePersona battlePersona, Monster monster);
}
