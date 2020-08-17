@[toc]

# 写在前面

**值得注意的是**

框架中测试了百度搜索接口和企业微信的一些功能接口，对于百度搜索不需要身份信息，直接运行框架可以正常测试百度搜索，但是对于企业微信而言其中的操作需要 token 信息（处于安全考虑，博主未将自己的 token 放置其中），所以如要测试通过企业微信的接口，需要大家注册一下免费的企业微信，然后将其中的 corpid 和通讯录 corpsecret 填写进 testng.xml 的参数中，再运行即可测试成功自己的企业微信！

**java**

java 当前最主流的后端开发语言，目前做自动化主要是两大阵营 java 和 python，这里不讨论游戏自动化，相比而言，小厂的 python
稍微主流一些，大厂的 java 稍微主流一些，毕竟大厂几乎全部被 java 
占领，而测试作为保障项目质量的一个关键角色，必须要打穿整个项目流程，因此贴近研发代码就显得尤为重要

**testng**

目前整个测试圈有两大阵营，一个是忠实的 testng 阵营，另一个是新潮流 junit5  阵营，不论哪个阵营未来都会成为测试圈的主流，我个人感觉纯粹的自动化测试或者测开应该是 testng 目前更占有又是，junit5  随着许多开发转为测试开发，会把 junit5 的技术带到测试圈进而丰富测试圈的技术栈

我个人认为 testng 比 junit5 更灵活，更加适合做自动化，但是 junit5 提供了更丰富的参数化运行，总的来说如果项目较为复杂我推荐使用更加灵活多变的 testng， 简单的项目就可以使用 junit5 来做

**REST assured**

REST Assured是一个可以简化HTTP Builder顶层 基于REST服务的测试过程的Java **DSL**（针对某一领域，具有受限表达性的一种计算机程序设计语言）。它支持发起POST,GET,PUT,DELETE,OPTIONS,PATCH和HEAD请求，并且可以用来验证和校对这些请求的响应信息。

