package id.ac.ui.cs.advprog.soulcatcherBattle.model.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BattleRewardDTO {
   List<String> name;
   List<Integer> quantity;
}
