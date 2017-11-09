Steps to run the program from Maven:

1) mvn clean instal
2) Run the program:

mvn exec:java -Dexec.args="<input>"

Example:
mvn exec:java -Dexec.args="[94133,94133] [94200,94299] [94600,94699]"