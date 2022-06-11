package id.ac.ui.cs.advprog.soulcatcherBattle.controller;

import id.ac.ui.cs.advprog.soulcatcherBattle.core.entities.Monster;
import id.ac.ui.cs.advprog.soulcatcherBattle.core.entities.monsters.Razorbrute;
import id.ac.ui.cs.advprog.soulcatcherBattle.core.entities.monsters.Rotflayer;
import id.ac.ui.cs.advprog.soulcatcherBattle.core.entities.monsters.Webteeth;
import id.ac.ui.cs.advprog.soulcatcherBattle.core.vo.EnemyDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BattleController {

    @RequestMapping(path = "/enemy-details", produces = "application/json; charset=UTF-8")
    @CrossOrigin(origins = "http://localhost:5000")
    @ResponseBody
    public ResponseEntity<List<EnemyDetail>> getEnemyDetails() {
        List<EnemyDetail> enemyList = new ArrayList<>();
        enemyList.add(new EnemyDetail(new Monster(new Rotflayer(), "Enemy1")));
        enemyList.add(new EnemyDetail(new Monster(new Razorbrute(), "Enemy2")));
        enemyList.add(new EnemyDetail(new Monster(new Webteeth(), "Enemy3")));
        return ResponseEntity.ok(enemyList);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/attack", produces = {"application/json"})
    @CrossOrigin(origins = "http://localhost:5000")
    @ResponseBody
    public ResponseEntity<EnemyDetail> attack(@RequestBody EnemyDetail enemyDetail) {
        enemyDetail.setHp(enemyDetail.getHp() - 10);

        return ResponseEntity.ok(enemyDetail);
    }
}
