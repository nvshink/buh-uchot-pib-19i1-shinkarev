package com.company;

import java.math.BigDecimal;

public class Operation {
    AccountsNumbers debit_account;
    int debit_amount;
    AccountsNumbers credit_account;
    int credit_amount;
    BigDecimal sum;
    String description;

    public Operation(AccountsNumbers debit_account, int debit_amount, AccountsNumbers credit_account, int credit_amount, BigDecimal sum, String description) {
        this.debit_account = debit_account;
        this.debit_amount = debit_amount;
        this.credit_account = credit_account;
        this.credit_amount = credit_amount;
        this.sum = sum;
        this.description = description;
    }

    public AccountsNumbers getDebit_account() {
        return debit_account;
    }

    public int getDebit_amount() {
        return debit_amount;
    }

    public AccountsNumbers getCredit_account() {
        return credit_account;
    }

    public int getCredit_amount() {
        return credit_amount;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public String getDescription() {
        return description;
    }
}
