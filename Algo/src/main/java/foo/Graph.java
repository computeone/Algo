package foo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
	/**
	 * @param args
	 */
	private ArrayList<LinkedList<ArrayList<Integer>>> array;
	private ArrayList<Integer[]> nodeinfo;
	private Integer[][] matrix;
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
	public Graph(Integer[][] matrix){
		this.matrix=matrix;
	}
	public void setGraph(Integer[][] relation){
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix.length;j++){
				matrix[i][j]=0;
			}
			int k=relation[i].length;
			for(int m=0;m<k;m++){
				int index=relation[i][m];
				matrix[i][index]=1;
			}
		}
	}
	public void setNodeInfo(ArrayList<Integer[]> nodeinfo){
		this.nodeinfo=nodeinfo;
	}
	public void depthFirstSearch(){		
			LinkedList<ArrayList<Integer>> linkedlist=new LinkedList<ArrayList<Integer>>();
			linkedlist=array.get(0);
			this.dfs_visit(linkedlist.getFirst());
			for(int i=0;i<size;i++){
				if(nodeinfo.get(i)[0]==0){
					this.dfs_visit(array.get(i).getFirst());
				}
			}
	}
	public void dfs_visit(ArrayList<Integer> node){
		LinkedList<ArrayList<Integer>> list=new LinkedList<ArrayList<Integer>>();
		ArrayList<Integer> tmpnode=new ArrayList<Integer>();
		Integer[] info=new Integer[nodeinfo.get(0).length];
		int node_index=node.get(0);
		info=nodeinfo.get(node_index);
		info[0]=1;//有部分被搜索了
		info[2]=counter;//设置discovered值
		counter++;//计数器递增
		list=array.get(node_index);
		Iterator<ArrayList<Integer>> iterator=list.iterator();
		while(iterator.hasNext()){//扫描邻接结点的颜色
			tmpnode=iterator.next();
			int index=tmpnode.get(0);
			if(nodeinfo.get(index)[0]==0){//如果颜色是白色
				nodeinfo.get(index)[1]=node_index;//设置前驱结点
				this.dfs_visit(tmpnode);//递归搜索
			}
		}
		info[0]=2;;//搜索完成 ，颜色设置为黑色
		info[3]=counter;//设置finished值
	}
	public void addNode(ArrayList<Integer> node,Integer[] relation){
		LinkedList<ArrayList<Integer>> linkedlist=new LinkedList<ArrayList<Integer>>();	
		for(int i=0;i<relation.length;i++){
			ArrayList<Integer> tmpnode=new ArrayList<Integer>();
		    tmpnode.add(relation[i]);
			linkedlist.add(tmpnode);			
		}
		int index=node.get(0);
		array.set(index,linkedlist);
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Graph graph=new Graph(9);
		ArrayList<Integer[]> nodeinfo=new ArrayList<Integer[]>();
		Integer[][] matrix=new Integer[9][9];
		Integer[][] relation={{0,1,4},{1,0,2},{2,1,3,6},{3,2,4},{4,0,3,5},{5,4},{6,2},{7,8},{8,7}};
		for(int i=0;i<9;i++){
			ArrayList<Integer> node=new ArrayList<Integer>();
			node.add(i);//结点node
			graph.addNode(node, relation[i]);
		}
		for(int i=0;i<9;i++){
			Integer[] info=new Integer[4];
			nodeinfo.add(info);
			info[0]=0;//颜色时白色  当为0时为白色，为1时为灰色，为2时为黑色
			info[1]=-1;//前驱结点
			info[2]=-1;//被发现时计数器的值
			info[3]=-1;//在该结点上被遍历完时计数器的值
		}
		graph.setNodeInfo(nodeinfo);
		graph.depthFirstSearch();
		Graph graph1=new Graph(matrix);
		graph1.setGraph(relation);
		System.out.println("Graph is builded");
	}
}
