package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.ZipCodeDto;
import com.example.demo.request.ZipCodeRequest;
import com.example.demo.service.ZipCodeService;

@Controller
public class UserAddController {

    @Autowired
    ZipCodeService zpcService;

    /**
     * 郵便番号入力フォーム
     * @return "useradd"
     */
    @RequestMapping(value = "/useradd")
    public String zipcodeForm(HttpSession session, Model model) {
        return "useradd";
    }

    /**
     * 利用規約
     * @return "agree-team"
     */
    @RequestMapping(value = "/agreeteam")
    public String agreeTeamPage(HttpSession session, Model model) {
        return "agree-team";
    }

    /**
     * 郵便番号から住所を取得する
     * @return "zipcode"
     */
    @RequestMapping(value="/useradd/zipcode", method=RequestMethod.POST)
    public String zipcodeConfirm(@Validated @ModelAttribute ZipCodeRequest zipCodeRequest,
    		BindingResult result, Model model, @RequestParam("zipcode") String zipcode){

    	if (result.hasErrors()) {

			// 入力チェックエラーの場合
			List<String> errorList = new ArrayList<String>();

			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("validationError", errorList);

			return "useradd";
		}

        // 郵便番号検索APIサービス呼び出し
        ZipCodeDto zipCodeDto = zpcService.service(zipcode);

        // thymeleafでリストを展開して表示する
        model.addAttribute("zipcodeList", zipCodeDto.getResults());

        return "useradd";
    }

//    /**
//     * 郵便番号情報表示
//     * @return "zipcode"
//     */
//    @RequestMapping(value="/useradd/zipcode", method=RequestMethod.POST)
//    public String zipcodeConfirm(@Validated @ModelAttribute UserAddRequest userAddRequest,
//    		BindingResult result, Model model, @RequestParam("zipcode") String zipcode){
//
//    	if (result.hasErrors()) {
//
//			// 入力チェックエラーの場合
//			List<String> errorList = new ArrayList<String>();
//
//			for (ObjectError error : result.getAllErrors()) {
//				errorList.add(error.getDefaultMessage());
//			}
//			model.addAttribute("validationError", errorList);
//
//			return "useradd";
//		}
//
//        // 郵便番号検索APIサービス呼び出し
//        ZipCodeDto zipCodeDto = zpcService.service(zipcode);
//
//        // thymeleafでリストを展開して表示する
//        model.addAttribute("zipcodeList", zipCodeDto.getResults());
//
//        return "zipcode";
//    }

}
