package co.chu3la.Repository;

import co.chu3la.Integration.AbstractContainerBaseTest;
import co.chu3la.domain.Transaction;
import co.chu3la.repository.TransactionRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TransactionRepositoryTest extends AbstractContainerBaseTest {

    @Autowired
    TransactionRepository transactionRepository;

    @DisplayName("JUnit Test for getting transaction by ID")
    @Test
    public void givenTransactionObject_whenFindById_thenTransactionObject() {
        //given - precondition
        Transaction transaction = new Transaction("WU Transaction", new Date(), "987456321", "EUR", "100");
        //when - action or the behavior that we are going to test
        List<Transaction> transactions = transactionRepository.findAllByAccountNumber(transaction.accountNumber());
        //then - verify output
        assertEquals(transactions.size(), 0);
    }


}
