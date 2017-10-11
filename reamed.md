#时间提示框选择
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
                
 ###使用初始化

            // TODO Auto-generated method stub
            /* 从Calendar抽象基类获得实例对象，并设置成中国时区 */
            my_Calendar = Calendar.getInstance(Locale.CHINA);
            /* 从日历对象中获取当前的：年、月、日、时、分 */
            my_Year = my_Calendar.get(Calendar.YEAR);
            my_Month = my_Calendar.get(Calendar.MONTH);
            my_Day = my_Calendar.get(Calendar.DAY_OF_MONTH);
            my_Hour = my_Calendar.get(Calendar.HOUR_OF_DAY);
            my_Minute = my_Calendar.get(Calendar.MINUTE);
            
 ###通过拼接显示
       showDate_Time.setText(new StringBuffer().append(my_Year).append("/")
                     .append(FormatString(my_Month + 1)).append("/")
                     .append(FormatString(my_Day)).append(" ")
                     .append(FormatString(my_Hour)).append(" : ")
                     .append(FormatString(my_Minute)));
                     
![图片]()