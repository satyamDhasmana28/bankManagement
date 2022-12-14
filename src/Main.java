public class Main {
    public static void main(String[] args) {
     Sbi satyam = new Sbi("Satyam dhasmana","111");
     Sbi ayush = new Sbi("Ayush makhloga","222");
//     satyam.addToBank();
//     ayush.addToBank();
     satyam.deposit(100,"111");

     satyam.transfer(ayush,11);
     System.out.println(satyam.getBalance());
     System.out.println(ayush.getBalance());
    }
}