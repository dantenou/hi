package engine;

import java.util.ArrayList;

import datastructure.BTreeSet;
import datastructure.BTreeSet_interface;
import datastructure.Node_interface;
import engine_interface.*;

/**
 * �������Ҫ����ʵ������
 * 
 * @author ligmh
 *
 */
public class Sorter implements Sort {

	/**
	 * ������Υ�������룬�򷵻�null
	 */
	@Override
	public BTreeSet_interface sort(BTreeSet_interface bTreeSet, boolean asc, int... index) {

		// ��������
		BTreeSet_interface bTreeSetCopy = bTreeSet;// ����Ѵ�������b�����Ƶ�bTreeSetCopy��
		ArrayList<String> allColumn = bTreeSetCopy.showAllColumn();// �����ǽ����е��е����ƶ�ȡ��
		int columnCount = allColumn.size();// ����ܹ��ж��ٸ���
		ArrayList<Node_interface> allNodes = new ArrayList<Node_interface>();

		// �����ѭ�������ж�������к��ǲ��ǳ����˱��������к�
		for (int i = 0; i < index.length; i++) {
			if (index[i] >= columnCount) {
				System.out.println("û����������кţ�");
				return null;
			}
		}

		Node_interface node = bTreeSetCopy.findNode(bTreeSetCopy.first());// ����������ȡ��һ��node

		// ��������ѭ��������������b���������е�node�ڵ�װ��allNodes��
		while (node.nextNode() != null) {
			allNodes.add(node);
			node = node.nextNode();
		}

		// ���������õ���allNodes�е�node���ݽ�������
		if (asc) {// �����ʾ��������
			allNodes.sort(null);// ���ﻹ�д��о�
			return restoreAllNodes(allNodes);
		} else {// �����ʾ���ǽ���
			allNodes.sort(null);
			return restoreAllNodes(allNodes);
		}
	}

	/**
	 * �����������������allnodes�е�����ȫ��װ��b��
	 * 
	 * @param allNodes
	 * @return ����һ��װ�������ݵ�b��
	 */
	private BTreeSet_interface restoreAllNodes(ArrayList<Node_interface> allNodes) {

		// ��������
		BTreeSet_interface bTreeSetTemp = new BTreeSet();// ����ı����������洢Ҫװ�����ݵ�b��
		for (int i = 0; i < allNodes.size(); i++) {
			bTreeSetTemp.addNode((ArrayList<Object>) allNodes.get(i));
		}
		return bTreeSetTemp;

	}

}
