package engine;
import datastructure.*;

public interface Limit {
	//实现限制运算的接口,继承类名规定为Limiter,Limiter用组合方式定义为执行引擎中的一个内部类
	
	public BTreeSet_interface limit(BTreeSet_interface bTreeSet,int limit);
}
