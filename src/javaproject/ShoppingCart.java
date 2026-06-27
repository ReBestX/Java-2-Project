

package javaproject;

import static javaproject.JavaProject.*;
import java.text.DecimalFormat;
import java.util.InputMismatchException;

public class ShoppingCart {
    
    public void AddShoppingCardItem(){
        System.out.println(YELLOW+"[ Add Item to Customer Shopping Cart Operation: ]"+RESET);
        boolean Flag = true;
        while(Flag){
            boolean Flag2 = true;
            char selector = 'y';
            char selectorpls = 'y';
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
                        System.out.print("Do you want to try again (y/n)?");
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
            Items[] arr = new Items[itemsList.size()];
            for(int i = 0;i<itemsList.size();i++){
                System.out.println(">>> "+(i+1)+". "+itemsList.get(i).getItemNumber()+" "+itemsList.get(i).getItemName()+". ["+itemsList.get(i).getItemQuantity()+"]");
                arr[i] = itemsList.get(i);
            }
            System.out.println(">>> 0. Return to a main menu");
            boolean Flag3 = true;
            while(Flag3){
                int selectedindex = 0;
                boolean validInput = false;
                while (!validInput) {
                    try {
                        System.out.print("Enter your choice item : ");
                        selectedindex = input.nextInt();
                        validInput = true;
                    } catch (InputMismatchException e) {
                        System.out.println(RED+"[ERROR] > A Name in place of a Number!, "+RESET+"Please enter a number.");
                        input.nextLine();
                    }
                }
                boolean Validindex = true;
                while(Validindex){
                    if(selectedindex >= 0 && selectedindex-1 < itemsList.size()){
                        Validindex = false;
                        break;
                    }else{
                        System.out.println(RED+"[ERROR] > Unknown index! "+RESET+", please try again");
                        boolean validInput2 = false;
                        while (!validInput2) {
                            try {
                                System.out.print("Enter your choice item : ");
                                selectedindex = input.nextInt();
                                validInput2 = true;
                            } catch (InputMismatchException e) {
                                System.out.println(RED+"[ERROR] > A Name in place of a Number!, "+RESET+"Please enter a number.");
                                input.nextLine();
                            }
                        }
                    }
                }
                if(selectedindex == 0){
                    Flag = false;
                    break;
                }
                selectedindex--;
                Items selecteditem = itemsList.get(selectedindex);
                System.out.println("The item is ["+YELLOW+selecteditem.getItemNumber()+" "+selecteditem.getItemName()+RESET+" ["+YELLOW+selecteditem.getItemQuantity()+RESET+"]]");
                int quantityNeeded = 0;
                boolean validInput2 = false;
                while (!validInput2) {
                    try {
                        System.out.print("Enter the quantity you need : ");
                        quantityNeeded = input.nextInt();
                        validInput2 = true;
                    } catch (InputMismatchException e) {
                        System.out.println(RED+"[ERROR] > A Name in place of a Number!, "+RESET+"Please enter a number.");
                        input.nextLine();
                    }
                }
                if(quantityNeeded > selecteditem.getItemQuantity()){
                    System.out.println(RED+"[ERROR] > Sorry the required quantity is not avalible "+RESET+", the available quantity is ["+selecteditem.getItemQuantity()+"],try again!");
                }else if(quantityNeeded <= selecteditem.getItemQuantity() && selecteditem.getItemQuantity()>0 && quantityNeeded>0){
                    Items GettingItemReady = new Items();
                    if(selecteditem.getItemType() == 'b'){
                        books GettingbookReady = new books();
                        books selectedbook = (books)selecteditem;
                        GettingbookReady.setItemName(selectedbook.getItemName());
                        GettingbookReady.setItemNumber(selectedbook.getItemNumber());
                        GettingbookReady.setItemPrice(selectedbook.getItemPrice());
                        GettingbookReady.setItemType((char)selectedbook.getItemType());
                        GettingbookReady.setBookTitle(selectedbook.getBookTitle());
                        GettingbookReady.setBookAuthor(selectedbook.getBookAuthor());
                        GettingbookReady.setItemQuantity(quantityNeeded);
                        SelectedCustomer.getShoppingCart().add(GettingbookReady);
                        System.out.println(GREEN+"[DONE] > The item is ["+GettingbookReady.getItemNumber()+" "+GettingbookReady.getItemName()+" ["+GettingbookReady.getItemQuantity()+"]] adding to shopping cart success"+RESET);
                    }else{
                        GettingItemReady.setItemName(selecteditem.getItemName());
                        GettingItemReady.setItemNumber(selecteditem.getItemNumber());
                        GettingItemReady.setItemPrice(selecteditem.getItemPrice());
                        GettingItemReady.setItemType((char)selecteditem.getItemType());
                        GettingItemReady.setItemQuantity(quantityNeeded);
                        SelectedCustomer.getShoppingCart().add(GettingItemReady);
                        System.out.println(GREEN+"[DONE] > The item is ["+GettingItemReady.getItemNumber()+" "+GettingItemReady.getItemName()+" ["+GettingItemReady.getItemQuantity()+"]] adding to shopping cart success"+RESET);
                    }
                }
                if(selecteditem.getItemQuantity()<=0 || quantityNeeded<=0){
                    System.out.println(RED+"[ERROR] > invalid Quantity, Please pick another item"+RESET);
                }
                input.nextLine();
                boolean FlagEnd = true;
                while(FlagEnd){
                    System.out.print("Do you want add another item to shopping cart (y/n)? ");
                    selectorpls = input.nextLine().toLowerCase().charAt(0);
                    if(selectorpls == 'y'){
                        Flag = true;
                        FlagEnd = false;
                    }else if(selectorpls == 'n'){
                        Flag = false;
                        FlagEnd = false;
                    } else {
                        System.out.println(RED + "[ERROR] > Invalid input. Please enter 'y' or 'n'." + RESET);
                    }
                }
                if(selectorpls == 'n'){
                    Flag3 = false;
                    break;
                }
            }
            if(selectorpls == 'n'){
                    Flag = false;
                    break;
            }
        }
    }
    public void RemoveShoppingCardItem(){
        System.out.println(YELLOW+"[ Remove Item From Customer Shopping Cart Operation: ]"+RESET);
        boolean Flag = true;
        while(Flag){
            boolean Flag2 = true;
            char selector = 'y';
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
                        System.out.print("Do you want to try again (y/n)?");
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
            System.out.println("The current items in the shopping cart : ");
            for (int i = 0; i < SelectedCustomer.getShoppingCart().size(); i++) {
                System.out.println(">>> "+(i+1)+". "+SelectedCustomer.getShoppingCart().get(i).getItemNumber()+" "+SelectedCustomer.getShoppingCart().get(i).getItemName()+". ["+SelectedCustomer.getShoppingCart().get(i).getItemQuantity()+"]");
            }
            char selectorpls = 'y';
            boolean Flag3 = true;
            while(Flag3){
                System.out.println(YELLOW+"What you want to modify?"+RESET);
                System.out.println(">>> R. Remove item from the shopping cart");
                System.out.println(">>> M. Return to the main menu");
                System.out.print("Enter your choice [R Remove,M main menu] : ");
                selectorpls = input.nextLine().toLowerCase().charAt(0);
                if(selectorpls == 'r'){
                    int option = 0;
                    boolean validInput = false;
                    while (!validInput) {
                        try {
                            System.out.print("Enter your item option number : ");
                            option = input.nextInt() - 1;
                            validInput = true;
                        } catch (InputMismatchException e) {
                            System.out.println(RED+"[ERROR] > A Name in place of a Number!, "+RESET+"Please enter a number.");
                            input.nextLine();
                        }
                    }
                    boolean Validindex = true;
                    while(Validindex){
                        if(option+1 > 0 && option+1 <= SelectedCustomer.getShoppingCart().size()){
                            Validindex = false;
                            break;
                        }else{
                            System.out.println(RED+"[ERROR] > Unknown index! "+RESET+", please try again");
                            boolean validInput2 = false;
                            while (!validInput2) {
                                try {
                                    System.out.print("Enter your choice item : ");
                                    option = input.nextInt() - 1;
                                    validInput2 = true;
                                } catch (InputMismatchException e) {
                                    System.out.println(RED+"[ERROR] > A Name in place of a Number!, "+RESET+"Please enter a number.");
                                    input.nextLine();
                                }
                            }
                        }
                    }
                    Items removedobject = SelectedCustomer.getShoppingCart().get(option);
                    SelectedCustomer.getShoppingCart().remove(option);
                    System.out.println(GREEN+"[DONE] > The item ["+removedobject.getItemNumber()+" "+removedobject.getItemName()+". ["+removedobject.getItemQuantity()+"]] is removed from shopping cart"+RESET);
                    input.nextLine();
                }else if(selectorpls == 'm'){
                    Flag3 = false;
                }
            }
            if(selectorpls == 'm'){
                Flag3 = false;
                Flag = false;
            }
        }
    }
    public void ViewShoppingCartItems(){
        System.out.println(YELLOW+"[ View the items in Customer shopping cart Operation: ]"+RESET);
        boolean Flag = true;
        while(Flag){
            boolean Flag2 = true;
            char selector = 'y';
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
                        System.out.print("Do you want to try again (y/n)?");
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
            System.out.println("The current items in the shopping cart : ");
            System.out.println(YELLOW+"Item no       Item name       Quantity       Unit price       Total price"+RESET);
            double totalprice = 0;
            for (int i = 0; i < SelectedCustomer.getShoppingCart().size(); i++) {
                totalprice += (SelectedCustomer.getShoppingCart().get(i).getItemPrice()*SelectedCustomer.getShoppingCart().get(i).getItemQuantity());
                System.out.println(SelectedCustomer.getShoppingCart().get(i).getItemNumber()+"             "+SelectedCustomer.getShoppingCart().get(i).getItemName()+"             "+SelectedCustomer.getShoppingCart().get(i).getItemQuantity()+"             "+SelectedCustomer.getShoppingCart().get(i).getItemPrice()+"             "+(SelectedCustomer.getShoppingCart().get(i).getItemPrice()*SelectedCustomer.getShoppingCart().get(i).getItemQuantity()));
            }
            DecimalFormat df = new DecimalFormat("#.##");
            String TP = df.format(totalprice);
            System.out.println(YELLOW+"                                                     Total price : "+RESET+TP);
            char selectorplz = 'y';
            boolean Flag3 = true;
            while(Flag3){
                System.out.print("Press(m/M)key to return to the main menu : ");
                selectorplz = input.nextLine().toLowerCase().charAt(0);
                if(selectorplz == 'm' || selectorplz=='M'){
                    Flag = false;
                    Flag3 = false;
                }
            }
            if(selectorplz == 'm' || selectorplz=='M'){
                Flag = false;
                Flag3 = false;
            }
        }
    }
    public void Checkout(){
        System.out.println(YELLOW+"[ Checkout Operation : ]"+RESET);
        boolean Flag = true;
        while(Flag){
            boolean Flag2 = true;
            char selector = 'y';
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
                        System.out.print("Do you want to try again (y/n)?");
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
            System.out.println("The current items in the shopping cart : ");
            System.out.println(YELLOW+"Item no       Item name       Quantity       Unit price       Total price"+RESET);
            double totalprice = 0;
            for (int i = 0; i < SelectedCustomer.getShoppingCart().size(); i++) {
                totalprice += (SelectedCustomer.getShoppingCart().get(i).getItemPrice()*SelectedCustomer.getShoppingCart().get(i).getItemQuantity());
                System.out.println(SelectedCustomer.getShoppingCart().get(i).getItemNumber()+"             "+SelectedCustomer.getShoppingCart().get(i).getItemName()+"             "+SelectedCustomer.getShoppingCart().get(i).getItemQuantity()+"             "+SelectedCustomer.getShoppingCart().get(i).getItemPrice()+"             "+(SelectedCustomer.getShoppingCart().get(i).getItemPrice()*SelectedCustomer.getShoppingCart().get(i).getItemQuantity()));
            }
            DecimalFormat df = new DecimalFormat("#.##");
            String TP = df.format(totalprice);
            System.out.println(YELLOW+"                                                     Total price : "+RESET+TP);
            boolean Flag4 = true;
            boolean enoughQuantity = true;
            while(Flag4){
            for (int i = 0; i < itemsList.size(); i++) {
                for (int j = 0; j < SelectedCustomer.getShoppingCart().size(); j++){
                    if(itemsList.get(i).getItemNumber() == SelectedCustomer.getShoppingCart().get(j).getItemNumber()){
                        if (itemsList.get(i).getItemQuantity() < SelectedCustomer.getShoppingCart().get(j).getItemQuantity()) {
                            System.out.println(RED+"[ERROR] > Error in Checkout: not enough quantity of ["+itemsList.get(i).getItemName()+"]"+RESET);
                            enoughQuantity = false;
                            break;
                        }
                    }
                }
                if (!enoughQuantity) {
                    break;
                }
            }
            if(enoughQuantity == true){
                for (int i = 0; i < itemsList.size(); i++) {
                    for (int j = 0; j < SelectedCustomer.getShoppingCart().size(); j++){
                        if(itemsList.get(i).getItemNumber() == SelectedCustomer.getShoppingCart().get(j).getItemNumber()){
                            itemsList.get(i).setItemQuantity((itemsList.get(i).getItemQuantity() - SelectedCustomer.getShoppingCart().get(j).getItemQuantity()));
                        }
                    }
                }
                for (int i = 0; i < SelectedCustomer.getShoppingCart().size(); i++) {
                    SelectedCustomer.getShoppingCart().remove(i);
                }
                System.out.println(GREEN+"[DONE] > Checkout Done"+RESET);
                
            }
            Flag4 = false;
        }
            char selectorplz = 'y';
            boolean Flag3 = true;
            while(Flag3){
                System.out.print("Press(m/M)key to return to the main menu : ");
                selectorplz = input.nextLine().toLowerCase().charAt(0);
                if(selectorplz == 'm' || selectorplz=='M'){
                    Flag = false;
                    Flag3 = false;
                }
            }
            if(selectorplz == 'm' || selectorplz=='M'){
                Flag = false;
                Flag3 = false;
            }
        }
    }
    public void EmptyCart(){
        System.out.println(YELLOW+"[ Empty Shopping Cart From items: ]"+RESET);
        boolean Flag = true;
        while(Flag){
            boolean Flag2 = true;
            char selector = 'y';
            int SelectedCustomerNo = 0;
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
                        SelectedCustomerNo = i;
                        Flag2 = false;
                        break;
                    }
                }
                input.nextLine();
                if(FlagIN == false){
                    System.out.print(RED+"[ERROR] > The Customer is not exists, "+RESET);
                    boolean FlagEnd = true;
                    while(FlagEnd){
                        System.out.print("Do you want to try again (y/n)?");
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
            boolean FlagEnd = true;
            while(FlagEnd){
                System.out.print(YELLOW+"Do you want to remove all items from your Shopping Cart(y/n)? "+RESET);
                char selcetor2 = input.nextLine().toLowerCase().charAt(0);
                if(selcetor2 == 'y'){
                    for (int i = 0; i < SelectedCustomer.getShoppingCart().size(); i++) {
                        SelectedCustomer.getShoppingCart().remove(i);
                    }
                    Customers.remove(SelectedCustomerNo);
                    System.out.println(GREEN+"[DONE] > Customer & hisItems Removed successfully"+RESET);
                    Flag = false;
                    FlagEnd = false;
                }else if(selcetor2 == 'n'){
                    System.out.println("Back to main menu"); 
                    Flag = false;
                    FlagEnd = false;
                }else {
                    System.out.println(RED + "[ERROR] > Invalid input. Please enter 'y' or 'n'." + RESET);
                }
            }
        }
    }
}
