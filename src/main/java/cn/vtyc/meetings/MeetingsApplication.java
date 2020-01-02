package cn.vtyc.meetings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "cn.vtyc.meetings.dao.*")
@EnableScheduling
public class MeetingsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeetingsApplication.class, args);
	}
}
