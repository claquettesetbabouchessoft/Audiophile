package fr.claquettesetbabouchessoft.audiophile.db.query.request;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.claquettesetbabouchessoft.audiophile.db.data.Author;
import fr.claquettesetbabouchessoft.audiophile.db.query.RequestFinder;
import fr.claquettesetbabouchessoft.audiophile.db.query.result.DBAuthorResult;

public class DBAuthorRequest extends DBRequest{

	private int id;
	
	public DBAuthorRequest(int id) {
		this.id = id;
	}
	
	public int getID() {
		return this.id;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public DBAuthorResult request() {
		return RequestFinder.answer(this);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public DBAuthorResult synchronousRequest(Connection connection) {
		DBAuthorResult authorResult = new DBAuthorResult(null);
		try {
			PreparedStatement prep_req = connection.prepareStatement("SELECT * FROM AUTHORS WHERE authorID = ?");
			prep_req.setInt(1, this.id);
			ResultSet res = prep_req.executeQuery();
			//as id is primary key there is only one or zero row
			if(res.next())authorResult.setAuthor(new Author(res.getInt(1), res.getString(2)));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return authorResult;
	}
}
