package sort_search;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SortString_Asce_DescOrder {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the input names and when you want to check then enter 'check' : ");
      
        List<String> input = new ArrayList<String>();
               
        while(true){
            String name = in.next();
            if(name.equals("check")){
                break;
            }
            input.add(name);
        }
        
        int i =0, j=0;
        for(; i<input.size()-1; i++){
            if(input.get(i).compareToIgnoreCase(input.get(i+1))>0){
                System.out.println("string arrary is not sorted in ascending order.");
                for(; j<input.size()-1; j++){
                    if(input.get(j).compareToIgnoreCase(input.get(j+1))<0){
                        System.out.println("string arrary is not sorted in descending order.");
                        break;
                    }
                }
                if(j==input.size()-1){
                    System.out.println("String array is sorted in descending order");
                }
                break;
            }
        }
        
        if(i==input.size()-1){
            System.out.println("String array is in ascending order");
        }
    }
}
