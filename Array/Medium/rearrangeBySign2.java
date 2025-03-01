public class rearrangeBySign2 {
        public int[] rearrangeArray(int[] arr) {
            int len = arr.length;
            int n[] = new int[len];
            int pos = 0;
            int neg = 1;
            for(int i = 0;i<len;i++){
                if(arr[i]>0){
                    n[pos] = arr[i];
                    pos+=2;
                }
                else{
                    n[neg]= arr[i];
                    neg+=2; 
                }
            }       
            return n;    
        }
    
    
    
}
