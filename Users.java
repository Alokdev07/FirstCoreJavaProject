import java.util.Scanner;
import AxisBank.*;
import Bank.Bankingfeatures;
import BankofAmerica.*;
import BankofBaroda.*;
import HDFCBank.*;
import ICICBank.*;
import PunjabNationalBank.*;
import StateBankOfIndia.*;
import UnionBank.*;
import BankofIndia.*;
import BankingException.BankingException;

public class Users {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a bank name which you want to use");
    String BankAcc = sc.nextLine().toLowerCase();
    Bankingfeatures bank = null;
    Boolean Bankselected = false;
    switch (BankAcc) {

      case "axisbank":
        Bankselected = true;
        bank = new Axisbank();
        break;
      case "BankofAmerica":
        Bankselected = true;
        bank = new BankofAmerica();
        break;
      case "BankofBaroda":
        Bankselected = true;
        bank = new BankofBaroda();
        break;
      case "HDFCBank":
        Bankselected = true;
        bank = new HDFCBank();
        break;
      case "ICICBank":
        Bankselected = true;
        bank = new ICICBank();
      case "PunjabNationalBank":
        Bankselected = true;
        bank = new PunjabNationalBank();
        break;
      case "StateBankOfIndia":
        Bankselected = true;
        bank = new StateBankOfIndia();
        break;
      case "UnionBank":
        Bankselected = true;
        bank = new UnionBank();
        break;
      case "BankofIndia":
        Bankselected = true;
        bank = new BankofIndia();
        break;
      default:
        System.out
            .println("you have entered a wrong bank name or the name which you enter this is not in my code base");
        break;
    }
    System.out.println("Enter what you want to do with your bank");
    String command = sc.nextLine().toLowerCase();
    if (Bankselected == true) {

      switch (command) {
        case "createaccount":
          try {
            bank.CreateAccount();
          } catch (BankingException e) {
            System.out.println(e);
          }
          break;

        default:
          System.out.println("Enter a valid command");
          break;
      }
    } else {
      System.out.println("Select a Bank First");
    }
  }
}