使用的话通过配置 mvn 依赖的方式即可使用其中的方法来完成接口测试。目前该项目在 github 上[https://github.com/rest-assured/rest-assured](https://github.com/rest-assured/rest-assured)有将近 5k 的 star

**本文的项目地址**

项目 github 地址如下，欢迎大家 fork 和 star！！！

[https://github.com/abcnull/apitest4j](https://github.com/abcnull/apitest4j)

另外博主还搭建有 webui 和 appui 的测试项目，欢迎参观博客(#^.^#)

# 项目结构介绍

我先贴一张我自己的项目结构图：

![项目结构](https://github.com/abcnull/Image-Resources/blob/master/apitest4j/项目结构.png)


整体框架代码都是在 test 测试包下，采用了 pageobject 的思想，其实这一思想本来是马丁福勒提出来用在 UI 测试上的，但实际上 api 测试同样也是可以使用 pageobject 类似的思想的，只不过你可以不适用页面来划分，而是使用模块来划分接口。依据 pageobject 思想，大致分为了两大阵营的包，一个是 module 阵营，另一个是 case 阵营

- module 阵营

  - basepage 包

    其中含有 BaseModule 类，是基础的模块类，所以 module 的父类

  - pageobject 包

    - data 包

      其中含有对应模块的接口数据（这个接口数据是一个 map 形式，键名为 api 键值为接口，键名为 body，键值为接口的请求数据），为了便于管理所以把对应 module 中的接口的具体数据存放在此

    - module 包

      与 data 包中的类是对应的，可以直接调用 data 包中的数据。这里使用 REST assured 的方法进行接口请求，类似于 UI 测试中的 Page 对象

- case 阵营

  - basecase 包

    其中进行了接口测试的一些初始化工作，是所有 testcase 的父类

  - testcase 包

    其中存放的是接口测试类，测试类写的调用 module 中接口请求操作的逻辑代码，所以说 testcase 中只用管接口测试业务流程即可

# 基本 usage

整体框架可以分给组内多个组员完成自动化接口测试，当大家把这个框架做好自己的定制化修改之后，编写测试脚本的成员只需要关注以下几个包

- pageobject.data
- pageobject.module
- testcase

其他包无需关注，如果成员要把自己的测试用例组织起来，可以使用"名字_testng.xml"的方式来管理测试用例，当然使用其他的方式组织测试用例也是可行的！

还值得注意的是，该框架中测试了百度的搜索功能和企业微信的创建部门和删除部门的接口功能

- 百度搜索接口测试

  百度搜索是 GET 方法，不需要 token 等身份信息即可搜索，所以这里可以较为简单的完成测试

- 企业微信

  - 部门管理创建的接口测试

    企业微信的接口测试需要 token 信息，所以需要先访问一个接口拿到 token（当然这个我已经有了封装），然后就可以正常测试了，大家只需要在 testng.xml 中找到 parameter 是 corpid 和 corpsecret 的参数并填写自己的企业微信的 corpid 和通讯录 corpsecret 然后运行该 xml 即可完成测试（处于安全考虑本人没有把自己的 token 信息放置于框架中），所以还需要请大家注册免费的企业微信去查看身份标识

  - 部门管理删除的接口测试

    同样也需要 token 信息

testng.xml 中需要自己填写的参数如下：

![testng参数](https://github.com/abcnull/Image-Resources/blob/master/apitest4j/testng参数.png)


# properties

项目通过配置的形式来驱动整个项目，目前配置文件中配置的是整个被测项目的 host name 和获取 token 的接口

# 数据驱动

项目支持数据驱动的方式，我们实际中的 UI 自动化往往通过 jenkins 来持续构建，jenkins 的 job 中支持 param 传参，我们在 mvn 项目的 pom 文件中添加如下：

![数据驱动](https://github.com/abcnull/Image-Resources/blob/master/apitest4j/数据驱动.png)

xmlFileName，param1，param2，param3 这些名字需要与 jenkins 中传参名字一致，然后 mvn 中需要一个 surefile 插件，在这个插件的 suiteXmlFiles 标签中指定运行那个 testng.xml `<suiteXmlFile>testng.xml</suiteXmlFile>`，还可以指定传给 testng.xml 的参数（具体可以拉取项目代码查看）

# 日志系统

日志系统使用的是 slf4j+log4j 的形式来做，同时使用了 lombok 插件，我们将 log4j2.xml 的日志格式配置文件放在了`/src/main/resources`下，我们在代码打日志，先在类上打上`@Slf4j`，然后就可以直接使用`log.info`的形式了。当项目测试运行完，我们可以直接在项目下看到 logs 文件夹，可以在其中查看到我们的日志

# surefire 插件

surefire 是 mvn 的一个非常适用的测试插件，它可以结合 junit5，testng 来使用，我们可以使用它来帮助我们外部传参，可以使用它指定当我们 mvn 构建时候要执行哪个 testng.xml 文件

![surefire](https://github.com/abcnull/Image-Resources/blob/master/apitest4j/surefire.png)

甚至我们可以使用 mvn 命令配合上 surefire 加上一些命令参数来运行指定的测试用例，这些可以通过访问 surefire 官网来查看

# testng 监听器

这里我目前使用了两个监听器（这些监听器都是来源于 testng 的，当我们继承或实现这些监听器，方便我们做拓展），一个是 TestListenerAdapter 类，另一个是 IAnnotationTransformer 接口

- TestListenerAdapter 类

  TestListenerAdapter  类很强大里头有测试执行过程中各个阶段的方法，比如测试开始时的方法，测试失败时，测试结束时等等，因此我们可以把这些方法重写，然后把 log  信息打印进去，这样我们就可以看见完整的 log 流程了

- IAnnotationTransformer 接口

  我通过实现这个接口来进行 testng.xml 测试用例运行优先级的调整，传统的 method 运行的优先级是：再一个 class  中，method 是依据方法名排序，所以基本是乱序的，与 testng.xml 中 method 的组织顺序无关，我加上这个监听器后，可以保证  testng.xml 中 class 里的 method 的书写顺序就是执行顺序，这个可以说是非常实用的，具体的源码我是参照了  stackoverflow

有了这些监听器，我们需要在 testng.xml 去声明一下，表示会使用这些监听器

```java
<!-- 监听器 -->
<listeners>
    <!-- 测试日志监听器 -->
    <listener class-name="com.abcnull.listener.TestLogListener"/>
    <!-- 优先级监听器 -->
    <listener class-name="com.abcnull.listener.RePrioritizingListener"/>
</listeners>
```

# 报告输出

传统的报告输出有两个常用的样式，一个是 extentreport 另一个是 allure 2 样式，相比而言 allure 2 要用的更多一些，本项目也是使用的 allure 2 报告样式

配置方式是结合了 surefire 插件，具体配置可以拉取代码查看细节

当我们项目运行完，会在项目直接路径下产生 allure-results 文件，我们运行`allure serve allure-results`即可解析 allure 2 报告，然后我们打开控制台返回的网址即可

allure 2 不仅仅是项目中安装依赖这么简单，也需要自己电脑中安装好 allure 工具，这样才能在自己电脑中正确解析报告，要不`allure serve allure-results`这个命令怎么来的(#.#)，具体的 allure 使用可以参照博主的另一篇博文https://blog.csdn.net/abcnull/article/details/104095934

# 其他

目前使用的报告形式是 allure2，以后还考虑再多加一个模板形式 extentreport

项目 github 地址如下，欢迎大家 fork 和 star！！！

[https://github.com/abcnull/apitest4j](https://github.com/abcnull/apitest4j)

另外博主还搭建有 webui 和 appui 的测试项目，欢迎参观博客(#^.^#)




