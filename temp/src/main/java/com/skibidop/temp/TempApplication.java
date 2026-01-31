package com.skibidop.temp;
//Spring boot scan package และ sub-package แล้วสามารถเรียกใช้ได้เลยผ่าน Application context


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TempApplication {

	public static void main(String[] args) {
		SpringApplication.run(TempApplication.class, args);
	}

}

//./mvnw spring-boot:run