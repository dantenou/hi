package engine;
import datastructure.*;
public class Limiter implements engine_interface.Limit{

	@Override
	public BTreeSet_interface limit(BTreeSet_interface bTreeSet, int limit) {
		BTreeSet_interface bt=bTreeSet;
		int i=0;
		Node_interface node=bt.findNode(bt.first());
		while(true) {
			node=node.nextNode();
			i++;
			if(node==null) {
				break;
			}
			else if(i>=limit) {
				bt.deleteNode(node.getIndex());
			}
		}
		return bt;
}
}
