import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import example.model.AccountHolder;
import example.model.SimpleBankAccountWithAtm;

public class SimpleBankAccountWithAtmTest extends SimpleBankAccountTest{

    private double fee = 1.0;
    private double amountTest = 100.0;

    @Override
    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccountWithAtm(accountHolder, 0, fee);
    }

    @Override
    @Test
    void testDeposit() {
        bankAccount.deposit(accountHolder.getId(), amountTest);
        assertEquals(amountTest - fee, bankAccount.getBalance());
    }

    @Override
    @Test
    void testWrongDeposit() {
        bankAccount.deposit(accountHolder.getId(), amountTest);
        bankAccount.deposit(2, amountTest);
        assertEquals(amountTest - fee, bankAccount.getBalance());
    }

    @Override
    @Test
    void testWithdraw() {
        bankAccount.deposit(accountHolder.getId(), amountTest);
        bankAccount.withdraw(accountHolder.getId(), amountTest / 2);
        assertEquals(amountTest - (amountTest / 2) - (fee*2), bankAccount.getBalance());
    }

    @Override
    @Test
    void testWrongWithdraw() {
        bankAccount.deposit(accountHolder.getId(), amountTest);
        bankAccount.withdraw(2, 70);
        assertEquals(amountTest - fee, bankAccount.getBalance());
    }
}
