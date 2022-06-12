package id.ac.ui.cs.advprog.soulcatcherBattle.model.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class BattleRewardDTO {
   List<String> name;
   List<Integer> quantity;
}
