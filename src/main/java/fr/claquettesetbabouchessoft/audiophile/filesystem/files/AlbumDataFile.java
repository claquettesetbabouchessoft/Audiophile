package fr.claquettesetbabouchessoft.audiophile.filesystem.files;

import com.flowpowered.nbt.IntTag;
import com.flowpowered.nbt.StringTag;

import fr.claquettesetbabouchessoft.audiophile.data.Album;
import fr.claquettesetbabouchessoft.audiophile.data.Author;
import fr.claquettesetbabouchessoft.audiophile.filesystem.nbt.NBTFile;
import fr.claquettesetbabouchessoft.audiophile.utils.NBTUtils;

/**
 * album data
 * @author Axicer
 */
public class AlbumDataFile extends NBTFile{

	private static final String PATH_TAG_ID = "path";
	private static final String ALBUM_NAME_TAG_ID = "name";
	private static final String ALBUM_ID_TAG_ID = "id";
	private static final String ALBUM_IMAGE_TAG_ID = "image";
	private static final String ALBUM_AUTHOR_ID_TAG_ID = "authorId";
	private static final String ALBUM_DATE_TAG_ID = "date";
	
	//current data file path
	private String path;
	
	/**
	 * Constructor of an album data file
	 * @param path {@link String} path to the album data file
	 */
	public AlbumDataFile(String path) {
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
	 * @return path to the album folder
	 */
	public String getAlbumFolderPath() {
		StringTag str_tag = NBTUtils.getChild(getRoot(), PATH_TAG_ID, StringTag.class);
		return str_tag == null ? null : str_tag.getValue();
	}
	
	/**
	 * @return the album name
	 */
	public String getAlbumName() {
		StringTag str_tag = NBTUtils.getChild(getRoot(), ALBUM_NAME_TAG_ID, StringTag.class);
		return str_tag == null ? null : str_tag.getValue();
	}
	
	/**
	 * @return the album image as a base64 String representation
	 */
	public String getAlbumImage() {
		StringTag str_tag = NBTUtils.getChild(getRoot(), ALBUM_IMAGE_TAG_ID, StringTag.class);
		return str_tag == null ? null : str_tag.getValue();
	}
	
	/**
	 * @return the album date
	 */
	public int getAlbumDate() {
		IntTag int_tag = NBTUtils.getChild(getRoot(), ALBUM_DATE_TAG_ID, IntTag.class);
		return int_tag == null ? null : int_tag.getValue();
	}
	
	/**
	 * @return the album's id
	 */
	public int getAlbumID() {
		IntTag int_tag = NBTUtils.getChild(getRoot(), ALBUM_ID_TAG_ID, IntTag.class);
		return int_tag == null ? null : int_tag.getValue();
	}
	
	/**
	 * @return the album author's id
	 */
	public int getAlbumAuthorID() {
		IntTag int_tag = NBTUtils.getChild(getRoot(), ALBUM_AUTHOR_ID_TAG_ID, IntTag.class);
		return int_tag == null ? null : int_tag.getValue();
	}
	
	public Album toAlbum(Author auth) {
		return new Album(getAlbumFolderPath(), getAlbumName(), getAlbumID(), getAlbumDate(), getAlbumAuthorID(), getAlbumImage());
	}
}
