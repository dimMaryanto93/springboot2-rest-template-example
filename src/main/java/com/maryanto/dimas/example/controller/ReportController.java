package com.maryanto.dimas.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app/report/")
public class ReportController {

    @GetMapping("/sign")
    public String getReportHtml() {
        return "report/sign";
    }
}
