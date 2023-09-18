package com.app.tripplan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

// TODO 데이터 베이스 연동 후에 (exclude 제거)
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class TripPlanApplication {

	public static void main(String[] args) {
		SpringApplication.run(TripPlanApplication.class, args);
	}

}
