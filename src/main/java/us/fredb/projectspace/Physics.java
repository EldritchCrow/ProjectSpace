package us.fredb.projectspace;

/**
 * Managers list of all atoms and performs physics calculations.
 * @author Fred Buchanan
 *
 */
public abstract class Physics {
	
	/**
	 * Gets all the atoms managed by this physics system
	 * @return An array of atoms
	 */
	public abstract Atom[] GetAllAtoms();
	
	/**
	 * Returns an atom by it's integer id.
	 * @param id The id of the atom
	 * @return The atom with the id.
	 */
	public abstract Atom GetAtomById(int id);

}
