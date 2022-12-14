import java.util.ArrayList;
import java.util.Objects;

public class Sbi implements Bank{
    String accountHolderName;
    String password;
    int balance;
    private  ArrayList<Integer> miniStatmentList;
    private static ArrayList<Sbi> bankUsers = new ArrayList<>();

    public Sbi(String accountHolderName, String password) {
        this.accountHolderName = accountHolderName;
        this.password = password;
        this.miniStatmentList = new ArrayList<>();
        addToBank();
    }
    private void addToBank(){
        bankUsers.add(this);
    }

    @Override
    public void deposit(int amount,String enteredPassword) {
    if(!this.password.equals(enteredPassword)){
        System.out.println("Wrong password! :(");
    }
    else{
        this.balance+=amount;
        miniStatmentList.add(amount);
        System.out.println("Succesfully deposited "+"Rs"+amount);
    }
    }
//    private void withdrawal(int amount){
//        this.balance-=amount;
//    }

    @Override
    public boolean withdrawal(int amount,String enteredPassword) {
        if(!this.password.equals(enteredPassword)){
            System.out.println("Wrong password! :(");
            return false;
        } else if (amount>this.balance) {
            System.out.println("Insufficient Balance");
            return false;
        } else{
            this.balance-=amount;
            miniStatmentList.add(-amount);
            return true;
        }

    }

    public  boolean isExist(){
        for(Sbi user : bankUsers){
            if(Objects.equals(user.accountHolderName, this.accountHolderName))
                return true;
        }
//        System.out.println("Account Holder Doesn't exists");
        return false;
    }
    public boolean transfer(Sbi receiver,int amount) {
       if(receiver.isExist()==false){
           System.out.println("Account holder not exists");
           return false;
       }
       else if(this.balance<amount){
           System.out.println("Insufficient Balance");
           return false;
       }
       else{
           this.withdrawal(amount,this.password);
           receiver.deposit(amount,receiver.password);
           return true;
       }
    }

    @Override
    public void miniStatement() {
        System.out.println(this.miniStatmentList);
    }

    public int getBalance(){
        return this.balance;
    }
}
