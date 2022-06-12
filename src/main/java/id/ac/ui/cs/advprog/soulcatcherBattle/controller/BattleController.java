package id.ac.ui.cs.advprog.soulcatcherBattle.controller;

import id.ac.ui.cs.advprog.soulcatcherBattle.core.entities.BattlePersona;
import id.ac.ui.cs.advprog.soulcatcherBattle.core.entities.Monster;
import id.ac.ui.cs.advprog.soulcatcherBattle.core.entities.monsters.Razorbrute;
import id.ac.ui.cs.advprog.soulcatcherBattle.core.entities.monsters.Rotflayer;
import id.ac.ui.cs.advprog.soulcatcherBattle.core.entities.monsters.Webteeth;
import id.ac.ui.cs.advprog.soulcatcherBattle.core.vo.EnemyDetail;
import id.ac.ui.cs.advprog.soulcatcherBattle.service.BattleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class BattleController {

    @Autowired
    BattleService battleService;

    @RequestMapping(path = "/enemy-details", produces = "application/json; charset=UTF-8")
    @CrossOrigin(origins = "http://localhost:5000")
    @ResponseBody
    public ResponseEntity<List<EnemyDetail>> getEnemyDetails() {
        List<EnemyDetail> enemyList = new ArrayList<>(); // pindahin ke service sesuai implementasi sendiri
        enemyList.add(new EnemyDetail(new Monster(new Rotflayer())));
        enemyList.add(new EnemyDetail(new Monster(new Razorbrute())));
        enemyList.add(new EnemyDetail(new Monster(new Webteeth())));
        return ResponseEntity.ok(enemyList);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/attack-monster", produces = {"application/json"})
    @CrossOrigin(origins = "http://localhost:5000")
    @ResponseBody
    public ResponseEntity<EnemyDetail> attackMonster(@RequestBody EnemyDetail enemyDetail) {


        return ResponseEntity.ok(enemyDetail); // dto nya damage player, hp musuh, state si musuh, berlaku juga buat sebaliknya (tambahin id persona)
    }


}
