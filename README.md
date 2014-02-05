# Ocypode

It is an open source project for Android platform, written in Java. Its goal is to help programmers with common functionalities needed daily in most projects. Basically, it is a result of refactoring on projects that I have worked on. This project is integrated with [RoboGuice](https://github.com/roboguice/roboguice), providing some abstraction for methods like: startActivity; overridePendingTransition and startService; There is also view components to deal with type of fonts, dialog builders, auto resize text view and create image as a circle. You can also find utility classes for currency, date and number format. There is string validation and Logcat.

## Installation

### From Gradle

The Gradle is the tool used to build the Ocypode library. If you are using Gradle too (the new standard build system for Android), you can add Ocypode 
 repository ('https://github.com/jairobjunior/Ocypode/raw/dev/repo') and dependency ('com.ocypode:ocypode-lib:0.1.0') to your build.gradle, as the below example.

```groovy
buildscript {
	repositories {
		mavenCentral()
	}

	dependencies {
		classpath 'com.android.tools.build:gradle:0.6.1+'
	}
}

apply plugin: 'android'

repositories {
	maven { url 'https://github.com/jairobjunior/Ocypode/raw/dev/repo' }
}

dependencies {
	compile 'com.android.support:support-v4:19.0.1'
	compile 'com.ocypode:ocypode-lib:0.1.0'
}

...
```

Be aware of the latest version.

### Manually

## Features

## Usage

On the [Wiki pages](https://github.com/jairobjunior/Ocypode/wiki/_pages) you can get more code examples.

## Credits

Ocypode is brought to you by [Jairo Barros Junior](http://jairobjunior.com) and [contributors to the project](https://github.com/jairobjunior/Ocypode/contributors). If you have feature suggestions or bug reports, feel free to help out by sending pull requests or by [creating new issues](https://github.com/jairobjunior/Ocypode/issues/new). If you're using Ocypode in your project, attribution would be nice.

### Mascot

## License
Copyright © 2013 Jairo Barros Junior

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
