//Link: https://www.interviewbit.com/problems/largest-distance-between-nodes-of-a-tree/

//Time & Space Complexity:

int ans;
 
int maxLen(int u, vector<int> adj[], int p)
{
    vector<int> v;
 
    for(auto x : adj[u])
    {
        if(x!=p)
        {
            v.push_back(maxLen(x, adj, u));
        }
    }
 
    int nv = v.size();
 
    if(nv == 0)
    {
        ans = max(ans, 1);
        return 1;
    }
 
    if(nv == 1)
    {
        ans = max(ans, v[0] + 1);
        return v[0] + 1;
    }
 
    sort(v.rbegin(), v.rend());
 
    ans = max(ans, v[0] + v[1] + 1);
    return v[0] + 1;
}
 
int Solution::solve(vector<int> &A)
{
    int n = A.size();
 
    vector<int> adj[n];
 
    for(int i=0;i<n;i++)
    {
        if(A[i] == -1)
            continue;
 
        adj[A[i]].push_back(i);
        adj[i].push_back(A[i]);
    }
 
    ans = INT_MIN;
 
    maxLen(0, adj, -1);
 
    return ans-1;
