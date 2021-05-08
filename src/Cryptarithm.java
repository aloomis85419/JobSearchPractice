import java.util.HashMap;

public class Cryptarithm {

    boolean isCryptSolution(String[] crypt, char[][] solution) {
        HashMap<String, String>solutionMap = getSolutionMap(solution);
        long x = getCryptValue(crypt[0],solutionMap);
        long y = getCryptValue(crypt[1],solutionMap);
        long z = getCryptValue(crypt[2],solutionMap);
        if (x != -1 || y != -1) {
            if (x + y == z) {
                return true;
            }
        }
        return false;
    }


    long getCryptValue(String word, HashMap<String,String>solutionMap){
        String numeric = "";
        for(int i = 0; i < word.length(); i++){
            numeric+=solutionMap.get(String.valueOf(word.charAt(i)));
        }
        if (numeric.startsWith("0") && numeric.length() > 1){
            return -1;
        }
        return Long.valueOf(numeric);
    }

    HashMap<String,String> getSolutionMap(char[][] solution){
        HashMap<String,String>solutionMap = new HashMap<>();
        for (int i = 0; i < solution.length; i++){
            solutionMap.put(String.valueOf(solution[i][0]),String.valueOf(solution[i][1]));
        }
        return solutionMap;
    }



}
