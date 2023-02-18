package com.group3.DataServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@SpringBootApplication
public class DataServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataServerApplication.class, args);

		/*Consumer consumer1 = new Consumer("ws1.Temperature");
		Consumer consumer2 = new Consumer("ws1.Humidity");
		try {
			consumer1.subscribeToQueue();
			consumer2.subscribeToQueue();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}*/
	}

}
