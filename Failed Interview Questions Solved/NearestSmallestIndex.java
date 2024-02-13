import java.util.*;
class NearestSmallestIndex{

	public static void main(String... args){

	Scanner sc=new Scanner(System.in);
	int n=sc.nextInt();
	
	List<Integer> cd=new ArrayList<>();
	for(int i=0;i<n;i++)
	{
	int num=sc.nextInt();
	cd.add(num);
	}
	int m=sc.nextInt();
	List<Integer> queries=new ArrayList<>();
	for(int i=0;i<m;i++)
	{
	int num=sc.nextInt();
	queries.add(num);
	}
	System.out.println(new NearestSmallestIndex().nearestSmallestIndex(cd,queries));
	}
	
	public List<Integer> nearestSmallestIndex(List<Integer> cd,List<Integer> queries){
	
	Stack<Integer> s1=new Stack<>();
	int[] larr=new int[cd.size()];
	for(int i=0;i<cd.size();i++)
	{
		while(!s1.isEmpty()&&cd.get(s1.peek())>=cd.get(i))
		s1.pop();
		if(s1.isEmpty())
		larr[i]=-1;
		else larr[i]=s1.peek();
		s1.add(i);
	}
	Stack<Integer> s2=new Stack<>();
	int[] rarr=new int[cd.size()];
	for(int i=cd.size()-1;i>=0;i--)
	{
		while(!s2.isEmpty()&&cd.get(s2.peek())>=cd.get(i))
		s2.pop();
		if(s2.isEmpty())
		rarr[i]=-1;
		else rarr[i]=s2.peek();
		s2.add(i);
	
	}
	System.out.println(Arrays.toString(larr));
	System.out.println(Arrays.toString(rarr));
	int ans[]=new int[larr.length];
	List<Integer> arr=new ArrayList<Integer>();
	for(int i=0;i<ans.length;i++)
	{
	if(larr[i]==-1||rarr[i]==-1)
	ans[i]=Math.max(larr[i],rarr[i]);
	else {
		if(cd.get(larr[i])==cd.get(rarr[i]))
		if(Math.abs(i-larr[i])<Math.abs(i-rarr[i]))
		ans[i]=larr[i];
		else ans[i]=rarr[i];
		else ans[i]=Math.min(larr[i],rarr[i]);}
	
	}
		for(int i=0;i<queries.size();i++)
		arr.add(ans[queries.get(i)-1]==-1?-1:ans[queries.get(i)-1]+1);
		return arr;
	}
}