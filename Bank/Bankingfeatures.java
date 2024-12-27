package Bank;
import java.util.HashSet;
import java.util.Scanner;

import BankingException.BankingException;
interface NormalBank {
    /*
     * Those who want to deposit money specifically for bank
     * use deposit method to deposit money in bank
     */
    // @Override compoulsory which class implents it
    public void Deposit() throws BankingException;

    /*
     * those who want to withdrawl money in bank where user deposit money
     * use withdrawl method to withdrawl money
     * and it is not over the deposit
     * someone try to implement this method to use password
     */
    public int Withdraw(int money, String want_To_ShowMoney_After_Withdrawl, int password) throws BankingException;

    /*
     * those who want to check money in deposit use
     * the method called MiniStatement
     * it is a sensitive it also required password
     */
    public int MiniStatement(int password) throws BankingException;

    /*
     * Bank has special pin to everyuser
     * it contains 8 numbers
     * it doesnot follow any sequence
     * it some forget the password it has method to get password it accept the
     * deposit money or bank number to see those password
     */
    public void Forgetpassword(double otp, int newpassword,int BankNumber) throws BankingException;

    /*
     * if you want to apply atm you have to give your
     * passbook details,some information about which bank you create your atm etc
     */
    public void CreateAccount() throws BankingException;
}
/*
 * this exception is used for checked exception wheere the user give some 
 * wrong information or want to access private data
 */


public class Bankingfeatures implements NormalBank {
    public  String BankName; 
    private String AcHolderName;
    private int Adhar;
    private int age;
    private int Bankmoney;
    public boolean isUsed = false;
    private HashSet<String> uniqueSet = new HashSet<>();//it will take a set of uniqueuser it check if user exists then it will cancel the method of creating account
    String uniqueUser;//it will take name and age from user and concatinate it and stores it
    Scanner sc = new Scanner(System.in);
    public String getAcHolderName() { //if someone want to acess get the ac holder name  use this method to use their name in bank
        return AcHolderName;
    }
    public int getAdhar() { //if someone want to adhar number use this method to print method
        return Adhar;
    }
    private int passkey;
    private int BankACNumber;
    
    public Bankingfeatures(){
        this.BankName = this.getClass().getSimpleName();
    }

    public void Deposit() throws BankingException { // if some one want to deposit money it stores the value in banking money
       if (isUsed == true) {
          System.out.println("Enter your amount you want to deposit");
          int Money = sc.nextInt();
           this.Bankmoney = Money;
       }
       else{
        throw new BankingException("You are not a eligible user");
       }
    }

    public void setPassword(int passkey) {// for set the password and if the password is alreay set it cant be overriden
                                          // by any chance
        if (passkey != -1) { // It Means Password is alreay set for this reason it cannot be overriden
            return;
        }
        if (passkey == -1) { // if the password is not set it must follow the method and set the password
            this.passkey = passkey;
        }

    }

    public int getMoney(int password) throws BankingException {
         /** if someone want to get money after withdrawl then it
          * is called internall  */                                                                                                      
                                                                
        if (password == passkey) {
            return Bankmoney;
        }
        throw new BankingException("you have to set password first");
    }

    @Override
    public int Withdraw(int money, String want_To_ShowMoney_After_Withdrawl, int password) throws BankingException {
        if (password == passkey) {
            System.out.println("this is withdrawl amount" + " : " + money);
            this.Bankmoney = Bankmoney - money;
        }

        if (want_To_ShowMoney_After_Withdrawl == "yes") {
            return getMoney(password);
        }
        return -1;

    }

    @Override
    public int MiniStatement(int password) throws BankingException {
        if (passkey == password) {
            return Bankmoney;
        }
        throw new BankingException("Enter a right password or create password");
    }
    /*
     * if someone forget password the method internally calles and generate some otp if user input a valid otp then it reset the password 
     */
    double Generateotp; //it stores the value when the generate otp method calls it stores directly
    public void generateotp(int BankNumber) throws BankingException{ /*when someone create obj and use this feauture the creator of bank 
        explicitely handle the exception and it shows the otp when you  pass the otp int the Forget pass method he is able to set a new password */
        if (BankNumber == BankACNumber) {
            Generateotp = 10*(int)Math.random();
            System.out.println(Generateotp);
        }
       throw new BankingException("enter a valid BankNumber");         
    }
    @Override
    public void Forgetpassword(double otp, int newpassword,int BankNumber) throws BankingException {/*
        this method is valid for this user where the user forget their password and set the password for a new password
         it requires some banking information so it might be complicated and safety issue */
        if (otp == Generateotp) {
            passkey = -1;
        }
          setPassword(newpassword);
          throw new BankingException("Enter a Correct otp,valid BankNumber");
    }
/*
 * for those who want to crate a bank account pass all the information other wise it give error and you have to handle 
 * this error and those who paass not the all information which fullfill the criteria of create a bank account it will give you the error
 */
    @Override
    public void CreateAccount() throws BankingException {
        if (uniqueSet.contains(uniqueUser)) {
            System.out.println("You are an existing user");
        }else{
     if(!isUsed){
        
            System.out.println("Enter your Name :");
            AcHolderName = sc.nextLine();//input from user  for acholder name
            System.out.println("Enter your adhar number :");
            Adhar = sc.nextInt();//input from user name for adharnumber
            System.out.println("Enter your age :");
            age = sc.nextInt();//input user for age
            System.err.println("Enter you bank number which you want :");
            BankACNumber = sc.nextInt();//input user name for BankAcNumber
            System.out.println("Enter you passkey and remember it only set once if it once set you cant change the passkey :");
            passkey = sc.nextInt();//input user from passkey and set password method set the password for user
            setPassword(passkey);
            uniqueUser = AcHolderName+age;
            uniqueSet.add(uniqueUser);
                if (age<=18) { 
                    throw new BankingException("you are not eligible for createAccount"); 
                }
                else{
                    System.out.println("Congratulation you Create A BankAccount on this : " + BankName);
                }       
        }
        else{
            System.out.println("You are Existing user");
        }
    } 
}
}

