package id.ac.ui.cs.advprog.soulcatcherbattle.core.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {
    private Integer id;
    private String name;
    private int hp;
    private int damage;
    private int level;
    private String personaClass;
    private int soulFragment;
}