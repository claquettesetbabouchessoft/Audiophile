package fr.claquettesetbabouchessoft.audiophile.db.query.request;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.claquettesetbabouchessoft.audiophile.db.data.Album;
import fr.claquettesetbabouchessoft.audiophile.db.query.RequestFinder;
import fr.claquettesetbabouchessoft.audiophile.db.query.result.DBAlbumResult;

public class DBAlbumRequest extends DBRequest{

	private int id;
	
	public DBAlbumRequest(int id) {
		this.id = id;
	}
	
	public int getID() {
		return this.id;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public DBAlbumResult request() {
		return RequestFinder.answer(this);
	}

	@SuppressWarnings("unchecked")
	@Override
	public DBAlbumResult synchronousRequest(Connection connection) {
		DBAlbumResult albumResult = new DBAlbumResult(null);
		try {
			PreparedStatement prep_req = connection.prepareStatement("SELECT * FROM ALBUMS WHERE albumID = ?");
			prep_req.setInt(1, this.id);
			ResultSet res = prep_req.executeQuery();
			//as id is primary key there is only one or zero row
			if(res.next())albumResult.setAlbum(new Album(res.getInt(1), res.getString(2)));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return albumResult;
	}
}
