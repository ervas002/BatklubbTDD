package Batklubb;

public class Boat {
	
	public Boat(BoatType a_bt, BoatSize a_bs){
		if(a_bt  == null|| a_bs  == null)
		throw new IllegalArgumentException();
	}
}