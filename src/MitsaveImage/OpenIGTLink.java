package src.MitsaveImage;

import java.util.Collections;
import java.util.LinkedList;

import org.medcare.igtl.messages.ImageMessage;
import org.medcare.igtl.network.GenericIGTLinkClient;
import org.medcare.igtl.network.IOpenIgtPacketListener;
import org.medcare.igtl.util.Status;

import com.neuronrobotics.sdk.addons.kinematics.math.TransformNR;
import com.neuronrobotics.sdk.common.Log;

import Jama.Matrix;


public class OpenIGTLink extends Thread implements IOpenIgtPacketListener {

	private GenericIGTLinkClient client;
	
	protected ImageMessage imageMessage;
	protected String name;
	
	protected Matrix mat;
	
	protected byte[] b;
	
	public OpenIGTLink(String ipAddress, int port) {

		try {
			Log.enableDebugPrint(false);
			Log.enableSystemPrint(false);

			Log.debug("Starting client");
			client = new GenericIGTLinkClient(ipAddress, port);

			client.addIOpenIgtOnPacket(this);
			

			// while (exit == true) {
			// Thread.sleep(1000);
			//
			//
			// }

			// client.stopClient();
			// Log.debug("Client disconnected");
			// System.exit(0);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Override
	public void onRxImage(String name, ImageMessage image) {
		imageMessage = image;
		this.name = name;
		
		
		
	}

	@Override
	public void onRxTransform(String name, TransformNR t) {
		// TODO Auto-generated method stub
		System.out.println("9");
		
		
	}

	@Override
	public TransformNR getTxTransform(String name) {
		// TODO Auto-generated method stub
		System.out.println("8");
		
		return null;
	}

	@Override
	public Status onGetStatus(String name) {
		// TODO Auto-generated method stub
		System.out.println("7");
		
		return null;
	}

	@Override
	public void onRxString(String name, String body) {
		// TODO Auto-generated method stub
		System.out.println("6");
			
	}

	@Override
	public String onTxString(String name) {
		System.out.println("5");
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onRxDataArray(String name, Matrix data) {
		System.out.println("1");
		
	}

	@Override
	public double[] onTxDataArray(String name) {
		// TODO Auto-generated method stub
		System.out.println("2");
		
		return null;
	}


	@Override
	public void onTxNDArray(String name) {
		// TODO Auto-generated method stub
		System.out.println("3");
		
		
	}

	@Override
	public void onRxNDArray(String name, float[] data) {
		// TODO Auto-generated method stub
		System.out.println("4");
		
	}
	
	

}
