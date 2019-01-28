package mina;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;

import org.apache.sshd.client.SshClient;
import org.apache.sshd.client.session.ClientSession;
import org.apache.sshd.common.forward.PortForwardingEventListener;
import org.apache.sshd.common.session.Session;
import org.apache.sshd.common.util.net.SshdSocketAddress;
import org.apache.sshd.server.forward.AcceptAllForwardingFilter;

/**
 * This class showcase how to load a URL using apache sshd
 * @author Ankit Katiyar
 *
 */
public class TunnelMina {
	public static void main(String[] args) throws IOException {

		SshClient client = SshClient.setUpDefaultClient();
		// override any default configuration...
		/*
		 * client.setSomeConfiguration(...); client.setOtherConfiguration(...);
		 */
		client.setForwardingFilter(AcceptAllForwardingFilter.INSTANCE);
		client.start();

		// using the client for multiple sessions...
		try (ClientSession session = client.connect("username", "bastion-server-host", 22).verify(1000).getSession()) {
			session.addPasswordIdentity("devpass"); // for password-based authentication
			// or
			// session.addPublicKeyIdentity(...key-pair...); // for password-less
			// authentication
			// Note: can add BOTH password AND public key identities - depends on the
			// client/server security setup

			session.auth().verify(10000);
			// start using the session to run commands, do SCP/SFTP, create local/remote
			// port forwarding, etc...

			
			
session.addPortForwardingEventListener(new PortForwardingEventListener() {
				
				@Override
				public void establishedDynamicTunnel(Session session, SshdSocketAddress local,
						SshdSocketAddress boundAddress, Throwable reason) throws IOException {
					// TODO Auto-generated method stub
					PortForwardingEventListener.super.establishedDynamicTunnel(session, local, boundAddress, reason);
					
					System.out.println(
							"ColpMina.main(...).new PortForwardingEventListener() {...}.establishedDynamicTunnel()");
				}
			});
			
			
			SshdSocketAddress sshdSocketAddress = session
					.startDynamicPortForwarding(new SshdSocketAddress("localhost", 8000));

			System.out.println("Host: " + sshdSocketAddress.getHostName());
			System.out.println("Port: " + sshdSocketAddress.getPort());
			
			
//			ChannelDirectTcpip channel=session.createDirectTcpipChannel(new SshdSocketAddress("localhost", 8000), new SshdSocketAddress("http://10.7.65.250:9080/status/detailed", 0));
//			System.out.println("Signal:"+channel.getExitSignal());
//			Scanner reader=new Scanner(channel.getIn());
//			
//			while(reader.hasNext()) {
//				System.out.println("Data:"+reader.next());
//			}
//			reader.close();
			
			Proxy proxy = new Proxy(Proxy.Type.SOCKS, new InetSocketAddress(sshdSocketAddress.getHostName(), sshdSocketAddress.getPort()));
			HttpURLConnection connection =(HttpURLConnection)new URL("http://10.7.65.250:9080/status/detailed").openConnection(proxy);
			
			System.out.println("Proxy work:"+connection.usingProxy());
			
			
			try {
				// URL url = new URL("http://localhost:"+tunnelLocalPort+"/status/detailed");
//				URL url = new URL("http://10.7.65.250:9080/status/detailed");
//				System.out.println("Reading data from URL: " + url);
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				System.out.println("================== Data From URL ==================\n");
				String inputLine;
				while ((inputLine = in.readLine()) != null)
					System.out.println(inputLine);
				in.close();

				System.out.println("================== Data From URL ==================\n");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
