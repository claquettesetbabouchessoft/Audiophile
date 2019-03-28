package fr.claquettesetbabouchessoft.audiophile.db.query;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import fr.claquettesetbabouchessoft.audiophile.db.query.parsing.QueryParser;
import fr.claquettesetbabouchessoft.audiophile.db.query.request.DBRequest;
import fr.claquettesetbabouchessoft.audiophile.db.query.result.DBResult;
import fr.claquettesetbabouchessoft.audiophile.utils.Environment;
import fr.claquettesetbabouchessoft.audiophile.utils.QAQueue;

/**
 * Finding class for requests
 * @author Axicer
 */
public class RequestFinder extends Thread{
	
	@SuppressWarnings("rawtypes")
	private static QAQueue queue;
	static {
		queue = new QAQueue<>();
	}
	
	private Connection connection;
	private boolean shouldStop;
	
	public RequestFinder() {
		try {
			shouldStop = false;
			//init mysql drivers
			Class.forName("com.mysql.cj.jdbc.Driver");
			//create connection
			connection = DriverManager.getConnection(Environment.DATABASE_URL, Environment.DATABASE_USER, Environment.DATABASE_PASS);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void run() {
		while(!shouldStop) {
			//wait for a request
			DBRequest request = queue.getQuestion();
			//if request is null it's that the queue is shutdown
			if(request == null)continue;
			//answer via a QueryParser and set the result in the queue
			queue.setAnswer(new QueryParser(request, connection).parse());
		}
	}
	
	/**
	 * End the current finder from finding request
	 */
	public void stopSeeking() {
		shouldStop = true;
		queue.shutdown();
	}
	
	/**
	 * send the given request to the server and get the response from a Finder runnable
	 * @param <T> extends DBRequest
	 * @param <V> extends DBResult
	 * @param request T request to send
	 * @return V request's answer
	 */
	@SuppressWarnings("unchecked")
	public static <T extends DBRequest, V extends DBResult> V answer(T request) {
		return (V) queue.get(request);
	}
	
}
