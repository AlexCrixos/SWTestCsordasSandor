package hu.uni.miskolc.iit.swtest.book.dao.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.swing.plaf.FileChooserUI;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import hu.uni.miskolc.iit.swtest.book.core.subject.Book;
import hu.uni.miskolc.iit.swtest.book.core.subject.BookType;
import hu.uni.miskolc.iit.swtest.book.core.subject.InvalidPublicationYearException;
import hu.uni.miskolc.iit.swtest.book.dao.BookDAO;

public class BookFileDAOTest {

	private static File DEFAULT_DB_STATE;
	
	private File temporalDB;
	private BookDAO dao;

	@BeforeClass
	public static void beforeClass() {
		DEFAULT_DB_STATE = new File("src/resources/bookDB.csv");
	}

	@Before
	public void setUp() throws IOException {
		temporalDB = File.createTempFile("bookDB", "csv");
		InputStream is = null;
		OutputStream os = null;
		try {

			is = new FileInputStream(DEFAULT_DB_STATE);
			os = new FileOutputStream(temporalDB);
			byte[] buffer = new byte[1024];
			int length;
			while ((length = is.read(buffer)) > 0) {
				os.write(buffer, 0, length);
			}
		} finally {
			is.close();
			os.close();
		}
		this.dao = new BookFileDAO(temporalDB);
	}

	@Test
	public void testReadCarsFromDefaultDB() throws InvalidPublicationYearException {
		List<Book> expected = Arrays.asList(
				new Book(BookType.Timetravel, "Szukits", 2010, 550),
				new Book(BookType.Soft, "Europa", 1940, 1320));
		Collection<Book> actual = dao.readBooks();
		Assert.assertEquals(expected.size(), actual.size());
		for(Book book : expected) {
			Assert.assertTrue(actual.contains(book));
		}
	}

}
