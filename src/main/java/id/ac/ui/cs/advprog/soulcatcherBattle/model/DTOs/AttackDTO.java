package id.ac.ui.cs.advprog.soulcatcherBattle.model.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AttackDTO {
    int damage;
    int enemyHealth;
    String enemyState;
    int enemyId;
}
