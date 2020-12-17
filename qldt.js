// ==UserScript==
// @name         Boost access into QLDT PTIT Script
// @namespace    http://annanjin.me/
// @version      0.1
// @description  Autofill capcha and directly redirect to registering page
// @author       Annanjin
// @match        http://qldt.ptit.edu.vn/*
// @grant        none
// ==/UserScript==

(function() {
    'use strict';

    // Your code here...
    var capchaInput = document.getElementById("ctl00_ContentPlaceHolder1_ctl00_txtCaptcha");
    if (capchaInput != null && capchaInput != undefined && capchaInput.value == "") {
        var capchaText = document.getElementById("ctl00_ContentPlaceHolder1_ctl00_lblCapcha").innerHTML;
        capchaInput.value = capchaText;
        var capchaBtn = document.getElementById("ctl00_ContentPlaceHolder1_ctl00_btnXacNhan");
        capchaBtn.click();
    }

    var greeting = document.getElementById("ctl00_Header1_ucLogout_lblNguoiDung").innerHTML;
    if(greeting != null && greeting != undefined && greeting == "Chào bạn  Đỗ Đình Nhất (B16DCCN258)"){ // giữa chữ bạn với đỗ có 2 dấu cách là đúng
        var url = window.location.href;
        if(url != "http://qldt.ptit.edu.vn/Default.aspx?page=dkmonhoc"){
            window.location.href="http://qldt.ptit.edu.vn/Default.aspx?page=dkmonhoc";
        }
    }

    var MMH_Input = document.getElementById("txtMaMH1");
    if(MMH_Input != null && MMH_Input != undefined && MMH_Input.value == ""){
        MMH_Input.value = "BAS1143";
        var searchBtn = document.getElementById("btnLocTheoMaMH1");
        searchBtn.click();
    }
})();
