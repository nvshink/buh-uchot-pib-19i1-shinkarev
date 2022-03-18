package com.company;

import java.math.BigDecimal;
import java.util.HashMap;

import static com.company.AccountsNumbers.*;

public class Account {
    private int amount;
    private BigDecimal rest;

    public Account( int amount, BigDecimal rest) {
        this.amount = amount;
        this.rest = rest;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public BigDecimal getRest() {
        return rest;
    }

    public void setRest(BigDecimal rest) {
        this.rest = rest;
    }
    private static HashMap <AccountsNumbers, Account> accounts;
    public static void setAccounts() {
        accounts = new HashMap<AccountsNumbers, Account>();
        accounts.put(GOODS, new Account(0, BigDecimal.ZERO)); //товары
        accounts.put(REGISTER, new Account(0, BigDecimal.ZERO)); //касса
        accounts.put(SETTLEMENTS_WITH_SUPPLIERS, new Account(0, BigDecimal.ZERO)); //расчёты с поставщиками
        accounts.put(SETTLEMENTS_WITH_CUSTOMERS, new Account(0, BigDecimal.ZERO)); //расчёты с покупателями
        accounts.put(SALES, new Account(0, BigDecimal.ZERO)); //продажи
    }
    public static HashMap <AccountsNumbers, Account> getAccounts() {
        return accounts;
    }
}
