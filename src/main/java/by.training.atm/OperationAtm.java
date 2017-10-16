package by.training.atm;

/**
 * Created by Evgenia on 05.10.2017.
 */
public class OperationAtm {
//    private static int balance = 0;
    Notes notes;

    public OperationAtm(Notes notes) {
        this.notes = notes;
    }
    private static int balance = Notes.getBalance();

    public static int getBalance() {
        return balance;
    }

    public static void setBalance(int balance) {
        OperationAtm.balance = balance;
    }

    public static Integer putMoney (int moneyAmount){
        if(moneyAmount%5==0){
            balance += moneyAmount;
            System.out.println("Сумма счета стала равна: " + balance);
        } else {
            System.out.println("Сумма не может быть принята. Банкомат принимает купюры номиналом 5,10,20");
        }
        return balance;
    }

    public static int takeMoney(int moneyAmount) throws NotEnoughMoneyException {
        if (moneyAmount > balance)
            throw new NotEnoughMoneyException();
        if(moneyAmount%5==0){
        balance -= moneyAmount;
        System.out.println("Сумма счета стала равна: " + balance);
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



