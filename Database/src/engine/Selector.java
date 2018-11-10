package engine;
import datastructure.*;
public class Selector implements engine_interface.Select{

	@Override
	public BTreeSet_interface select(BTreeSet_interface bTreeSet, Predicate_interface predicate) {
		BTreeSet_interface bt=bTreeSet;
		int node_curr=bt.first();
		int j;
		while(true) {
			if(!bt.findNode(node_curr).select(predicate)) {
				j=node_curr;
				if(node_curr==bt.last()) {
					bt.deleteNode(node_curr);
					break;
				}
				node_curr=bt.findNode(node_curr).next();
				bt.deleteNode(j);
				}
			else {
				if(node_curr==bt.last()) break;
				else node_curr=bt.findNode(node_curr).next();
			}
	}
		return bt;
	}
}
