public class StringOperations {
    public static void main(String[] args){

    }
    public static boolean checkRecord(String s) {
        boolean isElligible = true;
        int absent = 0;
        int late = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'A'){
                absent++;
                late = 0;
            }
            else if(s.charAt(i) == 'L'){
                late++;
            }
            else{
                late = 0;
            }
            if(absent > 1 || late == 3){
                isElligible = false;
                break;
            }
        }
        return isElligible;
    }
}
