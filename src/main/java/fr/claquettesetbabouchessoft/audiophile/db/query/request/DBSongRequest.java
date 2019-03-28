package fr.claquettesetbabouchessoft.audiophile.db.query.request;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.claquettesetbabouchessoft.audiophile.db.data.Song;
import fr.claquettesetbabouchessoft.audiophile.db.query.RequestFinder;
import fr.claquettesetbabouchessoft.audiophile.db.query.result.DBSongResult;

public class DBSongRequest extends DBRequest{

	private int id; 
	
	public DBSongRequest(int id) {
		this.id = id;
	}
	
	public int getID() {
		return this.id;
	}

	@SuppressWarnings("unchecked")
	@Override
	public DBSongResult request() {
		return RequestFinder.answer(this);
	}

	@SuppressWarnings("unchecked")
	@Override
	public DBSongResult synchronousRequest(Connection connection) {
		DBSongResult songResult = new DBSongResult(null);
		try {
			PreparedStatement prep_req = connection.prepareStatement("SELECT * FROM SONGS WHERE songID = ?");
			prep_req.setInt(1, this.id);
			ResultSet res = prep_req.executeQuery();
			//as id is primary key there is only one or zero row
			if(res.next())songResult.setSong(new Song(res.getInt(1), res.getString(2), res.getString(3), res.getInt(4)));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return songResult;
	}
}
