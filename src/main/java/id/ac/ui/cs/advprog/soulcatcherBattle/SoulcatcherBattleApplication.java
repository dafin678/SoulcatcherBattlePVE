package id.ac.ui.cs.advprog.soulcatcherBattle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SoulcatcherBattleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoulcatcherBattleApplication.class, args);
    }

}
