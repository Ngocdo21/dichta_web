package com.example.demospring1.login.controller;

import com.example.demospring1.login.model.enity.User;
import com.example.demospring1.login.repository.database.UserDB;
import com.example.demospring1.login.service.UserService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserDB userDB;

    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/register")
    public String DangKy(Model model) {
        model.addAttribute("user", new User());
        return "signup_Form";
    }

    @GetMapping("/login")
    public String backToLogin(Model model) {
        model.addAttribute("user", new User());
        return "login_Form";
    }

    @PostMapping("/process_register")
    public String processRegistration(User user) {
        userDB.save(user);
        return "register_success";
    }

    @PostMapping("/process_login")
    public String processLogin(
            User user,
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "password", required = false) String password,
            Model model
    ) throws NotFoundException{
        model.addAttribute("username", user.getUsername());
        model.addAttribute("password", user.getPassword());

        User user2 = userService.findUser(username, password);
//        model.addAttribute("user",user2);
//        model.addAttribute("existMatch", user2 == null ?"Sai tên đăng nhập hoặc mật khẩu" : "Đăng nhập thành công");
        if (user2 == null) {
//            throw new NotFoundException("Sai tên đăng nhập hoặc mật khẩu");
//            return "login_not_success";
            model.addAttribute("loginResult", "Sai tên đăng nhập hoặc mật khẩu");
            return "login_Result";
        }
        model.addAttribute("loginResult", "Đăng nhập thành công");
        return "login_Result";
    }


//    @GetMapping("/dangnhaphethong")
//    public String LoginClient(){
//        return "login";
//    }

    //    @RequestMapping("/alluser")
//    public ResponseEntity<BaseResponse<UserResponse>> findAllUser() {
//        List<User> users = userService.findAllUser();
//        BaseResponse<UserResponse> baseResponse = new BaseResponse<>();
//        baseResponse.setCode(1);
//        baseResponse.setMessage("success");
//        baseResponse.setData(UserResponse.builder()
//                .user(users)
//                .build());
//        return ResponseEntity.ok(baseResponse);
//    }
//
//    @PostMapping(value = "/login")
//    public ResponseEntity<BaseResponse<UserResponse>> findbyID(
////            @PathVariable("id") int id
//            @RequestParam(value = "username") String username,
//            @RequestParam(value = "password") String password
//    ) {
//        User user = userService.findUser(username, password);
//        BaseResponse<UserResponse> baseResponse = new BaseResponse<>();
//        if (user != null) {
//            baseResponse.setCode(1);
//            baseResponse.setMessage("success");
//            baseResponse.setData(UserResponse.builder()
//                    .user(Arrays.asList(user))
//                    .build());
//            System.out.println("đang nhập thành công");
//            return ResponseEntity.ok(baseResponse);
//        }
//        System.out.println("đang nhập k thành công");
//        baseResponse.setCode(0);
//        baseResponse.setMessage("sai thông tin đăng nhập hoặc mật khẩu");
//        return ResponseEntity.badRequest().body(baseResponse);
//    }


//    @RequestMapping("/sign-up1")
//    public ResponseEntity<BaseResponse<UserResponse>> InsertNewUser(
//            @RequestParam(value = "username") String username,
//            @RequestParam(value = "password") String password
//    ) {
//        User user = userService.createUser();
//        BaseResponse<UserResponse> baseResponse = new BaseResponse<>();
//        baseResponse.setCode(1);
//        baseResponse.setMessage("success");
//        baseResponse.setData(UserResponse.builder()
//                .user(Arrays.asList(user))
//                .build());
//        System.out.println("tạo tài khoản thành công");
//        return ResponseEntity.ok(baseResponse);
//    }

//    @PostMapping("/sign-up")
//    public ResponseEntity<BaseResponse<UserCreateResponse>> createUser(
//            @RequestBody UserCreateRequest userCreateRequest,
//            @RequestParam(value = "username") String username,
//            @RequestParam(value = "password") String password) {
//        User user = userService.findUser(username, password);
//        BaseResponse<UserResponse> baseResponse = new BaseResponse();
//        int id = userService.createUser(userCreateRequest);
//        if (id > 0) {
//            baseResponse.setCode(1);
//            baseResponse.setMessage("success");
//            System.out.println("ok");
//        } else {
//            baseResponse.setCode(0);
//            baseResponse.setMessage("can not create new user");
//            System.out.println("not ok");
//        }
//        return ResponseEntity.ok( new BaseResponse<>());
//    }
}

