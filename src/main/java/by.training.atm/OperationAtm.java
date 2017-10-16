package by.training.atm;

/**
 * Created by Evgenia on 05.10.2017.
 */
public class OperationAtm {

    private int balance;
    Notes notes;

    public OperationAtm(Notes notes) {
        this.notes = notes;
        balance = notes.getBalance();
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Notes getNotes() {
        return notes;
    }

    public void setNotes(Notes notes) {
        this.notes = notes;
    }


    public Integer putMoney (int moneyAmount){
        if(moneyAmount%5==0){
            balance += moneyAmount;
            System.out.println("Сумма в банкомате стала равна: " + balance);
        } else {
            System.out.println("Сумма не может быть принята. Банкомат принимает купюры номиналом 5,10,20");
        }
        return balance;
    }

    public int takeMoney(int moneyAmount) throws NotEnoughMoneyException {
        int s;
        if (moneyAmount > balance)
            throw new NotEnoughMoneyException();
        if(moneyAmount%5==0){
            if (moneyAmount>=20 && notes.getTwenty()*20>=moneyAmount){
               if (moneyAmount%20==0){
                balance -= moneyAmount;
                notes.remTwenty(moneyAmount/20);
               }
               else if(moneyAmount%10==0){
                   balance -=moneyAmount;
                   notes.remTen(moneyAmount/10);
               }
               else if(moneyAmount%5==0){
                   balance -=moneyAmount;
                   notes.remFive(moneyAmount/5);
               }
            }
        System.out.println("Сумма в банкомате стала равна: " + balance);
        } else {
            int i = moneyAmount%5;
            int sum = moneyAmount - i;
            System.out.println("Выдано - " + sum + " руб." + " Выдает купюры номиналом 5,10,20");
            balance -= sum;
            System.out.println("Сумма счета стала равна: " + balance);
        }
        return balance;
    }

}



