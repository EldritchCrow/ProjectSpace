package us.fredb.projectspace;

import junit.framework.TestCase;

public class AtomTests extends TestCase {
	
	/**
	 * Test that atoms can be instantiated.
	 */
	public void testAtomCreation() {
		Atom testAtom = new MemoryAtom();
		assertNotNull(testAtom);
	}
	
	/**
	 * Test that the update methods moves the object appropriately.
	 */
	public void testAtomsUpdate() {
		Atom testAtom = new MemoryAtom();
		testAtom.SetXAcc(1F);
		
		//Do update
		testAtom.Update(1F);
		
		//The atoms should be moved 1 forward
		assertEquals(1F, testAtom.GetXPos());
	}

}
