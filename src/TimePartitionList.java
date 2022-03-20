import java.util.ArrayList;
import java.util.Collections;

public class TimePartitionList {

	private ArrayList<Integer> deletedInstances;
	private int startTime, endTime;
	
	public TimePartitionList(int t, int startTime, int endTime) {
		this.deletedInstances = new ArrayList<Integer>();
		this.startTime = startTime;
		this.endTime = endTime;
		removeInstant(t);

	}
	
	public void removeInstant(int t) {
		deletedInstances.add(t);
	}
	
	public ArrayList<DeltaEdge> getAllDeltaIntervals(int delta) {
		ArrayList<DeltaEdge> response = new ArrayList<>();
		int ninstants = deletedInstances.size();
		Collections.sort(deletedInstances);
		if(deletedInstances.get(0) - startTime >= delta) response.add(new DeltaEdge(startTime, deletedInstances.get(0) - 1, null, null));
		for(int i=0; i<ninstants-2;i++) {
			if(deletedInstances.get(i+1) - deletedInstances.get(i) >= delta) response.add(new DeltaEdge(deletedInstances.get(i)+1, deletedInstances.get(i+1)-1, null, null));
		}
		if(endTime - deletedInstances.get(ninstants-1) >= delta) response.add(new DeltaEdge(deletedInstances.get(ninstants-1) + 1, endTime, null, null));
        return response;
	}
	
}
