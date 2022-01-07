package 개인문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 송연16_버븦정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int arrays[] = { 5, 3, 7, 2, 11,1 };
//        bubble_sort(arrays);
        insert_sort(arrays);
        System.out.println(Arrays.toString(arrays));
    }

    //삽입정렬
    public  static void insert_sort(int arrays[]){
        for(int i=1;i<arrays.length;i++){
            for(int j=0;j<i;j++){
                //자리바꾼 오른쪽으로 밀어냄
                if(arrays[i]<arrays[j]){
                    int key =arrays[i];
                    for(int k=i;k>j;k-- )
                        arrays[k] = arrays[k-1];
                    arrays[j] = key;
                }
            }
        }
    }
    //버블정렬
    public static void bubble_sort(int arrays[]){
        int index = arrays.length;
        while(index-->0){
            for(int i=0;i<index-1;i++){
                if(arrays[i]>arrays[i+1]){
                    int temp = arrays[i];
                    arrays[i] = arrays[i+1];
                    arrays[i+1] = temp;
                }
            }
        }
    }
}
