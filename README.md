# testcase
Application for an xml validation via an xsd schema and counting xml elements occurrences.

Hello!

## Getting Started

You can clone the project or download a jar file with libs (in the root of the repo).

### Prerequisites

All you have to do is to set 2 resource file. First one is xml file and the second is xsd file. 

You can take my files:
 [valid xml](https://github.com/Prayzer/testcase/blob/master/src/test/resources/xml/valid_records.xml) 
 /
 [invalid xml](https://github.com/Prayzer/testcase/blob/master/src/test/resources/xml/invalid_records.xml) 
 and 
 [xsd](https://github.com/Prayzer/testcase/blob/master/src/test/resources/records.xsd) 

### Run jar with cmd

It is easy to run the jar file with following commad(do not forget to insert your paths!):

java -jar testcase-1.0-SNAPSHOT-jar-with-dependencies.jar path\to\an\xml path\to\an\xsd

for me it looks like this:

java -jar testcase-1.0-SNAPSHOT-jar-with-dependencies.jar C:\resources\xml\valid_records.xml C:\resources\records.xsd

### Create jar from Intellij Idea

Open Maven plugin controller on the right side and do these steps:
1. clean
2. compile
3. assembly:single goal in the Plugins/assembly

After that a new jar will be created! 

