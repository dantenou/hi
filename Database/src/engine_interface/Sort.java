package engine_interface;
import datastructure.*;

public interface Sort {
	//实现排序运算的接口,继承类名规定为Sorter,Sorter用组合方式定义为执行引擎中的一个内部类
	
	public BTreeSet_interface sort(BTreeSet_interface bTreeSet,boolean asc,int... index);
	//参数中的index表明排序依据的一个或多个类,第二个参数asc为true时表示升序，否则为降序
}
