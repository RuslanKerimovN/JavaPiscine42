## creating new dir for compilation files
mkdir target

## set the destination directory for class files
javac src/java/edu/school21/printer/*/*.java  -d ./target

## copy from resources to target
cp -R src/resources target/.

## make jar
jar -cf ./target/images-to-chars-printer.jar src/manifest.txt -C target .

## running a program with custom files
java -classpath ./target edu.school21.printer.app.Program . o

## deleting compilation dir
rm -rf target