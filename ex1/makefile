# 204064257
# menahea1

compile: bin
	javac -cp src -d bin src/Factorial.java src/DescribeNumbers.java src/Sort.java
check: 
	java -jar checkstyle/checkstyle-5.7-all.jar -c checkstyle/biuoop.xml src/*.java
run1:
	java -cp bin Factorial 5
run2:
	java -cp bin DescribeNumbers 12 2 3 -9 8
run3-1:
	java -cp bin Sort asc 12 2 3 -9 8 
run3-2:
	java -cp bin Sort desc 12 2 3 -9 8 
bin:
	mkdir bin
