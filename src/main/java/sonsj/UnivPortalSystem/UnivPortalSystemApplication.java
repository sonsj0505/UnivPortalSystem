package sonsj.UnivPortalSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@SpringBootApplication
public class UnivPortalSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnivPortalSystemApplication.class, args);
	}

	//view의 form태그에서 전송 방식에 put, delete를 사용하기 위해 추가
	@Bean
	public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
		return new HiddenHttpMethodFilter();
	}
}
