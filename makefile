# 204064257
# menahea1

compile: bin
	javac -cp biuoop-1.4.jar:src -d bin src/animations/*.java src/collidables/*.java src/designread/*.java src/game/*.java src/geometry/*.java src/levels/*.java src/listeners/*.java src/tasks/*.java
run:	
	java -cp biuoop-1.4.jar:bin Ass7Game
jar:
	jar cvfm ass7game.jar MANIFEST.MF -C bin .
bin:
	mkdir bin