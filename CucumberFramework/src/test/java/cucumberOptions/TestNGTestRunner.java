package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features",glue="stepDefinitions",monochrome=true)
public class TestNGTestRunner extends AbstractTestNGCucumberTests{

}


//features="src/test/java/features" - providing path of features package
//glue="stepDefinitions"  - providing name of stepDefinitions package, as it will search inside src/test/java
//monochrome=true  - this makes output more readable , if false then we will see many aplhanumeric characters
//which will be hard to read
//dryRun=true - if u r not actually running and just want to see there is any mapping missing for any step in
//feature file and it will provide syntax for it

//run as testng test - we will get stepDefinitions