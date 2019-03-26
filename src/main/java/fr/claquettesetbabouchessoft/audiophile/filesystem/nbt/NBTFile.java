package fr.claquettesetbabouchessoft.audiophile.filesystem.nbt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import com.flowpowered.nbt.CompoundTag;
import com.flowpowered.nbt.stream.NBTInputStream;

/**
 * Read data as a NBT Tag from a given path
 * @author Axicer
 */
public class NBTFile {

	public static final String NBT_EXTENSION = "nbt";
	
	//root tag
	private CompoundTag root;
	
	/**
	 * Constructor of a {@link NBTFile}
	 * @param path {@link String} path to the file
	 */
	public NBTFile(String path) {
		//get file from path
		File file = new File(path);
		if(file.exists()) {
			try {
				InputStream stream = new FileInputStream(file);
				NBTInputStream nbt_is = new NBTInputStream(stream);
				
				root = (CompoundTag) nbt_is.readTag();
				
				nbt_is.close();
				stream.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Get the current {@link CompoundTag} which is the root of the file
	 * @return root {@link CompoundTag}
	 */
	public CompoundTag getRoot() {
		return this.root;
	}
	
}
