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
	BorgarB�t,
	RPB,
	Canoe,
	FBGB
}

enum BoatSize{
	SMALL,
	MEDIUM,
	LARGE
}