![RealParallaxAndroid](https://github.com/mallethugo/RealParallaxAndroid/blob/master/realparallaxandroid.png)

===

RealParallaxAndroid is a View Pager with a Real Parallax Android Effect
Support Android 4.0+

[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-RealParallaxAndroid-green.svg?style=true)](https://android-arsenal.com/details/1/2918)

![RealParallaxAndroid](https://github.com/mallethugo/RealParallaxAndroid/blob/master/Demo.gif)

# Usage

```xml
<com.github.hmallet.realparallaxandroid.RealHorizontalScrollView
android:id="@+id/main_horizontal_scrollview"
android:layout_width="match_parent"
android:layout_height="match_parent"
app:src="@mipmap/background"/>

<com.github.hmallet.realparallaxandroid.RealViewPager
android:id="@+id/main_view_pager"
android:layout_width="match_parent"
android:layout_height="match_parent"
app:parallaxVelocity="0.2"/>
```

## Custom Attributes for RealHorizontalScrollView

- `app:src`

## Custom Attributes for RealViewPager

- `parallaxVelocity` float to manage parallax effect


## Gradle

At your project `build.gradle` file:

```groovy
dependencies {
    compile 'com.github.hmallet:realparallaxandroid:1.0.1'
}
```

Done!

#Author
Hugo Mallet:
- hello@mallethugo.com
- [@mallethugo](https://twitter.com/mallethugo)
- [Linkedin](https://www.linkedin.com/in/hugomallet)

# License

The MIT License (MIT)

Copyright (c) 2015 Hugo Mallet

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
