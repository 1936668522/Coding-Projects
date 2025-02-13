/**
 * @author - Thomas Lee
 * This class is to containing all of the information and methods for one book
 */
package assg6_lic20;


public class Book implements Comparable<Book>{
	
	//variables that will be used later
	private String ISBN, title, author, publisher, year;

	/**
	 * this is the constructor with 5 parameters that are informations of book
	 * @param ISBN of book
	 * @param title of book
	 * @param author of book
	 * @param publisher of book
	 * @param year of book
	 */
	public Book(String ISBN, String title, String author, String publisher, String year)
	{
		this.ISBN = ISBN;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.year = year;
	}
	
	/**
	 * This is get ISBN method to receive ISBN
	 * @return ISBN
	 */
	public String getISBN()
	{
		return ISBN;
	}
	
	/**
	 * This is get title method to receive title
	 * @return title
	 */
	public String getTitle()
	{
		return title;
	}
	
	/**
	 * this is get author method to receive author
	 * @return author
	 */
	public String getAuthor()
	{
		return author;
	}
	
	/**
	 * this is get publisher method to receive publisher
	 * @return publisher
	 */
	public String getPublisher()
	{
		return publisher;
	}
	
	/**
	 * this is get year method to receive publishing year
	 * @return year
	 */
	public String getYear()
	{
		return year;
	}
	
	
	/**
	 * This is set ISBN method to set a new ISBN
	 * @param newISBN
	 */
	public void setISBN(String newISBN)
	{
		this.ISBN = newISBN;
	}
	
	/**
	 * This is set author method to set a new author
	 * @param newAuthor
	 */
	public void setAuthor(String newAuthor )
	{
		this.author = newAuthor;
	}
	
	/**
	 * This is set publisher method to set a new publisher
	 * @param newPublisher
	 */
	public void setPublisher(String newPublisher)
	{
		this.publisher = newPublisher;
	}
	
	/**
	 * This is set publishing year method to set a new publishing year.
	 * @param newYear
	 */
	public void setYear(String newYear)
	{
		this.year = newYear;
	}
	
	/**
	 * This is toString method to print the information on screen
	 */
	public String toString()
	{
		return ISBN + "\n" + title + "\n" + author + "\n" + publisher + "\n" + year + "\n";
	}
	
	/**
	 * This is equals method to see if two books has same title.
	 */
	public boolean equals(Object obj)
	{
		if(obj == null)
		{
			return false;
		}
		if (obj instanceof Book) 
		{
			Book book = (Book)obj;
			if(this.title == book.getTitle())
			{
				return true;
			}
			else
			{
				return false;
			}
			
		}
		else 
			return false;
	}

	/**
	 * This is compareTo method that will compare the title by alphabet order.
	 */
	@Override
	public int compareTo(Book obj) 
	{
		return this.title.compareTo(obj.getTitle());
	}
}
