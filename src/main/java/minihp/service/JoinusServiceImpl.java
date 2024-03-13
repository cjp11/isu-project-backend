package minihp.service;

import jakarta.transaction.Transactional;
import minihp.data.dto.ResponseData;
import minihp.data.entity.Member;
import minihp.repository.MemberRepository;
import minihp.utils.CommonUtils;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class JoinusServiceImpl implements JoinusService {

    private MemberRepository memberRepository;
    private CommonUtils commonUtils;
    private ResponseData responseData;

    /*회원가입 완료*/
    @Override
    @Transactional
    public ResponseData joinusCreate(Member member){

        String message = null;
        Boolean resultSuccess = true;
        String password =null;
        int code = 200;

        //이메일 중복체크
        if(!member.getEmail().isEmpty()){
            Member memberResult = memberRepository.findByEmail(member.getEmail());

            if(!memberResult.getEmail().isEmpty()){
                resultSuccess = false;
                message = "MEM_LOGINID_DUP";
            }
        }

        //비밀번호 암호화
        //1차(md)
        password = commonUtils.encryptByMd5(member.getPassword());
        //2차(sh)
        password = commonUtils.sha256(password);

        member.setPassword(password);

        Member memberInfo = memberRepository.save(member);

        if(memberInfo != null){
            message = "Success";
            resultSuccess = true;
        }

        code = message =="Success" ? 200 : 500;

        responseData.setData(memberInfo);
        responseData.setMessage(message);
        responseData.setStatus(code);


        return responseData;
    }



}
