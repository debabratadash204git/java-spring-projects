package graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
	
	private static int rottenOrange(char[][] grid) {
		
		int freshcount = 0;
		Queue<int[]> queue =  new LinkedList<>();
		
		for(int i =0; i < grid.length;i++) {
			for(int j = 0; j < grid[0].length ; j++ ) {
				
				if(grid[i][j] == '1')
					freshcount++;
				else if(grid[i][j] == '2')
					queue.offer(new int[]{i,j});
				
			}
		}
		int time = 0;
		while(!queue.isEmpty() && freshcount > 0) {
			
			int size = queue.size();
			
			
			for (int i =0 ; i< size;i++) {
				
				int[] loc = queue.poll();
				
				int x = loc[0];
				int y = loc[1];
				
				int[][] directions = {{x+1,y},{x-1,y},{x,y+1},{x,y-1}};
				
				for (int[] dir :directions) {
					
					int nx = dir[0];
					int ny = dir[1];
					
					if(nx <0 || ny<0 || nx>= grid.length || ny>= grid[0].length || grid[nx][ny] == '2') {
						continue;
						
					}
					
					grid[nx][ny] = '2';
					freshcount --;
					queue.offer(new int[]{nx,ny});
						
					
				}
				
			}
			
			time++;
			
		}
		
		return freshcount ==0 ? time: -1;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] [] grid = {{'1','1','1','2'},
				  		  {'1','1','2','1'},
				          {'1','1','2','1'},
				          {'1','1','2','1'}
				         };
		int time = rottenOrange(grid);
		
		System.out.println("Total time taken to rotten the orange ====  " + time );

	}

}
