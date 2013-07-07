package  Leetcode; 

import java.util.Stack;

/*	Simplify path:
	Given an absolute path for a file (Unix-style), simplify it.

	For example,
	path = "/home/", => "/home"
	path = "/a/./b/../../c/", => "/c"
	path = "/" => "/"	
	path = "///" => "/"	
	path = "/home/../../.." => "/"
	path = "/home/foo/./.././bar" => "/home/bar"	
*/
public class SimplifyPath {
    public static String simplifyPath(String path) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String[] paths = path.split("/");
        Stack<String> s1 = new Stack<String> ();
        Stack<String> s2 = new Stack<String> ();
        StringBuilder sb = new StringBuilder ();
        
        for(String p : paths) {
            if(p.equals("..") && !s1.isEmpty())
                s1.pop();
            if(!p.equals("") && !p.equals(".") && !p.equals(".."))
                s1.push(p);
        }
        if(s1.isEmpty()) return "/";
        
        while(!s1.isEmpty()) {
            s2.push(s1.pop());
            s2.push("/");
        }
        while(!s2.isEmpty()) {
            sb.append(s2.pop());
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
    	SimplifyPath.simplifyPath("/././");
    }
}
