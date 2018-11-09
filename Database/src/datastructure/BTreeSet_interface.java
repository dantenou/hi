package datastructure;
import java.util.*;

public interface BTreeSet_interface {
	//���ݿ��е�һ�����Ӧһ��B���������ж����ݵ���ɾ��Ĳ������Դ���Ϊ�����ӿ�
	public ArrayList<String> showAllColumn();               //������������ɵ�ArrayList
	public ArrayList<String> showAllsource();               //���ظ���������Ӧ��Դ���ݱ���
	public String showColumn(int column);                   //��ʾ��Ӧ����������,��column���Ϸ��򷵻�null
	public int getColumn(String column);                    //��ʾ����column��Ӧ������,��column�������򷵻�null
	public String showSource(int column);                   //��ʾ��Ӧ������Դ���ݱ���
	public String showSource(String column);                //��ʾ��Ӧ������Դ���ݱ���
	public int getCount();                                  //��ʾ��ǰ��B���еĽڵ���Ŀ
	
	//��һ����Ϊ�������ֵ�Ĳ���
	public boolean addColumn(String column_name);           //���һ���µ�����
	public boolean renameColumn(String newName,int column); //�޸�����
	public boolean removeColumn(int column);                //�Ƴ���Ӧ����������,��column���Ϸ��򷵻�false,����ͶӰ����
	
	public boolean addNode(ArrayList<Object> values);       //������������Ԫ��,values�д����������ֵ,�ɹ�����true,���򷵻�false
	public boolean deleteNode(int index);                   //ɾ�����е�����Ԫ��,�ɹ�����true,���򷵻�false
	public int first();                                     //����B���е��׽ڵ�����ֵ
	public int last();                                      //����B���е�β�ڵ�����ֵ
	public Node_interface findNode(int index);              //����node������ֵ�ҵ���Ӧ�Ľڵ�
}
