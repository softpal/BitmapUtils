# BitmapUtils


### Developed by
[Softpal](https://www.github.com/softpal)

[![](https://jitpack.io/v/softpal/DateTimeUtils.svg)](https://jitpack.io/#softpal/DateTimeUtils)


**Features**

Get Size of the image file. <br>
Decode image and scale it to reduce memory consumption.


## Installation

Add repository url and dependency in application module gradle file:
  
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
	
    
    
### Gradle
[![](https://jitpack.io/v/softpal/DateTimeUtils.svg)](https://jitpack.io/#softpal/DateTimeUtils)
```javascript
dependencies {
    implementation 'com.github.softpal:BitmapUtils:1.0'
}
```


## Usage

### 1. Get Size of Image

```javascript
       float imageSize = BitmapUtils.getImgFileSize(uri);
```
