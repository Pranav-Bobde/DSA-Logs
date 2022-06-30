//Persitent Question

//Time & Space Complexity: O(N) O(N)

import java.util.*;
public class Main
{
    static class Pair {
        private int city;
        private int ruler;
        Pair(int c, int r){
            city = c;
            ruler = r;
        }
        int getCity(){return city;}
        int getRuler(){return ruler;}
        @Override
        public String toString(){
            return "city: "+city+" ruler: "+ruler;
        }
    }
    
	public static void main(String[] args) {
		ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();
		int[] ruler = {1,2,1,1,2,2};
		int n = ruler.length;
		int[][] edges = 
		{
		    {1,2},
		    {2,3},
		    {2,5},
		    {1,4},
		    {4,5},
		    {5,6},
		    {6,3},
		    {4,6}
		};
		for(int i=0; i<=n; i++){
		    adj.add(new ArrayList<Pair>());
		}
		
		for(int[] arr : edges){
		    adj.get(arr[0]).add(new Pair(arr[1], ruler[arr[1]-1]));
		}
		
		 System.out.println(dfs(new Pair(1, ruler[0]), adj));
	}
	
	static int dfs(Pair s, ArrayList<ArrayList<Pair>> adj){
	    int size = 1;
	    int temp=1;
	    for(Pair n : adj.get(s.getCity())){
	        if(n.getRuler() != s.ruler)
                temp = dfs(n, adj);
            if(temp >= size)
                size = 1+temp;
	    }
	    
	    return size;
	}
}
