package tests;

import java.security.SecureRandom;

import Batklubb.Member;

public class MemberGenerator {

	
	public Member generateMember(){
		return new Member(generateValidName(), generateValidSocNumber());
	}
	
	public String generateValidName(){
		StringBuilder sb = new StringBuilder();
		SecureRandom random = new SecureRandom();
		int nameLength = 3 + random.nextInt(20);
		for(int i = 0; i < nameLength; i++){
			sb.append((char)(random.nextInt(26) + 'a'));
		}
		return sb.toString();
	}
	
	public String generateValidSocNumber(){
		StringBuilder sb = new StringBuilder();
		SecureRandom random = new SecureRandom();
		//Year
		String year = String.valueOf(1 + random.nextInt(98));
		if(year.length() < 2)
			year = "0" + year;
		sb.append(year);
		//Month
		String month = String.valueOf(1 + random.nextInt(11));
		if(month.length() < 2)
			month = "0" + month;
		sb.append(month);
		//Day
		String day = String.valueOf(1 + random.nextInt(30));
		if(day.length() < 2)
			day = "0" + day;
		sb.append(day);
		//LastFour		
		String lastFour = String.valueOf(random.nextInt(9999));
		while(lastFour.length() < 4)
			lastFour += "0";
		sb.append(lastFour);
		return sb.toString();
	}
}
