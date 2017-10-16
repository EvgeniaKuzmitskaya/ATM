package by.training.atm;

import java.util.Scanner;

/**
 * Created by Evgenia on 05.10.2017.
 */
public class Loader {
    public static void main(String[] args) {

//        int a[] = {5, 10, 20};
//        int sum = 1000;
//        int k=a.length-1;
//        while(k>=0)
//            if(a[k]>sum)
//                k--;
//            else{
//                System.out.println(sum+" - "+a[k]);
//                sum-=a[k];
//            }


        Notes notes = new Notes(1,1,1);
        OperationAtm operationAtm = new OperationAtm(notes);
        Card card = new Card(30);

        Scanner sc = new Scanner(System.in);

        int number;
        do {
            System.out.println("Сделайте ваш выбор:" +
                    " \n 1-пополнить ваш баланс; \n 2-снять деньги со счета; \n 3-посмотреть баланс на счету; \n 4-выход.");
            number = sc.nextInt();
            int operationFive;
            int operationTen;
            int operationTwenty;
            int operation;
            int sum = 0;
            int moneyAmount = operationAtm.getNotes().getBalance();
            switch (number) {
                case 1: {
                    System.out.println("Введите сумму на которую вы хотите пополнить ваш счет:");
                    System.out.println("Введите количество 5 долларовых купюр");
                    operationFive=sc.nextInt();
                    notes.setFive(operationFive);
                    System.out.println("Введите количество 10 долларовых купюр");
                    operationTen=sc.nextInt();
                    notes.setTen(operationTen);
                    System.out.println("Введите количество 20 долларовых купюр");
                    operationTwenty=sc.nextInt();
                    notes.setTwenty(operationTwenty);
                    sum = card.addBalance(operationFive*5+operationTen*10+operationTwenty*20); // сумма на счете у клиента
                    moneyAmount += sum;
                    operationAtm.putMoney(moneyAmount);
                    System.out.println(notes.getTen());
                    System.out.println(notes.getFive());
                    System.out.println(notes.getTwenty());
                    break;}
                case 2:{
                    System.out.println("Введите сумму которую вы хотите снять со счета:");
                    operation = sc.nextInt();
                    if (card.getBalance()<operation)
                        System.out.println("У вас нет такой суммы денег!");
                    else
                        try {
                            operationAtm.takeMoney(operation);
                            sum = card.remBalance(operation);
                        } catch (NotEnoughMoneyException e) {
                            e.printStackTrace();
                        }
                    break;
                }
                case 3:
                    System.out.println(card.getBalance());
                    break;
                case 4:
                    System.out.println("Спасибо за пользование нашей программой!");
                    System.exit(0);
            }
        }while (number!=4);
    }

    //проверка строки на тип Integer
    private boolean isInteger(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }



}













