IN = src/*.java
OUTPUT = SliptOMatic
CC = javac -d .
PACKAGE = SplitOMatic
MAIN = SplitOMatic
MAINCLASS = $(PACKAGE)/$(MAIN)
JAR = jar cfe 
Target:
	$(CC) $(IN)
	$(JAR) $(OUTPUT).jar $(MAINCLASS) $(PACKAGE)
