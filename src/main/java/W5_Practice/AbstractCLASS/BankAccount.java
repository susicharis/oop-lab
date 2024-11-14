package W5_Practice.AbstractCLASS;

abstract class BankAccount {
    String accountHolder;
    String accountNumber;
    double balance;

    public BankAccount(String accountHolder, String accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    abstract void deposit(double amount);
    abstract void withdraw(double amount);
    abstract void printAccountDetails();

    public double getBalance() {
        return balance;
    }
}

class SavingsAccount extends BankAccount {
    double interestRate;

    public SavingsAccount(String accountHolder, String accountNumber, double balance, double interestRate) {
        super(accountHolder, accountNumber, balance);
        this.interestRate = interestRate;
    }

    public void deposit(double amount) {
        balance += amount; // Simple deposit logic
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    public double calculateInterest() {
        return balance * (interestRate / 100);
    }

    public void printAccountDetails() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

class CheckingAccount extends BankAccount {
    double transactionFee;

    public CheckingAccount(String accountHolder, String accountNumber, double balance, double transactionFee) {
        super(accountHolder, accountNumber, balance);
        this.transactionFee = transactionFee;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance >= amount + transactionFee) {
            balance -= (amount + transactionFee);
        } else {
            System.out.println("Insufficient funds for withdrawal + transaction fee.");
        }
    }

    public void printAccountDetails() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
        System.out.println("Transaction Fee: " + transactionFee);
    }
}
