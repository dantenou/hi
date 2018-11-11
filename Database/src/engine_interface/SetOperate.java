package engine_interface;
import datastructure.*;

public interface SetOperate {
	//实现集合运算的接口,继承类名规定为SetOperator,SetOperator用组合方式定义为执行引擎中的一个内部类
	
	//下面的方法实现各种集合操作，参数和返回结果都是BTreeSet
	public BTreeSet_interface intersect(BTreeSet_interface bTreeSet1,BTreeSet_interface bTreeSet2); //实现交运算
	public BTreeSet_interface union(BTreeSet_interface bTreeSet1,BTreeSet_interface bTreeSet2);     //实现并运算
	public BTreeSet_interface except(BTreeSet_interface bTreeSet1,BTreeSet_interface bTreeSet2);    //实现差运算
	
}
