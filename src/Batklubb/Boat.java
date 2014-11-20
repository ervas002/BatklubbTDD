package Batklubb;

public class Boat {
	public Boat(){
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