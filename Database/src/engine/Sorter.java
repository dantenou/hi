package engine;

import java.util.ArrayList;

import datastructure.BTreeSet;
import datastructure.BTreeSet_interface;
import datastructure.Node_interface;
import engine_interface.*;

/**
 * 这个类主要用来实现排序
 * 
 * @author ligmh
 *
 */
public class Sorter implements Sort {

	/**
	 * 假如是违法的输入，则返回null
	 */
	@Override
	public BTreeSet_interface sort(BTreeSet_interface bTreeSet, boolean asc, int... index) {

		// 变量定义
		BTreeSet_interface bTreeSetCopy = bTreeSet;// 这里把传过来的b树复制到bTreeSetCopy中
		ArrayList<String> allColumn = bTreeSetCopy.showAllColumn();// 这里是将所有的列的名称都取到
		int columnCount = allColumn.size();// 获得总共有多少个列
		ArrayList<Node_interface> allNodes = new ArrayList<Node_interface>();

		// 下面的循环用于判断输入的列号是不是超过了表中最大的列号
		for (int i = 0; i < index.length; i++) {
			if (index[i] >= columnCount) {
				System.out.println("没有您输入的列号！");
				return null;
			}
		}

		Node_interface node = bTreeSetCopy.findNode(bTreeSetCopy.first());// 这里用来获取第一个node

		// 这里的这个循环用来遍历整个b树，将所有的node节点装进allNodes中
		while (node.nextNode() != null) {
			allNodes.add(node);
			node = node.nextNode();
		}

		// 这里对上面得到的allNodes中的node数据进行排序
		if (asc) {// 这里表示的是升序
			allNodes.sort(null);// 这里还有待研究
			return restoreAllNodes(allNodes);
		} else {// 这里表示的是降序
			allNodes.sort(null);
			return restoreAllNodes(allNodes);
		}
	}

	/**
	 * 这个方法用来将参数allnodes中的数据全部装入b数
	 * 
	 * @param allNodes
	 * @return 返回一个装入了数据的b树
	 */
	private BTreeSet_interface restoreAllNodes(ArrayList<Node_interface> allNodes) {

		// 变量定义
		BTreeSet_interface bTreeSetTemp = new BTreeSet();// 这里的变量是用来存储要装入数据的b树
		for (int i = 0; i < allNodes.size(); i++) {
			bTreeSetTemp.addNode((ArrayList<Object>) allNodes.get(i));
		}
		return bTreeSetTemp;

	}

}
