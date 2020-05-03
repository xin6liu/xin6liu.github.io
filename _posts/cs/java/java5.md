1. Stack
2. Heap 


Stack 底层一个区域用来放main()里面的variables. 

Variables inside of the main method, local variables local to the main method.

A specific reservation is going to be made for this variable.

Main method里面出现其他的method, e.g.: doWork(), 将会在stack里main的上面开辟一片区域储存doWork()里面的variables.

doWork()里面出现其他的method, e.g.: doWork2(), 将会在stack里doWork()的上面开辟一片区域储存doWork2()里面的variables.

doWork2运行完，就会被清除。doWork运行完，清除。

## reference variable

Car myCar;

This local **reference variable** belongs inside of main, 和之前的普通variable一样，在mian底层区域开辟一个reservation. 但此时我们还没有assign it a particular object.

这不是一个普通的variable, 它的type是一个class, 这是一个 reference variable, it refers to where the actual object resides in memory. **myCar** 储存的其实是the memory address right on the heap where this Car() object resides in memory

myCar = new Car()

object 实际存储在heap里

## instance variable

就是heap里面Class1的reference变量指向heap里的Class2