
package javaproject;

import java.util.ArrayList;
import java.util.InputMismatchException;
import static javaproject.JavaProject.*;

public class Customer {
    private int CustomerNo;
    private String CustomerName;
    private ArrayList<Items> ShoppingCart = new ArrayList<>();
    public Customer(){}
    public Customer(int CustomerNo,String CustomerName,ArrayList<Items> ShoppingCart){
        this.CustomerNo = CustomerNo;
        this.CustomerName = CustomerName;
        this.ShoppingCart = ShoppingCart;
    }
    public int getCustomerNo() {
        return CustomerNo;
    }
    public void setCustomerNo(int CustomerNo) {
        this.CustomerNo = CustomerNo;
    }
    public String getCustomerName() {
        return CustomerName;
    }
    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }
    public ArrayList<Items> getShoppingCart() {
        return ShoppingCart;
    }
    public void setShoppingCart(ArrayList<Items> ShoppingCart) {
        this.ShoppingCart = ShoppingCart;
    }
    public void AddCustomer(){
        System.out.println(YELLOW+"[ Add new Customer Operation: ]"+RESET);
        boolean Flag = true;
        while(Flag){
            int CustomerNo = 0;
            boolean flag2 = true;
            while (flag2) {
                boolean validInput = false;
                while (!validInput) {
                    try {
                        System.out.print("Please enter the Customer Number : ");
                        CustomerNo = input.nextInt();
                        validInput = true;
                    } catch (InputMismatchException e) {
                        System.out.println(RED+"[ERROR] > A Name in place of a Number!, "+RESET+"Please enter a number.");
                        input.nextLine();
                    }
                }
                boolean flagIN = false;
                for (int i = 0; i < Customers.size(); i++) {
                    if (Customers.get(i).getCustomerNo() == CustomerNo) {
                        flagIN = true;
                        break;
                    }
                }
                if (flagIN) {
                    System.out.println(RED+"[ERROR] > the Number you entered is taken by another Customer, please try again"+RESET);
                } else {
                    flag2 = false;
                }
            }
            input.nextLine();
            System.out.print("Please Enter the Customer Name : ");
            String CustomerName = input.nextLine();
            ArrayList<Items> ShoppingCart = new ArrayList<Items>();
            Customer newCustomer = new Customer(CustomerNo,CustomerName,ShoppingCart);
            Customers.add(newCustomer);
            System.out.println(GREEN+"[DONE] > Customer added with empty Shopping Card Successfully"+RESET);
            boolean FlagEnd = true;
            while(FlagEnd){
                System.out.print("Do you want add another Customer (y/n)? ");
                char selector = input.nextLine().toLowerCase().charAt(0);
                if(selector == 'y'){
                    Flag = true;
                    FlagEnd = false;
                }else if(selector == 'n'){
                    Flag = false;
                    FlagEnd = false;
                } else {
                    System.out.println(RED + "[ERROR] > Invalid input. Please enter 'y' or 'n'." + RESET);
                }
            }
        }
    }
    public void ModifyCustomerData(){
        System.out.println(YELLOW+"[ Modify Customer Data: ]"+RESET);
        boolean Flag = true;
        while(Flag){
            boolean Flag2 = true;
            char selector = 'y';
            char selectorplz = 'y';
            Customer SelectedCustomer = new Customer();
            while(Flag2){
                int CustomerNumber = 0;
                boolean validInput = false;
                while (!validInput) {
                    try {
                        System.out.print("Please Enter Customer Number : ");
                        CustomerNumber = input.nextInt();
                        validInput = true;
                    } catch (InputMismatchException e) {
                        System.out.println(RED+"[ERROR] > A Name in place of a Number!, "+RESET+"Please enter a number.");
                        input.nextLine();
                    }
                }
                boolean FlagIN = false;
                for (int i = 0; i < Customers.size(); i++) {
                    if(Customers.get(i).getCustomerNo() == CustomerNumber){
                        FlagIN = true;
                        SelectedCustomer = Customers.get(i);
                        Flag2 = false;
                        break;
                    }
                }
                input.nextLine();
                if(FlagIN == false){
                    System.out.print(RED+"[ERROR] > The Customer is not exists, "+RESET);
                    boolean FlagEnd = true;
                    while(FlagEnd){
                        System.out.print("Do you want to try again (y/n)? ");
                        selector = input.nextLine().toLowerCase().charAt(0);
                    if(selector == 'y'){
                        Flag2 = true;
                        FlagEnd = false;
                    }else if(selector == 'n'){
                        Flag2 = false;
                        FlagEnd = false;
                    } else {
                        System.out.println(RED + "[ERROR] > Invalid input. Please enter 'y' or 'n'." + RESET);
                    }
                    }
                }
            }
            if(selector == 'n'){
                Flag = false;
                break;
            }
            System.out.println("The Customer No : "+YELLOW+SelectedCustomer.getCustomerNo()+RESET+",The Customer Name : "+YELLOW+SelectedCustomer.getCustomerName()+RESET);
            int NewCustomerNumber = 0;
            boolean flag2 = true;
            while (flag2) {
                boolean validInput = false;
                while (!validInput) {
                    try {
                        System.out.print("please enter the Customer NEW number : ");
                        NewCustomerNumber = input.nextInt();
                        validInput = true;
                    } catch (InputMismatchException e) {
                        System.out.println(RED+"[ERROR] > A Name in place of a Number!, "+RESET+"Please enter a number.");
                        input.nextLine();
                    }
                }
                boolean flagIN = false;
                for (int i = 0; i < Customers.size(); i++) {
                    if (Customers.get(i).getCustomerNo() == NewCustomerNumber) {
                        flagIN = true;
                        break;
                    }
                }
                if(SelectedCustomer.getCustomerNo() == NewCustomerNumber){
                    flag2 = false;
                    break;
                }
                if (flagIN) {
                    System.out.println(RED+"[ERROR] > the Number you entered is taken by another Customer, please try again"+RESET);
                } else {
                    flag2 = false;
                }
            }
            SelectedCustomer.setCustomerNo(NewCustomerNumber);
            System.out.print("please enter the Customer NEW Name : ");
            input.nextLine();
            String NewCustomerName = input.nextLine();
            SelectedCustomer.setCustomerName(NewCustomerName);
            System.out.println(GREEN+"[DONE] > Customer modified Successfully"+RESET);
            boolean FlagEnd = true;
            while(FlagEnd){
                System.out.print("Do you want modify another Customer (y/n)? ");
                selectorplz = input.nextLine().toLowerCase().charAt(0);
                if(selectorplz == 'y'){
                    Flag = true;
                    FlagEnd = false;
                }else if(selectorplz == 'n'){
                    System.out.println("back to main menu");
                    Flag = false;
                    FlagEnd = false;
                } else {
                    System.out.println(RED + "[ERROR] > Invalid input. Please enter 'y' or 'n'." + RESET);
                }
            }
        }
    }
}
