package engine;
import datastructure.*;

public interface Limit {
	//ʵ����������Ľӿ�,�̳������涨ΪLimiter,Limiter����Ϸ�ʽ����Ϊִ�������е�һ���ڲ���
	
	public BTreeSet_interface limit(BTreeSet_interface bTreeSet,int limit);
}
