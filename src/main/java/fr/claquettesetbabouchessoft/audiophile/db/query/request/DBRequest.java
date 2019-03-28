package fr.claquettesetbabouchessoft.audiophile.db.query.request;

import java.sql.Connection;

import fr.claquettesetbabouchessoft.audiophile.db.query.result.DBResult;

public abstract class DBRequest {
	public DBRequest() {}
	
	/**
	 * request the current request to the internal request finder system
	 * WARNING: this is blocking until a response is sended
	 * @param <T> extends {@link DBResult}
	 * @return T result 
	 */
	public abstract <T extends DBResult> T request();
	
	/**
	 * request data from server synchronously
	 * @param <T> extends {@link DBResult}
	 * @param connection {@link Connection} database connection
	 * @return T result
	 */
	public abstract <T extends DBResult> T synchronousRequest(Connection connection);
}
