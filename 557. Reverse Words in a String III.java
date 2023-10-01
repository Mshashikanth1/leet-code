class Solution {
    public String reverseWords(String s) {

        return String.join(" ",Arrays.stream(s.split(" "))
                                     .map(str->{ StringBuilder sb=new StringBuilder(str);
                                                  return sb.reverse().toString();  
                                                  })
                                      .collect(Collectors.toList()));
    }
}

/**

557. Reverse Words in a String III
Easy
5.5K
234
Companies
Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

 

Example 1:

Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Example 2:

Input: s = "God Ding"
Output: "doG gniD"
 

Constraints:

1 <= s.length <= 5 * 104
s contains printable ASCII characters.
s does not contain any leading or trailing spaces.
There is at least one word in s.
All the words in s are separated by a single space.
Accepted
777.2K
Submissions
941.5K
Acceptance Rate
82.6%
Seen this question in a real interview before?
1/4
Yes
No
 */
