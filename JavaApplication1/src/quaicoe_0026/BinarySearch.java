/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package quaicoe_0026;

import javax.swing.JOptionPane;

/**
 *
 * @author Theophilus Quaicoe
 */
public class BinarySearch {

   static int Searching(int numbers[],int numberSize,int key){
   
   int mid = 0;
   int low = 0;
   int high = numberSize - 1;
   
     while(high >= low){
          mid =(high+low)/2 ;
          if(numbers[mid] < key){
          low = mid + 1 ;
          }
          else if(numbers[mid] > key){
              high = mid -1;
          }
          else {
          return mid;
          }
          }
      return -1 ; //not found
     
   }
 
}