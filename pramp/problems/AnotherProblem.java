import java.io.*;
import java.util.*;

class AnotherProblem {

    static int[] spiralCopy(int[][] inputMatrix) {

        if(inputMatrix == null || inputMatrix.length == 0){
            return new int[]{};
        }

        int[] result = new int[inputMatrix.length * inputMatrix[0].length];

        int count = 0;

        int left = 0;
        int right = inputMatrix.length - 1;
        int top = 0;
        int buttom = inputMatrix[0].length - 1;

        while(count < result.length){

            for(int i = left; i <= right && i < result.length; i++){
                result[count] = inputMatrix[top][i];
            }

            for(int i = top + 1; i <= buttom && i < result.length; i++){
                result[count] = inputMatrix[i][right];
            }

            for(int i = right - 1; i >= left && i < result.length; i--){
                result[count] = inputMatrix[buttom][i];
            }

            for(int i = buttom - 1; i >= top && i < result.length; i--){
                result[count] = inputMatrix[i][left];
            }

            left++;
            right--;
            top++;
            buttom--;
        }

        return result;
    }

    public static void main(String[] args) {


        int [][] inputMatrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        System.out.println(inputMatrix);

        // spiralCopy(inputMatrix);
    }

}