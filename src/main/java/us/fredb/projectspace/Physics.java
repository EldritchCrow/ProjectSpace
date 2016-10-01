package us.fredb.projectspace;

import java.lang.Math;
import java.util.LinkedList;

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
	 * @return The atom or null if not found.
	 */
	public abstract Atom GetAtomById(String id);
	
	/**
	 * Adds an atom to the physics system
	 * @param atom The atom to add
	 */
	public abstract void AddAtom(Atom atom);
	
	/**
	 * Finds the distance of an atom from an arbitrary point t from a system of parametric equations
	 * @param a The Atom to be measured
	 * @param t meaningless value directly proportional to the square root of distance
	 * @param a1 The constant term in the x parametric equation
	 * @param a2 The linear term in the x parametric equation
	 * @param b1 The constant term in the y parametric equation
	 * @param b2 The linear term in the y parametric equation
	 * @param c1 The constant term in the z parametric equation
	 * @param c2 The linear term in the z parametric equation
	 * @return
	 */
	float GetDistFromT(Atom a, float t, float a1, float a2, float b1, float b2, float c1, float c2)
	{
		return (float) Math.sqrt((double) ((a1 + t*a2 - a.GetXPos())*(a1 + t*a2 - a.GetXPos()) + (b1 + t*b2 - a.GetYPos())*(b1 + t*b2 - a.GetYPos()) + (c1 + t*c2 - a.GetZPos())*(c1 + t*c2 - a.GetZPos())));
	}
	
	/**
	 * Finds a distance between 2 atoms
	 * @param a The first atom
	 * @param source The second atom
	 * @return A distance as a float
	 */
	public float GetDist(Atom a, Atom source)
	{
		return (float) Math.sqrt((double) ((a.GetXPos() - source.GetXPos())*(a.GetXPos() - source.GetXPos()) + (a.GetYPos() - source.GetYPos())*(a.GetYPos() - source.GetYPos()) + (a.GetZPos() - source.GetZPos())*(a.GetZPos() - source.GetZPos())));
	}
	
	/**
	 * Tells you what Atoms you hit when source fired
	 * @param source The Atom that started the call (fired a shot)
	 * @param relDirs An array containing the relative directions in terms of coordinate points (assuming source was adjusted to the origin).
	 * @param dist The maximum distance you can be from the line in order to be hit.
	 * @return A LinkedList of Atoms that were hit by the Raycast
	 * @throws Exception Will be thrown if relDirs values are too high or distance is not changing when a parametric parameter does
	 */
	public LinkedList<Atom> Raycast(Atom source, float[] relDirs, float dist, float maxdist) throws Exception
	{
		LinkedList<Atom> toReturn = new LinkedList<Atom>();
		float[] realSrc = new float[] {source.GetXPos(), source.GetYPos(), source.GetZPos()};
		float[] realDirs = new float[] {source.GetXPos() + relDirs[0], source.GetYPos() + relDirs[1], source.GetZPos() + relDirs[2]};
		float a1 = realSrc[0];
		float b1 = realSrc[1];
		float c1 = realSrc[2];
		float a2 = realDirs[0] - realSrc[0];
		float b2 = realDirs[1] - realSrc[1];
		float c2 = realDirs[2] - realSrc[2];
		if(a2 > 10 || b2 > 10 || c2 > 10) throw new Exception("ERROR DURING RAYCASTING: A RELDIR VALUE WAS TOO HIGH");
		float newdist = 0, lastdist = 0;
		float t;
		float increment = 10;
		int i = 0;
		for(Atom a : this.GetAllAtoms())
		{
			t = 0;
			newdist = GetDistFromT(a, t, a1, a2, b1, b2, c1, c2);
			while(Math.abs(newdist - lastdist) > 100)
			{
				if(newdist - lastdist > 0) t += increment;
				else if(newdist - lastdist < 0) t -= increment;
				else throw new Exception("ERROR DURING RAYCASTING: DISTANCE UNCHANGED WITH MODULATION OF T");
				newdist = GetDistFromT(a, t, a1, a2, b1, b2, c1, c2);
			}
			increment = 1;
			i = 0;
			while(Math.abs(newdist - lastdist) > 10 && i < 10)
			{
				if(newdist - lastdist > 0) t += increment;
				else if(newdist - lastdist < 0) t -= increment;
				else throw new Exception("ERROR DURING RAYCASTING: DISTANCE UNCHANGED WITH MODULATION OF T");
				newdist = GetDistFromT(a, t, a1, a2, b1, b2, c1, c2);
				i++;
			}
			increment = (float) 0.1;
			i = 0;
			while(Math.abs(newdist - lastdist) > 1 && i < 10)
			{
				if(newdist - lastdist > 0) t += increment;
				else if(newdist - lastdist < 0) t -= increment;
				else throw new Exception("ERROR DURING RAYCASTING: DISTANCE UNCHANGED WITH MODULATION OF T");
				newdist = GetDistFromT(a, t, a1, a2, b1, b2, c1, c2);
				i++;
			}
			if(newdist < (dist + 1) && GetDist(a, source) < maxdist) toReturn.add(a);
		}
		return toReturn;
	}
}
