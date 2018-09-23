package hu.uni.miskolc.iit.swtest.book.dao;

import java.util.Collection;

import hu.uni.miskolc.iit.swtest.book.core.subject.Book;
import hu.uni.miskolc.iit.swtest.book.dao.exception.DuplicatedBookEntryException;
import hu.uni.miskolc.iit.swtest.book.dao.exception.EntryNotFoundExpcetion;

/**
 * Data Access Object 
 * CREATE
 * READ
 * UPDATE
 * DELETE
 */
public interface BookDAO {

	void createBook(Book book) throws DuplicatedBookEntryException;
	
	Collection<Book> readBooks();
	
	void updateBook(Book book) throws EntryNotFoundExpcetion;
	void deleteBook(Book book) throws EntryNotFoundExpcetion;
	
}
