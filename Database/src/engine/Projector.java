package engine;

import engine_interface.*;
import java.util.ArrayList;
import datastructure.*;

public class Projector implements Project{

	@Override
	public BTreeSet_interface project(BTreeSet_interface bTreeSet,boolean distinct, int... column) {//按索引值进行投影
		// TODO Auto-generated method stub
		BTreeSet_interface bt=new BTreeSet();//最终的返回b树
		ArrayList<String> allColumn_bTreeSet=bTreeSet.showAllColumn();
		ArrayList<String> allColumn_bTreeSet_source=bTreeSet.showAllsource();
		for (int i = 0; i < column.length; i++){
			bt.addColumn(allColumn_bTreeSet.get(column[i]),allColumn_bTreeSet_source.get(column[i]));//根据索引值将需要的列投影出来
		}
		bt = Distinct(bt,distinct);
		return bt;
	}

	@Override
	public BTreeSet_interface project(BTreeSet_interface bTreeSet, boolean distinct, String... column) {
		// TODO Auto-generated method stub
		BTreeSet_interface bt=new BTreeSet();//最终的返回b树
		ArrayList<String> allColumn_bTreeSet=bTreeSet.showAllColumn();
		ArrayList<String> allColumn_bTreeSet_source=bTreeSet.showAllsource();
		for (int i = 0; i < column.length; i++){
			for(int j = 0; j<allColumn_bTreeSet.size();j++){
			  if( column[i].equals(allColumn_bTreeSet.get(j)) ){
				  bt.addColumn(allColumn_bTreeSet.get(j),allColumn_bTreeSet_source.get(j));//根据索引值将需要的列投影出来
				  break;
			  }
			}
		}
		bt = Distinct(bt,distinct);
		return bt;
	}
	
	private BTreeSet_interface Distinct(BTreeSet_interface bt,boolean distinct){
		if( distinct == true){
			ArrayList<String> allColumn_bt=bt.showAllColumn();
			int i =0;
			int j =1;
			int temp1=1;   //记录下一次i的位置
			int temp2=1;  //记录下一次j的位置
			int count=1;   //根据count的状态判断temp1与temp2的赋值
			la0: while(true){
				 Node_interface node0=bt.findNode(i); 
				 Node_interface nodet=bt.findNode(temp2); 
				 if(nodet!=null){
					la1: while(true){
						 Node_interface node1=bt.findNode(j);
						 if(node1!=null){
							 for(int w=0;w<allColumn_bt.size();w++){
								 if( node0.getValues(allColumn_bt.get(w)).equals(node1.getValues(allColumn_bt.get(w))) ){
									 if( w== allColumn_bt.size()-1){         //若两元组对应列的值均相同则删去索引值较大的一个节点
										 bt.deleteNode(j); 
										 j++;
										 if( count==1){                //记录下一次i的位置
										   temp1 = j;
										   count = 2;
										 }
										 continue la1;
									 }
								 }else{
									 if( count==1){                 //记录下一次i的位置
										   temp1 = j;
										   count = 2;
									   }else if (count==2){      //记录下一次j的位置
										   temp2 = j;
										   count = 3;
									   }
									 j++; 
									 continue la1;
								 }
							 
							 }
						 }else {//内层元组为空，内层已经遍历完
							    if( count==2){        //考虑到count为2时的特殊退出情况
							    	temp2++;
							    }
								i=temp1;             //将i移向下一个节点
								j=temp2;             //将j移向下一个节点
							    count =1;            //将count置为初始状态
							    continue la0;
					  }
					}
				 }else {
						i=0;
						break la0;
					}
			  }
			
			  return bt;
			}else{
			  return bt;
			}
	}

}
