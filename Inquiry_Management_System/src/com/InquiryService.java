package com;
import model.Inquiry;
//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;
@Path("/Inquiry")

public class InquiryService {
	Inquiry Obj = new Inquiry();
	
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readItems()
	 {
	 return Obj.readInquiry();
	 }
	
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertcustomermanagement(@FormParam("account_no") String account_no,
	@FormParam("address") String address,
	 @FormParam("phone") String phone,
	 @FormParam("subject") String subject,
	@FormParam("message") String message )
	{
	 String output = Obj.insertinquirymanagement(account_no,address, phone, subject, message);
	return output;
	}
	
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	
	public String updateinquirymanagement(String inquiryData)
	{
	//Convert the input string to a JSON object
	 JsonObject Object = new JsonParser().parse(inquiryData).getAsJsonObject();
	 
	 //Read the values from the JSON object
	 String inquiry_id = Object.get("inquiry_id").getAsString();
	 String account_no = Object.get("account_no").getAsString();
	 String address = Object.get("address").getAsString();
	 String phone = Object.get("phone").getAsString();
	 String subject = Object.get("subject").getAsString();
	 String message = Object.get("message").getAsString();
	 
	 String output = Obj.updateinquirymanagement(inquiry_id, account_no ,address, phone, subject, message);
	return output;
	}

	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteinquirymanagement(String inquiryData)
	{
	//Convert the input string to an XML document
	 Document doc = Jsoup.parse(inquiryData, "", Parser.xmlParser());

	//Read the value from the element <itemID>
	 String inquiry_id = doc.select("inquiry_id").text();
	 String output = Obj.deleteinquirymanagement(inquiry_id);
	return output;
	}

	
}
