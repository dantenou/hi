package engine;
import datastructure.*;

public interface Connect {
	//ʵ�ָ�����������Ľӿ�,�̳������涨ΪConnector,Connector����Ϸ�ʽ����Ϊִ�������е�һ���ڲ���
	
	//����ķ���ʵ�ָ����������㣬��������ΪBTreeSet
	public BTreeSet_interface cartesian(BTreeSet_interface bTreeSet1,BTreeSet_interface bTreeSet2); //�ѿ�����
	public BTreeSet_interface natural(BTreeSet_interface bTreeSet1,BTreeSet_interface bTreeSet2);   //��Ȼ����
	public BTreeSet_interface outer(BTreeSet_interface bTreeSet1,BTreeSet_interface bTreeSet2,boolean full,boolean left);
	//�����ӣ����в���fullΪtrueʱΪȫ�����ӣ���fullΪfalseʱΪ�������ӣ�left�������������ӻ���������
}
