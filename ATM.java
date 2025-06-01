import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            // ────────── WELCOME BANNER ──────────
            System.out.println("\n\t\t\t\t-------------------------------");
            System.out.println("\t\t\t\t|  Welcome to SBI Banking System  |");
            System.out.println("\t\t\t\t-------------------------------\n");

            // ────────── MAIN MENU ──────────
            System.out.println("Enter your choice");
            System.out.println("1. Signup");
            System.out.println("2. Login");
            System.out.println("3. Password change");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 :
                 {
                    signup s = new signup();
                    s.Enterdetails();
                    System.out.println("Signup successful. Please login to continue.\n");
                    login l = new login(s.getName(), s.getPassword());
                    l.checkPassword();
                }
                case 2 :
                 {
                    login loginExisting = new login("priyanshu", 123456789); // Default details
                    loginExisting.checkPassword();
                }
                case 3 :
                 {
                    System.out.print("Enter username: ");
                    String changeName = scanner.next();
                    System.out.print("Enter password: ");
                    int changePassword = scanner.nextInt();
                    changePassword changePass = new changePassword(changeName, changePassword);
                    changePass.changePassword();
                }
                case 4 :
                 {
                    System.out.print("Are you sure you want to exit? (yes/no): ");
                    String exitConfirmation = scanner.next();
                    if (exitConfirmation.equalsIgnoreCase("yes")) {
                        System.out.println("Exiting...");
                        System.exit(0);
                    } else {
                        main(args);
                    }
                }
                default :
                 System.out.println("Invalid choice");
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            System.out.println("Thank you for using our SBI Banking System.");
        }
    }
}

/*────────────────────────────── CLASSES ──────────────────────────────*/

class signup {
    private String name;
    private int password;
    private final Scanner scanner;

    signup() {
        scanner = new Scanner(System.in);
    }

    void Enterdetails() {
        System.out.print("Enter username: ");
        name = scanner.next();
        System.out.print("Enter password: ");
        password = scanner.nextInt();
    }

    String getName()     { return name; }
    int    getPassword() { return password; }
}

class login {
    private final String name;
    private final int password;
    private final Scanner scanner;

    login(String name, int password) {
        this.name = name;
        this.password = password;
        scanner = new Scanner(System.in);
    }

    void checkPassword() {
        System.out.print("Enter username: ");
        String inputName = scanner.next();
        System.out.print("Enter password: ");
        int inputPassword = scanner.nextInt();

        if (name.equals(inputName) && password == inputPassword) {
            System.out.println("\n---------------------");
            System.out.println("| Welcome, " + name + "! |");
            System.out.println("---------------------\n");
            System.out.println("Your Account number is 62281512511\n");

            /* initialise balance on first login */
            Save.setBalance(100_000);

            System.out.println("Your bank balance = " + Save.getBalance() + "\n");
            operationstarts(scanner);
        } else {
            System.out.println("Invalid username or password. Please try again.");
            checkPassword();
        }
    }

    void operationstarts(Scanner scanner) {
        System.out.println("Choose as per your requirements by entering a number:");
        System.out.println("1. Deposit money");
        System.out.println("2. Withdraw money");
        System.out.println("3. Apply Loan");
        System.out.println("4. Apply Credit Card");
        System.out.println("5. Exit\n");
        int n = scanner.nextInt();
        switch (n) {
            case 1 :
             new deposit(this).displayAmount(scanner);
            case 2 :
             new withdraw(this).displayAmount(scanner);
            case 3 :
             {
                System.out.print("Do you want to apply for a loan? (yes/no): ");
                String applyLoan = scanner.next();
                if (applyLoan.equalsIgnoreCase("yes")) {
                    new loan().processLoan(scanner);
                } else if (applyLoan.equalsIgnoreCase("no")) {
                    operationstarts(scanner);
                } else {
                    System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                    operationstarts(scanner);
                }
            }
            case 4 :
             {
                System.out.print("Do you want to apply for a credit card? (yes/no): ");
                String credit = scanner.next();
                if (credit.equalsIgnoreCase("yes")) {
                    new Creditcard(scanner);
                } else {
                    System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                    operationstarts(scanner);
                }
            }
            case 5 :
             {
                System.out.print("Are you sure you want to exit? (yes/no): ");
                String exitConfirmation = scanner.next();
                if (exitConfirmation.equalsIgnoreCase("yes")) {
                    System.out.println("Exiting...");
                    System.exit(0);
                } else {
                    operationstarts(scanner);
                }
            }
            default :
             {
                System.out.println("Invalid choice. Please try again.");
                operationstarts(scanner);
            }
        }
    }
}

