package datastructure;

public interface Node_interface {
	//B���еĽڵ㣬һ���ڵ��һ��Ԫ��
	public int getIndex();                                  //���ص�ǰ�ڵ������ֵ
	public boolean resetIndex(int index);                   //���õ�ǰ�ڵ������ֵ,�ɹ��򷵻�true,���򷵻�false
	public int next();                                      //������һ���ڵ������ֵ
	public Node_interface nextNode();                       //������һ���ڵ�
	
	public Object getValues(String column);                 //��Object������ʽ����������ֵ,����ΪString���͵�����
	public Object getValues(int column);                    //��Object������ʽ����������ֵ,����Ϊ�������͵�����
	public boolean resetColumn(Object value,int column);    //��������ֵ,��value������ת�Ͳ����ϵײ����ݽṹ���׳��쳣,��valueֵ���Ϸ��򷵻�false
	public boolean select(Predicate_interface predicate);   //ν�ʲ���,��ν�ʶ��ڵ�ǰ�ڵ��е�Ԫ��Ϊ���򷵻�true
}
