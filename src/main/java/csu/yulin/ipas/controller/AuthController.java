package csu.yulin.ipas.controller;

import csu.yulin.ipas.common.ResponseResult;
import csu.yulin.ipas.dto.LoginRequest;
import csu.yulin.ipas.repository.UserRepository;
import csu.yulin.ipas.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lp
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/test")
    public ResponseResult<String> test(@RequestHeader("Authorization") String authHeader) {
        String token = authHeader.substring(7);
        String phone = jwtUtil.extractPhoneNumber(token);
        return ResponseResult.success("登录成功，用户手机号: " + phone);
    }

    @PostMapping("/login")
    public ResponseResult<String> login(@RequestBody LoginRequest request) {
        return userRepository.findByPhoneNumber(request.getPhoneNumber())
                .filter(user -> user.getPassword().equals(request.getPassword()))
                .map(user -> ResponseResult.success(jwtUtil.generateToken(user.getPhoneNumber())))
                .orElse(ResponseResult.error(401, "手机号或密码错误"));
    }
}