/*─────────────── PASSWORD CHANGE ───────────────*/

class changePassword {
    private final String name;
    private int password;
    private final Scanner scanner;

    changePassword(String name, int password) {
        this.name = name;
        this.password = password;
        scanner = new Scanner(System.in);
    }

    void changePassword() {
        System.out.print("Enter new password: ");
        int newPassword = scanner.nextInt();
        System.out.print("Enter confirm password: ");
        int confirmPassword = scanner.nextInt();

        if (newPassword == password) {
            System.out.println("Please pick a new password (old password not allowed).");
            changePassword();
        } else if (newPassword == confirmPassword) {
            this.password = newPassword;
            System.out.println("Password changed successfully.");
        } else {
            System.out.println("Passwords do not match. Password change failed.");
            changePassword();
        }
    }
}

/*─────────────── BALANCE HANDLING ───────────────*/

/** New helper that permanently holds the current account balance in memory */
class Save {
    private static int balance;

    static int  getBalance()               { return balance; }
    static void setBalance(int amount)     { balance = amount; }
    static void addBalance(int amount)     { balance += amount; }
    static boolean withdraw(int amount) {
        if (amount > balance) return false;
        balance -= amount;
        return true;
    }
}

/*─────────────── WITHDRAW ───────────────*/

class withdraw {
    private final login loginInstance;

    withdraw(login loginInstance) { this.loginInstance = loginInstance; }

    void displayAmount(Scanner scanner) {
        System.out.println("Current Balance: " + Save.getBalance());
        System.out.print("Enter amount to withdraw: ");
        int withAmount = scanner.nextInt();

        if (Save.withdraw(withAmount)) {
            System.out.println("Amount withdrawn successfully.");
            System.out.println("Your bank balance = " + Save.getBalance());
        } else {
            System.out.println("Insufficient balance.");
        }
        continueBanking(scanner);
    }

    private void continueBanking(Scanner scanner) {
        System.out.println("Do you want to continue with banking processing?");
        System.out.println("1 -> Yes\n2 -> No");
        int n = scanner.nextInt();
        loginInstance.operationstarts(scanner);   // either way return to menu
    }
}

/*─────────────── DEPOSIT ───────────────*/

class deposit {
    private final login loginInstance;

    deposit(login loginInstance) { this.loginInstance = loginInstance; }

    void displayAmount(Scanner scanner) {
        System.out.println("Current Balance: " + Save.getBalance());
        System.out.print("Enter amount to deposit: ");
        int depoAmount = scanner.nextInt();

        if (depoAmount > 100_000) {
            System.out.println("Not allowed to deposit more than 100000. Try again.");
            displayAmount(scanner);
            return;
        }
        Save.addBalance(depoAmount);
        System.out.println("Amount deposited successfully.");
        System.out.println("Your bank balance = " + Save.getBalance());
        continueBanking(scanner);
    }

    private void continueBanking(Scanner scanner) {
        System.out.println("Do you want to continue with banking processing?");
        System.out.println("1 -> Yes\n2 -> No");
        scanner.nextInt();                       // choice ignored, always return
        loginInstance.operationstarts(scanner);
    }
}

/*─────────────── LOAN SECTION ───────────────*/

class loan {
    private int caseNumber;

    void processLoan(Scanner scanner) {
        System.out.println("Which type of loan do you prefer:");
        System.out.println("1. Car loan\n2. Home loan\n3. Education loan\n4. Gold loan\n5. Land loan\n6. Personal loan");
        caseNumber = scanner.nextInt();
        switch (caseNumber) {
            case 1 :
             Carloan(scanner);
            case 2 :
             Homeloan(scanner);
            case 3 :
             Educationloan(scanner);
            case 4 :
             Goldloan(scanner);
            case 5 :
             Landloan(scanner);
            case 6 :
             Personalloan(scanner);
            default :
             {
                System.out.println("Invalid choice. Please try again.");
                processLoan(scanner);
            }
        }
    }

    /* Helper to enforce minimum loan amount */
    private boolean checkMinLoan(int loanamount) {
        if (loanamount < 1_000) {
            System.out.println("Loan amount must be at least ₹1000. Application rejected.\n");
            return false;
        }
        return true;
    }

    /* All loan methods below now call checkMinLoan(...) */

