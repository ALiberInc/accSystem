package jp.co.aliber.accsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

//MyBatis
@MapperScan("jp.co.aliber.accsystem.mapper")
// filter
@ServletComponentScan(basePackages = "jp.co.aliber.accsystem.filter")
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
