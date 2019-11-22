package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName BucketSort
 * @Description 桶排序
 * @Author Administrator
 * @Date 2019/11/22 16:19
 * @Version 1.0
 */
public class BucketSort extends AbstractSort implements Sortable{

	private static final int MAX_LENGTH = 10;

	public BucketSort(){
		super();
	}

	@Override
	public void sort(int[] nums) {
		generateList();
	}

	protected void generateList(){
		List<List<Integer>> list = new ArrayList<>();
		for (int i = 0; i <= MAX_LENGTH; i++){
			List<Integer> tmp = new ArrayList<>();
			list.add(tmp);
		}
		int max = Integer.MIN_VALUE;
		for (int num: nums){
			if (num > max){
				max = num;
			}
		}
		int partition = max / MAX_LENGTH;
		for (int num: nums){
			list.get(num / partition).add(num);
		}
		int tmp = 0;
		for (int i = 0; i <= MAX_LENGTH; i++){
			List<Integer> c = list.get(i);
			Collections.sort(c);
			for (int j = 0; j < c.size(); j++){
				nums[tmp++] = c.get(j);
			}
		}
	}

	public static void main(String[] args) {
		BucketSort bucketSort = new BucketSort();
		bucketSort.generateList();
		bucketSort.print();
	}
}
