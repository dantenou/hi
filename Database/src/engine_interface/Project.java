package engine_interface;
import datastructure.*;

public interface Project {
	//ʵ��ͶӰ����Ľӿ�,�̳������涨ΪProjector,Projector����Ϸ�ʽ����Ϊִ�������е�һ���ڲ���
	
	//��������������ʵ��ͶӰ�������������ڸ��������Ĳ������Ͳ�ͬ���м�Ĳ���distinct��ʾΨһ��Լ������distinctΪtrue���������о���ѭΨһ��Լ�������򶼲���ѭ
	public BTreeSet_interface project(BTreeSet_interface bTreeSet,boolean distinct,int... column);
	public BTreeSet_interface project(BTreeSet_interface bTreeSet,boolean distinct,String... column);
	
}
