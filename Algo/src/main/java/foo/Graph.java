package foo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ArrayDeque;
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
			linkedlist=array.get(1);
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

	public void breadthFirstSearch() {
		ArrayDeque<Integer> queue = new ArrayDeque<Integer>(9);
		LinkedList<ArrayList<Integer>> linkedlist = new LinkedList<ArrayList<Integer>>();
		Integer[] info = new Integer[5];
		int dist = 0;
		int counter = 0;

		// 把开始结点加入队列
		info=nodeinfo.get(0);
		info[0]=1;//设置颜色为灰色
		info[2]=counter;//设置计数器
		counter++;
		info[4]=dist;//设置距离始点的距离
		dist++;
		queue.add(0);
		// 增加邻接结点到队列
		linkedlist = array.get(0);
		Integer head=queue.getFirst();
		while (!queue.isEmpty()) {
			head=queue.getFirst();
			Iterator<ArrayList<Integer>> iterator = linkedlist.iterator();
			while (iterator.hasNext()) {
				ArrayList<Integer> node = new ArrayList<Integer>();
				node = iterator.next();
				info=nodeinfo.get(node.get(0));
				if (info[0]==0) {
					info[0]=1;
					info[1]=head;
					info[2]=counter;
					counter++;
					info[4]=dist;
					dist++;
					queue.add(node.get(0));
				}
			}
			queue.remove();
			nodeinfo.get(head)[0]=2;
			if(queue.isEmpty()){
				break;
			}
			linkedlist = array.get(queue.getFirst());// 获取这个结点的邻接结点
		}
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Graph graph=new Graph(9);
		ArrayList<Integer[]> nodeinfo=new ArrayList<Integer[]>();
		Integer[][] matrix=new Integer[9][9];
		Integer[][] relation={{1,4},{0,2},{1,3,6},{2,4},{0,3,5},{4},{2},{8},{7}};
		for(int i=0;i<9;i++){
			ArrayList<Integer> node=new ArrayList<Integer>();
			node.add(i);//结点node
			graph.addNode(node, relation[i]);
		}
		for(int i=0;i<9;i++){
			Integer[] info=new Integer[5];
			nodeinfo.add(info);
			info[0]=0;//颜色时白色  当为0时为白色，为1时为灰色，为2时为黑色
			info[1]=-1;//前驱结点
			info[2]=-1;//被发现时计数器的值
			info[3]=-1;//在该结点上被遍历完时计数器的值
			info[4]=-1;//距离始点的距离
		}
		graph.setNodeInfo(nodeinfo);
		//graph.depthFirstSearch();
		//Graph graph1=new Graph(matrix);
		//graph1.setGraph(relation);
		graph.breadthFirstSearch();
		System.out.println("Graph is builded");
	}
}
