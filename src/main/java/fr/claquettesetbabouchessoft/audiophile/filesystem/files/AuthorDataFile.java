package fr.claquettesetbabouchessoft.audiophile.filesystem.files;

import com.flowpowered.nbt.IntTag;
import com.flowpowered.nbt.StringTag;

import fr.claquettesetbabouchessoft.audiophile.data.Author;
import fr.claquettesetbabouchessoft.audiophile.filesystem.nbt.NBTFile;
import fr.claquettesetbabouchessoft.audiophile.utils.NBTUtils;

public class AuthorDataFile extends NBTFile{

	private static final String PATH_TAG_ID = "path";
	private static final String AUTHOR_NAME_TAG_ID = "name";
	private static final String AUTHOR_ID_TAG_ID = "id";
	
	
	//current data file path
	private String path;
	
	public AuthorDataFile(String path) {
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
	 * @return the author's id
	 */
	public int getAuthorID() {
		IntTag int_tag = NBTUtils.getChild(getRoot(), AUTHOR_ID_TAG_ID, IntTag.class);
		return int_tag == null ? null : int_tag.getValue();
	}
	
	/**
	 * @return the author's name
	 */
	public String getAuthorName() {
		StringTag str_tag = NBTUtils.getChild(getRoot(), AUTHOR_NAME_TAG_ID, StringTag.class);
		return str_tag == null ? null : str_tag.getValue();
	}
	
	/**
	 * @return the author's path
	 */
	public String getAuthorPath() {
		StringTag str_tag = NBTUtils.getChild(getRoot(), PATH_TAG_ID, StringTag.class);
		return str_tag == null ? null : str_tag.getValue();
	}

	public Author toAuthor() {
		return new Author(getAuthorName(), getAuthorID(), getAuthorPath());
	}
}
