package fr.claquettesetbabouchessoft.audiophile.db.query.request;

import fr.claquettesetbabouchessoft.audiophile.db.query.RequestFinder;
import fr.claquettesetbabouchessoft.audiophile.db.query.result.DBAuthorResult;

public class DBAuthorRequest extends DBRequest{

	private int id;
	
	public DBAuthorRequest(int id) {
		this.id = id;
	}
	
	public int getID() {
		return this.id;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public DBAuthorResult request() {
		return RequestFinder.answer(this);
	}
}
