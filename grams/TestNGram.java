package com.nlp.grams;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class TestNGram {

	private static HashMap<NGram, Double> uniGram;
	
	private static HashMap<NGram, Double> bigram;
	
	private static HashMap<NGram, Double> trigram;
	
	private static Scanner in;
	
	private static ArrayList<String> tokens;
	
	private TestNGram() {
		tokens = new ArrayList<String>();
		uniGram = new HashMap<NGram, Double>();
		bigram = new HashMap<NGram, Double>();
		trigram = new HashMap<NGram, Double>();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TestNGram gram = new TestNGram();
		File file = new File(args[0]);
		FileInputStream stream;
		try {
			stream = new FileInputStream(file);
			in = new Scanner(stream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		String line;
		String[] strs;
		while (in.hasNextLine()) {
			line = in.nextLine();
			strs = line.split(" ");
			Collections.addAll(tokens, strs);
		}
		
		in.close();
		
		getUnigramCount(trigram,3);
		
		printHashMap(trigram);
		
	}

	private static void printHashMap(HashMap<NGram, Double> gram) {
		Iterator iterator = gram.keySet().iterator(); 
		while (iterator.hasNext()) {
			NGram key = (NGram) iterator.next();
			Double value = (Double)gram.get(key);
			System.out.println("[" + key.toString() + "] " + value);
		}
	}
	
	/**
	 * 
	 */
	private static void getUnigramCount(HashMap<NGram, Double> map, int type) {
		for (int i = 0; i < tokens.size(); i++) {
			NGram gram = null;
			switch (type) {
			case 1:
				gram = new NGram(new String[]{tokens.get(i)});
				break;
			case 2:
				String token2;
				if (i == tokens.size()-1) {
					token2 = "*";
				}else{
					token2 = tokens.get(i+1);
				}
				
				gram = new NGram(new String[]{tokens.get(i),token2});
				break;
			case 3:
			default:
				String token3;
				String token4;
				if (i == tokens.size()-2) {
					token3 = tokens.get(i+1);
					token4 = "*";
				}else if(i == tokens.size()-1){
					token3 = "*";
					token4 = "*";
				}else {
					token3 = tokens.get(i+1);
					token4 = tokens.get(i+2);
				}
				gram = new NGram(new String[]{tokens.get(i),token3, token4});
				break;
			}
			if (map.keySet().contains(gram)) {
				map.put(gram, map.get(gram) + 1);
			}
			else {
				map.put(gram, 1.0);
			}
		}
	}
}
