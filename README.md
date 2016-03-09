#Zipangu

You can handle prefectures information more easily in Android.

---

## Usage
Add dependencies

```gradle
compile 'com.github.sakebook:Zipangu:0.1.0@aar'
```

In Application or first Activity 

 * java
 
```java
Zipangu.beginning(this);
```

 * kotlin
 
```kotlin
Zipangu.beginning(this);
```

Support narrowing

 * code(1 ~ 47)
 * name(ex `北海道`, `東京都`)
 * area(ex `東北`)
 * segment(`北日本`, `東日本`, `西日本`, `沖縄・那覇`)
    * Based on the Japan Meteorological Agency([JMA](http://www.jma.go.jp/jma/kishou/know/yougo_hp/tiikimei.html))

The return value of the exception

 * Zipangu is will not return value of null. 
Instead, it returns a dummy prefecture.


## Option

### Use custom dummy prefecture  

 * java
 
```java
Zipangu.beginning(this, new Prefecture(0, "カスタム県", "カスタムエリア", Segment.None));
```

 * kotlin
 
```kotlin
Zipangu.beginning(this, Prefecture(0, "県外", "県外", Segment.None))
```


## LICENSE
```
Copyright (C) 2016 Shinya Sakemoto

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```