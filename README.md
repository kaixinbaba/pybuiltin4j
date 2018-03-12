# pybuiltin4j
Using java to implement Python built-in functions
```xml
<!-- import from maven -->
<dependency>
    <groupId>com.github.MyEclipse1214</groupId>
    <artifactId>pybuiltin4j</artifactId>
    <version>1.0.0</version>
</dependency>
```
Let's start!
```java
// First, the static import of PyBuiltin
import static com.github.PyBuiltin.*;
```
```java
// before
System.out.println("Hello world!");
// now
print("Hello world!");


List someList;
// before
if (someList != null && someList.size() > 0) {
    // do something..
}
// now
if (bool(someList)) {
    // do something..
}
// also apply to String and other Collections

// We have a list or set, like [1, 3, 4, 5, 7]
// Now we want get the sum
// before
int sumResult = 0;
for (Integer i : aList) {
    sumResult += i;
}
// now
int sumResult = sum(aList);

// also we can sorted reversed like
List afterSorted = sorted(aList);
List afterReversed = reversed(aList);

// Functional
// map
List<String> old = new ArrayList<>();
old.add("a");
old.add("b");
old.add("c");
// We want to turn them into capitals
// before
List<String> newList = old.stream().map(String::toUpperCase)).collect(Collectors.toList());
// now
List<String> newList = map(String::toUpperCase, old);

// filter
List<Integer> old = new ArrayList<>();
old.add(1);
old.add(2);
old.add(4);
old.add(7);
// We want to filter out all the even numbers
// before
List<Integer> newList = old.stream().filter(x -> x % 2 == 0)).collect(Collectors.toList());
// now
List<Integer> newList = filter(x -> x % 2 == 0, old);
```
###Existing function 还是用中文吧
- abs 求绝对值
- print 输出控制台 TODO 写入文件
- id 同 hash， 在python里这两者并不相同
- len 求长度（数组，集合，字符串）
- str 转字符串（任意对象）
- int 转成整型
- bool 转成布尔值（任意对象）
- hash hashcode
- max 求序列最大
- min 求序列最小
- set 转成集合（数组，集合，字符串）
- list 转成列表（数组，集合，字符串）
- sum 序列求和
- type 获取类型
- any 集合元素有一个为true，即为true，否则false
- all 集合元素全部为true才为true
- filter 函数式编程过滤
- map 函数式编程映射
- pow 求平方
- long_ 转成长整型
- double_ 转成双精度浮点
- float_ 转成单精度浮点
- hasattr 判断对象是否有属性
- sorted 序列排序
- reversed 序列反序
- frozenset 创建一个不可修改的Set

###TODO
考虑到java实现最大的缺点应该就是性能问题了，所以2.0看能否调用python库，3.0看能否扩展C语言库
但是谁知道有没有2.0,3.0呢 哈哈
