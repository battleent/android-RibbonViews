# RibbonViews
![license](https://img.shields.io/badge/license-MIT%20License-blue.svg)
[![Build Status](https://travis-ci.org/battleent/android-RibbonViews.svg?branch=master)](https://travis-ci.org/battleent/android-RibbonViews) 
[ ![Download](https://api.bintray.com/packages/battleent/maven/RibbonViews/images/download.svg) ](https://bintray.com/battleent/maven/RibbonViews/_latestVersion)
<br>

![screenshot1645545604](https://user-images.githubusercontent.com/27774870/51260708-3dbbab00-19f2-11e9-9948-84644f88281a.png) <br>

<p align="center">
    :purple_heart: Thank you for download 3500+ :purple_heart:
</p>

## Tutorial
[Youtube Android Studio Tutorial - Ribbon Layout](https://www.youtube.com/watch?v=8HQ_PDUDJ4k)

## Demo
This is an android view library "RibbonViews" by [Battle Entertainment](https://www.battleent.com/)

![screenshot](https://user-images.githubusercontent.com/24237865/33116641-ea4b1526-cfa8-11e7-8552-5401c6db2607.png) <br>

## BattleComics Preview
![scrennshot00](https://user-images.githubusercontent.com/24237865/33155980-a27600b8-d038-11e7-9043-adfd608d9b97.png)
![screenshot01](https://user-images.githubusercontent.com/24237865/33155979-a24b102e-d038-11e7-8eac-bea1296687f2.png)

## Download
#### Gradle
```java
dependencies {
    implementation "com.github.battleent:RibbonViews:1.1.6"
}
```

## Usage
### RibbonLayout
```xml
<com.battleent.ribbonviews.RibbonLayout
                android:layout_width="132dp"
                android:layout_height="90dp"
                app:show_header="true" // default is true
                app:header_text="New"
                app:header_textSize="10"
                app:header_textColor="@android:color/white"
                app:header_ribbonRadius="6"
                app:header_ribbonColor="@color/colorPrimary"
                app:header_padding="5"
                app:show_bottom="true" // default is true
                app:bottom_text="Updated today"
                app:bottom_textSize="10"
                app:bottom_textColor="@android:color/white"
                app:bottom_ribbonColor="@color/pale_magenta_90"
                app:bottom_height="50"
                app:bottom_padding="11">

                <ImageView
                    android:layout_width="132dp"
                    android:layout_height="wrap_content"
                    android:scaleType="fitXY"
                    android:src="@drawable/thumbnail0"/>
            </com.battleent.ribbonviews.RibbonLayout>
```

#### Attributes
Parameter  |  Format  |  Default  |  Description
--- | --- | --- | ---
show_header | Boolean | true | set header ribbon's visibility
header_text | String | null | set header ribbon's text
header_textSize | int | 9 | set header ribbin's textSize
header_textColor | color | Color.White | set header ribbin's textColor
header_ribbonRadius | int | 10 | set header ribbon's corner radius
header_ribbonColor | color | Color.White | set header ribbin's colour
header_padding | int | 4 | set header ribbon's paddings
show_bottom | Boolean | true | set bottom ribbon's visibility
bottom_text | String | null | set bottom ribbon's text
bottom_textSize | int | 10 | set bottom ribbin's textSize
bottom_textColor | color | Color.White | set bottom ribbin's textColor
bottom_height | int | -1 | set bottom ribbin's height
bottom_padding | int | 3 | set bottom ribbon's paddings

### RibbonTag
```xml
<com.battleent.ribbonviews.RibbonTag
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="sale event"
                    android:layout_marginTop="3dp"
                    app:tag_ribbonRadius="5"
                    app:tag_padding_right="6dp"
                    app:tag_padding_left="6dp"
                    app:tag_ribbonColor="#cdda0b23"/>
```

### RibbonTagListView
```xml
<com.battleent.ribbonviews.RibbonTagListView
                    android:id="@+id/ribbonTagListView"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_marginTop="3dp"
                    app:item_space="10"/>
```

### RibbonCoverLayout
```xml
<com.battleent.ribbonviews.RibbonCoverLayout
                android:layout_width="180dp"
                android:layout_height="119dp"
                app:cover_color="@color/cover"
                app:cover_text="expired"
                app:cover_textSize="23"
                app:cover_textColor="@android:color/white">
    
                <!-- or set custom layout on cover -->
                <!-- app:cover="@layout/layout_cover"  -->

                <ImageView
                    android:layout_width="200dp"
                    android:layout_height="wrap_content"
                    android:scaleType="fitXY"
                    android:src="@drawable/thumbnail0"/>
            </com.battleent.ribbonviews.RibbonCoverLayout>
```

### RibbonFickleCoverLayout
```xml
<com.battleent.ribbonviews.RibbonFickleCoverLayout
                android:id="@+id/ribbonCoverLayout"
                android:layout_width="180dp"
                android:layout_height="119dp"
                app:fickle_cover="@layout/layout_cover"
                app:fickle_cover_second="@layout/layout_cover_second"
                app:fickle_delay="1000">

                <ImageView
                    android:layout_width="200dp"
                    android:layout_height="wrap_content"
                    android:scaleType="fitXY"
                    android:src="@drawable/thumbnail0"/>

            </com.battleent.ribbonviews.RibbonFickleCoverLayout>
```

### RibbonGradationProgressbar
```java
RibbonGradationProgressbar progress = findViewById(R.id.progress);
progress.setProgress(65);
progress.setLabel("progress 50%");
```

### RibbonEditText
```xml
   <com.battleent.ribbonviews.RibbonFickleCoverLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:editText_paddingTop="10"
        app:editText_ribbonLeftPadding="10"
        app:editText_ribbonText="password"
        app:editText_ribbonColor="@color/black_87"
        app:editText_ribbonFocusColor="@color/colorPrimary"
        app:editText_ribbonSize="15"
        app:editText_editColor="@color/black_87"
        app:editText_editHintColor="@color/black_54"
        app:editText_editSize="15"
        app:editText_editHint="type password"/>
```

## Version Log
- v1.1.4 - Updated RibbonEditText
- v1.0.9 - Updated RibbonGradationProgressbar
- v1.0.8 - Updated RibbonFickleCoverLayout
- v1.0.7 - Updated RibbonCoverLayout
- v1.0.2 - Updated RibbonTagListView
- v1.0.1 - Updated RibbonTag

# License
```xml
MIT License

Copyright (c) 2017 Battle Entertainment

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
```
