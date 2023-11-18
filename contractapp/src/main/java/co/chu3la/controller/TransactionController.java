package co.chu3la.controller;


import co.chu3la.domain.Transaction;
import co.chu3la.exception.TransactionException;
import co.chu3la.response.BaseResponse;
import co.chu3la.service.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Generated;
import java.util.List;



@RequestMapping(value ="/")
@RestController
public class TransactionController {

    @Autowired
    TransactionService transactionService;



    @Operation(summary = "Get A all transactions for a specific account number")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Get all transactions for a specific account number"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @GetMapping(value = "transactions/{accountNumber}")
    public BaseResponse<Transaction> getTransactionsByAccountNumber(@PathVariable("accountNumber") String accountNumber) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            List<Transaction> transactions = transactionService.getAllTransactions(accountNumber);
            baseResponse.setJsonData(transactions);
            baseResponse.setStatus(true);
            baseResponse.setStatusCode("200");
        }catch (TransactionException e) {
            baseResponse.setStatus(false);
            baseResponse.setStatusCode("401");
            baseResponse.setMsg(e.getMessage());
        }
        return baseResponse;
    }

}

