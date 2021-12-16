# Java Multithreading

This simple demonstration of multithreading in Java portrays thread-safe 
synchronization using the Producer-Consumer design paradigm. 


# 4 Classes are present:
  - ProdConMain --> Simple driver, handles input and creation of threads.
  - Hub --> Composed of a Integer Stack. Has Get() and Set() methods that are synchronized so as to prevent consumers from removing from empty stack.
      Consumers must wait if no items are present in the Stack.
  - Producer --> Implements Runnable interface. Adds random number in range 0-100 every 5 seconds for 1 minute.
  - Consumer --> Implements Runnable interface. Pops off value from stack.


# At program start: 
    Enter the initial number of producers you would like to create.
    These Producers will start generating.
    Consumers will pop one value from the Hub and end. 
                  
                  
# While program is running:
    Enter 1 to generate a new producer.
    Enter 2 to generate a new consumer.
    Enter 3 to generate 5 new consumers.
    Enter 4 to stop sending inputs and let all threads eventually come to an end. 
