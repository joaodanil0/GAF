package projects.GAF.nodes.nodeImplementations;

import sinalgo.configuration.Configuration;
import sinalgo.configuration.WrongConfigurationException;
import sinalgo.gui.transformation.PositionTransformation;
import sinalgo.nodes.Node;
import sinalgo.nodes.messages.Inbox;
import sinalgo.nodes.messages.Message;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import projects.GAF.nodes.messages.DataMessage;
import projects.GAF.nodes.timers.FloodingTimer;

public class Sink extends Node{

	
	/**
	 * Save the id messages received
	 */
	public ArrayList<Integer>idMessages = new ArrayList<>();
	
	
	
	@Override
	public void handleMessages(Inbox inbox) {
		
		while(inbox.hasNext()) {
			
			Message msg = inbox.next();	
			
			if(msg instanceof DataMessage) {
				
				processDataMessage((DataMessage) msg);
			}
		}
	}	

	@Override
	public void preStep() {
		
	}

	@Override
	/**
	 * Send a flooding package to network with the Sink position
	 */
	public void init() {
				setSinkPosition();
				
		FloodingTimer t = new FloodingTimer(ID, getPosition(), ID, 0, null);
		t.startRelative(1, Sink.this);
	}

	@Override
	public void neighborhoodChange() {
		
	}

	@Override
	public void postStep() {
	}

	@Override
	public void checkRequirements() throws WrongConfigurationException {
		
	}
	
	public void draw(Graphics g, PositionTransformation pt, boolean highlight){
		
		drawNodeAsSquareWithText(g, pt, highlight, "", 2, Color.WHITE);
		setColor(Color.RED);		
	}

	//----------------------------------------------------------------------------
	//
	//					Custom methods			
	//
	//----------------------------------------------------------------------------
	
	/**
	 * Set the sink position in the mid of grid
	 */
	private void setSinkPosition() {
		setPosition(Configuration.dimX/2,Configuration.dimY/2,0);
	}
	
	/**
	 * Check if the idMessage is save  in the list
	 * @param idMessage Message to be checked
	 * @return True if packet received, False if not received
	 */
	public boolean isPcktReceived(int idMessage) {
		
		for(int i = 0; i< idMessages.size(); i++){			
			
			if(idMessages.get(i) == idMessage ){
				
				return true;
			}
		}
		return false;	
	}
	
	private void processDataMessage(DataMessage msg) {
		
		if(!isPcktReceived(msg.idMessage)){
			
			
			idMessages.add(msg.idMessage);
						
		}
		
	}

	
}
