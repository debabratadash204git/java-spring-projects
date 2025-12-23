package leetCode150;
import java.util.*;
import java.util.Arrays;


public class MeetingRoom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//int[][] intervals = {{1,5},{3,9},{6,8}}; - ----------> output false
		int[][] intervals = {{2,4},{9,12},{6,9},{13,15}};
		int[][] meetings = {{6,8},{4,6},{3,5},{8,9}};
		
		
		boolean valid = validIntervalTime(meetings);
		System.out.println("\n");
		System.out.println("meeting time valid ---> " + valid);
		
		int countRoom = countNumberOfRooms(meetings);
		System.out.println("\n");
		System.out.println("Count Number of meeting rooms ---> "  + countRoom);

	}

	private static int countNumberOfRooms(int[][] intervals) {
		
		List<Integer> startTime = new ArrayList<>();
		List<Integer> endTime = new ArrayList<>();
		
		for(int[] time : intervals) {
			startTime.add(time[0]);
			endTime.add(time[1]);
		}
		Collections.sort(startTime);
		Collections.sort(endTime);
		
		int totalRoom = 0;
		int j = 0;
		for(int i =0;i < startTime.size();i++) {
			
			if(startTime.get(i)< endTime.get(j)){
				totalRoom++;
			}
			else
				j++;
		}
		
		return totalRoom;
	}

	private static boolean validIntervalTime(int[][] intervals) {
		
		Arrays.sort(intervals,(a,b)->a[0]-b[0]);
		
		int j = 0; 
		int totalroom = 0;
		
		for(int i=0; i< intervals.length ; i++) {
			if(intervals[i][0] < intervals[j][1])
			{
				totalroom++;
			}
			else
				j++;
		}
		
		System.out.print("inside validIntervalTime logic ----->" + totalroom);
		
		for(int i = 1; i < intervals.length;i++) {
			if(intervals[i][0] > intervals[i-1][1])
			{
				return true;
			}
		}
		
		return false;
	}

}
