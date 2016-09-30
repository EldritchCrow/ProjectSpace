package us.fredb.projectspace;

public class AtomBuilder extends Builder<Atom> {
	
	private Class<? extends Atom> Type = MemoryAtom.class;
	private float x = 0F;
	private float y = 0F;
	private float z = 0F;
	
	/**
	 * Returns a new instance of an AtomBuilder.
	 * Defaults are a memory atom at 0,0,0
	 * @return a new AtomBuilder.
	 */
	public static AtomBuilder Get() {
		return new AtomBuilder();
	}
	
	/**
	 * Sets the initial position of the atom being built
	 * @param x X position of the atom
	 * @param y Y position of the atom
	 * @param z Z position of the atom
	 * @return this
	 */
	public AtomBuilder SetPosition(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
		
		return this;
	}
	
	/**
	 * Sets the type of atom to build
	 * @param type an atom subclass
	 * @return this
	 */
	public AtomBuilder SetType(Class<? extends Atom> type) {
		this.Type = type;
		
		return this;
	}

	@Override
	public Atom Build() {
		Atom atom;
		try {
			atom = (Atom)Type.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
			return null;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			return null;
		}
		atom.SetXPos(x);
		atom.SetYPos(y);
		atom.SetZPos(z);
		
		return atom;
	}

}
