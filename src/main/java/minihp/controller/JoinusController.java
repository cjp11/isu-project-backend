package minihp.controller;

import minihp.data.dto.MemberDto;
import minihp.data.dto.ResponseData;
import minihp.data.entity.Member;
import minihp.service.JoinusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JoinusController {

    @Autowired
    private JoinusService joinusService;

    @PostMapping("/isu/join/create")
    public ResponseEntity<ResponseData> joinusComplete(
            Model model, @ModelAttribute("data") Member member ){

        ResponseData responseData = this.joinusService.joinusCreate(member);

        return dataPush(responseData);
    }



    public ResponseEntity<ResponseData> dataPush(ResponseData responseData) {

        List<MemberDto> dto = new ArrayList<>();

        return ResponseEntity.ok(
                ResponseData.builder()
                        .status(responseData.getStatus())
                        .message(responseData.getMessage())
                        .data(responseData.getData())
                        .build()
        );
    }

}
