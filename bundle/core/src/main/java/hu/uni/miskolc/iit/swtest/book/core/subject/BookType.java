package hu.uni.miskolc.iit.swtest.book.core.subject;

public enum BookType {
	Timetravel(Genre.Scifi),
	Spaceopera(Genre.Scifi),
	Steampunk(Genre.Scifi),
	Hard(Genre.Romantic),
	Soft(Genre.Romantic);
	
	
	private final Genre genre;
	
	private BookType(Genre genre) {
		this.genre = genre;
	}

	public Genre getGenre() {
		return genre;
	}
	
	
}
