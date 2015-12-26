##Question
Write a Java Program to control the speed and motion of a bouncing ball. A user defined Circle class contains the properties of the ball. (mass, velocity, position etc)

##Ideas
The behavior of a circle
1.	Velocity:  v+(dx, dy)
2.	Radius
3.	Mass
4.	Position: (x, y)
5.	Cases when two points collide together
	* X is same direction and y is not
		dx = dx, dy = -dy
	* Y is same direction and x is not
		dx = -dx, dy = dy
	* X is not same direction and y is not
		dx = -dx, dy = -dy
	* X is same direction and y is same too
		Swap dx and dy of two balls

##Design
According to the question, a user defined ```Circle``` class contains the properties of the ball, which includes mass, radius of circle, position (x and y) and velocity that contains direction of velocity (dx and dy) and absolute value (speed). The window which is a user defined class ```SpeedControlPanel``` extends JPanel  to display the ```circle```. In this window, I adopted ```JSlider``` object which can be used to control the speed of a single ball in real time.

##Description
In this program, the number of balls can be changed by simply modifying the variable CIRCLENUM, which is controlled by changing slider. Balls can bounce off the walls as well as off of each other. 

![img](https://dl.dropbox.com/s/o5kf834ytqaka73/1.jpg)

![img](https://dl.dropbox.com/s/cvqn7rmkdtjl7cs/2.jpg)