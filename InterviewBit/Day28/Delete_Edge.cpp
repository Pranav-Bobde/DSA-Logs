//Link: https://www.interviewbit.com/problems/delete-edge/

//Time & Space Complexity: 

const int M = 1e9+7;
typedef vector<int> vi;
void dfs(int u, int par, vector<int> graph[], vi &subTreeSum, vi &val){
    subTreeSum[u] += val[u-1];
    for(int child:graph[u]){
        if(child == par) continue;
        dfs(child, u, graph, subTreeSum, val);
        subTreeSum[u] += subTreeSum[child];
    }
}
int Solution::deleteEdge(vector<int> &A, vector<vector<int> > &B) {
    int N = A.size();
    vi graph[N+1];
    vi subTreeSum(N+1, 0);
    for(auto edge:B){
        graph[edge[0]].push_back(edge[1]);
        graph[edge[1]].push_back(edge[0]);
    }
    dfs(1, 0, graph, subTreeSum, A);
    long long ans = 0;
    for(int i=2; i<=N; i++){
        int part1 = subTreeSum[i];
        int part2 = subTreeSum[1] - part1;
        ans = max((part1*1LL*part2)%M, ans);
    }
    return ans;
}
