package Batklubb;

public class PaymentManager {

	public void makePayment(Member a_member, Boat a_boat) {
		BoatClubManager bcm = new BoatClubManager();
		
		if(a_member == null || a_boat == null ||
		   (!bcm.getMembersFromDatabase().contains(a_member) && !bcm.getMembers().contains(a_member)))
		{
			throw new IllegalArgumentException();
		}
		else
		{
			// Add has payed, and the date to the database.
		}
		
	}

//	public boolean HasPayed(Member a_member, Boat a_boat) {
//		
//		// CONNECT TO THE "DATABASE", CHECK IF a_member has payed for a_boat.
//		throw new IllegalArgumentException();
//	}
//	
	
	
}
