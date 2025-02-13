/**
 * @author - Thomas Lee
 * This is main class that will show menu
 * and also allow users to choose the options
 */
package assg6_lic20;

import java.util.*;

public class LibraryApplication {

	public static void main(String[] args) 
	{
		//variables that will be used later.
				String ISBN = null;
				String title = null;
				String author = null;
				String publisher = null;
				String year = null;
				
		Scanner kbd = new Scanner(System.in);
		
		Book book1, book2, book3, book4;
		book1 = new Book("12345678", "The way of Love", "Jackson D. Mike", "UNCC", "2018");
		book2 = new Book("12345678", "The way of Love", "Jackson D. Mike", "UNCC", "2018");
		book3 = new Book("53462345", "Darkness", "Thomas Johson", "NCW","2022");
		book4 = new Book("31424234", "X-man", "Auther Kye", "Marvel", "2013");
		//to test if getISBN works
		System.out.println(book1.getISBN());
		
		//to test if getTitle works
		System.out.println(book1.getTitle());
		
		//To test if getAuthor works
		System.out.println(book1.getAuthor());
		
		//To test if getPublisher works
		System.out.println(book1.getPublisher());
		
		//To test if getYear works
		System.out.println(book1.getYear());
		
		// to test if setMethod works properly
		book3.setAuthor("Jackson Joe");
		book3.setISBN("123334323");
		book3.setPublisher("UNCW");
		book3.setYear("2020");
		
		//to test if toString method works properly.
		System.out.println("\n" + book3.toString());
		
		//to test if equals method works properly
		System.out.println(book1.equals(book2));
		System.out.println(book1.equals(book3));
		
		//To test if compareTo method works properly.
		System.out.println("\n" + book1.compareTo(book3));
		System.out.println(book1.compareTo(book2));
		System.out.println(book1.compareTo(book4)+ "\n");
		
		int choice; //Allow user to choose the options
		
		//making a Obj for BookCatalog Type
		BookCatalog catalog = new BookCatalog();
		
		//make a variable of fileName
		String fileName = "assg6_catalog.txt";
		
		//call loadData method and displayCatalog method.
		catalog.loadData(fileName);
		

		
		while(true)
		{
			//print out the menu
			System.out.println("Please choose the options below then press \"Enter\" key: ");
			System.out.println("1. Display all the books in the catalog");
			System.out.println("2. Search for a book");
			System.out.println("3. Add a new book");
			System.out.println("4. Update an existing book");
			System.out.println("5. Remove a book");
			System.out.println("6. Display book by a publisher");
			System.out.println("7. Sort all the books based on title");
			System.out.println("8. Save data");
			System.out.println("9. Exit");
			
			choice = kbd.nextInt();
			

			//If user enter 9, it will exit the system.
			if(choice == 9 )
			{
				System.out.println("You're exited from the system.");
				System.exit(1);
				break;
			}
			
			switch(choice)
			{
			case 1:
				//if user enter 1 then call displayCatalog method
				catalog.displayCatalog();
				break;
			case 2:
				//If user enter 2 then call searchForBook method
				catalog.searchForBook(title);
				break;
			case 3:
				//If user enter 3 then call addBook method
				catalog.addBook(ISBN, title, author, publisher, year);
				break;
			case 4:
				//If user enter 4 then call updateBook method
				catalog.updateBook(ISBN, title, author, publisher, year);
				break;
			case 5:
				//If user enter 5 then call removeBook method
				catalog.removeBook(title);
				break;
			case 6: 
				//If user enter 6 then call getBooksByPublisher method
				catalog.getBooksByPublisher(publisher);
				break;
			case 7:
				//If user enter 7 then call sortByTitle method
				catalog.sortByTitle();
				break;
			case 8:
				//If user enter 8 then call Save method.
				catalog.Save();
				break;
			}
		}
		kbd.close();
	}

}