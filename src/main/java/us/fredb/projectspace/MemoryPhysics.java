package us.fredb.projectspace;

import java.util.LinkedList;
import java.util.List;

public class MemoryPhysics extends Physics {
	
	private List<Atom> Atoms = new LinkedList<Atom>();

	@Override
	public Atom[] GetAllAtoms() {
		return (Atom[]) Atoms.toArray();
	}

	@Override
	public Atom GetAtomById(String id) {
		for (Atom a : Atoms) {
			if (a.GetId().equals(id)) {
				return a;
			}
		}
		
		return null;
	}

	@Override
	public void AddAtom(Atom atom) {
		Atoms.add(atom);
	}

}
