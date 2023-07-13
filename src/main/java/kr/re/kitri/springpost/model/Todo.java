package kr.re.kitri.springpost.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Todo {
    // 값이 누락되지 않게 하려면 db의 필드명과 동일하게 멤버변수를 선언해줘야 한다.
    private long todoId;
    private String title;
    private boolean completed;
    // 나머지 보일러 플레이트 필드를 깔아줘야 됨. 코틀린은 data class 라고 하면 보일러 플레이트를 자동으로 깔아준다.
    // java에서 이런 일을 해주는 라이브러리가 lombok(3rd 파티인데 스프링이 지원함)이다.
}
