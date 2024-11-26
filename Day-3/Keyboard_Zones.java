// In a futuristic virtual reality (VR) game world, players are provided with custom VR keypads that are similar to modern American keyboards but have some restrictions. The keypad is divided into three distinct zones, and each zone contains specific letters that the player can use for a task.
// 	- Zone 1: Letters on the top row: "qwertyuiop"
// 	- Zone 2: Letters on the middle row: "asdfghjkl"
// 	- Zone 3: Letters on the bottom row: "zxcvbnm"

// Players are given a set of secret codes (words), and they must type these codes using only letters from one zone at a time. If a word uses letters from more than one zone, it will be considered invalid and cannot be typed.

// Your task is to help the players by filtering out the valid secret codes (words) that can be typed using letters from only one zone.

// Given a list of secret codes (words), return the codes that can be typed using letters from only one zone of the VR keypad.

// Constraints:
// ------------
// 1 ≤ secretCodes.length ≤ 20
// 1 ≤ secretCodes[i].length ≤ 100
// secretCodes[i] consists of English letters (both lowercase and uppercase).

// Input Format:
// -------------
// Space separated words, secretCodes[]

// Output Format:
// --------------
// A list of codes that can be typed using letters from only one zone.


// Sample Input-1:
// ---------------
// Galaxy Mars Venus Sky

// Sample Output-1:
// ----------------
// ["Mars", "Sky"]

// Explanation:
// ------------
// "Mars" can be typed using only Zone 2.
// "Sky" can be typed using only Zone 3.
// "Galaxy" and "Venus" use letters from multiple zones and are thus invalid.


// Sample Input-2:
// ---------------
// keyboard monkey

// Sample Output-2:
// ----------------
// []

// Explanation:
// ------------
// None of the words can be typed using letters from only one zone.


// Sample Input-3:
// ---------------
// qw er ty

// Sample Output-3:
// ----------------
// ["qw", "er", "ty"]

// Explanation:
// ------------
// All the codes can be typed using only letters from Zone 1.

import java.util.*;

public class Keyboard_Zones{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] inp = sc.nextLine().split(" ");
        
        ArrayList<String> res = new ArrayList<>();

        ArrayList<Character> zone1 = new ArrayList<>(Arrays.asList('q','w','e','r','t','y','u','i','o','p','Q','W','E','R','T','Y','U','I','O','P'));
        ArrayList<Character> zone2 = new ArrayList<>(Arrays.asList('a','s','d','f','g','h','j','k','l','A','S','D','F','G','H','J','K','L'));
        ArrayList<Character> zone3 = new ArrayList<>(Arrays.asList('z','x','c','v','b','n','m','Z','X','C','V','B','N','M'));
        
        for(String i : inp){
            char c = i.charAt(0);
            if(zone1.contains(c)){
                if(check(i,zone1)){
                    res.add(i);
                }
            }
            else if(zone2.contains(c)){
                if(check(i,zone2)){
                    res.add(i);
                }
            }
            else if(zone3.contains(c)){
                if(check(i,zone3)){
                    res.add(i);
                }
            }
        }
        System.out.println(res);
        sc.close();
    }
    public static boolean check(String s, ArrayList<Character> zone){
        for(char c : s.toCharArray()){
            if(!zone.contains(c)){
                return false;
            }
        }
        return true;
    }
}