package hu.uni.miskolc.iit.swtest.book.core.subject;

public enum BookType {
	Timetravel(Genre.Scifi),
	Soft(Genre.Romantic);
	
	
	private final Genre genre;
	
	private BookType(Genre genre) {
		this.genre = genre;
	}

	public Genre getGenre() {
		return genre;
	}
	
	
}
