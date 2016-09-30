package us.fredb.projectspace;

public abstract class Builder<T> {
	
	/**
	 * Builds the object
	 * @return the object being built or null if it fails.
	 */
	public abstract T Build();
	
}
