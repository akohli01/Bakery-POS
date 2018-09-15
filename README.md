Manhattan's Finest Bakery

This is a bakery ordering software for a superficial bakery named Manhattan's Finest Bakery. This application is written in Java and uses the old Java GUI Framework: Swing. This application allows the user to select bagels, muffins, cakes, or drinks for purchase.

Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

Prerequisites

Java SDK (At least version SE 8)
An Integrated Development Environment (Preferably Intellij IDEA - which was used to develop this software).


Testing

This project includes a runnable jar file that can be used to quickly run the current state of the application. The location of this jar file is in out/artifacts/Manhattan_s_Finest_Bakery_jar/Manhattan's Finest Bakery.jar

If you would like to modify the source files, the project structure is as follows...

The src directory contains all the java packages mentioned below.

The OrderItems package contains a java file for each edible item offered by this bakery. More edible items can be added to this package.
The OrderMain package contains a java file named OrderStart.java which is responsible for creating the initial GUI.
The OrderProcessor package contains a java file named OrderCalculator.java which is responsible for calculating the necessary costs for an order.
The OrderDatabase package is currently empty but will be used hold java files needed to establish connectivity with a database and perform necessary SQL commands.

Contributing

Currently no one.

License

This project is licensed under the MIT License - see the LICENSE.md file for details
