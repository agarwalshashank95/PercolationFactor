class PorusSolid{
    double newRun(int a){
        UnionFind uf = new UnionFind(a*a+2);
        int i=0,p,a2=a*a;
        int ar[]=new int[a2];
        int u,d,l,r;
        for(i=0;i<a2;i++){
            ar[i]=1;
        }
        for(i=0;i<a;i++){
            uf.union(i,a2);
        }
        for(i=a2-a;i<a2;i++){
            uf.union(i,a2+1);
        }
        int c=0;
        while(!uf.connected(a2,a2+1)){
            p=nextRnd(a2);
            if(ar[p]==0) continue;
            ar[p]=0;
            c++;
            u=up(a,p);
            d=down(a,p);
            l=left(a,p);
            r=right(a,p);
            if(ar[u]==0) uf.union(p,u);
            if(ar[d]==0) uf.union(p,d);
            if(ar[l]==0) uf.union(p,l);
            if(ar[r]==0) uf.union(p,r);
        }
        
        return (c+0.0d)/a2;
        
    }
    
    int up(int a,int i){
        if(i<a) return i;
        return i-a;
    }
    
    int down(int a, int i){
        if(i>=a*a-a) return i;
        return i+a;
    }
    
    int left(int a, int i){
        if(i%a==0) return i;
        return i-1;
    }
    
    int right(int a, int i){
        if(i%a==a-1) return i;
        return i+1;
    }
    
    int nextRnd(int n){
        return (int)(Math.random()*n);
    }
    
    public static void main(){
        PorusSolid ps = new PorusSolid();
        int i=0,num=5;
        double s=0;
        for(i=1;i<=num;i++){
            s+=ps.newRun(1000);
            if(i%100==0){
                System.out.println("i = "+i+"\t pf = "+(double)(s/i));
            }
        }
        System.out.println(s/num);
    }
}