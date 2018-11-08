package engine;
import datastructure.*;

public interface Connect {
	//实现各种连接运算的接口,继承类名规定为Connector,Connector用组合方式定义为执行引擎中的一个内部类
	
	//下面的方法实现各种连接运算，返回类型为BTreeSet
	public BTreeSet_interface cartesian(BTreeSet_interface bTreeSet1,BTreeSet_interface bTreeSet2); //笛卡儿积
	public BTreeSet_interface natural(BTreeSet_interface bTreeSet1,BTreeSet_interface bTreeSet2);   //自然连接
	public BTreeSet_interface outer(BTreeSet_interface bTreeSet1,BTreeSet_interface bTreeSet2,boolean full,boolean left);
	//外连接，其中参数full为true时为全外连接，当full为false时为半外连接，left决定是左外连接或右外连接
}
