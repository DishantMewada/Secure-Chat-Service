//Program to print the prime numbers below 200
//Using function to call sieveOfErathosthenes class
//using bool function to return or end the program 
//Author : VidyaSagar Vankayala
//Date : 13-Nov-2018

#include<iostream>
#include<string>
using namespace std;
// declaration of the function void sieveOfEratosthenes () for success or failure with return type
int  sieveOfEratosthenes(int n);
int main(){
    char user_choice{'y'};
    //Declaring return variable
    int return_type;
    //welcome message with user details
    cout<<"Welcome"<<" VidyaSagar Vankayala "<<endl<<"UL student with ID : 17044758 "<<endl;
    while(user_choice =='y' || user_choice == 'Y'){ 
    //asking the user for upper limit of the prime number
    cout<<"Enter the upper limit of the Prime numbers required: ";
    //User entering the vlaue   
    int upper_limit;
    cin>>upper_limit;
    return_type =  sieveOfEratosthenes(upper_limit);
    //Printing return value
    if (return_type == 0){
      cout<<"LIMIT_TOOSMALL"<<endl;  //Entering value is lower 
    }
    else if(return_type == 1){
      cout<<"LIMIT_TOOLARGE"<<endl;  // Entering value is higher 
    }
    else{
      cout<<"LIMIT_OK"<<endl;   // Entered value is between the given number
    }
    //Asking the user to run again
    cout<<"Do you want to run once more?[y/n]"<<endl;
    //user entering the choice 
    cin>>user_choice;
    }
    return EXIT_SUCCESS;
}

//enum class used to return the values of the ranges
enum Limit{
    //limits Declaration 
    LIMIT_TOOSMALL,
    LIMIT_TOOLARGE ,
    LIMIT_OK 
};
//function definition
int sieveOfEratosthenes(int n){
    //Limit evaluation using enum limit class
  Limit range;
    if(n <2){
        //Value returned as 0
        range =  LIMIT_TOOSMALL; 
        }
        else if(n>200) {
            //value returned as 1
            range =  LIMIT_TOOLARGE;
            }
            else{
                //If the value is within 2 to 200
                //intializing p as 2 as it is first prime number
                int p = 2;
                //declaring array to contain the N number given by user
                int numbers[n-1];
                //intializing the array using for loop
                for( int i=0; i<n-1;i++){
		  numbers[i] = 2+i;
		}                     
                    //Double for loop
                    //First for loop will intiate the P value
                    //second for loop will make the array filled with prime numbers
                    for (int i = 0; i<n-1; i++){
                        for (int j=0;j<n-1; j++){
                            //as per the “Sieve of Eratosthenes , dividing array eliments by p
                            //assgining zero values for perfect multiples of p
                            if (numbers[j]%p== 0 && numbers[j]!= p ){
                                numbers[j] = 0;
                                }
                                }
                                //Assigning P value to next prime number to get all the prime numbers
                                if (numbers[i]>p){  // initialize the array with numbers
                                    p = numbers[i];
                                    }
                                    }
                                //Printing all prime numbers
                                    for (int i=0;i<n-1;i++){
                                        if (numbers[i]!=0){
					  cout<<numbers[i]<<" ";
					}
				    }
				    cout<<""<<endl;

				    //value returned is 2 as per enum limit class
                                            range =  LIMIT_OK;
	    }
    return range;
}
    


   
    



