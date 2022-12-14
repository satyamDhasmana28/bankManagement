public interface Bank {
    void deposit(int amount ,String password);
    boolean withdrawal(int amount , String password);
//    boolean transfer(Object receiver);
    void miniStatement();
}
