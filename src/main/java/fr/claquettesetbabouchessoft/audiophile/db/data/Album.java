package fr.claquettesetbabouchessoft.audiophile.db.data;

/**
 * An album as represented in the database
 * @author Axicer
 */
public class Album {

	private int albumID;
	private String name;
	
	public Album(int albumID, String name) {
		this.name = name;
		this.albumID = albumID;
	}

	public String getName() {
		return name;
	}

	public int getAlbumID() {
		return albumID;
	}
	
	
}
