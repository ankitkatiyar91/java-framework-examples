package mina;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.sshd.client.SshClient;
import org.apache.sshd.client.auth.hostbased.HostKeyIdentityProvider;
import org.apache.sshd.client.keyverifier.AcceptAllServerKeyVerifier;
import org.apache.sshd.client.session.ClientSession;
import org.apache.sshd.common.NamedFactory;
import org.apache.sshd.common.config.keys.loader.pem.PEMResourceParserUtils;
import org.apache.sshd.common.config.keys.loader.putty.PuttyKeyUtils;
import org.apache.sshd.common.forward.PortForwardingEventListener;
import org.apache.sshd.common.session.Session;
import org.apache.sshd.common.util.net.SshdSocketAddress;
import org.apache.sshd.server.channel.PuttyRequestHandler;
import org.apache.sshd.server.forward.AcceptAllForwardingFilter;
import org.apache.sshd.server.keyprovider.SimpleGeneratorHostKeyProvider;

/**
 * This class
 * 
 * @author Ankit Katiyar
 *
 */
public class AmazonTest {

	private static String BASTION_SERVER_PASSWORD = "P@ssword1";
	private static final String BASTION_SERVER_USER = "ec2-user";
	private static final String BASTION_SEREVR_HOST = "ec2-18-191-207-91.us-east-2.compute.amazonaws.com";
	private static final String URL_TO_ACCESS = "http://www.google.com";

	public static void main(String[] args) {

		try {
			
			
			Collection<KeyPair> keys = null;
			// OPtional loading keys from a PEM file
			//keys=PEMResourceParserUtils.getPEMResourceParserByAlgorithm("RSA").loadKeyPairs(ClassLoader.getSystemResource("local-ps-test.pem").toURI().toURL(), null);
			
			// Optional: Using Putty key for login 
			 keys=PuttyKeyUtils.DEFAULT_INSTANCE.loadKeyPairs(ClassLoader.getSystemResource("local-ps-private-key.ppk").toURI().toURL(), null);
			 
			SshClient client = SshClient.setUpDefaultClient();
			client.setForwardingFilter(AcceptAllForwardingFilter.INSTANCE);
			client.setServerKeyVerifier(AcceptAllServerKeyVerifier.INSTANCE);
			client.start();

			// using the client for multiple sessions...
			try (ClientSession session = client.connect(BASTION_SERVER_USER, BASTION_SEREVR_HOST, 22).verify()
					.getSession()) {
				// IF you use password to login provide here
				// session.addPasswordIdentity(BASTION_SERVER_PASSWORD); // for password-based
				// authentication
				
				session.addPublicKeyIdentity(keys.iterator().next());

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

						System.out.println("Dynamic Forword Tunnel is Ready");
					}
				});

				SshdSocketAddress sshdSocketAddress = session
						.startDynamicPortForwarding(new SshdSocketAddress("localhost", 8000));

				System.out.println("Host: " + sshdSocketAddress.getHostName());
				System.out.println("Port: " + sshdSocketAddress.getPort());

				// Create a Proxy object to work with
				Proxy proxy = new Proxy(Proxy.Type.SOCKS,
						new InetSocketAddress(sshdSocketAddress.getHostName(), sshdSocketAddress.getPort()));

				/**
				 * Now you can use this proxy instance into any URL until this SSH session is active. 
				 */
				
				// TEST one URL
				HttpURLConnection connection = (HttpURLConnection) new URL(URL_TO_ACCESS).openConnection(proxy);

				System.out.println("Proxy work:" + connection.getURL());

				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				System.out.println("================== Data From URL ==================\n");
				String inputLine;
				while ((inputLine = in.readLine()) != null)
					System.out.println(inputLine);
				in.close();

				System.out.println("================== Data From URL ==================\n");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
