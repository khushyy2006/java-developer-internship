import java.sql.*;
import java.util.Scanner;

// Base class for bank account abstraction
abstract class MainBankAccount {
    private long accountNumber;
    private String holderName;
    private double balance;

    public MainBankAccount(long accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public long getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }

    public abstract void showAccountType();
}

// Inherited class for specific savings logic
class SavingsAccount extends MainBankAccount {
    public SavingsAccount(long accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public void showAccountType() {
        System.out.println("Account Type: Savings");
    }
}

public class BankingSystem {

    // Database credentials
    static final String URL = "jdbc:mysql://localhost:3306/Banking_System?useSSL=false&allowPublicKeyRetrieval=true";
    static final String USER = "root"; 
    static final String PASSWORD = "YOUR_PASSWORD_HERE";
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Connected Successfully to the Banking Database.");

            while (true) {
                System.out.println("\n--- BANKING SYSTEM MENU ---");
                System.out.println("1. Create New Account");
                System.out.println("2. Deposit Money");
                System.out.println("3. Withdraw Money");
                System.out.println("4. Display Balance");
                System.out.println("5. Exit");
                System.out.print("Please enter your choice: ");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1: {
                        System.out.print("Enter 10-digit Account Number: ");
                        long accNo = sc.nextLong();
                        sc.nextLine(); // Clear buffer

                        if (String.valueOf(accNo).length() != 10) {
                            System.out.println("Error: Account number must be exactly 10 digits.");
                            break;
                        }

                        // Checking if account already exists in the system
                        String checkQuery = "SELECT accountNumber FROM accounts WHERE accountNumber = ?";
                        PreparedStatement checkStmt = con.prepareStatement(checkQuery);
                        checkStmt.setLong(1, accNo);
                        ResultSet rs = checkStmt.executeQuery();

                        if (rs.next()) {
                            System.out.println("Error: An account with this number already exists.");
                            break;
                        }

                        System.out.print("Enter Account Holder Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Initial Deposit Amount: ");
                        double balance = sc.nextDouble();

                        if (balance < 0) {
                            System.out.println("Error: Initial balance cannot be negative.");
                            break;
                        }

                        String insertQuery = "INSERT INTO accounts (accountNumber, holderName, balance, accountType) VALUES (?, ?, ?, ?)";
                        PreparedStatement pst = con.prepareStatement(insertQuery);
                        pst.setLong(1, accNo);
                        pst.setString(2, name);
                        pst.setDouble(3, balance);
                        pst.setString(4, "Savings");
                        pst.executeUpdate();

                        System.out.println("Account created successfully.");
                        break;
                    }

                    case 2: {
                        System.out.print("Enter Account Number for deposit: ");
                        long depAcc = sc.nextLong();

                        String checkQuery = "SELECT balance FROM accounts WHERE accountNumber = ?";
                        PreparedStatement pst1 = con.prepareStatement(checkQuery);
                        pst1.setLong(1, depAcc);
                        ResultSet rs = pst1.executeQuery();

                        if (!rs.next()) {
                            System.out.println("Error: Account not found.");
                            break;
                        }

                        double currentBalance = rs.getDouble("balance");
                        System.out.print("Enter Amount to Deposit: ");
                        double depAmt = sc.nextDouble();

                        if (depAmt <= 0) {
                            System.out.println("Error: Deposit amount must be positive.");
                            break;
                        }

                        String updateQuery = "UPDATE accounts SET balance = balance + ? WHERE accountNumber = ?";
                        PreparedStatement pst2 = con.prepareStatement(updateQuery);
                        pst2.setDouble(1, depAmt);
                        pst2.setLong(2, depAcc);
                        pst2.executeUpdate();

                        System.out.println("Deposit successful. Updated balance: " + (currentBalance + depAmt));
                        break;
                    }

                    case 3: {
                        System.out.print("Enter Account Number for withdrawal: ");
                        long withAcc = sc.nextLong();

                        String checkQuery = "SELECT balance FROM accounts WHERE accountNumber = ?";
                        PreparedStatement pst1 = con.prepareStatement(checkQuery);
                        pst1.setLong(1, withAcc);
                        ResultSet rs = pst1.executeQuery();

                        if (!rs.next()) {
                            System.out.println("Error: Account not found.");
                            break;
                        }

                        double currentBalance = rs.getDouble("balance");
                        System.out.print("Enter Amount to Withdraw: ");
                        double withAmt = sc.nextDouble();

                        if (withAmt > currentBalance) {
                            System.out.println("Error: Insufficient balance.");
                        } else if (withAmt <= 0) {
                            System.out.println("Error: Invalid withdrawal amount.");
                        } else {
                            String updateQuery = "UPDATE accounts SET balance = balance - ? WHERE accountNumber = ?";
                            PreparedStatement pst2 = con.prepareStatement(updateQuery);
                            pst2.setDouble(1, withAmt);
                            pst2.setLong(2, withAcc);
                            pst2.executeUpdate();
                            System.out.println("Withdrawal successful.");
                        }
                        break;
                    }

                    case 4: {
                        System.out.print("Enter Account Number to view details: ");
                        long viewAcc = sc.nextLong();

                        String viewQuery = "SELECT * FROM accounts WHERE accountNumber = ?";
                        PreparedStatement pst = con.prepareStatement(viewQuery);
                        pst.setLong(1, viewAcc);
                        ResultSet rs = pst.executeQuery();

                        if (rs.next()) {
                            System.out.println("\n--- Account Details ---");
                            System.out.println("Account Number: " + rs.getLong("accountNumber"));
                            System.out.println("Holder Name   : " + rs.getString("holderName"));
                            System.out.println("Current Balance: " + rs.getDouble("balance"));
                            System.out.println("Account Type  : " + rs.getString("accountType"));
                        } else {
                            System.out.println("Error: Account record not found.");
                        }
                        break;
                    }

                    case 5:
                        System.out.println("Exiting the system. Goodbye.");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid input. Please choose a valid menu option.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("General Error: " + e.getMessage());
        }
    }
}
