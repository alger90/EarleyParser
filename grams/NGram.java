package com.nlp.grams;

import java.util.Arrays;

public class NGram {
	
	private String[] string;
	
	public NGram(String str[]) {
		int size = str.length;
		string = new String[size];
		for (int i = 0; i < str.length; i++) {
			string[i] = str[i];
		}
	}
	
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        NGram other = (NGram) obj;
        if (!Arrays.equals(string, other.string))
            return false;
        return true;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(string);
        return result;
    }
    
    @Override
    public String toString() {
    	StringBuilder result = new StringBuilder(100);
    	result.append(this.getClass());
    	result.append(": ");
    	int i;
    	for (i = 0; i < string.length-1; i++) {
			result.append(string[i]);
			result.append(",");
		}
    	result.append(string[i]);
    	return result.toString();
    }
}
