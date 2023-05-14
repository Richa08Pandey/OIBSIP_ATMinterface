// importing necessary class
import java.util.*;

public class ATM_Machine {
    public static void main(String[] args) {
        //user input
            Scanner scanner = new Scanner(System.in);
            Deposit dep = new Deposit();
            Withdraw wd = new Withdraw();
            Transfer t = new Transfer();

          // user info  
            System.out.println("Please enter your user name:");
            String user = scanner.next();
            System.out.println("Please enter your user pin:");
            int pin = scanner.nextInt();


            int choice;
            double balance;
            double amount ;
              
            //making choices for various operations to be performed

            do {

                System.out.println("1. Transcation History");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. Transfer");
                System.out.println("5. Quit");

                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Your current balance is: " + TranHist.getBalance());
                        break;

                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        amount = scanner.nextDouble();
                        Withdraw.withdraw(amount);
                        break;
                    case 3:
                        System.out.print("Enter amount to deposit: ");
                        amount = scanner.nextDouble();
                        Deposit.deposit(amount);
                        break;
                    case 4:
                        System.out.println("Enter money to be transfered:" );
                        amount = scanner.nextDouble();
                        Transfer.transfer(amount);
                        break;
                    case 5:
                        System.out.println("Thank you for using our bank!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } while (choice != 5);

            scanner.close();
        }
    }

    class Deposit{
        public static double balance;
        public static void deposit(double amount) {
            balance += amount;
            System.out.println("Deposit successful.");
        }
    }

    class Withdraw{
        static Deposit b= new Deposit();
        static double bal=b.balance;
        static public double Wleft;

        public static void withdraw(double amount) {
            if (bal <= amount) {
                bal -= amount;
                Wleft = amount;
                System.out.println("Withdrawal successful.");
            } else {
                System.out.println("Insufficient funds. Withdrawal unsuccessful.");
            }
        }
    }
    class  Transfer {

        static Deposit b= new Deposit();
        static double bal=b.balance;
        public static double Tleft;

        public static void transfer(double amount){
                bal -= amount;
                Tleft = amount;
                System.out.println("Transferred successful.");

        }

    }
    class TranHist{
        static Deposit b= new Deposit();
        static double bal=b.balance;
        public static double getBalance() {
            Transfer a = new Transfer();
            Withdraw b = new Withdraw();
            double sum = a.Tleft + b.Wleft;
            return (bal-sum) ;
        }

    }
