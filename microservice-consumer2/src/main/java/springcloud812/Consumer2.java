package springcloud812;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class Consumer2 {

	public static void main(String[] args) {
		SpringApplication.run(Consumer2.class, args);
	}

}
