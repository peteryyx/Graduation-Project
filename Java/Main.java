import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main implements Runnable{
	
	public int port;
	
	public Main(int port) {
		this.port = port;
	}
	
	public static void main(String[] args) {
		Main m = new Main(9050);
		m.run();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			ServerSocket server = new ServerSocket(port);
			while(true) {
				System.out.println("waiting...");
				Socket socket = server.accept();
				DataInputStream d = new DataInputStream(socket.getInputStream());
				String string = d.readUTF();
				System.out.println("client:"+string);
				DataOutputStream out = new DataOutputStream(socket.getOutputStream());
				if(string=="�ͻ�����������") {
					out.write(1);
					socket.close();
					continue;
				}
				out.writeUTF("������socket����"+string);
				socket.close();
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
