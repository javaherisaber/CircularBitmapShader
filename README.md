# CircularBitmapShader
[![](https://jitpack.io/v/javaherisaber/CircularBitmapShader.svg)](https://jitpack.io/#javaherisaber/CircularBitmapShader)

![Hero Image](https://github.com/javaherisaber/CircularBitmapShader/blob/master/images/hero.png)

draw some nice random shadow around your circular bitmap file

## Dependencies

To use this library you need to add following scripts to your project

**Step 1**. Add to top level build.gradle
```groovy
allprojects {
        repositories {
            ...
            maven { url 'https://jitpack.io' }
        }
    }
```

**Step 2**. Add dependency
```groovy
dependencies {
    implementation "com.github.javaherisaber:CircularBitmapShader:${versions.circularBitmapShader}"
}
```

## Usage

1. To be used on a single ImageView

```kotlin
CircularBitmapShader(bitmap)
        .into(imageView)
        .recycleSrcBitmap()
```

2. To be used on multiple ImageView's

```kotlin
CircularBitmapShader(bitmap)
        .into(imageView1)
        .into(imageView2)
        .into(imageView3)
        .recycleSrcBitmap()
```

3. To generate output bitmap and use in different views (eg. GoogleMap marker)

```kotlin
val outputBitmap = CircularBitmapShader(bitmap)
                            .generateBitmap()
```

## Public Methods

| Name | Description |
|:----:|:----:|
|setShadowSize(int)| set size of shadow (default is 36)|
|setShadowColor(int)| set color of shadow (random color would be generated by default)|
|setAutoGenerateColor(boolean)| if set to true, after each call to into() you'll have new color shadow|
|regenerateShadowColor()| use this to regenerate color after into() call|
|into(ImageView)| set output bitmap into your imageview|
|generateBitmap()| get output bitmap to use elsewhere|
|recycleSrcBitmap()| recycle input bitmap to improve performance|

## License
```

The MIT License (MIT)

Copyright (c) 2019 Mahdi Javaheri

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
