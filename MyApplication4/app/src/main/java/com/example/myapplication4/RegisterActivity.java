package com.example.myapplication4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication4.bean.UserInfo;
import com.example.myapplication4.database.UserDBHelper;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{
    private UserDBHelper mHelper; // 声明一个用户数据库帮助器的对象
    private EditText id_phone;//姓名
    private EditText id_password;//手机号
    private EditText id_name;//密码
    private Button btn_register;//注册
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        id_phone = findViewById(R.id.id_phone);
        id_password = findViewById(R.id.id_password);
        id_name=findViewById(R.id.id_name);
        btn_register=findViewById(R.id.btn_register);

        btn_register.setOnClickListener(this);
    }

    private void showToast(String desc) {
        Toast.makeText(this, desc, Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_register){
            UserInfo infocheck = mHelper.queryByPhone(id_phone.getText().toString());
            if (infocheck != null) {
                Toast.makeText(this, "该账户存在", Toast.LENGTH_SHORT).show();
                return;
            }
            String name=id_name.getText().toString();
            String phone = id_phone.getText().toString();
            String password =id_password.getText().toString();
            UserInfo info = new UserInfo();
            info.name=name;
            info.phone = phone;
            info.pwd = password;
            if (TextUtils.isEmpty(name)) {
                showToast("请先填写姓名");
                return;
            } else if (TextUtils.isEmpty(phone)) {
                showToast("请先填写手机号");
                return;
            } else if (TextUtils.isEmpty(password)) {
                showToast("请先填写密码");
                return;
            }
            if (phone.length() < 11) { // 手机号码不足11位
                Toast.makeText(this, "请输入正确的手机号", Toast.LENGTH_SHORT).show();
                return;
            }
            if (password.length() < 8) { //密码需要6位
                Toast.makeText(this, "请输入6位密码", Toast.LENGTH_SHORT).show();
                return;
            }
            Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
            // 执行数据库帮助器的插入操作
            mHelper.insert(info);

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        // 获得用户数据库帮助器的一个实例
        mHelper = UserDBHelper.getInstance(this, 2);
        // 恢复页面，则打开数据库连接
        mHelper.openWriteLink();
    }
    @Override
    protected void onPause() {
        super.onPause();
        // 暂停页面，则关闭数据库连接
        mHelper.closeLink();
    }
}