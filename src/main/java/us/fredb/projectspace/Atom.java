package us.fredb.projectspace;

/**
 * @author Fred Buchanan
 *
 * This class represents any physical object in space.
 *
 * ps. All of these things are methods so they can later be stored in a database.
 */
public abstract class Atom {
	
	/**
	 * @return The unique ID of this Atom
	 */
	public abstract String GetId();
	/**
	 * Should rarely be called.
	 * @param id The new unique ID.
	 */
	public abstract void SetId(String id);
	
	/**
	 * Should rarely be called.
	 * @return the key used form authentication of this atom.
	 */
	public abstract String GetKey();
	/**
	 * @param key The new key used for authentication.
	 */
	public abstract void SetKey(String key);
	
	/**
	 * @return The X Position of the Atom
	 */
	public abstract float GetXPos();
	/**
	 * @param x The new X Position of the Atom
	 */
	public abstract void SetXPos(float x);
	
	/**
	 * @return The Y Position of the Atom
	 */
	public abstract float GetYPos();
	/**
	 * @param y The new Y Position of the Atom
	 */
	public abstract void SetYPos(float y);
	
	/**
	 * @return The Z Position of the Atom
	 */
	public abstract float GetZPos();
	/**
	 * @param z The new Z Position of the Atom
	 */
	public abstract void SetZPos(float z);
	
	
	/**
	 * @return The X Velocity of the Atom
	 */
	public abstract float GetXVel();
	/**
	 * @param x The new X Velocity of the Atom
	 */
	public abstract void SetXVel(float x);
	
	/**
	 * @return The Y Velocity of the Atom
	 */
	public abstract float GetYVel();
	/**
	 * @param y The new Y Velocity of the Atom
	 */
	public abstract void SetYVel(float y);
	
	/**
	 * @return The Z Velocity of the Atom
	 */
	public abstract float GetZVel();
	/**
	 * @param z The new Z Velocity of the Atom
	 */
	public abstract void SetZVel(float z);
	
	/**
	 * @return The X Acceleration of the Atom
	 */
	public abstract float GetXAcc();
	/**
	 * @param x The new X Acceleration of the Atom
	 */
	public abstract void SetXAcc(float x);
	
	/**
	 * @return The Y Acceleration of the Atom
	 */
	public abstract float GetYAcc();
	/**
	 * @param y The new Y Acceleration of the Atom
	 */
	public abstract void SetYAcc(float y);
	
	/**
	 * @return The Z Acceleration of the Atom
	 */
	public abstract float GetZAcc();
	/**
	 * @param z The new Z Acceleration of the Atom
	 */
	public abstract void SetZAcc(float z);
	
	//Real Methods---------------------------------------------------------
	
	/**
	 * Updates the object based on physics.
	 * Should be called once per tick.
	 * @param deltaTime The times since the last tick.
	 */
	public void Update(float deltaTime)
	{
		//Update Velocity based on Acceleration
		this.SetXVel( (this.GetXVel() + this.GetXAcc()) * deltaTime );	//x
		this.SetYVel( (this.GetYVel() + this.GetYAcc()) * deltaTime );	//y
		this.SetZVel( (this.GetZVel() + this.GetZAcc()) * deltaTime );	//z
		
		//Update Position based of Velocity
		this.SetXPos( (this.GetXPos() + this.GetXVel()) * deltaTime);	//x
		this.SetYPos( (this.GetYPos() + this.GetYVel()) * deltaTime);	//y
		this.SetZPos( (this.GetZPos() + this.GetZVel()) * deltaTime);	//z
	}

}
