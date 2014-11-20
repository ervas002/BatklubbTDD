package Batklubb;

public class Boat {

	
	private BoatType m_boatType;
	private BoatSize m_boatSize;

	public Boat(BoatType a_bt, BoatSize a_bs) {
		if (a_bt == null || a_bs == null)
			throw new IllegalArgumentException();

		m_boatType = a_bt;
		m_boatSize = a_bs;
	}

	public BoatType getBoatType() {
		return m_boatType;
	}

	public BoatSize getBoatSize() {
		return m_boatSize;
	}

	public void setMooring(int a_mooring) {
		if(a_mooring < 1)
			throw new IllegalArgumentException();		
	}
}