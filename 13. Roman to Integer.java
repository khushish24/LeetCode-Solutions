class Solution {
    public int romanToInt(String s) {
        int main=0;
        int num=0;
        int prev=0;
        for(int i=s.length()-1;i>=0;i--){
            switch (s.charAt(i)) {
            case 'M' -> num = 1000;
            case 'D' -> num = 500;
            case 'C' -> num = 100;
            case 'L' -> num = 50;
            case 'X' -> num = 10;
            case 'V' -> num = 5;
            case 'I' -> num = 1;
        }
        if(num<prev){
            main-=num;
        }else{
            main+=num;
        }
        prev=num;
        }
        return main;
    }
}
