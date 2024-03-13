package minihp.data.dto;


import lombok.*;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class MemberDto {

    int member_id;

    String email;

    String password;

    String name;

    String register_type;

    Date birth_date;

    String gender;

    String address;

    String delete_yn;

}
