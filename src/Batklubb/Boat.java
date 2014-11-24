package Batklubb;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Boat {

	// Variables
	private int m_mooring = 0;
	private Date m_expiryDate;
	private BoatType m_boatType;
	private BoatSize m_boatSize;

	// Construct
	public Boat(BoatType a_bt, BoatSize a_bs) {
		if (a_bt == null || a_bs == null)
			throw new IllegalArgumentException();

		m_boatType = a_bt;
		m_boatSize = a_bs;
	}

	// Gets And Sets
	public BoatType getBoatType() {
		return m_boatType;
	}

	public BoatSize getBoatSize() {
		return m_boatSize;
	}

	public void setMooring(int a_mooring) {
		if (a_mooring < 1)
			throw new IllegalArgumentException();
		m_mooring = a_mooring;

		Calendar c = new GregorianCalendar();
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR) + 1);
		m_expiryDate = c.getTime();
	}

	public int getMooring() {
		if (m_mooring > 0) {
			return m_mooring;
		}
		throw new NullPointerException();
	}

	public Date getExpiryDate() {
		if (m_expiryDate == null)
			throw new NullPointerException();

		return m_expiryDate;
	}

}