package by.training.atm;

/**
 * Created by Evgenia on 16.10.2017.
 */
public class Card {


    private int balance;

    public Card(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
//        System.out.println(balance);
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int addBalance(int i){
        this.balance += i;
        System.out.println("Ваш баланс " + balance);
        return balance;
    }

    public int remBalance(int i){
        this.balance -= i;
        System.out.println("Ваш баланс " + balance);
        return balance;
    }

}
