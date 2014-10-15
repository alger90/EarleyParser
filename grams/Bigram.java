//package com.nlp.grams;
//
//public class Bigram extends NGram{
//
//	private String secondString;
//	
//	public Bigram(String str,String secString) {
//		super(str);
//		secondString = secString;
//	}
//	
//	@Override
//    public boolean equals(Object obj) {
//		if (!super.equals(obj)) {
//			return false;
//		}
//		Bigram otherBigram = (Bigram) obj;
//		return secondString.equals(otherBigram.secondString);
//	}
//	
//    @Override
//    public int hashCode() {
//        return super.hashCode() + secondString.hashCode();
//    }
//    
//    @Override
//    public String toString() {
//    	return super.toString() + ", " + secondString;
//    }
//}
