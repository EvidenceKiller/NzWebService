package com.adl.service.v3interface.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;


/**
 * Name : GradeTreeData
 * Author : zhouxiangnan
 * Date : 2026/4/7
 * Describe : 定义接口响应数据结构
 */
public final class GradeTreeData {
    /**
     * 年级ID
    */
    @SerializedName("id")
    private String id;

    /**
     * 入学年份 入学年份 入学时间（2019）
    */
    @SerializedName("enterYear")
    private int enterYear;

    /**
     * 毕业年份 毕业年份 毕业时间（2020）
    */
    @SerializedName("graduationYear")
    private int graduationYear;

    /**
     * 年级编码 org_code_enter_year
    */
    @SerializedName("gradeCode")
    private String gradeCode;

    /**
     * 年级名称
    */
    @SerializedName("gradeName")
    private String gradeName;

    /**
     * 部门编码 多个用-隔开
    */
    @SerializedName("departmentCodes")
    private String departmentCodes;

    /**
     * 是否毕业 参考字典编码：adl_tis_graduation_flag（1 毕业 0 未毕业）
    */
    @SerializedName("graduationFlag")
    private int graduationFlag;

    /**
     * 班级列表
    */
    @SerializedName("classList")
    private List<GradeClassList> classList;

    /**
     * 年级序号（根据当前学段）
    */
    @SerializedName("gradeNumByStage")
    private int gradeNumByStage;

    /**
     * 年级序号（总年级编号）
    */
    @SerializedName("gradeNum")
    private int gradeNum;

    /**
     * 学段代码
    */
    @SerializedName("secCode")
    private String secCode;

    /**
     * 学段序号
    */
    @SerializedName("stageType")
    private String stageType;

    /**
     * 年级中文名称
    */
    @SerializedName("gradeChineseName")
    private String gradeChineseName;

    /**
     * 学段年级中文名称
    */
    @SerializedName("gradeStageChineseName")
    private String gradeStageChineseName;

    public String getId() {
        return id;
    }

    public int getEnterYear() {
        return enterYear;
    }

    public int getGraduationYear() {
        return graduationYear;
    }

    public String getGradeCode() {
        return gradeCode;
    }

    public String getGradeName() {
        return gradeName;
    }

    public String getDepartmentCodes() {
        return departmentCodes;
    }

    public int getGraduationFlag() {
        return graduationFlag;
    }

    public List<GradeClassList> getClassList() {
        return classList;
    }

    public int getGradeNumByStage() {
        return gradeNumByStage;
    }

    public int getGradeNum() {
        return gradeNum;
    }

    public String getSecCode() {
        return secCode;
    }

    public String getStageType() {
        return stageType;
    }

    public String getGradeChineseName() {
        return gradeChineseName;
    }

    public String getGradeStageChineseName() {
        return gradeStageChineseName;
    }

    public class GradeClassList {
        /**
         * 班级全称 班级全称 小学一年级一班
        */
        @SerializedName("classFullName")
        private String classFullName;

        /**
         * 班级名称
        */
        @SerializedName("className")
        private String className;

        /**
         * 班级代码 1 2 3 4 5
        */
        @SerializedName("classNum")
        private int classNum;

        /**
         * 创建时间
        */
        @SerializedName("createTime")
        private String createTime;

        /**
         * 专业代码 （高校）
        */
        @SerializedName("departmentCode")
        private String departmentCode;

        /**
         * 年级编码
        */
        @SerializedName("gradeCode")
        private String gradeCode;

        /**
         * 班级id
        */
        @SerializedName("id")
        private String id;

        /**
         * 机构id
        */
        @SerializedName("orgId")
        private String orgId;

        /**
         * 班级状态 1. 进行中 2. 未开学 3. 已毕业
        */
        @SerializedName("status")
        private int status;

        /**
         * 租户id
        */
        @SerializedName("tenantId")
        private String tenantId;

        /**
         * 更新时间
        */
        @SerializedName("updateTime")
        private String updateTime;

        /**
         * 学段年级中文名称
        */
        @SerializedName("gradeStageChineseName")
        private String gradeStageChineseName;

        /**
         *
        */
        @SerializedName("platformClassId")
        private String platformClassId;

        /**
         * 学院代码
        */
        @SerializedName("collegeCode")
        private String collegeCode;

        /**
         * 学院ID
        */
        @SerializedName("collegeId")
        private String collegeId;

        /**
         * 学院名称
        */
        @SerializedName("collegeName")
        private String collegeName;

        /**
         * 院系代码
        */
        @SerializedName("facultyCode")
        private String facultyCode;

        /**
         * 院系ID
        */
        @SerializedName("facultyId")
        private String facultyId;

        /**
         * 院系名称
        */
        @SerializedName("facultyName")
        private String facultyName;

        /**
         * 专业代码
        */
        @SerializedName("majorCode")
        private String majorCode;

        /**
         * 专业ID
        */
        @SerializedName("majorId")
        private String majorId;

        /**
         * 专业名称
        */
        @SerializedName("majorName")
        private String majorName;

        public String getClassFullName() {
            return classFullName;
        }

        public String getClassName() {
            return className;
        }

        public int getClassNum() {
            return classNum;
        }

        public String getCreateTime() {
            return createTime;
        }

        public String getDepartmentCode() {
            return departmentCode;
        }

        public String getGradeCode() {
            return gradeCode;
        }

        public String getId() {
            return id;
        }

        public String getOrgId() {
            return orgId;
        }

        public int getStatus() {
            return status;
        }

        public String getTenantId() {
            return tenantId;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public String getGradeStageChineseName() {
            return gradeStageChineseName;
        }

        public String getPlatformClassId() {
            return platformClassId;
        }

        public String getCollegeCode() {
            return collegeCode;
        }

        public String getCollegeId() {
            return collegeId;
        }

        public String getCollegeName() {
            return collegeName;
        }

        public String getFacultyCode() {
            return facultyCode;
        }

        public String getFacultyId() {
            return facultyId;
        }

        public String getFacultyName() {
            return facultyName;
        }

        public String getMajorCode() {
            return majorCode;
        }

        public String getMajorId() {
            return majorId;
        }

        public String getMajorName() {
            return majorName;
        }
    }
}