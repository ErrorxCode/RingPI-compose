
# RingPI (Jetpack library)
<p align="left">
  <a href="#"><img alt="Languages-Kotlin" src="https://img.shields.io/badge/Language-Kotlin-1DA1F2?style=flat-square&logo=kotlin"></a>
  <a href="#"><img alt="Version" src="https://jitpack.io/v/ErrorxCode/ExpandableCard.svg"></a>
  <a href="https://www.instagram.com/x0.rahil/"><img alt="Instagram - x0.rahil" src="https://img.shields.io/badge/Instagram-x0.rahil-lightgrey"></a>
  <a href="#"><img alt="Downloads" src="https://jitpack.io/v/ErrorxCode/EasyInsta/month.svg"></a>
  <a href="#"><img alt="GitHub Repo stars" src="https://img.shields.io/github/stars/ErrorxCode/ExpandableCard?style=social"></a>
  </p>

> "A beautiful way of displaying progress or quota"

This library provides 2 amazing progress indicator which you can use in your application with just 1 line of code.


Full ring indicator             |  Half ring indicator
:-------------------------:|:-------------------------:
![image](https://github.com/user-attachments/assets/0d51e9cc-b400-4e0f-8d3b-03b07d5bfdec) |  ![image](https://github.com/user-attachments/assets/e9f83422-d4d8-4c1d-a470-765a0aaca1da)





## Implementation

To deploy this project run

**Step 1**. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:
```groovy
	dependencyResolutionManagement {
		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
		repositories {
			mavenCentral()
			maven { url 'https://jitpack.io' }
		}
	}
```
**Step 2**. Add the dependency

	dependencies {
	        implementation 'com.github.ErrorxCode:RingPI-compose:Tag'
	}
 
[![](https://jitpack.io/v/ErrorxCode/RingPI-compose.svg)](https://jitpack.io/#ErrorxCode/RingPI-compose)


## Usage/Examples

```kotlin
RingProgressIndicator(
    radius = 200,
    colors = listOf(Color.Red,Color.Blue,Color.Green),  // If you only want one color then pass the same color in the list.
    txtColor = Color.Black,				//options, if not stated will use gradient color
    progress = 85,
    isHalfRing = true  					// false for the full circular ring
)
```



## Contributing

Contributions are always welcome!

What you can do is add more customization options to it. You can contact me anytime on [instagram](https://instagram.com/x0.rahil) for any help.


