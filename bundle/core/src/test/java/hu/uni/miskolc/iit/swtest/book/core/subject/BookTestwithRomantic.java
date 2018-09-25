package hu.uni.miskolc.iit.swtest.book.core.subject;



import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

public class BookTestwithRomantic {
	
	private static final String ROMANTIC_PUBLISHER = "Europa";
	
	private Book book;
	
	@Before
	public void setUp() {
		try {
			this.book = new Book(BookType.Soft, ROMANTIC_PUBLISHER, 1870, 1210);
		} catch (InvalidPublicationYearException e) {
			Assume.assumeNoException(e);
		}
	}
	
	@Test
	public void testGenreWithRomantic() {
		Genre expected = Genre.Romantic;
		Genre actual = book.getGenre();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testSubjectWithRomantic(){
		BookType expected = BookType.Soft;
		BookType actual = book.getSubject();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testPublisherWithRomantic() {
		String expected = ROMANTIC_PUBLISHER;
		String actual = book.getPublisher();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testPublicationYearWithRomantic() {
		int expected = 1870;
		int actual = book.getPublicationYear();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testPageNumberhWithRomantic() {
		int expected = 1210;
		int actual = book.getPageNumber();
		Assert.assertEquals(expected, actual);
	}
	
	@Test(expected=InvalidPublicationYearException.class)
	public void testInvalidProductionYear() throws InvalidPublicationYearException {
		Book book = new Book(BookType.Soft, "Europa", 0, 750);
	}

}
