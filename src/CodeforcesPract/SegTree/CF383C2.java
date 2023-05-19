package CodeforcesPract.SegTree;
import java.util.*;
import java.io.*;
public class CF383C2 {

    static int n,m,i,j,k,u,v,opt,tot;
    static int son[] =new int[200005];
    static int next[] = new int[400005];
    static int ed[] = new int[400005];
    static int flag[] = new int[200005];
    static int st[] = new int[200005];
    static int en[] = new int[200005];
    static int a[] = new int[200005];
    static long ans;
    static long sum[] = new long[1000005];

    static void dfs(int x){
        st[x]=++tot;
        for(int i=son[x];i>0;i=next[i])
            if(flag[ed[i]]==0){
                flag[ed[i]]=-flag[x];
                dfs(ed[i]);
            }
        en[x]=++tot;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        n = sc.nextInt();
        int m = sc.nextInt();

        for(i=1;i<=n;++i)
            a[i]=sc.nextInt();
        for(i=1;i<n;++i)
        {
            u = sc.nextInt();
            v = sc.nextInt();
            ++tot;next[tot]=son[u];son[u]=tot;ed[tot]=v;
            ++tot;next[tot]=son[v];son[v]=tot;ed[tot]=u;
        }
        tot=0;flag[1]=1;
        dfs(1);
        for(;m>0;--m)
        {
            opt = sc.nextInt();
            if(opt==1)
            {
                u = sc.nextInt();
                v = sc.nextInt();
                for(i=st[u];i<=tot;i+=i&-i)sum[i]+=flag[u]*v;
                for(i=en[u];i<=tot;i+=i&-i)sum[i]-=flag[u]*v;
            }
            else
            {
                u = sc.nextInt();

                ans=a[u];
                for(i=st[u];i>=1;i-=i&-i)ans+=flag[u]*sum[i];
                out.println(ans);
            }
        }
        out.flush();
    }
}
