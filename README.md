# Alo4J
Additional Logger Option for Java

## Versioning
This library is now 0.1<br/>
I am developing this and update continuously.<br/>
0.1 version is now working but it might have some issue.<br/>
If you found bugs. please send me the detail.<br/>
email : cho.yh.kin@gmail.com

### How to use?
Just put the Jar file to your project and use it!<br/>
There are two Jar file.
- Alo4J for Java5 ~ Java7
- Alo4J8 for Java8 
(Alo4J8 use lambda.)

First, you make Alo4JWrapper which wrap Slf4j Logger.
```
Logger logger = LoggerFactory.getLogger(SampleService.class); // Slf4j Logger
Alo4JWrapper loggerWrapper = Alo4JWrapper.wrap(logger);
```

Then, you can use functions of Alo4J

#### print currentLocation
```
// with static import
loggerWrapper.warn(currentLocation("here!!"));

// without static import "Alo4JHelper"
loggerWrapper.warn(Alo4JHelper.currentLocation("here!!"));
```
then result is
```
22:33:48.129 [main] WARN  org.test.Sample - here!! >> at org.test.Sample.target(Sample.java:20)
```
This is useful because you can find log location easily and <br/>
if you use IDE, you can move to the location only click the line "(SampleClass.java:20)" (just like exception stackTrace)

#### print Object variables
```
// with static import
logWrapper.trace(variableOf("param", obj));

// without static import "Alo4JHelper"
logWrapper.trace(Alo4JHelper.variableOf("param", obj));
```
result is
```
target<resources.variable.VariablePrivateVariable>
> param.name<String>: kin
> param.age<int>: 31
> param.weight<double>: 60.1
> param.isMale<boolean>: true
> param.stringList[0]: abc
> param.stringList[1]: def
> param.stringList[2]: ghi
```
This print all (include private) variables.

#### control logging
```
// in Java8 (using lambda)
loggerWrapper.when(()->{return condition;})
			.trace(()->{return "logging message";});


// in Java5~Java7
loggerWrapper.when(new Condition() {
	protected boolean run() {
		return condition;
	}
}).trace(new Log() {
	public String print() {
		return "logging message";
	}
});
```
Above code is same with
```
if(logger.isTrace()){
	if(condition){
		logger.trace("this is trace in F.run");
	}
}
```
You don't need to use if statement which make difficult to read code and spend time<br/>
Especially If you use Java8, you can improve readability and performance.


#### method begin and end logging
method begin
```
// with static import
logWrapper.trace(Alo4JHelper.methodBegin(param1, param2));

// without static import "Alo4JHelper"
logWrapper.trace(methodBegin(param1, param2));
```
resut is 
```
Begin method [printMethodBegin]
param[0]<java.lang.String>: param1-String
param[1]<java.lang.Integer>: 123
```
method end
```
// with static import
logWrapper.trace(Alo4JHelper.methodEnd(resultValue));

// without static import "Alo4JHelper"
logWrapper.trace(methodEnd(resultValue));
```
resut is 
```
End method [printMethodEnd]
return<java.lang.Boolean>: false
```

## Download Jar files
- Alo4J for Java5~7 (Alo4J): http://file.upload.pe/aAc
- Alo4J for Java8 (Alo4J8): http://file.upload.pe/aAd
