package projects.GAF.nodes.timers;

import projects.GAF.nodes.messages.RoutingMessage;
import projects.GAF.nodes.nodeImplementations.GAF;
import sinalgo.nodes.Position;
import sinalgo.nodes.timers.Timer;

public class FloodingTimer extends Timer {
	
	/**
	 * It is the identification of Sink
	 */
	private int sinkId;
	
	/**
	 * It is the position of Sink on the grid
	 */
	private Position sinkPosition;
	
	/**
	 * The identification grid
	 */	
	public int gridID;
	
	/**
	 * The identification from node that send the packet
	 */
	public int nodeID;
	
	/**
	 * Instance of node that send packet
	 */
	public GAF gaf;
	
	/**
	 * Class constructor
	 * @param gaf 
	 * @param SinkId is the identification of Sink
	 * @param SinkPosition is the position of Sink on the grid
	 */
	public FloodingTimer(int sinkId, Position sinkPosition, int nodeID, int gridID, GAF gaf){
		this.sinkId = sinkId;
		this.sinkPosition = sinkPosition;
		this.gridID = gridID;
		this.nodeID = nodeID;
		this.gaf = gaf;
	}
	
	@Override
	public void fire() {
		// TODO Auto-generated method stub
		
		RoutingMessage msg = new RoutingMessage(sinkId, sinkPosition, nodeID, gridID);
		this.node.broadcast(msg);
		if(gaf != null)
			this.gaf.battery.gastaEnergiaEnvio();
		
	}

}
