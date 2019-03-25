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
