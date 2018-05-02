package projects.GAF.nodes.timers;

import projects.GAF.nodes.messages.DataMessage;
import projects.GAF.nodes.nodeImplementations.GAF;
import projects.GAF.nodes.nodeImplementations.GAF.States;
import sinalgo.nodes.timers.Timer;

public class TaTimer extends Timer {

	/**
	 * The instance of the node that call the timer
	 */
	public GAF gaf;
	
	public TaTimer(GAF gaf) {
		
		this.gaf = gaf;
	}

	@Override
	public void fire() {
				
		if(this.gaf.state == States.active) {
			
			int idMessage = Integer.parseInt(this.gaf.ID + "" + this.gaf.dataPctSent++);
			
			DataMessage msg = new DataMessage(this.gaf.ID, this.gaf.sinkDistance, idMessage, this.gaf.gridID);
			this.node.broadcast(msg);
			this.gaf.battery.gastaEnergiaEnvio();
			this.gaf.state = States.discovery;
			this.gaf.startTaTimer = false;	
		}
		
		
		
	}

}
