# FirstDemo
1.@Before：初始化方法   对于每一个测试方法都要执行一次（注意与BeforeClass区别，后者是对于所有方法执行一次）
@After：释放资源  对于每一个测试方法都要执行一次（注意与AfterClass区别，后者是对于所有方法执行一次）
@Test：测试方法，在这里可以测试期望异常和超时时间 
@Test(expected=ArithmeticException.class)检查被测方法是否抛出ArithmeticException异常 
@Ignore：忽略的测试方法 
@BeforeClass：针对所有测试，只执行一次，且必须为static void 
@AfterClass：针对所有测试，只执行一次，且必须为static void 
一个JUnit4的单元测试用例执行顺序为： 
@BeforeClass -> @Before -> @Test -> @After -> @AfterClass; 
每一个测试方法的调用顺序为： 
@Before -> @Test -> @After;  
2.用hashmap实现redis有什么问题？
1.hashmap是有最大容量的
2.redis可以持久化，也可以定时时间，hashmap不可以持久化
3.hashmap不是线程安全的（并且：多线程同时调用hashMap的resize方法后，后续调用get方法时，可能进入死循环）
4.edis 有集群，自动保存，自动恢复，还有消息队列，还有跨语言调用。
5.解决：ConcurrentHashmap：底层采用分段的数组+链表实现，线程安全
通过把整个Map分为N个Segment，可以提供相同的线程安全，但是效率提升N倍，默认提升16倍。(读操作不加锁，由于HashEntry的value变量是 volatile的，也能保证读取到最新的值。)
3.
