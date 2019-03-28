package fr.claquettesetbabouchessoft.audiophile;

import fr.claquettesetbabouchessoft.audiophile.db.query.RequestFinder;
import fr.claquettesetbabouchessoft.audiophile.db.query.request.DBSongRequest;

public class App{
	
	public static void main(String[] args) {
		//launch the finder
		RequestFinder finder = new RequestFinder();
		finder.start();
	
		//computing 10000 request to database and calculating average request time
		System.out.println("running 10000 tests");
		
		long avg = 0;
		long avg_cpt = 0;
		
		for(int i = 0 ; i < 10000 ; i++) {
			long before = System.nanoTime();
			DBSongRequest req = new DBSongRequest(1);
			req.request();
			long after = System.nanoTime();
			avg_cpt++;
			avg += after-before;
		}
		System.out.println("average time: "+(avg/avg_cpt)/1000000.0 + "ms");
		
		finder.stopSeeking();
	}
}
