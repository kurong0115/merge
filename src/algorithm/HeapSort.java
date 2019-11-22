package algorithm;

import java.util.Random;

/**
 * @ClassName HeapSort
 * @Description 堆排序
 * @Author Administrator
 * @Date 2019/11/22 15:36
 * @Version 1.0
 */
public class HeapSort {
	static int[] nums;

	static {
		nums = new int[10];
		Random r = new Random();
		for (int i = 0; i < nums.length; i++){
			nums[i] = r.nextInt(50);
		}
	}

	public static void main(String[] args) {
		print(nums);
		heapSort();
		print(nums);
	}

	public static void heapSort(){
		int length = nums.length;
		for (int i = length - 1; i >= 0; i--){
			buildHeap(i, length);
		}
		for (int i = length - 1; i >= 0; i--){
			swap(0, i);
			buildHeap(0, --length);
		}
	}

	public static void buildHeap(int start, int end){
		int left = (start << 1) + 1;
		int right = (start << 1) + 2;
		int max = start;
		if (left < end && nums[left] > nums[max]){
			max = left;
		}
		if (right < end && nums[right] > nums[max]){
			max = right;
		}
		if (max > start){
			swap(max, start);
			buildHeap(max, end);
		}
	}

	public static void swap(int i, int j){
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	public static void print(int[] nums){
		for (int num: nums){
			System.out.print(num + "\t");
		}
		System.out.println();
	}
}
