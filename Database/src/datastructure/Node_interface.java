package datastructure;

public interface Node_interface {
	//B树中的节点，一个节点存一个元组
	public int getIndex();                                  //返回当前节点的索引值
	public boolean resetIndex(int index);                   //重置当前节点的索引值,成功则返回true,否则返回false
	public int next();                                      //返回下一个节点的索引值
	public Node_interface nextNode();                       //返回下一个节点
	
	public Object getValues(String column);                 //以Object对象形式返回列属性值,参数为String类型的类名
	public Object getValues(int column);                    //以Object对象形式返回属性列值,参数为整数类型的列数
	public boolean resetColumn(Object value,int column);    //重置属性值,若value经向下转型不符合底层数据结构则抛出异常,若value值不合法则返回false
	public boolean select(Predicate_interface predicate);   //谓词操作,若谓词对于当前节点中的元组为真则返回true
}
