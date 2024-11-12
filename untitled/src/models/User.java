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

    public User(String username, String password, String fullName, String dob, String gender, int age, String bankAccount) {
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance=balance;
    }

    // Constructor with all fields
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

    // Getters and setters
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
}
