package demo;
import java.util.Scanner;

public class Demo1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int casenum =1;
		//initialize
		while (in.hasNextLine()){
			int[][] board = new int[9][9];
            int row = 0;

            while (row<9){
                String line = in.nextLine().trim();
				if (line.isEmpty()) continue;
			
			//string to int
			for(int j=0;j<9;j++){
				board[row][j]=Character.getNumericValue(line.charAt(j));
			}
			row++;
		}
		System.out.println("Case "+casenum+": "+ (answer(board)?"True"+".":"False"+"."));
		casenum++;
	}
}
	
	public static boolean group(int[] g){
		boolean[] seen = new boolean[9];
		for(int i=0;i<9;i++){
			int num=g[i];
			if (seen[num-1]){
				return false;
			}
			seen[num-1]=true;
		}
		return true;
	}

	public static boolean subgrid(int[][] board, int row, int col){
		boolean[] seen = new boolean[9];
		for (int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				int num = board[row+i][col+j];
				if(seen[num-1]) return false;
				seen[num-1]=true;
			}
		}		return true;
	}

	public static boolean answer(int[][] board){
		//row
		for (int i=0;i<9;i++){
			if (!group(board[i])){
				return false;
			}
		}

		//column
		for (int i=0;i<9;i++){
			int[] column = new int[9];
			for (int j=0;j<9;j++){
				column[j]=board[j][i];
			}	
			if(!group(column)){
				return false;
			}
		}
		
		//3*3 subgrid
		for (int i=0;i<9;i+=3){
            for (int j=0;j<9;j+=3){
                if (!subgrid(board,i,j)){
                    return false;
                }
            }
        }
		return true;
	}

}
