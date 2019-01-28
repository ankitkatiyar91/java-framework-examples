package jsch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.UserInfo;

public class TunnelJSCH {
	public static void main(String[] args) {
		TunnelJSCH t = new TunnelJSCH();
		try {
			t.go();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void go() throws Exception {
		String host = "bastion-server-host";
		String user = "username";
		String password = "password";
		int port = 22;

		int tunnelLocalPort = 8000;
		String tunnelRemoteHost = "remote-host";
		int tunnelRemotePort = 9080;

		JSch jsch = new JSch();
		Session session = jsch.getSession(user, host, port);
		session.setPassword(password);
		localUserInfo lui = new localUserInfo();
		session.setUserInfo(lui);
		System.out.println("Creating connection to server:" + host);
		session.connect();
		System.out.println("Connected to server, initializing Port forwarding ");
		session.setPortForwardingL(tunnelLocalPort, tunnelRemoteHost, tunnelRemotePort);
		
		System.out.println("Port forward successful forwarding: localhost:" + tunnelLocalPort + " -> "
				+ tunnelRemoteHost + ":" + tunnelRemotePort);

		try {

			URL url = new URL("http://localhost:8000");
			System.out.println("Reading data from URL: " + url);
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			System.out.println("================== Data From URL ==================\n");
			String inputLine;
			while ((inputLine = in.readLine()) != null)
				System.out.println(inputLine);
			in.close();

			System.out.println("================== Data From URL ==================\n");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (session != null && session.isConnected()) {
			System.out.println("Closing SSH Connection");
			session.disconnect();
		}

	}

	class localUserInfo implements UserInfo {
		String passwd;

		public String getPassword() {
			return passwd;
		}

		public boolean promptYesNo(String str) {
			return true;
		}

		public String getPassphrase() {
			return null;
		}

		public boolean promptPassphrase(String message) {
			return true;
		}

		public boolean promptPassword(String message) {
			return true;
		}

		public void showMessage(String message) {
		}
	}
}
