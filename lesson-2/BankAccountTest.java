import org.junit.Test;

import static org.junit.Assert.*;

public class BankAccountTest {

    @Test
    public void testDeposit() {
        int amount = 500;
        BankAccount account = new BankAccount();

        account.deposit(amount);

        assertEquals(amount, account.getBalance());
    }

    @Test
    public void testWithdraw() {
        int amountToDeposit = 500;
        int amountToWithdraw = 200;
        BankAccount account = new BankAccount();

        account.deposit(amountToDeposit);
        account.withdraw(amountToWithdraw);

        assertEquals(300, account.getBalance());
    }

    @Test
    public void testWithdrawTooMuch() {
        int amountToDeposit = 1000;
        int amountToWithdraw = 7000;
        BankAccount account = new BankAccount();

        account.deposit(amountToDeposit);
        account.withdraw(amountToWithdraw);

        assertTrue(1000 == account.getBalance());
    }
}