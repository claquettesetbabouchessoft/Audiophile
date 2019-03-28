package fr.claquettesetbabouchessoft.audiophile.db.data;

/**
 * A song as represented in the database
 * @author Axicer
 */
public class Song {

	private String name;
	private String image;
	private int songID;
	private int position;
	
	public Song(int songID, String name, String image, int position) {
		this.name = name;
		this.songID = songID;
		this.image = image;
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public int getSongID() {
		return songID;
	}

	public String getImage() {
		return image;
	}

	public int getPosition() {
		return position;
	}

	@Override
	public String toString() {
		return "Song [name=" + name + ", image=" + image + ", songID=" + songID + ", position=" + position + "]";
	}
	
}
