
package javaproject;

import java.util.InputMismatchException;
import static javaproject.JavaProject.*;

public class Items{
    private int itemNumber;
    private String itemName;
    private int itemQuantity;
    private char itemType;
    private double itemPrice;
    
    public Items(){}
    public Items(int itemNumber, String itemName, int itemQuantity, double itemPrice, char itemType) {
        this.itemNumber = itemNumber;
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
        this.itemPrice = itemPrice;
        this.itemType = itemType;
    }
    public int getItemNumber() {
        return itemNumber;
    }
    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public int getItemQuantity() {
        return itemQuantity;
    }
    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }
    public double getItemPrice() {
        return itemPrice;
    }
    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }
    public char getItemType() {
        return itemType;
    }
    public void setItemType(char itemType) {
        this.itemType = itemType;
    }
    public void AddItem(){
        System.out.println(YELLOW+"[ Add Item Operation: ]"+RESET);
        boolean Flag = true;
        while(Flag){
            int itemNo = 0;
            boolean flag2 = true;
            while (flag2) {
                boolean validInput = false;
                while (!validInput) {
                    try {
                        System.out.print("Please enter the item Number : ");
                        itemNo = input.nextInt();
                        validInput = true;
                    } catch (InputMismatchException e) {
                        System.out.println(RED+"[ERROR] > A Name in place of a Number!, "+RESET+"Please enter a number.");
                        input.nextLine();
                    }
                }
                boolean flagIN = false;
                for (int i = 0; i < itemsList.size(); i++) {
                    if (itemsList.get(i).getItemNumber() == itemNo) {
                        flagIN = true;
                        break;
                    }
                }
                if (flagIN) {
                    System.out.println(RED+"[ERROR] > the Number you entered is taken by another item, please try again"+RESET);
                } else {
                    flag2 = false;
                }
            }
            input.nextLine();
            System.out.print("Please enter the item Name : ");
            String itemName = input.nextLine();
            boolean Flag4 = true;
            int itemQuantity = 0;
            while(Flag4){
                boolean validInput = false;
                while (!validInput) {
                    try {
                        System.out.print("Please enter the Quantity : ");
                        itemQuantity = input.nextInt();
                        validInput = true;
                    } catch (InputMismatchException e) {
                        System.out.println(RED+"[ERROR] > A Name in place of a Number!, "+RESET+"Please enter a number.");
                        input.nextLine();
                    }
                }
                if(itemQuantity<=0){
                    System.out.println(RED+"[ERROR] > invalid Quantity, Please Enter a Valid One"+RESET);
                }else{
                    Flag4 = false;
                }
            }
            boolean Flag5 = true;
            double itemPrice = 0;
            while(Flag5){
                boolean validInput = false;
                while (!validInput) {
                    try {
                        System.out.print("Please enter the Price : ");
                        itemPrice = input.nextDouble();
                        validInput = true;
                    } catch (InputMismatchException e) {
                        System.out.println(RED+"[ERROR] > A Name in place of a Number!, "+RESET+"Please enter a number.");
                        input.nextLine();
                    }
                }
                if(itemPrice<=0){
                    System.out.println(RED+"[ERROR] > invalid Price, Please Enter a Valid One"+RESET);
                }else{
                    Flag5 = false;
                }
            }
            input.nextLine();
            boolean Flag3 = true;
            while (Flag3) {
                System.out.print("Enter the type of item (B)Book, (s)shoes, (G)Game? : ");
                char itemType = input.nextLine().toLowerCase().charAt(0);
                switch (itemType) {
                    case 'b':
                        System.out.print("Enter the Book title: ");
                        String bookTitle = input.nextLine();
                        System.out.print("Enter the Book author name: ");
                        String bookAuthor = input.nextLine();
                        books newBook = new books(itemNo, itemName, itemQuantity, itemPrice, itemType, bookTitle, bookAuthor);
                        itemsList.add(newBook);
                        System.out.println(GREEN+"[DONE] > Item added Successfully"+RESET);
                        Flag3 = false;
                        break;
                    case 's':
                    case 'g':
                        Items newitem2 = new Items(itemNo,itemName,itemQuantity,itemPrice,itemType);
                        itemsList.add(newitem2);
                        System.out.println(GREEN+"[DONE] > Item added Successfully"+RESET);
                        Flag3 = false;
                        break;
                    default:
                        System.out.println(RED+"[ERROR] > incorrect entry, please try again"+RESET);
                }
            }
            boolean FlagEnd = true;
            while(FlagEnd){
                System.out.print("Do you want add another item (y/n)? ");
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
}
