package fr.claquettesetbabouchessoft.audiophile.db.query.parsing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.claquettesetbabouchessoft.audiophile.db.data.Album;
import fr.claquettesetbabouchessoft.audiophile.db.data.Author;
import fr.claquettesetbabouchessoft.audiophile.db.data.Song;
import fr.claquettesetbabouchessoft.audiophile.db.query.request.DBAlbumRequest;
import fr.claquettesetbabouchessoft.audiophile.db.query.request.DBAuthorRequest;
import fr.claquettesetbabouchessoft.audiophile.db.query.request.DBRequest;
import fr.claquettesetbabouchessoft.audiophile.db.query.request.DBSongRequest;
import fr.claquettesetbabouchessoft.audiophile.db.query.result.DBAlbumResult;
import fr.claquettesetbabouchessoft.audiophile.db.query.result.DBAuthorResult;
import fr.claquettesetbabouchessoft.audiophile.db.query.result.DBResult;
import fr.claquettesetbabouchessoft.audiophile.db.query.result.DBSongResult;

public class QueryParser {
	
	private DBRequest request;
	private Connection connection;
	
	public QueryParser(DBRequest request, Connection connection) {
		this.request = request;
		this.connection = connection;
	}
	
	/**
	 * Parse the given query and return the result
	 * @param <T> extends DBResult
	 * @return T result with null value inside if the query fail, and null if the query is not recognized
	 */
	@SuppressWarnings("unchecked")
	public synchronized <T extends DBResult> T parse() {
		//parse all differents request sended
		if(request.getClass().isAssignableFrom(DBSongRequest.class)) {
			DBSongRequest sreq = (DBSongRequest) request;			
			DBSongResult songResult = new DBSongResult(null);
			try {
				PreparedStatement prep_req = connection.prepareStatement("SELECT * FROM SONGS WHERE songID = ?");
				prep_req.setInt(1, sreq.getID());
				ResultSet res = prep_req.executeQuery();
				//as id is primary key there is only one or zero row
				if(res.next())songResult.setSong(new Song(res.getInt(1), res.getString(2), res.getString(3), res.getInt(4)));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return (T) songResult;
		}
		if(request.getClass().isAssignableFrom(DBAlbumRequest.class)) {
			DBAlbumRequest sreq = (DBAlbumRequest) request;
			DBAlbumResult albumResult = new DBAlbumResult(null);
			try {
				PreparedStatement prep_req = connection.prepareStatement("SELECT * FROM ALBUMS WHERE albumID = ?");
				prep_req.setInt(1, sreq.getID());
				ResultSet res = prep_req.executeQuery();
				//as id is primary key there is only one or zero row
				if(res.next())albumResult.setAlbum(new Album(res.getInt(1), res.getString(2)));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return (T) albumResult;
		}
		if(request.getClass().isAssignableFrom(DBAuthorRequest.class)) {
			DBAuthorRequest sreq = (DBAuthorRequest) request;
			DBAuthorResult authorResult = new DBAuthorResult(null);
			try {
				PreparedStatement prep_req = connection.prepareStatement("SELECT * FROM AUTHORS WHERE authorID = ?");
				prep_req.setInt(1, sreq.getID());
				ResultSet res = prep_req.executeQuery();
				//as id is primary key there is only one or zero row
				if(res.next())authorResult.setAuthor(new Author(res.getInt(1), res.getString(2)));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return (T) authorResult;
		}
		System.out.println("unknown request type: "+request.getClass());
		return null;
	}
	
}
