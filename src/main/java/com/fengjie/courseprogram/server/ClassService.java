package com.fengjie.courseprogram.server;

import com.fengjie.courseprogram.model.entity.Class;
import com.fengjie.courseprogram.mybatis.dao.ClassDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;

import java.util.List;

/**
 * @author fengjie
 * @date 2019/5/6 14:28
 */
@Service
public class ClassService {

    @Autowired
    private ClassDao classDao;

    @Autowired
    private StudentService studentService;

    public List<Class> getClassesByCourseId(String courseId) {
        Class c = new Class();
        c.setCourseId(courseId);
        return classDao.select(c);
    }

    public Class getClassById(String classId) {
        return classDao.selectByPrimaryKey(classId);
    }

    public int updateClassById(Class c) {
        if (StringUtils.isEmpty(c.getId())) {
            throw new RuntimeException("未填写id");
        }
        return classDao.updateByPrimaryKeySelective(c);
    }

    @Transactional(rollbackFor = Exception.class)
    public int deleteClass(String classId){
        int i = classDao.deleteByPrimaryKey(classId);
        studentService.deleteStudentsByClassId(classId);
        return i;
    }

}
