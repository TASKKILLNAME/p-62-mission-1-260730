package com.back.practicejsb.domain.post.question.form;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/*
    처음엔 QuestionForm도 엔티티의 성향이 있다고 판단하여
    Setter 사용을 피했지만, 폼에 제목 또는 내용만 입력하고
    저장하기를 누를 시에 내가 입력한 데이터가
    QuestionForm이 저장하지 못해날아가는 문제가 생김
    -> @Setter를 사용하여 해결
 */
public class QuestionForm {

    @NotEmpty(message = "제목은 필수항목입니다.")
    @Size(max=200)
    private String subject;

    @NotEmpty(message = "내용은 필수항목입니다.")
    private String content;
}
