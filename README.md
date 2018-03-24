
一个App的外框架，可以用于新闻类、音乐播放类、视频类客户端的开发。目前作为一个模板暂存，后续很多都可以在此基础上开发。

- 使用MVP模式（不过实际没有用到具体页面）
- 基本参照MD设计要求，采用design中的组件
- 主页使用侧滑+底部按钮+碎片搭建 
即 DrawerLayout+BottomNavigationView+TabLayout+Fragment
- 首页第一屏使用嵌套碎片（Nested Fragment）的方式
- 图标基本上从google官方提供的icon中选取
- 目前基本效果如下

![图片1](https://github.com/demongel/AndroidAppTemplate/blob/master/image/fragment.jpg){:height="50%" width="50%"}

![图片2](https://github.com/demongel/AndroidAppTemplate/blob/master/image/home.jpg){:height="50%" width="50%"}

![图片3](https://github.com/demongel/AndroidAppTemplate/blob/master/image/slidemenu.jpg){:height="50%" width="50%"}
