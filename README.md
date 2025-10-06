# FilterFrame

**Gradle**
**Step 1.** Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:
```css
dependencyResolutionManagement {
		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
		repositories {
			mavenCentral()
			maven { url 'https://jitpack.io' }
		}
	}
```
**Step 2.** Add the dependency
```css
dependencies {
	        implementation 'com.github.vtabk2:FilterFrame:1.0.6'
	}
```

**config_filter_frame.xml**
```css
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <color name="ff_color_ic_select_frame_category">#ffffff</color>
    <color name="ff_color_ic_select_frame_category_selected">#2aa4ea</color>
    <color name="ff_color_ic_ratio_frame">#ffffff</color>
    <color name="ff_color_ic_ratio_frame_selected">#2aa4ea</color>
    <color name="ff_tag_view_bg_color">#EBEBEB</color>
    <color name="ff_tag_view_bg_color_check">#2aa4ea</color>
    <color name="ff_tag_view_text_color">#2aa4ea</color>
    <color name="ff_tag_view_text_color_check">#ffffff</color>
    <color name="ff_color_ratio_frame_icon">#000000</color>
    <color name="ff_color_ratio_frame_icon_selected">#ffffff</color>
    <color name="ff_color_ratio_frame_background">#EBEBEB</color>
    <color name="ff_color_ratio_frame_background_selected">#2aa4ea</color>
    <color name="ff_color_background_item_number">#EBEBEB</color>
    <color name="ff_color_background_item_number_selected">#2aa4ea</color>
    <color name="ff_color_background_ratio_frame">#EBEBEB</color>
    <color name="ff_color_background_ratio_frame_selected">#2aa4ea</color>
    <color name="ff_color_msg_frame_filter_no_data">#ffffff</color>

    <drawable name="ff_ic_close_frame">@drawable/ff__ic_close_frame</drawable>
    <drawable name="ff_image_no_frame_filter">@drawable/ff__image_no_frame_filter</drawable>
    <drawable name="ff_ic_select_frame_category">@drawable/ff__ic_select_frame_category</drawable>
    <drawable name="ff_ic_select_frame_category_selected">@drawable/ff__ic_select_frame_category_selected</drawable>
    <drawable name="ff_ratio_frame">@drawable/ff_ic_ratio_frame</drawable>
    <drawable name="ff_ratio_frame_selected">@drawable/ff_ic_ratio_frame_selected</drawable>
</resources>
```

# Lịch sử cập nhật

Version 1.0.6

- Thêm tính năng hideNavigationBar
- Cập nhật lib lên target 35, min 24 