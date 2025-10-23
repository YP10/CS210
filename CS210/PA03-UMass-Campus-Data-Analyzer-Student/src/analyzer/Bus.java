//
// Copyright (c) 2025 Tim Richards. All rights reserved.
//
/*
 * Copyright 2025 Tim Richards.
 */
package analyzer;
/**
 * Represents a UMass campus bus.
 */
public class Bus {
  private int busNumber;
  private String routeName;
  private int currentPassengers;
  private int maxCapacity;

  public Bus(int busNumber, String routeName, int currentPassengers, int maxCapacity) {
    this.busNumber=busNumber;
    this.routeName=routeName;
    if(maxCapacity<0){
      this.maxCapacity=0;
      }
    else{
      this.maxCapacity=maxCapacity;
    }
    if(currentPassengers>maxCapacity){
      this.currentPassengers=this.maxCapacity;
    }
    this.currentPassengers=currentPassengers;
  }
       
  

  public int getBusNumber() {
    return this.busNumber;
  }

  public String getRouteName() {
    return this.routeName;
  }

  public int getCurrentPassengers() {
    return this.currentPassengers;
  }

  public int getMaxCapacity() {
    return this.maxCapacity;
  }
  
  @Override
  public String toString() {
    String result=String.format("Bus %d (%s) - Passengers: %d, Max Capacity: %d",this.busNumber,this.routeName,this.currentPassengers,this.maxCapacity);
    // You must return a string that is EXACTLY 1 line long and
    // looks like this (without the double quotes):
    // "Bus 34 (Campus Shuttle Northbound) - Passengers: 50, Max Capacity: 60"
    return result;  
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + busNumber;
    result = prime * result + ((routeName == null) ? 0 : routeName.hashCode());
    result = prime * result + currentPassengers;
    result = prime * result + maxCapacity;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Bus other = (Bus) obj;
    if (busNumber != other.busNumber)
      return false;
    if (routeName == null) {
      if (other.routeName != null)
        return false;
    } else if (!routeName.equals(other.routeName))
      return false;
    if (currentPassengers != other.currentPassengers)
      return false;
    if (maxCapacity != other.maxCapacity)
      return false;
    return true;
  }
}