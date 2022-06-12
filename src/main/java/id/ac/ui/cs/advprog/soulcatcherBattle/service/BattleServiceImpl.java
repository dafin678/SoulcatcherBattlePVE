package id.ac.ui.cs.advprog.soulcatcherBattle.service;

import id.ac.ui.cs.advprog.soulcatcherBattle.core.entities.BattlePersona;
import id.ac.ui.cs.advprog.soulcatcherBattle.core.entities.Entity;
import id.ac.ui.cs.advprog.soulcatcherBattle.core.entities.Monster;
import id.ac.ui.cs.advprog.soulcatcherBattle.model.DTOs.AttackDTO;
import id.ac.ui.cs.advprog.soulcatcherBattle.model.DTOs.BattleRewardDTO;
import id.ac.ui.cs.advprog.soulcatcherBattle.model.DTOs.DamageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
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
    public BattleRewardDTO assignWinReward(int personaId) {
        ResponseEntity fragmentResponse = restTemplate.postForEntity("http://HOME-SERVICE/update-fragment/3", new HttpEntity<>(personaId), BattleRewardDTO.class);

        Random random = new Random();
        Integer dropChance = random.nextInt(101);

        if(dropChance <= 45) {
            Integer soulChance = random.nextInt(101);

            if(soulChance <= 30) {
                ResponseEntity soulResponse = restTemplate.postForEntity("http://HOME-SERVICE/assign-persouna-soul", new HttpEntity<>(personaId), BattleRewardDTO.class);
                return (BattleRewardDTO) soulResponse.getBody();

            } else {
                ResponseEntity consumableResponse = restTemplate.postForEntity("http://HOME-SERVICE/assign-consumable", new HttpEntity<>(""), BattleRewardDTO.class);
                return (BattleRewardDTO) consumableResponse.getBody();
            }

        }
        return (BattleRewardDTO) fragmentResponse.getBody();
    }

    @Override
    public BattleRewardDTO assignLoseReward(int personaId) {
        ResponseEntity response = restTemplate.postForEntity("http://HOME-SERVICE/update-fragment/1", new HttpEntity<>(personaId), BattleRewardDTO.class);
        return (BattleRewardDTO) response.getBody();
    }

    @Override
    public AttackDTO playerAttack(BattlePersona battlePersona, Monster monster) {
        var damageDTO = getDamageFromAttack(battlePersona.getAttack());
        monster.refreshState();
        monster.processDamage(damageDTO);
        List<Entity> target = new ArrayList<>();
        List<DamageDTO> damageDTOS = new ArrayList<>();
        target.add(monster);
        damageDTOS.add(damageDTO);
        return new AttackDTO(battlePersona,target,damageDTOS);
    }

    @Override
    public AttackDTO monsterAttack(BattlePersona battlePersona, Monster monster){
        var damageDTO = getDamageFromAttack(monster.getAttack());
        battlePersona.refreshState();
        battlePersona.processDamage(damageDTO);
        List<Entity> target = new ArrayList<>();
        List<DamageDTO> damageDTOS = new ArrayList<>();
        target.add(battlePersona);
        damageDTOS.add(damageDTO);
        return new AttackDTO(monster,target,damageDTOS);
    }

    @Override
    public DamageDTO getDamageFromAttack(int attackerPoint) {
        DamageDTO damageDTO = new DamageDTO();
        damageDTO.setDamage(attackerPoint+damageDTO.getDamage());
        return damageDTO;
    }

}