class rearrangeBySign {
    public int[] rearrangeArray(int[] arr) {
        int len = arr.length;
        int pos[] = new int[len/2];
        int neg[] = new int[len/2];
        int j = 0;
        int k = 0;
        for(int i=0;i<len;i++){
            if(arr[i]>0){
                pos[j] = arr[i];
                j++;
            }
            else{
                neg[k] = arr[i];
                k++;
            }
        }   
        j=0;
        k=0;
        for(int i=0;i<len;i++){
            if(i%2 == 0){
                arr[i] = pos[j];
                j++;
            }
            else{
                arr[i] = neg[k];
                k++;
            }
        }
        return arr;
    }
}
