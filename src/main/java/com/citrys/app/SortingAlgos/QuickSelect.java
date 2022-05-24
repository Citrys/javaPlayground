import java.util.*;

class MedianOfAStream {

    LinkedList<Integer> nums = new LinkedList<>();

    public void insertNum(int num) {
        nums.add(num);
    }

    public double findMedian() {
        if (nums.size() == 0) {
            return 0;
        }
        if (nums.size() % 2 == 0) {
            return nums.get(nums.size()/2);
        } else {
            return (nums.get(nums.size()/2) + nums.get(nums.size()/2 + 1)) / 2;
        }
    }

    public static void main(String[] args) {
        MedianOfAStream medianOfAStream = new MedianOfAStream();
        medianOfAStream.insertNum(3);
        medianOfAStream.insertNum(1);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(5);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(4);
        System.out.println("The median is: " + medianOfAStream.findMedian());
    }
}
