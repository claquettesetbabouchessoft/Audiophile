package fr.claquettesetbabouchessoft.audiophile;

import fr.claquettesetbabouchessoft.audiophile.db.query.RequestFinder;
import fr.claquettesetbabouchessoft.audiophile.db.query.request.DBSongRequest;
import fr.claquettesetbabouchessoft.audiophile.db.query.result.DBSongResult;

public class App{
	
	public static void main(String[] args) {
		//launch the finder
		RequestFinder finder = new RequestFinder();
		finder.start();
		
		DBSongRequest req = new DBSongRequest(1);
		DBSongResult res = req.request();
		System.out.println(res.getSong());
		
		finder.stopSeeking();
	}
}
