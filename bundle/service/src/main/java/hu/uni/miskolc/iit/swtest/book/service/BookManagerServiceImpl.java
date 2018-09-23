package hu.uni.miskolc.iit.swtest.book.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import hu.uni.miskolc.iit.swtest.book.core.subject.Book;
import hu.uni.miskolc.iit.swtest.book.core.subject.Genre;
import hu.uni.miskolc.iit.swtest.book.core.service.BookDoesNotExisitsException;
import hu.uni.miskolc.iit.swtest.book.core.service.BookManagerService;
import hu.uni.miskolc.iit.swtest.book.core.service.exceptions.BookAlreadyExistsException;
import hu.uni.miskolc.iit.swtest.book.dao.BookDAO;
import hu.uni.miskolc.iit.swtest.book.dao.exception.DuplicatedBookEntryException;
import hu.uni.miskolc.iit.swtest.book.dao.exception.EntryNotFoundExpcetion;

public class BookManagerServiceImpl implements BookManagerService {
	
	private BookDAO bookDAO;

	public BookManagerServiceImpl(BookDAO bookDAO) {
		super();
		this.bookDAO = bookDAO;
	}

	public void recordBook(Book book) throws BookAlreadyExistsException {
		try {
			bookDAO.createBook(book);
		} catch (DuplicatedBookEntryException e) {
			throw new BookAlreadyExistsException(e);
		}
	}

	public void updateBook(Book book) throws BookDoesNotExisitsException {
		try {
			bookDAO.updateBook(book);
		} catch (EntryNotFoundExpcetion e) {
			throw new BookDoesNotExisitsException(e);
		}
	}

	public Collection<Book> listBooks() {
		return bookDAO.readBooks();
	}

	public Collection<Book> listBooksByGenre(Genre genre) {
		Set<Book> result = new HashSet<Book>();
		for(Book book : listBooks()) {
			if(book.getGenre() == genre) {
				result.add(book);
			}
		}
		return result;
	}

}
