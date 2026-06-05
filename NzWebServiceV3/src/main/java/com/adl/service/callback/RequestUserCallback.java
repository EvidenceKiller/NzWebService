package com.adl.service.callback;

import android.content.Context;

import com.adl.service.data.StudentData;
import com.adl.service.data.TeacherData;

import java.util.List;

/**
 * ProjectName: AiPowerAuth
 * Author     : 南山
 * Date       : 2024/7/1
 * Describe   : 请求回答
 */
public abstract class RequestUserCallback extends RequestLoadingCallback {

    public RequestUserCallback(Context context) {
        super(context);
    }

    public RequestUserCallback(Context context, boolean showDialog) {
        super(context);
        showDialog(showDialog);
    }

    // 同步信息过程中，分步处理
    public abstract void nextStatus(int status, String msg);

    //  组织发生变化
    public void orgChange(String newOrgId, String oldOrgId) {
    }

    //  更新学生数据
    public void updateStudent(List<StudentData> updateData, List<StudentData> deleteData) {
    }

    //  更新老师数据
    public void updateTeacher(List<TeacherData> updateData, List<TeacherData> deleteData) {
    }
}
