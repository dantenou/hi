package engine_interface;
import datastructure.*;

public interface SetOperate {
	//ʵ�ּ�������Ľӿ�,�̳������涨ΪSetOperator,SetOperator����Ϸ�ʽ����Ϊִ�������е�һ���ڲ���
	
	//����ķ���ʵ�ָ��ּ��ϲ����������ͷ��ؽ������BTreeSet
	public BTreeSet_interface intersect(BTreeSet_interface bTreeSet1,BTreeSet_interface bTreeSet2); //ʵ�ֽ�����
	public BTreeSet_interface union(BTreeSet_interface bTreeSet1,BTreeSet_interface bTreeSet2);     //ʵ�ֲ�����
	public BTreeSet_interface except(BTreeSet_interface bTreeSet1,BTreeSet_interface bTreeSet2);    //ʵ�ֲ�����
	
}
