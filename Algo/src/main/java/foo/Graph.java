package foo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
public class Graph {
	/**
	 * @param args
	 */
	private ArrayList<LinkedList<ArrayList<Integer>>> array;
	//private ArrayList<Integer> node;
	//private LinkedList<ArrayList<Integer>> list;
	private ArrayList<String> nodeinfo;
	private int size;
	private int counter=0;
	public Graph(int size){
		this.size=size;
		this.array=new ArrayList<LinkedList<ArrayList<Integer>>>();
		LinkedList<ArrayList<Integer>> list=new LinkedList<ArrayList<Integer>>();
		ArrayList<Integer> node=new ArrayList<Integer>();
		node=new ArrayList<Integer>();
		list=new LinkedList<ArrayList<Integer>>();
		for(int i=0;i<this.size;i++){
			array.add(new LinkedList<ArrayList<Integer>>());
		}
	}
	public void setNodeInfo(ArrayList<String> nodeinfo){
		this.nodeinfo=nodeinfo;
	}
	public void depthFirstSearch(){		
		//for(int i=0;i<array.size();i++){
			LinkedList<ArrayList<Integer>> linkedlist=new LinkedList<ArrayList<Integer>>();
			linkedlist=array.get(1);
			this.dfs_visit(linkedlist.getFirst());
		//}
	}
	public void dfs_visit(ArrayList<Integer> node){
		LinkedList<ArrayList<Integer>> list=new LinkedList<ArrayList<Integer>>();
		ArrayList<Integer> tmpnode=new ArrayList<Integer>();
		int node_index=node.get(0);
		nodeinfo.set(node_index, "gray");//有部分被搜索了
		node.set(2, counter);//设置discovered值
		counter++;       //计数器递增
		list=array.get(node_index);
		Iterator<ArrayList<Integer>> iterator=list.iterator();
		while(iterator.hasNext()){//扫描邻接结点的颜色
			tmpnode=iterator.next();
			int index=tmpnode.get(0);
			if(nodeinfo.get(index)=="gray"){
				continue;
			}
			if(nodeinfo.get(index)=="white"){
				tmpnode.set(1,node_index);//设置前驱结点
				this.dfs_visit(tmpnode);//递归搜索
			}
		}
		nodeinfo.set(node_index, "black");//搜索完成
		node.set(3,counter);//设置finished值
	}
	public void addNode(ArrayList<Integer> node,Integer[] relation){
		LinkedList<ArrayList<Integer>> linkedlist=new LinkedList<ArrayList<Integer>>();		
		for(int i=0;i<relation.length;i++){
			//linkedlist=array.get(node.get(0));//得到这个结点的array linkedlist
			ArrayList<Integer> tmpnode=new ArrayList<Integer>();
			tmpnode.add(relation[i]);
			tmpnode.add(-1);
			tmpnode.add(-1);
			tmpnode.add(-1);
			linkedlist.add(tmpnode);			
		}
		int index=node.get(0);
		array.set(index,linkedlist);
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Graph graph=new Graph(7);
		ArrayList<String> nodeinfo=new ArrayList<String>();
		Integer[][] relation={{1,4},{0,2},{1,3,6},{2,4},{0,3,5},{4},{2}};
		for(int i=0;i<7;i++){
			ArrayList<Integer> node=new ArrayList<Integer>();
			node.add(i);//结点node
			node.add(-1);//前驱结点prev[]
			node.add(-1);//被发现时计数器的值discovered[]
			node.add(-1);//在该结点上被遍历完时计数器的值 finished[]
			graph.addNode(node, relation[i]);
		}
		for(int i=0;i<7;i++){
			nodeinfo.add("white");
		}
		graph.setNodeInfo(nodeinfo);
		graph.depthFirstSearch();
		System.out.println("Graph is builded");
	}
}
