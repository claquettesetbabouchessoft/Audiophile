package fr.claquettesetbabouchessoft.audiophile.filesystem;

import fr.claquettesetbabouchessoft.audiophile.data.Album;
import fr.claquettesetbabouchessoft.audiophile.data.Author;
import fr.claquettesetbabouchessoft.audiophile.data.Song;

/**
 * Searcher class for searching songs, albums, and authors
 * @author Axicer
 */
public class Searcher {

	/**
	 * Get authors like a given pattern math some author's name
	 * @param pattern {@link String} pattern to match
	 * @return {@link Author}[] array of authors matching this name
	 */
	public static Author[] getAuthorsLike(String pattern) {
		//TODO
		return null;
	}
	
	/**
	 * Get the author with the given ID
	 * @param id int id to get author from
	 * @return {@link Author} if found null otherwise
	 */
	public static Author getAuthorWithID(int id) {
		//TODO
		return null;
	}
	
	/**
	 * Get albums like a given pattern math some albums's name
	 * @param pattern {@link String} pattern to match
	 * @return {@link Album}[] array of albums matching this name
	 */
	public static Album[] getAlbumsLike(String pattern) {
		//TODO
		return null;
	}
	
	/**
	 * Returns all the albums from a specified {@link Author}
	 * @param author {@link Author} to get all the albums from
	 * @return {@link Album}[] array of author's albums or null if the author is null
	 */
	public static Album[] getAlbumsFrom(Author author) {
		//TODO
		return null;
	}
	
	/**
	 * Get the album with the given ID
	 * @param id int id to get album from
	 * @return {@link Album} if found null otherwise
	 */
	public static Album getAlbumWithID(int id) {
		//TODO
		return null;
	}
	
	/**
	 * Returns all the songs from a specified {@link Album}
	 * @param author {@link Album} to get all the songs from
	 * @return {@link Song}[] array of album's songs or null if the album is null
	 */
	public static Song[] getSongsFrom(Author author) {
		//TODO
		return null;
	}
	
	/**
	 * Returns all the songs from a specified {@link Author}
	 * @param author {@link Author} to get all the songs from
	 * @return {@link Song}[] array of author's songs or null if the author is null
	 */
	public static Song[] getSongsFrom(Album author) {
		//TODO
		return null;
	}
	
	/**
	 * Get songs like a given pattern math some songs's name
	 * @param pattern {@link String} pattern to match
	 * @return {@link Song}[] array of songs matching this name
	 */
	public static Song[] getSongsLike(String pattern) {
		//TODO
		return null;
	}
	
	/**
	 * Get the song with the given ID
	 * @param id int id to get song from
	 * @return {@link Song} if found null otherwise
	 */
	public static Song getSongsWithID(int id) {
		//TODO
		return null;
	}
	
}
