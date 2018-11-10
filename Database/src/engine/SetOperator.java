package engine;

import java.util.ArrayList;

import datastructure.BTreeSet;
import datastructure.BTreeSet_interface;
import datastructure.Node_interface;
import datastructure.Predicate_interface;
import engine_interface.*;

/**
 * 这个类用来实现集合运算的交、并、差
 * 
 * @author ligmh
 *
 */
public class SetOperator implements SetOperate {
	// 定义一些常量代表交并差
	public static final int INTERSECT = 0;
	public static final int UNION = 1;
	public static final int EXPEPT = 2;

	// 成员变量定义
	BTreeSet_interface bTreeSetResult = new BTreeSet();

	@Override
	public BTreeSet_interface intersect(BTreeSet_interface bTreeSet1, BTreeSet_interface bTreeSet2) {
		// 变量定义

		// 首先判断两个表的列是不是一样的
		if (!checkColunm(bTreeSet1, bTreeSet2))
			return null;
		// 进行两个表的交运算
		bTreeSetResult = calcutate(bTreeSet1, bTreeSet2, INTERSECT);

		return bTreeSetResult;
	}

	@Override
	public BTreeSet_interface union(BTreeSet_interface bTreeSet1, BTreeSet_interface bTreeSet2) {
		// 变量定义

		// 首先判断两个表的列是不是一样的
		if (!checkColunm(bTreeSet1, bTreeSet2))
			return null;

		// 进行两个表的并运算
		bTreeSetResult = calcutate(bTreeSet1, bTreeSet2, UNION);
		return bTreeSetResult;
	}

	@Override
	public BTreeSet_interface except(BTreeSet_interface bTreeSet1, BTreeSet_interface bTreeSet2) {
		// 变量定义

		// 首先判断两个表的列是不是一样的
		if (!checkColunm(bTreeSet1, bTreeSet2))
			return null;

		// 进行表的差运算
		bTreeSetResult = calcutate(bTreeSet1, bTreeSet2, EXPEPT);

		return bTreeSetResult;
	}

	/**
	 * 用来判断两个树的列是不是相同的
	 * 
	 * @param bTreeSet1
	 * @param bTreeSet2
	 * @return 返回值是布尔变量,当两个树的列相同的时候返回true
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
	 * 这个函数用来判断传进来的两个节点中的数据是不是相同的
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
	 * 这个类用来计算
	 * 
	 * @param bTreeSet1这个是第一个树
	 * @param bTreeSet2第二个树
	 * @param signal用来标识当前是哪种运算
	 * @return 返回值是运算的结果树
	 */
	private BTreeSet_interface calcutate(BTreeSet_interface bTreeSet1, BTreeSet_interface bTreeSet2, int signal) {

		// 变量定义
		int tree1NodeCount = bTreeSet1.getCount();// 首先分别得到两个树中node的数目
		int tree2NodeCount = bTreeSet2.getCount();
		int columnCount = bTreeSet1.showAllColumn().size();// 得到列数
		BTreeSet_interface bTreeSetResult = new BTreeSet();// 定义结果树

		// 进行计算
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
			bTreeSetResult = bTreeSet1;// 首先将第一个树复制到结果树中去
			// 然后再把第二个树中新的节点加入到结果树中
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

				boolean flag = true;// 判断下面的循环是否break了，如果break了就把这个flag设置为false
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
