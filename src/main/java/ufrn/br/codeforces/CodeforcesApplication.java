package ufrn.br.codeforces;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication()
@ComponentScan({"ufrn.br.codeforces"})
public class CodeforcesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodeforcesApplication.class, args);
	}

}
