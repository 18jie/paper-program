package com.fengjie.courseprogram.model.queryvo;

import com.fengjie.courseprogram.model.entity.CourseQuestion;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author fengjie
 * @date 2019:05:12
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CourseQuestionOperationVO extends CourseQuestion implements Comparable<CourseQuestionOperationVO> {

    private Integer operationNo;

    private Integer singleGrade;

    private Boolean answered;

    private String submitAnswer;

    private Integer currentGrade;

    private String answerStatus;

    @Override
    public int compareTo(CourseQuestionOperationVO o) {
        if (this.getOperationNo() > o.getOperationNo()) {
            return 1;
        } else if (this.getOperationNo() < o.getOperationNo()) {
            return -1;
        }
        return 0;
    }
}
