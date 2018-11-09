package datastructure;
import java.util.*;

public interface BTreeSet_interface {
	//数据库中的一个表对应一个B树集，所有对数据的增删查改操作皆以此作为基本接口
	public ArrayList<String> showAllColumn();               //返回由列名组成的ArrayList
	public ArrayList<String> showAllsource();               //返回各个列名对应的源数据表名
	public String showColumn(int column);                   //显示对应列数的列名,若column不合法则返回null
	public int getColumn(String column);                    //显示列名column对应的列数,若column不存在则返回null
	public String showSource(int column);                   //显示对应列数的源数据表名
	public String showSource(String column);                //显示对应列名的源数据表名
	public int getCount();                                  //显示当前的B树中的节点数目
	
	//这一部分为对数据字典的操作
	public boolean addColumn(String column_name);           //添加一个新的列名
	public boolean renameColumn(String newName,int column); //修改列名
	public boolean removeColumn(int column);                //移除对应列数的列名,若column不合法则返回false,用于投影操作
	
	public boolean addNode(ArrayList<Object> values);       //向表中添加数据元素,values中存的是属性列值,成功返回true,否则返回false
	public boolean deleteNode(int index);                   //删除表中的数据元素,成功返回true,否则返回false
	public int first();                                     //返回B树中的首节点索引值
	public int last();                                      //返回B树中的尾节点索引值
	public Node_interface findNode(int index);              //根据node的索引值找到对应的节点
}
