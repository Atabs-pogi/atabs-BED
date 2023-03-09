package com.atabs.atabbe;


import com.atabs.atabbe.helper.BackUpDatabase;
import com.atabs.atabbe.helper.FileCreated;
import com.atabs.atabbe.model.DatabaseCreds;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.File;
import java.util.Properties;


@SpringBootApplication
@EnableScheduling
public class AtabBeApplication {


	public static void main(String[] args) {
		SpringApplication.run(AtabBeApplication.class, args);
		new File(FileCreated.UPLOADDIRECTORY).mkdir();
	}

//	@Scheduled(cron = "0 0 6 * * 7") // every 6am of sunday
//	@Scheduled(cron = "1 * * * * *") //every 1 mins
//	public void schedule() {
//		Properties springProperties = new Properties();
//		springProperties.getProperty("spring.datasource.url");
//		DatabaseCreds databaseCreds = new DatabaseCreds();
//		System.out.println("Backup logs : " +springProperties.getProperty("spring.datasource.url"));
//		System.out.println("Backup logs : " + databaseCreds.getPassword());
//		System.out.println("Backup logs : " + databaseCreds.getDbName());
//		boolean isSuccess = BackUpDatabase.backUp(FileCreated.dbPathFile(),"root","javaman007","coop");
//		System.out.println("Backup logs : " + isSuccess);
//	}

}