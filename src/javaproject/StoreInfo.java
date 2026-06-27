
package javaproject;

public abstract class StoreInfo {
    
    public static void AddItemDescription (){
        System.out.println("""
                           The AddItem function is a method that allows users to add new items to an inventory system.
                           The function guides the user through a series of input prompts to gather information about the item being added,
                           including the item number, name, quantity, price, and type.
                           If the item is a book, additional information such as the book title and author are also collected.
                           The function validates the user input to ensure that the entered data is of the expected format,
                           and displays error messages and prompts for correction if any invalid input is detected.
                           After all the necessary information has been collected, a new item object is created and added to a list of existing items.
                           The function also provides an option for the user to add additional items or to end the item addition process.""");
    }
    public static void AddCustomerDescription (){
        System.out.println("""
                           The AddCustomer function is used to add a new customer to the system. 
                           It first prompts the user to enter a unique customer number and checks if it is already taken by another customer. 
                           If the number is unique, the function asks for the customer's name and creates a new customer object with an empty shopping cart. 
                           The new customer is added to the list of customers in the system. The function then prompts the user to add another customer or exit.""");
    }
    public static void AddShoppingCardItemDescription (){
        System.out.println("""
                           The AddShoppingCardItem function is designed to add items to a customer's shopping cart. 
                           The function first prompts the user to enter a customer number, 
                           and then it displays a list of available items along with their details. 
                           The user can then select an item and specify the quantity needed. If the requested quantity is available, 
                           the item is added to the customer's shopping cart. 
                           Otherwise, an error message is displayed, and the user is prompted to try again.
                           The function uses a while loop to repeatedly prompt the user for input until a valid input is entered. 
                           It also uses boolean flags to control the flow of the loop. The function also catches InputMismatchExceptions 
                           to ensure that the user inputs a number when prompted to do so. Finally, 
                           the function outputs messages in different colors to distinguish them from other output messages.""");
    }
    public static void RemoveShoppingCardItemDescription (){
        System.out.println("""
                           The function RemoveShoppingCardItem() is a method that allows a user to remove an item from a customer's shopping cart.
                           The function first prompts the user to enter the customer number whose shopping cart they wish to modify. 
                           It then displays a list of items in the customer's shopping cart and prompts the user to choose which item they want to remove. 
                           If the user selects an item to remove, the function removes the item from the shopping cart and displays a confirmation message. 
                           If the user decides not to remove an item, they are given the option to return to the main menu. 
                           This process continues until the user chooses to exit the function.""");
    }
    public static void ViewShoppingCartItemsDescription (){
        System.out.println("""
                           The function ViewShoppingCartItems() allows the user to view the items in a customer's shopping cart.
                           First, the function prompts the user to enter the customer number. 
                           If the customer number exists in the system, 
                           the function displays the customer's name and the list of items in their shopping cart. 
                           For each item in the shopping cart, the function displays the item number, name, quantity, unit price, and total price.
                           After displaying the customer's shopping cart, 
                           the function prompts the user to press the 'm' key to return to the main menu. 
                           If the user presses 'm', the function exits and returns control to the main program. 
                           Overall, this function provides a user-friendly interface for the user to view the shopping cart of any customer in the system.""");
    }
    public static void CheckoutDescription (){
        System.out.println("""
                           The Checkout function begins by prompting the user to enter a customer number, 
                           and then checks if the entered customer number exists in the customer list. 
                           If the customer number is invalid, the program asks the user if they want to try again or not. 
                           Once a valid customer number is entered, the program displays the customer's name, 
                           along with the items in their shopping cart and their prices. 
                           The program then checks if there is enough stock of each item in the cart, and if there is, 
                           the program updates the inventory by reducing the quantity of each item in the cart. Finally, 
                           the program clears the customer's shopping cart and asks the user if they want to return to the main menu.""");
    }
    public static void EmptyCartDescription (){
        System.out.println("""
                           The function EmptyCart provides the user with the ability to remove all items from a selected customer's shopping cart. 
                           It takes input from the user in the form of the customer number and validates it against the existing customer list. 
                           If the entered customer number is valid, the program prompts the user to confirm the removal of all items from the customer's shopping cart. 
                           If confirmed, the program removes all items from the shopping cart and removes the customer and their cart from the system. 
                           If the user decides not to remove the items, the program returns to the main menu.""");
    }
    public static void ModifyCustomerDataDescription (){
        System.out.println("""
                           The ModifyCustomerData function allows the user to modify customer data.
                           It starts by prompting the user to enter a customer number. 
                           If the customer number exists in the system, 
                           the function will display the customer's current number and name and then prompt the user to enter a new customer number and name. 
                           The function will ensure that the new customer number is not already assigned to another customer. 
                           If it is, an error message will be displayed, and the user will be prompted to enter a new number. 
                           Once a unique number is entered, the function will update the customer's data and print a success message. 
                           The function will then prompt the user to modify another customer or return to the main menu. 
                           If the user chooses to modify another customer, the process repeats. 
                           If the user chooses to return to the main menu, the function terminates.""");
    }
}
