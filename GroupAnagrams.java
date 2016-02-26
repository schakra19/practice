import java.util.*;

public class GroupAnagrams{
  public static List<List<String>> groupAnagrams(ArrayList<String> input){
    HashMap<String, List<Integer>> group = new HashMap<String, List<Integer>>();
                ArrayList<List<String>> output = new ArrayList<List<String>>();
                for(String word: input){
                        String temp = word;
                        char[] c_arr = word.toCharArray();
                        Arrays.sort(c_arr);

                        String key = new String(c_arr);
                        if(group.containsKey(key)){
                                group.get(key).add(input.indexOf(word));
                        }
                        else{
                                ArrayList<Integer> collect = new ArrayList<Integer>();
                                collect.add(input.indexOf(word));
                                group.put(key,collect);
                        }

                }
                for(Map.Entry<String,List<Integer>> entry : group.entrySet()){
                        ArrayList<String> temp = new ArrayList<String>();
                        for(int i=0; i<entry.getValue().size(); i++){
                                temp.add(input.get(entry.getValue().get(i)));
                        }
                        output.add(temp);
                }
                return output;
        }
        public static void main(String[] args){
                ArrayList<String> list = new ArrayList<String>();
                list.add("cat");
                 list.add("god");
                list.add("man");
                list.add("act");
                list.add("dog");
                List<List<String>> output = groupAnagrams(list);
                for(int i=0; i<output.size(); i++){
                        for(int j=0; j<output.get(i).size(); j++)
                                System.out.print(output.get(i).get(j)+ " ");
                        System.out.println();
                }
        }
}

