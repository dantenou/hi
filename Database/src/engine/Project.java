package engine;
import datastructure.*;

public interface Project {
	//ʵ��ͶӰ����Ľӿ�,�̳������涨ΪProjector,Projector����Ϸ�ʽ����Ϊִ�������е�һ���ڲ���
	
	//��������������ʵ��ͶӰ�������������ڸ��������Ĳ������Ͳ�ͬ
	public BTreeSet_interface project(BTreeSet_interface bTreeSet,int... column);
	public BTreeSet_interface project(BTreeSet_interface bTreeSet,String... column);
	
}
