import os
import math

num_nos = 900

density = 0.03
rangeNode = 30

area = num_nos/density;
side = int(math.sqrt(area));

#-batch	
os.system('java -cp binaries/bin sinalgo.Run\
																		\
		   -project GAF													\
		   -gen '+ str(num_nos) + ' GAF:GAF GAF:Grid C=UDG   							\
		   -gen 1  GAF:Sink GAF:Grid C=UDG								\
		   -rounds 100												\
		   -overwrite													\
		   dimX=' + str(side) + '										\
		   dimY=' + str(side) + '										\
		   GeometricNodeCollection/rMax=' + str(rangeNode) + '			\
		   UDG/rMax=' + str(rangeNode) + '								\
		   minimunTimeBetweenSends/time=60								\
		   maxEnergyOfBattery/value=1000								\
		   ')
