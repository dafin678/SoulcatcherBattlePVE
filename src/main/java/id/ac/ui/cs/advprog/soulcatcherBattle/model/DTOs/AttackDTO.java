package id.ac.ui.cs.advprog.soulcatcherBattle.model.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttackDTO {
    int damage;
    int enemyHealth;
    String enemyState;
}
