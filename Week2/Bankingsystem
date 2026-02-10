import java.io.*;
import java.util.*;

class Account {
    private int accountNumber;
    private String holderName;
    private double balance;

    public Account(int accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient Balance!");
        }
    }

    @Override
    public String toString() {
        return accountNumber + "," + holderName + "," + balance;
    }
}

class SavingsAccount extends Account {
    public SavingsAccount(int accNo, String name, double balance) {
        super(accNo, name, balance);
    }
}

public class BankingSystem {

    static final String FILE_NAME = "accounts.txt";
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== SIMPLE BANKING SYSTEM =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> createAccount();
                case 2 -> deposit();
                case 3 -> withdraw();
                case 4 -> checkBalance();
                case 5 -> System.exit(0);
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void createAccount() {
        try (FileWriter fw = new FileWriter(FILE_NAME, true)) {

            System.out.print("Enter Account Number: ");
            int accNo = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Holder Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Initial Balance: ");
            double balance = sc.nextDouble();

            Account acc = new SavingsAccount(accNo, name, balance);

            fw.write(acc.toString() + "\n");
            System.out.println("Account Created Successfully!");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void deposit() {
        updateBalance(true);
    }

    static void withdraw() {
        updateBalance(false);
    }

    static void updateBalance(boolean isDeposit) {

        try {
            System.out.print("Enter Account Number: ");
            int accNo = sc.nextInt();

            System.out.print("Enter Amount: ");
            double amount = sc.nextDouble();

            File file = new File(FILE_NAME);
            List<String> lines = new ArrayList<>();
            boolean found = false;

            Scanner fileReader = new Scanner(file);

            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] data = line.split(",");

                int fileAccNo = Integer.parseInt(data[0]);
                String name = data[1];
                double balance = Double.parseDouble(data[2]);

                if (fileAccNo == accNo) {
                    Account acc = new SavingsAccount(fileAccNo, name, balance);

                    if (isDeposit) {
                        acc.deposit(amount);
                    } else {
                        acc.withdraw(amount);
                    }

                    lines.add(acc.toString());
                    found = true;
                } else {
                    lines.add(line);
                }
            }

            fileReader.close();

            FileWriter fw = new FileWriter(FILE_NAME);
            for (String l : lines) {
                fw.write(l + "\n");
            }
            fw.close();

            if (found)
                System.out.println("Transaction Successful!");
            else
                System.out.println("Account Not Found!");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void checkBalance() {

        try {
            System.out.print("Enter Account Number: ");
            int accNo = sc.nextInt();

            File file = new File(FILE_NAME);
            Scanner fileReader = new Scanner(file);

            while (fileReader.hasNextLine()) {
                String[] data = fileReader.nextLine().split(",");
                if (Integer.parseInt(data[0]) == accNo) {
                    System.out.println("Current Balance: " + data[2]);
                    fileReader.close();
                    return;
                }
            }

            fileReader.close();
            System.out.println("Account Not Found!");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

