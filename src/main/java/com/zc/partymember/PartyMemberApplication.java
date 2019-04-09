package com.zc.partymember;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zc.partymember.mapper")
public class PartyMemberApplication {

	public static void main(String[] args) {
		SpringApplication.run(PartyMemberApplication.class, args);
	}

}
