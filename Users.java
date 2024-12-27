import java.util.Scanner;

import AxisBank.*;
import BankingException.BankingException;
public class Users {
    public static void main(String[] args) {
   
        Axisbank obj = new Axisbank();
             try {
                obj.CreateAccount();
            } catch (BankingException e) {
              System.out.println(e);
            }
            try {
                obj.Deposit();
            } catch (BankingException e) {
               System.out.println(e);
            }
          }   
        }
    
