package minihp.service;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import minihp.data.dto.MemberDto;
import minihp.data.dto.ResponseData;
import minihp.data.entity.Member;
import minihp.repository.MemberRepository;
import minihp.utils.CommonUtils;
import org.springframework.http.ResponseEntity;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public interface JoinusService {

    /*회원가입 완료*/
    @Transactional
   ResponseData joinusCreate(Member member);
}
