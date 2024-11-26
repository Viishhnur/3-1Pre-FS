// 1st Oct

/*
You are managing a large network of IoT devices deployed across multiple cities.
Each device sends diagnostic information over the network, including its IP address. 
To maintain security and network integrity, you need to ensure that each device 
reports a valid IPv4 or IPv6 address. If a device reports an invalid address, 
it needs to be flagged for review and troubleshooting.

Write a program that takes a list of N device-reported IP addresses and classifies 
them as "IPv4", "IPv6", or "Invalid". Your task is to determine the correct format 
for each IP address and ensure no invalid IP addresses are allowed into the network.

Constraints:
------------
deviceIPs is a list of strings where each string is a potential IP address.
1 <= N <= 10^4
Each string in deviceIPs consists only of English letters(ELIGIBLE ONLY), digits, and 
the characters . and :.


Input Format:
-------------
Line-1: An integer N, number of IP addresses.
Next N lines:  a string, device-reported IP address

Output Format:
--------------
List of values, IPv4, IPv6, Invalid


Sample Input-1:
---------------
4
192.168.0.1
2001:0db8:85a3:0000:0000:8a2e:0370:7334
192.168.1.256
abcd:1234:5678:9abc:def0:1234:5678:90ab

Sample Output-1: 
----------------
["IPv4", "IPv6", "Invalid", "IPv6"]

Explanation:
------------
"192.168.0.1" is a valid IPv4 address.
"2001:0db8:85a3:0000:0000:8a2e:0370:7334" is a valid IPv6 address.
"192.168.1.256" is invalid because the segment exceeds 255, so it is "Neither".
"abcd:1234:5678:9abc:def0:1234:5678:90ab" is a valid IPv6 address.


Sample Input-2:
---------------
4
256.256.256.256
123.456.789.000
1.1.1.01
1234::5678

Sample Output-2: 
----------------
["Invalid", "Invalid", "Invalid", "Invalid"]

Explanation:
------------
"256.256.256.256" is invalid because no segment can exceed 255 in IPv4.
"123.456.789.000" is invalid because no IPv4 segment can exceed 255.
"1.1.1.01" is invalid due to leading zeros in the last segment.
"1234::5678" is invalid as IPv6 cannot have a shorthand "::" followed by incomplete segments.
*/

import java.util.*;
import java.util.regex.*;

public class ip_validate{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String regex_v4 = "^((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])\\.){3}(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])$";
        String regex_v6 = "^([0-9a-fA-F]{1,4}:){7}([0-9a-fA-F]{1,4})$";
        Pattern pattern = Pattern.compile(regex_v4);
        Pattern pattern2 = Pattern.compile(regex_v6);
        ArrayList<String> res = new ArrayList<String>();
        for(int i = 0;i<n;i++){
            String s = sc.nextLine();
            Matcher matcher = pattern.matcher(s);
            if(matcher.matches()){
                res.add("IPv4");
            }
            else{
                Matcher matcher2 = pattern2.matcher(s);
                if(matcher2.matches()){
                    res.add("IPv6");
                }
                else{
                    res.add("Invalid");
                }
            }
        }
        System.out.println(res);    
        sc.close();
    }
}