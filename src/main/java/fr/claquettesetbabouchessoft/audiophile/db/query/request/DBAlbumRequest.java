package fr.claquettesetbabouchessoft.audiophile.db.query.request;

import fr.claquettesetbabouchessoft.audiophile.db.query.Finder;
import fr.claquettesetbabouchessoft.audiophile.db.query.result.DBAlbumResult;

public class DBAlbumRequest extends DBRequest{

	private int id;
	
	public DBAlbumRequest(int id) {
		this.id = id;
	}
	
	public int getID() {
		return this.id;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public DBAlbumResult request() {
		return Finder.answer(this);
	}

}
