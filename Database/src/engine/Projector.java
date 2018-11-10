package engine;

import engine_interface.*;
import java.util.ArrayList;
import datastructure.*;

public class Projector implements Project{

	@Override
	public BTreeSet_interface project(BTreeSet_interface bTreeSet,boolean distinct, int... column) {//������ֵ����ͶӰ
		// TODO Auto-generated method stub
		BTreeSet_interface bt=new BTreeSet();//���յķ���b��
		ArrayList<String> allColumn_bTreeSet=bTreeSet.showAllColumn();
		ArrayList<String> allColumn_bTreeSet_source=bTreeSet.showAllsource();
		for (int i = 0; i < column.length; i++){
			bt.addColumn(allColumn_bTreeSet.get(column[i]),allColumn_bTreeSet_source.get(column[i]));//��������ֵ����Ҫ����ͶӰ����
		}
		bt = Distinct(bt,distinct);
		return bt;
	}

	@Override
	public BTreeSet_interface project(BTreeSet_interface bTreeSet, boolean distinct, String... column) {
		// TODO Auto-generated method stub
		BTreeSet_interface bt=new BTreeSet();//���յķ���b��
		ArrayList<String> allColumn_bTreeSet=bTreeSet.showAllColumn();
		ArrayList<String> allColumn_bTreeSet_source=bTreeSet.showAllsource();
		for (int i = 0; i < column.length; i++){
			for(int j = 0; j<allColumn_bTreeSet.size();j++){
			  if( column[i].equals(allColumn_bTreeSet.get(j)) ){
				  bt.addColumn(allColumn_bTreeSet.get(j),allColumn_bTreeSet_source.get(j));//��������ֵ����Ҫ����ͶӰ����
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
			int temp1=1;   //��¼��һ��i��λ��
			int temp2=1;  //��¼��һ��j��λ��
			int count=1;   //����count��״̬�ж�temp1��temp2�ĸ�ֵ
			la0: while(true){
				 Node_interface node0=bt.findNode(i); 
				 Node_interface nodet=bt.findNode(temp2); 
				 if(nodet!=null){
					la1: while(true){
						 Node_interface node1=bt.findNode(j);
						 if(node1!=null){
							 for(int w=0;w<allColumn_bt.size();w++){
								 if( node0.getValues(allColumn_bt.get(w)).equals(node1.getValues(allColumn_bt.get(w))) ){
									 if( w== allColumn_bt.size()-1){         //����Ԫ���Ӧ�е�ֵ����ͬ��ɾȥ����ֵ�ϴ��һ���ڵ�
										 bt.deleteNode(j); 
										 j++;
										 if( count==1){                //��¼��һ��i��λ��
										   temp1 = j;
										   count = 2;
										 }
										 continue la1;
									 }
								 }else{
									 if( count==1){                 //��¼��һ��i��λ��
										   temp1 = j;
										   count = 2;
									   }else if (count==2){      //��¼��һ��j��λ��
										   temp2 = j;
										   count = 3;
									   }
									 j++; 
									 continue la1;
								 }
							 
							 }
						 }else {//�ڲ�Ԫ��Ϊ�գ��ڲ��Ѿ�������
							    if( count==2){        //���ǵ�countΪ2ʱ�������˳����
							    	temp2++;
							    }
								i=temp1;             //��i������һ���ڵ�
								j=temp2;             //��j������һ���ڵ�
							    count =1;            //��count��Ϊ��ʼ״̬
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
