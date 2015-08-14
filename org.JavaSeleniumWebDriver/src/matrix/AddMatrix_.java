package matrix;

class AddMatrix_ {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Note: Rows and columns number for both matrix should be same then only it can be added.");
        System.out.println("enter the number of rows: ");
        int r = in.nextInt();
        System.out.println("enter the number of columns: ");
        int c = in.nextInt();
        
        int[][] m1 = getNumOfMatrix(in, r, c);
        int[][] m2 = getNumOfMatrix(in, r, c);
        int[][] m3 = addMatrix(r, c, m1, m2);
        System.out.println("1st Matrix: ");
        printMatrix(m1);
        System.out.println("2nd Matrix: ");
        printMatrix(m2);
        System.out.println("Addition of Matrix: ");
        printMatrix(m3);
        
    }
    public static int[][] getNumOfMatrix(Scanner in, int r, int c){
        int[][] m = new int[r][c];
        System.out.println("Enter the elements of matrix: ");
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                m[i][j] = in.nextInt();
            }
        }
        return m;
    }
    
    public static int[][] addMatrix(int r, int c, int[][] m1, int[][] m2){
        int[][] m = new int[r][c];
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                m[i][j] = m1[i][j] + m2[i][j];
            }
        }
        return m;
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
