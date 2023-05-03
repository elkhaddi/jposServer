package com.server.serversimulator;

import org.jpos.q2.Q2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServersimulatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServersimulatorApplication.class, args);
	}
	@Bean
	public Q2 q2(){
		Q2 q2 = new Q2();
		q2.start();
		return q2;
	}

}
