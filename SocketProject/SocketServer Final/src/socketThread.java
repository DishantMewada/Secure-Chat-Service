

public class socketThread implements Runnable{
	String Myname = null;
	
	public socketThread(String Myname) {
		this.Myname = Myname;
	}
	public void clientThread(String Myname){
		SocketServer ss = new SocketServer(Myname);
	}
	
	@Override
	public void run() {
		clientThread(Myname);		
	}

}
