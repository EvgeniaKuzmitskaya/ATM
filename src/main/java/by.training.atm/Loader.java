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


//        Notes notes = new Notes(1,1,1);
//        OperationAtm operationAtm = new OperationAtm(notes);

        Scanner sc = new Scanner(System.in);
        int moneyAmount=0;
        int number;
        do {
            System.out.println("Сделайте ваш выбор:" +
                    " \n 1-пополнить ваш баланс; \n 2-снять деньги со счета; \n 3-посмотреть баланс на счету; \n 4-выход.");
            number = sc.nextInt();
            int operation;
            switch (number) {
                case 1: {
                    System.out.println("Введите сумму на которую вы хотите пополнить ваш счет:");
                    operation=sc.nextInt();
                    moneyAmount+= operation;
                    OperationAtm.putMoney(moneyAmount);
                    break;}
                case 2:{
                    System.out.println("Введите сумму которую вы хотите снять со счета:");
                    operation = sc.nextInt();
                    if (moneyAmount<operation)
                        System.out.println("У вас нет такой суммы денег!");
                    else
                        try {
                            OperationAtm.takeMoney(operation);
                        } catch (NotEnoughMoneyException e) {
                            e.printStackTrace();
                        }
                    break;
                }
                case 3:
                    System.out.println(moneyAmount);
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













