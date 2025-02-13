/**
 * @author - Thomas Lee
 * This class is interface class for BookCatalog
 */
package assg6_lic20;

public interface BookCatalogInterface {

	/**
	 * this method should have a file name as the parameter. 
	 * The method loads the data containing all the books from a given file.
	 * @param fileName
	 */
	public void loadData(String fileName);
	
	
	/**
	 * this method displays all the books in the catalog.
	 */
	public void displayCatalog();
	
	
	/**
	 * this method should have a title as the parameter.
	 * It should return the Book object if found, or null if not found.
	 * @param title
	 * @return
	 */
	public Book searchForBook(String title);
	
	
	/**
	 * this method is used to add a new Book. 
	 * It should have five parameters that represent the ISBN, title, author, 
	 * publisher, and publishing year. If the title is already in the book catalog, 
	 * then a message should be printed informing the user that the book already exists. 
	 * This method returns a boolean value. If the book is added, it returns true; otherwise it returns false.
	 * @param ISBN
	 * @param title
	 * @param author
	 * @param publisher
	 * @param year
	 */
	public boolean addBook(String ISBN, String title, String author, String publisher, String year);
	
	
	/**
	 * this method is used to update the information of an existing book. 
	 * It should have five parameters that represent the ISBN, title, author, 
	 * publisher, and publishing year. If the title is not currently in the book catalog, 
	 * then a message should be printed informing the user that the book does exist. 
	 * Otherwise update the book information in the catalog. This method returns a boolean value. 
	 * If the book is updated, it returns true; otherwise it returns false.
	 */
	public boolean updateBook(String ISBN, String title, String author, String publisher, String year);
	
	
	
	/**
	 * this method should have a title as the parameter. 
	 * It should remove the Book from the catalog if the title is found. 
	 * Otherwise it should print a message. This method returns a boolean value. 
	 * If the book is removed, it returns true; otherwise it returns false.
	 */
	public boolean removeBook(String title);
	
	
	
	/**
	 * this method should have a publisher as the parameter. 
	 * It should return an ArrayList object with all the books by the given publisher.
	 * If there is no book by the given publisher, the size of the ArrayList will be zero.
	 */
	public <ArrayList> Object getBooksByPublisher(String publisher);
	
	/**
	 * This method is to sort the book by it's title
	 */
	public void sortByTitle();
	
	
	/**
	 * This method is to save back to the file.
	 */
	public void Save();
	
	
	
}
