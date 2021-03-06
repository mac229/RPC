package http.service;

public interface IBankService {
    void createAccount(Account account);
    void transfer(String sourcAccNumber, String destAccNumber, Double amount);
    Double getAccountBalance(String accNumber);
    Account getAccount(String accNumber);
}
