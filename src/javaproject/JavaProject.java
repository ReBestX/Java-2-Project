
package javaproject;

import java.util.ArrayList;
import java.util.Scanner;

public class JavaProject extends StoreInfo {
    
    public static final String RESET = "\033[0m"; // Text Reset
    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String YELLOW= "\033[0;33m"; // YELLOW
    static Scanner input = new Scanner(System.in);
    static ArrayList<Customer> Customers = new ArrayList<Customer>();
    static ArrayList<Items> itemsList = new ArrayList<Items>();
    
    public static void main(String[] args) {
        Customer nC = new Customer();
        Items nI = new Items();
        ShoppingCart nSC = new ShoppingCart();
        Customer newC = new Customer(22,"ayman",new ArrayList<Items>());
        Items newI = new Items(1,"fifa22",100,200,'g');
        Customers.add(newC);
        itemsList.add(newI);
        boolean program = true;
        while(program){
            System.out.println("-------[ "+YELLOW+"Store Main Menu"+RESET+" ]-------");
            System.out.println("""
                               1. Add a new Item to Store.
                               2. Add a new Customer to Store.
                               3. Add an item to Customer shopping cart.
                               4. Remove an item from Customer shopping cart.
                               5. View the items in Customer shopping cart.
                               6. End shopping and go to checkout.
                               7. Empty Customer shopping cart.
                               8. Modify customer data.
                               9. Exit the program.
                               (Enter the Number Twice for Function description)""");
            System.out.println("---------------------------------");
            System.out.print("Please Enter the number of Operation you want : ");
            int operation = input.nextInt();
            switch(operation){
                case 1 : nI.AddItem(); break;
                case 2 : nC.AddCustomer(); break;
                case 3 : nSC.AddShoppingCardItem(); break;
                case 4 : nSC.RemoveShoppingCardItem(); break;
                case 5 : nSC.ViewShoppingCartItems(); break;
                case 6 : nSC.Chechout(); break;
                case 7 : nSC.EmptyCart(); break;
                case 8 : nC.ModifyCustomerData(); break;
                case 9 : program = false;System.out.println(GREEN+"Thanks for your purchase, visit us SOON"+RESET); break;
                case 11 : AddItemDescription(); break;
                case 22 : AddCustomerDescription(); break;
                case 33 : AddShoppingCardItemDescription(); break;
                case 44 : RemoveShoppingCardItemDescription(); break;
                case 55 : ViewShoppingCartItemsDescription(); break;
                case 66 : ChechoutDescription(); break;
                case 77 : EmptyCartDescription(); break;
                case 88 : ModifyCustomerDataDescription(); break;
            }
        }
    }
}
