package fr.claquettesetbabouchessoft.audiophile.data;

public class Song {

	String path, name;
	int id, albumId, albumPos;
	
	public Song(String path, String name, int id, int albumId, int albumPos) {
		this.name = name;
		this.path = path;
		this.id = id;
		this.albumId = albumId;
		this.albumPos = albumPos;
	}
}
