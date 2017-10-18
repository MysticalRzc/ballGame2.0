package messageBuffer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;


public class MessageBuffer {
	final private Map<String,Queue> messBuffer = new HashMap<String,Queue>();
	
	
	public int getSize()
	{
		return messBuffer.size();
	}
	public void setMessage(String mesId,String message)
	{
		System.out.println("MessageBuffer receive£º " + message);
		if(!messBuffer.containsKey(mesId))
		{
			messBuffer.put(mesId, new LinkedList<String>());
		}
		messBuffer.get(mesId).add(message);
	}
	public String getMessage(String mesId)
	{
		String message;
		
		if(!messBuffer.containsKey(mesId))
			return null;
		message = (String) messBuffer.get(mesId).poll();		
		return message;
	}
	
}