package algo.google;

import com.leetds.TreeNode;

import java.util.*;

public class Easy {

    public static void main(String[] args){
        Easy main=new Easy();
       // main.findMissingRanges(new int[]{2147483647},0,2147483647);
        main.productProcess();

    }
    void productProcess(){
        HashMap<String,Map<String,List<String>>> map=new HashMap<>();
        map.computeIfAbsent("Move1",a->new HashMap<String,List<String>>());
        map.computeIfAbsent("Opr2",a->new HashMap<String,List<String>>());
        map.get("Move1").computeIfAbsent("ProductRequirement",a->new ArrayList<String>());
        map.get("Move1").computeIfAbsent("ProcessRequirement",a->new ArrayList<String>());
        map.get("Move1").get("ProductRequirement").add("6ProdReq2");
        map.get("Move1").get("ProcessRequirement").add("4ProcReq2");
        map.get("Opr2").computeIfAbsent("ProductRequirement",a->new ArrayList<String>());
        map.get("Opr2").computeIfAbsent("ProcessRequirement",a->new ArrayList<String>());
        map.get("Opr2").get("ProductRequirement").add("10ProdReq2");
        map.get("Opr2").get("ProductRequirement").add("5ProdReq2");
        map.get("Opr2").get("ProcessRequirement").add("3ProcReq1");
        Iterator<Map.Entry<String,Map<String,List<String>>>>iterator=map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String,Map<String,List<String>>> entry=iterator.next();
            print(entry.getValue(),entry.getKey());
        }
    }
    public void print(Map<String,List<String>> map,String key){
       Iterator<Map.Entry<String,List<String>>>it= map.entrySet().iterator();
       while(it.hasNext()){
           Map.Entry<String,List<String>> entry=it.next();
          String prefix=""+key+":"+""+entry.getKey();
          Iterator<String> fieldIterator=entry.getValue().iterator();
          while(fieldIterator.hasNext()){
              System.out.println(prefix+":"+fieldIterator.next());
          }
       }
    }


    //2,1,5,6,2,3
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack=new Stack<>();
        int maxarea=0;
        int i=0;
        int n=heights.length;
        while(i<n){
            if(stack.isEmpty()||heights[stack.peek()]<=heights[i]){
                stack.push(i++);
            }else{
                //heights[i ] is now less than the item on top of stack ;
                int item=stack.peek();
                stack.pop();
                int current_area=heights[item]*(stack.isEmpty()?i:i-stack.peek()-1);
                maxarea=Math.max(current_area,maxarea);

            }
            while(!stack.isEmpty()){
                int s=stack.peek();
                stack.pop();
                int current_area=heights[s]*(stack.isEmpty()?i:i-stack.peek()-1);
                maxarea=Math.max(current_area,maxarea);
            }
        }
        return maxarea;


    }

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result=new ArrayList<>();
        int start=lower;
        for(int i=0;i<nums.length;i++){
        if(nums[i]>lower){
            int i1=start;
            int i2=nums[i]-1;
            result.add(i1==i2?""+i1:""+i1+"->"+i2);

        }
        if(nums[i]!=Integer.MAX_VALUE)
        start=Math.max(start+1,nums[i]+1);
        else
            start=nums[i];

        }
        if(nums[nums.length-1]!=Integer.MAX_VALUE&&start<=upper){
            result.add(start==upper?""+upper:""+start+"->"+upper);
        }
       return result;

    }

    int minJumps(int[] arr){


        
        return -1;
    }








    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        int n=indexes.length;
        int len=S.length();
        String[] ans=new String[len];
        for(int i=0;i<len;i++){
            ans[i]=""+S.charAt(i);
        }
        for(int i=0;i<n;i++){
            int index=indexes[i];
            int l1=sources[i].length();
            if(index+l1-1<len){
                String subStr=S.substring(index,index+l1);
                if(subStr.equals(sources[i])){
                    ans[index]=targets[i];
                    for(int j=1;j<l1;j++){
                        ans[index+j]=null;
                    }
                }
            }
        }
        String res="";
        for(String s:ans){
            if(s!=null)
            res=res+s;
        }
        return res;
    }




    public int minSumOfLengths(int[] arr, int target) {
            int n=arr.length;
            int[] left=new int[n];//min length till index i from left
            int[] right=new int[n]; // min length starting at index i from right
            HashMap<Integer,Integer> mapFromLeft=new HashMap<>();
        HashMap<Integer,Integer> mapFromRight=new HashMap<>();

            int s1=arr[0];
            mapFromLeft.put(s1,0);
            left[0]=s1==target?1:0;

            for(int i=1;i<n-1;i++) {
                s1 += arr[i];
                mapFromLeft.put(s1, i);
                int i1 = mapFromLeft.getOrDefault(s1 - target, -1);

                int i2 = mapFromLeft.getOrDefault(s1, -1);


                if(i1!=-1){

                    left[i]=Math.min(left[i-1],i-i1);

            }else
                    left[i]=left[i-1];
            }
            int s2=arr[n-1];
            mapFromRight.put(s2,n-1);
            right[n-1]=arr[n-1]==target?1:0;

            for(int i=n-2;i>-1;i--){
            s2+=arr[i];
            mapFromRight.put(s1,i);
            int i1=mapFromRight.getOrDefault(s2-target,-1);

            int i2=mapFromRight.getOrDefault(s1,-1);


            if(i1!=-1)
                right[i]=right[i+1]!=0?Math.min(right[i+1],i1-i):i1-i;
            else
                right[i]=right[i+1];

        }
            int len=Integer.MAX_VALUE;
            for(int i=0;i<n-1;i++){
              if(left[i]!=0&&right[i+1]!=0)
              len=Math.min(left[i]+right[i+1],len);
            }
            return len==Integer.MAX_VALUE?-1:len;



            }







