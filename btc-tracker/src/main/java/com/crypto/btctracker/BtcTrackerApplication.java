package com.crypto.btctracker;

import com.crypto.btctracker.interfaces.DataAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EntityScan("com.crypto.btctracker.*")
public class BtcTrackerApplication {

	@Autowired DataAPIService dataAPIService;
	public static void main(String[] args) {
		SpringApplication.run(BtcTrackerApplication.class, args);
	}

}

@Configuration
@EnableScheduling
//@ConditionalOnProperty(name="")
class SchedulerConfiguration {

}
