package hello.spring_mvc_study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class SpringMvcStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcStudyApplication.class, args);
	}

}
