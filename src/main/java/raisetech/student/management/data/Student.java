package raisetech.student.management.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Student {


  private String id;
  private String fullName; //name
  private String furigana; //kanaName
  private String nickname;
  private String email;
  private String region; //area
  private int age;
  private String gender; //sex
  private String remark;
  private boolean isDeleted;
}
