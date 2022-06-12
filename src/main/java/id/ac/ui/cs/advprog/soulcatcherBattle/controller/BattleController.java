package id.ac.ui.cs.advprog.soulcatcherBattle.controller;

import id.ac.ui.cs.advprog.soulcatcherBattle.core.entities.Monster;
import id.ac.ui.cs.advprog.soulcatcherBattle.model.DTOs.AttackDTO;
import id.ac.ui.cs.advprog.soulcatcherBattle.model.DTOs.BattleRewardDTO;
import id.ac.ui.cs.advprog.soulcatcherBattle.service.BattleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class BattleController {

    @Autowired
    BattleService battleService;

    @RequestMapping(path = "/enemy-details", produces = "application/json; charset=UTF-8")
    @CrossOrigin(origins = "http://localhost:5000")
    @ResponseBody
    public ResponseEntity<List<Monster>> getEnemyDetails() {
        return ResponseEntity.ok(battleService.getMonsterList());
    }

    @PostMapping(path = "/attack-monster", produces = {"application/json"})
    @CrossOrigin(origins = "http://localhost:5000")
    @ResponseBody
    public ResponseEntity<AttackDTO> attack(@RequestBody Integer personaId) {
        return ResponseEntity.ok(battleService.attack());
    }

    @PostMapping(path = "/win-battle", produces = {"application/json"})
    @CrossOrigin(origins = "http://localhost:5000")
    @ResponseBody
    public ResponseEntity<BattleRewardDTO> win(@RequestBody Integer personaId) {
        return ResponseEntity.ok(battleService.assignWinReward(personaId));
    }

    @PostMapping(path = "/lose-battle", produces = {"application/json"})
    @CrossOrigin(origins = "http://localhost:5000")
    @ResponseBody
    public ResponseEntity<BattleRewardDTO> lose(@RequestBody Integer personaId) {
        return ResponseEntity.ok(battleService.assignLoseReward(personaId));
    }
}
