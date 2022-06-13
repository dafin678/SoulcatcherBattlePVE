package id.ac.ui.cs.advprog.soulcatcherbattle.service;
import id.ac.ui.cs.advprog.soulcatcherbattle.core.entities.Monster;
import id.ac.ui.cs.advprog.soulcatcherbattle.core.entities.monsters.Razorbrute;
import id.ac.ui.cs.advprog.soulcatcherbattle.core.entities.monsters.Rotflayer;
import id.ac.ui.cs.advprog.soulcatcherbattle.core.entities.monsters.Webteeth;
import id.ac.ui.cs.advprog.soulcatcherbattle.model.dto.AttackDTO;
import id.ac.ui.cs.advprog.soulcatcherbattle.model.dto.BattleRewardDTO;
import id.ac.ui.cs.advprog.soulcatcherbattle.model.dto.DamageDTO;
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

    private static final RestTemplate REST_TEMPLATE = new RestTemplate();

    @Override
    public BattleRewardDTO assignWinReward(int personaId) {
        ResponseEntity<BattleRewardDTO> fragmentResponse = REST_TEMPLATE.postForEntity("https://soulcatcher-b1.herokuapp.com/update-fragment/3", new HttpEntity<>(personaId), BattleRewardDTO.class);

        var random = new Random();
        Integer dropChance = random.nextInt(101);

        if(dropChance <= 45) {
            Integer soulChance = random.nextInt(101);

            if(soulChance <= 30) {
                ResponseEntity<BattleRewardDTO> soulResponse = REST_TEMPLATE.postForEntity("https://soulcatcher-b1.herokuapp.com/assign-persona-soul", new HttpEntity<>(null, null), BattleRewardDTO.class);
                return soulResponse.getBody();

            } else {
                ResponseEntity<BattleRewardDTO> consumableResponse = REST_TEMPLATE.postForEntity("https://soulcatcher-b1.herokuapp.com/assign-consumable", new HttpEntity<>(null, null), BattleRewardDTO.class);
                return consumableResponse.getBody();
            }

        }
        return fragmentResponse.getBody();
    }

    @Override
    public BattleRewardDTO assignLoseReward(int personaId) {
        ResponseEntity<BattleRewardDTO> response = REST_TEMPLATE.postForEntity("https://soulcatcher-b1.herokuapp.com/update-fragment/1", new HttpEntity<>(personaId), BattleRewardDTO.class);
        return response.getBody();
    }

    @Override
    public AttackDTO attack(AttackDTO attackDTO) {
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
        var damageDTO = new DamageDTO();
        damageDTO.setDamage(attackerPoint+damageDTO.getDamage());
        return damageDTO;
    }

    @Override
    public Monster getMonster() {
        var random = new Random();

        var x = random.nextInt(3);
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
        for(var j = 0 ; j<3 ; j++){
            monsterList.add(getMonster());
        }
        return monsterList;
    }


}

