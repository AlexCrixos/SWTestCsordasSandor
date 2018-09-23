package hu.uni.miskolc.iit.swtest.book.core.subject;



import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

public class BookTest {
	
	private static final String SCIFI_PUBLISHER = "Szukits";
	
	private Book book;
	
	@Before
	public void setUp() {
		try {
			this.book = new Book(BookType.Timetravel, SCIFI_PUBLISHER, 2000, 750);
		} catch (InvalidPublicationYearException e) {
			Assume.assumeNoException(e);
		}
	}
	
	@Test
	public void testGenreWithScifi() {
		Genre expected = Genre.Scifi;
		Genre actual = book.getGenre();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testSubjectWithScifi(){
		BookType expected = BookType.Timetravel;
		BookType actual = book.getSubject();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testPublisherWithScifi() {
		String expected = SCIFI_PUBLISHER;
		String actual = book.getPublisher();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testPublicationYearWithScifi() {
		int expected = 2000;
		int actual = book.getPublicationYear();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testPageNumberhWithScifi() {
		int expected = 750;
		int actual = book.getPageNumber();
		Assert.assertEquals(expected, actual);
	}
	
	@Test(expected=InvalidPublicationYearException.class)
	public void testInvalidProductionYear() throws InvalidPublicationYearException {
		Book book = new Book(BookType.Timetravel, "Szukits", 0, 750);
	}

}
