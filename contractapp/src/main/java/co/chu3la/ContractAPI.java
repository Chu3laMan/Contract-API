package co.chu3la;


import co.chu3la.domain.Transaction;
import co.chu3la.repository.TransactionRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

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
}