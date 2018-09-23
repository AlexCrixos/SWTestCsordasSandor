package hu.uni.miskolc.iit.swtest.book.dao.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;

import hu.uni.miskolc.iit.swtest.book.core.subject.Book;
import hu.uni.miskolc.iit.swtest.book.core.subject.BookType;
import hu.uni.miskolc.iit.swtest.book.core.subject.InvalidPublicationYearException;
import hu.uni.miskolc.iit.swtest.book.core.subject.Genre;
import hu.uni.miskolc.iit.swtest.book.dao.BookDAO;
import hu.uni.miskolc.iit.swtest.book.dao.exception.DuplicatedBookEntryException;
import hu.uni.miskolc.iit.swtest.book.dao.exception.EntryNotFoundExpcetion;

public class BookFileDAO implements BookDAO {

	private File database;

	private static final String FIELD_SEPARATOR = ";";
	
	
	public BookFileDAO(String databasePath) {
		super();
		this.database = new File(databasePath);
	}

	public BookFileDAO(File database) {
		super();
		this.database = database;
	}

	public void createBook(Book book) throws DuplicatedBookEntryException {
		Collection<Book> books = readBooks();
		if(books.contains(book)) {
			throw new DuplicatedBookEntryException(book.toString());
		}
		books.add(book);
		overrideDatabase(books);
	}

	public Collection<Book> readBooks() {
		Collection<Book> result = new ArrayList<Book>();
		String line = null;
		try {
		BufferedReader br = new BufferedReader(new FileReader(database));
		while((line = br.readLine()) != null) {
			String[] fields = line.split(FIELD_SEPARATOR);
			if(fields.length!= 5) {
				continue;
			}
			Genre genre = Genre.valueOf(fields[0]);
			BookType subject = BookType.valueOf(fields[1]);
			String publisher = fields[2];
			int publicationYear = Integer.parseInt(fields[3]);
			int pageNumber = Integer.parseInt(fields[4]);;
			result.add(new Book(subject, publisher, publicationYear, pageNumber));
		}
		}
		catch(IOException e) {
			System.out.println(e);
		} catch (InvalidPublicationYearException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public void updateBook(Book book) throws EntryNotFoundExpcetion {
		// TODO Auto-generated method stub

	}

	public void deleteBook(Book book) throws EntryNotFoundExpcetion {
		Collection<Book> books = readBooks();
		if(books.contains(book) == false) {
			throw new EntryNotFoundExpcetion(book.toString());
		}
		books.remove(book);
		overrideDatabase(books);
	}
	
	private String marshal2record(Book book) {
		return ""+
				book.getGenre().toString()+FIELD_SEPARATOR+
				book.getSubject().toString()+FIELD_SEPARATOR+
				book.getPublisher()+FIELD_SEPARATOR+
				book.getPublicationYear()+FIELD_SEPARATOR+
				book.getPageNumber()+FIELD_SEPARATOR;
	}
	
	private void overrideDatabase(Collection<Book> books) {
		PrintWriter writer;
		try {
			writer = new PrintWriter(new FileWriter(database, false));
			for(Book book : books) {
				writer.println(marshal2record(book)+"\n");
			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
