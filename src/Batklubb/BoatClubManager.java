package Batklubb;

import java.io.File;
import java.io.ObjectInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 


import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class BoatClubManager {
	
	private List<Member> m_memberList = new ArrayList<>();
	
	public List<Member> getMembers(){
		return m_memberList;
	}
	
	public void addMember(String name, String socNum){
		m_memberList.add(new Member(name, socNum));
	}
	
	//Source http://www.mkyong.com/tutorials/java-xml-tutorials/
	public void saveMembersToDatabase(){
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = null;
		Document doc = null;
		try{
			docBuilder = docFactory.newDocumentBuilder();
			doc = docBuilder.newDocument();
			Element members = doc.createElement("members");
			doc.appendChild(members);
			for(Member m : m_memberList){				
				Element member = doc.createElement("member");
				
				Element name = doc.createElement("name");
				name.appendChild(doc.createTextNode(m.getName()));
				member.appendChild(name);			
				
				Element socNum = doc.createElement("socNum");
				socNum.appendChild(doc.createTextNode(m.getSocNum()));
				member.appendChild(socNum);
				
				Element boats = doc.createElement("boats");
				for(Boat b : m.m_boats){
					Element boat = doc.createElement("boat");

					Element mooring = doc.createElement("mooring");
					mooring.appendChild(doc.createTextNode(Integer.toString(b.getMooring())));
					boat.appendChild(mooring);
					
					Element expiryDate = doc.createElement("expiryDate");
					expiryDate.appendChild(doc.createTextNode(new SimpleDateFormat().format(b.getExpiryDate())));
					boat.appendChild(expiryDate);
					
					Element boatType = doc.createElement("boatType");
					boatType.appendChild(doc.createTextNode(b.getBoatType().toString()));
					boat.appendChild(boatType);
					
					Element boatSize = doc.createElement("boatSize");
					boatSize.appendChild(doc.createTextNode(b.getBoatSize().toString()));
					boat.appendChild(boatSize);
					
					boats.appendChild(boat);
				}
				
				member.appendChild(boats);
				members.appendChild(member);
			}
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("Members.xml"));
//			StreamResult result = new StreamResult(System.out);
			transformer.transform(source, result);			
		}catch(Exception e){	
			e.printStackTrace();
		}
		
	}
	
	public List<Member> getMembersFromDatabase(){
		ArrayList<Member> mList = new ArrayList<Member>();
		File xmlFile = new File("Members.xml");
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = null;
		Document doc = null;
		try{
			docBuilder = docFactory.newDocumentBuilder();
			doc = docBuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();
			NodeList members = doc.getElementsByTagName("member");
			
			for(int i = 0; i < members.getLength(); i++){	
				Node member = members.item(i);
				if(member.getNodeType() == Node.ELEMENT_NODE){
					Element mElement = (Element)member;					
					String mName = mElement.getElementsByTagName("name").item(0).getTextContent();
					String mSocNum = mElement.getElementsByTagName("socNum").item(0).getTextContent();
					
					NodeList boats = mElement.getElementsByTagName("boats");
					Member mObject = new Member(mName, mSocNum); 
					//List<Boat> mObjectbList = new ArrayList<Boat>();
					if(boats.getLength() == 0){
						for(int y = 0; y < boats.getLength(); y++){
							Node boat = boats.item(y);
							if(boat.getNodeType() == Node.ELEMENT_NODE){
								Element bElement = (Element)boat;
								
								int mooring = Integer.parseInt(bElement.getElementsByTagName("mooring").item(0).getFirstChild().getTextContent());
								Date expiryDate = new SimpleDateFormat().parse(bElement.getElementsByTagName("expiryDate").item(0).getTextContent());
								BoatType bType = BoatType.valueOf(bElement.getElementsByTagName("boatType").item(0).getTextContent());
								BoatSize bSize = BoatSize.valueOf(bElement.getElementsByTagName("boatSize").item(0).getTextContent());
								
								Boat b = new Boat(bType, bSize);
								b.setMooring(mooring);
								b.setExpiryDate(expiryDate);
								mObject.addBoat(b);
							}
						}
					}
					mList.add(mObject);
				}
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}				
		return mList;
	}

	public void CheckAndSetMooring(Member member, Boat boat){
		if(member == null || boat == null){
			throw new IllegalArgumentException();
		}else if(!m_memberList.contains(member)){
			throw new IllegalArgumentException();
		}
		
	}
	


}
