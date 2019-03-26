package fr.claquettesetbabouchessoft.audiophile.utils;

import com.flowpowered.nbt.CompoundTag;
import com.flowpowered.nbt.Tag;

/**
 * Util class for NBT reading and writings
 * @author Axicer
 */
public class NBTUtils {

	/**
	 * Get a tag from parent's {@link CompoundTag} his name and the class as the return value
	 * @param parent parent {@link CompoundTag} to get tag from
	 * @param name {@link String} name of the child tag
	 * @param clazz {@link Class} to get tag type
	 * @return the child tag if found and assignable from given class or null otherwise
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T extends Tag> T getChild(CompoundTag parent, String name, Class<T> clazz){
		Tag child = parent.getValue().get(name);
		return clazz.isInstance(child) ? (T)child : null; 
	}
}
