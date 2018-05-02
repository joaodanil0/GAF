package projects.GAF.nodes.messages;

import sinalgo.nodes.Position;
import sinalgo.nodes.messages.Message;

public class RoutingMessage extends Message{
	
	/**
	 * It is the identification of Sink
	 */
	public int sinkId;
	
	/**
	 * It is the position of Sink on the grid
	 */
	public Position sinkPosition;
	
	/**
	 * The identification grid
	 */	
	public int gridID;
	
	/**
	 * The identification from node that send the packet
	 */
	public int nodeID;
	
	/**
	 * Class constructor
	 * @param SinkId is the identification of Sink
	 * @param SinkPosition is the position of Sink on the grid
	 */
	public RoutingMessage(int sinkId, Position sinkPosition, int nodeID, int gridID){
		
		this.sinkId = sinkId;
		this.sinkPosition = sinkPosition;
		this.gridID = gridID;
		this.nodeID = nodeID;
	}
	@Override
	public Message clone() {
		// TODO Auto-generated method stub
		return this;
		//return new RoutingMessage(sinkId, sinkPosition, nodeID, gridID);
	}

}
