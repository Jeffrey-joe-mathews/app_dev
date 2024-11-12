package models;

public class User {
    private String username;
    private String password;
    private String fullName;
    private String dob;
    private String gender;
    private int age;
    private String bankAccount;
    private int balance;

    // Constructor without balance
    public User(String username, String password, String fullName, String dob, String gender, int age, String bankAccount) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.dob = dob;
        this.gender = gender;
        this.age = age;
        this.bankAccount = bankAccount;
        this.balance = 0;
    }

    // Constructor with all fields including balance
    public User(String username, String password, String fullName, String dob, String gender, int age, String bankAccount, int balance) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.dob = dob;
        this.gender = gender;
        this.age = age;
        this.bankAccount = bankAccount;
        this.balance = balance;
    }

    // Getters and Setters for all fields
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getDob() { return dob; }
    public void setDob(String dob) { this.dob = dob; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getBankAccount() { return bankAccount; }
    public void setBankAccount(String bankAccount) { this.bankAccount = bankAccount; }

    public int getBalance() { return balance; }
    public void setBalance(int balance) { this.balance = balance; }
}

//package models;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class User {
//    private String username;
//    private String fullName;
//    private int age;
//    private List<BankAccount> accounts;  // List to hold multiple accounts
//
//    public User(String username, String fullName, int age) {
//        this.username = username;
//        this.fullName = fullName;
//        this.age = age;
//        this.accounts = new ArrayList<>();
//    }
//
//    // Add a new account to the user
//    public void addAccount(BankAccount account) {
//        accounts.add(account);
//    }
//
//    // Get a specific account by account number
//    public BankAccount getAccount(String accountNumber) {
//        for (BankAccount account : accounts) {
//            if (account.getAccountNumber().equals(accountNumber)) {
//                return account;
//            }
//        }
//        return null;  // Return null if the account is not found
//    }
//
//    // Get all accounts
//    public List<BankAccount> getAccounts() {
//        return accounts;
//    }
//
//    // Other getters and setters
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getFullName() {
//        return fullName;
//    }
//
//    public void setFullName(String fullName) {
//        this.fullName = fullName;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//}
