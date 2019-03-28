package fr.claquettesetbabouchessoft.audiophile.db.query.result;

import fr.claquettesetbabouchessoft.audiophile.db.data.Album;

public class DBAlbumResult extends DBResult{

	private Album album;
	
	public DBAlbumResult(Album album) {
		this.album = album;
	}
	
	public Album getAlbum() {
		return this.album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}
	
}
