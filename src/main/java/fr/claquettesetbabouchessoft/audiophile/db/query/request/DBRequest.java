package fr.claquettesetbabouchessoft.audiophile.db.query.request;

import fr.claquettesetbabouchessoft.audiophile.db.query.result.DBResult;

public abstract class DBRequest {
	public DBRequest() {}
	
	public abstract <T extends DBResult> T request();
}
