package LibraryManager;

import java.util.Scanner;

public class Library {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);


        System.out.println(
                "********************Welcome to Spidey's Library!********************");

        System.out.println(
        "Select From The Following Options:");
        System.out.println(
                "**********************************************************************");

        Books ob = new Books();

        Students obStudent = new Students();

        int choice;
        int searchChoice=0;
        do {
            ob.displayMenu();
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    Book b = new Book();
                    ob.addBook(b);
                    break;

                case 2:
                    ob.upgradeBookQty();
                    break;

                case 3:
                    System.out.println("Press 1 to search with Book Serial No.");
                    System.out.println("Press 2 to search with Book's Author Name.");
                    searchChoice = input.nextInt(); // take input here
                    switch (searchChoice) {
                        case 1:
                            ob.searchBySno();
                            break;
                        case 2:
                            ob.searchByAuthorName();
                            break;
                        default:
                            System.out.println("Invalid search choice.");
                    }
                    break;


                case 4:
                    ob.showAllBooks();
                    break;
                case 5:
                    Student s = new Student();
                    obStudent.addStudent(s);
                    break;

                case 6:
                    obStudent.showAllStudents();
                    break;
                case 7:
                    obStudent.checkOutBook(ob);
                    break;

                case 8:
                    obStudent.checkInBook(ob);
                    break;
                default:
                    System.out.println("Enter Between 0 to 8");
            }

        }
          while(choice != 0);
    }
}
