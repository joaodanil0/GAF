/*
PP Copyright (c) 2007, Distributed Computing Group (DCG)
                    ETH Zurich
                    Switzerland
                    dcg.ethz.ch

 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions
 are met:

 - Redistributions of source code must retain the above copyright
   notice, this list of conditions and the following disclaimer.

 - Redistributions in binary form must reproduce the above copyright
   notice, this list of conditions and the following disclaimer in the
   documentation and/or other materials provided with the
   distribution.

 - Neither the name 'Sinalgo' nor the names of its contributors may be
   used to endorse or promote products derived from this software
   without specific prior written permission.

 THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package projects.GAF.models.distributionModels;


import java.util.Random;

import sinalgo.configuration.Configuration;
import sinalgo.models.DistributionModel;
import sinalgo.nodes.Position;

/**
 * Aligns the nodes about equally spaced on a gird covering the entire deployment area.
 */
public class Grid extends DistributionModel {

  private double size; // the cell-size of the gird
  private int numNodesPerLine; // number of nodes on the x-axis
  private boolean start = true;
  private int i,j; // loop counters
	
  private Random pertuba = new Random();
	
  /* (non-Javadoc)
   * @see sinalgo.models.DistributionModel#initialize()
   */
  public void initialize() {
		
  	size = (Configuration.dimX / (Math.sqrt(numberOfNodes)-1));
  	numNodesPerLine = (int) Math.round(Configuration.dimX / size); 
		
  	i=0;
  	j=0;
  }
	
  /* (non-Javadoc)
   * @see models.DistributionModel#getNextPosition()
   */
  public Position getNextPosition() {
		
  	i ++;
  	if(i > numNodesPerLine) {
  		start = true;
  		i=1; 	
  		j ++;
  	}
		
  	if(start) {
  		i = 0;
  		start = false;
			
  	}			
	return new Position(i * size + (pertuba.nextGaussian()), j * size + (pertuba.nextGaussian()), 0);
  }
	
	
}
