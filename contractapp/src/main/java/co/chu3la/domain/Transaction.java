package co.chu3la.domain;



import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "transaction")
public class Transaction extends BaseEntity<String> {

    @JsonProperty("id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("type")
    private String type;

    @JsonProperty("date")
    private Date date;

    @JsonProperty("accountNumber")
    private String accountNumber;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("amount")
    private String amount;

    public Transaction() {
    }

    public Transaction(String type, Date date, String accountNumber, String currency, String amount) {
        this.type = type;
        this.date = date;
        this.accountNumber = accountNumber;
        this.currency = currency;
        this.amount = amount;
    }

    public Long id() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String type() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date date() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String accountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String currency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String amount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
