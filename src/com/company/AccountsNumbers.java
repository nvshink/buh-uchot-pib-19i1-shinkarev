package com.company;

import java.util.Arrays;
import java.util.Optional;

enum AccountsNumbers {
    GOODS(41),
    REGISTER(50),
    SETTLEMENTS_WITH_SUPPLIERS(60),
    SETTLEMENTS_WITH_CUSTOMERS(62),
    SALES(90);

    private double num;

    AccountsNumbers(double num) {
        this.num = num;
    }

    public double getNumVal() {
        return num;
    }

    public static boolean isPresent(double data) {
        return Arrays.stream(AccountsNumbers.values()).anyMatch(element -> element.num == data);
    }
    public static AccountsNumbers toAccountNumbers (double data) {
        Optional <AccountsNumbers> accountsNumbers = Arrays.stream(AccountsNumbers.values()).filter(element -> element.num == data).findFirst();
        return accountsNumbers.get();
    }
}