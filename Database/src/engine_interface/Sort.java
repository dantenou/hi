package engine_interface;
import datastructure.*;

public interface Sort {
	//ʵ����������Ľӿ�,�̳������涨ΪSorter,Sorter����Ϸ�ʽ����Ϊִ�������е�һ���ڲ���
	
	public BTreeSet_interface sort(BTreeSet_interface bTreeSet,boolean asc,int... index);
	//�����е�index�����������ݵ�һ��������,�ڶ�������ascΪtrueʱ��ʾ���򣬷���Ϊ����
}
