package fr.claquettesetbabouchessoft.audiophile.db.query;

import fr.claquettesetbabouchessoft.audiophile.db.query.parsing.QueryParser;
import fr.claquettesetbabouchessoft.audiophile.db.query.request.DBRequest;
import fr.claquettesetbabouchessoft.audiophile.db.query.result.DBResult;
import fr.claquettesetbabouchessoft.audiophile.utils.QAQueue;

/**
 * Finding class for requests
 * @author Axicer
 */
public class Finder implements Runnable{
	
	static QAQueue<? extends DBRequest, ? extends DBResult> queue;
	static {
		queue = new QAQueue<>();
	}
	
	public Finder() {}

	@Override
	public void run() {
		//wait for a request
		DBRequest request = queue.getQuestion();
		//answer via a QueryParser and set the result in the queue
		queue.setAnswer(new QueryParser(request).parse());
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
		return (V) queue.get(null);
	}
	
}
