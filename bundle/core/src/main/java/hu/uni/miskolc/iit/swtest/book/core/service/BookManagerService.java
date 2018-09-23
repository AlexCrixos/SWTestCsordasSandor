package hu.uni.miskolc.iit.swtest.book.core.service;

import java.util.Collection;

import hu.uni.miskolc.iit.swtest.book.core.subject.Book;
import hu.uni.miskolc.iit.swtest.book.core.subject.Genre;
import hu.uni.miskolc.iit.swtest.book.core.service.exceptions.BookAlreadyExistsException;

public interface BookManagerService {
	
	void recordBook(Book car) throws BookAlreadyExistsException;
	void updateBook(Book car) throws BookDoesNotExisitsException;
	
	Collection<Book> listBooks();
	Collection<Book> listBooksByGenre(Genre genre);

}
