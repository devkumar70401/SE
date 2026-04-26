

public class temp {
    public static void swap(Integer x,Integer y){
        System.out.println("hello");
        int temp = x;
        x=y;
        y=temp;
        
    }
    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5,6};
        swap(arr[0],arr[5]);
        for(int val:arr)
            System.out.println(val);
    }
}
