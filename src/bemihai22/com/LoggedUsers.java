package bemihai22.com;

import java.util.concurrent.*;

class LoggedUsers {
	private ConcurrentMap<String,MessageQueue> queueTable = new ConcurrentHashMap<String,MessageQueue>();

	public void add(String userName) {
	    queueTable.put(userName, new MessageQueue());
	}
	
	public MessageQueue getQueue(String userName) {
	    return queueTable.get(userName);
	}
	
	public boolean isLogged(String userName){
		if(queueTable.containsKey(userName))
			return true;
		else return false;
	}
	
	public void logout(String userName){
		queueTable.remove(userName, queueTable.get(userName));
	}
}
