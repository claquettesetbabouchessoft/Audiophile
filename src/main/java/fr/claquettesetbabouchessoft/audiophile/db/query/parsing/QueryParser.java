package fr.claquettesetbabouchessoft.audiophile.db.query.parsing;

import fr.claquettesetbabouchessoft.audiophile.db.query.request.DBRequest;
import fr.claquettesetbabouchessoft.audiophile.db.query.result.DBResult;

public class QueryParser {
	
	private DBRequest request;
	
	public QueryParser(DBRequest request) {
		this.request = request;
	}
	
	public <T extends DBResult> T parse() {
		//TODO parse all differents request sended
		return null;
	}
	
}