    void Carloan(Scanner scanner) {
        System.out.println("\nThe interest rate for Car loan is 12.01%");
        System.out.print("Enter your amount for applying for loan: ");
        int loanamount = scanner.nextInt();
        if (!checkMinLoan(loanamount)) return;

        double interestrate = 12.01;
        System.out.print("Enter years: ");
        int year = scanner.nextInt();
        double total = loanamount * interestrate * year / 100;

        confirmAndFinish(scanner, "Car", loanamount, interestrate, year, total);
    }

    void Homeloan(Scanner scanner) {
        System.out.println("\nThe interest rate for Home loan is 7.23%");
        System.out.print("Enter your amount for applying for loan: ");
        int loanamount = scanner.nextInt();
        if (!checkMinLoan(loanamount)) return;

        double interestrate = 7.23;
        System.out.print("Enter years: ");
        int year = scanner.nextInt();
        double total = loanamount * interestrate * year / 100;

        confirmAndFinish(scanner, "Home", loanamount, interestrate, year, total);
    }

    void Educationloan(Scanner scanner) {
        System.out.println("\nThe interest rate for Education loan is 9.45%");
        System.out.print("Enter your amount for applying for loan: ");
        int loanamount = scanner.nextInt();
        if (!checkMinLoan(loanamount)) return;

        double interestrate = 9.45;
        System.out.print("Enter years: ");
        int year = scanner.nextInt();
        double total = loanamount * interestrate * year / 100;

        confirmAndFinish(scanner, "Education", loanamount, interestrate, year, total);
    }

    void Goldloan(Scanner scanner) {
        System.out.println("\nThe interest rate for Gold loan is 10.00%");
        System.out.print("Enter your amount for applying for loan: ");
        int loanamount = scanner.nextInt();
        if (!checkMinLoan(loanamount)) return;

        double interestrate = 10.00;
        System.out.print("Enter years: ");
        int year = scanner.nextInt();
        double total = loanamount * interestrate * year / 100;

        confirmAndFinish(scanner, "Gold", loanamount, interestrate, year, total);
    }

    void Landloan(Scanner scanner) {
        System.out.println("\nThe interest rate for Land loan is 8.50%");
        System.out.print("Enter your amount for applying for loan: ");
        int loanamount = scanner.nextInt();
        if (!checkMinLoan(loanamount)) return;

        double interestrate = 8.50;
        System.out.print("Enter years: ");
        int year = scanner.nextInt();
        double total = loanamount * interestrate * year / 100;

        confirmAndFinish(scanner, "Land", loanamount, interestrate, year, total);
    }

    int Personalloan(Scanner scanner) {
        System.out.println("\nThe interest rate for Personal loan is 9.75%");
        System.out.print("Enter your amount for applying for loan: ");
        int loanamount = scanner.nextInt();
        if (!checkMinLoan(loanamount)) return 0;

        double interestrate = 9.75;
        System.out.print("Enter years: ");
        int year = scanner.nextInt();
        double total = loanamount * interestrate * year / 100;

        confirmAndFinish(scanner, "Personal", loanamount, interestrate, year, total);
        return loanamount;
    }

    /* Common confirmation & post-processing */
    private void confirmAndFinish(Scanner scanner, String type,
                                  int loanamount, double rate, int year, double total) {
        System.out.println("\nProcessing " + type + " loan...");
        System.out.println("Total amount you must repay with interest: " + total);
        System.out.print("Do you agree? (1 -> yes or 2 -> no): ");
        if (scanner.nextInt() == 1) {
            System.out.println("Loan applied successfully.\n");
        } else {
            System.out.println("Loan cancelled.\n");
        }
    }
}

/*─────────────── CREDIT CARD ───────────────*/

class Creditcard {
    Creditcard(Scanner scanner) {
        System.out.print("\nEnter your name: ");
        String name = scanner.next();
        System.out.print("Enter your SSN Number: ");
        int SSNNumber = scanner.nextInt();
        scanner.nextLine();                               // consume newline
        System.out.print("Enter your address: ");
        String address = scanner.nextLine();
        System.out.print("Enter your employee status: ");
        String employee_status = scanner.nextLine();
        System.out.print("Enter your gross income: ");
        int grossincome = scanner.nextInt();

        System.out.println("\nProcessing credit card...");
        if (grossincome <= 1_000_000) {
            System.out.println("Your request is being sent to the bank...");
            System.out.println("We will notify you soon...\n");
        }
    }
}
