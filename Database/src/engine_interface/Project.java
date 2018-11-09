package engine_interface;
import datastructure.*;
import java.util.*;

public interface Project {
	//实现投影运算的接口,继承类名规定为Projector,Projector用组合方式定义为执行引擎中的一个内部类
	
	//下面这两个方法实现投影操作，区别在于给出列名的参数类型不同，中间的参数ArrayList存储列名是否带有distinct
	public BTreeSet_interface project(BTreeSet_interface bTreeSet,ArrayList<Boolean> distinct,int... column);
	public BTreeSet_interface project(BTreeSet_interface bTreeSet,ArrayList<Boolean> distinct,String... column);
	
}
