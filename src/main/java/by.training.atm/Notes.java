package by.training.atm;

/**
 * Created by Evgenia on 05.10.2017.
 */
public class Notes {

    private int five;
    private int ten;
    private int twenty;
    private static int balance;

//    public Notes(){};

    public Notes(int five, int ten, int twenty) {
        this.five = five;
        this.ten = ten;
        this.twenty = twenty;
        balance = this.five*5+this.ten*10+this.twenty*20;
    }

    public int getFive() {
        return five;
    }

    public int getTen() {
        return ten;
    }

    public int getTwenty() {
        return twenty;
    }

    public static int getBalance(){

        return balance;
    }

    public static void setBalance(int balance) {
        Notes.balance = balance;
    }

    public void setFive(int five) {
        this.five = five;
    }

    public void setTen(int ten) {
        this.ten = ten;
    }

    public void setTwenty(int twenty) {
        this.twenty = twenty;
    }
}
