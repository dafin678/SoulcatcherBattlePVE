package id.ac.ui.cs.advprog.soulcatcherBattle.model.DTOs;

import id.ac.ui.cs.advprog.soulcatcherBattle.core.entities.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AttackDTO {
    Entity from;
    List<Entity> to;
    List<DamageDTO> attacks;
}

