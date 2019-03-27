package fr.claquettesetbabouchessoft.audiophile.db.query.request;

import fr.claquettesetbabouchessoft.audiophile.db.query.Finder;
import fr.claquettesetbabouchessoft.audiophile.db.query.result.DBSongResult;

public class DBSongRequest extends DBRequest{

	private int id; 
	
	public DBSongRequest(int id) {
		this.id = id;
	}
	
	public int getID() {
		return this.id;
	}

	@SuppressWarnings("unchecked")
	@Override
	public DBSongResult request() {
		return Finder.answer(this);
	}
}
