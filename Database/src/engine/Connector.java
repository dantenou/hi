package engine;
import java.util.ArrayList;

import datastructure.BTreeSet_interface;
import datastructure.Node_interface;
import engine_interface.*;
import datastructure.*;
public class Connector implements Connect{

	@Override
	public BTreeSet_interface cartesian(BTreeSet_interface bTreeSet1, BTreeSet_interface bTreeSet2) {
		BTreeSet_interface bt=new BTreeSet();
		
		return null;
	}

	@Override
	public BTreeSet_interface natural(BTreeSet_interface bTreeSet1, BTreeSet_interface bTreeSet2) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public BTreeSet_interface outer(BTreeSet_interface bTreeSet1, BTreeSet_interface bTreeSet2, boolean full,
			boolean left) {
		// TODO �Զ����ɵķ������
		return null;
	}

}
