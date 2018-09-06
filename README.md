Execute Program in docker
=====

This program can executed :
1) as a docker image.
2) as a java jar
3) as a simple java program

This contains following:

#1) As docker, docker file is present at location ./Assignment/Dockerfile and can be executed with command 

```
docker build -t test .
```

#2) program jar file located at ./Assignment/test.jar and this can be executed

```
java -jar test.jar
```

Note : make sure input.csv is placed under Assignment folder

#3) Main file has java main methods so it can be executed in ecliplse

**Test**

Test cases are written at in Testcases.feature file place at ./Testcases.feature

Scenario Outline: tc_verify_reverse_sorting

Given I use <inputtext> inputfile
When I execute my program
Then I see <message> message

Examples: 
	|inputtext				  		 			|output            						|
	|       									|file path is invalid 					|
	|input_with_proper_text.csv 				|words are sorted successfully			|  
	|input_with_empty_no_newline.csv			|file is empty							| 
	|input_with_spaces_only.csv  				|singleline is having only spaces		|
	|input_with_commas_only.csv 				|singleline has only comma symbol		|
	|input_with_commas_with_space_only.csv   	|singleline contains BLANK word			|
	|input_with_special_character.csv 			|singleline words contains non alphabet	|
	|input_with_numbers.csv 					|singleline words contains non alphabet	|
	|input_with_duplicate_words.csv				|words are sorted successfully			|