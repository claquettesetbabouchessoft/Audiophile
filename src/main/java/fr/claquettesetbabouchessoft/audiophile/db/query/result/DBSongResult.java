package fr.claquettesetbabouchessoft.audiophile.db.query.result;

import fr.claquettesetbabouchessoft.audiophile.db.data.Song;

public class DBSongResult extends DBResult{

	private Song song;
	
	public DBSongResult(Song song) {
		this.song = song;
	}
	
	public Song getSong() {
		return this.song;
	}

	public void setSong(Song song) {
		this.song = song;
	}
}
