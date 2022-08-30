package libraryApp;
import java.util.ArrayList;

public class BookRepository {
	
	private ArrayList<Book> books = new ArrayList<>();
	private int booksFound = 0;
	
	//Constructor to initialize books
	public BookRepository(){
		books.add(new Book(25390,"Pride and Prejudice C", "Jane Austen", "Love",10,7));
		books.add(new Book(39520,"Programming in ANSI C", "E. Balagurusamy", "Educational",15,10));
		books.add(new Book(75332,"Shrimad Bhagavad Gita", "Krishna Dvaipayana", "Motivational",20,18));
		books.add(new Book(93514,"Java: The Complete Reference", "Herbert Schildt", "Educational",12,9));
		books.add(new Book(45990,"It", "Stephan King", "Horror",7,5));
	}
	
	
	//Searching books by Title Keyword
	public void searchByTitle(String title) {
		booksFound = 0;
		for(Book book : books) {
			String bookTitle = book.getTitle();
			if(bookTitle.toLowerCase().contains(title.toLowerCase())) {
				bookDetails(book);
				booksFound++;
			}
		}
		System.out.printf("\n%d Book%s Found.\n",booksFound,booksFound>1?"s":"");
		return;
	}
	

	//Searching books by ISBN Number
	public void searchByISBN(int isbn) {
		booksFound = 0;
		for(Book book : books) {
			if(book.getIsbn()==isbn) {
				bookDetails(book);
				booksFound++;
				break;
			}
				
		}
		System.out.printf("\n%d Book%s Found.\n",booksFound,booksFound>1?"s":"");
		return;
	}
	
	
	//Searching books by Genre
	public boolean searchByGenre(String genre){
		booksFound = 0;
		for(Book book : books) {
			String bookGenre = book.getGenre();
			if(bookGenre.toLowerCase().equals(genre.toLowerCase())) {
				bookDetails(book);
				booksFound++;
			}
		}
		System.out.printf("\n%d Book%s Found.\n",booksFound,booksFound>1?"s":"");
		if(booksFound>0)
			return true;
		else 
			return false;
			
	}
	
	
	// Display Book Details
	public void bookDetails(Book book) {
		System.out.println("\n+> Book details: \n");
		System.out.println("\tTitle: "+book.getTitle()+"\n\tAuthor: "+ book.getAuthor()+"\n\tGenre: "+book.getGenre()+"\n\tISBN: "+book.getIsbn()+"\n\tQuantity: "+book.getQuantity()+"\n\tChecked Out: "+String.valueOf(book.getCheckedOut())+"\n\tAvailable: "+String.valueOf(book.getQuantity()-book.getCheckedOut()));
	}
	
	
	//Searching for ISBN number for checkIn and checkOut
	public int searchISBN(int isbn) {
		for(Book book:books)
			if(book.getIsbn()==isbn)
				return 1;
		return 0;
	}
	
	
	//withdrawing book
	public boolean getBook(int isbn) {
		for(Book book: books) {
			if(book.getIsbn()==isbn) {
				if((book.getQuantity()-book.getCheckedOut())>0) {
					book.setCheckedOut(book.getCheckedOut()+1);
					return true;
				}
			}
		}
		return false;
	}
	
	
	//submitting book
	public boolean submitBook(int isbn) {
		for(Book book: books) {
			if(book.getQuantity()>book.getCheckedIn()) {
				book.setCheckedOut(book.getCheckedOut()-1);
				return true;
			}
		}
		return false;
	}
	
	
	//Showing status of book
	public void bookStatus(int isbn) {
		for(Book book: books) {
			if(book.getIsbn()==isbn) {
				bookDetails(book);
				break;
			}
		}
	}
	
}
