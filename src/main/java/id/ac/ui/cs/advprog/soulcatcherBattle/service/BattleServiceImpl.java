package id.ac.ui.cs.advprog.soulcatcherBattle.service;

import id.ac.ui.cs.advprog.soulcatcherBattle.core.entities.BattlePersona;
import id.ac.ui.cs.advprog.soulcatcherBattle.core.entities.Entity;
import id.ac.ui.cs.advprog.soulcatcherBattle.core.entities.Monster;
import id.ac.ui.cs.advprog.soulcatcherBattle.core.entities.monsters.Razorbrute;
import id.ac.ui.cs.advprog.soulcatcherBattle.core.entities.monsters.Rotflayer;
import id.ac.ui.cs.advprog.soulcatcherBattle.core.entities.monsters.Webteeth;
import id.ac.ui.cs.advprog.soulcatcherBattle.core.enums.EntityState;
import id.ac.ui.cs.advprog.soulcatcherBattle.model.DTOs.AttackDTO;
import id.ac.ui.cs.advprog.soulcatcherBattle.model.DTOs.DamageDTO;
import id.ac.ui.cs.advprog.soulcatcherBattle.vo.BattleRequest;
import id.ac.ui.cs.advprog.soulcatcherBattle.vo.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BattleServiceImpl implements BattleService{

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Persona getPersona(BattleRequest battleRequest) {
        int personaId = battleRequest.getPersonaId();
        ResponseEntity<Persona> response = restTemplate.getForEntity("http://HOME-SERVICE/get-persona/{id}", Persona.class, personaId);
        Persona persona = response.getBody();
        return persona;
    }

    @Override
    public void assignReward(BattlePersona battlePersona, Monster monster) {
        Persona persona = battlePersona.getPersona();
        int personaId = persona.getId();

        if(battlePersona.getState().equals(EntityState.ALIVE) && monster.getState().equals(EntityState.DEAD)) {
            int newSoulFragments = persona.getSoulFragment() + 3;

            restTemplate.getForEntity("http://HOME-SERVICE/update-fragment/{id}/{newFragment}", String.class, personaId, newSoulFragments);
            restTemplate.getForEntity("http://HOME-SERVICE/assign-persouna-soul", String.class);

        } else if (battlePersona.getState().equals(EntityState.DEAD) && monster.getState().equals(EntityState.ALIVE)) {
            int newSoulFragments = persona.getSoulFragment() + 1;

            restTemplate.getForEntity("http://HOME-SERVICE/update-fragment/{id}/{newFragment}", String.class, personaId, newSoulFragments);
        }

    }

    @Override
    public AttackDTO playerAttack(int personaID) {
        BattlePersona battlePersona = new BattlePersona(personaID);
        var damageDTO = getDamageFromAttack(battlePersona.getAttack());
        Monster monster = getMonster();
        monster.refreshState();
        monster.processDamage(damageDTO);
        return new AttackDTO(battlePersona.getAttack(),monster.getHealth(),monster.getState().toString(), monster.getId());

    }

    @Override
    public AttackDTO monsterAttack(int personaID, Monster monster){
        var damageDTO = getDamageFromAttack(monster.getAttack());
        BattlePersona battlePersona = new BattlePersona(personaID);
        battlePersona.refreshState();
        battlePersona.processDamage(damageDTO);
        return new AttackDTO(monster.getAttack(),battlePersona.getHealth(),battlePersona.getState().toString(), battlePersona.getId());
    }

    @Override
    public DamageDTO getDamageFromAttack(int attackerPoint) {
        DamageDTO damageDTO = new DamageDTO();
        damageDTO.setDamage(attackerPoint+damageDTO.getDamage());
        return damageDTO;
    }

    @Override
    public Monster getMonster() {
        Random random = new Random();

        int x = random.nextInt(3);
        if(x == 0){
            return new Monster(new Razorbrute());
        }
        else if (x==1){
            return new Monster(new Rotflayer());
        }
        else if (x==2) {
            return new Monster(new Webteeth());
        }
        return null;
    }


}
