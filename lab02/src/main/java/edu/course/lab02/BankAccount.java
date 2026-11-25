package edu.course.lab02;

public class BankAccount {
    private int balance;

    public BankAccount(int initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("error");
        }
        this.balance = initialBalance;
    }

    public void deposit(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("error");
        }
        this.balance += amount;
    }

    public void withdraw(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("error");
        }

        if (amount > this.balance) {
            throw new IllegalArgumentException("error");
        }

        this.balance -= amount;
    }

    public int getBalance() {
        return balance;
    }
}