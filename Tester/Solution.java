class Solution {
    public static int convertNum(String num) {
        if (num == null) return -1;
        String fm = num.trim().toUpperCase();
        char firstChar = fm.charAt(0);
        String regex = "^(-|+){0,1}(0X){0,1}[0-9A-F]+$";
        if (firstChar == '-' || firstChar == '+') {
            
        } 
        else if (firstChar == '0')
        if (!fm.matches(regex)) {
            throw new IllegalArgumentException("Invalid input format");
        }
        else{

        }
        char[] array = fm.toCharArray();
        int result = 0;
        for (int i = array.length -1; i > -1; i--) {
            result = 16 * result + array[i] - '0';
        }
        return result;
    }

    public static void main(String[] args) {


        System.out.println();
    }
    
}