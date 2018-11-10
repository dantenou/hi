package engine;
import datastructure.BTreeSet_interface;
import engine_interface.*;

import java.util.ArrayList;

import datastructure.*;
public class Connector implements Connect{

	@Override
	public BTreeSet_interface cartesian(BTreeSet_interface bTreeSet1, BTreeSet_interface bTreeSet2) {//�ѿ�����
		BTreeSet_interface bt=new BTreeSet();//���յķ���b��
		ArrayList<String> common_column=this.join_column_common(bTreeSet1, bTreeSet2);
		ArrayList<String> allColumn_bTreeSet1=bTreeSet1.showAllColumn();
		ArrayList<String> allColumn_bTreeSet2=bTreeSet2.showAllColumn();
		ArrayList<String> allColumn_bTreeSet1_source=bTreeSet1.showAllsource();
		ArrayList<String> allColumn_bTreeSet2_source=bTreeSet2.showAllsource();
		for(int i=0;i<allColumn_bTreeSet1.size();i++) {
			bt.addColumn(allColumn_bTreeSet1.get(i),allColumn_bTreeSet1_source.get(i));
		}
		for(int i=0;i<allColumn_bTreeSet2.size();i++) {
			bt.addColumn(allColumn_bTreeSet2.get(i),allColumn_bTreeSet2_source.get(i));
		}
		int m=0;
		while(true) {
			if(bt.showColumn(m)==null) {
				m=0;
				break;
			}
			for(int i=0;i<common_column.size();i++) {
				if(bt.showColumn(m).equals(common_column.get(i))&&m<allColumn_bTreeSet1.size())
					bt.renameColumn(allColumn_bTreeSet1_source.get(bTreeSet1.getColumn(bt.showColumn(m)))+bt.showColumn(m), m);	
				if(bt.showColumn(m).equals(common_column.get(i))&&m>=allColumn_bTreeSet1.size())
					bt.renameColumn(allColumn_bTreeSet2_source.get(bTreeSet2.getColumn(bt.showColumn(m)))+bt.showColumn(m), m);
			}
			m++;
		}
		int i=0;
		int j=0;
		while(true) {
			Node_interface node1=bTreeSet1.findNode(i);
			if(node1!=null) {
				while(true) {
					Node_interface node2=bTreeSet2.findNode(j);
					if(node2!=null) {
						ArrayList<Object> node_value=new ArrayList<Object>();
						for(int tree1_point=0;tree1_point<allColumn_bTreeSet1.size();tree1_point++) {
							node_value.add(node1.getValues(tree1_point));							
						}
						for(int tree2_point=0;tree2_point<allColumn_bTreeSet2.size();tree2_point++) {
							node_value.add(node1.getValues(tree2_point));							
						}
						bt.addNode(node_value);
						j++;
					}
					else {
						j=0;
						break;
					}
				}
				i++;
			}
			else {
				i=0;
				break;
			}
		}
		return bt;
	}
	private ArrayList<String> join_column_common(BTreeSet_interface bTreeSet1, BTreeSet_interface bTreeSet2){
		ArrayList<String> allColumn_bTreeSet1=bTreeSet1.showAllColumn();
		ArrayList<String> allColumn_bTreeSet2=bTreeSet2.showAllColumn();
		ArrayList<String> column_common=new ArrayList<String>();
		la:for(int i=0;i<allColumn_bTreeSet1.size();i++) {
			for(int j=0;j<allColumn_bTreeSet2.size();j++) {
				if(!allColumn_bTreeSet1.get(i).equals(allColumn_bTreeSet2.get(j))) {				
					continue;
					}				
				else {
					column_common.add(allColumn_bTreeSet1.get(i));
					continue la;
					}
			}
		}
		return column_common;
	}
	@Override
	public BTreeSet_interface natural(BTreeSet_interface bTreeSet1, BTreeSet_interface bTreeSet2) {//��Ȼ����
		BTreeSet_interface bt=new BTreeSet();
		ArrayList<String> allColumn_bTreeSet1=bTreeSet1.showAllColumn();//��һ���������е���
		ArrayList<String> allColumn_bTreeSet2=bTreeSet2.showAllColumn();//�ڶ����������е���
		ArrayList<String> allColumn_bTreeSet1_source=bTreeSet1.showAllsource();
		ArrayList<String> allColumn_bTreeSet2_source=bTreeSet2.showAllsource();
		ArrayList<String> column_common=new ArrayList<String>();//������
		ArrayList<String> allColumn_bTreeSet2_delete_common=new ArrayList<String>();//�ڶ�������ȥ��������ʣ�µ���
		la:for(int i=0;i<allColumn_bTreeSet1.size();i++) {//�ѵ�һ���ı�����е��м��뵽�±���
			bt.addColumn(allColumn_bTreeSet1.get(i),allColumn_bTreeSet1_source.get(i));
			for(int j=0;j<allColumn_bTreeSet2.size();j++) {
				if(!allColumn_bTreeSet1.get(i).equals(allColumn_bTreeSet2.get(j))) {//���������������ͬ������������ڶ����������					
					continue;
					}				
				else {
					column_common.add(allColumn_bTreeSet1.get(i));//������������ͬ��ʱ�򣬰���ͬ���������뵽������
					continue la;//������ ��ͬ�е�ʱ�򣬵�һ����ĵ�ǰ�����Ͳ���������ڶ������������ͬ����
				}
			}
		}
		la1:for(int i=0;i<allColumn_bTreeSet2.size();i++) {//�ѵڶ������е����еĺ͵�һ�����е��в�ͬ���мӵ��±��У��ȱ����ڶ�����
			for(int j=0;j<column_common.size();j++) {
				if(allColumn_bTreeSet2.get(i).equals(column_common.get(j)))//�ж��Ƿ�͹�������ͬ����ͬ��������еڶ�����
					continue la1;
			}
			allColumn_bTreeSet2_delete_common.add(allColumn_bTreeSet2.get(i));//���͹����в���ͬ��ʱ���±��м�����У����ڵڶ������ʣ�����м������
			bt.addColumn(allColumn_bTreeSet2.get(i),allColumn_bTreeSet2_source.get(i));
		}
		/*BTreeSet_interface bt=this.join_column(bTreeSet1, bTreeSet2);
		ArrayList<String> column_common=this.join_column_common(bTreeSet1, bTreeSet2);*/
		int i=0,j=0;
		la0:while(true) {//����ѭ�����������������Ԫ��
			Node_interface node1=bTreeSet1.findNode(i);
			if(node1!=null) {//Ԫ�鲻Ϊ�գ���û�б�����
				la:while(true) {
					Node_interface node2=bTreeSet2.findNode(j);
					if(node2!=null) {
						for(int w=0;w<column_common.size();w++) {
							if(!node1.getValues(column_common.get(w)).equals(node2.getValues(column_common.get(w)))) {
								//���ڹ��������������Ԫ�鲻��ͬ������������ڶ������ʣ�µ�Ԫ��
								j++;
								continue la;
							}
						}
						//ǰ���forѭ��һ��Ҳû��continue�Ļ�����������Ԫ����������
						//���Ѿ��ҵ��������������ж�����ͬ���У�����һ�����ȥ������break���ڲ�ѭ��
						ArrayList<Object> node_value=new ArrayList<Object>();//�����Ԫ���ֵ��object�б�
						for(int tree1_point=0;tree1_point<allColumn_bTreeSet1.size();tree1_point++) {
							node_value.add(node1.getValues(tree1_point));	
						}
						for(int tree2_point=0;tree2_point<allColumn_bTreeSet2_delete_common.size();tree2_point++) {
							node_value.add(node2.getValues(allColumn_bTreeSet2_delete_common.get(tree2_point)));							
						}
						bt.addNode(node_value);//���Ԫ��
						j=0;//�ڲ�ָ������
						i++;
						continue la0;
				    }
					else {//�ڲ�Ԫ��Ϊ�գ��ڲ��Ѿ�������
						j=0;//�ڲ�ָ������
						i++;
						break la;
					}
				}
			}
			else {
				i=0;//���ָ������
				break la0;
			}
		}
		return bt;
	}

