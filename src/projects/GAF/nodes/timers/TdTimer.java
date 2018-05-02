package projects.GAF.nodes.timers;

import projects.GAF.nodes.messages.DiscoveryMessage;
import projects.GAF.nodes.nodeImplementations.GAF;
import projects.GAF.nodes.nodeImplementations.GAF.States;
import sinalgo.nodes.timers.Timer;

public class TdTimer extends Timer {
	
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
	
	/**
	 * The instance of the node that call the timer
	 */
	public GAF gaf;
	
	
	public TdTimer(int nodeID, int gridID, double enat, States state, GAF gaf, double energyRemaining) {
		
		this.nodeID = nodeID;
		this.gridID = gridID;
		this.enat = enat;
		this.state = state;
		this.gaf = gaf;
		this.energyRemaining = energyRemaining;
	}
	@Override
	public void fire() {
				
		if(this.gaf.state != States.sleep) {
			
			if(this.gaf.state == States.active) {
				this.gaf.battery.gastaEnergiaEnvio();
				DiscoveryMessage msg = new DiscoveryMessage(nodeID, gridID, enat, state, energyRemaining);			
				this.node.broadcast(msg);
			}
			
			this.gaf.state = States.active;
			this.gaf.startTdTimer = false;	
			
			
		}		
	}

}
