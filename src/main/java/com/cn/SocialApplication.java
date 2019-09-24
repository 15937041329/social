package com.cn;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*@ComponentScan(basePackages = "com.cn.dao.mapper")*/
/*@SpringBootApplication(scanBasePackages = "com.cn")*/
@SpringBootApplication
@MapperScan("com.cn.dao.mapper.User*")
public class SocialApplication {
	public static void main(String[] args) {
		SpringApplication.run(SocialApplication.class, args);
	}

}
