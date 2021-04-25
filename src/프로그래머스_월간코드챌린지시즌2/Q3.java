package 프로그래머스_월간코드챌린지시즌2;

/*

문제 설명
각 점에 가중치가 부여된 트리가 주어집니다. 당신은 다음 연산을 통하여, 이 트리의 모든 점들의 가중치를 0으로 만들고자 합니다.

임의의 연결된 두 점을 골라서 한쪽은 1 증가시키고, 다른 한쪽은 1 감소시킵니다.
하지만, 모든 트리가 위의 행동을 통하여 모든 점들의 가중치를 0으로 만들 수 있는 것은 아닙니다. 당신은 주어진 트리에 대해서 해당 사항이 가능한지 판별하고, 만약 가능하다면 최소한의 행동을 통하여 모든 점들의 가중치를 0으로 만들고자 합니다.

트리의 각 점의 가중치를 의미하는 1차원 정수 배열 a와 트리의 간선 정보를 의미하는 edges가 매개변수로 주어집니다. 주어진 행동을 통해 트리의 모든 점들의 가중치를 0으로 만드는 것이 불가능하다면 -1을, 가능하다면 최소 몇 번만에 가능한지를 찾아 return 하도록 solution 함수를 완성해주세요. (만약 처음부터 트리의 모든 정점의 가중치가 0이라면, 0을 return 해야 합니다.)

제한사항
a의 길이는 2 이상 300,000 이하입니다.
a의 모든 수는 각각 -1,000,000 이상 1,000,000 이하입니다.
a[i]는 i번 정점의 가중치를 의미합니다.
edges의 행의 개수는 (a의 길이 - 1)입니다.
edges의 각 행은 [u, v] 2개의 정수로 이루어져 있으며, 이는 u번 정점과 v번 정점이 간선으로 연결되어 있음을 의미합니다.
edges가 나타내는 그래프는 항상 트리로 주어집니다.
입출력 예
a	edges	result
[-5,0,2,1,2]	[[0,1],[3,4],[2,3],[0,3]]	9
[0,1,0]	[[0,1],[1,2]]	-1
입출력 예 설명
입출력 예 #1

다음 그림은 주어진 트리의 모든 정점의 가중치를 0으로 만드는 과정을 나타낸 것입니다.
all_zero_example.png

2번 정점과 3번 정점을 선택하여 2번 정점은 1 감소시키고, 3번 정점은 1 증가시킵니다. (2번 반복)
3번 정점과 4번 정점을 선택하여 4번 정점은 1 감소시키고, 3번 정점은 1 증가시킵니다. (2번 반복)
0번 정점과 3번 정점을 선택하여 3번 정점은 1 감소시키고, 0번 정점은 1 증가시킵니다. (5번 반복)
모든 정점의 가중치를 0으로 만드는 데 필요한 최소 행동 횟수는 9번이므로, 9를 return 해야 합니다.
입출력 예 #2

주어진 트리는 모든 정점의 가중치를 0으로 만드는 것이 불가능하므로, -1을 return 해야 합니다.

*/

public class Q3 {
	public static void main(String[] args) {
		int a[] = {-5,0,2,1,2};
		int edges[][] = 
			{
				{0, 1},
				{3, 4},
				{2, 3},
				{0, 3}
			};
		
//		int a[] = {0, 1, 0};
//		int edges[][] = 
//			{
//				{0, 1},
//				{1, 2}
//			};
			
		System.out.println(solution(a, edges));
	}
	
	public static long solution(int[] a, int[][] edges) {
        long answer = 0;
        int len = a.length;
        int parent[] = init(len);
        for(int i = 0; i < edges.length; i++) {
        	union(parent, edges[i][0], edges[i][1]);
        }
        
        if(!findParent(parent, a)) {
        	return -1;
        }
        boolean check = false;
        for(int i = 0; i < len; i++) {
        	if(a[i] == 0) {
        		check = true;
        	}else {
        		check = false;
        		break;
        	}
        }
        if(check) return 0;
        
        // 가중치가 제일 큰놈은 움직이지 않는다.
        
        return answer;
    }
	
	private static void dfs(int node) {
		
	}
        
    private static int[] init(int len) {
    	int parent[] = new int[len];
    	
    	for(int i = 0; i < len; i++) {
    		parent[i] = i;
    	}
    	
    	return parent;
    }
    
    private static int find(int[] parent, int x) {
    	if(parent[x] == x) {
    		return x;
    	}
    	
    	return find(parent, parent[x]);
    }
    
    private static void union(int[] parent, int a, int b) {
    	a = find(parent, a);
    	b = find(parent, b);
    	
    	if(a < b) {
    		parent[b] = a;
    	}else {
    		parent[a] = b;
    	}
    }
    
    private static boolean findParent(int[] parent, int[] a) {
    	for(int i = 0; i < parent.length; i++) {
    		int x = find(parent, i);
    		if(x == i) {
    			if(!sumParent(parent, a, x)) {
    				return false;
    			}
    		}
    	}
    	
    	return true;
    }
    
    private static boolean sumParent(int[] parent, int[] a, int x) {
    	long sum = 0;
    	for(int i = 0; i < parent.length; i++) {
    		if(find(parent, i) == x) {
    			sum += a[i];
    		}
    	}
    	
    	if(sum != 0) {
    		return false;
    	}
    	
    	return true;
    }
    
    private static void print(int[] parent) {
    	for(int i = 0; i < parent.length; i++) {
    		System.out.print(parent[i] + " ");
    	}
    }
}
