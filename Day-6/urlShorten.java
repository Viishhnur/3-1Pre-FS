/*
You are working on a team that is building a custom URL shortening service. The service 
needs to create unique, user-friendly abbreviations for long URLs, while ensuring that 
no two different URLs map to the same abbreviation.

To validate whether a custom abbreviation correctly maps to the original URL, your team 
has built an abbreviation validation system. However, the system must also check for 
compliance with the following rules:
	- The abbreviation can replace any number of non-adjacent, non-empty substrings 
	  in the URL with their lengths (as integers).
	- The lengths of these substrings must not have leading zeros.
	- Adjacent substrings cannot be replaced, and no empty substrings should be replaced.
	- The abbreviation must be able to fully and accurately recreate the original URL.

Your task is to implement a code that to determine if the abbreviation is valid for the given 
URL or not. If it is valid, print true, otherwise "false"


Constraints:
------------
1 <= URL.length <= 50, The URL consists of lowercase English letters.
1 <= abbr.length <= 20, abbr consists of lowercase English letters and digits.
All integers in abbr will fit in a 32-bit integer.


Input Format:
-------------
Line-1: Two space separated strings, URL and abbr.

Output Format:
-------------
A Boolean Value.


Sample Input-1:
---------------
hypertexttransferprotocol h23l

Sample Output-1:
----------------
true

Explanation:
------------
The abbreviation "h23l" corresponds to "h ypertexttransferprotoco l" where 
the substring "ypertexttransferprotoco" is replaced by its length of 23.


Sample Input-2:
---------------
applicationprogramminginterface app843minginterface

Sample Output-2: 
----------------
false

Explanation:
------------
The abbreviation "app843minginterface" corresponds to "app lication prog ram 
minginterface" where the substrings "lication", "prog", "ram" are adjacent 
substrings, and not allowed to be replaced


Sample Input-3:
---------------
webdevelopment webd0evelopment

Sample Output-3: 
----------------
false

Explanation:
------------
The abbreviation "webd0evelopment" is invalid because "0" is not allowed 
(no leading zeros, and an empty substring cannot be replaced).
*/
import java.util.*;

public class urlShorten {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String url = sc.next();
        String abbr = sc.next();

        int ti = 0;
        int ai = 0;

        sc.close();
        while (ai < abbr.length() && ti < url.length()) {
            if (Character.isDigit(abbr.charAt(ai))) {
                if (abbr.charAt(ai) == '0') {
                    System.out.println(false);
                    return;
                }

                int num = 0;
                while (ai < abbr.length() && Character.isDigit(abbr.charAt(ai))) {
                    num = num * 10 + (abbr.charAt(ai) - '0');
                    ai++;
                }
                ti += num;
                if (ti > url.length()) {
                    System.out.println(false);
                    return;
                }

            } 
            else {
                if (url.charAt(ti) != abbr.charAt(ai)) {
                    System.out.println(false);
                    return;
                }
                ti++;
                ai++;
            }
        }
        if (ti == url.length() && ai == abbr.length()) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}