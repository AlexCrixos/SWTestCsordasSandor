package hu.uni.miskolc.iit.swtest.book.core.subject;

public class Book {

	private Genre genre;
	private BookType subject;
	private String publisher;
	private int publicationYear;
	private int pageNumber;

	public Book(BookType subject, String publisher, int publicationYear, int pageNumber) throws InvalidPublicationYearException{
		super();
		if(publicationYear < 1400) {
			throw new InvalidPublicationYearException();
		}
		this.subject = subject;
		this.genre = subject.getGenre();
		this.publisher = publisher;
		this.publicationYear = publicationYear;
		this.pageNumber = pageNumber;
	}

	public Genre getGenre() {
		return genre;
	}

	public BookType getSubject() {
		return subject;
	}

	public String getPublisher() {
		return publisher;
	}

	public int getPublicationYear() {
		return publicationYear;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((publisher == null) ? 0 : publisher.hashCode());
		result = prime * result + pageNumber;
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
		result = prime * result + publicationYear;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (publisher == null) {
			if (other.publisher != null)
				return false;
		} else if (!publisher.equals(other.publisher))
			return false;
		if (pageNumber != other.pageNumber)
			return false;
		if (genre != other.genre)
			return false;
		if (subject != other.subject)
			return false;
		if (publicationYear != other.publicationYear)
			return false;
		return true;
	}
	
	

}
