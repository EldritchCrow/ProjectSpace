package us.fredb.projectspace;

public class MemoryAtom extends Atom {
	
	private int Id;
	private String Key;
	
	private float XPos;
	private float YPos;
	private float ZPos;
	
	private float XVel;
	private float YVel;
	private float ZVel;
	
	private float XAcc;
	private float YAcc;
	private float ZAcc;
	

	@Override
	public int GetId() {
		return this.Id;
	}

	@Override
	public void SetId(int id) {
		this.Id = id;
	}

	@Override
	public String GetKey() {
		return this.Key;
	}

	@Override
	public void SetKey(String key) {
		this.Key = key;

	}

	@Override
	public float GetXPos() {
		return this.XPos;
	}

	@Override
	public void SetXPos(float x) {
		this.XPos = x;

	}

	@Override
	public float GetYPos() {
		return this.YPos;
	}

	@Override
	public void SetYPos(float y) {
		this.YPos = y;
	}

	@Override
	public float GetZPos() {
		return this.ZPos;
	}

	@Override
	public void SetZPos(float z) {
		this.ZPos = z;
	}

	@Override
	public float GetXVel() {
		return this.XVel;
	}

	@Override
	public void SetXVel(float x) {
		this.XVel = x;

	}

	@Override
	public float GetYVel() {
		return this.YVel;
	}

	@Override
	public void SetYVel(float y) {
		this.YVel = y;
	}

	@Override
	public float GetZVel() {
		return this.ZVel;
	}

	@Override
	public void SetZVel(float z) {
		this.ZVel = z;

	}

	@Override
	public float GetXAcc() {
		return this.XAcc;
	}

	@Override
	public void SetXAcc(float x) {
		this.XAcc = x;
	}

	@Override
	public float GetYAcc() {
		return this.YAcc;
	}

	@Override
	public void SetYAcc(float y) {
		this.YAcc = y;
	}

	@Override
	public float GetZAcc() {
		return this.ZAcc;
	}

	@Override
	public void SetZAcc(float z) {
		this.ZAcc = z;
	}

}
