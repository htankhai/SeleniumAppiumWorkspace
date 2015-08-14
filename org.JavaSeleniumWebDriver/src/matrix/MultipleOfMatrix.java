package matrix;

class MultipleOfMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
        System.out.println("enter the number of rows: ");
        int r = in.nextInt();
        System.out.println("enter the number of columns: ");
        int c = in.nextInt();
        int[][] m1 = new int[r][c];
        int[][] m2 = new int[c][r];
        int[][] m3 = new int[r][r];
        System.out.println("Enter the numbers for the 1st matrix: ");
        m1 = getNumOfMatrix(in, r, c, m1);
        System.out.println("Enter the numbers for the 2nd matrix: ");
        m2 = getNumOfMatrix(in, c, r, m2);
        m3 = multiplyMatrix(r,r,c,m1,m2,m3);
        
        System.out.println("1st matrix m1: ");
        printMatrix(m1);
        System.out.println("2nd matrix m2: ");
        printMatrix(m2);
        System.out.println("Multiplication of both the matrix m1 and m2: ");
        printMatrix(m3);
    }

    public static int[][] getNumOfMatrix(Scanner in, int r, int c, int[][] m){
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                m[i][j] = in.nextInt();
            }
        }
        return m;
    }
    
    public static int[][] multiplyMatrix(int r1, int c2, int c1,int[][] m1, int[][] m2, int[][] m3){
        int sum=0;
        for(int i=0; i<r1; i++){
            for(int j=0; j<c2; j++){
                sum=0;
                for(int k=0; k<c1; k++){
                    sum = sum+m1[i][k]*m2[k][j];
                }
                m3[i][j] = sum;
            }
        }
        return m3;
    }
    public static void printMatrix(int[][] m){
        for(int[] i: m){
            for(int j: i){
                System.out.print(" "+j);
            }
            System.out.println();
        }
	}

}
