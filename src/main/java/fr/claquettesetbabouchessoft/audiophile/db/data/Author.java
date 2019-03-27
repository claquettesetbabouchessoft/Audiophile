package fr.claquettesetbabouchessoft.audiophile.db.data;

/**
 * Anm author as represented in the database
 * @author Axicer
 */
public class Author {

	private int authorID;
	private String name;
	
	public Author(int authorID, String name) {
		this.name = name;
		this.authorID = authorID;
	}

	public String getName() {
		return name;
	}

	public int getAuthorID() {
		return authorID;
	}
}
