# RibbonLayout
This is an android layout library "RibbonLayout" by [Battle Entertainment](https://www.battleent.com/)

![screenshot](https://user-images.githubusercontent.com/24237865/32170256-3d46b1f8-bdb7-11e7-99c9-b658f5ec27c5.png)

## Download
#### Gradle
```java
dependencies {
    compile 'com.github.skydoves:ribbonlayout:1.0.0'
}
```

## Usage
```xml
<com.skydoves.ribbonlayout.RibbonLayout
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
            </com.skydoves.ribbonlayout.RibbonLayout>
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

# License
```xml
Copyright 2017 battleent

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
