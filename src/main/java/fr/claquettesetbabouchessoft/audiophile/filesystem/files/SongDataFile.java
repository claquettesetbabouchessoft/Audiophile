package fr.claquettesetbabouchessoft.audiophile.filesystem.files;

import com.flowpowered.nbt.IntTag;
import com.flowpowered.nbt.StringTag;

import fr.claquettesetbabouchessoft.audiophile.data.Album;
import fr.claquettesetbabouchessoft.audiophile.data.Song;
import fr.claquettesetbabouchessoft.audiophile.filesystem.nbt.NBTFile;
import fr.claquettesetbabouchessoft.audiophile.utils.NBTUtils;

/**
 * Data file for each song
 * @author Axicer
 */
public class SongDataFile extends NBTFile{

	private static final String PATH_TAG_ID = "path";
	private static final String SONG_NAME_TAG_ID = "name";
	private static final String SONG_ALBUM_TAG_ID = "albumId";
	private static final String SONG_ALBUM_POSITION_TAG_ID = "albumPos";
	private static final String SONG_ID_TAG_ID = "id";
	
	//current data file path
	private String path;
	
	/**
	 * Constructor of a {@link SongDataFile}
	 * @param path {@link String} path of the current data file
	 */
	public SongDataFile(String path) {
		super(path);
		this.path = path;
	}

	/**
	 * @return this data file path
	 */
	public String getDataFilePath() {
		return this.path;
	}
	
	/**
	 * @return path to the song
	 */
	public String getSongFilePath() {
		StringTag str_tag = NBTUtils.getChild(getRoot(), PATH_TAG_ID, StringTag.class);
		return str_tag == null ? null : str_tag.getValue();
	}
	
	/**
	 * @return song's name
	 */
	public String getSongName() {
		StringTag str_tag = NBTUtils.getChild(getRoot(), SONG_NAME_TAG_ID, StringTag.class);
		return str_tag == null ? null : str_tag.getValue();
	}
	
	/**
	 * @return song's album id
	 */
	public int getSongAlbumId() {
		IntTag int_tag = NBTUtils.getChild(getRoot(), SONG_ALBUM_TAG_ID, IntTag.class);
		return int_tag == null ? null : int_tag.getValue();
	}
	
	/**
	 * @return song's album id
	 */
	public int getSongAlbumPosition() {
		IntTag int_tag = NBTUtils.getChild(getRoot(), SONG_ALBUM_POSITION_TAG_ID, IntTag.class);
		return int_tag == null ? null : int_tag.getValue();
	}
	
	/**
	 * @return song's id
	 */
	public int getSongId() {
		IntTag int_tag = NBTUtils.getChild(getRoot(), SONG_ID_TAG_ID, IntTag.class);
		return int_tag == null ? null : int_tag.getValue();
	}
	
	public Song toAlbum(Album album) {
		return new Song(getSongFilePath(), getSongName(), getSongId(), getSongAlbumId(), getSongAlbumPosition());
	}
}