	@SuppressWarnings("unchecked")
	@Override
	public BTreeSet_interface outer(BTreeSet_interface bTreeSet1, BTreeSet_interface bTreeSet2, boolean full,boolean left) {
		BTreeSet_interface bt=new BTreeSet();
		bt=this.natural(bTreeSet1, bTreeSet2);
		ArrayList<String> allColumn_bTreeSet1=bTreeSet1.showAllColumn();//��һ���������е���
		ArrayList<String> allColumn_bTreeSet2=bTreeSet2.showAllColumn();//�ڶ����������е���
		ArrayList<String> column_common=this.join_column_common(bTreeSet1, bTreeSet2);//������
		ArrayList<Object> node_left=new ArrayList<Object>();
		ArrayList<Object> node_right=new ArrayList<Object>();
		ArrayList<String> allColumn_bTreeSet2_delete_common=new ArrayList<String>();//�ڶ�������ȥ��������ʣ�µ���
		
		//��allColumn_bTreeSet2_delete_common��ֵ
		la1:for(int i=0;i<allColumn_bTreeSet2.size();i++) {//�ѵڶ������е����еĺ͵�һ�����е��в�ͬ���мӵ��±��У��ȱ�����һ����
			for(int j=0;j<column_common.size();j++) {
				if(allColumn_bTreeSet2.get(i).equals(column_common.get(j)))//�ж��Ƿ�͹�������ͬ����ͬ��������еڶ�����
					continue la1;
			}
			allColumn_bTreeSet2_delete_common.add(allColumn_bTreeSet2.get(i));//���͹����в���ͬ��ʱ���±��м�����У����ڵڶ������ʣ�����м������
		}
		
		int i=0,j=0;
		la:while(true) {
			ArrayList<Object> node_value=new ArrayList<Object>();
			Node_interface node1=bTreeSet1.findNode(i);
			if(node1!=null) {				
				while(true) {
					Node_interface node2=bTreeSet2.findNode(j);
					if(node2!=null) {
						int common_count=0;
						for(int w=0;w<column_common.size();w++) {
							if(node1.getValues(column_common.get(w)).equals(node2.getValues(column_common.get(w)))) {
								common_count++;
								}
							}
						if(common_count==column_common.size()) {
							j=0;
							i++;
							continue la;
						}
						else {
							j++;
							continue;
						}
					}
					else {//��һ�ĵ�ǰԪ��ͱ��������Ԫ�鶼���ٹ�������ͬ�����Ԫ���������������뵱��Ԫ�飨node_left����
						for(int we=0;i<allColumn_bTreeSet1.size()+allColumn_bTreeSet2_delete_common.size();we++) {
							if(we<allColumn_bTreeSet1.size()) 
								node_value.add(node1.getValues(we));
							else 
								node_value.add(null);
						}
						node_left.add(node_value);
						i++;
						j=0;
						break;//��ѭ����һ����ѭ�����㣬break��ѭ��
					}
				}
			}
			else {
				i=0;
				break;
			}
		}
		la:while(true) {
			ArrayList<Object> node_value=new ArrayList<Object>();
			Node_interface node1=bTreeSet2.findNode(i);
			if(node1!=null) {
				while(true) {
					Node_interface node2=bTreeSet1.findNode(j);
					if(node2!=null) {
						int common_count=0;
						for(int w=0;w<column_common.size();w++) {
							if(node1.getValues(column_common.get(w)).equals(node2.getValues(column_common.get(w)))) {
								common_count++;
								}
							}
						if(common_count==column_common.size()) {
							j=0;
							i++;
							continue la;
						}
						else {
							j++;
							continue;
						}
					}
					else {
						for(int we=0;i<allColumn_bTreeSet1.size()+allColumn_bTreeSet2_delete_common.size();we++) {
							if(we<allColumn_bTreeSet1.size()-column_common.size()) 
								node_value.add(null);
							else if(we>=allColumn_bTreeSet1.size()-column_common.size()) {
								node_value.add(node1.getValues(column_common.get(we-column_common.size())));
							}							
						}
						node_right.add(node_value);
						i++;
						break;
					}
				}
			}
			else
				{
				i=0;
				break;	
				}
		}
		if(full==true) {
			for( i=0;i<node_left.size();i++) {
				bt.addNode((ArrayList<Object>) node_left.get(i));
			}
			for(i=0;i<node_right.size();i++) {
				bt.addNode((ArrayList<Object>) node_right.get(i));
			}
			return bt;
		}
		else if(left==true) {
			for( i=0;i<node_left.size();i++) {
				bt.addNode((ArrayList<Object>) node_left.get(i));
			}
			return bt;
		}
		else {
			for(i=0;i<node_right.size();i++) {
				bt.addNode((ArrayList<Object>) node_right.get(i));
			}
			return bt;
		}
	}}


