package Batklubb;

public class Boat {
	public Boat(){
		throw new IllegalArgumentException();
	}
	public Boat(BoatType a_bt, BoatSize a_bs){
		if(a_bt  == null|| a_bs  == null)
		throw new IllegalArgumentException();
	}
}

enum BoatType{
	SailBoat,
	MotorBoatTits,
	RowBoat,
	Yacht,
	BorgarBåt,
	RPB,
	Canoe,
	FBGB
}

enum BoatSize{
	SMALL,
	MEDIUM,
	LARGE
}