package PojoConcept;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class OutputPayload {
	
	// This class is just for demo purpose.

	public static void main(String[] args) throws JsonProcessingException {

		IssueType issue=new IssueType("Task");
		Projects project=new Projects("Project_name");
		Payload internalload=new Payload("Summary Demo", " Demo Description", issue, project);
		
		Fields finalload=new Fields(internalload);
		System.out.println(issue);
				
		ObjectMapper objMap=new ObjectMapper();
		String data=objMap.writerWithDefaultPrettyPrinter().writeValueAsString(finalload);                 
		System.out.println(data);
	}
}
