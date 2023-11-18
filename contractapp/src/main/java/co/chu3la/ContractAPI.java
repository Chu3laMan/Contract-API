package co.chu3la;


import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"co.chu3la.repository",
        "co.chu3la.service",
        "co.chu3la.controller",
        "co.chu3la.domain"
})
public class ContractAPI {
    public static void main(String[] args) {
        SpringApplication.run(ContractAPI.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}