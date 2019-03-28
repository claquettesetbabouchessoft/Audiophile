package fr.claquettesetbabouchessoft.audiophile.db.query.result;

import fr.claquettesetbabouchessoft.audiophile.db.data.Author;

public class DBAuthorResult extends DBResult{

	private Author author;
	
	public DBAuthorResult(Author author) {
		this.author = author;
	}
	
	public Author getAuthor() {
		return this.author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
	
}
