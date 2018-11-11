package engine_interface;
import datastructure.*;

public interface Project {
	//实现投影运算的接口,继承类名规定为Projector,Projector用组合方式定义为执行引擎中的一个内部类
	
	//下面这两个方法实现投影操作，区别在于给出列名的参数类型不同，中间的参数distinct表示唯一性约束，若distinct为true，则所有列均遵循唯一性约束，否则都不遵循
	public BTreeSet_interface project(BTreeSet_interface bTreeSet,boolean distinct,int... column);
	public BTreeSet_interface project(BTreeSet_interface bTreeSet,boolean distinct,String... column);
	
}
