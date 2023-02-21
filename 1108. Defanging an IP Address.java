1108. Defanging an IP Address.java
Problem : https://leetcode.com/problems/defanging-an-ip-address/
//a defanged IP address replaces every period with "[.]"
class Solution {
    public String defangIPaddr(String address) {
        return address.replace(".","[.]");
    }
}
