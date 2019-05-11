package wsi.tasks;

public class Deleter {
    int[] L; 
    int[] R;
    int n;

    public Deleter(int n) {
        this.n = n;
        L = new int[n];
        R = new int[n];
        for (int i = 0; i < n; i++) {
            L[i] = i+1;
            R[i] = i-1;
        }
    }
    
    public int rightOf(int idx) {
        return R[idx];
    }
    public int leftOf(int idx) {
        return L[idx];
    }
    
    public void delete(int idx) {
        int r = R[idx];
        int l = L[idx];
        R[l] = r;
        L[r] = l;
    }
    
}
