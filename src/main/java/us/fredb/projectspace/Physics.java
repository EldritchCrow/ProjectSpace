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
	 * Returns an atom by it's id.
	 * @param id The id of the atom
	 * @return The atom with the id.
	 */
	public abstract Atom GetAtomById(String id);
	
	/**
	 * Adds an atom to the physics system
	 * @param atom The atom to add
	 */
	public abstract void AddAtom(Atom atom);

}
