package socketclient;

public class socketThread implements Runnable {
	String Myname = null;

	public socketThread(String Myname) {
		this.Myname = Myname;
	}

	public void clientThread(String Myname) {
		SocketClient sc = new SocketClient(Myname);
	}

	@Override
	public void run() {
		clientThread(Myname);
	}

}
