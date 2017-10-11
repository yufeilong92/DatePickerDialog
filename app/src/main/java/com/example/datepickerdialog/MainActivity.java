package com.example.datepickerdialog;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends Activity implements Button.OnClickListener {
    /*
     * 定义 程序用到的UI元素对象:日历设置器对话框、时间设置器对话框、 显示时间的TextView、按钮
     */
    DatePickerDialog my_datePickerDialog;
    TimePickerDialog my_timePickerDialog;
    TextView showDate_Time;
    Button showDatePDialog;
    Button showTimePDialog;
    /* 定义时间变量：年、月、日、小时、分钟 */
    private int my_Year, my_Month, my_Day, my_Hour, my_Minute;
    /* 定义日历对象，初始化时，用来获取当前时间 */
    Calendar my_Calendar;

    private OnDateSetListener myDateSetListener = new OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
			/* 日期改变事件处理 */
            my_Year = year;
            my_Month = monthOfYear;
            my_Day = dayOfMonth;

			/* 动态显示修改后的日期 */
            loadDate_Time();
        }

    };

    private OnTimeSetListener myTimeSetListener = new OnTimeSetListener() {

        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            // TODO Auto-generated method stub
			/* 时间改变事件处理 */
            my_Hour = hourOfDay;
            my_Minute = minute;
			/* 动态显示修改后的时间 */
            loadDate_Time();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitTime();
        findViewById();
        setListener();
        loadDate_Time();
    }

    private void setListener() {
        // TODO Auto-generated method stub
        showDatePDialog.setOnClickListener(this);
        showTimePDialog.setOnClickListener(this);
    }

    private void findViewById() {
        // TODO Auto-generated method stub
        showDate_Time = (TextView) findViewById(R.id.my_TextView);
        showDatePDialog = (Button) findViewById(R.id.show_DatePicker);
        showTimePDialog = (Button) findViewById(R.id.show_TimePicker);
    }

    private void InitTime() {
        // TODO Auto-generated method stub
		/* 从Calendar抽象基类获得实例对象，并设置成中国时区 */
        my_Calendar = Calendar.getInstance(Locale.CHINA);
		/* 从日历对象中获取当前的：年、月、日、时、分 */
        my_Year = my_Calendar.get(Calendar.YEAR);
        my_Month = my_Calendar.get(Calendar.MONTH);
        my_Day = my_Calendar.get(Calendar.DAY_OF_MONTH);
        my_Hour = my_Calendar.get(Calendar.HOUR_OF_DAY);
        my_Minute = my_Calendar.get(Calendar.MINUTE);
    }

    private void loadDate_Time() {
        // TODO Auto-generated method stub
        showDate_Time.setText(new StringBuffer().append(my_Year).append("/")
                .append(FormatString(my_Month + 1)).append("/")
                .append(FormatString(my_Day)).append(" ")
                .append(FormatString(my_Hour)).append(" : ")
                .append(FormatString(my_Minute)));
    }

    /* 日期时间显示两位数的方法 */
    private String FormatString(int x) {
        String s = Integer.toString(x);
        if (s.length() == 1) {
            s = "0" + s;
        }
        return s;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.show_DatePicker:
			/* 显示日期设置对话框的按钮点击事件处理 */
			/*
			 * 构造一个DatePickerDialog对象，第一个参数为Context、 第二参数为日期修改事件处理监听器、后面为初始化的年月日
			 */
                my_datePickerDialog = new DatePickerDialog(this, myDateSetListener,
                        my_Year, my_Month, my_Day);
			/* 显示出日期设置对话框 */
                my_datePickerDialog.show();
                break;
            case R.id.show_TimePicker:
			/* 显示时间设置对话框的按钮点击事件处理 */
			/*
			 * 构造一个TimePickerDialog对象，第一个参数为Context、第二个参数为时间修改
			 * 事件监听器、后面两个为初始化时间，最后一个boolean类型设置是否为24小时制
			 */
                my_timePickerDialog = new TimePickerDialog(this, myTimeSetListener,
                        my_Hour, my_Minute, false);
			/* 显示出日期设置对话框 */
                my_timePickerDialog.show();
                break;
        }
    }

}
