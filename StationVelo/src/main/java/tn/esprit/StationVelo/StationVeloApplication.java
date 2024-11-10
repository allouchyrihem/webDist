package tn.esprit.StationVelo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@SpringBootApplication
@EnableDiscoveryClient
public class StationVeloApplication {

	public static void main(String[] args) {
		SpringApplication.run(StationVeloApplication.class, args);
	}

}
