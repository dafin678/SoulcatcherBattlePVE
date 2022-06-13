package id.ac.ui.cs.advprog.soulcatcherBattle.service;
import id.ac.ui.cs.advprog.soulcatcherBattle.core.entities.BattlePersona;
import id.ac.ui.cs.advprog.soulcatcherBattle.core.entities.Monster;
import id.ac.ui.cs.advprog.soulcatcherBattle.core.entities.monsters.Razorbrute;
import id.ac.ui.cs.advprog.soulcatcherBattle.core.entities.monsters.Rotflayer;
import id.ac.ui.cs.advprog.soulcatcherBattle.core.entities.monsters.Webteeth;
import id.ac.ui.cs.advprog.soulcatcherBattle.core.enums.EntityState;
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
                ResponseEntity soulResponse = restTemplate.postForEntity("http://HOME-SERVICE/assign-persona-soul", new HttpEntity<>(null, null), BattleRewardDTO.class);
                return (BattleRewardDTO) soulResponse.getBody();

            } else {
                ResponseEntity consumableResponse = restTemplate.postForEntity("http://HOME-SERVICE/assign-consumable", new HttpEntity<>(null, null), BattleRewardDTO.class);
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
    public AttackDTO attack(AttackDTO attackDTO) {
//        BattlePersona battlePersona = new BattlePersona();
//        Monster monster = getMonster();
//        var personaDamageDTO = getDamageFromAttack(battlePersona.getAttack());
//        var monsterDamageDTO = getDamageFromAttack(monster.getAttack());
//        monster.refreshState();
//        monster.processDamage(personaDamageDTO);
//        battlePersona.refreshState();
//        battlePersona.processDamage(monsterDamageDTO);
        int damage = attackDTO.getDamage();
        int health = attackDTO.getEnemyHealth();
        int newHp = health-damage;
        if (newHp <= 0) {
            attackDTO.setEnemyState("dead");
            newHp = 0;
        }
        attackDTO.setEnemyHealth(newHp);
        return attackDTO;
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

    @Override
    public List<Monster> getMonsterList() {
        List<Monster> monsterList = new ArrayList<>();
        for(int j = 0 ; j<3 ; j++){
            monsterList.add(getMonster());
        }
        return monsterList;
    }


}

