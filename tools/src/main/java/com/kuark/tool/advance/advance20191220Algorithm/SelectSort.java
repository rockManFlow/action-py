package com.kuark.tool.advance.advance20191220Algorithm;

/**
 * @author rock
 * @detail ѡ������ ʱ�临�Ӷ�Ҳ��O(n^2)
 * @date 2021/1/27 16:40
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = new int[]{9, 10, 5, 12, 6, 2, 1, 16, 8, 7};
        sort(arr);
        for(int a:arr){
            System.out.println(a);
        }
    }

    public static void sort(int[] arr){
        int len = arr.length;
        int minIndex, temp;
        for (int i = 0; i < len - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[minIndex]) {     // Ѱ����С����
                    minIndex = j;                 // ����С������������
                }
            }
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
