Run tests simulating GET request within spring stack.<br/>
This example uses a simple Mock.<br/>
<br/>
compile & test :<br/>
mvn spring-boot:run<br/>
or<br/>
mvn test<br/>

<br/>
--HelloRepositoryImpl.java<br/>
public String get() {<br/>
&nbsp;&nbsp;return "Hello from HelloRepository";<br/>
<br/>
--HelloServiceImpl.java<br/>
@Autowired<br/>
HelloRepository helloRepository;<br/>
@Override<br/>
public String get() {<br/>
&nbsp;&nbsp;return helloRepository.get();<br/>
<br/>
--HelloServiceMockTest.java<br/>
<b>@Mock</b>//the mocked class<br/>
private HelloRepository helloRepository;<br/>
<b>@InjectMocks</b>//the class we inject the mocked class within<br/>
private HelloService helloService = new HelloServiceImpl();<br/>
@Test<br/>
void testReturnedValueWithMockito() {<br/>
&nbsp;&nbsp;//Arrange<br/>
&nbsp;&nbsp;<b>when(helloRepository.get()).thenReturn("Hello from Mockito mocked repository");</b><br/>
&nbsp;&nbsp;//Act<br/>
&nbsp;&nbsp;String actualValue = <b>helloService.get()</b>;<br/>
&nbsp;&nbsp;//Assert<br/>
&nbsp;&nbsp;String expectedValue = "Hello from Mockito mocked repository";<br/>
&nbsp;&nbsp;<b>assertEquals(expectedValue, actualValue)</b>;<br/>
<br/>
@Test<br/>
void testNumberOfCallsWithMockito() {<br/>
&nbsp;&nbsp;//Arrange<br/>
&nbsp;&nbsp;<b>when(helloRepository.get()).thenReturn("Hello from Mockito mocked repository");</b><br/>
&nbsp;&nbsp;//Act<br/>
&nbsp;&nbsp;<b>helloService.get();<br/>
&nbsp;&nbsp;helloService.get();</b><br/>
&nbsp;&nbsp;//Assert<br/>
&nbsp;&nbsp;<b>Mockito.verify(helloRepository, Mockito.times(2)).get();</b><br/>
<br/>