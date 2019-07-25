package com.ikeguang.monitor.mysql.web;

import com.ikeguang.monitor.mysql.model.MonitorTable;
import com.ikeguang.monitor.mysql.service.MonitorTableService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ Author: keguang
 * @ Date: 2019/7/25 11:36
 * @ version: v1.0.0
 * @ description:
 */
@Controller
public class MonitorTableController {

    @Resource
    MonitorTableService monitorTableService;

    @RequestMapping("/")
    public String index(){
        return "redirect:/list";
    }

    @RequestMapping("/list")
    public String list(Model model){
        List<MonitorTable>  monitorTables = monitorTableService.getMonitorTableList();
        model.addAttribute("monitorTables", monitorTables);
        return "monitorTable/list";
    }

    @RequestMapping("/add")
    public String add(){
        return "monitorTable/add";
    }

    @RequestMapping("/addSubmit")
    public String addSubmit(MonitorTable monitorTable){
        System.out.println(monitorTable.toString());
        monitorTableService.save(monitorTable);
        return "redirect:/list";
    }

    @RequestMapping("/edit")
    public String edit(Model model, long id){
        MonitorTable monitorTable = monitorTableService.findMonitorTableById(id);
        model.addAttribute("monitorTable", monitorTable);
        return "monitorTable/edit";
    }

    @RequestMapping("/editSubmit")
    public String editSubmit(MonitorTable monitorTable){
        monitorTableService.edit(monitorTable);
        return "redirect:/list";
    }

    @RequestMapping("/delete")
    public String delete(long id){
        monitorTableService.deleteById(id);
        return "redirect:/list";
    }
}
