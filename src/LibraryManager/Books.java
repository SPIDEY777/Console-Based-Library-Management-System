package LibraryManager;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Books {

 ArrayList<Book> theBooks = new ArrayList<>();
 public static int count;

 Scanner input = new Scanner(System.in);

 public int compareBookObjects(Book b1 , Book b2){
     if(b1.bookName.equalsIgnoreCase(b2.bookName)){
         System.out.println("Book with this Name Already Exists");
         return 0;
     }
     if(b1.Sno == b2.Sno){
         System.out.println("Book with this Serial Number already Exists.");
         return 0;
     }
     return 1;
 }


 public void addBook(Book b){
     for(int i = 0;i< count; i++){

         if(this.compareBookObjects(b,this.theBooks.get(i))==0){
             return;
         }
         theBooks.add(b);
         count++;


     }
 }
    public void searchBySno()
    {

        // Display message
        System.out.println(
                "\t\t\t\tSEARCH BY SERIAL NUMBER\n");

        // Class data members
        int sNo;
        System.out.println("Enter Serial No of Book:");
        sNo = input.nextInt();

        int flag = 0;
        System.out.println(
                "S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");

        for (int i = 0; i < count; i++) {
            if (sNo == theBooks.get(i).Sno) {
                System.out.println(
                        theBooks.get(i).Sno + "\t\t"
                                + theBooks.get(i).bookName + "\t\t"
                                + theBooks.get(i).authorName + "\t\t"
                                + theBooks.get(i).bookQtyCopy + "\t\t"
                                + theBooks.get(i).bookQty);
                flag++;
                return;
            }
        }
        if (flag == 0)
            System.out.println("No Book for Serial No "
                    + sNo + " Found.");
    }

    public void searchByAuthorName()
    {

        // Display message
        System.out.println(
                "\t\t\t\tSEARCH BY AUTHOR'S NAME");

        input.nextLine();

        System.out.println("Enter Author Name:");
        String authorName = input.nextLine();

        int flag = 0;

        System.out.println(
                "S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");

        for (int i = 0; i < count; i++) {

            // if author matches any of its book
            if (authorName.equalsIgnoreCase(
                    theBooks.get(i).authorName)) {

                // Print below corresponding credentials
                System.out.println(
                        theBooks.get(i).Sno + "\t\t"
                                + theBooks.get(i).bookName + "\t\t"
                                + theBooks.get(i).authorName + "\t\t"
                                + theBooks.get(i).bookQtyCopy + "\t\t"
                                + theBooks.get(i).bookQty);
                flag++;
            }
        }

        // Else no book matches for author
        if (flag == 0)
            System.out.println("No Books of " + authorName
                    + " Found.");
    }

    public void showAllBooks()
    {

        System.out.println("\t\t\t\tSHOWING ALL BOOKS\n");
        System.out.println(
                "S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");

        for (int i = 0; i < count; i++) {

            System.out.println(
                    theBooks.get(i).Sno + "\t\t"
                            + theBooks.get(i).bookName + "\t\t"
                            + theBooks.get(i).authorName + "\t\t"
                            + theBooks.get(i).bookQtyCopy + "\t\t"
                            + theBooks.get(i).bookQty);
        }
    }

    public void upgradeBookQty()
    {

        System.out.println(
                "\t\t\t\tUPGRADE QUANTITY OF A BOOK\n");
        System.out.println("Enter Serial No of Book");

        int sNo = input.nextInt();

        for (int i = 0; i < count; i++) {

            if (sNo == theBooks.get(i).Sno) {

                // Display message
                System.out.println(
                        "Enter No of Books to be Added:");

                int addingQty = input.nextInt();
                theBooks.get(i).bookQty += addingQty;
                theBooks.get(i).bookQtyCopy += addingQty;

                return;
            }
        }
    }

    public void dispMenu()
    {

        // Displaying menu
        System.out.println(
                "----------------------------------------------------------------------------------------------------------");
        System.out.println("Press 1 to Add new Book.");
        System.out.println("Press 0 to Exit Application.");
        System.out.println(
                "Press 2 to Upgrade Quantity of a Book.");
        System.out.println("Press 3 to Search a Book.");
        System.out.println("Press 4 to Show All Books.");
        System.out.println("Press 5 to Register Student.");
        System.out.println(
                "Press 6 to Show All Registered Students.");
        System.out.println("Press 7 to Check Out Book. ");
        System.out.println("Press 8 to Check In Book");
        System.out.println(
                "-------------------------------------------------------------------------------------------------------");
    }

    public int isAvailable(int sNo)
    {

        for (int i = 0; i < count; i++) {
            if (sNo == theBooks.get(i).Sno) {
                if (theBooks.get(i).bookQtyCopy > 0) {

                    System.out.println(
                            "Book is Available.");
                    return i;
                }
                System.out.println("Book is Unavailable");
                return -1;
            }
        }

        System.out.println("No Book of Serial Number "
                + " Available in Library.");
        return -1;
    }

    public Book checkOutBook()
    {

        System.out.println(
                "Enter Serial No of Book to be Checked Out.");
        int sNo = input.nextInt();

        int bookIndex = isAvailable(sNo);

        if (bookIndex != -1) {
            theBooks.get(bookIndex).bookQtyCopy--;
            return theBooks.get(bookIndex);
        }
        return null;
    }


    public void checkInBook(Book b)
    {
        for (int i = 0; i < count; i++) {
            if (b.equals(theBooks.get(i))) {
                theBooks.get(i).bookQtyCopy++;
                return;
            }
        }
    }


}
