class Solution {

    List<String> newAdded;
    public String countOfAtoms(String formula) {
        Map<String, Integer> elementCountMap= new TreeMap<>();

        Stack<String> stack = new Stack<>();

        char[] cha = formula.toCharArray();

        for(int i=0; i<cha.length; i++ ){


                if( cha[i]=='(' ){
                    stack.push( "" +cha[i]); 
                    continue;              
                }else  if( cha[i]==')' ) {
                    
                    System.out.println(stack);
                

                    StringBuilder dig= new StringBuilder();
                    while(i<cha.length-1 && isDigit(cha[i+1]) ){
                          dig.append(cha[++i]);
                    }

                    if( dig.toString().length()!=0){
                        int m= Integer.valueOf(dig.toString());

                        while( !stack.peek().equals("(")){
                            String key =  stack.pop(); 
                            elementCountMap.put( key, elementCountMap.get(key)*m );

                             System.out.println(elementCountMap);
                        }

                    }

                stack.pop();
                   
                }                
                elementCountMap=process(cha,elementCountMap, i , stack);
        }
        


        StringBuilder sb= new StringBuilder();
        for(Map.Entry<String,Integer> entry : elementCountMap.entrySet() ){
            sb.append( entry.getKey());
           
            if( entry.getValue() != 1) 
            sb.append( entry.getValue());

        }
        return sb.toString();
     }

    public boolean isUpper( char ch){
        return ch >='A' && ch<= 'Z';
    }

    public boolean isLower(char ch){
        return ch >= 'a' && ch <='z';
    }

    public boolean isDigit( char ch ){
        return ch >='0' && ch <= '9';
    }

    public Map<String, Integer> process(char[] cha,Map<String, Integer> elementCountMap, int i, Stack<String> stack){

          StringBuilder ele= new StringBuilder();
                    if( isUpper(cha[i]) ){
                        ele.append(cha[i]);
                        while( i<cha.length-1 && isLower(cha[i+1]) ){
                           
                              ele.append(cha[++i]);

    
                        }
                  

                    StringBuilder dig= new StringBuilder();
                    while(i<cha.length-1 && isDigit(cha[i+1]) ){
                          dig.append(cha[++i]);
                    }

                    if( !stack.isEmpty() ) stack.push( ele.toString());
                    
                    elementCountMap.put(ele.toString(), elementCountMap.getOrDefault( ele.toString(), 0)+ 
                    Integer.valueOf(dig.toString().length()  > 0 ? dig.toString() : "1"));

                    System.out.println(elementCountMap); }
            return elementCountMap;
        
    }
}


/**
726. Number of Atoms
Hard
Topics
Companies
Hint
Given a string formula representing a chemical formula, return the count of each atom.

The atomic element always starts with an uppercase character, then zero or more lowercase letters, representing the name.

One or more digits representing that element's count may follow if the count is greater than 1. If the count is 1, no digits will follow.

For example, "H2O" and "H2O2" are possible, but "H1O2" is impossible.
Two formulas are concatenated together to produce another formula.

For example, "H2O2He3Mg4" is also a formula.
A formula placed in parentheses, and a count (optionally added) is also a formula.

For example, "(H2O2)" and "(H2O2)3" are formulas.
Return the count of all elements as a string in the following form: the first name (in sorted order), followed by its count (if that count is more than 1), followed by the second name (in sorted order), followed by its count (if that count is more than 1), and so on.

The test cases are generated so that all the values in the output fit in a 32-bit integer.

 

Example 1:

Input: formula = "H2O"
Output: "H2O"
Explanation: The count of elements are {'H': 2, 'O': 1}.
Example 2:

Input: formula = "Mg(OH)2"
Output: "H2MgO2"
Explanation: The count of elements are {'H': 2, 'Mg': 1, 'O': 2}.
Example 3:

Input: formula = "K4(ON(SO3)2)2"
Output: "K4N2O14S4"
Explanation: The count of elements are {'K': 4, 'N': 2, 'O': 14, 'S': 4}.
 

Constraints:

1 <= formula.length <= 1000
formula consists of English letters, digits, '(', and ')'.
formula is always valid.


 */
