
package javaproject;

public class books extends Items {
    private String bookTitle;
    private String bookAuthor;
    
    public books(int itemNumber, String itemName, int itemQuantity, double itemPrice, char itemType, String bookTitle, String bookAuthor){
        super(itemNumber, itemName, itemQuantity, itemPrice, itemType);
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
    }
    public books(){}
    public String getBookTitle() {
        return bookTitle;
    }
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }
    public String getBookAuthor() {
        return bookAuthor;
    }
    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }
}
