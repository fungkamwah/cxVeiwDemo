本节介绍Android的常用控件，以及控件配合res文件的使用。

## 1 在layout文件中编辑view
## 1.1 新建工程
本次新建项目，选择【Empty Activity】，让AndroidStudio帮我们创建一个空的Activity，并会自动在AndroidManifest.xml配置好默认的Activity。

![image](http://youdao.mikezz.cn/QQ20190312-103114.png-wardo)

生成的是一个可以直接运行Android项目。
![image](http://youdao.mikezz.cn/QQ20190312-104251.png-wardo)


其中生成的layout_main使用的是ConstraintLayout 
```
<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hello World!"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

</android.support.constraint.ConstraintLayout>
```
为了更好了解控件，这里我们把它编辑为线性布局LinearLayout，并设置内容水平居中gravity="center_horizontal"。同时为了当内容超出屏幕后能够滚动屏幕，在外面套上ScrollView控件，修改后 layout_main如下：

```
<?xml version="1.0" encoding="utf-8"?>
<ScrollView xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content">
    
    <LinearLayout
        android:orientation="vertical"
        android:gravity="center_horizontal"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">
    </LinearLayout>
    //以上4行属性设置分别表示，1纵向布局，2内容水平居中，3宽度与父View一致，4高度根据内容而定

</ScrollView>
```

## 1.2 TextView
TextView即文本控件，在LinearLayout布局内添加一个子元素TextView。
```
<?xml version="1.0" encoding="utf-8"?>
<ScrollView xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <LinearLayout
        android:orientation="vertical"
        android:gravity="center_horizontal"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">

       <!--1宽随内容，2高随内容，3内容为『文本1』，4颜色值#ff0000红,字大小16sp,
        外距5dp-->
        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="文本1"
            android:textColor="#ff0000"
            android:textSize="16sp"
            android:layout_margin="5dp"/>

    </LinearLayout>

</ScrollView>
```

运行看效果。

![image](http://youdao.mikezz.cn/QQ20190318-154247.png-wardo)

下面试一下配合string.xml，colors.xml和dimens.xml使用。

res/values/strings.xml是文本配置资源文件，编辑添加内容:
```
<resources>
    <!--项目名称-->
    <string name="app_name">cxVeiwDemo</string>

    <!--添加的文本-->
    <string name="tv2">文本2</string>
    <string name="input_tips">请输入内容</string>
    <string name="btn1">按钮A</string>
    <string name="btn2">按钮B</string>
</resources>
```

res/values/colors.xml是颜色的资源配置文件。添加自己的颜色配置：
```
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <!--生成的主题的颜色配置-->
    <color name="colorPrimary">#008577</color>
    <color name="colorPrimaryDark">#00574B</color>
    <color name="colorAccent">#D81B60</color>
    
    <!--自己添加的颜色-->
    <color name="cx_green">#00aa00</color>
    
</resources>
```

res/values/dimens.xml是尺寸的配置文件，没有的话手动创建一个。
```
<?xml version="1.0" encoding="utf-8"?>
<resources>

    <!--字体尺寸-->
    <dimen name="t_size">20sp</dimen>

    <!--距离大小尺寸-->
    <dimen name="text_margin">10dp</dimen>

</resources>
```
添加一个TextView并引用上边的配置。如下：
```
<?xml version="1.0" encoding="utf-8"?>
<ScrollView xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <LinearLayout
        android:orientation="vertical"
        android:gravity="center_horizontal"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">

        <!--1宽随内容，2高随内容，3内容为『文本1』，4颜色值#ff0000红,字大小16sp,
        外距5dp-->
        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="文本1"
            android:textColor="#ff0000"
            android:textSize="16sp"
            android:layout_margin="5dp"/>

        <!--与文本1不同，文本2的属性值没直接写在这，而是引用了res文件的配置-->
        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/tv2"
            android:textSize="@dimen/t_size"
            android:textColor="@color/cx_green"
            android:layout_margin="@dimen/text_margin"/>


    </LinearLayout>

</ScrollView>
```
运行看效果：
![image](http://youdao.mikezz.cn/QQ20190318-161552.png-wardo)



## 1.3 EditText文本输入框

编辑layout_main，添加一个EditText。
```
<?xml version="1.0" encoding="utf-8"?>
<ScrollView xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <LinearLayout
        android:orientation="vertical"
        android:gravity="center_horizontal"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">

        <!--1宽随内容，2高随内容，3内容为『文本1』，4颜色值#ff0000红,字大小16sp,
        外距5dp-->
        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="文本1"
            android:textColor="#ff0000"
            android:textSize="16sp"
            android:layout_margin="5dp"/>

        <!--与文本1不同，文本2的属性值没直接写在这，而是引用了res文件的配置-->
        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/tv2"
            android:textSize="@dimen/t_size"
            android:textColor="@color/cx_green"
            android:layout_margin="@dimen/text_margin"/>
        
        <!--指定一个id，hint引用之前在strings.xml中添加的一个文本-->
       <EditText
            android:id="@+id/editText_1"
            android:layout_margin="20dp"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="@string/input_tips"/>


    </LinearLayout>

</ScrollView>
```

![image](http://youdao.mikezz.cn/QQ20190318-163018.png-wardo)

运行起来，看到一个带输入提示的EditText文本输入控件，控件获得焦点时弹出键盘。


下面修改通过修改这个EditText的background来改变它的样式。
在res/drawable目录下新建shape文件ed_bg.xml。
![image](http://youdao.mikezz.cn/QQ20190318-164002.png-wardo)
![image](http://youdao.mikezz.cn/QQ20190318-164136.png-wardo)

编辑ed_bg.xml内容如下：
```
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android">


    <!--宽高-->
    <size android:width="200dp"
        android:height="40dp"/>
    <!--颜色-->
    <solid android:color="#eeeeee"/>

    <!--边框-->
    <stroke android:width="1dp"
        android:color="@color/cx_blue"/>

    <!--圆角-->
    <corners android:radius="5dp"/>

</shape>
```

然后把刚才的EditText修改如下：
```
 <!--指定一个id，hint引用之前在strings.xml中添加的一个文本，背景引用res中的drawable资源-->
        <EditText
            android:id="@+id/editText_1"
            android:layout_margin="20dp"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:hint="@string/input_tips"
            android:background="@drawable/ed_bg"/>
```

运行看效果。

![image](http://youdao.mikezz.cn/QQ20190318-165013.png-wardo)


## 1.4 Button

在LinearLayout中添加2个Button元素。
```
 <Button
            android:id="@+id/btn_1"
            android:layout_margin="20dp"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="@string/btn1"/>
        <Button
            android:id="@+id/btn_2"
            android:layout_margin="20dp"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/btn2"
            android:textColor="#ffffff"
            android:background="@drawable/btn_bg"/>
```


其中btn_bg.xml
```
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android">
    
    <size android:width="280dp"
        android:height="50dp"/>
    <solid android:color="#ff8800"/>
    <corners android:radius="20dp"/>

</shape>
```

看效果：

![image](http://youdao.mikezz.cn/QQ20190318-170854.png-wardo)

##  1.5 ProgressBar

```
        <!--没有百分比的进度条，样式由style决定-->
        <ProgressBar
            android:layout_margin="30dp"
            android:id="@+id/progressBar"
            style="?android:attr/progressBarStyle"
            android:layout_width="match_parent"
            android:layout_height="wrap_content" />

        <!--带百分比的进度条-->
        <ProgressBar
            android:layout_margin="30dp"
            android:id="@+id/progressBar2"
            style="?android:attr/progressBarStyleHorizontal"
            android:layout_width="match_parent"
            android:progress="30"
            android:max="100"
            android:layout_height="30dp" />
```

运行效果：

![image](http://youdao.mikezz.cn/QQ20190318-172919.png-wardo)

## 1.6 ImageView图片

添加一个ImageView
```
        <!---scaleType是图片适应控件的方式，
        src是图片内容，引用了res中的mipmap资源,
        padding内边距为5dp-->
        <ImageView
            android:id="@+id/image"
            android:scaleType="fitXY"
            android:layout_width="300dp"
            android:layout_height="400dp"
            android:padding="5dp"
            android:background="@color/cx_blue"
            android:src="@mipmap/ic_launcher"/>
```

运行一下。

![image](http://youdao.mikezz.cn/QQ20190318-173529.png-wardo)

可以看到图片已经超出了屏幕，这时我们开始时候用的ScrollView就有作用了，可以往下滚动屏幕，看到整个图片。

## 2 在代码中操作View。
以上内容都是在layout_main布局文件中编辑控件。现在开始在代码中使用控件这些控件。

## 2.1 findViewById
首先给所有View都加上id，包括Linearlayout，以便在代码中通过id获取到这些控件。
```
<?xml version="1.0" encoding="utf-8"?>
<ScrollView xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <LinearLayout
        android:id="@+id/layout"
        android:orientation="vertical"
        android:gravity="center_horizontal"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">

        <!--1宽随内容，2高随内容，3内容为『文本1』，4颜色值#ff0000红,字大小16sp,
        外距5dp-->
        <TextView
            android:id="@+id/tv1"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="文本1"
            android:textColor="#ff0000"
            android:textSize="16sp"
            android:layout_margin="5dp"/>

        <!--与文本1不同，文本2的属性值没直接写在这，而是引用了res文件的配置-->
        <TextView
            android:id="@+id/tv2"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/tv2"
            android:textSize="@dimen/t_size"
            android:textColor="@color/cx_green"
            android:layout_margin="@dimen/text_margin"/>

        <!--指定一个id，hint引用之前在sings.xml中添加的一个文本，背景引用res中的drawable资源-->
        <EditText
            android:id="@+id/editText_1"
            android:layout_margin="20dp"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:hint="@string/input_tips"
            android:background="@drawable/ed_bg"/>


        <Button
            android:id="@+id/btn_1"
            android:layout_margin="20dp"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="@string/btn1"/>
        <Button
            android:id="@+id/btn_2"
            android:layout_margin="20dp"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/btn2"
            android:textColor="#ffffff"
            android:background="@drawable/btn_bg"/>

        <!--没有百分比的进度条，样式由style决定-->
        <ProgressBar
            
            android:layout_margin="30dp"
            android:id="@+id/progressBar"
            style="?android:attr/progressBarStyle"
            android:layout_width="match_parent"
            android:layout_height="wrap_content" />

        <!--带百分比的进度条-->
        <ProgressBar
            android:layout_margin="30dp"
            android:id="@+id/progressBar2"
            style="?android:attr/progressBarStyleHorizontal"
            android:layout_width="match_parent"
            android:progress="30"
            android:max="100"
            android:layout_height="30dp" />


        <!---scaleType是图片适应控件的方式，
        src是图片内容，引用了res中的mipmap资源,
        padding内边距为5dp-->
        <ImageView
            android:id="@+id/image"
            android:scaleType="fitXY"
            android:layout_width="300dp"
            android:layout_height="400dp"
            android:padding="5dp"
            android:background="@color/cx_blue"
            android:src="@mipmap/ic_launcher"/>


    </LinearLayout>

</ScrollView>
```
编辑MainActivity，在代码中操作view的基本用法，看代码和注释。
```
package net.gzchunxiang.cxveiwdemo;

import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /*声明view*/
    LinearLayout linearLayout;
    TextView textView1;
    TextView textView2;
    EditText editText;
    Button button1;
    Button button2;
    ProgressBar progressBar1;
    ProgressBar progressBar2;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //在setContentView之后，通过findViewById方法绑定view到变量
        linearLayout = findViewById(R.id.layout);
        textView1 = findViewById(R.id.tv1);
        textView2 = findViewById(R.id.tv2);
        editText = findViewById(R.id.editText_1);
        button1 = findViewById(R.id.btn_1);
        button2 = findViewById(R.id.btn_2);
        progressBar1 = findViewById(R.id.progressBar);
        progressBar2 = findViewById(R.id.progressBar2);
        imageView = findViewById(R.id.image);

        //给view 设置Listener
        //长按事件
        textView1.setOnLongClickListener(longClickListener);
        textView2.setOnLongClickListener(longClickListener);
        //点击事件
        button1.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);

        //用Log打印的示例
        //获取layout中子view个数
        Log.i("onCreate", "linearLayout的子view个数为："
                + linearLayout.getChildCount());
    }


    /*实现一个点击监听*/
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //通过id来判断点击的是哪一个view
            switch (v.getId()) {
                case R.id.btn_1:
                    clickButton1();
                    break;
                case R.id.btn_2:
                    clickButton2();
                    break;
            }
        }
    };

    /**
     *
     */
    private void clickButton1() {

        //获取EditText内容
        String text = editText.getText().toString();
        textView2.setText(text);

        // 一个Toast示例
        Toast.makeText(MainActivity.this, "点击了按钮1",
                Toast.LENGTH_SHORT).show();

        //隐藏view示例
        progressBar1.setVisibility(View.INVISIBLE);

        //改变progressBar2进度值
        int progress = progressBar2.getProgress();
        progressBar2.setProgress(progress + 10);

    }

    private void clickButton2() {
        // 一个Toast示例
        Toast.makeText(MainActivity.this, "点击了按钮2",
                Toast.LENGTH_LONG).show();

        //显示view示例
        progressBar1.setVisibility(View.VISIBLE);

        //操作image
        imageView.setBackgroundColor(getResources().getColor(R.color.cx_green));
        //先在res/mipmap-xhdpi中添加图片文件pic
        imageView.setImageResource(R.mipmap.pic);
        //动态修改ScaleType
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    }

    /*一个长按监听处理*/
    View.OnLongClickListener longClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            //通过id来判断长按的是哪一个view
            switch (v.getId()) {
                case R.id.tv1:
                    textView1.setText("我被长按了，我要变蓝");
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        //版本23以后新增的方法
                        textView1.setTextColor(getColor(R.color.cx_blue));
                    } else {
                        //为了支持旧版本
                        textView1.setTextColor(Color.parseColor("#0000cc"));
                    }
                    break;
                case R.id.tv2:
                    textView2.setText(R.string.tv2);//还原内容
                    break;
            }


            return false;
        }
    };
}

```

查看logcat如图

![image](http://youdao.mikezz.cn/QQ20190319-155934.png-wardo)

尝试点击和长安各个view，观察界面view的变化。

---

*本系列为快速上手指南，不作过多讲解。要了解Android基础知识，请查阅：http://www.runoob.com/w3cnote/android-tutorial-intro.html*
