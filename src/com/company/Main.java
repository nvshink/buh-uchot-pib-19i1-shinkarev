package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Account.setAccounts();
        System.out.println("Welcome to SpaceTavern");
        new Bookkeeping().actionSelector();
    }

}
