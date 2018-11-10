package engine;
import datastructure.BTreeSet_interface;
import engine_interface.*;

import java.util.ArrayList;

import datastructure.*;
public class Connector implements Connect{

	@Override
	public BTreeSet_interface cartesian(BTreeSet_interface bTreeSet1, BTreeSet_interface bTreeSet2) {//笛卡尔积
		BTreeSet_interface bt=new BTreeSet();//最终的返回b树
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
	public BTreeSet_interface natural(BTreeSet_interface bTreeSet1, BTreeSet_interface bTreeSet2) {//自然连接
		BTreeSet_interface bt=new BTreeSet();
		ArrayList<String> allColumn_bTreeSet1=bTreeSet1.showAllColumn();//第一个表中所有的列
		ArrayList<String> allColumn_bTreeSet2=bTreeSet2.showAllColumn();//第二个表中所有的列
		ArrayList<String> allColumn_bTreeSet1_source=bTreeSet1.showAllsource();
		ArrayList<String> allColumn_bTreeSet2_source=bTreeSet2.showAllsource();
		ArrayList<String> column_common=new ArrayList<String>();//公共列
		ArrayList<String> allColumn_bTreeSet2_delete_common=new ArrayList<String>();//第二个表中去掉公共列剩下的列
		la:for(int i=0;i<allColumn_bTreeSet1.size();i++) {//把第一个的表的所有的列加入到新表中
			bt.addColumn(allColumn_bTreeSet1.get(i),allColumn_bTreeSet1_source.get(i));
			for(int j=0;j<allColumn_bTreeSet2.size();j++) {
				if(!allColumn_bTreeSet1.get(i).equals(allColumn_bTreeSet2.get(j))) {//如果两个列名不相同，则继续遍历第二个表的列名					
					continue;
					}				
				else {
					column_common.add(allColumn_bTreeSet1.get(i));//当两个列名相同的时候，把相同的列名加入到公共列
					continue la;//当发现 相同列的时候，第一个表的当前列名就不会再有与第二个表的列名相同的了
				}
			}
		}
		la1:for(int i=0;i<allColumn_bTreeSet2.size();i++) {//把第二个表中的所有的和第一个表中的列不同的列加到新表中，先遍历第二个表
			for(int j=0;j<column_common.size();j++) {
				if(allColumn_bTreeSet2.get(i).equals(column_common.get(j)))//判断是否和公共列相同，相同则继续编列第二个表
					continue la1;
			}
			allColumn_bTreeSet2_delete_common.add(allColumn_bTreeSet2.get(i));//当和公共列不相同的时候，新表中加入该列，且在第二个表的剩下列中加入该列
			bt.addColumn(allColumn_bTreeSet2.get(i),allColumn_bTreeSet2_source.get(i));
		}
		/*BTreeSet_interface bt=this.join_column(bTreeSet1, bTreeSet2);
		ArrayList<String> column_common=this.join_column_common(bTreeSet1, bTreeSet2);*/
		int i=0,j=0;
		la0:while(true) {//两层循环遍历两个表的所有元组
			Node_interface node1=bTreeSet1.findNode(i);
			if(node1!=null) {//元组不为空，则还没有遍历完
				la:while(true) {
					Node_interface node2=bTreeSet2.findNode(j);
					if(node2!=null) {
						for(int w=0;w<column_common.size();w++) {
							if(!node1.getValues(column_common.get(w)).equals(node2.getValues(column_common.get(w)))) {
								//若在公共列中两个表的元组不相同，则继续遍历第二个表的剩下的元组
								j++;
								continue la;
							}
						}
						//前面的for循环一次也没有continue的话，则这两个元组满足条件
						//在已经找到公共列中所有行都是相同的行，把这一行填进去，并且break掉内层循环
						ArrayList<Object> node_value=new ArrayList<Object>();//存放新元组的值的object列表
						for(int tree1_point=0;tree1_point<allColumn_bTreeSet1.size();tree1_point++) {
							node_value.add(node1.getValues(tree1_point));	
						}
						for(int tree2_point=0;tree2_point<allColumn_bTreeSet2_delete_common.size();tree2_point++) {
							node_value.add(node2.getValues(allColumn_bTreeSet2_delete_common.get(tree2_point)));							
						}
						bt.addNode(node_value);//添加元组
						j=0;//内层指针清零
						i++;
						continue la0;
				    }
					else {//内层元组为空，内层已经遍历完
						j=0;//内层指针清零
						i++;
						break la;
					}
				}
			}
			else {
				i=0;//外层指针清零
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
		ArrayList<String> allColumn_bTreeSet1=bTreeSet1.showAllColumn();//第一个表中所有的列
		ArrayList<String> allColumn_bTreeSet2=bTreeSet2.showAllColumn();//第二个表中所有的列
		ArrayList<String> column_common=this.join_column_common(bTreeSet1, bTreeSet2);//公共列
		ArrayList<Object> node_left=new ArrayList<Object>();
		ArrayList<Object> node_right=new ArrayList<Object>();
		ArrayList<String> allColumn_bTreeSet2_delete_common=new ArrayList<String>();//第二个表中去掉公共列剩下的列
		
		//给allColumn_bTreeSet2_delete_common赋值
		la1:for(int i=0;i<allColumn_bTreeSet2.size();i++) {//把第二个表中的所有的和第一个表中的列不同的列加到新表中，先遍历第一个表
			for(int j=0;j<column_common.size();j++) {
				if(allColumn_bTreeSet2.get(i).equals(column_common.get(j)))//判断是否和公共列相同，相同则继续编列第二个表
					continue la1;
			}
			allColumn_bTreeSet2_delete_common.add(allColumn_bTreeSet2.get(i));//当和公共列不相同的时候，新表中加入该列，且在第二个表的剩下列中加入该列
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
					else {//表一的当前元组和表二的所有元组都不再公共列相同，则该元组满足条件，加入当左元组（node_left）中
						for(int we=0;i<allColumn_bTreeSet1.size()+allColumn_bTreeSet2_delete_common.size();we++) {
							if(we<allColumn_bTreeSet1.size()) 
								node_value.add(node1.getValues(we));
							else 
								node_value.add(null);
						}
						node_left.add(node_value);
						i++;
						j=0;
						break;//外循环加一，内循环清零，break内循环
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


