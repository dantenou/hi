package engine_interface;
import datastructure.*;

public interface Select {
	//ʵ��ѡ������Ľӿ�,�̳������涨ΪSelector,Selector����Ϸ�ʽ����Ϊִ�������е�һ���ڲ���
	
	public BTreeSet_interface select(BTreeSet_interface bTreeSet,Predicate_interface predicate);    //ʵ��ѡ����������������B����ʽ����
}
