package fr.claquettesetbabouchessoft.audiophile.data;

public class Album {

	public String path, name, image;
	public int date, id, authorID;
	
	public Album(String path, String name, int id, int date, int authorID, String image) {
		this.path = path;
		this.name = name;
		this.authorID = authorID;
		this.id = id;
		this.date = date;
		this.image = image;
	}
}
