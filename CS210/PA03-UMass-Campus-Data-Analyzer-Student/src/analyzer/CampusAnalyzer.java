//
// Copyright (c) 2025 Tim Richards. All rights reserved.
//
/*
 * Copyright 2025 Tim Richards.
 */
package analyzer;

import java.util.Arrays;


/**
 * UMass Campus Data Analyzer
 * This program analyzes campus building names, distances, and bus data.
 * 
 * Students will complete the TODO sections.
 */
public class CampusAnalyzer {

  /**
   * Finds the longest building name in the array.
   * 
   * @param buildings An array of building names.
   * @return The longest building name.
   */
  public static String findLongestName(String[] buildings) {
    int longest=0;
    String longestString="";
    for(String i:buildings){
      if(i.length()>longest){
        longest=i.length();
        longestString= i;
      }
    }
    return longestString;
  }

  /**
   * Reverses each building name and stores them in a new array.
   * 
   * @param buildings An array of building names.
   * @return A new array containing reversed names.
   */
  public static String[] reverseNames(String[] buildings) {
    String[] result=new String[buildings.length];
      for(int i=0;i<buildings.length;i++){
        String reversed="";
        for(int j=buildings[i].length()-1;j>=0;j--){
          reversed+=buildings[i].charAt(j);
        }
        result[i]=reversed; 
      }
    return result;
  }

  /**
   * Counts how often each letter (A-Z) appears across all building names.
   * 
   * @param buildings An array of building names.
   * @return An array of 26 integers, each representing letter frequency.
   */
  public static int[] countLetters(String[] buildings) {
    int[]result=new int[26];
    for(String i:buildings){
      i=i.toLowerCase();
      char[]letters=i.toCharArray();
      for(char j:letters){
        if(Character.isLetter(j)){
          int index=j-'a';
          result[index]+=1;
        }
      }
    }
    return result;
  }

  /**
   * Finds the closest building (smallest distance).
   * 
   * @param distances An array of distances from the Campus Center.
   * @return The smallest distance value.
   */
  public static double findMinDistance(double[] distances) {
    if(distances.length==0){
      return 0.0;
    }
    double min=distances[0];
    for(double i:distances){
      if (min>i){
         min=i;
      }
    }
    return min;
  }

  /**
   * Finds the farthest building (largest distance).
   * 
   * @param distances An array of distances from the Campus Center.
   * @return The largest distance value.
   */
  public static double findMaxDistance(double[] distances) {
    double max=0;
    for(double i:distances){
      if(max<i){
        max=i;
      }
    }
    return max;
  }

  /**
   * Computes the average distance.
   * 
   * @param distances An array of distances from the Campus Center.
   * @return The average distance.
   */
  public static double findAverageDistance(double[] distances) {
    if(distances.length==0){
      return 0.0;
    }
    double sum=0;
    for(double i:distances){
      sum+=i;
    }
    return sum/distances.length;
  }

  /**
   * Sorts an array of distances using Bubble Sort.
   * 
   * @param distances The array to be sorted.
   */
  public static void sortDistances(double[] distances) {
    for(int i=0; i<distances.length;i++){
        boolean swapped=false;
      for(int j=1;j<distances.length-i;j++){
        if(distances[j-1]>distances[j]){
          double temp=distances[j-1];
          distances[j-1]=distances[j];
          distances[j]=temp;
          swapped=true;
        }
      }
      if(!swapped){
          break;
      }
    }

  }

  /**
   * Finds the most crowded bus.
   * 
   * @param buses An array of Bus objects.
   * @return The bus with the highest passenger count.
   */
  public static Bus findMostCrowdedBus(Bus[] buses) {
    int max=buses[0].getCurrentPassengers();
    int index=0;
    for(int i=0;i<buses.length;i++){
      if(buses[i].getCurrentPassengers()>max){
        max=buses[i].getCurrentPassengers();
        index=i;
      }
    }
    return buses[index];
  }

  /**
   * Finds buses that are overloaded.
   * 
   * @param buses An array of Bus objects.
   * @return An array of overloaded buses.
   */
  public static Bus[] findOverloadedBuses(Bus[] buses) {
    int count=0;
    Bus[] overloadedBuses=new Bus[buses.length];
    for(Bus i:buses){
      if(i.getCurrentPassengers()>i.getMaxCapacity()){
        overloadedBuses[count]=i;
        count++;
      }
    }

    return Arrays.copyOf(overloadedBuses, count++);
  }

  /**
   * Sorts buses by passenger count using Bubble Sort.
   * 
   * @param buses The array to be sorted.
   */
  public static void sortBusesByPassengers(Bus[] buses) {
    for(int i=0; i<buses.length;i++){
      boolean swapped=false;
    for(int j=1;j<buses.length-i;j++){
      if(buses[j-1].getCurrentPassengers()>buses[j].getCurrentPassengers()){
        Bus temp=buses[j-1];
        buses[j-1]=buses[j];
        Bus[j]=temp;
        swapped=true;
      }
    }
    if(!swapped){
        break;
    }
  } 
        
  }
}