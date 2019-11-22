package algorithm;

import java.util.Random;

/**
 * @ClassName AbstractSort
 * @Description TODO
 * @Author Administrator
 * @Date 2019/11/22 16:22
 * @Version 1.0
 */
public class AbstractSort {

	protected int[] nums;

	private static final int MAX_LENGTH = 100;

	public static final int MAX_NUM = 500;

	public AbstractSort(){
		nums = new int[MAX_LENGTH];
		putValue();
		print();
	}

	protected void print(){
		for (int num: nums){
			System.out.print(num + "\t");
		}
		System.out.println();
	}

	protected void putValue(){
		Random r = new Random();
		for (int i = 0; i < nums.length; i++){
			nums[i] = r.nextInt(MAX_NUM);
		}
	}

}
