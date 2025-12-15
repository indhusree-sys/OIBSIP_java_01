import java.util.Scanner;

public class ATMInterfaceUserDefined {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== ATM REGISTRATION =====");
        System.out.print("Create User ID: ");
        String userId = sc.nextLine();

        System.out.print("Create PIN: ");
        int pin = sc.nextInt();

        double balance = 10000;
        String history = "";

        System.out.println("\n===== LOGIN =====");
        sc.nextLine(); // clear buffer

        System.out.print("Enter User ID: ");
        String loginId = sc.nextLine();

        System.out.print("Enter PIN: ");
        int loginPin = sc.nextInt();

        if (!loginId.equals(userId) || loginPin != pin) {
            System.out.println("Invalid credentials!");
            return;
        }

        int choice;

        do {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Choose option: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Transaction History:");
                    if (history.isEmpty()) {
                        System.out.println("No transactions yet.");
                    } else {
                        System.out.println(history);
                    }
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdraw = sc.nextDouble();
                    if (withdraw <= balance) {
                        balance -= withdraw;
                        history += "Withdrawn: ₹" + withdraw + "\n";
                        System.out.println("Please collect your cash.");
                    } else {
                        System.out.println("Insufficient balance!");
                    }
                    break;

                case 3:
                    System.out.print("Enter amount to deposit: ");
                    double deposit = sc.nextDouble();
                    balance += deposit;
                    history += "Deposited: ₹" + deposit + "\n";
                    System.out.println("Amount deposited successfully.");
                    break;

                case 4:
                    System.out.print("Enter amount to transfer: ");
                    double transfer = sc.nextDouble();
                    if (transfer <= balance) {
                        balance -= transfer;
                        history += "Transferred: ₹" + transfer + "\n";
                        System.out.println("Amount transferred successfully.");
                    } else {
                        System.out.println("Insufficient balance!");
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using ATM.");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

            System.out.println("Current Balance: ₹" + balance);

        } while (choice != 5);

        sc.close();
    }
}