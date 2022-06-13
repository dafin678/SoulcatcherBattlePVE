package id.ac.ui.cs.advprog.soulcatcherBattle.model.DTOs;

import id.ac.ui.cs.advprog.soulcatcherBattle.core.entities.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttackDTO {
    int damage;
    int enemyHealth;
    String enemyState;
}
