# **Simple Library Catalog**
## Author: Thomas Lee
Simple Library Catalog is a straightforward Java-based application for managing a collection of books. It provides features to display, search, add, update, sort, and remove books, and it can also load and save the book catalog to a file. 

## Project Overview
This Java-based Simple Library Catalog is organized into four core classes:
1. **Book** :
   - Represents an individual book, holding its ISBN, title, author, publisher, and publication year.
   - Implements "Comparable Book" to allow alphabetical sorting by title.
     
2. **BookCatalog** :
   - Implements BookCatalogInterface to manage a collection (ArrayList) of Book objects.
   - Provides methods to load books from a file, display them, search by title, add new entries, update existing ones, remove books, sort them, and save changes back to a file.
     
3. **BookCatalogInterface** :
   - Defines the blueprint for BookCatalog functionality, including loading, displaying, searching, adding, updating, and removing books, as well as sorting and saving to a file.    

4. **LibraryApplication** :
   - The main class that presents a console-based menu.
   - Allows users to choose various options to interact with the BookCatalog, such as displaying all books, searching, adding, updating, removing, sorting, and saving the catalog.
   - Demonstrates basic testing of the Book class methods (getters, setters, equals, compareTo, etc.) before launching the menu.     

   
## Key Features
### 1. Load & Save
   - Load a list of books from a data file and save any changes (e.g., new additions or updates) back to a file.
  
### 2. Search
   - Search for books by title or publisher.

### 3. Catalog Management
   - Add new books, update existing information, or remove books from the catalog.

### 4. Sorting
   - Sort books by title (alphabetically).

### 5. Conso;e-Based Menu
   - A simple interactive menu allows users to select actions by entering numerically.

## Getting Started

### Prerequisites
- Java Development (JDK) 8 or later

### Installation & Running
1. Clone or Download this project's files into your local machine.
2. Compile the .jsva files. In your terminal or command prompt, navigate to the folder containing the source files and run:
   ```
   javac *.java
   ```
3. Run the main application:
   ```
   Java LibraryApplication
   ```
4. Usage
   - Upon launching, the application will prompt you with a menu of options (1-9)
   - Enter the corresponding number to execute a command. For example, to display all books, type 1 and press Enter.   

## File Structure

├── Book.java

├── BookCatalog.java

├── BookCatalogInterface.java

└── LibraryApplication.java
- **Booke.java**
   - Contains the Book class for modeling the data and behaviors of a single book.
- **BookCatalog.java**
   - Manages a collection of Book objects, handling operations like loading from files, adding, removing, and saving.
- ** BookCatalogInterface.java**
   - An interface that outlines the methods for any book catalog implementation.
- **LibraryApplication.java**
   - Entry point (main method). Runs an interactive console menu and orchestrates all the operations on the BookCatalog.  

## How to Works
1. **Initialization**
   - LibraryApplication creates an instance of BookCatalog and loads book data from a file (default named assg6_catalog.txt).
     
2. **Menu Options**
   - 1 – Display all books.
   - 2 – Search for a book by title.
   - 3 – Add a new book (you’ll be prompted for ISBN, title, author, publisher, and year).
   - 4 – Update existing book data.
   - 5 – Remove a book by title.
   - 6 – Display books by publisher.
   - 7 – Sort all books by title (alphabetically).
   - 8 – Save any changes to assg6_catalog.txt.
   - 9 – Exit the application.
     
3. **Data Persistence**
   - Changes made are kept in memory until you choose option 8 to save. Once saved, the updated data is written to the output file (assg6_catalog.txt by default).      

## License
This project is open-source and free to use.