//[1,1,1]
    // dp[i]
    public int subarraySum(int[] nums, int k) {
       HashMap<Integer,Integer>map=new HashMap<>();
        map.put(0,1);
        int count =0;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            sum+=num;
            if(map.containsKey(sum-k)){
                count+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
    //4,7,9,10]  k=3  8
    public int missingElement(int[] nums, int k) {
        return 0;

    }
    private int missing(int[] nums,int k,int idx){
        int diff=nums[idx]-nums[0]-(idx);
       return diff;

    }


    public boolean validateStackSequences(int[] pushed, int[] popped) {
            Stack<Integer> stack=new Stack<>();
            Set<Integer> set=new HashSet<>();
            int i=0,j=0;
            int n=popped.length;
            while(i<=n&&j<n){

                if(set.contains(popped[j])){
                    if(stack.peek()==popped[j])
                    {
                        set.remove(popped[j]);
                        j++;
                        stack.pop();
                        if(j==n) return true;
                    }else
                        return false;
                }else {
                    if(i==n) break;
                    set.add(pushed[i]);
                    stack.add(pushed[i]);
                    i++;
                }

            }
            return false;

    }
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        //TreeNode root=new TreeNode(manager[headID]);
        HashMap<Integer,HashSet<Integer>> parentToChildMap=new HashMap<>();
        for(int i=0;i<manager.length;i++){
            int child=i;
            int parent=manager[i];
            if(child!=headID){
                if(!parentToChildMap.containsKey(parent)){
                    parentToChildMap.put(parent,new HashSet<Integer>());
                }
                parentToChildMap.get(parent).add(child);
            }
        }
        HashSet<Integer> visited=new HashSet<>();



        return getTime(headID,parentToChildMap,visited,informTime);
    }
    public int getTime(int node,HashMap<Integer,HashSet<Integer>> hierarchyMap,HashSet<Integer> visited,int[] inform){

        HashSet<Integer> childs=hierarchyMap.getOrDefault(node,null);
        int time=inform[node];
        if(childs==null) return 0;
        Iterator<Integer>it=childs.iterator();
        int t=0;
        visited.add(node);
        while(it.hasNext())
        {
            int ch=it.next();
            if(!visited.contains(ch)){
                t=Math.max(t,getTime(ch,hierarchyMap,visited,inform));
            }

        }
        return time+t;

    }

    //0,6,5,2,2,5,1,9,4
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int n=A.length;
        int[] sumEndingofLengthL=new int[n];
        int[] sumEndingofLengthM= new int[n];
        int[] sumFromLeft=new int[n];

        for(int i=0;i<n;i++){
            sumFromLeft[i]+=i>0?sumFromLeft[i-1]+A[i]:A[0];
        }
        sumEndingofLengthL[L-1]=sumFromLeft[L-1];
        for(int i=L;i<n;i++){
            sumEndingofLengthL[i]=sumFromLeft[i]-sumFromLeft[i-L];
        }
        sumEndingofLengthM[M-1]=sumFromLeft[M-1];
        for(int i=M;i<n;i++){
            sumEndingofLengthM[i]=sumFromLeft[i]-sumFromLeft[i-M];
        }
        int[] maxFromRight=new int[n];


        int[] rightsumL=new int[n];
        int[] rightsumM= new int[n];
        int[] sumFromRight=new int[n];

        for(int i=n-1;i>-1;i--){
            sumFromRight[i]+=i<n-1?sumFromRight[i+1]+A[i]:A[n-1];
            rightsumL[i]=n-i<L?0:sumFromRight[i]-i<L-1?sumFromRight[i+L]:0;
            rightsumM[i]=n-i<M?0:sumFromRight[i]-i<M-1?sumFromRight[i+M]:0;
        }
return 0;

    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set=new HashSet<Integer>();
        for(int d:to_delete) set.add(d);
        List<TreeNode> result=new ArrayList<>();
        TreeNode node=delNode(root,set,result);
        if(node!=null) result.add(node);
        return result;


    }
    private TreeNode delNode(TreeNode node,Set<Integer> set,List<TreeNode> result){
        if(node==null) return null;
        node.left=delNode(node.left,set,result);
        node.right=delNode(node.right,set,result);
        if(set.contains(node.val))
        {
            if(node.left!=null)
                result.add(node.left);
            if(node.right!=null)
                result.add(node.right);
            return null;

        }
        return node;
    }
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        //use pre-order traversal
        if(root1==null&& root2==null) return true;
        if(root1==null||root2==null) return false;

        if(root1.val!=root2.val) return false;
        return (flipEquiv(root1.left,root2.left)&&flipEquiv(root1.right,root2.right))
                ||flipEquiv(root1.left,root2.right)&&flipEquiv(root1.right,root2.left);


    }
    public String getHint(String secret, String guess) {
        if(secret==null||secret.isEmpty()) return "";
        int n=secret.length();
        int[] count=new int[10];
        char[] a=secret.toCharArray();
        char[] b=guess.toCharArray();
        int bulls=0;
        int cows=0;
        for(int i=0;i<a.length;i++){
            if(a[i]==b[i]) {
                bulls++;
            }else{
                count[a[i]-'0']++;
            }
        }
        for(int i=0;i<b.length;i++){
            if(a[i]!=b[i]){
                if(a[b[i]-'0']>0) {
                    cows++;
                    a[b[i]-'0']--;
                }
            }
        }
        return ""+bulls+"A"+cows+"B";
    }
}
