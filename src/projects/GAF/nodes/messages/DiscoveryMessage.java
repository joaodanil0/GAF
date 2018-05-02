package projects.GAF.nodes.messages;

import projects.GAF.nodes.nodeImplementations.GAF.States;
import sinalgo.nodes.messages.Message;

public class DiscoveryMessage extends Message{
	
	/**
	 * Identification of node that send the message
	 */
	public int nodeID;
	
	/**
	 * Identification of grid from the node that send the message
	 */
	public int gridID;
	
	/**
	 * Estimation node active time
	 */
	public double enat;
	
	/**
	 * The state of the node that send the message
	 */
	public States state;
	
	/**
	 * The energy remaining of node that send the message
	 */
	public double energyRemaining;
	
	
	public DiscoveryMessage(int nodeID, int gridID, double enat, States state, double energyRemaining) {
		
		this.nodeID = nodeID;
		this.gridID = gridID;
		this.enat = enat;
		this.state = state;	
		this.energyRemaining = energyRemaining;
	}
	
	@Override
	public Message clone() {
		// TODO Auto-generated method stub
		return this;
	}

}
