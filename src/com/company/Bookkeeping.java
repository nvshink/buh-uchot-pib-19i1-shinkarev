package com.company;

import java.math.BigDecimal;
import java.util.*;

public class Bookkeeping {
    boolean exitMark = false;
    private final List<Operation> operations = new ArrayList<>();
    private final Map<AccountsNumbers, Account> balance = Account.getAccounts();
    static final Scanner in = new Scanner(System.in);

    public void actionSelector() {
        do {
            exitMark = false;
            System.out.println("Select action: show balance, add operation, exit");
            switch (in.nextLine()) {
                case "add operation":
                    addOperation();
                    break;
                case "show balance":
                    showBalance();
                    break;
                case "exit":
                    exitMark = true;
                    break;
                default:
                    System.out.println("Incorrect action");
            }
        } while (!exitMark);
    }

    public void addOperation() {
        AccountsNumbers debitAccount = enterDebitAccount();
        if (exitMark) return;
        int debitAmount = enterDebitAmount();
        if (exitMark) return;
        AccountsNumbers creditAccount = enterCreditAccount(debitAccount);
        if (exitMark) return;
        int creditAmount = enterCreditAmount();
        if (exitMark) return;
        BigDecimal sum = enterSum();
        if (exitMark) return;
        String description = enterDescription();
        if (exitMark) return;
        Operation operation = new Operation(debitAccount, debitAmount, creditAccount, creditAmount, sum, description);
        operations.add(operation);
        recalculateBalance();
    }

    public void showBalance() {
        for (Map.Entry<AccountsNumbers, Account> entry : balance.entrySet()) {
            System.out.println(entry.getKey().getNumVal() + " " + entry.getValue().getAmount() + " " + entry.getValue().getRest());
        }
    }

    private void recalculateBalance() {
        Account debitSum = sumDebit(operations.get(operations.size() - 1).debit_account);
        Account creditSum = sumCredit(operations.get(operations.size() - 1).debit_account);
        balance.put(operations.get(operations.size() - 1).debit_account, new Account(debitSum.getAmount() - creditSum.getAmount(), debitSum.getRest().subtract(creditSum.getRest())));
    }

    private Account sumDebit(AccountsNumbers account) {
        int amount = 0;
        BigDecimal rest = BigDecimal.ZERO;
        for (Operation operation : operations) {
            if (operation.debit_account == account) {
                amount += operation.debit_amount;
                rest = rest.add(operation.sum);
            }
        }
        return new Account(amount, rest);
    }

    private Account sumCredit(AccountsNumbers account) {
        int amount = 0;
        BigDecimal rest = BigDecimal.ZERO;
        for (Operation operation : operations) {
            if (operation.credit_account == account) {
                amount += operation.credit_amount;
                rest = rest.add(operation.sum);
            }
        }
        return new Account(amount, rest);
    }

    private AccountsNumbers enterDebitAccount() {
        String name = "debit account";
        return scanAccount(name, null);
    }

    private AccountsNumbers enterCreditAccount(AccountsNumbers debitAccount) {
        String name = "credit account";
        return scanAccount(name, debitAccount);
    }

    private AccountsNumbers scanAccount(String name, AccountsNumbers debitAccount) {
        Double inValue;
        AccountsNumbers accountsNumbers = null;
        String inString;
        boolean i = true;
        do {
            System.out.printf("Enter %s: ", name);
            inString = in.nextLine();
            if (inString.equals("exit")) {
                break;
            }
            try {
                inValue = Double.parseDouble(inString);
                if (AccountsNumbers.isPresent(inValue)) {
                    if (name.equals("credit account") && inValue.equals(debitAccount.getNumVal())) {
                        System.out.println("Debit and credit accounts cannot match");
                    } else {
                        accountsNumbers = AccountsNumbers.toAccountNumbers(inValue);
                        i = false;
                    }
                } else {
                    System.out.println("Account doesn't exist");
                }
            } catch (Exception e) {
                System.out.println("Incorrect number entered");
            }

        } while (i);
        return accountsNumbers;
    }

    private int enterDebitAmount() {
        String name = "debit amount";
        return scanAmount(name);
    }

    private int enterCreditAmount() {
        String name = "credit amount";
        return scanAmount(name);
    }

    private int scanAmount(String name) {
        Integer inValue = null;
        boolean i = true;
        String inString;
        do {
            System.out.printf("Enter %s: ", name);
            inString = in.nextLine();
            if (inString.equals("exit")) {
                inValue = null;
                break;
            }
            try {
                inValue = Integer.parseInt(inString);
                if (inValue >= 0) {
                    i = false;
                } else {
                    System.out.println("Amount can't be below zero");
                }
            } catch (Exception e) {
                System.out.println("Incorrect number entered");
            }

        } while (i);
        return inValue;
    }

    private BigDecimal enterSum() {
        String name = "sum";
        return scanSum(name);
    }

    private BigDecimal scanSum(String name) {
        boolean i = true;
        BigDecimal inValue = null;
        String inString;
        do {
            System.out.printf("Enter %s: ", name);
            inString = in.nextLine();
            if (inString.equals("exit")) {
                inValue = null;
                exitMark = true;
                break;
            }
            try {
                inValue = new BigDecimal(inString);
                if (inValue.compareTo(BigDecimal.ZERO) >= 0) {
                    i = false;
                } else {
                    System.out.println("Sum can't be below zero");
                }
            } catch (Exception e) {
                System.out.println("Incorrect number entered");
            }

        } while (i);
        return inValue;
    }

    private String enterDescription() {
        String name = "description";
        return scanDescription(name);
    }

    private String scanDescription(String name) {
        boolean i = true;
        String inValue;
        do {
            System.out.printf("Enter %s: ", name);
            inValue = in.nextLine();
            if (inValue.equals("exit")) {
                inValue = null;
                exitMark = true;
            } else {
                i = false;
            }
        } while (i);
        return inValue;
    }
}
