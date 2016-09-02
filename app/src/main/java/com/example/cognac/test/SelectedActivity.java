package com.example.cognac.test;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SelectedActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    LoginActivity loginActivity = new LoginActivity();
    DatabaseHelper helper = new DatabaseHelper(this);
    private ArrayList<String> moduleCodeArraylist = new ArrayList<>();

    String[] test;
    private SimpleAdapter simpleAdapter;
    private List<Map<String, Object>> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected);

        new AlertDialog.Builder(SelectedActivity.this).setTitle("Tip")//设置对话框标题

                .setMessage("Click a Module to delete it！")//设置显示的内容

                .setPositiveButton("OK",new DialogInterface.OnClickListener() {//添加确定按钮

                            @Override

                            public void onClick(DialogInterface dialog, int which) {//确定按钮的响应事件

                            }
                        }

                ).setPositiveButton("OK",new DialogInterface.OnClickListener() {//添加返回按钮
            @Override

            public void onClick(DialogInterface dialog, int which) {//响应事件

                // TODO Auto-generated method stub

                Log.i("alertdialog"," 请保存数据！");

            }

        }).show();//在按键响应事件中显示此对话框


        TextView textView = (TextView) findViewById(R.id.SelectedModule);
        //textView.setText("Username:");

        ListView listView = (ListView) findViewById(R.id.SelectedlistView);

        String selectedModuleStr = helper.searchSelectedModule(loginActivity.Username);

        for(int i=0; i < selectedModuleStr.length()/8; i++){

            String newString = selectedModuleStr.substring(i*8, (i+1)*8);

            moduleCodeArraylist.add(newString);
        }

        for(Iterator<String> testIterator = moduleCodeArraylist.iterator(); testIterator.hasNext();) {
            Log.i("elemets", testIterator.next());
        }

        final String[] ModulesName = new String[moduleCodeArraylist.size()];
        String[] ModulesLevel = new String[moduleCodeArraylist.size()];
        String[] ModulesSemester = new String[moduleCodeArraylist.size()];


        for (int i = 0; i < moduleCodeArraylist.size(); i++) {

            ModulesName[i]= helper.searchSelectedNameByCode(moduleCodeArraylist.get(i));
            ModulesLevel[i]= helper.searchSelectedLevelByCode(moduleCodeArraylist.get(i));
            ModulesSemester[i] = helper.searchSelectedSemesterByCode(moduleCodeArraylist.get(i));

        }
        final String[] ModulesCode = new String[moduleCodeArraylist.size()];
        for (int i = 0; i < moduleCodeArraylist.size(); i++) {

            ModulesCode[i] = moduleCodeArraylist.get(i);
        }


        int c = ModulesName.length;
        Log.i("fdsf4321314f", String.valueOf(c));

        dataList = new ArrayList<Map<String, Object>>();


        simpleAdapter = new SimpleAdapter(this, getData(ModulesName,ModulesLevel, ModulesCode,ModulesSemester), R.layout.newitem, new String[]{"txt","txtcode","txtlevel","txtsemester"}, new int[]{R.id.Name,R.id.Code,R.id.Level,R.id.Semester});
        listView.setAdapter(simpleAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast p = Toast.makeText(SelectedActivity.this, "You have already Delete " + ModulesName[i], Toast.LENGTH_SHORT);
                p.show();

                helper.deleteSelectedModules(ModulesCode[i]);

            }
        });


    }


    private List<Map<String, Object>> getData(String[] ModulesName,String[] ModulesLevel,String []ModulesCode,String []ModulesSemester) {

        for (int i = 0; i < ModulesName.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            //map.put("pic", R.mipmap.ic_launcher);
            map.put("txt", ModulesName[i]);
            map.put("txtlevel",ModulesLevel[i]);
            map.put("txtcode",ModulesCode[i]);
            map.put("txtsemester",ModulesSemester[i]);
            dataList.add(map);
        }
        return dataList;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {



    }
}
