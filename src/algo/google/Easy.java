package algo.google;

public class Easy {

    public static void main(String[] args){
        Easy main=new Easy();


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
