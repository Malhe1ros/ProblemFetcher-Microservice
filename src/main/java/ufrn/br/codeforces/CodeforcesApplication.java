package ufrn.br.codeforces;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication()
@EnableWebFlux
@ComponentScan({"ufrn.br.codeforces"})
public class CodeforcesApplication {

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate(){
		return  new RestTemplate();
	}
//	@Bean
//	@LoadBalanced
//	public WebClient getWebClient(){
//		return WebClient.create();
//	}
	public static void main(String[] args) {
		SpringApplication.run(CodeforcesApplication.class, args);
	}

}
