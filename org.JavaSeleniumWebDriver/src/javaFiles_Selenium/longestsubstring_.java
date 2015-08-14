package javaFiles_Selenium;/*Find the Longest Substring in the given String Without Repetition of characters*/

import java.util.HashSet;
import java.util.Set;

class longestsubstring_ {

	private Set<String> subStrList = new HashSet<String>();
	private int finalSubStrSize = 0;

	public Set<String> getLongestSubstr(String input){
		//reset instance variables
		subStrList.clear();
		finalSubStrSize = 0;
		
		// have a boolean flag on each character ascii value
		boolean[] flag = new boolean[256];
		int j = 0;
		char[] inputCharArr = input.toCharArray();
		for (int i = 0; i < inputCharArr.length; i++) {
			char c = inputCharArr[i];
			if (flag[c]) {
				extractSubString(inputCharArr,j,i);
				for (int k = j; k < i; k++) {
					if (inputCharArr[k] == c) {
						j = k + 1;
						break;
					}
					flag[inputCharArr[k]] = false;
				} 
			} else {
				flag[c] = true;
			}
		}
		extractSubString(inputCharArr,j,inputCharArr.length);
		return subStrList;
	}


	private String extractSubString(char[] inputArr, int start, int end){

		StringBuilder sb = new StringBuilder();
		for(int i=start;i<end;i++){
			sb.append(inputArr[i]);
		}
		String subStr = sb.toString();
		if(subStr.length() > finalSubStrSize){
			finalSubStrSize = subStr.length();
			subStrList.clear();
			subStrList.add(subStr);
		} else if(subStr.length() == finalSubStrSize){
			subStrList.add(subStr);
		}

		return sb.toString();
	}

	public static void main(String a[]){
		longestsubstring_ mls = new longestsubstring_();
		System.out.println(mls.getLongestSubstr("automation_tester"));
		System.out.println(mls.getLongestSubstr("Selenium_Webdriver_is_AutomationTesting"));
		System.out.println(mls.getLongestSubstr("sdsjk_uippj_agjhs_7890"));
		System.out.println(mls.getLongestSubstr("abcabcbb"));
	}
}
