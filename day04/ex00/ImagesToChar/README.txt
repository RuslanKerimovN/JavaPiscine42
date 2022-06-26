## creating new dir for compilation files
mkdir target

## set the destination directory for class files
javac src/java/edu/school21/printer/*/*.java  -d ./target

## running a program with custom files
java -classpath ./target edu.school21.printer.app.Program . o /Users/botilia/Desktop/image.bmp

## deleting compilation dir
rm -rf target