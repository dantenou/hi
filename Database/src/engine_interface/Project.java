package engine_interface;
import datastructure.*;
import java.util.*;

public interface Project {
	//ʵ��ͶӰ����Ľӿ�,�̳������涨ΪProjector,Projector����Ϸ�ʽ����Ϊִ�������е�һ���ڲ���
	
	//��������������ʵ��ͶӰ�������������ڸ��������Ĳ������Ͳ�ͬ���м�Ĳ���ArrayList�洢�����Ƿ����distinct
	public BTreeSet_interface project(BTreeSet_interface bTreeSet,ArrayList<Boolean> distinct,int... column);
	public BTreeSet_interface project(BTreeSet_interface bTreeSet,ArrayList<Boolean> distinct,String... column);
	
}
