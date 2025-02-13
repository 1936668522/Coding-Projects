/**
 * This BookCatalog book is implements BookCatalogInterface
 * to manipulate the book and book catalog
 */
package assg6_lic20;

import java.util.*;
import java.io.*;

public class BookCatalog implements BookCatalogInterface{
	
	static Scanner kbd = new Scanner(System.in); //For later ask user to enter the info.
	
	//Making a arraylist for later use.
	private ArrayList<Book> bookList;

	/**
	 * constructor that will initialize the book List
	 */
	public BookCatalog()
	{
		bookList = new ArrayList<Book>();
	}	

	/**
	 * This is loadData that can read file and put it into bookList.
	 */
	@Override
	public void loadData(String fileName) 
	{
		String ISBN = null, title = null, author = null, publisher = null, year = null;
		
		Scanner inputStream = null;
		Book newBook = null;		
		try
		{
			inputStream = new Scanner(new File(fileName));
			
			while(inputStream.hasNextLine())
			{			
				ISBN = inputStream.nextLine();
		
				if(inputStream.hasNextLine())
				{				       
					title = inputStream.nextLine();
				}		
					
				if(inputStream.hasNextLine())
				{
			        author = inputStream.nextLine();
				}		
					
				if(inputStream.hasNextLine())
				{
			        publisher = inputStream.nextLine();
				}		
			
				if(inputStream.hasNextLine())	
				{
			        year = inputStream.nextLine();
				}	
				
				if(inputStream.hasNextLine())
				{
					inputStream.nextLine();
				}
				
					
					newBook = new Book(ISBN, title, author, publisher, year);
					bookList.add(newBook);
			}
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Sorry we couldn't find the file");
			System.exit(1);
		}
		finally 
		{
			if(inputStream != null)
			{
				inputStream.close();
			}
		}
		
	}

	/**
	 * This is displayCatalog method that will display the books on the screen
	 */
	@Override
	public void displayCatalog() 
	{
		Iterator<Book> iter;
		
		iter = bookList.iterator();
		System.out.println("The Books are: \n");
		while(iter.hasNext())
		{
			System.out.println(iter.next());
		}
	}

	/**
	 * This is searchForBook by title method
	 * allows to search the book by their title
	 */
	@Override
	public Book searchForBook(String title) 
	{
		System.out.println("Please enter the title of the book");
		title = kbd.nextLine();
		
		for(Book book: bookList) // for loop for bookList
		{
			if(book.getTitle().equals(title))
			{
				System.out.println(book.toString());//print out the book information if found.
				return book;
			}
		}
		return null;
	}

	/**
	 * This is addBook method that allows user to add the new book.
	 */
	@Override
	public boolean addBook(String ISBN, String title, String author, String publisher, String year) {
		System.out.println("Please enter the information of the book");
		
		//ask user to enter the information
		System.out.println("ISBN: ");
		ISBN = kbd.nextLine();
		
		System.out.println("Title: ");
		title = kbd.nextLine();
		
		System.out.println("Author: ");
		author = kbd.nextLine();

		System.out.println("Publisher: ");
		publisher = kbd.nextLine();

		System.out.println("Publishing year: ");
		year = kbd.nextLine();
		
		Book newbook = new Book (ISBN, title, author, publisher, year);
		
		//to check if the book is already exist.
		for(Book book : bookList)
		{
			if(book.getTitle().equals(newbook.getTitle()) 
					&& book.getAuthor().equals(newbook.getAuthor())
					&& book.getISBN().equals(newbook.getISBN())
					&& book.getPublisher().equals(newbook.getPublisher())
					&& book.getYear().equals(newbook.getYear()))
			{
				System.out.println("Sorry the book is already exists in the system");
				return false;
			}
		}
		
		bookList.add(newbook);
		
		return true;
	}

	/**
	 * This is updateBook that allows user to update existed book in the catalog.
	 */
	@Override
	public boolean updateBook(String ISBN, String title, String author, String publisher, String year) 
	{
		//updateBook variable that will be used to update.
		Book updateBook = null;
		
		System.out.println("Please enter the title of the book that you want to update: ");
		title = kbd.nextLine();
		
		for(Book book: bookList)
		{
			if(title.equals(book.getTitle()))
			{
				//let updateBook = book so we can use it outside of for loop.
				updateBook = book;
				break;
			}
		}
		
			if(updateBook == null)
			{
				System.out.println("Sorry the book you want to update is not in our system, please try again.");
				return false;
			}
		
		//update the new informations of book other than title by using setMethod.
		System.out.println("Please update new information of the book other than title");
		System.out.print("ISBN: ");
		ISBN = kbd.nextLine();
		updateBook.setISBN(ISBN);
		
		System.out.println(title);
		
		System.out.print("Author: ");
		author = kbd.nextLine();
		updateBook.setAuthor(author);
		
		System.out.print("Publisher: ");
		publisher = kbd.nextLine();
		updateBook.setPublisher(publisher);
		
		System.out.print("Publishing year: ");
		year = kbd.nextLine();
		updateBook.setYear(year);

		return true;
	}

	/**
	 * This is removeBook method that will allows user to remove existed book.
	 */
	@Override
	public boolean removeBook(String title) 
	{
		System.out.println("Please enter the title of the book that you want to remove: ");
		title = kbd.nextLine();
		
		Book removeBook = null;
		
		for(Book book: bookList)
		{
			if(book.getTitle().equals(title))
			{
				//to search the book if it is in the system.
				removeBook = book;
				break;
			}
		}
		
		//if the book is not in the system, print the message.
		if(removeBook == null)
		{
			System.out.println("Sorry the book you want to remove is not in our system, please try again.");
			return false;
		}
		
		bookList.remove(removeBook);
		return true;
	}

	/**
	 * This is getBookByPublisher method that 
	 * allows users to search books by publisher.
	 */
	@Override
	public ArrayList <Object> getBooksByPublisher(String publisher) 
	{
		ArrayList<Object> books = new ArrayList<>();
		
		System.out.println("Please enter the publisher of the book that you want to search: ");
		publisher = kbd.nextLine();
		
		for(Book book: bookList)
		{
			if(book.getPublisher().equals(publisher))
			{
				//if the book is found, print out all the books by given publisher.
				 System.out.println(book.toString() + "\n");
				 books.add(book);
			}
		}
		return books;
	}

	/**
	 * This is sortByTitle method that will sort books by alphabet of the titles
	 */
	@Override
	public void sortByTitle() 
	{
		Collections.sort(bookList);
	}

	/**
	 * This is Save method that will save all the information of the books after changed.
	 */
	@Override
	public void Save() 
	{
		PrintWriter output = null;
		try
		{
			output = new PrintWriter("assg6_catalog.txt");
		}
		catch(IOException e)
		{
			System.out.print("Fail to write to the output file!");
			System.exit(1);
		}
		
		for(Book book: bookList)
		{
			output.println(book.toString());
		}
		output.close();
		
	}

}

