package engine_interface;
import datastructure.*;

public interface Select {
	//实现选择运算的接口,继承类名规定为Selector,Selector用组合方式定义为执行引擎中的一个内部类
	
	public BTreeSet_interface select(BTreeSet_interface bTreeSet,Predicate_interface predicate);    //实现选择操作，并将结果以B树形式返回
}
