package fr.claquettesetbabouchessoft.audiophile.db.query.parsing;

import java.sql.Connection;
import java.util.concurrent.Callable;

import fr.claquettesetbabouchessoft.audiophile.db.query.request.DBRequest;
import fr.claquettesetbabouchessoft.audiophile.db.query.result.DBResult;

public class QueryParser<T extends DBResult> implements Callable<T>{
	
	private DBRequest request;
	private Connection connection;
	
	public QueryParser(DBRequest request, Connection connection) {
		this.request = request;
		this.connection = connection;
	}

	@Override
	public T call() throws Exception {
		return request.synchronousRequest(connection);
	}
	
}
