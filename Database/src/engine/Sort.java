package engine;
import datastructure.*;

public interface Sort {
	//ʵ����������Ľӿ�,�̳������涨ΪSorter,Sorter����Ϸ�ʽ����Ϊִ�������е�һ���ڲ���
	
	public BTreeSet_interface sort(BTreeSet_interface bTreeSet,int... index);
	//�����е�index�����������ݵ�һ��������
}
