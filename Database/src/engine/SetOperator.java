package engine;

import java.util.ArrayList;

import datastructure.BTreeSet;
import datastructure.BTreeSet_interface;
import datastructure.Node_interface;
import datastructure.Predicate_interface;
import engine_interface.*;

/**
 * ���������ʵ�ּ�������Ľ���������
 * 
 * @author ligmh
 *
 */
public class SetOperator implements SetOperate {
	// ����һЩ������������
	public static final int INTERSECT = 0;
	public static final int UNION = 1;
	public static final int EXPEPT = 2;

	// ��Ա��������
	BTreeSet_interface bTreeSetResult = new BTreeSet();

	@Override
	public BTreeSet_interface intersect(BTreeSet_interface bTreeSet1, BTreeSet_interface bTreeSet2) {
		// ��������

		// �����ж�����������ǲ���һ����
		if (!checkColunm(bTreeSet1, bTreeSet2))
			return null;
		// ����������Ľ�����
		bTreeSetResult = calcutate(bTreeSet1, bTreeSet2, INTERSECT);

		return bTreeSetResult;
	}

	@Override
	public BTreeSet_interface union(BTreeSet_interface bTreeSet1, BTreeSet_interface bTreeSet2) {
		// ��������

		// �����ж�����������ǲ���һ����
		if (!checkColunm(bTreeSet1, bTreeSet2))
			return null;

		// ����������Ĳ�����
		bTreeSetResult = calcutate(bTreeSet1, bTreeSet2, UNION);
		return bTreeSetResult;
	}

	@Override
	public BTreeSet_interface except(BTreeSet_interface bTreeSet1, BTreeSet_interface bTreeSet2) {
		// ��������

		// �����ж�����������ǲ���һ����
		if (!checkColunm(bTreeSet1, bTreeSet2))
			return null;

		// ���б�Ĳ�����
		bTreeSetResult = calcutate(bTreeSet1, bTreeSet2, EXPEPT);

		return bTreeSetResult;
	}

	/**
	 * �����ж������������ǲ�����ͬ��
	 * 
	 * @param bTreeSet1
	 * @param bTreeSet2
	 * @return ����ֵ�ǲ�������,��������������ͬ��ʱ�򷵻�true
	 */
	private boolean checkColunm(BTreeSet_interface bTreeSet1, BTreeSet_interface bTreeSet2) {
		ArrayList<String> arr1 = bTreeSet1.showAllColumn();
		ArrayList<String> arr2 = bTreeSet2.showAllColumn();

		if (arr1.size() != arr2.size())
			return false;
		else {
			for (int i = 0; i < arr1.size(); i++) {
				if (!arr1.get(i).equals(arr2.get(i))) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * ������������жϴ������������ڵ��е������ǲ�����ͬ��
	 * 
	 * @param Node1
	 * @param Node2
	 * @param columnNumber
	 * @return
	 */
	private boolean isTwoLinesSame(Node_interface Node1, Node_interface Node2, int columnNumber) {
		for (int i = 0; i < columnNumber; i++) {
			if (Node1.getValues(i) != Node2.getValues(i)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * �������������
	 * 
	 * @param bTreeSet1����ǵ�һ����
	 * @param bTreeSet2�ڶ�����
	 * @param signal������ʶ��ǰ����������
	 * @return ����ֵ������Ľ����
	 */
	private BTreeSet_interface calcutate(BTreeSet_interface bTreeSet1, BTreeSet_interface bTreeSet2, int signal) {

		// ��������
		int tree1NodeCount = bTreeSet1.getCount();// ���ȷֱ�õ���������node����Ŀ
		int tree2NodeCount = bTreeSet2.getCount();
		int columnCount = bTreeSet1.showAllColumn().size();// �õ�����
		BTreeSet_interface bTreeSetResult = new BTreeSet();// ��������

		// ���м���
		if (signal == INTERSECT) {//
			for (int i = 0; i < tree1NodeCount; i++) {
				for (int j = 0; j < tree2NodeCount; j++) {
					Node_interface tree1Node = bTreeSet1.findNode(i);
					Node_interface tree2Node = bTreeSet2.findNode(j);
					if (isTwoLinesSame(tree1Node, tree2Node, columnCount)) {
						bTreeSetResult.addNode((ArrayList<Object>) tree1Node);
					}
				}
			}

		} else if (signal == UNION) {
			bTreeSetResult = bTreeSet1;// ���Ƚ���һ�������Ƶ��������ȥ
			// Ȼ���ٰѵڶ��������µĽڵ���뵽�������
			for (int i = 0; i < tree2NodeCount; i++) {
				Node_interface tree2Node = bTreeSet2.findNode(i);
				boolean flag = true;
				for (int j = 0; j < tree1NodeCount; j++) {
					Node_interface tree1Node = bTreeSet1.findNode(j);
					if (isTwoLinesSame(tree1Node, tree2Node, columnCount)) {
						flag = false;
						break;
					}
				}
				if (flag) {
					bTreeSetResult.addNode((ArrayList<Object>) tree2Node);
				}
			}

		} else {
			for (int i = 0; i < tree1NodeCount; i++) {
				Node_interface tree1Node = bTreeSet1.findNode(i);

				boolean flag = true;// �ж������ѭ���Ƿ�break�ˣ����break�˾Ͱ����flag����Ϊfalse
				for (int j = 0; j < tree2NodeCount; j++) {
					Node_interface tree2Node = bTreeSet1.findNode(j);
					if (isTwoLinesSame(tree1Node, tree2Node, columnCount)) {
						flag = false;
						break;
					}
				}
				if (flag) {
					bTreeSetResult.addNode((ArrayList<Object>) tree1Node);
				}
			}
		}
		return bTreeSetResult;
	}

}
